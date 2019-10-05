package entity;

import java.util.Date;

public class HOADONPHONG {
	private PHONG phong;
	private KHACHHANG khachHang;
	private NHANVIEN nhanVien;
	private Date ngayTra, ngayDat;
	private String tinhTrang;
	public PHONG getPhong() {
		return phong;
	}
	public void setPhong(PHONG phong) {
		this.phong = phong;
	}
	public KHACHHANG getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KHACHHANG khachHang) {
		this.khachHang = khachHang;
	}
	public NHANVIEN getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NHANVIEN nhanVien) {
		this.nhanVien = nhanVien;
	}
	public Date getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public HOADONPHONG(PHONG phong, KHACHHANG khachHang, NHANVIEN nhanVien, Date ngayTra, Date ngayDat,
			String tinhTrang) {
		super();
		this.phong = phong;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayTra = ngayTra;
		this.ngayDat = ngayDat;
		this.tinhTrang = tinhTrang;
	}
	public HOADONPHONG() {
		super();
		// TODO Auto-generated constructor stub
	}		
}
