package day240612.practice.me;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", args[0]);
        System.out.println("Connected to database");

        Statement stmt = connection.createStatement();
        String selectSql = "select id, name, balance from user;";
        ResultSet rs = stmt.executeQuery(selectSql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int balance = rs.getInt("balance");
            System.out.println(id + "\t" + name + "\t" + balance);
        }

        System.out.println("=== === ===");

        String insertSql = "insert into user(name, balance) values(?, ?);";
        PreparedStatement ppstmt = connection.prepareStatement(insertSql);
        ppstmt.setString(1, "alex__");
        ppstmt.setInt(2, 90);
        ppstmt.executeUpdate();
    }
}
