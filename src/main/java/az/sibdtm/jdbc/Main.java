package az.sibdtm.jdbc;


import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args)  {
        ConnectionDb connectionDb=new ConnectionDb();
        try {
            Statement stmt= connectionDb.dbConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
