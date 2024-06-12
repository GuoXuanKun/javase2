package day240612.practice.me;

public class Student {

    // 1. state
    private String name;
    private int age;

    // 2. behavior

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

    // 3.constructor

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
