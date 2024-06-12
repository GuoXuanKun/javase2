package day240612.practice.me;

public class TeacherTest {
    public static void main(String[] args) {
        Teacher kkk = new Teacher("kkk", 19);
        System.out.println(kkk);
        System.out.println(kkk.getAge());
        System.out.println(kkk.getNamePuls());
        kkk.setAge(20);
        kkk.setNamePuls("k");
        System.out.println(kkk.getAge());
        System.out.println(kkk.getNamePuls());
    }
}
