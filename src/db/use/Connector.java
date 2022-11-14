package db.use;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connector {
    private String databaseName;
    private String username = "sa";
    private String password = "hongson26203_";
    
    private Connection connection;

    public Connector(String databaseName) {
        this.databaseName = databaseName;
        String url = "jdbc:sqlserver://localhost\\KTEAM:1433;databaseName=" + this.databaseName;
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Connection getConnection() {
        return this.connection;
    }
}
