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
        GearsSpeeds speeds = gearSpeedsService.gearsSpeedsService(mapToVehicle(vehicle));
        if (speeds == null) {
            return ResponseEntity.ok(new GearsSpeeds());
        }
        GearsSpeeds formattedSpeeds = new GearsSpeeds();
        if (speeds.getGearSpeed1() != null && speeds.getGearSpeed1() != 0) formattedSpeeds.setGearSpeed1(Math.round(speeds.getGearSpeed1() * 100.0) / 100.0);
        if (speeds.getGearSpeed2() != null && speeds.getGearSpeed2() != 0) formattedSpeeds.setGearSpeed2(Math.round(speeds.getGearSpeed2() * 100.0) / 100.0);
        if (speeds.getGearSpeed3() != null && speeds.getGearSpeed3() != 0) formattedSpeeds.setGearSpeed3(Math.round(speeds.getGearSpeed3() * 100.0) / 100.0);
        if (speeds.getGearSpeed4() != null && speeds.getGearSpeed4() != 0) formattedSpeeds.setGearSpeed4(Math.round(speeds.getGearSpeed4() * 100.0) / 100.0);
        if (speeds.getGearSpeed5() != null && speeds.getGearSpeed5() != 0) formattedSpeeds.setGearSpeed5(Math.round(speeds.getGearSpeed5() * 100.0) / 100.0);
        if (speeds.getGearSpeed6() != null && speeds.getGearSpeed6() != 0) formattedSpeeds.setGearSpeed6(Math.round(speeds.getGearSpeed6() * 100.0) / 100.0);
        if (speeds.getGearSpeed7() != null && speeds.getGearSpeed7() != 0) formattedSpeeds.setGearSpeed7(Math.round(speeds.getGearSpeed7() * 100.0) / 100.0);
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
            GearsSpeeds gearsSpeeds = gearSpeedsService.gearsSpeedsService(vehicle);
            
            Map<String, Double> gearsSpeedsMap = new LinkedHashMap<>();
            if (gearsSpeeds.getGearSpeed1() != null && gearsSpeeds.getGearSpeed1() != 0) gearsSpeedsMap.put("gear1", Math.round(gearsSpeeds.getGearSpeed1() * 100.0) / 100.0);
            if (gearsSpeeds.getGearSpeed2() != null && gearsSpeeds.getGearSpeed2() != 0) gearsSpeedsMap.put("gear2", Math.round(gearsSpeeds.getGearSpeed2() * 100.0) / 100.0);
            if (gearsSpeeds.getGearSpeed3() != null && gearsSpeeds.getGearSpeed3() != 0) gearsSpeedsMap.put("gear3", Math.round(gearsSpeeds.getGearSpeed3() * 100.0) / 100.0);
            if (gearsSpeeds.getGearSpeed4() != null && gearsSpeeds.getGearSpeed4() != 0) gearsSpeedsMap.put("gear4", Math.round(gearsSpeeds.getGearSpeed4() * 100.0) / 100.0);
            if (gearsSpeeds.getGearSpeed5() != null && gearsSpeeds.getGearSpeed5() != 0) gearsSpeedsMap.put("gear5", Math.round(gearsSpeeds.getGearSpeed5() * 100.0) / 100.0);
            if (gearsSpeeds.getGearSpeed6() != null && gearsSpeeds.getGearSpeed6() != 0) gearsSpeedsMap.put("gear6", Math.round(gearsSpeeds.getGearSpeed6() * 100.0) / 100.0);
            if (gearsSpeeds.getGearSpeed7() != null && gearsSpeeds.getGearSpeed7() != 0) gearsSpeedsMap.put("gear7", Math.round(gearsSpeeds.getGearSpeed7() * 100.0) / 100.0);

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
