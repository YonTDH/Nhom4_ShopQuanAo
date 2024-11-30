package iuh.se.entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@jakarta.persistence.Table(name = "hoadon")
public class HoaDon {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String maHD;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "khachHang_id", nullable = false)
    private KhachHang e_KhachHang;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nhanVien_id", nullable = false)
    private NhanVien e_NhanVien;

    private LocalDate ngayLapHD;

    // Constructors
    public HoaDon() {
    }

    public HoaDon(KhachHang e_KhachHang, NhanVien e_NhanVien, LocalDate ngayLapHD) {
        this.e_KhachHang = e_KhachHang;
        this.e_NhanVien = e_NhanVien;
        this.ngayLapHD = ngayLapHD;
    }

    public HoaDon(String maHD, KhachHang e_KhachHang, NhanVien e_NhanVien, LocalDate ngayLapHD) {
        this.maHD = maHD;
        this.e_KhachHang = e_KhachHang;
        this.e_NhanVien = e_NhanVien;
        this.ngayLapHD = ngayLapHD;
    }

    // Getters and Setters
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public KhachHang getKhachHang() {
        return e_KhachHang;
    }

    public void setKhachHang(KhachHang e_KhachHang) {
        this.e_KhachHang = e_KhachHang;
    }

    public NhanVien getNhanVien() {
        return e_NhanVien;
    }

    public void setNhanVien(NhanVien e_NhanVien) {
        this.e_NhanVien = e_NhanVien;
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
                ", e_KhachHang=" + e_KhachHang +
                ", e_NhanVien=" + e_NhanVien +
                ", ngayLapHD=" + ngayLapHD +
                '}';
    }
}
