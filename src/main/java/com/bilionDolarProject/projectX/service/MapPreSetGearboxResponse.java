package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.entity.PreSetGearbox;
import com.bilionDolarProject.projectX.entity.PreSetGearboxResponse;
import com.bilionDolarProject.projectX.entity.SubObjectGearbox;

import java.util.ArrayList;

public class MapPreSetGearboxResponse {
        public PreSetGearboxResponse preSetGearboxResponse(PreSetGearbox preSetGearbox){
            String brand = preSetGearbox.getCarBrand();
            String name = preSetGearbox.getName();
            double drive = preSetGearbox.getFinalDrive();
            int gear1 = 1;
            int gear2 = 2;
            int gear3 = 3;
            int gear4 = 4;
            int gear5 = 5;
            int gear6 = 6;
            int gear7 = 7;
            double ratio1 = preSetGearbox.getGear1();
            double ratio2 = preSetGearbox.getGear2();
            double ratio3 = preSetGearbox.getGear3();
            double ratio4 = preSetGearbox.getGear4();
            double ratio5 = preSetGearbox.getGear5();
            double ratio6 = preSetGearbox.getGear6();
            double ratio7 = preSetGearbox.getGear7();
            SubObjectGearbox subObjectGearbox1 = new SubObjectGearbox(gear1,ratio1);
            SubObjectGearbox subObjectGearbox2 = new SubObjectGearbox(gear2,ratio2);
            SubObjectGearbox subObjectGearbox3 = new SubObjectGearbox(gear3,ratio3);
            SubObjectGearbox subObjectGearbox4 = new SubObjectGearbox(gear4,ratio4);
            SubObjectGearbox subObjectGearbox5 = new SubObjectGearbox(gear5,ratio5);
            SubObjectGearbox subObjectGearbox6 = new SubObjectGearbox(gear6,ratio6);
            SubObjectGearbox subObjectGearbox7 = new SubObjectGearbox(gear7,ratio7);
            ArrayList<SubObjectGearbox> gears = new ArrayList<SubObjectGearbox>();
            gears.add(subObjectGearbox1);
            gears.add(subObjectGearbox2);
            gears.add(subObjectGearbox3);
            gears.add(subObjectGearbox4);
            gears.add(subObjectGearbox5);
            gears.add(subObjectGearbox6);
            gears.add(subObjectGearbox7);

            PreSetGearboxResponse preSetGearboxResponse = new PreSetGearboxResponse(preSetGearbox.getCarBrand(), preSetGearbox.getName(), preSetGearbox.getFinalDrive(), gears);
            return preSetGearboxResponse;
        }




}
