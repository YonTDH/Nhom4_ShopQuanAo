package iuh.se.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iuh.se.entities.HoaDon;
import iuh.se.entities.KhachHang;
import iuh.se.entities.NhanVien;
import iuh.se.repositories.HoaDonRepository;
import iuh.se.services.HoaDonService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Override
    public List<HoaDon> getAllHoaDon() {
        return hoaDonRepository.findAll();
    }

    @Override
    public Optional<HoaDon> getHoaDonById(String id) {
        return hoaDonRepository.findById(id);
    }

    @Override
    public HoaDon saveHoaDon(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public void deleteHoaDon(String id) {
        hoaDonRepository.deleteById(id);
    }

    @Override
    public List<HoaDon> findByKhachHang(KhachHang khachHang) {
        return hoaDonRepository.findByKhachHang(khachHang);
    }

    @Override
    public List<HoaDon> findByNhanVien(NhanVien nhanVien) {
        return hoaDonRepository.findByNhanVien(nhanVien);
    }

    @Override
    public List<HoaDon> findByNgayLapHD(LocalDate ngayLapHD) {
        return hoaDonRepository.findByNgayLapHD(ngayLapHD);
    }

    @Override
    public List<HoaDon> findByDateRange(LocalDate startDate, LocalDate endDate) {
        return hoaDonRepository.findByNgayLapHDBetween(startDate, endDate);
    }

    @Override
    public List<HoaDon> findByKhachHangAndDateRange(KhachHang khachHang, LocalDate startDate, LocalDate endDate) {
        return hoaDonRepository.findByKhachHangAndNgayLapHDBetween(khachHang, startDate, endDate);
    }

    @Override
    public List<HoaDon> findByNhanVienAndDateRange(NhanVien nhanVien, LocalDate startDate, LocalDate endDate) {
        return hoaDonRepository.findByNhanVienAndNgayLapHDBetween(nhanVien, startDate, endDate);
    }

    @Override
    public long countByKhachHang(KhachHang khachHang) {
        return hoaDonRepository.countByKhachHang(khachHang);
    }

    @Override
    public long countByNhanVien(NhanVien nhanVien) {
        return hoaDonRepository.countByNhanVien(nhanVien);
    }

    @Override
    public List<HoaDon> searchByMaHD(String keyword) {
        return hoaDonRepository.searchByMaHD(keyword);
    }

    @Override
    public List<HoaDon> findByTenKhachHang(String tenKH) {
        return hoaDonRepository.findByTenKhachHang(tenKH);
    }

    @Override
    public List<HoaDon> findByTenNhanVien(String tenNV) {
        return hoaDonRepository.findByTenNhanVien(tenNV);
    }
}