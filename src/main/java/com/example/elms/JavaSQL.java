package com.example.elms;

import java.sql.*;

public class JavaSQL {
    public static Connection con;

    public Connection ConnectDB () {

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "Nbhr@1707");
        }
        catch(Exception e){
            System.out.println(e);
        }

        return con;

    }
}
