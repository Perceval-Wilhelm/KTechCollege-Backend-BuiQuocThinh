package vn.edu.likelion.day33;

public class ServiceSMS implements InterfaceService {
    public void sendMessage(String message) {
        System.out.println("SMS message: " + message);
    }
}
