package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.entity.Gearbox;
import com.bilionDolarProject.projectX.entity.ShaftSpeeds;
import org.springframework.stereotype.Service;

@Service
public class GearRatioCalculator {
    public ShaftSpeeds shaftSpeed(Gearbox gearbox) {
        ShaftSpeeds shaftSpeeds = new ShaftSpeeds();
        double finalDrive = gearbox.getFinalDrive();

        for (int i = 0; i < gearbox.getGears().size(); i++) {
            Double gearRatio = gearbox.getGears().get(i);
            if (gearRatio != null) {
                shaftSpeeds.getShaftSpeeds().put(i + 1, gearRatio * finalDrive);
            }
        }

        return shaftSpeeds;
    }
}
