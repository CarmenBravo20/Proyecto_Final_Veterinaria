package ec.edu.ups.pweb.Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	public static Connection dbCon(){
		Connection con=null;
		String driver="org.postgresql.Driver";
		String url="jdbc:postgresql://localhost:5432/VeterinariaDB";
		String user="postgres";
		String pass="vinicioc17";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pass);
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
