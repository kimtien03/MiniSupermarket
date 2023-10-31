package com.myproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class conndb {
    protected Connection con = null;
    public boolean openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName = SIEUTHIMINI;encrypt=false";
            String username = "sa";
            String password = "1";
            con = DriverManager.getConnection(dbUrl,username,password);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public void closeConnection() {
        try {
            if(con!=null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Connection getConnection() {
        return con;
    }
}
