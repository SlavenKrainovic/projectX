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
    public List<Map<String, Map<String, Double>>> calculateSpeeds(@RequestBody Vehicle vehicle) {
        GearSpeedsService gearSpeedsService = new GearSpeedsService();
        List<Map<String, Map<String, Double>>> gearSpeedsList = new ArrayList<>();
        int baseRpm = vehicle.getMaxRpm();
        for (int rpm = 50; rpm <= baseRpm; rpm += 50) {
            vehicle.setMaxRpm(rpm);
            GearsSpeeds gearsSpeeds = gearSpeedsService.gearsSpeedsService(vehicle);
            Map<String, Double> gearsSpeedsMap = new HashMap<>();
            gearsSpeedsMap.put("gearSpeed1", gearsSpeeds.getGearSpeed1());
            gearsSpeedsMap.put("gearSpeed2", gearsSpeeds.getGearSpeed2());
            gearsSpeedsMap.put("gearSpeed3", gearsSpeeds.getGearSpeed3());
            gearsSpeedsMap.put("gearSpeed4", gearsSpeeds.getGearSpeed4());
            gearsSpeedsMap.put("gearSpeed5", gearsSpeeds.getGearSpeed5());
            gearsSpeedsMap.put("gearSpeed6", gearsSpeeds.getGearSpeed6());

            Map<String, Map<String, Double>> gearSpeedsWrapper = new HashMap<>();
            gearSpeedsWrapper.put("rpm " + rpm, gearsSpeedsMap);
            gearSpeedsList.add(gearSpeedsWrapper);
        }

        gearSpeedsList.sort(Comparator.comparingInt(map -> Integer.parseInt(map.keySet().iterator().next().split(" ")[1])));

        return gearSpeedsList;
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




