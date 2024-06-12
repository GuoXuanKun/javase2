package day240612.practice.teach;

/**
 * Java Bean
 * POJO
 */
public class Student {
    // state
    private String namePlus;
    private int age;

    // behavior
    public String getNamePlus() {
        return namePlus;
    }

    public void setNamePlus(String namePlus) {
        this.namePlus = namePlus;
    }

    public int getAge() {
        return age + 1;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // constructor
    public Student(String namePlus, int age) {
        this.namePlus = namePlus;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "namePlus='" + namePlus + '\'' +
                ", age=" + age +
                '}';
    }
}
