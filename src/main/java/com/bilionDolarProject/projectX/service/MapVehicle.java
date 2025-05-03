package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.entity.Vehicle;
import com.bilionDolarProject.projectX.entity.Gearbox;
import com.bilionDolarProject.projectX.entity.WheelSize;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MapVehicle {
    public Gearbox gearbox(Vehicle vehicle) {
        Gearbox gearbox = new Gearbox();
        List<Double> gearRatios = new ArrayList<>();
        gearRatios.add(vehicle.getGearRatio1());
        gearRatios.add(vehicle.getGearRatio2());
        gearRatios.add(vehicle.getGearRatio3());
        gearRatios.add(vehicle.getGearRatio4());
        gearRatios.add(vehicle.getGearRatio5());
        gearRatios.add(vehicle.getGearRatio6());
        gearRatios.add(vehicle.getGearRatio7());
        gearbox.setGears(gearRatios);
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
