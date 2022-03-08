package lk.ijse.pos_system.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;
    private Connection connection;

    private DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/WholesaleStore",
                "root",
                "Dhana@2001");
    }
    public static DbConnection getInstance() throws ClassNotFoundException, SQLException {
        if (dbConnection==null){
            dbConnection= new DbConnection();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
