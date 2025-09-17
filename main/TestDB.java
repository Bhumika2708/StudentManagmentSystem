package main;

import util.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class TestDB {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();
            System.out.println("✅ Connected to database successfully!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed.");
            e.printStackTrace();
        }
    }
}
