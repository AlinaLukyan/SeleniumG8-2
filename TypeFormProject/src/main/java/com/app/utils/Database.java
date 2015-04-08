package com.app.utils;

import oracle.jdbc.pool.OracleDataSource;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 *  Database class provides methods for working with database.
 */
public class Database {
   private Connection connection = null;
   private String jdbcUrl;
   static Logger log = Logger.getLogger(Database.class);
    /*
     *  Constructor opens connection to database using connection string from config.properties file.
     *  Note in config.properties, please, that username and password for access to the database should be named as
     *  relevant connection string including "_USER"  and "_PASSWORD"
     */
    public Database() throws IOException, ClassNotFoundException, SQLException {
        jdbcUrl = ConfigData.getConfigValue("PADB_DB");
        log.info("The JDBC url has been read: " + jdbcUrl);

        // Load driver for JDBC class
//        Class.forName(ConfigData.getConfigValue("Oracle"));

        // Create a connection to the database
        String userName = ConfigData.getConfigValue("PADB_DB_USER");
        String userPassword = ConfigData.getConfigValue("PADB_DB_PASSWORD");
        log.info("Username - " + userName + "; Password - " + userPassword);
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(jdbcUrl);
        ods.setUser(userName);
        ods.setPassword(userPassword);
        connection = ods.getConnection();

        log.info("The connection has been established " + connection);
    }

    /*
     *  That method verifies if the row in the query exists in the database
     */
    public boolean isRowPresent(String query) throws SQLException {

        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm = connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);

        // Calculate number of rows
        int rowNumber = 0;
        while (rSet.next()){
            rowNumber ++;
        }

        stm.close();

        // Verify if the row exists in the table
        if (rowNumber == 0){
            return false;
        } else{
            return true;
        }
    }

    /*
     *  That method gets SQL [Select COLUMN_NAME from TABLE_NAME where ...] query as parameter and returns result as String
     */
    public String selectValue(String query) throws SQLException {
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm = connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);
        ResultSetMetaData meta = rSet.getMetaData();
        
        // Retrieve value from ResultSet
        String value = "";

        if (rSet.next()) {
            if (rSet.getObject(1) != null){
                value=rSet.getObject(1).toString();

                if(meta.getColumnType(1) == 93){
                    value = value.substring(0, value.length() - 2);
                }
            }
        }
        stm.close();
        //System.out.println(query);
        value = value.trim();
        return value;
    }

    /*
     *  That method gets SQL [Select COLUMN_NAME from TABLE_NAME where ...] query as parameter and returns result set as List of Strings
     */
    public List selectResultSet(String query) throws SQLException {
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm = connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);

        // Get ResultSet's meta data
        ResultSetMetaData meta = rSet.getMetaData();

        List<String> resultSet = new ArrayList<String>();

        while (rSet.next()){
            String value = "";

            if (rSet.getObject(1) != null){
                value = rSet.getObject(1).toString();

                if(meta.getColumnType(1) == 93){
                    value = value.substring(0, value.length() - 2);
                }
            }
            value = value.trim();
            resultSet.add(value);
        }
        // Close the statement
        stm.close();
        return resultSet;
    }


    /*
     *  That method gets SQL [Select COLUMN_NAME_1,COLUMN_NAME_2 from TABLE_NAME where ...] query as parameter and returns result set as List of Strings
     */
    public List selectTable(String query) throws SQLException {
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm = connection.createStatement();
        //System.out.println(query);
        ResultSet rSet = stm.executeQuery(query);

        // Get ResultSet's meta data
        ResultSetMetaData meta = rSet.getMetaData();
        int columnNumber = meta.getColumnCount();

        List<ArrayList> resultTable = new ArrayList<ArrayList>();

        // Add column_name's values in the result table header
        ArrayList<String> columnNameSet = new ArrayList<String>();
        columnNameSet.add("");
        for(int i = 0; i < columnNumber; i++){
            columnNameSet.add(meta.getColumnName(i + 1));
        }
        resultTable.add(columnNameSet);

        // Add result rows in the result table
        int resultSize = 0;

        while (rSet.next()){
            ArrayList<String> resultSet = new ArrayList<String>();
            resultSize ++;
            resultSet.add(String.valueOf(resultSize));

            for (int k = 1; k < (columnNumber + 1); k ++){
                String value = "";

                if (rSet.getObject(k) != null){
                    value=rSet.getObject(k).toString();

                    if(meta.getColumnType(k) == 93){
                        value = value.substring(0,value.length() - 2);
                    }
                }
                value = value.trim();
                resultSet.add(value);
            }
            resultTable.add(resultSet);
        }
        // Close the statement
        stm.close();
        return resultTable;
    }

    /*
     *  That method gets SQL [Select count(*) from TABLE_NAME where ...] query as parameter and returns number of rows as Integer
     */
    public int getRowNumber(String query) throws SQLException {
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm = connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);
        ResultSetMetaData meta = rSet.getMetaData();
        // Retrieve value from ResultSet
        int rowCount = 0;

        if (rSet.next()){
            if (rSet.getObject(1) != null){
                rowCount = Integer.parseInt(rSet.getObject(1).toString());
            }
        }
        stm.close();
        return rowCount;
    }

    /*
     *  That method gets SQL [select ..., RAND(185) as IDX from ... where ... ORDER BY IDX FETCH FIRST 1 ROWS ONLY] query as parameter
     *  and returns random value from DB
     */
    public String randDbValue(String query) throws SQLException {
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm = connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);
        ResultSetMetaData meta = rSet.getMetaData();
        // Retrieve value from ResultSet
        String value = "";

        if (rSet.next()) {
            if (rSet.getObject(1) != null) {
                value=rSet.getObject(1).toString();

                if(meta.getColumnType(1) == 93){
                    value=value.substring(0, value.length() - 2);
                }
            }
        }
        stm.close();
        value = value.trim();
        return value;
    }

    /**
     *
     * @throws SQLException
     */
    public void updateDB(String query_for_update) throws SQLException {
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm = connection.createStatement();
        try {
            int affected = stm.executeUpdate(query_for_update);
            log.info(affected + " rows has been updated");
        } catch (Exception e) {
            log.error("DB update has been failed. Exception has been thrown" + e);
        } finally {
            stm.close();
        }
    }

    /*
     *  Close connection to the database
     */
    public void quit() throws SQLException {
        connection.close();
    }
}
