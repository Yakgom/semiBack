package com.kh.statement.model.dto;

public class VendingDTO {

    private String drinkName;
    private int changeStock;

    public VendingDTO() {}

    public VendingDTO(String drinkName, int changeStock) {
        this.drinkName = drinkName;
        this.changeStock = changeStock;
    }

    public String getDrinkName() { return drinkName; }
    public void setDrinkName(String drinkName) { this.drinkName = drinkName; }
    public int getChangeStock() { return changeStock; }
    public void setChangeStock(int changeStock) { this.changeStock = changeStock; }
}
