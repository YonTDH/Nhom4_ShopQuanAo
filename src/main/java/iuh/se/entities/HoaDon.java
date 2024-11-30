
package iuh.se.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@jakarta.persistence.Table(name = "hoadon")
public class HoaDon {

    @Id
    private String maHD;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "maKH", nullable = false)
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "maNV", nullable = false)
    private NhanVien nhanVien;

    private LocalDate ngayLapHD;
    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietHoaDon> items; 
    // Constructors
    
    public HoaDon() {
    }

    public HoaDon(KhachHang e_KhachHang, NhanVien e_NhanVien, LocalDate ngayLapHD) {
        this.khachHang = e_KhachHang;
        this.nhanVien = e_NhanVien;
        this.ngayLapHD = ngayLapHD;
    }

    public HoaDon(String maHD, KhachHang e_KhachHang, NhanVien e_NhanVien, LocalDate ngayLapHD) {
        this.maHD = maHD;
        this.khachHang = e_KhachHang;
        this.nhanVien = e_NhanVien;
        this.ngayLapHD = ngayLapHD;
    }

    // Getters and Setters
    public String getMaHD() {
        return maHD;
    }
    
    public List<ChiTietHoaDon> getItems() {
		return items;
	}

	public void setItems(List<ChiTietHoaDon> items) {
		this.items = items;
	}

	public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang e_KhachHang) {
        this.khachHang = e_KhachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien e_NhanVien) {
        this.nhanVien = e_NhanVien;
    }

    public LocalDate getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(LocalDate ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "maHD='" + maHD + '\'' +
                ", e_KhachHang=" + khachHang +
                ", e_NhanVien=" + nhanVien +
                ", ngayLapHD=" + ngayLapHD +
                '}';
    }
}
