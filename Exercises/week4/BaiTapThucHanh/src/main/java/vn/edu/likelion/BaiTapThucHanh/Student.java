package vn.edu.likelion.BaiTapThucHanh;

public class Student {
    private int id;
    private String name;
    private boolean isPresent;

    public Student(int id, String name, boolean isPresent) {
        this.id = id;
        this.name = name;
        this.isPresent = isPresent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
