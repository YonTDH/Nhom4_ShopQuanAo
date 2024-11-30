package iuh.se.entities;

import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class NhanVien {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String maNV;

    private String tenNV;

    private LocalDate ngaySinh;

    private boolean gioiTinh;

    private String sDT;

    private String diaChi;

    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "taiKhoan_id")
    private TaiKhoan taiKhoan;

    // Constructors
    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, LocalDate ngaySinh, boolean gioiTinh, String sDT, String diaChi,
                    String email, TaiKhoan taiKhoan) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sDT = sDT;
        this.diaChi = diaChi;
        this.email = email;
        this.taiKhoan = taiKhoan;
    }

    // Getters and Setters
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    // Format ngày sinh thành chuỗi
    public String getFormattedNgaySinh() {
        return ngaySinh != null ? ngaySinh.toString() : "N/A";
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV='" + maNV + '\'' +
                ", tenNV='" + tenNV + '\'' +
                ", ngaySinh=" + getFormattedNgaySinh() +
                ", gioiTinh=" + (gioiTinh ? "Nam" : "Nữ") +
                ", sDT='" + sDT + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", email='" + email + '\'' +
                ", taiKhoan=" + taiKhoan +
                '}';
    }
}
