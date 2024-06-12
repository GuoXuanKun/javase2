package day240612.practice.me;

public class StudentTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("xxx",19);
        System.out.println(19 == teacher.getAge());
        System.out.println(teacher.getNamePuls());
        teacher.setNamePuls("x");
        teacher.setAge(20);
        System.out.println(teacher.getAge());
        System.out.println(teacher.getNamePuls());
        System.out.println(teacher.getAge());
        System.out.println(19 != teacher.getAge());
        System.out.println(19 == teacher.getAge());
    }
}
