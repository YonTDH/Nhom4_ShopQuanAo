package iuh.se.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "chitiethoadon")
public class ChiTietHoaDon {
	    @Id
    private String maCTHD;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "maHD", nullable = false)
    private HoaDon hoaDon; 

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "maQuanAo", nullable = false)
    private QuanAo quanAo;  

    @Column(name = "soLuong", nullable = false)
    private int soLuong;  

    @Column(name = "donGia", nullable = false)
    private double donGia; 
    
    
    
    public ChiTietHoaDon() {
        super();
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public QuanAo getQuanAo() {
        return quanAo;
    }

    public void setQuanAo(QuanAo quanAo) {
        this.quanAo = quanAo;
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
}
