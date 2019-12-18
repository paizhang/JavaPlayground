package javabasics.oop.composition;

public class MotherBoard {

    private String model;
    private String manufaturer;
    private int ramSlot;
    private int cardSlot;
    private String bios;

    public MotherBoard(String model, String manufaturer, int ramSlot, int cardSlot, String bios) {
        this.model = model;
        this.manufaturer = manufaturer;
        this.ramSlot = ramSlot;
        this.cardSlot = cardSlot;
        this.bios = bios;
    }

    public String getModel() {
        return model;
    }

    public String getManufaturer() {
        return manufaturer;
    }

    public int getRamSlot() {
        return ramSlot;
    }

    public int getCardSlot() {
        return cardSlot;
    }

    public String getBios() {
        return bios;
    }
}
