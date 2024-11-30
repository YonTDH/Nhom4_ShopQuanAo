package iuh.se.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LoaiQuanAo") // Ánh xạ lớp tới bảng "LoaiQuanAo" trong cơ sở dữ liệu
public class LoaiQuanAo {

    @Id
    @Column(name = "maLoai", nullable = false, length = 10) // Khóa chính
    private String maLoai;

    @Column(name = "loai", nullable = false, length = 50) // Thuộc tính loại quần áo
    private String loai;

	public LoaiQuanAo() {
	}

//private String auto_ID(){
//    DAO_LoaiQuanAo LoaiQuanAo_DAO = new DAO_LoaiQuanAo();
//    String idPrefix = "LQA";
//   int length = LoaiQuanAo_DAO.getAllLoai().size();
//   String finalId = idPrefix + String.format("%05d", length + 1);
//   return finalId;
//}
	public LoaiQuanAo(String loai) {
		super();
//		this.maLoai = auto_ID();
		this.loai = loai;
	}

	public LoaiQuanAo(String maLoai, String loai) {
		super();
		this.maLoai = maLoai;
		this.loai = loai;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

}
