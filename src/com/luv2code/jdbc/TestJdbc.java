package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?" +
                "useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
       String user = "hbstudent";
       String pass = "hbstudent";
        try{

            System.out.println("Connecting to database: " + jdbcURL);

            Connection connection = DriverManager.getConnection(jdbcURL, user, pass);

            System.out.println("Connection successful!");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
