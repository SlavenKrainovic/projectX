package com.bilionDolarProject.projectX.controller;
import com.bilionDolarProject.projectX.entity.PreSetGearbox;
import com.bilionDolarProject.projectX.service.GearSpeedsService;

import com.bilionDolarProject.projectX.service.PreSetGearboxService;
import org.springframework.web.bind.annotation.*;


@RestController
public class GearCalculatorController {






    @PostMapping("/gearbox")
    public GearsSpeeds gearsSpeeds(@RequestBody Vehicle vehicle) {
        GearSpeedsService gearSpeedsService = new GearSpeedsService();
        GearsSpeeds gearsSpeeds2 = gearSpeedsService.gearsSpeedsService(vehicle);
        return gearsSpeeds2;


    }


    @PostMapping("/saveGearbox")
    public void PreSetGearboxService (@RequestBody PreSetGearbox preSetGearbox){
        PreSetGearboxService.addNewPreSetGearbox(preSetGearbox);


    }

}