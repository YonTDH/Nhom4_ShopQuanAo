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
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
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

    @GetMapping("/list")
    public String showHoaDonList(Model model) {
        List<HoaDon> hoaDons = hoaDonService.getAllHoaDon();
        model.addAttribute("hoaDons", hoaDons);
        return "hoadon/list"; // This should match the path to your list.html file
    }
    
    @GetMapping("/success")
    public String showSuccessPage(Model model) {
        return "hoadon/success";  
    }


    @GetMapping("/search")
    public String searchHoaDon(@RequestParam("keyword") String keyword, Model model) {
        List<HoaDon> hoaDons = hoaDonService.searchByMaHD(keyword);

        model.addAttribute("hoaDons", hoaDons);
        model.addAttribute("keyword", keyword);
        return "hoadon";
        }
    
    @PostMapping("/addproduct")
    public List<ChiTietHoaDon> addProductToInvoice(@RequestParam("hoaDonId") String hoaDonId,
                                                   @RequestParam("sanPhamId") String sanPhamId,
                                                   @RequestParam("soLuong") int soLuong) {

        // Lấy hóa đơn và sản phẩm từ database
        HoaDon hoaDon = hoaDonService.getHoaDonById(hoaDonId);
        QuanAo quanAo = quanAoService.getQuanAoId(sanPhamId);

        // Kiểm tra nếu hóa đơn hoặc sản phẩm không tồn tại
        if (hoaDon == null || quanAo == null) {
            throw new IllegalArgumentException("Hóa đơn hoặc sản phẩm không tồn tại");
        }

        // Kiểm tra số lượng sản phẩm có hợp lệ không
        if (soLuong > quanAo.getSoLuong()) {
            throw new IllegalArgumentException("Số lượng sản phẩm vượt quá tồn kho");
        }

        // Tạo chi tiết hóa đơn mới
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
        chiTietHoaDon.setHoaDon(hoaDon);
        chiTietHoaDon.setQuanAo(quanAo);
        chiTietHoaDon.setSoLuong(soLuong);
        chiTietHoaDon.setDonGia(quanAo.getDonGiaBan());  // Đơn giá sản phẩm

        // Thêm chi tiết hóa đơn vào hóa đơn
        hoaDon.getItems().add(chiTietHoaDon);

        // Cập nhật số lượng sản phẩm trong kho
        quanAoService.updateSoLuong(sanPhamId);

        // Cập nhật tổng tiền của hóa đơn
        hoaDon.setTongTien(hoaDon.getItems().stream().mapToDouble(item -> item.getDonGia() * item.getSoLuong()).sum());

        // Lưu hóa đơn sau khi cập nhật
        hoaDonService.saveHoaDon(hoaDon);

        // Trả về danh sách chi tiết hóa đơn
        return hoaDon.getItems();
    }


}
