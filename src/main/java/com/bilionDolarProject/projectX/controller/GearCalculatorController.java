package com.bilionDolarProject.projectX.controller;
import com.bilionDolarProject.projectX.service.GearSpeedsService;

import com.bilionDolarProject.projectX.controller.repo.PreSetGearboxRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;


@RestController
public class GearCalculatorController {






    @PostMapping("/gearbox")
    public GearsSpeeds gearsSpeeds(@RequestBody Vehicle vehicle) {
        GearSpeedsService gearSpeedsService = new GearSpeedsService();
        GearsSpeeds gearsSpeeds2 = gearSpeedsService.gearsSpeedsService(vehicle);
        return gearsSpeeds2;


    }

    @Bean
    @PostMapping("/saveGearbox")
    CommandLineRunner commandLineRunner(PreSetGearboxRepository preSetGearboxRepository) {
        return args -> {

            preSetGearboxRepository.findAll();

        };
    }

}