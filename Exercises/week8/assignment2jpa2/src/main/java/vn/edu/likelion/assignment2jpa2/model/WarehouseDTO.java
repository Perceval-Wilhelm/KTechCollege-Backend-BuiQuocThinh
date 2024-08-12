package vn.edu.likelion.assignment2jpa2.model;

public class WarehouseDTO extends BaseDTO {
    private String warehouse_name;
    private String address;

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
