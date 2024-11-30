package iuh.se.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Đánh dấu đây là một thực thể JPA
@Table(name = "MauSac") // Ánh xạ tới bảng MauSac trong CSDL
public class MauSac {

    @Id // Đánh dấu cột khóa chính
    @Column(name = "maMauSac", nullable = false, length = 10) // Ánh xạ tới cột maMauSac
    private String maMauSac;

    @Column(name = "mauSac", nullable = false, length = 50) // Ánh xạ tới cột mauSac
    private String mauSac;

	public MauSac() {
	}
//private String auto_ID(){
//    DAO_MauSac mauSac_DAO = new DAO_MauSac();
//     String idPrefix = "MS";
//    int length = mauSac_DAO.getAllMauSac().size();
//    String finalId = idPrefix + String.format("%06d", length + 1);
//    return finalId;
//}

	public MauSac(String maMauSac, String mauSac) {
		super();
		this.maMauSac = maMauSac;
		this.mauSac = mauSac;
	}

	public MauSac(String mauSac) {
		super();
//		this.maMauSac = auto_ID();
		this.mauSac = mauSac;
	}

	public String getMaMauSac() {
		return maMauSac;
	}

	public void setMaMauSac(String maMauSac) {
		this.maMauSac = maMauSac;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

}
