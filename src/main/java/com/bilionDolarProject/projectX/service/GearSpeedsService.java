package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.controller.GearsSpeeds;
import com.bilionDolarProject.projectX.controller.ShaftSpeeds;
import com.bilionDolarProject.projectX.controller.Vehicle;
import com.bilionDolarProject.projectX.entity.Gearbox;
import com.bilionDolarProject.projectX.entity.WheelSize;

public class GearSpeedsService {

 public GearsSpeeds gearsSpeedsService(Vehicle vehicle){
     MapVehicle mapVehicle = new MapVehicle();
     Gearbox gearbox = mapVehicle.gearbox(vehicle);
     GearRatioCalculator gearRatioCalculator = new GearRatioCalculator();
     ShaftSpeeds shaftSpeed = gearRatioCalculator.shaftSpeed(gearbox);
     WheelSize wheelSize = mapVehicle.wheelSize(vehicle);
     WheelSizeCalculator wheelSizeCalculator = new WheelSizeCalculator();
     WheelSpeedsCalculator wheelSpeedsCalculator = new WheelSpeedsCalculator();
     GearsSpeeds gearsSpeeds1= wheelSpeedsCalculator.gearsSpeeds(shaftSpeed,wheelSizeCalculator,wheelSize);
     return gearsSpeeds1;
 }








}
