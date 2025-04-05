package com.bilionDolarProject.projectX.controller;

import com.bilionDolarProject.projectX.entity.PreSetGearbox;
import com.bilionDolarProject.projectX.service.PreSetGearboxService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gearbox")
public class PreSetGearboxController {

    private final PreSetGearboxService preSetGearboxService;

    public PreSetGearboxController(PreSetGearboxService preSetGearboxService) {
        this.preSetGearboxService = preSetGearboxService;
    }

    @GetMapping("/brand/{carBrand}")
    public List<PreSetGearbox> getGearboxesByBrand(@PathVariable String carBrand) {
        return preSetGearboxService.getGearboxesByCarBrand(carBrand);
    }

    @GetMapping("/brands")
    public List<String> getAllCarBrands() {
        return preSetGearboxService.getAllCarBrands();
    }
}
