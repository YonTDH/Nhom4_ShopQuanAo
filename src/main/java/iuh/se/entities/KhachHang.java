package iuh.se.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "khachhang")
public class KhachHang {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maKH", nullable = false, unique = true)
    private String maKH;

    @Column(name = "tenKH", nullable = false, length = 100)
    private String tenKH;

    @Column(name = "sDT", nullable = false, length = 15)
    private String sDT;

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;

    @Column(name = "email", length = 100)
    private String email;

    // Constructors
    public KhachHang() {
        super();
    }

    public KhachHang(String tenKH, String sDT, Boolean gioiTinh, String email) {
        this.tenKH = tenKH;
        this.sDT = sDT;
        this.gioiTinh = gioiTinh;
        this.email = email;
    }

    public KhachHang(String maKH, String tenKH, String sDT, Boolean gioiTinh, String email) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sDT = sDT;
        this.gioiTinh = gioiTinh;
        this.email = email;
    }

    // Getters and Setters
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public Boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKH);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        KhachHang other = (KhachHang) obj;
        return Objects.equals(maKH, other.maKH);
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKH='" + maKH + '\'' +
                ", tenKH='" + tenKH + '\'' +
                ", sDT='" + sDT + '\'' +
                ", gioiTinh=" + (gioiTinh ? "Nam" : "Nữ") +
                ", email='" + email + '\'' +
                '}';
    }
}
