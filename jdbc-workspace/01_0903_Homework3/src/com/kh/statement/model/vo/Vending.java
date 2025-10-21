package com.kh.statement.model.vo;

	import java.sql.Date;
import java.util.Objects;

public class Vending {

    private int drinkId;
    private String drinkName;
    private String drinkType;
    private int price;
    private int stock;
    private Date manufactureDate;
    private Date expiryDate;
    private String vendor;

    public Vending() {}

    public Vending(String drinkName, String drinkType, int price, int stock, Date manufactureDate, Date expiryDate, String vendor) {
        this.drinkName = drinkName;
        this.drinkType = drinkType;
        this.price = price;
        this.stock = stock;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.vendor = vendor;
    }

    public Vending(int drinkId, String drinkName, String drinkType, int price, int stock, Date manufactureDate, Date expiryDate, String vendor) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkType = drinkType;
        this.price = price;
        this.stock = stock;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.vendor = vendor;
    }

    // getter & setter
    public int getDrinkId() { return drinkId; }
    public void setDrinkId(int drinkId) { this.drinkId = drinkId; }
    public String getDrinkName() { return drinkName; }
    public void setDrinkName(String drinkName) { this.drinkName = drinkName; }
    public String getDrinkType() { return drinkType; }
    public void setDrinkType(String drinkType) { this.drinkType = drinkType; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public Date getManufactureDate() { return manufactureDate; }
    public void setManufactureDate(Date manufactureDate) { this.manufactureDate = manufactureDate; }
    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }
    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }

    @Override
    public int hashCode() {
        return Objects.hash(drinkId, drinkName, drinkType, price, stock, manufactureDate, expiryDate, vendor);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Vending other = (Vending) obj;
        return drinkId == other.drinkId && price == other.price && stock == other.stock
                && Objects.equals(drinkName, other.drinkName)
                && Objects.equals(drinkType, other.drinkType)
                && Objects.equals(manufactureDate, other.manufactureDate)
                && Objects.equals(expiryDate, other.expiryDate)
                && Objects.equals(vendor, other.vendor);
    }
}
