/*
 * Eder Mazariegos
 * COP3330
 * Fall 2016
 */
package inputOutput;

import inputOutput.ConnectionData;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author eder
 */
public class PostgreSQLConnect
{
    //declaring our connection
    Connection connect = null;
    
    public PostgreSQLConnect(ConnectionData data)
    {
        try
        {
            //get login data and process it
           Class.forName(data.getType());
           connect = DriverManager.getConnection(data.toString(), data.getLogin(), data.getPassword());
           
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        //made it this far, opened the database
        System.out.println("Opened database successfully");
    }
    
    public Connection getConnection()
    {
        return connect;
    }
    
}
