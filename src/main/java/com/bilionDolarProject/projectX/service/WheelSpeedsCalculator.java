package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.entity.GearsSpeeds;
import com.bilionDolarProject.projectX.entity.ShaftSpeeds;
import com.bilionDolarProject.projectX.entity.WheelSize;
import com.bilionDolarProject.projectX.service.WheelSizeCalculator;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WheelSpeedsCalculator {
    public GearsSpeeds gearsSpeeds(ShaftSpeeds shaftSpeeds, WheelSizeCalculator wheelSizeCalculator, WheelSize wheelSize) {
        GearsSpeeds gearsSpeeds = new GearsSpeeds();
        double dia = wheelSizeCalculator.getcompleteWheelDiameter(wheelSize);

        for (Map.Entry<Integer, Double> entry : shaftSpeeds.getShaftSpeeds().entrySet()) {
            Integer gearNumber = entry.getKey();
            Double shaftSpeed = entry.getValue();
            if (shaftSpeed != null) {
                gearsSpeeds.getGearSpeeds().put(gearNumber, 0.1885 * shaftSpeed * dia);
            }
        }

        return gearsSpeeds;
    }
}
