package javabasics.oop.composition;

public class Monitor {

    private String model;
    private String manufaturer;
    private int size;
    // This is an example of resolution. It is a HAS-A relationship. One class is another class's component.
    private Resolution resolution;

    public Monitor(String model, String manufaturer, int size, Resolution resolution) {
        this.model = model;
        this.manufaturer = manufaturer;
        this.size = size;
        this.resolution = resolution;
    }

    public void drawPixelAt(int x, int y) {
        System.out.println("Draw at x = " + x + " and y = " + y);
    }

    public String getModel() {
        return model;
    }

    public String getManufaturer() {
        return manufaturer;
    }

    public int getSize() {
        return size;
    }

    public Resolution getResolution() {
        return resolution;
    }

}
