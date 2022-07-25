package com.bilionDolarProject.projectX.entity;

public class Gearbox {


    private int maxRpm;
    private double gearRatio1;
    private double gearRatio2;
    private double gearRatio3;
    private double gearRatio4;
    private double gearRatio5;
    private double gearRatio6;
    private double finalDrive;
    public Gearbox(){}
    public Gearbox(int maxRpm, double gearRatio1, double gearRatio2, double gearRatio3, double gearRatio4, double gearRatio5, double gearRatio6, double finalDrive) {
        this.maxRpm = maxRpm;
        this.gearRatio1 = gearRatio1;
        this.gearRatio2 = gearRatio2;
        this.gearRatio3 = gearRatio3;
        this.gearRatio4 = gearRatio4;
        this.gearRatio5 = gearRatio5;
        this.gearRatio6 = gearRatio6;
        this.finalDrive = finalDrive;
    }

    public int getMaxRpm() {
        return maxRpm;
    }

    public void setMaxRpm(int maxRpm) {
        this.maxRpm = maxRpm;
    }

    public double getGearRatio1() {
        return gearRatio1;
    }

    public void setGearRatio1(double gearRatio1) {
        this.gearRatio1 = gearRatio1;
    }

    public double getGearRatio2() {
        return gearRatio2;
    }

    public void setGearRatio2(double gearRatio2) {
        this.gearRatio2 = gearRatio2;
    }

    public double getGearRatio3() {
        return gearRatio3;
    }

    public void setGearRatio3(double gearRatio3) {
        this.gearRatio3 = gearRatio3;
    }

    public double getGearRatio4() {
        return gearRatio4;
    }

    public void setGearRatio4(double gearRatio4) {
        this.gearRatio4 = gearRatio4;
    }

    public double getGearRatio5() {
        return gearRatio5;
    }

    public void setGearRatio5(double gearRatio5) {
        this.gearRatio5 = gearRatio5;
    }

    public double getGearRatio6() {
        return gearRatio6;
    }

    public void setGearRatio6(double gearRatio6) {
        this.gearRatio6 = gearRatio6;
    }

    public double getFinalDrive() {
        return finalDrive;
    }

    public void setFinalDrive(double finalDrive) {
        this.finalDrive = finalDrive;
    }
}

