package com.kh.statement.controller;


import java.sql.Date;
import java.util.List;

import com.kh.statement.model.vo.Vending;
import com.kh.statement.service.VendingService;

public class VendingController {

    private VendingService service = new VendingService();

    public int save(String drinkName, String drinkType, int price, int stock, Date manufactureDate, Date expiryDate, String vendor) {
        Vending vending = new Vending(drinkName, drinkType, price, stock, manufactureDate, expiryDate, vendor);
        return service.save(vending);
    }

    public List<Vending> findAll() {
        return service.findAll();
    }

    public Vending findByName(String drinkName) {
        return service.findByName(drinkName);
    }

    public List<Vending> findByKeyword(String vendor) {
        return service.findByKeyword(vendor);
    }

    public int update(String drinkName, int changeStock) {
        return service.update(drinkName, changeStock);
    }

    public int delete(String drinkName, String vendor) {
        return service.delete(drinkName, vendor);
    }
}