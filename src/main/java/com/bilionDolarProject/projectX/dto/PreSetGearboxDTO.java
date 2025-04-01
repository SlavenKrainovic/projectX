package com.bilionDolarProject.projectX.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PreSetGearboxDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Car brand is required")
    private String carBrand;

    @NotNull(message = "Gear 1 ratio is required")
    @Min(value = 0, message = "Gear ratio must be positive")
    private Double gear1;

    @NotNull(message = "Gear 2 ratio is required")
    @Min(value = 0, message = "Gear ratio must be positive")
    private Double gear2;

    @NotNull(message = "Gear 3 ratio is required")
    @Min(value = 0, message = "Gear ratio must be positive")
    private Double gear3;

    @NotNull(message = "Gear 4 ratio is required")
    @Min(value = 0, message = "Gear ratio must be positive")
    private Double gear4;

    @NotNull(message = "Gear 5 ratio is required")
    @Min(value = 0, message = "Gear ratio must be positive")
    private Double gear5;

    @NotNull(message = "Gear 6 ratio is required")
    @Min(value = 0, message = "Gear ratio must be positive")
    private Double gear6;

    @Min(value = 0, message = "Gear ratio must be positive")
    private Double gear7;

    @NotNull(message = "Final drive ratio is required")
    @Min(value = 0, message = "Final drive ratio must be positive")
    private Double finalDrive;
}
