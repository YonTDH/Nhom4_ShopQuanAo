package iuh.se.controllers;

import iuh.se.entities.HoaDon;
import iuh.se.entities.KhachHang;
import iuh.se.entities.NhanVien;
import iuh.se.services.HoaDonService;
import iuh.se.services.KhachHangService;
import iuh.se.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/hoadon")
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public String showHoaDonPage(Model model) {
        List<KhachHang> khachHangs = khachHangService.getAllKhachHang();
        List<NhanVien> nhanViens = nhanVienService.findAll();

        model.addAttribute("hoaDon", new HoaDon()); // Đối tượng hoaDon trống để binding form
        model.addAttribute("khachHangs", khachHangs);
        model.addAttribute("nhanViens", nhanViens);
        model.addAttribute("hoaDons", hoaDonService.getAllHoaDon());

        return "hoadon"; 
    }

    @PostMapping("/create")
    public String createHoaDon(HoaDon hoaDon, Model model) {
        hoaDon.setNgayLapHD(LocalDate.now());

        hoaDonService.saveHoaDon(hoaDon);

        model.addAttribute("hoaDons", hoaDonService.getAllHoaDon());

        return "redirect:/hoadon";
    }

    @GetMapping("/search")
    public String searchHoaDon(@RequestParam("keyword") String keyword, Model model) {
        List<HoaDon> hoaDons = hoaDonService.searchByMaHD(keyword);

        model.addAttribute("hoaDons", hoaDons);
        model.addAttribute("keyword", keyword);
        return "hoadon";
    }
}
