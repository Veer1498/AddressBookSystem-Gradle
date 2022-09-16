package com.addressbook;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DBDemo {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String username = "root";
        String password = "veer";
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");

        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find Driver !!"+e);
        }
        listDrivers();
        try{
            System.out.println("Connecting to Database "+jdbcURL);
            con = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connection is Successful !!!!"+con);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverlist = DriverManager.getDrivers();
        while (driverlist.hasMoreElements()){
            Driver driverClass = (Driver) driverlist.nextElement();
            System.out.println("  "+driverClass.getClass().getName());
        }
    }
}
