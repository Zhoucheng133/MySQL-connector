import Operations.DeleteByCondition;
// import Operations.DeleteByID;
import Operations.Read;
import Operations.Update;
import Operations.Write;

public class App {
    public static void main(String[] args) {
        Write.writeToSQL("userlist", "李四","123456","0");
        Update.updateSQL("userlist", "pass", "1234567", "name='李四'");
        System.out.println("----diving line----");
        Read.print2DArray(Read.readFromMySQL("userlist"));
        // DeleteByID.deleteDataFromTable("userlist", 0);
        DeleteByCondition.deleteDataFromTable("userlist", "name='张三'");
    }
}
