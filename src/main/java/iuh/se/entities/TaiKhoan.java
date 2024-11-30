package iuh.se.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "taikhoan")
public class TaiKhoan {

    @Id
    @Column(name = "maDangNhap", nullable = false, unique = true, length = 50)
    private String maDangNhap;

    @Column(name = "matKhau", nullable = false)
    private String matKhau;

    @Column(name = "phanQuyen", nullable = false)
    private String phanQuyen;

    public TaiKhoan() {
        super();
    }

    public TaiKhoan(String maDangNhap, String matKhau, String phanQuyen) {
        this.maDangNhap = maDangNhap;
        this.matKhau = matKhau;
        this.phanQuyen = phanQuyen;
    }

    // Getters and Setters
    public String getMaDangNhap() {
        return maDangNhap;
    }

    public void setMaDangNhap(String maDangNhap) {
        this.maDangNhap = maDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(String phanQuyen) {
        this.phanQuyen = phanQuyen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDangNhap);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TaiKhoan other = (TaiKhoan) obj;
        return Objects.equals(maDangNhap, other.maDangNhap);
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "maDangNhap='" + maDangNhap + '\'' +
                ", matKhau='[PROTECTED]'" +  // Không hiển thị mật khẩu
                ", phanQuyen='" + phanQuyen + '\'' +
                '}';
    }
}
