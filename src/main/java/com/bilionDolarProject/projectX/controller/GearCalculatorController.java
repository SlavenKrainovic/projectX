package com.bilionDolarProject.projectX.controller;
import com.bilionDolarProject.projectX.GearRatioCalculator;
import com.bilionDolarProject.projectX.WheelSizeCalculator;
import com.bilionDolarProject.projectX.WheelSpeedsCalculator;
import com.bilionDolarProject.projectX.entity.Gearbox;
import com.bilionDolarProject.projectX.entity.WheelSize;
import com.bilionDolarProject.projectX.service.GearSpeedsService;
import com.bilionDolarProject.projectX.service.GearboxService;
import com.bilionDolarProject.projectX.service.MapVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GearCalculatorController {
    private final GearboxService gearboxService;

    @Autowired
    public GearCalculatorController(GearboxService gearboxService) {
        this.gearboxService = gearboxService;
    }


    @PostMapping("/gearbox")
    public GearsSpeeds gearsSpeeds(@RequestBody Vehicle vehicle) {
        GearSpeedsService gearSpeedsService = new GearSpeedsService();
        GearsSpeeds gearsSpeeds2 = gearSpeedsService.gearsSpeedsService(vehicle);
        return gearsSpeeds2;


    }
    @GetMapping("getAllgearbox")
    public List<Gearbox> getGearbox(){
        return gearboxService.getGearbox();
    }


}