package com.bilionDolarProject.projectX.controller;
import com.bilionDolarProject.projectX.entity.PreSetGearbox;
import com.bilionDolarProject.projectX.entity.PreSetGearboxResponse;
import com.bilionDolarProject.projectX.service.GearSpeedsService;

import com.bilionDolarProject.projectX.service.MapPreSetGearboxResponse;
import com.bilionDolarProject.projectX.service.PreSetGearboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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
    public List<GearsSpeeds> calculateSpeeds(@RequestBody Vehicle vehicle) {
        GearSpeedsService gearSpeedsService = new GearSpeedsService();
        List<GearsSpeeds> gearsSpeedsList = new ArrayList<>();
        int baseRpm = vehicle.getMaxRpm();
        for (int rpm = 50; rpm <= baseRpm; rpm += 50) {
            vehicle.setMaxRpm(rpm);
            GearsSpeeds gearsSpeeds = gearSpeedsService.gearsSpeedsService(vehicle);
            gearsSpeedsList.add(gearsSpeeds);
        }
        return gearsSpeedsList;
        // Calculate the speeds and return array for all RPM from 50 to max RPM
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




