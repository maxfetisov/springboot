package com.masos.dao;

import com.masos.model.Purchase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO implements DAO<Purchase, Integer>{
    private static final String URL = "jdbc:postgresql://localhost:5432/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void create(Purchase purchase){
        String SQL = "INSERT INTO Purchase(personId, goodId) VALUES("
                + purchase.getPersonId() + ", "
                + purchase.getGoodId() + ")";
        try {
            connection.createStatement().executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Purchase> getAll(){
        List<Purchase> list = new ArrayList<>();
        String SQL = "SELECT * FROM Purchase";
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(SQL);
            while (resultSet.next()){
                list.add(new Purchase(resultSet.getInt("number"),
                        resultSet.getInt("personId"),
                        resultSet.getInt("goodId")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public Purchase getById(Integer id){

        String SQL = "SELECT * FROM Purchase WHERE number = " + id;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(SQL);
            resultSet.next();
            return new Purchase(resultSet.getInt("number"),
                    resultSet.getInt("personId"),
                    resultSet.getInt("goodId"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Purchase purchase){
        String SQL = "UPDATE Purchase SET personId = " + purchase.getPersonId()
                + ", goodId = " + purchase.getGoodId()
                + " WHERE number = " + purchase.getNumber();
        try {
            connection.createStatement().executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id){
        String SQL = "DELETE FROM Purchase WHERE number = " + id;
        try {
            connection.createStatement().executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
