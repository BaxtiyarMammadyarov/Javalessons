package az.sibdtm.jdbc;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args)  {
        ConnectionDb conn=new ConnectionDb();
        try {
            boolean answer=false;
            PreparedStatement statement=conn.dbConnection().prepareStatement("select * from students where name=?");
            statement.setString(1,"lllll");
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
               answer=true;
                 System.out.println(answer);
            }else System.out.println(answer);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
