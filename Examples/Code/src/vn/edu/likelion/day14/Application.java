package vn.edu.likelion.day14;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // Stream API
        List<String> list =
                Arrays.asList("PHP", "Java", "C#", "Python", "ReactJS");

        Stream<String> stream = list.stream()
                .filter(s -> s.toLowerCase().startsWith("j"));

        List<String> streamList = stream.toList();
        //System.out.println(streamList);

        // Base 64
        // Mã hoá với base64 encoding
        String password = "likelion2024";
        String encode = Base64.getEncoder().encodeToString(password.getBytes());
        //System.out.println("Mã hoá: "  + encode);

        // Giải mã với base64 decoding
        byte[] decodeByte = Base64.getDecoder().decode(encode);
        String decode = new String(decodeByte);
        //System.out.println("Giải mã: " + decode);

        StringBuilder sb = new StringBuilder();
        sb.append("Ci0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tRWFzdGVyIGVnZy0tLS0tLS0tLS0tLS0tLS0tLS0tLS0t");
        sb.append("ClRyb25nIG3DoyBow7NhIEJhc2U2NCwgxJHhu5kgZMOgaSBj4bunYSBjaHXhu5dpIMSRxrDhu6Nj");
        sb.append("IG3DoyBow7NhIMSR4bqndSByYSBwaOG6o2kgbMOgIGLhu5lpIHPhu5EgY+G7p2EgMy4KTuG6v3Ug");
        sb.append("a2jDtG5nIMSR4bunLCDEkeG6p3UgcmEgc+G6vSDEkcaw4bujYyDEkeG7h20gYuG6sW5nIGPDoWMg");
        sb.append("a8O9IHThu7EgcGFkIGLhu5Ugc3VuZyAoZOG6pXUgPSkuClRhIGPDsyB0aOG7gyBi4buPIGThuqV1");
        sb.append("ID0gYuG6sW5nIGPDoWNoIHPhu60gZOG7pW5nIHdpdGhvdXRQYWRkaW5nIG5oxrAgc2F1OiBCYXNl");
        sb.append("NjQuZ2V0RW5jb2RlcigpLndpdGhvdXRQYWRkaW5nKCkuZW5jb2RlVG9TdHJpbmcoc3RyLmdldEJ5");
        sb.append("dGVzKCkp");
        byte[] abc = Base64.getDecoder().decode(sb.toString());
        String str = new String(abc);
        System.out.println(str);
    }
}
