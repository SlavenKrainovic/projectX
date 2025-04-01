package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.entity.Gearbox;
import com.bilionDolarProject.projectX.entity.ShaftSpeeds;
import org.springframework.stereotype.Service;

@Service
public class GearRatioCalculator {
    public ShaftSpeeds shaftSpeed(Gearbox gearbox) {
        ShaftSpeeds shaftSpeeds = new ShaftSpeeds();

        if (gearbox.getGear1() != null) {
            shaftSpeeds.setShaftSpeed1(gearbox.getGear1() * gearbox.getFinalDrive());
        }
        if (gearbox.getGear2() != null) {
            shaftSpeeds.setShaftSpeed2(gearbox.getGear2() * gearbox.getFinalDrive());
        }
        if (gearbox.getGear3() != null) {
            shaftSpeeds.setShaftSpeed3(gearbox.getGear3() * gearbox.getFinalDrive());
        }
        if (gearbox.getGear4() != null) {
            shaftSpeeds.setShaftSpeed4(gearbox.getGear4() * gearbox.getFinalDrive());
        }
        if (gearbox.getGear5() != null) {
            shaftSpeeds.setShaftSpeed5(gearbox.getGear5() * gearbox.getFinalDrive());
        }
        if (gearbox.getGear6() != null) {
            shaftSpeeds.setShaftSpeed6(gearbox.getGear6() * gearbox.getFinalDrive());
        }
        if (gearbox.getGear7() != null) {
            shaftSpeeds.setShaftSpeed7(gearbox.getGear7() * gearbox.getFinalDrive());
        }

        return shaftSpeeds;
    }
}
