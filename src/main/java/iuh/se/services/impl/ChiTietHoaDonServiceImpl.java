package iuh.se.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.se.entities.ChiTietHoaDon;
import iuh.se.repositories.ChiTietHoaDonRepository;
import iuh.se.services.ChiTietHoaDonService;

@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {
	@Autowired
	private ChiTietHoaDonRepository chiTietHoaDonRepository;

	@Override
	public ChiTietHoaDon saveChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		return chiTietHoaDonRepository.save(chiTietHoaDon);
	}

}
