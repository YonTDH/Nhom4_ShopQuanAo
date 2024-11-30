package iuh.se.controllers;

import iuh.se.entities.ChiTietHoaDon;
import iuh.se.entities.HoaDon;
import iuh.se.entities.KhachHang;
import iuh.se.entities.NhanVien;
import iuh.se.entities.QuanAo;
import iuh.se.services.ChiTietHoaDonService;
import iuh.se.services.HoaDonService;
import iuh.se.services.KhachHangService;
import iuh.se.services.NhanVienService;
import iuh.se.services.QuanAoService;

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

    @Autowired
    private QuanAoService quanAoService;  // Inject QuanAoService
    
    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;
    @GetMapping
    public String showHoaDonPage(Model model) {
        List<KhachHang> khachHangs = khachHangService.getAllKhachHang();
        List<NhanVien> nhanViens = nhanVienService.findAll();
        List<QuanAo> products = quanAoService.getAllQuanAo(); 

        HoaDon hoaDon = new HoaDon();
        hoaDon.setNgayLapHD(LocalDate.now());  

        model.addAttribute("hoaDon", hoaDon);
        model.addAttribute("khachHangs", khachHangs);
        model.addAttribute("nhanViens", nhanViens);
        model.addAttribute("hoaDons", hoaDonService.getAllHoaDon());
        model.addAttribute("products", products); 

        return "hoadon";
    }


    @PostMapping("/create")
    public String createHoaDon(HoaDon hoaDon, Model model) {
        hoaDon.setNgayLapHD(LocalDate.now());

        hoaDonService.saveHoaDon(hoaDon);

		for (ChiTietHoaDon product : hoaDon.getItems()) {
			quanAoService.updateSoLuong(product.getQuanAo().getMaQuanAo()); 
		}

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
    @PostMapping("/addproduct")
    public String addProductToInvoice(@RequestParam String hoaDonId, @RequestParam String sanPhamId,
                                       @RequestParam Integer soLuong, Model model) {
        // Lấy hóa đơn hiện tại
        HoaDon hoaDon = hoaDonService.getHoaDonById(hoaDonId).orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại!"));

        // Lấy sản phẩm được chọn
        QuanAo quanAo = quanAoService.getQuanAoId(sanPhamId);

        // Tạo chi tiết hóa đơn
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
        chiTietHoaDon.setHoaDon(hoaDon);
        chiTietHoaDon.setQuanAo(quanAo);
        chiTietHoaDon.setSoLuong(soLuong);
        chiTietHoaDon.setDonGia(quanAo.getDonGiaBan());

        // Lưu chi tiết hóa đơn
        chiTietHoaDonService.saveChiTietHoaDon(chiTietHoaDon);

        // Cập nhật danh sách sản phẩm đã thêm
        model.addAttribute("addedProducts", hoaDon.getItems());
        return "redirect:/hoadon/view/" + hoaDonId;
    }
}
