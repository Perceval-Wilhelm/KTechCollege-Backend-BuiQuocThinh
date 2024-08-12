package vn.edu.likelion.assigment2jpa.model;

public class ErrorHandler extends RuntimeException {
    public ErrorHandler(String msg) {
        super(msg);
    }
}
