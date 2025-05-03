package com.bilionDolarProject.projectX.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.HashMap;

@Data
public class GearsSpeeds {
    private Map<Integer, Double> gearSpeeds;

    public GearsSpeeds() {
        this.gearSpeeds = new HashMap<>();
    }

    public GearsSpeeds(Map<Integer, Double> gearSpeeds) {
        this.gearSpeeds = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : gearSpeeds.entrySet()) {
            setGearSpeed(entry.getKey(), entry.getValue());
        }
    }

    private Double roundSpeed(Double speed) {
        if (speed == null) return null;
        return BigDecimal.valueOf(speed)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public Map<Integer, Double> getGearSpeeds() {
        return gearSpeeds;
    }

    public void setGearSpeed(Integer gearNumber, Double speed) {
        this.gearSpeeds.put(gearNumber, roundSpeed(speed));
    }
}
