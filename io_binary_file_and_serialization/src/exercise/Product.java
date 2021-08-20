package exercise;

import java.io.Serializable;

public class Product implements Serializable {
    private int ID = -1;
    private String productName = "";
    private String manufacturer = "";
    private String description = "";
    private float price = 0;

    public Product() {
    }

    public Product(int ID, String productName, String manufacturer, String description, float price) {
        this.ID = ID;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.description = description;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void getAllInFor(){
        System.out.println("ID = " + this.ID + " Name = " + this.productName
                            + " Manufacturer = " + this.manufacturer + " Description = "
                            + this.description + " Price = " + this.price);
    }
}
