package vn.edu.likelion.assignment2.model;

public class ProductAttribute {
    private int productAttributeID;
    private int productID;
    private int sizeAttribute;
    private String typeAttribute;
    private String colorAttribute;
    private String brandAttribute;

    public ProductAttribute() {}

    public ProductAttribute(int productID, int sizeAttribute, String typeAttribute, String colorAttribute, String brandAttribute) {
        this.productID = productID;
        this.sizeAttribute = sizeAttribute;
        this.typeAttribute = typeAttribute;
        this.colorAttribute = colorAttribute;
        this.brandAttribute = brandAttribute;
    }

    // Getters and Setters
    public int getProductAttributeID() {
        return productAttributeID;
    }

    public void setProductAttributeID(int productAttributeID) {
        this.productAttributeID = productAttributeID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSizeAttribute() {
        return sizeAttribute;
    }

    public void setSizeAttribute(int sizeAttribute) {
        this.sizeAttribute = sizeAttribute;
    }

    public String getTypeAttribute() {
        return typeAttribute;
    }

    public void setTypeAttribute(String typeAttribute) {
        this.typeAttribute = typeAttribute;
    }

    public String getColorAttribute() {
        return colorAttribute;
    }

    public void setColorAttribute(String colorAttribute) {
        this.colorAttribute = colorAttribute;
    }

    public String getBrandAttribute() {
        return brandAttribute;
    }

    public void setBrandAttribute(String brandAttribute) {
        this.brandAttribute = brandAttribute;
    }
}