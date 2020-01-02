package io.javaio;

import java.io.Serializable;

/*
    Two scenarios for implementing the Serializable.
    1. We want to serialize the object explicitly using ObjectInputStream and ObjectOutputStream.
    2. We try to address some compatibility issues.

    Serialzable has no methods. Some no methods need to be overriden.
    serialVersionUID is used to identify the version of object. It is recommended to be managed by ourselves. Otherwise,
    the compiler will generate one for us. And it is not guarantee that the compilers will always generate the same
    number. And when we deserialize the object, if the serialVersionUID is not specified, the compiler will generate
    a new UID and compare it with the saved UID. If these two are not matched, it will throw a
    java.io.InvalidClassException.
 */
public class TestObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TestObject(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
