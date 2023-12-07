package com.bilionDolarProject.projectX.controller;
import com.bilionDolarProject.projectX.entity.PreSetGearbox;
import com.bilionDolarProject.projectX.entity.PreSetGearboxResponse;
import com.bilionDolarProject.projectX.service.GearSpeedsService;

import com.bilionDolarProject.projectX.service.MapPreSetGearboxResponse;
import com.bilionDolarProject.projectX.service.PreSetGearboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
public class GearCalculatorController {
    @Autowired
    private PreSetGearboxService preSetGearboxService;
    private PreSetGearboxResponse preSetGearboxResponse;
    private MapPreSetGearboxResponse mapPreSetGearboxResponse;
    private PreSetGearbox preSetGearbox;
    @PostMapping("/gearbox/calculateSpeed")
    public GearsSpeeds gearsSpeeds(@RequestBody Vehicle vehicle) {
        GearSpeedsService gearSpeedsService = new GearSpeedsService();
        GearsSpeeds gearsSpeeds2 = gearSpeedsService.gearsSpeedsService(vehicle);
        return gearsSpeeds2;
    //Calculate the speed and return seeds for only for max RPM

    }
    @PostMapping("/gearbox/calculateSpeeds")
    public Map<String, GearsSpeeds> calculateSpeeds(@RequestBody Vehicle vehicle) {
        GearSpeedsService gearSpeedsService = new GearSpeedsService();
        Map<String, GearsSpeeds> gearsSpeedsMap = new HashMap<>();
        int baseRpm = vehicle.getMaxRpm();
        for (int rpm = 50; rpm <= baseRpm; rpm += 50) {
            vehicle.setMaxRpm(rpm);
            GearsSpeeds gearsSpeeds = gearSpeedsService.gearsSpeedsService(vehicle);
            gearsSpeedsMap.put("rpm " + rpm, gearsSpeeds);
        }

        List<Map.Entry<String, GearsSpeeds>> list = new ArrayList<>(gearsSpeedsMap.entrySet());
        list.sort(Map.Entry.comparingByKey(Comparator.comparingInt(s -> Integer.parseInt(s.split(" ")[1]))));

        Map<String, GearsSpeeds> sortedGearsSpeedsMap = new LinkedHashMap<>();
        for (Map.Entry<String, GearsSpeeds> entry : list) {
            sortedGearsSpeedsMap.put(entry.getKey(), entry.getValue());
        }

        return sortedGearsSpeedsMap;
    }


    @PostMapping("/gearbox/save")
    public void SaveGearbox (@RequestBody PreSetGearbox preSetGearbox){
        preSetGearboxService.addNewPreSetGearbox(preSetGearbox);
    //Saves preset Gearboxes to base
    }

    @GetMapping("/gearbox/getAllList")
    public List<PreSetGearbox> GetAllGearboxes(){
        return preSetGearboxService.getPreSetGearbox();
    //return all gerboxes from base

    }
    @GetMapping("/gearbox/getById/{id}")
     public PreSetGearboxResponse getPreSetGearbox (@PathVariable Long id){
       PreSetGearbox gearbox =  preSetGearboxService.findPreSetGearboxById(id);
       MapPreSetGearboxResponse mapPreSetGearboxResponse = new MapPreSetGearboxResponse();
       PreSetGearboxResponse preSetGearboxResponse = mapPreSetGearboxResponse.preSetGearboxResponse(gearbox);
       return preSetGearboxResponse;
    //return gearboxes by id
    }
    @GetMapping("/gearbox/getAll")
    private List<PreSetGearboxResponse> listOfGearboxes(){
        int n = preSetGearboxService.getPreSetGearbox().size();
        MapPreSetGearboxResponse mapPreSetGearboxResponse = new MapPreSetGearboxResponse();
        PreSetGearbox gearbox = new PreSetGearbox();
        PreSetGearboxResponse preSetGearboxResponse = new PreSetGearboxResponse();
        Long b = 1L;
        List<PreSetGearboxResponse> listOfBoxes = new ArrayList<PreSetGearboxResponse>();
        for(int i = 0; i < n; i++){
            gearbox =  preSetGearboxService.findPreSetGearboxById(b);
            preSetGearboxResponse = mapPreSetGearboxResponse.preSetGearboxResponse(gearbox);
            b++;
            listOfBoxes.add(preSetGearboxResponse);
        }
        //return all gearboxes with all data
            return listOfBoxes;
        }




}




