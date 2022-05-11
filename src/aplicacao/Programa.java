package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.cj.xdevapi.PreparableStatement;

import jdbcteste.DB;

public class Programa {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE seller"
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "DepartmentId = ? ");
			st.setDouble(1, 700.0);
			st.setInt(2, 4);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Pronto! Rows Affected: " + rowsAffected);			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	
	}
	
	
}
