package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import entity.NHANVIEN;
import entity.TAIKHOAN;

public class DAO_NHANVIEN{
	
	public ArrayList<NHANVIEN> getalltbNhanVien() {
		ArrayList<NHANVIEN> dsnv = new ArrayList<NHANVIEN>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("Select * from NHANVIEN");

			while (rs.next()) {
				NHANVIEN nv = new NHANVIEN(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getString(6));	 		
				dsnv.add(nv);	
			}
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return dsnv;
	}
	
}
