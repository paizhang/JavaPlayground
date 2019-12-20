package javabasics.oop.interfaces;

public class MainClass {

    public static void main(String[] args) {
        ITelephone phone = null;
        phone = new DeskPhone(123456);
        phone.answer();
    }
}
