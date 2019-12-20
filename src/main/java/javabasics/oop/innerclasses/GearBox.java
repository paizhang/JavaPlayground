package javabasics.oop.innerclasses;

import java.util.ArrayList;
import java.util.List;

public class GearBox {

    private int maxGear;
    private List<Gear> gears;

    public GearBox(int maxGear) {
        this.maxGear = maxGear;
        this.gears = new ArrayList<Gear>();
    }

    public void addGear(int gearID, String gearName) {
        Gear newGear = new Gear(gearID, gearName);
        this.gears.add(newGear);
    }

    public void addGear(Gear gear) {
        gears.add(gear);
    }

    public class Gear {

        private int gearID;
        private String gearName;

        public Gear(int gearID, String gearName) {
            // this keyword here refer to the Gear class.
            this.gearID = gearID;
            this.gearName = gearName;
        }

        public void printGearDescription() {
            System.out.println("This is a " + this.gearName);
        }
    }
}
