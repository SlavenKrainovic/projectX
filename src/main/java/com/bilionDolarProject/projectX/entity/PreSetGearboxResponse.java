package com.bilionDolarProject.projectX.entity;

import java.util.ArrayList;

public class PreSetGearboxResponse {

 private String carBrand;
 private String name;
 private double finalDrive;
 private ArrayList<SubObjectGearbox> gears = new ArrayList<SubObjectGearbox>();

 public PreSetGearboxResponse(){}

 public PreSetGearboxResponse(String carBrand, String name, double finalDrive, ArrayList<SubObjectGearbox> gears) {
  this.carBrand = carBrand;
  this.name = name;
  this.finalDrive = finalDrive;
  this.gears = gears;
 }

 public String getCarBrand() {
  return carBrand;
 }

 public void setCarBrand(String carBrand) {
  this.carBrand = carBrand;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public double getFinalDrive() {
  return finalDrive;
 }

 public void setFinalDrive(double finalDrive) {
  this.finalDrive = finalDrive;
 }

 public ArrayList<SubObjectGearbox> getgears() {
  return gears;
 }

 public void setSubObjectGearboxes(ArrayList<SubObjectGearbox> gears) {
  this.gears = gears;
 }
}