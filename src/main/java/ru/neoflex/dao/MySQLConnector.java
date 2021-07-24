package ru.neoflex.dao;

import java.sql.*;

public class MySQLConnector {

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testimony?useUnicode=true&serverTimezone=UTC", "root", "148192");
            System.out.println("Successful connection to the DataBase");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error connecting to the DataBase " + e);
        }
        return connection;
    }

    public static ResultSet selectAllFromBilling(String currentmonth) throws SQLException {
        Statement st = getConnection().createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM billing_period WHERE currentmonth = " + currentmonth);
        return resultSet;
    }

    public static ResultSet selectAllFromPriceGuide(int priceGas) throws SQLException {
        Statement st = getConnection().createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM price_guide WHERE priceGas = " + priceGas);
        return resultSet;
    }

    public static ResultSet selectAllFromTestimony_History(String date) throws SQLException {
        Statement st = getConnection().createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM testimony_history WHERE currentmonth = " + date);
        return resultSet;
    }
}
