package entity;

public class TAIKHOAN {
	private String ma, tentk, mk;

	public TAIKHOAN(String ma, String tentk, String mk) {
		super();
		this.ma = ma;
		this.tentk = tentk;
		this.mk = mk;
	}

	public TAIKHOAN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTentk() {
		return tentk;
	}

	public void setTentk(String tentk) {
		this.tentk = tentk;
	}

	public String getMk() {
		return mk;
	}

	public void setMk(String mk) {
		this.mk = mk;
	}
	
}
