package com.bilionDolarProject.projectX.entity;

public class SubObjectGearbox {
    private int gear;
    private double ratio;


    public SubObjectGearbox(){}

    public SubObjectGearbox(int gear, double ratio) {
        this.gear = gear;
        this.ratio = ratio;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }



}
