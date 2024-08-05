package vn.edu.likelion.day33;

public class Client {
    // tight coupling
//    private ServiceMail serviceMail = new ServiceMail();

    private InterfaceService interfaceService;

    public Client() {}

    // loose coupling
    public Client(InterfaceService interfaceService) {
        this.interfaceService = interfaceService;
    }

    public InterfaceService getInterfaceService() {
        return interfaceService;
    }

    public void setInterfaceService(InterfaceService interfaceService) {
        this.interfaceService = interfaceService;
    }

    public void print(String message) {
        interfaceService.sendMessage(message);
    }
}
