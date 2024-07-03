package vn.edu.likelion.day12;

public class FatherMain {
    public static void main(String[] args) {

        Father<Integer, String> father = new Father<>();
        father.setAge(18);
        father.setName("Vinh");

        System.out.println("Cha - Tên tôi là " + father.getName());
        System.out.println("Tôi năm nay " + father.getAge() + " tuổi");

        Father<String, Integer> son = new Father<>();
        son.setAge("Mười tám");
        son.setName(17);

        System.out.println("Con trai - Tên tôi là " + son.getName());
        System.out.println("Tôi năm nay " + son.getAge() + " tuổi");

        Father<String, String> daughter = new Father<>();
        daughter.setAge("Mười tám");
        daughter.setName("Hà");

        System.out.println("Con gái - Tên tôi là " + daughter.getName());
        System.out.println("Tôi năm nay " + daughter.getAge() + " tuổi");
    }
}
