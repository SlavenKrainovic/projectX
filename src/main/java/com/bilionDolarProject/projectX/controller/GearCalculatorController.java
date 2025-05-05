package com.bilionDolarProject.projectX.controller;

import com.bilionDolarProject.projectX.dto.PreSetGearboxDTO;
import com.bilionDolarProject.projectX.dto.VehicleDTO;
import com.bilionDolarProject.projectX.entity.GearsSpeeds;
import com.bilionDolarProject.projectX.entity.PreSetGearbox;
import com.bilionDolarProject.projectX.entity.PreSetGearboxResponse;
import com.bilionDolarProject.projectX.entity.Vehicle;
import com.bilionDolarProject.projectX.service.GearSpeedsService;
import com.bilionDolarProject.projectX.service.MapPreSetGearboxResponse;
import com.bilionDolarProject.projectX.service.PreSetGearboxService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/v1/gearbox")
@RequiredArgsConstructor
@Tag(name = "Gearbox Calculator", description = "APIs for calculating gear ratios and speeds")
public class GearCalculatorController {

    private final PreSetGearboxService preSetGearboxService;
    private final GearSpeedsService gearSpeedsService;
    private final MapPreSetGearboxResponse mapPreSetGearboxResponse;

    private Double getGearSpeedByIndex(GearsSpeeds speeds, int gear) {
        return speeds.getGearSpeeds().getOrDefault(gear, null);
    }

    private void setGearSpeedByIndex(GearsSpeeds speeds, int gear, double value) {
        speeds.setGearSpeed(gear, Math.round(value * 100.0) / 100.0);
    }

    @Operation(summary = "Calculate speeds for RPM range")
    @PostMapping("/calculateSpeeds")
    public ResponseEntity<Map<Integer, Map<String, Double>>> calculateSpeeds(@Valid @RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = mapToVehicle(vehicleDTO);
        Map<Integer, Map<String, Double>> rpmToSpeedsMap = new TreeMap<>();
        
        int baseRpm = vehicle.getMaxRpm();
        String finalDrivePattern = vehicleDTO.getFinalDrivePattern();
        Double finalDrive2 = vehicleDTO.getFinalDrive2();
        for (int rpm = 5; rpm <= baseRpm; rpm += 5) {
            vehicle.setMaxRpm(rpm);
            GearsSpeeds gearsSpeeds;
            if (finalDrivePattern != null || finalDrive2 != null) {
                gearsSpeeds = gearSpeedsService.calculateGearSpeeds(vehicle, finalDrivePattern, finalDrive2);
            } else {
                gearsSpeeds = gearSpeedsService.calculateGearSpeeds(vehicle);
            }
            
            Map<String, Double> gearsSpeedsMap = new LinkedHashMap<>();
            for (int i = 1; i <= 7; i++) {
                Double speed = getGearSpeedByIndex(gearsSpeeds, i);
                if (speed != null && speed != 0) {
                    gearsSpeedsMap.put("gear" + i, Math.round(speed * 100.0) / 100.0);
                }
            }

            if (!gearsSpeedsMap.isEmpty()) {
                rpmToSpeedsMap.put(rpm, gearsSpeedsMap);
            }
        }

        return ResponseEntity.ok(rpmToSpeedsMap);
    }

    @Operation(summary = "Save a new gearbox preset")
    @PostMapping("/save")
    public ResponseEntity<Void> saveGearbox(@Valid @RequestBody PreSetGearboxDTO preSetGearboxDTO) {
        preSetGearboxService.addNewPreSetGearbox(mapToPreSetGearbox(preSetGearboxDTO));
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get all gearbox presets")
    @GetMapping("/getAllList")
    public ResponseEntity<List<PreSetGearbox>> getAllGearboxes() {
        return ResponseEntity.ok(preSetGearboxService.getPreSetGearbox());
    }

    @Operation(summary = "Get a gearbox preset by ID")
    @GetMapping("/getById/{id}")
    public ResponseEntity<PreSetGearboxResponse> getPreSetGearbox(@PathVariable Long id) {
        PreSetGearbox gearbox = preSetGearboxService.findPreSetGearboxById(id);
        Vehicle vehicle = mapToVehicle(gearbox);
        GearsSpeeds speeds = gearSpeedsService.calculateGearSpeeds(
            vehicle,
            gearbox.getFinalDrivePattern(),
            gearbox.getFinalDrive2()
        );
        PreSetGearboxResponse response = mapPreSetGearboxResponse.preSetGearboxResponse(gearbox);
        // Optionally, you can attach speeds to response if needed
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get all gearbox presets with detailed information")
    @GetMapping("/getAll")
    public ResponseEntity<List<PreSetGearboxResponse>> getAllGearboxesDetailed() {
        List<PreSetGearboxResponse> responses = new ArrayList<>();
        List<PreSetGearbox> gearboxes = preSetGearboxService.getPreSetGearbox();
        
        for (PreSetGearbox gearbox : gearboxes) {
            responses.add(mapPreSetGearboxResponse.preSetGearboxResponse(gearbox));
        }
        
        return ResponseEntity.ok(responses);
    }

    private Vehicle mapToVehicle(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setMaxRpm(dto.getMaxRpm());
        vehicle.setGearRatio1(dto.getGearRatio1());
        vehicle.setGearRatio2(dto.getGearRatio2());
        vehicle.setGearRatio3(dto.getGearRatio3());
        vehicle.setGearRatio4(dto.getGearRatio4());
        vehicle.setGearRatio5(dto.getGearRatio5());
        vehicle.setGearRatio6(dto.getGearRatio6());
        vehicle.setGearRatio7(dto.getGearRatio7());
        vehicle.setFinalDrive(dto.getFinalDrive());
        vehicle.setTyreWidth(dto.getTyreWidth());
        vehicle.setTyreProfile(dto.getTyreProfile());
        vehicle.setWheelDiameter(dto.getWheelDiameter());
        return vehicle;
    }

    private Vehicle mapToVehicle(PreSetGearbox gearbox) {
        Vehicle vehicle = new Vehicle();
        vehicle.setGearRatio1(gearbox.getGear1());
        vehicle.setGearRatio2(gearbox.getGear2());
        vehicle.setGearRatio3(gearbox.getGear3());
        vehicle.setGearRatio4(gearbox.getGear4());
        vehicle.setGearRatio5(gearbox.getGear5());
        vehicle.setGearRatio6(gearbox.getGear6());
        vehicle.setGearRatio7(gearbox.getGear7());
        vehicle.setFinalDrive(gearbox.getFinalDrive());
        // Set default values to prevent NPE
        vehicle.setTyreWidth(205);
        vehicle.setTyreProfile(55);
        vehicle.setWheelDiameter(16);
        vehicle.setMaxRpm(7000);
        return vehicle;
    }

    private PreSetGearbox mapToPreSetGearbox(PreSetGearboxDTO dto) {
        return new PreSetGearbox(
            dto.getName(),
            dto.getGear1(),
            dto.getGear2(),
            dto.getGear3(),
            dto.getGear4(),
            dto.getGear5(),
            dto.getGear6(),
            dto.getGear7(),
            dto.getFinalDrive(),
            dto.getFinalDrive2(),
            dto.getCarBrand(),
            dto.getFinalDrivePattern()
        );
    }
}
