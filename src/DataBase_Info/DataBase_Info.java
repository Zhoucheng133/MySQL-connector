package DataBase_Info;

public class DataBase_Info {
    // 数据库的用户和密码
    // Mysql username and password
    static private String sqlName="root";
    static private String sqlPass="12345678";
    // 数据库的名称
    // Database name
    static String dbName="graduassign";
    // Getters
    public static String getSqlName() {
        return sqlName;
    }
    public static String getSqlPass() {
        return sqlPass;
    }
    public static String getDbName() {
        return dbName;
    }
}
