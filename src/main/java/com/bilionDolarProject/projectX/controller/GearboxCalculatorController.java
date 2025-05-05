package com.bilionDolarProject.projectX.controller;

import com.bilionDolarProject.projectX.dto.PreSetGearboxDTO;
import com.bilionDolarProject.projectX.entity.PreSetGearbox;
import com.bilionDolarProject.projectX.entity.PreSetGearboxResponse;
import com.bilionDolarProject.projectX.service.PreSetGearboxService;
import com.bilionDolarProject.projectX.service.MapPreSetGearboxResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Tag(name = "Gearbox Calculator UI", description = "Web interface for gearbox calculations")
public class GearboxCalculatorController {

    private final PreSetGearboxService preSetGearboxService;
    private final MapPreSetGearboxResponse mapPreSetGearboxResponse;

    @GetMapping("/gearbox/calculate")
    public String showCalculator(Model model) {
        Integer maxRpm = 1000;
        model.addAttribute("title", maxRpm);
        model.addAttribute("inputString", "");
        return "GearCalculatorController";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam("inputString") String inputString, Model model) {
        model.addAttribute("title", inputString);
        return "GearCalculatorController";
    }

    @Operation(summary = "Save a new gearbox preset")
    @PostMapping("/gearbox/save")
    public ResponseEntity<Void> saveGearbox(@Valid @RequestBody PreSetGearboxDTO preSetGearboxDTO) {
        preSetGearboxService.addNewPreSetGearbox(mapToPreSetGearbox(preSetGearboxDTO));
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get all gearbox presets")
    @GetMapping("/gearbox/getAllList")
    public ResponseEntity<List<PreSetGearbox>> getAllGearboxes() {
        return ResponseEntity.ok(preSetGearboxService.getPreSetGearbox());
    }

    @Operation(summary = "Get a gearbox preset by ID")
    @GetMapping("/gearbox/getById/{id}")
    public ResponseEntity<PreSetGearboxResponse> getPreSetGearbox(@PathVariable Long id) {
        PreSetGearbox gearbox = preSetGearboxService.findPreSetGearboxById(id);
        return ResponseEntity.ok(mapPreSetGearboxResponse.preSetGearboxResponse(gearbox));
    }

    @Operation(summary = "Get all gearbox presets with detailed information")
    @GetMapping("/gearbox/getAll")
    public ResponseEntity<List<PreSetGearboxResponse>> getAllGearboxesDetailed() {
        List<PreSetGearboxResponse> responses = new ArrayList<>();
        List<PreSetGearbox> gearboxes = preSetGearboxService.getPreSetGearbox();
        
        for (PreSetGearbox gearbox : gearboxes) {
            responses.add(mapPreSetGearboxResponse.preSetGearboxResponse(gearbox));
        }
        
        return ResponseEntity.ok(responses);
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
