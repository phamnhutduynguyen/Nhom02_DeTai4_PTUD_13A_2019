package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import entity.CTHDDV;
import entity.DICHVU;
import entity.HOADONDICHVU;
import entity.NHANVIEN;

public class DAO_CTHDDV {
	public ArrayList<CTHDDV> getalltbCTHDDV() {
		ArrayList<CTHDDV> dsCTHDDV = new ArrayList<CTHDDV>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("Select * from CHITIETHDDV");

			while (rs.next()) {
				CTHDDV cthddv = new CTHDDV(new DICHVU(rs.getString(1)), new HOADONDICHVU(rs.getString(2)), new NHANVIEN(rs.getString(3)));	 		
				dsCTHDDV.add(cthddv);
			}
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return dsCTHDDV;
	}
}
