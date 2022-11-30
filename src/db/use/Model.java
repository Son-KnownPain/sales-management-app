package db.use;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {
    protected Connection connection;
    protected String tableName;
    protected int numOfColumn;
    protected String tableNameNotS;
    
    public Model(String tableName, int numOfColumn) {
        this.connection = new Connector("SalesManagement").getConnection();
        this.tableName = tableName;
        this.numOfColumn = numOfColumn;
        this.tableNameNotS = tableName.substring(0, tableName.length() - 1);
    }
    
    public ArrayList<String[]> run(int numOfColumn, String sqlStatement) {
        ArrayList<String[]> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                String[] fields = new String[numOfColumn];
                for (int i = 0; i < numOfColumn; i++) {
                    fields[i] = rs.getString(i + 1);
                }
                result.add(fields);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<String[]> selectAll() {
        ArrayList<String[]> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM " + tableName;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                String[] fields = new String[numOfColumn];
                for (int i = 0; i < numOfColumn; i++) {
                    fields[i] = rs.getString(i + 1);
                }
                result.add(fields);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<String[]> selectWithCondition(String condition) {
        ArrayList<String[]> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM " + tableName + " WHERE " + condition;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                String[] fields = new String[numOfColumn];
                for (int i = 0; i < numOfColumn; i++) {
                    fields[i] = rs.getString(i + 1);
                }
                result.add(fields);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<String[]> selectSorted(String columnName, String typeSort) {
        ArrayList<String[]> result = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM %s ORDER BY %s %s", tableName, columnName, typeSort);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                String[] fields = new String[numOfColumn];
                for (int i = 0; i < numOfColumn; i++) {
                    fields[i] = rs.getString(i + 1);
                }
                result.add(fields);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<String[]> select(String after) {
        ArrayList<String[]> result = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM %s %s", tableName, after);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                String[] fields = new String[numOfColumn];
                for (int i = 0; i < numOfColumn; i++) {
                    fields[i] = rs.getString(i + 1);
                }
                result.add(fields);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<String[]> select(String column, int numOfColumn, String after) {
        ArrayList<String[]> result = new ArrayList<>();
        try {
            String query = String.format("SELECT %s FROM %s %s", column, tableName, after);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                String[] fields = new String[numOfColumn];
                for (int i = 0; i < numOfColumn; i++) {
                    fields[i] = rs.getString(i + 1);
                }
                result.add(fields);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean insertOne(String values) {
        try {
            String query = String.format("INSERT INTO %s VALUES (%s);", tableName, values);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int insertResult = preparedStatement.executeUpdate();
            
            if (insertResult == 1) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean updateByID(String columnUpdate, int id) {
        try {
            String query = String.format("UPDATE %s SET %s WHERE %s = %d", tableName, columnUpdate, tableNameNotS + "ID", id);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int updateResult = preparedStatement.executeUpdate();
            
            if (updateResult == 1) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean update(String columnUpdate, String condition) {
        try {
            String query = String.format("UPDATE %s SET %s WHERE %s", tableName, columnUpdate, condition);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int updateResult = preparedStatement.executeUpdate();
            
            if (updateResult >= 1) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean deleteByID(int id) {
        try {
            String query = String.format("DELETE FROM %s WHERE %s = %d", tableName, tableNameNotS + "ID", id);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int updateResult = preparedStatement.executeUpdate();
            
            if (updateResult == 1) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(String condition) {
        try {
            String query = String.format("DELETE FROM %s WHERE %s", tableName, condition);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int updateResult = preparedStatement.executeUpdate();
            
            if (updateResult == 1) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
