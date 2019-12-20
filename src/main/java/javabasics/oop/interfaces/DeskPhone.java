package javabasics.oop.interfaces;

/*
    Class that implements an interface should override all methods within the interface.
    The use cases and purpose for using interfaces.
    1. Code reusability. Interface is a way for demonstrating polymorphism. So it inherits all the advantages that polymorphism
    possesses.
    2. It is used to define application API which is a contract that "third-party" vendors has to obey and implement.
    (https://stackoverflow.com/questions/2586389/when-should-i-use-an-interface-in-java)
 */
public class DeskPhone implements ITelephone {
    private int myPhoneNumber;
    private boolean isRinging;

    public int getMyPhoneNumber() {
        return myPhoneNumber;
    }

    public void setMyPhoneNumber(int myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
    }

    public void setRinging(boolean ringing) {
        isRinging = ringing;
    }

    public DeskPhone(int myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
        this.isRinging = false;
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Dialing:" + phoneNumber);
    }

    @Override
    public void callPhone(int phoneNumber) {
        System.out.println("Calling...");
    }

    @Override
    public void answer() {
        System.out.println("Is answering...");
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
