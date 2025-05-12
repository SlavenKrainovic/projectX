package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.entity.GearsSpeeds;
import com.bilionDolarProject.projectX.entity.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class GearSpeedsService {

    private boolean isNonZero(Double value) {
        return value != null && value != 0;
    }

    public GearsSpeeds calculateGearSpeeds(Vehicle vehicle) {
        GearsSpeeds gearsSpeeds = new GearsSpeeds();
        
        // Calculate wheel circumference in meters
        double wheelCircumference = calculateWheelCircumference(
            vehicle.getTyreWidth(),
            vehicle.getTyreProfile(),
            vehicle.getWheelDiameter()
        );

        // Calculate speeds for each gear if present and not zero
        for (int i = 1; i <= 7; i++) {
            Double gearRatio = getGearRatioByIndex(vehicle, i);
            if (isNonZero(gearRatio)) {
                double speed = calculateSpeed(
                    vehicle.getMaxRpm(),
                    gearRatio,
                    vehicle.getFinalDrive(),
                    wheelCircumference
                );
                gearsSpeeds.setGearSpeed(i, speed);
            }
        }

        return gearsSpeeds;
    }

    public GearsSpeeds calculateGearSpeeds(Vehicle vehicle, String finalDrivePattern, Double finalDrive2) {
        GearsSpeeds gearsSpeeds = new GearsSpeeds();
        double wheelCircumference = calculateWheelCircumference(
            vehicle.getTyreWidth(),
            vehicle.getTyreProfile(),
            vehicle.getWheelDiameter()
        );
        String[] pattern = finalDrivePattern != null ? finalDrivePattern.split(",") : null;
        int gearCount = 7; // update if more gears
        for (int i = 1; i <= gearCount; i++) {
            Double gearRatio = getGearRatioByIndex(vehicle, i);
            if (isNonZero(gearRatio)) {
                double drive = vehicle.getFinalDrive();
                if (pattern != null && pattern.length >= i && finalDrive2 != null) {
                    if ("2".equals(pattern[i-1])) {
                        drive = finalDrive2;
                    }
                }
                double speed = calculateSpeed(vehicle.getMaxRpm(), gearRatio, drive, wheelCircumference);
                gearsSpeeds.getGearSpeeds().put(i, speed);
            }
        }
        return gearsSpeeds;
    }

    private Double getGearRatioByIndex(Vehicle vehicle, int index) {
        switch (index) {
            case 1: return vehicle.getGearRatio1();
            case 2: return vehicle.getGearRatio2();
            case 3: return vehicle.getGearRatio3();
            case 4: return vehicle.getGearRatio4();
            case 5: return vehicle.getGearRatio5();
            case 6: return vehicle.getGearRatio6();
            case 7: return vehicle.getGearRatio7();
            default: return null;
        }
    }

    private double calculateSpeed(int rpm, double gearRatio, double finalDrive, double wheelCircumference) {
        // RPM to RPS (revolutions per second)
        double rps = rpm / 60.0;
        
        // Calculate wheel RPS
        double wheelRps = rps / (gearRatio * finalDrive);
        
        // Calculate speed in meters per second
        double speedMs = wheelRps * wheelCircumference;
        
        // Convert to km/h
        return speedMs * 3.6;
    }

    private double calculateWheelCircumference(int tyreWidth, int tyreProfile, int wheelDiameter) {
        // Convert tyre width from mm to m
        double widthM = tyreWidth / 1000.0;
        
        // Calculate tyre height in meters (profile is a percentage of width)
        double heightM = (tyreProfile / 100.0) * widthM;
        
        // Convert wheel diameter from inches to meters
        double diameterM = wheelDiameter * 0.0254;
        
        // Total diameter = wheel diameter + (2 * tyre height)
        double totalDiameter = diameterM + (2 * heightM);
        
        // Calculate circumference
        return Math.PI * totalDiameter;
    }
}
