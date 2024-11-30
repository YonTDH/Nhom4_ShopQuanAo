package iuh.se.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChatLieu") // Ánh xạ lớp này tới bảng "ChatLieu" trong cơ sở dữ liệu
public class ChatLieu {

    @Id
    @Column(name = "maChatLieu", nullable = false, length = 10) // Khóa chính
    private String maChatLieu;

    @Column(name = "chatLieu", nullable = false, length = 50) // Tên chất liệu
    private String chatLieu;

	public ChatLieu() {
	}

//	private String auto_ID() {
//		DAO_ChatLieu chatLieu_DAO = new DAO_ChatLieu();
//		String idPrefix = "CL";
//		int length = chatLieu_DAO.getAllChatLieu().size();
//		String finalId = idPrefix + String.format("%06d", length + 1);
//		return finalId;
//	}

	public ChatLieu(String chatLieu) {
		super();
//		this.maChatLieu = auto_ID();
		this.chatLieu = chatLieu;
	}

	public ChatLieu(String maChatLieu, String chatLieu) {
		super();
		this.maChatLieu = maChatLieu;
		this.chatLieu = chatLieu;
	}

	public String getMaChatLieu() {
		return maChatLieu;
	}

	public void setMaChatLieu(String maChatLieu) {
		this.maChatLieu = maChatLieu;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

}
