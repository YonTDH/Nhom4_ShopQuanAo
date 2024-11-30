package iuh.se.entities;


public class ChiTietHoaDon {
	private HoaDon hoaDon;
	private QuanAo quanAo;
	private int soLuong;
	private double donGia;
	public ChiTietHoaDon() {
		super();
	}
	public ChiTietHoaDon(HoaDon e_HoaDon, QuanAo e_QuanAo, int soLuong, double donGia) {
		super();
		this.hoaDon = e_HoaDon;
		this.quanAo = e_QuanAo;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon e_HoaDon) {
		this.hoaDon = e_HoaDon;
	}
	public QuanAo getQuanAo() {
		return quanAo;
	}
	public void setQuanAo(QuanAo e_QuanAo) {
		this.quanAo = e_QuanAo;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", quanAo=" + quanAo + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ "]";
	}
	
	
	
}
