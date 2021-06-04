package az.sibdtm.jdbc;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.sql.*;
import java.util.Scanner;


public class UserRepo {

    private static PasswordEncoder encoder = new PasswordEncoder();
    boolean answer = false;

    public boolean exsistByUsername(String username) {
        ConnectionDb conn = new ConnectionDb();
        try {
            PreparedStatement statement = conn.dbConnection().prepareStatement("select * from user_table where username=?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
           while (resultSet.next()) {
                answer = true;
            }
            conn.disConnection();
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            conn.disConnection();
        }
        return answer;
    }

    public boolean exsistByEmail(String email) {
        ConnectionDb conn = new ConnectionDb();
        try {
            PreparedStatement statement = conn.dbConnection().prepareStatement("select * from user_table where email=?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                answer = true;
            }
            conn.disConnection();
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            conn.disConnection();
        }
        return answer;
    }

    public boolean exsistByPassword(String username, String password) {
        ConnectionDb conn = new ConnectionDb();
        answer=false;
        try {
            PreparedStatement statement = conn.dbConnection().prepareStatement("select * from user_table where username=?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("password") == encoder.passwordEncoder(password))
                    answer = true;
            }
            conn.disConnection();
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            conn.disConnection();
        }
        return answer;
    }

    public UserDto get(String username) {
        ConnectionDb connectionDb = new ConnectionDb();
        UserDto user = new UserDto();
        try {
            PreparedStatement statement = connectionDb.dbConnection().prepareStatement("Select * from user_table where username=?");
            statement.setString(1, username);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                user.setId(set.getInt("id"));
                user.setName(set.getString("firstname"));
                user.setSurname(set.getString("surname"));
                user.setUsername(set.getString("username"));
                user.setEmail(set.getString("email"));
                user.setExtraEmail(set.getString("extra_email"));
                user.setPassword(set.getString("password"));
                JSONParser parser = new JSONParser();
                user.setPhoneList((JSONObject) parser.parse(set.getString("phones")));
                user.setDate(set.getDate("create_date"));
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void createUser(UserDto entity) {
        ConnectionDb connectionDb = new ConnectionDb();
        System.out.println("save basladi");
        try {
            DatabaseMetaData dbm = connectionDb.dbConnection().getMetaData();
            System.out.println("dbm yaradildi");
            ResultSet tables = dbm.getTables(null, null, "user_table", null);
            System.out.println(" table yoxlanir");
            if (!tables.next()) {
                Statement stmt = connectionDb.dbConnection().createStatement();
                stmt.executeUpdate(
                        "create table user_table (id integer PRIMARY KEY AUTO_INCREMENT," +
                                "firstname char(20) not null," +
                                "surname char(20) not null," +
                                "username char(20) not null unique," +
                                "email char(20) not null unique ," +
                                "extra_email char(20)," +
                                "password char(100)  not null,phones json ," +
                                "create_date date )");
            }

            PreparedStatement preparedStatement = connectionDb
                    .dbConnection()
                    .prepareStatement(
                            "insert into user_table(firstname,surname,username,email,extra_email,password,phones,create_date)" +
                                    "value (?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getSurname());
            preparedStatement.setString(3, entity.getUsername());
            preparedStatement.setString(4, entity.getEmail());
            preparedStatement.setString(5, entity.getExtraEmail());
            preparedStatement.setString(6, encoder.passwordEncoder(entity.getPassword()));
            preparedStatement.setString(7, entity.getPhoneList().toJSONString());
            preparedStatement.setDate(8, entity.getDate());
            preparedStatement.executeUpdate();

            connectionDb.disConnection();
            System.out.println("successful registration");
        } catch (SQLException e) {
            System.out.println("exseption " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String updateUserPassword() {
        Scanner scanner = new Scanner(System.in);
        String answer="username or email is incorrect";
        System.out.print("input username : ");
        String username = scanner.next();
        System.out.print("input email : ");
        String email = scanner.next();
        while (exsistByUsernameAndEmail(username, email)) {
                System.out.print("input password");
                String password = scanner.next();
                System.out.print("input repeat password:");
                String repeatPassword = scanner.next();
                if (password.equals(repeatPassword)) {
                    answer= updatePassword(username, email, encoder.passwordEncoder(password));
                    break;
                } else {
                    System.out.println("passwords do not match");
                }
            }
        return answer ;
    }

    private boolean exsistByUsernameAndEmail(String username, String email) {
        ConnectionDb conn = new ConnectionDb();
        boolean bool=false;
        try {
            PreparedStatement statement = conn
                    .dbConnection()
                    .prepareStatement("select * from user_table where username=? and email=?");
            statement.setString(1, username);
            statement.setString(2, email);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                bool= true;

            }
            conn.disConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }

    private String updatePassword(String username, String email, String password) {
        ConnectionDb connectionDb = new ConnectionDb();
        try {
            PreparedStatement statement = connectionDb
                    .dbConnection()
                    .prepareStatement("update user_table set password=? where username=? and email=?");
            statement.setString(1, password);
            statement.setString(2, username);
            statement.setString(3, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "password updated";
    }
}

