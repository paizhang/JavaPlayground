package javabasics.oop.polymorphism;

/*
    Polymorphism allows multiple subtypes of the same supertype to use the same reference of the supertype.
    Advantages:
    1. Code reusability. When another class calls the overriden methods of the subtypes, we do not need to implement methods for
    different subtypes.
    2. Less coupled. This makes it loose coupled with the specified subtype. In case that a specified subtype deprecates an API,
    the method that calls this API can still keep it as it is.
    3. Scalability. In case a new subtype is supported in the future, there is no change needed in the client side.

    A nice article explaining Polymorphism: https://www.zhihu.com/question/30082151
    Quora link discussing about advantages of polymorphism. https://www.quora.com/What-are-the-advantages-of-polymorphism-in-java
 */
public class MainClass {

    public static void driveCar(Car car) {
        car.drive();
    }

    public static void main(String[] args) {
        Car car = new BMW("BMW", "5.0X", "White");
        driveCar(car);

        car = new Benz("Benz", "3.0x", "Black");
        driveCar(car);
    }
}
