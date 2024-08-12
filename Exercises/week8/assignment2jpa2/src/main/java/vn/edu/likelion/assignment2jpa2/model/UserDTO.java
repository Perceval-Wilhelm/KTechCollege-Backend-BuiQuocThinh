package vn.edu.likelion.assignment2jpa2.model;

public class UserDTO extends BaseDTO {
    private String username;
    private String password;
    private int kind;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }
}
