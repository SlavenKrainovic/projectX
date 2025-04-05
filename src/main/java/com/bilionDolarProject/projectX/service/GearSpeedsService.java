package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.entity.GearsSpeeds;
import com.bilionDolarProject.projectX.entity.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class GearSpeedsService {

    public GearsSpeeds gearsSpeedsService(Vehicle vehicle) {
        GearsSpeeds gearsSpeeds = new GearsSpeeds();
        
        // Calculate wheel circumference in meters
        double wheelCircumference = calculateWheelCircumference(
            vehicle.getTyreWidth(),
            vehicle.getTyreProfile(),
            vehicle.getWheelDiameter()
        );

        // Calculate speeds for each gear if present and not zero
        if (vehicle.getGearRatio1() != null && vehicle.getGearRatio1() != 0) {
            gearsSpeeds.setGearSpeed1(calculateSpeed(
                vehicle.getMaxRpm(),
                vehicle.getGearRatio1(),
                vehicle.getFinalDrive(),
                wheelCircumference
            ));
        }

        if (vehicle.getGearRatio2() != null && vehicle.getGearRatio2() != 0) {
            gearsSpeeds.setGearSpeed2(calculateSpeed(
                vehicle.getMaxRpm(),
                vehicle.getGearRatio2(),
                vehicle.getFinalDrive(),
                wheelCircumference
            ));
        }

        if (vehicle.getGearRatio3() != null && vehicle.getGearRatio3() != 0) {
            gearsSpeeds.setGearSpeed3(calculateSpeed(
                vehicle.getMaxRpm(),
                vehicle.getGearRatio3(),
                vehicle.getFinalDrive(),
                wheelCircumference
            ));
        }

        if (vehicle.getGearRatio4() != null && vehicle.getGearRatio4() != 0) {
            gearsSpeeds.setGearSpeed4(calculateSpeed(
                vehicle.getMaxRpm(),
                vehicle.getGearRatio4(),
                vehicle.getFinalDrive(),
                wheelCircumference
            ));
        }

        if (vehicle.getGearRatio5() != null && vehicle.getGearRatio5() != 0) {
            gearsSpeeds.setGearSpeed5(calculateSpeed(
                vehicle.getMaxRpm(),
                vehicle.getGearRatio5(),
                vehicle.getFinalDrive(),
                wheelCircumference
            ));
        }

        if (vehicle.getGearRatio6() != null && vehicle.getGearRatio6() != 0) {
            gearsSpeeds.setGearSpeed6(calculateSpeed(
                vehicle.getMaxRpm(),
                vehicle.getGearRatio6(),
                vehicle.getFinalDrive(),
                wheelCircumference
            ));
        }

        if (vehicle.getGearRatio7() != null && vehicle.getGearRatio7() != 0) {
            gearsSpeeds.setGearSpeed7(calculateSpeed(
                vehicle.getMaxRpm(),
                vehicle.getGearRatio7(),
                vehicle.getFinalDrive(),
                wheelCircumference
            ));
        }

        return gearsSpeeds;
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
