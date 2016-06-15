package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import berger_sales.CustomerException;

public class OracleConnection
	{
		private Connection con;
		public OracleConnection() throws CustomerException
			{
				try 
					{ 
						Class.forName("oracle.jdbc.OracleDriver");
						open();
					}
				catch (ClassNotFoundException e) {
					throw new CustomerException("Could not find driver!");				}
				
			}
		
		public void open() throws CustomerException {
			try 
				{
					con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "mathias", "oracle");
					con.setAutoCommit(false);
				}
			catch (SQLException e) {
				throw new CustomerException("SQL Connect fehler");
			}
		}
		public void close() throws CustomerException {
			try 
				{
					con.close();
					
				}
			catch (SQLException e) {
				throw new CustomerException("Could not close connection!");
				
			}
		}
		public Connection getConnection()
		{
			return con;
		}


	}
