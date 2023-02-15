package Operations;
import java.sql.*;

import DataBase_Info.DataBase_Info;

public class Update {
    public static void updateSQL(String tableName, String columnName, Object newValue, String condition) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DataBase_Info.getDbName(), DataBase_Info.getSqlName(), DataBase_Info.getSqlPass());

            // Execute a query
            stmt = conn.createStatement();
            String sql = "UPDATE " + tableName + " SET " + columnName + " = '" + newValue + "' WHERE " + condition;
            stmt.executeUpdate(sql);

            System.out.println("更新成功!");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        updateSQL("userlist", "pass", "1234567", "name='张三'");
    }
}