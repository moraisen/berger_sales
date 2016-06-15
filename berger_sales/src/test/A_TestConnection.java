package test;

import java.sql.Connection;
import java.sql.SQLException;

import berger_sales.CustomerException;
import connection.OracleConnection;

public class A_TestConnection{
	public static void main(String[] args)
		{

			try { 
				OracleConnection oracon = new OracleConnection();
				oracon.open();
				Connection con = oracon.getConnection();
				System.out.println(con.getMetaData().getDatabaseMajorVersion());
				oracon.close();
			}
			catch (CustomerException | SQLException e) 
				{
					System.out.println(e.getMessage());
				}
		}


}
