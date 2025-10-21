package com.kh.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Vending {

    private int drinkId;          // DRINK_ID       NUMBER PRIMARY KEY,                          -- 음료ID (PK)
    private String drinkName;     // DRINK_NAME     VARCHAR2(50) NOT NULL UNIQUE,               -- 음료 이름 (NOT NULL, UNIQUE)
    private String drinkType;     // DRINK_TYPE     VARCHAR2(20) NOT NULL CHECK (DRINK_TYPE IN ('탄산','주스','커피','차','물')), -- 음료 종류 제한
    private int price;            // PRICE          NUMBER(5,0) NOT NULL CHECK (PRICE > 0),     -- 가격 (0 이상)
    private int stock;            // STOCK          NUMBER NOT NULL,                             -- 재고
    private Date manufactureDate; // MANUFACTURE_DT DATE NOT NULL,                               -- 제조일
    private Date expiryDate;      // EXPIRY_DT      DATE NOT NULL,
    private String vendor;        //VENDOR         VARCHAR2(50) NOT NULL


    public Vending() {
        super();
    }




    public Vending(String drinkName, String drinkType, int price, int stock, Date manufactureDate, Date expiryDate,
                   String vendor) {
        super();
        this.drinkName = drinkName;
        this.drinkType = drinkType;
        this.price = price;
        this.stock = stock;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.vendor = vendor;
    }




    public Vending(int drinkId, String drinkName, String drinkType, int price, int stock, Date manufactureDate,
                   Date expiryDate, String vendor) {
        super();
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkType = drinkType;
        this.price = price;
        this.stock = stock;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.vendor = vendor;
    }




    public int getDrinkId() {
        return drinkId;
    }




    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }




    public String getDrinkName() {
        return drinkName;
    }




    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }




    public String getDrinkType() {
        return drinkType;
    }




    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }




    public int getPrice() {
        return price;
    }




    public void setPrice(int price) {
        this.price = price;
    }




    public int getStock() {
        return stock;
    }




    public void setStock(int stock) {
        this.stock = stock;
    }




    public Date getManufactureDate() {
        return manufactureDate;
    }




    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }




    public Date getExpiryDate() {
        return expiryDate;
    }




    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }




    public String getVendor() {
        return vendor;
    }




    public void setVendor(String vendor) {
        this.vendor = vendor;
    }




    @Override
    public int hashCode() {
        return Objects.hash(drinkId, drinkName, drinkType, expiryDate, manufactureDate, price, stock, vendor);
    }




    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vending other = (Vending) obj;
        return drinkId == other.drinkId && Objects.equals(drinkName, other.drinkName)
                && Objects.equals(drinkType, other.drinkType) && Objects.equals(expiryDate, other.expiryDate)
                && Objects.equals(manufactureDate, other.manufactureDate) && price == other.price
                && stock == other.stock && Objects.equals(vendor, other.vendor);
    }










}
