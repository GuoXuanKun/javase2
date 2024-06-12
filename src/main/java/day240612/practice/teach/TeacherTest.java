package day240612.practice.teach;

public class TeacherTest {
    public static void main(String[] args) {
        Teacher xxx = new Teacher("xxx", 19);
        System.out.println(xxx);
        System.out.println(xxx.getAge());
        xxx.setAge(20);
        System.out.println(xxx.getAge());
    }
}
