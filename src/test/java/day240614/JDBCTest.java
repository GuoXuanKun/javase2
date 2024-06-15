package day240614;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * CREATE TABLE `user` (
 *     `id` int(11) PRIMARY KEY AUTO_INCREMENT,
 *     `name` varchar(255) DEFAULT NULL,
 *     `balance` int(11) DEFAULT NULL
 * );
 */
public class JDBCTest {
    static Connection connection;

    @BeforeAll
    public static void getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2", "root", "你自己设定的密码");
        System.out.println(connection.getClass().getName());
        System.out.println("JDBCTest.getConnection");
    }

    @Test
    public void testStatement() {
        String query = "select id, name, balance from user;";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int balance = rs.getInt("balance");
                System.out.println(id + "\t" + name + "\t" + balance);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    @Test
    public void testPreparedStatement() {
        String query = "select id, name, balance from user where id = ?";
        try (PreparedStatement pStmt = connection.prepareStatement(query)) {
            pStmt.setInt(1, 1);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int balance = rs.getInt("balance");
                System.out.println(id + "\t" + name + "\t" + balance);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    @Test
    public void insert() {
        String insertSql = "insert into user(name, balance) values(?, ?);";
        try (PreparedStatement pStmt = connection.prepareStatement(insertSql)) {
            pStmt.setString(1, "alex");
            pStmt.setInt(2, 50);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    @Test
    public void batchInsert() {
        String insertSql = "insert into user(name, balance) values(?, ?);";
        try (PreparedStatement pStmt = connection.prepareStatement(insertSql)) {

            pStmt.setString(1, "alex");
            pStmt.setInt(2, 50);
            pStmt.addBatch();

            pStmt.setString(1, "bob");
            pStmt.setInt(2, 30);
            pStmt.addBatch();

            pStmt.executeBatch();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    @Test
    public void update() {
        String updateSql = "update user set balance = balance + 5 where name = ?";
        try (PreparedStatement pStmt = connection.prepareStatement(updateSql)) {
            pStmt.setString(1, "alex");
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    @Test
    public void delete() {
        String updateSql = "delete from user where name = ?";
        try (PreparedStatement pStmt = connection.prepareStatement(updateSql)) {
            pStmt.setString(1, "alex");
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    @Test
    @SuppressWarnings({"all"})
    public void testWithoutTransactions() {
        PreparedStatement ppstmt1 = null;
        PreparedStatement ppstmt2 = null;
        String update1 = "update user set balance = balance - 10 where id = ?";
        String update2 = "update user set balance = balance + 10 where id = ?";

        try {
            ppstmt1 = connection.prepareStatement(update1);
            ppstmt1.setInt(1, 1);
            ppstmt1.executeUpdate();

            int i = 2 / 0;

            ppstmt2 = connection.prepareStatement(update2);
            ppstmt2.setInt(1, 2);
            ppstmt2.executeUpdate();
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            try {
                if (ppstmt1 != null) {
                    ppstmt1.close();
                }
                if (ppstmt2 != null) {
                    ppstmt2.close();
                }
            } catch (SQLException e) {
                System.out.println("finally 中又遇到了 SQLException: " + e.getMessage());
            }
        }
    }

    @Test
    @SuppressWarnings({"all"})
    public void testWithTransactions() {
        PreparedStatement ppstmt1 = null;
        PreparedStatement ppstmt2 = null;
        String update1 = "update user set balance = balance - 10 where id = ?";
        String update2 = "update user set balance = balance + 10 where id = ?";

        try {
            connection.setAutoCommit(false);

            ppstmt1 = connection.prepareStatement(update1);
            ppstmt1.setInt(1, 1);
            ppstmt1.executeUpdate();

            int i = 2 / 0;

            ppstmt2 = connection.prepareStatement(update2);
            ppstmt2.setInt(1, 2);
            ppstmt2.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println("rollback SQLException: " + e.getMessage());
            }
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            try {
                if (ppstmt1 != null) {
                    ppstmt1.close();
                }
                if (ppstmt2 != null) {
                    ppstmt2.close();
                }
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("finally 中又遇到了 SQLException: " + e.getMessage());
            }
        }
    }

    @AfterAll
    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("JDBCTest.close");
    }
}
