package com.bilionDolarProject.projectX.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class GearsSpeeds {
    private Double gearSpeed1;
    private Double gearSpeed2;
    private Double gearSpeed3;
    private Double gearSpeed4;
    private Double gearSpeed5;
    private Double gearSpeed6;
    private Double gearSpeed7;

    public GearsSpeeds() {}

    public GearsSpeeds(Double gearSpeed1, Double gearSpeed2, Double gearSpeed3, Double gearSpeed4, Double gearSpeed5, Double gearSpeed6, Double gearSpeed7) {
        setGearSpeed1(gearSpeed1);
        setGearSpeed2(gearSpeed2);
        setGearSpeed3(gearSpeed3);
        setGearSpeed4(gearSpeed4);
        setGearSpeed5(gearSpeed5);
        setGearSpeed6(gearSpeed6);
        setGearSpeed7(gearSpeed7);
    }

    private Double roundSpeed(Double speed) {
        if (speed == null) return null;
        return BigDecimal.valueOf(speed)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public void setGearSpeed1(Double gearSpeed1) {
        this.gearSpeed1 = roundSpeed(gearSpeed1);
    }

    public void setGearSpeed2(Double gearSpeed2) {
        this.gearSpeed2 = roundSpeed(gearSpeed2);
    }

    public void setGearSpeed3(Double gearSpeed3) {
        this.gearSpeed3 = roundSpeed(gearSpeed3);
    }

    public void setGearSpeed4(Double gearSpeed4) {
        this.gearSpeed4 = roundSpeed(gearSpeed4);
    }

    public void setGearSpeed5(Double gearSpeed5) {
        this.gearSpeed5 = roundSpeed(gearSpeed5);
    }

    public void setGearSpeed6(Double gearSpeed6) {
        this.gearSpeed6 = roundSpeed(gearSpeed6);
    }

    public void setGearSpeed7(Double gearSpeed7) {
        this.gearSpeed7 = roundSpeed(gearSpeed7);
    }
}
