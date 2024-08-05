package vn.edu.likelion.day33;

public class Main {
    public static void main(String[] args) {
        InterfaceService mailService = new ServiceMail();
        InterfaceService SMSService = new ServiceSMS();

        Client client = new Client();
        client.setInterfaceService(mailService);
        client.print("Hello!");
    }
}
