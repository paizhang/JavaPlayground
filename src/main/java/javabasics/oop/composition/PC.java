package javabasics.oop.composition;

public class PC {

    private MotherBoard motherBoard;
    private Case theCase;
    private Monitor monitor;

    public MotherBoard getMotherBoard() {
        return motherBoard;
    }

    public Case getTheCase() {
        return theCase;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public PC(MotherBoard motherBoard, Case theCase, Monitor monitor) {
        this.motherBoard = motherBoard;
        this.theCase = theCase;
        this.monitor = monitor;
    }
}
