package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import entity.DICHVU;

public class DAO_DICHVU {
	public ArrayList<DICHVU> getalltbDichVu() {
		ArrayList<DICHVU> dsnv = new ArrayList<DICHVU>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("Select * from DICHVU");

			while (rs.next()) {
				DICHVU nv = new DICHVU(rs.getString(1), rs.getString(2), rs.getDouble(3));	 		
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return dsnv;
	}
}
