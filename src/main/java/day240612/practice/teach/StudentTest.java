package day240612.practice.teach;

public class StudentTest {
    public static void main(String[] args) {
        Student xxx = new Student("xxx", 19);
        System.out.println(xxx);
        System.out.println(xxx.getAge());
        System.out.println(19 == xxx.getAge());
        xxx.setAge(20);
        System.out.println(xxx.getAge());
        System.out.println(xxx.getAge() != 19);
        System.out.println(xxx.getAge() == 20);
    }
}
