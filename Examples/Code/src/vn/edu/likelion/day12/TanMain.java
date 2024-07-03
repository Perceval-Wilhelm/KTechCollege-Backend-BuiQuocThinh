package vn.edu.likelion.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class TanMain {
    public static void main(String[] args) {

        Function<Integer, String> convert = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        };

        convert.apply(123);

        Predicate<String> check = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };

        check.test("123");

        TanEntity tan = new TanEntity();
        tan.setName("Tấn");
        tan.setAge(123);

        TanEntity tan2 = new TanEntity();
        tan2.setName("Tấn 2");
        tan2.setAge(456);

        ThinhEntity thinh = new ThinhEntity();
        thinh.setAddress("Tấn 2");
        thinh.setId(456L);

        TanService tanService = new TanService();
        tanService.insert(tan);
        tanService.insert(tan2);

        List<TanEntity> tanList = new ArrayList<>();
        tanList = tanService.findAll();
        for (TanEntity tanEntity : tanList) {
            System.out.println("Tên tôi là: " + tanEntity.getName());
            System.out.println("Tôi năm nay: " + tanEntity.getAge() + " tuổi");
        }
    }
}
