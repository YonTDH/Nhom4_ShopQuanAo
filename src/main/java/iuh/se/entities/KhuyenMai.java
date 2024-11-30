package iuh.se.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//import dao.DAO_KhuyenMai;


@Entity
@Table(name = "KhuyenMai") // Ánh xạ lớp tới bảng "KhuyenMai" trong cơ sở dữ liệu
public class KhuyenMai {

    @Id
    @Column(name = "maKM", nullable = false, length = 10) // Khóa chính
    private String maKM;

    @Temporal(TemporalType.DATE) // Chỉ định kiểu dữ liệu ngày tháng
    @Column(name = "ngayBatDau", nullable = false) // Ngày bắt đầu không được null
    private Date ngayBatDau;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngayKetThuc", nullable = false) // Ngày kết thúc không được null
    private Date ngayKetThuc;

    @Column(name = "mucGiamGia", nullable = false) // Mức giảm giá không được null
    private Double mucGiamGia;
	
//	private String auto_ID(){
//       DAO_KhuyenMai dao_khuyenMai = new DAO_KhuyenMai();
//       String idPrefix = "KM";
//       int length = dao_khuyenMai.getAllKhuyenMai().size();
//       String finalId = idPrefix + String.format("%06d", length + 1);
//       return finalId;
//   }
	

	public KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
	}


	public KhuyenMai( Date ngayBatDau, Date ngayKetThuc, Double mucGiamGia) {
		super();
//		this.maKM = auto_ID();
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.mucGiamGia = mucGiamGia;
	}
	public KhuyenMai(String maKM, Date ngayBatDau, Date ngayKetThuc, Double mucGiamGia) {
		super();
		this.maKM = maKM;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.mucGiamGia = mucGiamGia;
	}
	
	public String getMaKM() {
		return maKM;
	}
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public Double getMucGiamGia() {
		return mucGiamGia;
	}
	public void setMucGiamGia(Double mucGiamGia) {
		this.mucGiamGia = mucGiamGia;
	}

	public double tinhTienKhuyenMai(double giaBan){
		double giaTienKM = 0;
        
        giaTienKM = giaBan * this.mucGiamGia / 100;
        
        return giaTienKM;
    }
	@Override
	public String toString() {
		return "KhuyenMai [maKM=" + maKM + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc
				+ ", mucGiamGia=" + mucGiamGia + ", soLuong="  + "]";
	}
	
}