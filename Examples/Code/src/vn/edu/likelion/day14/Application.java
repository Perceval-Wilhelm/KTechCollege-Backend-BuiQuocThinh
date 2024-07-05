package vn.edu.likelion.day14;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
//        // Stream does not change original data
//        List<String> list = Arrays.asList("PHP", "Java", "C#", "Python", "ReactJS");
//
//        Stream<String> stream = list.stream()
//                .filter(s -> s.toLowerCase().startsWith("j"));
//
//        List<String> streamList = stream.toList();
//        // Or
//        List<String> stream2 = list.stream()
//                .filter(s -> s.toLowerCase().startsWith("j")).toList();
//
//        System.out.println(streamList);
//
//        // Base64
//        // Base64 encoding
//        String password = "Likelion2024";
//
//        String encode = Base64.getEncoder().encodeToString(password.getBytes());
//        System.out.println("Encode: " + encode);
//
//        // Base64 decoding
//        byte[] decodeByte = Base64.getDecoder().decode(encode);
//        System.out.println(decodeByte.toString());
//        String decode = new String(decodeByte);
//        System.out.println("Decode: " + decode);

        String encode2 = "Ci0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tRWFzdGVyIGVnZy0tLS0tLS0tLS0tLS0tLS0tLS0tLS0t\n" +
                "ClRyb25nIG3DoyBow7NhIEJhc2U2NCwgxJHhu5kgZMOgaSBj4bunYSBjaHXhu5dpIMSRxrDhu6Nj\n" +
                "IG3DoyBow7NhIMSR4bqndSByYSBwaOG6o2kgbMOgIGLhu5lpIHPhu5EgY+G7p2EgMy4KTuG6v3Ug\n" +
                "a2jDtG5nIMSR4bunLCDEkeG6p3UgcmEgc+G6vSDEkcaw4bujYyDEkeG7h20gYuG6sW5nIGPDoWMg\n" +
                "a8O9IHThu7EgcGFkIGLhu5Ugc3VuZyAoZOG6pXUgPSkuClRhIGPDsyB0aOG7gyBi4buPIGThuqV1\n" +
                "ID0gYuG6sW5nIGPDoWNoIHPhu60gZOG7pW5nIHdpdGhvdXRQYWRkaW5nIG5oxrAgc2F1OiBCYXNl\n" +
                "NjQuZ2V0RW5jb2RlcigpLndpdGhvdXRQYWRkaW5nKCkuZW5jb2RlVG9TdHJpbmcoc3RyLmdldEJ5\n" +
                "dGVzKCkp";

        byte[] decodeByte2 = Base64.getMimeDecoder().decode(encode2);
        System.out.println(decodeByte2.toString());
        String decode2 = new String(decodeByte2);
        System.out.println("Decode 2: " + decode2);
    }
}
