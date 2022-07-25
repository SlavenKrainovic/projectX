package com.bilionDolarProject.projectX;

import com.bilionDolarProject.projectX.entity.WheelSize;

public class WheelSizeCalculator {



    public double completeWheelDiameter(WheelSize wheelSize){

        double rimDiameter = wheelSize.getWheelDiameter() * 25.4;
        double tyreHightPrecente = wheelSize.getTyreProfile() / 100;
        double tyreHeight = wheelSize.getTyreWidth() * tyreHightPrecente;
        double wheelDiameterReal = tyreHeight + tyreHeight  + rimDiameter;
        double wheelDiameterResult = wheelDiameterReal / 1000;

        return wheelDiameterResult;
    }

    public double getcompleteWheelDiameter(WheelSize wheelSize) {
        return completeWheelDiameter(wheelSize);
    }
//wheelDiameterResult is in mm.



}
