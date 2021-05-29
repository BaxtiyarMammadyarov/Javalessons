package az.sibdtm.jdbc;

import java.sql.*;


public class ConnectionDb {
    private final String className = "com.mysql.cj.jdbc.Driver";
    private final String urldb = "jdbc:mysql://localhost:3306/";
    private final String userName = "root";
    private final String password = "root";
    private final String dbname = "java_backend_course";
    private Connection conn = null;



    public  Connection dbConnection() {

        if (conn == null) {
            try {
                Class.forName(className);
                conn = DriverManager.getConnection(urldb + dbname.toLowerCase(), userName, password);
                return conn;

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public void disConnection() {
        try {
            conn.close();
            System.out.println("cinnectin close");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConnectionDb connectionDb=new ConnectionDb();
        connectionDb.dbConnection();
    }

}
