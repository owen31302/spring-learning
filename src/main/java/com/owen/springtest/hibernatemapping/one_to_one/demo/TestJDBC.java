package com.owen.springtest.hibernatemapping.one_to_one.demo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author yuchlin on 3/18/19
 */
public class TestJDBC {

    public static void main(String[] args){

        // -------- Test connecting to the schema --------
        //                                           /<schema name>
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent"; //TODO: how to save your password? Maybe from file

        try{
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!!!");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
