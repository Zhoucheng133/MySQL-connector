package Operations;
import java.sql.*;
import DataBase_Info.DataBase_Info;

public class DeleteByID {
    public static void deleteDataFromTable(String tableName, int id) {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DataBase_Info.getDbName(), DataBase_Info.getSqlName(), DataBase_Info.getSqlPass());
            stmt = con.createStatement();
            String query = "DELETE FROM " + tableName + " WHERE id = " + id;
            stmt.executeUpdate(query);
            System.out.println("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        deleteDataFromTable("tableName", 1);
    }
}
