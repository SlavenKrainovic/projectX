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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Operation(summary = "Calculate speeds for maximum RPM")
    @PostMapping("/calculateSpeed")
    public ResponseEntity<GearsSpeeds> calculateSpeed(@Valid @RequestBody VehicleDTO vehicle) {
        GearsSpeeds speeds = gearSpeedsService.calculateGearSpeeds(mapToVehicle(vehicle));
        if (speeds == null) {
            return ResponseEntity.ok(new GearsSpeeds());
        }
        GearsSpeeds formattedSpeeds = new GearsSpeeds();
        for (int i = 1; i <= 7; i++) {
            Double speed = null;
            switch (i) {
                case 1: speed = speeds.getGearSpeed1(); break;
                case 2: speed = speeds.getGearSpeed2(); break;
                case 3: speed = speeds.getGearSpeed3(); break;
                case 4: speed = speeds.getGearSpeed4(); break;
                case 5: speed = speeds.getGearSpeed5(); break;
                case 6: speed = speeds.getGearSpeed6(); break;
                case 7: speed = speeds.getGearSpeed7(); break;
            }
            if (speed != null && speed != 0) {
                switch (i) {
                    case 1: formattedSpeeds.setGearSpeed1(Math.round(speed * 100.0) / 100.0); break;
                    case 2: formattedSpeeds.setGearSpeed2(Math.round(speed * 100.0) / 100.0); break;
                    case 3: formattedSpeeds.setGearSpeed3(Math.round(speed * 100.0) / 100.0); break;
                    case 4: formattedSpeeds.setGearSpeed4(Math.round(speed * 100.0) / 100.0); break;
                    case 5: formattedSpeeds.setGearSpeed5(Math.round(speed * 100.0) / 100.0); break;
                    case 6: formattedSpeeds.setGearSpeed6(Math.round(speed * 100.0) / 100.0); break;
                    case 7: formattedSpeeds.setGearSpeed7(Math.round(speed * 100.0) / 100.0); break;
                }
            }
        }
        return ResponseEntity.ok(formattedSpeeds);
    }

    @Operation(summary = "Calculate speeds for RPM range")
    @PostMapping("/calculateSpeeds")
    public ResponseEntity<Map<Integer, Map<String, Double>>> calculateSpeeds(@Valid @RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = mapToVehicle(vehicleDTO);
        Map<Integer, Map<String, Double>> rpmToSpeedsMap = new TreeMap<>();
        
        int baseRpm = vehicle.getMaxRpm();
        for (int rpm = 50; rpm <= baseRpm; rpm += 50) {
            vehicle.setMaxRpm(rpm);
            GearsSpeeds gearsSpeeds = gearSpeedsService.calculateGearSpeeds(vehicle);
            
            Map<String, Double> gearsSpeedsMap = new LinkedHashMap<>();
            for (int i = 1; i <= 7; i++) {
                Double speed = null;
                switch (i) {
                    case 1: speed = gearsSpeeds.getGearSpeed1(); break;
                    case 2: speed = gearsSpeeds.getGearSpeed2(); break;
                    case 3: speed = gearsSpeeds.getGearSpeed3(); break;
                    case 4: speed = gearsSpeeds.getGearSpeed4(); break;
                    case 5: speed = gearsSpeeds.getGearSpeed5(); break;
                    case 6: speed = gearsSpeeds.getGearSpeed6(); break;
                    case 7: speed = gearsSpeeds.getGearSpeed7(); break;
                }
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
        return ResponseEntity.ok(mapPreSetGearboxResponse.preSetGearboxResponse(gearbox));
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
            dto.getCarBrand()
        );
    }
}
