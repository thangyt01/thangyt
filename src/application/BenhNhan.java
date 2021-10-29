package application;

public class BenhNhan {
	private String HoTen;
	private int NamSinh;
	private String GioiTinh;
	private int MaBHYT;
	private String SDT;
	private String DiaChi;

	
	public BenhNhan() {
		// TODO Auto-generated constructor stub
	}


	public BenhNhan(String hoTen, int tuoi, String gioiTinh, int maBHYT, String sDT, String diaChi) {
		super();
		HoTen = hoTen;
		NamSinh = tuoi;
		GioiTinh = gioiTinh;
		MaBHYT = maBHYT;
		SDT = sDT;
		DiaChi = diaChi;
	}


	public String getHoTen() {
		return HoTen;
	}


	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}


	public int getNamSinh() {
		return NamSinh;
	}


	public void setNamSinh(int tuoi) {
		NamSinh = tuoi;
	}


	public String getGioiTinh() {
		return GioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}


	public int getMaBHYT() {
		return MaBHYT;
	}


	public void setMaBHYT(int maBHYT) {
		MaBHYT = maBHYT;
	}


	public String getSDT() {
		return SDT;
	}


	public void setSDT(String sDT) {
		SDT = sDT;
	}


	public String getDiaChi() {
		return DiaChi;
	}


	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
	public String toString() {
		return HoTen + "\n" + NamSinh + "\n" + GioiTinh + "\n" + MaBHYT + "\n" + SDT + "\n" + DiaChi;
	}


	
}
