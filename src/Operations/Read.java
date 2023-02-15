package Operations;
import java.sql.*;
import java.util.ArrayList;

import DataBase_Info.DataBase_Info;
class sqlData{
    ArrayList<String[]> data;
    int length;
    int columns;
    public ArrayList<String[]> getData() {
        return data;
    }
    public int getLength() {
        return length;
    }
    public int getColumns() {
        return columns;
    }
    public void setData(ArrayList<String[]> data) {
        this.data = data;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }
    
}

// 注意修改URL，用户和密码，使用时添加表名这样的参数

public class Read {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/"+DataBase_Info.getDbName();
    private static final String USER = DataBase_Info.getSqlName();
    private static final String PASSWORD = DataBase_Info.getSqlPass();

    public static String[][] readFromMySQL(String tableName) {
        sqlData rtData=new sqlData();
        ArrayList<String[]> data = new ArrayList<String[]>();
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            rtData.setColumns(columnCount);
            while (resultSet.next()) {
                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getString(i);
                }
                data.add(row);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println("错误: " + e.getMessage());
        }
        rtData.setLength(data.size());
        rtData.setData(data);

        String[][] array = new String[rtData.data.size()][rtData.columns];
        for (int i = 0; i < rtData.data.size(); i++) {
            for(int j=0;j<rtData.columns;j++){
                array[i][j]=rtData.data.get(i)[j];
            }
        }

        return array;
    }

    public static void print2DArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            String[] row = array[i];
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + "\t");
            }
            System.out.println();
        }
    }    

    public static void main(String[] args) {
        print2DArray(readFromMySQL("userlist"));
    }

}
