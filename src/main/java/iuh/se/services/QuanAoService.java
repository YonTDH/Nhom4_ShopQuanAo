package iuh.se.services;

import java.util.List;

import iuh.se.entities.QuanAo;

public interface QuanAoService {
	List<QuanAo> getAllQuanAo();

	void createQuanAo(QuanAo quanAo);

	QuanAo getQuanAoId(String id);

	void deleteQuanAo(String id);

    List<QuanAo> searchQuanAo(String key);
    
    void updateQuanAo(QuanAo quanAo);
    
    void updateSoLuong(String maQuanAo);
    
    
     
}
