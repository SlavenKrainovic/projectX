package com.bilionDolarProject.projectX.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.bilionDolarProject.projectX.validation.OptionalPositive;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PreSetGearboxDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Car brand is required")
    private String carBrand;

    @NotNull(message = "Gear 1 ratio is required")
    @Positive(message = "Gear ratio must be positive")
    @Max(value = 7, message = "Gear ratio cannot exceed 7.0")
    private Double gear1;

    @NotNull(message = "Gear 2 ratio is required")
    @Positive(message = "Gear ratio must be positive")
    @Max(value = 7, message = "Gear ratio cannot exceed 7.0")
    private Double gear2;

    @NotNull(message = "Gear 3 ratio is required")
    @Positive(message = "Gear ratio must be positive")
    @Max(value = 7, message = "Gear ratio cannot exceed 7.0")
    private Double gear3;

    @NotNull(message = "Gear 4 ratio is required")
    @Positive(message = "Gear ratio must be positive")
    @Max(value = 7, message = "Gear ratio cannot exceed 7.0")
    private Double gear4;

    @NotNull(message = "Gear 5 ratio is required")
    @Positive(message = "Gear ratio must be positive")
    @Max(value = 7, message = "Gear ratio cannot exceed 7.0")
    private Double gear5;

    @NotNull(message = "Gear 6 ratio is required")
    @Positive(message = "Gear ratio must be positive")
    @Max(value = 7, message = "Gear ratio cannot exceed 7.0")
    private Double gear6;

    @OptionalPositive(message = "Gear ratio must not be negative")
    @Max(value = 7, message = "Gear ratio cannot exceed 7.0")
    private Double gear7;

    @NotNull(message = "Final drive ratio is required")
    @Positive(message = "Final drive ratio must be positive")
    @Max(value = 6, message = "Final drive ratio cannot exceed 6.0")
    private Double finalDrive;

    private Double finalDrive2;

    private String finalDrivePattern;

    public Double getFinalDrive2() {
        return finalDrive2;
    }

    public void setFinalDrive2(Double finalDrive2) {
        this.finalDrive2 = finalDrive2;
    }

    public String getFinalDrivePattern() {
        return finalDrivePattern;
    }

    public void setFinalDrivePattern(String finalDrivePattern) {
        this.finalDrivePattern = finalDrivePattern;
    }
}
