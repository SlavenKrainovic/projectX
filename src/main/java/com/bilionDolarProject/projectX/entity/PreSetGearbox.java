package com.bilionDolarProject.projectX.entity;

import javax.persistence.*;

@Entity(name = "PreSetGearbox")
public class PreSetGearbox {
    @Id
    @SequenceGenerator(
            name = "preSetGearbox_sequence",
            sequenceName = "preSetGearbox_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "preSetGearbox_sequence"

    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "gear1"
    )
    private double gear1;
    @Column(name = "gear2")
    private double gear2;
    @Column (name = "gear3")
    private double gear3;
    @Column (name = "gear4")
    private double gear4;
    @Column (name = "gear5")
    private double gear5;
    @Column (name = "gear6")
    private double gear6;
    @Column (name = "gear7")
    private double gear7;
    @Column (name = "finalDrive")
    private double finalDrive;
    @Column (name = "carBrand", columnDefinition = "TEXT"
    )
    private String carBrand;

    public PreSetGearbox(){}

    public PreSetGearbox( String name, double gear1, double gear2, double gear3, double gear4, double gear5, double gear6, double gear7, double finalDrive, String carBrand) {

        this.name = name;
        this.gear1 = gear1;
        this.gear2 = gear2;
        this.gear3 = gear3;
        this.gear4 = gear4;
        this.gear5 = gear5;
        this.gear6 = gear6;
        this.gear7 = gear7;
        this.finalDrive = finalDrive;
        this.carBrand = carBrand;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGear1() {
        return gear1;
    }

    public void setGear1(double gear1) {
        this.gear1 = gear1;
    }

    public double getGear2() {
        return gear2;
    }

    public void setGear2(double gear2) {
        this.gear2 = gear2;
    }

    public double getGear3() {
        return gear3;
    }

    public void setGear3(double gear3) {
        this.gear3 = gear3;
    }

    public double getGear4() {
        return gear4;
    }

    public void setGear4(double gear4) {
        this.gear4 = gear4;
    }

    public double getGear5() {
        return gear5;
    }

    public void setGear5(double gear5) {
        this.gear5 = gear5;
    }

    public double getGear6() {
        return gear6;
    }

    public void setGear6(double gear6) {
        this.gear6 = gear6;
    }

    public double getGear7() {
        return gear7;
    }

    public void setGear7(double gear7) {
        this.gear7 = gear7;
    }

    public double getFinalDrive() {
        return finalDrive;
    }

    public void setFinalDrive(double finalDrive) {
        this.finalDrive = finalDrive;
    }

    @Override
    public String toString() {
        return "PreSetGearbox{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gear1=" + gear1 +
                ", gear2=" + gear2 +
                ", gear3=" + gear3 +
                ", gear4=" + gear4 +
                ", gear5=" + gear5 +
                ", gear6=" + gear6 +
                ", gear7=" + gear7 +
                ", finalDrive=" + finalDrive +
                ", carBrand='" + carBrand + '\'' +
                '}';
    }
}
