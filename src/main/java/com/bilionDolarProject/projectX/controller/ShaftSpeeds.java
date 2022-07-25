package com.bilionDolarProject.projectX.controller;

public class ShaftSpeeds {
    private double firstSpeed;
    private double secondSpeed;
    private double thirdSpeed;
    private double fourSpeed;
    private double fiveSpeed;
    private double sixSpeed;

    private ShaftSpeeds(){}

    public ShaftSpeeds(double firstSpeed, double secondSpeed, double thirdSpeed, double fourSpeed, double fiveSpeed, double sixSpeed) {
        this.firstSpeed = firstSpeed;
        this.secondSpeed = secondSpeed;
        this.thirdSpeed = thirdSpeed;
        this.fourSpeed = fourSpeed;
        this.fiveSpeed = fiveSpeed;
        this.sixSpeed = sixSpeed;
    }

    public double getFirstSpeed() {
        return firstSpeed;
    }

    public void setFirstSpeed(double firstSpeed) {
        this.firstSpeed = firstSpeed;
    }

    public double getSecondSpeed() {
        return secondSpeed;
    }

    public void setSecondSpeed(double secondSpeed) {
        this.secondSpeed = secondSpeed;
    }

    public double getThirdSpeed() {
        return thirdSpeed;
    }

    public void setThirdSpeed(double thirdSpeed) {
        this.thirdSpeed = thirdSpeed;
    }

    public double getFourSpeed() {
        return fourSpeed;
    }

    public void setFourSpeed(double fourSpeed) {
        this.fourSpeed = fourSpeed;
    }

    public double getFiveSpeed() {
        return fiveSpeed;
    }

    public void setFiveSpeed(double fiveSpeed) {
        this.fiveSpeed = fiveSpeed;
    }

    public double getSixSpeed() {
        return sixSpeed;
    }

    public void setSixSpeed(double sixSpeed) {
        this.sixSpeed = sixSpeed;
    }
}
