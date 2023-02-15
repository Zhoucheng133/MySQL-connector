package Operations;
import java.sql.*;

import DataBase_Info.DataBase_Info;

public class Write {
    public static void writeToSQL(String tableName, Object... data) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DataBase_Info.getDbName(), DataBase_Info.getSqlName(), DataBase_Info.getSqlPass());

            // Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO " + tableName + " VALUES (";
            for (int i = 0; i < data.length; i++) {
                sql += "'" + data[i] + "'";
                if (i < data.length - 1) {
                    sql += ", ";
                }
            }
            sql += ")";
            stmt.executeUpdate(sql);

            System.out.println("写入成功!");
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
        writeToSQL("userlist", "李四", "123456", "0");
    }
}
