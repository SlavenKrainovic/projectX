package com.bilionDolarProject.projectX.entity;

public class WheelSize {
   private double  tyreWidth;
   private double  tyreProfile;
   private double  wheelDiameter;

 public WheelSize(){}
 public WheelSize(double tyreWidth, double tyreProfile, double wheelDiameter){
     this.tyreWidth = tyreWidth;
     this.tyreProfile = tyreProfile;
     this.wheelDiameter = wheelDiameter;

 }

    public double getTyreWidth() {
        return tyreWidth;
    }

    public void setTyreWidth(double tyreWidth) {
        this.tyreWidth = tyreWidth;
    }

    public double getTyreProfile() {
        return tyreProfile;
    }

    public void setTyreProfile(double tyreProfile) {
        this.tyreProfile = tyreProfile;
    }

    public double getWheelDiameter() {
        return wheelDiameter;
    }

    public void setWheelDiameter(double wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }
}
