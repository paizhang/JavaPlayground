package javabasics.oop.innerclasses;

public class MainClass {

    public static void main(String[] args) {
        GearBox gearBox = new GearBox(6);
        // Create a Gear object within GearBox class
        gearBox.addGear(1, "Gear1");
        // Create a Gear object outside the GearBox class
        GearBox.Gear newGear = gearBox.new Gear(2, "Gear2");
        gearBox.addGear(newGear);
    }

}
