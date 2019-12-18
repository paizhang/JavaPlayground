package javabasics.oop.composition;

public class MainClass {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(5, 20, 20);
        Resolution resolution = new Resolution(1024, 1024);
        Case theCase = new Case("1.0", "Dell", "Dell", dimensions);
        Monitor monitor = new Monitor("1.0", "LG", 1000, resolution);
        MotherBoard motherBoard = new MotherBoard("1.0", "Dell", 4, 4, "Hello");

        PC pc = new PC(motherBoard, theCase, monitor);
        pc.getMonitor().drawPixelAt(10,10);
    }
}
