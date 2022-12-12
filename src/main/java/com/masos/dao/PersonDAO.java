package com.masos.dao;

import com.masos.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements DAO<Person, Integer>{
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
    public void create(Person person){
        String SQL = "INSERT INTO Person (name, login, password, email) VALUES('"
                + person.getName() + "', '"
                + person.getLogin() + "', '"
                + person.getPassword() + "', '"
                + person.getEmail() + "')";
        try {
            connection.createStatement().executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> getAll(){
        List<Person> list = new ArrayList<>();
        String SQL = "SELECT * FROM Person";
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(SQL);
            while (resultSet.next()){
                list.add(new Person(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public Person getById(Integer id){

        String SQL = "SELECT *  FROM Person WHERE id = " + id;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(SQL);
            resultSet.next();
            return new Person(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("email"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Person person){
        String SQL = "UPDATE Person SET name = '" + person.getName()
                + "', login = '" + person.getLogin()
                + "', password = '" + person.getPassword()
                + "', email = '" + person.getEmail()
                + "' WHERE id = " + person.getId();
        try {
            connection.createStatement().executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id){
        String SQL = "DELETE FROM Person WHERE id = " + id;
        try {
            connection.createStatement().executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
