package com.bilionDolarProject.projectX.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.bilionDolarProject.projectX.validation.OptionalPositive;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDTO {
    @NotNull(message = "Max RPM is required")
    @Min(value = 1000, message = "Max RPM must be at least 1000")
    @Max(value = 15000, message = "Max RPM cannot exceed 15000")
    private Integer maxRpm;

    @NotNull(message = "At least first gear ratio is required")
    @Positive(message = "Gear ratio must be positive")
    private Double gearRatio1;

    @OptionalPositive(message = "Gear ratio must not be negative")
    private Double gearRatio2;

    @OptionalPositive(message = "Gear ratio must not be negative")
    private Double gearRatio3;

    @OptionalPositive(message = "Gear ratio must not be negative")
    private Double gearRatio4;

    @OptionalPositive(message = "Gear ratio must not be negative")
    private Double gearRatio5;

    @OptionalPositive(message = "Gear ratio must not be negative")
    private Double gearRatio6;

    @OptionalPositive(message = "Gear ratio must not be negative")
    private Double gearRatio7;

    @NotNull(message = "Final drive ratio is required")
    @Positive(message = "Final drive ratio must be positive")
    private Double finalDrive;

    @NotNull(message = "Tyre width is required")
    @Min(value = 135, message = "Tyre width must be at least 135")
    @Max(value = 405, message = "Tyre width cannot exceed 405")
    private Integer tyreWidth;

    @NotNull(message = "Tyre profile is required")
    @Min(value = 25, message = "Tyre profile must be at least 25")
    @Max(value = 80, message = "Tyre profile cannot exceed 80")
    private Integer tyreProfile;

    @NotNull(message = "Wheel diameter is required")
    @Min(value = 13, message = "Wheel diameter must be at least 13")
    @Max(value = 24, message = "Wheel diameter cannot exceed 24")
    private Integer wheelDiameter;
}
