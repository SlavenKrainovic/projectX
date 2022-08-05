package com.bilionDolarProject.projectX.controller;
import com.bilionDolarProject.projectX.entity.PreSetGearbox;
import com.bilionDolarProject.projectX.entity.PreSetGearboxResponse;
import com.bilionDolarProject.projectX.repo.PreSetGearboxRepository;
import com.bilionDolarProject.projectX.service.GearSpeedsService;

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


    @PostMapping("/gearbox")
    public GearsSpeeds gearsSpeeds(@RequestBody Vehicle vehicle) {
        GearSpeedsService gearSpeedsService = new GearSpeedsService();
        GearsSpeeds gearsSpeeds2 = gearSpeedsService.gearsSpeedsService(vehicle);
        return gearsSpeeds2;


    }


    @PostMapping("/saveGearbox")
    public void SaveGearbox (@RequestBody PreSetGearbox preSetGearbox){
        preSetGearboxService.addNewPreSetGearbox(preSetGearbox);

    }

    @GetMapping("/getGearboxes")

    public List<PreSetGearbox> GetAllGearboxes(){
        return preSetGearboxService.getPreSetGearbox();
    }

}