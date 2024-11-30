package iuh.se.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NhaCungCap") // Ánh xạ lớp tới bảng "NhaCungCap" trong cơ sở dữ liệu
public class NhaCungCap {

    @Id
    @Column(name = "maNCC", nullable = false, length = 10) // Khóa chính
    private String maNCC;

    @Column(name = "tenNCC", nullable = false, length = 100) // Tên nhà cung cấp
    private String tenNCC;

    @Column(name = "soDienThoai", nullable = false, length = 15) // Số điện thoại
    private String soDienThoai;

    @Column(name = "diaChi", nullable = false, length = 200) // Địa chỉ
    private String diaChi;

    @Column(name = "email", nullable = true, length = 100) // Email (có thể null)
    private String email;
	
//	public String auto_ID(){
//	    DAO_NhaCungCap nhaCungCap_DAO = new DAO_NhaCungCap();
//	     String idPrefix = "NCC";
//	    int length = nhaCungCap_DAO.getAllNCC().size();
//	    String finalId = idPrefix + String.format("%05d", length + 1);
//	    return finalId;
//	}
	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhaCungCap( String tenNCC, String soDienThoai, String diaChi, String email) {
		super();
//		this.maNCC = auto_ID();
		this.tenNCC = tenNCC;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.email = email;
	}
	public NhaCungCap(String maNCC, String tenNCC, String soDienThoai, String diaChi, String email) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.email = email;
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
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
	@Override
	public int hashCode() {
		return Objects.hash(maNCC);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		return Objects.equals(maNCC, other.maNCC);
	}
	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", soDienThoai=" + soDienThoai + ", diaChi="
				+ diaChi + ", email=" + email + "]";
	}
	
	
}