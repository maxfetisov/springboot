package com.masos.dao;

import com.masos.model.Good;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDAO implements DAO<Good, Integer>{
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
    public void create(Good good){
        String SQL = "INSERT INTO Good(name, price) VALUES('"
                + good.getName() + "', "
                + good.getPrice() + ")";
        try {
            connection.createStatement().executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Good> getAll(){
        List<Good> list = new ArrayList<>();
        String SQL = "SELECT * FROM Good";
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(SQL);
            while (resultSet.next()){
                list.add(new Good(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public Good getById(Integer id){

        String SQL = "SELECT * FROM Good WHERE id =" + id;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(SQL);
            resultSet.next();
            return new Good(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Good good){
        String SQL = "UPDATE Good SET name = '" + good.getName()
                + "', price = " + good.getPrice()
                + " WHERE id = " + good.getId();
        try {
            connection.createStatement().executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id){
        String SQL = "DELETE FROM Good WHERE id = " + id;
        try {
            connection.createStatement().executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
