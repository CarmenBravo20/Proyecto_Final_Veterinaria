package ec.edu.ups.pweb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.Stateless;


import ec.edu.ups.pweb.Business.Conectar;
import ec.edu.ups.pweb.MODEL.Cliente;


@Stateless
public class LoginDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean OptenerLogin(Cliente cli) throws SQLException {
		String jpql = "Select * from Cliente where email=? and password=?";
		con = Conectar.dbCon();

		ps = con.prepareStatement(jpql);
		ps.setString(1, cli.getEmail());
		ps.setString(2, cli.getPassword());

		rs = ps.executeQuery();

		if (rs.next()) {
			return true;
		}
		return false;
	}

	public boolean VerificarUser(Cliente cli) throws SQLException {
		String jpql = "Select * from Cliente where nombre=? and email=?";
		con = Conectar.dbCon();

		ps = con.prepareStatement(jpql);
		ps.setString(1, cli.getNombre());
		ps.setString(2, cli.getEmail());

		rs = ps.executeQuery();

		if (!rs.next()) {
			return true;
		}
		return false;
	}
	
	
}