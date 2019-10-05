package entity;

public class NHANVIEN {
	private String MaNV, TenNV;
	private boolean GioiTinh;
	private String CMND, Sdt, ChucVu;
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getTenNV() {
		return TenNV;
	}
	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}
	public boolean isGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getSdt() {
		return Sdt;
	}
	public void setSdt(String sdt) {
		Sdt = sdt;
	}
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}
	public NHANVIEN(String maNV, String tenNV, boolean gioiTinh, String cMND, String sdt, String chucVu) {
		super();
		MaNV = maNV;
		TenNV = tenNV;
		GioiTinh = gioiTinh;
		CMND = cMND;
		Sdt = sdt;
		ChucVu = chucVu;
	}
	public NHANVIEN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NHANVIEN(String maNV) {
		super();
		MaNV = maNV;
	}		
}
