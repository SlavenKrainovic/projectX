package com.bilionDolarProject.projectX.entity;

import lombok.Data;

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
        this.gearSpeed1 = gearSpeed1;
        this.gearSpeed2 = gearSpeed2;
        this.gearSpeed3 = gearSpeed3;
        this.gearSpeed4 = gearSpeed4;
        this.gearSpeed5 = gearSpeed5;
        this.gearSpeed6 = gearSpeed6;
        this.gearSpeed7 = gearSpeed7;
    }
}
