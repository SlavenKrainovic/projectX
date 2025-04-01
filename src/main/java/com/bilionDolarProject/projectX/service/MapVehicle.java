package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.entity.Vehicle;
import com.bilionDolarProject.projectX.entity.Gearbox;
import com.bilionDolarProject.projectX.entity.WheelSize;
import org.springframework.stereotype.Service;

@Service
public class MapVehicle {
    public Gearbox gearbox(Vehicle vehicle) {
        Gearbox gearbox = new Gearbox();
        gearbox.setGear1(vehicle.getGearRatio1());
        gearbox.setGear2(vehicle.getGearRatio2());
        gearbox.setGear3(vehicle.getGearRatio3());
        gearbox.setGear4(vehicle.getGearRatio4());
        gearbox.setGear5(vehicle.getGearRatio5());
        gearbox.setGear6(vehicle.getGearRatio6());
        gearbox.setGear7(vehicle.getGearRatio7());
        gearbox.setFinalDrive(vehicle.getFinalDrive());
        return gearbox;
    }

    public WheelSize wheelSize(Vehicle vehicle) {
        WheelSize wheelSize = new WheelSize();
        wheelSize.setTyreWidth(vehicle.getTyreWidth());
        wheelSize.setTyreProfile(vehicle.getTyreProfile());
        wheelSize.setWheelDiameter(vehicle.getWheelDiameter());
        return wheelSize;
    }
}
