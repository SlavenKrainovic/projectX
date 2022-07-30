package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.controller.GearsSpeeds;
import com.bilionDolarProject.projectX.controller.ShaftSpeeds;
import com.bilionDolarProject.projectX.entity.WheelSize;
import com.bilionDolarProject.projectX.service.WheelSizeCalculator;


public class WheelSpeedsCalculator {
    public GearsSpeeds gearsSpeeds(ShaftSpeeds shaftSpeeds, WheelSizeCalculator wheelSizeCalculator, WheelSize wheelSize){


        double dia = wheelSizeCalculator.getcompleteWheelDiameter(wheelSize);

        double st1 = 0.1885 * shaftSpeeds.getFirstSpeed() * dia;
        double st2 = 0.1885 * shaftSpeeds.getSecondSpeed() * dia;
        double st3 = 0.1885 * shaftSpeeds.getThirdSpeed() * dia;
        double st4 = 0.1885 * shaftSpeeds.getFourSpeed() * dia;
        double st5 = 0.1885 * shaftSpeeds.getFiveSpeed() * dia;
        double st6 = 0.1885 * shaftSpeeds.getSixSpeed() * dia;
        GearsSpeeds gearsSpeeds = new GearsSpeeds(st1,st2,st3,st4,st5,st6);
        //wheell speed in kmh

        return gearsSpeeds;

    }
}
