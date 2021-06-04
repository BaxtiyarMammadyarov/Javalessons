package az.sibdtm.jdbc;

import java.sql.*;

public class Service {
   private static ConnectionDb conn=new ConnectionDb();
    boolean answer=false;
    public boolean exsistByUsername(String username){
       try {
           PreparedStatement statement=conn.dbConnection().prepareStatement("select * from user where user.username=?");
           statement.setString(1,username);
           ResultSet resultSet=statement.executeQuery();
           if(resultSet.next()){
               answer=true;
           }
           conn.disConnection();
       } catch (SQLException e) {
           System.out.println(e.getSQLState());
           conn.disConnection();
       }
        return answer;
    }
    public boolean exsistByEmail(String email){
        try {
            PreparedStatement statement=conn.dbConnection().prepareStatement("select * from user where user.email=?");
            statement.setString(1,email);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                answer=true;
            }
            conn.disConnection();
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            conn.disConnection();
        }
        return answer;
    }
    public static void save(UserEntity entity){

        try {
            DatabaseMetaData dbm = conn.dbConnection().getMetaData();
            ResultSet tables = dbm.getTables(null, null, "user", null);
            if (!tables.next()) {
             PreparedStatement Stmt=conn
                     .dbConnection()
                     .prepareStatement(
                             "create table user (id integer PRIMARY KEY AUTO_INCREMENT," +
                                     "name varchar(20) not null," +
                                     "surname varchar(20) not null," +
                                     "username varchar(20) not null unique," +
                                     "email varchar(20) not null unique ," +
                                     "extra_email varchar(20)," +
                                     "password varchar (100) not null ," +
                                     "phone set ," +
                                     "create_date data default current_date)");
            }
            PreparedStatement preparedStatement=conn
                    .dbConnection()
                    .prepareStatement(
                            "insert into user(name,surname,username,email,extra_email,password,phone,create_date)" +
                                    "value (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,entity.getName());
            preparedStatement.setString(2,entity.getSurname());
            preparedStatement.setString(3,entity.getUsername());
            preparedStatement.setString(4,entity.getEmail());
            preparedStatement.setString(5,entity.getExtraEmail());

            preparedStatement.setString(6,entity.getPassword());

            preparedStatement.setArray(7, (Array) entity.getPhoneList());

            preparedStatement.setDate(8, (Date) entity.getDate());



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
