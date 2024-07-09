package vn.edu.likelion.model;

public class Father {

    // Thuộc tính private
    // Không cho phép truy cập từ bên ngoài class
    // Bảo vệ tính toàn vẹn của dữ liệu
    private String name;

    public Father() {}

    public Father(String name) {
        this.name = name;
    }

    // Phương thức getter có phạm vi truy cập là public
    // Cho phép truy cập từ mọi nơi, mọi class, mọi package
    public String getName() {
        return name;
    }

    // Phương thức setter có phạm vi truy cập là public
    public void setName(String name) {
        this.name = name;
    }

    public void goiAnCom() {
        System.out.println("Goi con xuong an com");
    }

}
