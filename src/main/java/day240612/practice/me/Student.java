package day240612.practice.me;

public class Student {

    // 1. state
    private String namePlus;
    private int age;

    // 2. behavior

    public String getNamePlus() {
        return namePlus;
    }

    public void setName(String namePlus) {
        this.namePlus = namePlus;
    }

    public int getAge() {
        return age + 1;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 3.constructor

    public Student(String namePlus, int age) {
        this.namePlus = namePlus;
        this.age = age;
    }
}
