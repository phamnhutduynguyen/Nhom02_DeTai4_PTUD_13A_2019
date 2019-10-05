package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import entity.KHACHHANG;

public class DAO_KHACHHANG {
	
	public ArrayList<KHACHHANG> getalltbNhanVien() {
		ArrayList<KHACHHANG> dsnv = new ArrayList<KHACHHANG>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("Select * from KHACHHANG");

			while (rs.next()) {
				KHACHHANG nv = new KHACHHANG(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5));	 		
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return dsnv;
	}
}
