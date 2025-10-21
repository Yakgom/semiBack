package com.kh.statement.service;

import java.sql.Connection;
import java.util.List;
import static com.kh.common.JDBCTemplate.*;

import com.kh.statement.model.dao.VendingDao;
import com.kh.statement.model.dto.VendingDTO;
import com.kh.statement.model.vo.Vending;

public class VendingService {

    private VendingDao dao = new VendingDao();
    private Connection conn = null;

    public int save(Vending vending) {
        conn = getConnection();
        int result = dao.save(conn, vending);
        if(result > 0) commit(conn);
        else rollback(conn);
        close(conn);
        return result;
    }

    public List<Vending> findAll() {
        conn = getConnection();
        List<Vending> list = dao.findAll(conn);
        close(conn);
        return list;
    }

    public Vending findByName(String drinkName) {
        conn = getConnection();
        Vending vending = dao.findByName(conn, drinkName);
        close(conn);
        return vending;
    }

    public List<Vending> findByKeyword(String vendor) {
        conn = getConnection();
        List<Vending> list = dao.findByKeyword(conn, vendor);
        close(conn);
        return list;
    }

    public int update(String drinkName, int changeStock) {
        conn = getConnection();
        VendingDTO vd = new VendingDTO(drinkName, changeStock);
        int result = dao.update(conn, vd);
        if(result > 0) commit(conn);
        else rollback(conn);
        close(conn);
        return result;
    }

    public int delete(String drinkName, String vendor) {
        conn = getConnection();
        int result = dao.delete(conn, drinkName, vendor);
        if(result > 0) commit(conn);
        else rollback(conn);
        close(conn);
        return result;
    }
}