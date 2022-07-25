package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.controller.Vehicle;
import com.bilionDolarProject.projectX.entity.Gearbox;
import com.bilionDolarProject.projectX.entity.WheelSize;

public class MapVehicle {
    public Gearbox gearbox (Vehicle vehicle) {
        double speed1 = vehicle.getGearRatio1();
        double speed2 = vehicle.getGearRatio2();
        double speed3 = vehicle.getGearRatio3();
        double speed4 = vehicle.getGearRatio4();
        double speed5 = vehicle.getGearRatio5();
        double speed6 = vehicle.getGearRatio6();
        double fina = vehicle.getFinalDrive();
        int rpm1 = vehicle.getMaxRpm();
        Gearbox gearbox = new Gearbox(rpm1,speed1,speed2,speed3,speed4,speed5,speed6,fina);
        return gearbox;
    }
    public WheelSize wheelSize (Vehicle vehicle){
        int tyrP = vehicle.getTyreProfile();
        int tyrW = vehicle.getTyreWidth();
        int tyrD = vehicle.getWheelDiameter();

        WheelSize wheelSize = new WheelSize(tyrW,tyrP,tyrD);
        return wheelSize;
    }





}
