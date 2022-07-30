package com.bilionDolarProject.projectX.service;


import com.bilionDolarProject.projectX.controller.ShaftSpeeds;
import com.bilionDolarProject.projectX.entity.Gearbox;

public class GearRatioCalculator {
public  ShaftSpeeds shaftSpeed (Gearbox gearbox){
    double resultGear1 = (gearbox.getMaxRpm() / gearbox.getGearRatio1()) / gearbox.getFinalDrive();
    double resultGear2 = (gearbox.getMaxRpm() / gearbox.getGearRatio2()) / gearbox.getFinalDrive();
    double resultGear3 = (gearbox.getMaxRpm() / gearbox.getGearRatio3()) / gearbox.getFinalDrive();
    double resultGear4 = (gearbox.getMaxRpm() / gearbox.getGearRatio4()) / gearbox.getFinalDrive();
    double resultGear5 = (gearbox.getMaxRpm() / gearbox.getGearRatio5()) / gearbox.getFinalDrive();
    double resultGear6 = (gearbox.getMaxRpm() / gearbox.getGearRatio6()) / gearbox.getFinalDrive();
    ShaftSpeeds shaftSpeeds = new ShaftSpeeds(resultGear1,resultGear2,resultGear3,resultGear4,resultGear5,resultGear6);






    return shaftSpeeds;
    }



}
