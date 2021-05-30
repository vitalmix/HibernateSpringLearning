package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class Run {
    public static void main(String[] args) {

        //21 - 1

        String jdbURL = "jdbc:mysql://localhost:3306/starships_shop?useSSL=false&serverTimezone=UTC";
        String user = "stdeveloper";
        String password = "stdeveloper";

        try {

            System.out.println("Connecting to database: " + jdbURL);

            Connection connection = DriverManager.getConnection(jdbURL,user,password);

            System.out.println("Connection is successful!!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
