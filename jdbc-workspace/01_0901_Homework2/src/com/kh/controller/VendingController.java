package com.kh.controller;

import java.sql.Date;
import java.util.List;

import com.kh.model.dao.VendingDao;
import com.kh.model.dto.VendingDTO;
import com.kh.model.vo.Vending;

public class VendingController {
    private final VendingDao vd = new VendingDao();

    public int save(String drinkName,String drinkType , int price , int stock , Date manufactureDate , Date expiryDate,String vendor ) {

        int result = 0;

        Vending vending = new Vending(drinkName, drinkType, price, stock, manufactureDate, expiryDate, vendor);

        result = vd.save(vending);



        return result;
    }

    public List<Vending> findAll() {

        List<Vending> vendings = vd.findAll();
        return vendings;

    }

    public Vending findByName(String drinkName) {

        Vending vending = vd.findByName(drinkName);

        return vending;
    }

    public List<Vending> findByKeyword(String vendor) {

        List<Vending> vendings = vd.findByKeyword(vendor);


        return vendings;
    }
    
    
    public int update(String drinkName , int changeStock) {
    	
    	VendingDTO vdto = new VendingDTO(drinkName,changeStock);
    	
    	int result = vd.update(vdto);
    	
    	
    	return result ;
    	
    }
    
    public int delete(String drinkName ,String vendor) {
    	
    	Vending vending = new Vending();
    	
    	vending.setDrinkName(drinkName);
    	vending.setVendor(vendor);
    	
    	int result = vd.delete(drinkName,vendor);
    	
    	return result;
    	
    	
    }
    
    
}
