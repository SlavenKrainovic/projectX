package com.bilionDolarProject.projectX.controller;

import com.bilionDolarProject.projectX.dto.PreSetGearboxDTO;
import com.bilionDolarProject.projectX.dto.VehicleDTO;
import com.bilionDolarProject.projectX.entity.PreSetGearbox;
import com.bilionDolarProject.projectX.entity.PreSetGearboxResponse;
import com.bilionDolarProject.projectX.service.GearSpeedsService;
import com.bilionDolarProject.projectX.service.MapPreSetGearboxResponse;
import com.bilionDolarProject.projectX.service.PreSetGearboxService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

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
        return ResponseEntity.ok(speeds);
    }

    @Operation(summary = "Calculate speeds for RPM range")
    @PostMapping("/calculateSpeeds")
    public ResponseEntity<List<Map<String, Map<String, Double>>>> calculateSpeeds(@Valid @RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = mapToVehicle(vehicleDTO);
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

        gearSpeedsList.sort(Comparator.comparingInt(map -> 
            Integer.parseInt(map.keySet().iterator().next().split(" ")[1])));

        return ResponseEntity.ok(gearSpeedsList);
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
