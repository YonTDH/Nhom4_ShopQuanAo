package iuh.se.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.se.entities.QuanAo;
import iuh.se.repositories.QuanAoRepository;
import iuh.se.services.QuanAoService;

@Service
public class QuanAoServiceImpl implements QuanAoService {
	@Autowired
	private QuanAoRepository quanAoRepository;

	@Override
	public List<QuanAo> getAllQuanAo() {
		
		return quanAoRepository.findAll();
	}

	@Override
	public void createQuanAo(QuanAo quanAo) {
		quanAoRepository.save(quanAo);
		
	}

	@Override
	public QuanAo getQuanAoId(String id) {
		return quanAoRepository.findById(id).orElseThrow();
	}

	@Override
	public void deleteQuanAo(String id) {
		quanAoRepository.deleteById(id);
		
	}

	@Override
	public List<QuanAo> searchQuanAo(String key) {
		
		return quanAoRepository.searchQuanAo(key);
	}

	@Override
	public void updateQuanAo(QuanAo quanAo) {
	    quanAoRepository.save(quanAo);
		
	}

	@Override
	public void updateSoLuong(String maQuanAo) {
		quanAoRepository.updateSoLuong(maQuanAo);
		
	}
	
	
}
