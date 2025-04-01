package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.entity.GearsSpeeds;
import com.bilionDolarProject.projectX.entity.ShaftSpeeds;
import com.bilionDolarProject.projectX.entity.WheelSize;
import com.bilionDolarProject.projectX.service.WheelSizeCalculator;
import org.springframework.stereotype.Service;

@Service
public class WheelSpeedsCalculator {
    public GearsSpeeds gearsSpeeds(ShaftSpeeds shaftSpeeds, WheelSizeCalculator wheelSizeCalculator, WheelSize wheelSize) {
        GearsSpeeds gearsSpeeds = new GearsSpeeds();
        double dia = wheelSizeCalculator.getcompleteWheelDiameter(wheelSize);

        if (shaftSpeeds.getShaftSpeed1() != null) {
            gearsSpeeds.setGearSpeed1(0.1885 * shaftSpeeds.getShaftSpeed1() * dia);
        }
        if (shaftSpeeds.getShaftSpeed2() != null) {
            gearsSpeeds.setGearSpeed2(0.1885 * shaftSpeeds.getShaftSpeed2() * dia);
        }
        if (shaftSpeeds.getShaftSpeed3() != null) {
            gearsSpeeds.setGearSpeed3(0.1885 * shaftSpeeds.getShaftSpeed3() * dia);
        }
        if (shaftSpeeds.getShaftSpeed4() != null) {
            gearsSpeeds.setGearSpeed4(0.1885 * shaftSpeeds.getShaftSpeed4() * dia);
        }
        if (shaftSpeeds.getShaftSpeed5() != null) {
            gearsSpeeds.setGearSpeed5(0.1885 * shaftSpeeds.getShaftSpeed5() * dia);
        }
        if (shaftSpeeds.getShaftSpeed6() != null) {
            gearsSpeeds.setGearSpeed6(0.1885 * shaftSpeeds.getShaftSpeed6() * dia);
        }
        if (shaftSpeeds.getShaftSpeed7() != null) {
            gearsSpeeds.setGearSpeed7(0.1885 * shaftSpeeds.getShaftSpeed7() * dia);
        }

        return gearsSpeeds;
    }
}
