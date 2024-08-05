package vn.edu.likelion.day33;

public class ServiceMail implements InterfaceService {
    public void sendMessage(String message) {
        System.out.println("Mail message: " + message);
    }
}
