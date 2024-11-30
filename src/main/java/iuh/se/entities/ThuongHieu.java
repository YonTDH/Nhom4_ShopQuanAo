package iuh.se.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ThuongHieu") // Ánh xạ lớp này tới bảng "ThuongHieu" trong CSDL
public class ThuongHieu {

    @Id
    @Column(name = "maThuongHieu", nullable = false, length = 10) // Khóa chính
    private String maThuongHieu;

    @Column(name = "thuongHieu", nullable = false, length = 50) // Tên thương hiệu
    private String thuongHieu;
	public ThuongHieu() {
	}
//private String auto_ID(){
//    DAO_ThuongHieu thuongHieu_DAO = new DAO_ThuongHieu();
//    String idPrefix = "TH";
//   int length = thuongHieu_DAO.getAllThuongHieu().size();
//   String finalId = idPrefix + String.format("%06d", length + 1);
//   return finalId;
//}

	public ThuongHieu(String thuongHieu) {
		super();
//		this.maThuongHieu = auto_ID();
		this.thuongHieu = thuongHieu;
	}

	public ThuongHieu(String maThuongHieu, String thuongHieu) {
		super();
		this.maThuongHieu = maThuongHieu;
		this.thuongHieu = thuongHieu;
	}

	public String getMaThuongHieu() {
		return maThuongHieu;
	}

	public void setMaThuongHieu(String maThuongHieu) {
		this.maThuongHieu = maThuongHieu;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

}
