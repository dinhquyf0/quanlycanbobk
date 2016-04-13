/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Model.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author DINHQUY
 */
public class ChangeView extends javax.swing.JFrame {
    String s ="";
    private DefaultTableModel model;
    /**
     * Creates new form ChangeView
     */
    public ChangeView() {
        initComponents();
        model = new DefaultTableModel();
        BindingCBxNam();
        BindingCBxNgay();
        BindingCBxThang();
    }
    public ChangeView(String sn){
        s =sn;
        initComponents();
        model = new DefaultTableModel();
    }
    
    
    public void BindingCBxNam(){
        for(int years=Calendar.getInstance().get(Calendar.YEAR);years >= 1950;years--){
            Cbx_NamSinh_CB.addItem(years);
            CBx_Nam_Ctac.addItem(years);
            Cbx_NamSinh_Con.addItem(years);
            Cbx_Nam_Luong_TGBD.addItem(years);
            Cbx_Nam_DangPhi.addItem(years);
            Cbx_Nam_ChamThi.addItem(years);
            Cbx_Nam_ChucDanh.addItem(years);
            Cbx_Nam_ChucVu.addItem(years);
            Cbx_Nam_DoanPhi.addItem(years);
            Cbx_Nam_CongDoanPhi.addItem(years);
            Cbx_Nam_GiaoTrinh.addItem(years);
            Cbx_Nam_NCKH_TGKT.addItem(years);
            CBx_Nam_NCKH_TGBD.addItem(years);
            Cbx_Nam_BB.addItem(years);
       }
    }
    
    public void BindingCBxThang(){
        for(int month = 1;month <= 12;month++){
            Cbx_ThangSinh_CB.addItem(month);
            CBx_Thang_Ctac.addItem(month);
            Cbx_Thang_Luong_TGBD.addItem(month);
            Cbx_Thang_DangPhi.addItem(month);
            Cbx_Thang_ChamThi.addItem(month);
            Cbx_Thang_ChucDanh.addItem(month);
            Cbx_Thang_ChucVu.addItem(month);
            Cbx_Thang_DoanPhi.addItem(month);
            Cbx_Thang_CongDoanPhi.addItem(month);
            Cbx_Thang_NCKH_TGKT.addItem(month);
            Cbx_Thang_NCKH_TGBD.addItem(month);
            Cbx_Thang_baiBao.addItem(month);
            
       }
    }
    
    public void BindingCBxNgay(){
        for(int date = 1 ; date<=31;date++){
            Cbx_NgaySinh_CB.addItem(date);
            CBx_Ngay_Ctac.addItem(date);
            CBx_Ngay_Luong_TGBD.addItem(date);
            Cbx_Ngay_DangPhi.addItem(date);
            Cbx_Ngay_ChamThi.addItem(date);
            Cbx_Ngay_ChucDanh.addItem(date);
            Cbx_Ngay_ChucVu.addItem(date);
            Cbx_Ngay_DoanPhi.addItem(date);
            Cbx_Ngay_CongDoanPhi.addItem(date);
            Cbx_Ngay_NCKH_TGKT.addItem(date);
            Cbx_Ngay_NCKH_TGBD.addItem(date);
       }
    }
    
    public void BindingMaMH(ArrayList<GiangDay> listgd){
        for(GiangDay gd : listgd){
            CB_Ma_MH.addItem(gd.getMa_MH());
            Cbx_MaMH_ChamThi.addItem(gd.getMa_MH());
        }
    }
    
    public void BindingMaNCKH(ArrayList<NghienCuuKhoaHoc> listnckh){
        for(NghienCuuKhoaHoc nckh : listnckh){
            CB_Ma_DTai.addItem(nckh.getMa_DT());
        }
    }
    
    public void BindingMaGD(ArrayList<GiaDinh> listgd){
        for(GiaDinh gd : listgd){
            CB_Ma_GD.addItem(gd.getMa_GD());
        }
    }
    
    public void BindingMaBB(ArrayList<BaiBaoTapChi> listbb){
        for(BaiBaoTapChi bb : listbb){
            CB_MaBB.addItem(bb.getMa_BaiBao());
        }
    }
    
    public void BindingMaGT(ArrayList<GiaoTrinh> listgt){
        for(GiaoTrinh gt : listgt){
            CB_Ma_GTrinh.addItem(gt.getMa_GT());
        }
    }
    
    public void BindingMaCB(ArrayList<CanBo> listcbo) {
        for (CanBo cb : listcbo) {
            CB_MaCB_GDinh.addItem(cb.getMa_CB());
            CB_MaCB_BB.addItem(cb.getMa_CB());
            CB_MaCB_NCKH.addItem(cb.getMa_CB());
            CB_MaCB_DoanVien.addItem(cb.getMa_CB());
            CB_MaCb_DangVien.addItem(cb.getMa_CB());
            CB_MaCB_Gday.addItem(cb.getMa_CB());
            CB_MaCB_Luong.addItem(cb.getMa_CB());
            Cb_MaCB_CDV.addItem(cb.getMa_CB());
            CB_MaCB_GiaoTrinh.addItem(cb.getMa_CB());
            CB_MaCB_ChamThi.addItem(cb.getMa_CB());
            CB_MaCB_Gday.addItem(cb.getMa_CB());
            CBx_MaCB_ChucVu.addItem(cb.getMa_CB());
            CBx_MaCB_ChucDanh.addItem(cb.getMa_CB());
        }
    }
    
    public void BindingChucDanh(Vector data){
        Vector clums = new Vector();
        clums.add("Số thứ tự");
        clums.add("Mã Cán Bộ");
        clums.add("Tên cán bộ");
        clums.add("Chức danh");
        clums.add("Thời gian nhận");
        model.setColumnIdentifiers(clums);
        DefaultTableModel model = new DefaultTableModel(data, clums);
        ChucDanh_TBL.setModel(model);
    }
    
    public void BindingChucVu(Vector data){
        Vector clums = new Vector();
        clums.add("Số thứ tự");
        clums.add("Mã Cán Bộ");
        clums.add("Tên cán bộ");
        clums.add("Chức vụ nhận");
        clums.add("Thời gian nhận");
        model.setColumnIdentifiers(clums);
        DefaultTableModel model = new DefaultTableModel(data, clums);
        ChucVu_TBL.setModel(model);
    }
    
    public void BindingGV_GiangDay(Vector data){
        Vector clums = new Vector();
        clums.add("Số Thứ tự");
        clums.add("Mã giảng viên");
        clums.add("Tên giảng viên");
        clums.add("Mã môn học");
        model.setColumnIdentifiers(clums);
        DefaultTableModel model = new DefaultTableModel(data, clums);
        CB_GDay_TBL.setModel(model);
    }
    
    public void BindingChamThi(Vector data){
        Vector clums = new Vector();
        clums.add("Mã chấm thi");
        clums.add("Mã Lớp");
        clums.add("Mã cán bộ");
        clums.add("Tên cán bộ");
        clums.add("Mã Môn Học");
        clums.add("Ngày Nộp");
        clums.add("Số Bài Thi");
        model.setColumnIdentifiers(clums);
        DefaultTableModel model = new DefaultTableModel(data, clums);
        Chamthi_TBL.setModel(model);
    }
    
    public void BindingGiangVien_GT(Vector data){
        Vector clums = new Vector();
        clums.add("Số Thứ tự");
        clums.add("Mã cán bộ");
        clums.add("Tên cán bộ");
        clums.add("Mã giáo trình");
        model.setColumnIdentifiers(clums);
        DefaultTableModel model = new DefaultTableModel(data, clums);
        CB_GiaoTrinh_TBL.setModel(model);
    }
    
    public void BindingGiangVien_BBTC(Vector data){
        Vector clums = new Vector();
        clums.add("Số Thứ tự");
        clums.add("Mã cán bộ");
        clums.add("Tên cán bộ");
        clums.add("Mã bài báo");
        model.setColumnIdentifiers(clums);
        DefaultTableModel model = new DefaultTableModel(data, clums);
        CB_BB_TBL.setModel(model);
    }
    
    public void BindingGiangVien_NCKH(Vector data){
        
        Vector clums = new Vector();
        clums.add("Số Thứ Tự");
        clums.add("Mã cán bộ");
        clums.add("Tên cán bộ");
        clums.add("Mã đề tài");
        model.setColumnIdentifiers(clums);
        DefaultTableModel model = new DefaultTableModel(data, clums);
        GV_NCKH_TBL.setModel(model);
    }
    
    public void BindingCanBo_GiaDinh(Vector data){
        
        Vector clums = new Vector();
        clums.add("Số Thứ Tự");
        clums.add("Mã cán bộ");
        clums.add("Tên cán bộ");
        clums.add("Mã gia đình");
        model.setColumnIdentifiers(clums);
        DefaultTableModel model = new DefaultTableModel(data, clums);
        CB_GD_TBL.setModel(model);
    }
    
    public void BindingGiaoTrinh(Vector data){
        Vector clums = new Vector();
        
        clums.add("Mã Giáo Trình");
        clums.add("Tên Giáo Trình");
        clums.add("Tên Tác Giả");
        clums.add("Năm Xuất Bản");
        clums.add("Nhà Xuất Bản");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data,clums);
        GiaoTrinh_TBL.setModel(model);
    }
    
    public void BindingCongDoanPhi(Vector data){
        Vector clums = new Vector();
        
        clums.add("Số Thứ Tự");
        clums.add("Mã Cán Bộ");
        clums.add("Tên Cán Bộ");
        clums.add("Số Tiền Đóng");
        clums.add("Thời Gian Đóng");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data,clums);
        CongDoanPhi_TBL.setModel(model);
    }
    
    public void BindingDoanPhi(Vector data){
        Vector clums = new Vector();
        
        clums.add("Số Thứ Tự");
        clums.add("Mã Cán Bộ");
        clums.add("Tên Cán Bộ");
        clums.add("Số Tiền Đóng");
        clums.add("Thời Gian Đóng");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data,clums);
        DoanPhi_TBL.setModel(model);
    }
    
    public void BindingDangPhi(Vector data){
        Vector clums = new Vector();
        
        clums.add("Số Thứ Tự");
        clums.add("Mã Cán Bộ");
        clums.add("Tên Cán Bộ");
        clums.add("Số Tiền Đóng");
        clums.add("Thời Gian Đóng");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data,clums);
        DangPhi_TBL.setModel(model);
    }
    
    public void BindingLuong(Vector data){
        Vector clums = new Vector();
        
        clums.add("Số Thứ Tự");
        clums.add("Mã Cán Bộ");
        clums.add("Tên Cán Bộ");
        clums.add("Hệ Số Lương");
        clums.add("Thời Gian Bắt Đầu");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data,clums);
        Luong_TBL.setModel(model);
    }
    
    public void BindingNCKH(Vector data){
        
        Vector clums = new Vector();
        
        clums.add("Mã Đề Tài");
        clums.add("Tên Đề Tài");
        clums.add("Cấp");
        clums.add("Kinh Phí");
        clums.add("Thời Gian Bắt Đầu");
        clums.add("Thời Gian Kết Thúc");
        clums.add("Chủ Trì Đề Tài");
        clums.add("Tình Trạng");
        clums.add("Kết Quả");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data,clums);
        NCKH_TBL.setModel(model);
    }
    
    public void BindingBB(Vector data){
        
        Vector clums = new Vector();
        clums.add("Mã Tạp Chí");
        clums.add("Tên Tạp Chí");
        clums.add("Số");
        clums.add("Thời Gian Xuất Bản");
        clums.add("Chỉ Số ISSN");
        clums.add("Hệ Số IF");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data,clums);
        BaiBao_TBL.setModel(model);
    }
    
    public void BindingGD(Vector data){
        
        Vector clums = new Vector();
        clums.add("Số thứ tự");
        clums.add("Mã Gia Đình");
        clums.add("Họ Tên Con");
        clums.add("Năm Sinh");
        clums.add("Thành Tích");
        
        model.setColumnIdentifiers(clums);
        DefaultTableModel model = new DefaultTableModel(data, clums);
        GiaDinhTBL.setModel(model);
    }
            
    public void BindingCanBo(Vector data) {
        Vector clums = new Vector();
        clums.add("Mã Cán Bộ");
        clums.add("Tên Đăng Nhập");
        clums.add("Họ và Tên");
        clums.add("Ngày Sinh");
        clums.add("Giới Tính");
        clums.add("Nơi Công Tác");
        clums.add("Thời gian bắt đầu công tác");
        clums.add("Trình Độ");
        clums.add("Số Tài Khoản");
        clums.add("Mã Số Thuế");
        clums.add("Địa Chỉ");
        clums.add("Số Điện Thoại");
        clums.add("Email");
        clums.add("Thành Tích");
        clums.add("Thông Tin Khác");

                
        model.setColumnIdentifiers(clums);
        DefaultTableModel model = new DefaultTableModel(data, clums);
        CanBo_TBL.setModel(model);
    }
    
    public void BindingGday(Vector data){
        Vector clums = new Vector();
        clums.add("Mã Môn Học");
        clums.add("Tên Môn Học");
        clums.add("Số Tín Chỉ");
        clums.add("Lớp");
        clums.add("Số Sinh Viên");
        clums.add("Học Kỳ");
        clums.add("Năm Học");
        clums.add("Phụ Cấp Giảng Dạy");
                
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data, clums);
        GDayBTL.setModel(model);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        AddCbBtn = new javax.swing.JButton();
        UpdateCbBtn = new javax.swing.JButton();
        DelCbBtn = new javax.swing.JButton();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        TxtMaSoThue = new javax.swing.JTextField();
        TxtSoTaiKhoan = new javax.swing.JTextField();
        TxtDiaChi = new javax.swing.JTextField();
        TxtSoDienThoai = new javax.swing.JTextField();
        TxtEmail = new javax.swing.JTextField();
        TxtThanhTich = new javax.swing.JTextField();
        TxtThongTinKhac = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TxtCanBoID = new javax.swing.JTextField();
        TxtTenDangNhap = new javax.swing.JTextField();
        TxtTenCanBo = new javax.swing.JTextField();
        Cbx_NamSinh_CB = new javax.swing.JComboBox();
        Cbx_ThangSinh_CB = new javax.swing.JComboBox();
        Cbx_NgaySinh_CB = new javax.swing.JComboBox();
        Rbtn_Nam = new javax.swing.JRadioButton();
        RBtn_Nu = new javax.swing.JRadioButton();
        CBx_Nam_Ctac = new javax.swing.JComboBox();
        TxtNoiCongTac = new javax.swing.JTextField();
        CBx_Thang_Ctac = new javax.swing.JComboBox();
        CBx_Ngay_Ctac = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        Rbtn_DangVien = new javax.swing.JRadioButton();
        RBtn_CongDoanVien = new javax.swing.JRadioButton();
        RBtn_DoanVien = new javax.swing.JRadioButton();
        Cbx_TrinhDo = new javax.swing.JComboBox();
        jScrollPane19 = new javax.swing.JScrollPane();
        CanBo_TBL = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        GiaDinhTBL = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        CB_GD_TBL = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        addGDBtn = new javax.swing.JButton();
        UpdateGDBtn = new javax.swing.JButton();
        DelGDBtn = new javax.swing.JButton();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        TxtMa_GD = new javax.swing.JTextField();
        Cbx_NamSinh_Con = new javax.swing.JComboBox();
        TxtThanhTichCon = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        TxtStt_GD = new javax.swing.JTextField();
        TxtTenCon = new javax.swing.JTextField();
        RBtn_GD = new javax.swing.JRadioButton();
        jPanel23 = new javax.swing.JPanel();
        RBtn_CBGD = new javax.swing.JRadioButton();
        jLabel78 = new javax.swing.JLabel();
        TxtStt_CBGD = new javax.swing.JTextField();
        CB_MaCB_GDinh = new javax.swing.JComboBox();
        TxtTen_CBGiaDinh = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        CB_Ma_GD = new javax.swing.JComboBox();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        ChucVu_TBL = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        Txt_STT_ChucVu = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        CBx_MaCB_ChucVu = new javax.swing.JComboBox();
        jLabel98 = new javax.swing.JLabel();
        Txt_TenCB_ChucVu = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        Txt_ChucVu = new javax.swing.JTextField();
        Cbx_Ngay_ChucVu = new javax.swing.JComboBox();
        Cbx_Thang_ChucVu = new javax.swing.JComboBox();
        Cbx_Nam_ChucVu = new javax.swing.JComboBox();
        jPanel32 = new javax.swing.JPanel();
        AddChucVu_Btn = new javax.swing.JButton();
        UpdateChucVu_Btn = new javax.swing.JButton();
        DelChucVu_Btn = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        ChucDanh_TBL = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        Txt_tenCB_ChucDanh = new javax.swing.JTextField();
        CBx_MaCB_ChucDanh = new javax.swing.JComboBox();
        Txt_Stt_ChucDanh = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        Txt_ChucDanh = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        Cbx_Ngay_ChucDanh = new javax.swing.JComboBox();
        Cbx_Thang_ChucDanh = new javax.swing.JComboBox();
        Cbx_Nam_ChucDanh = new javax.swing.JComboBox();
        jPanel34 = new javax.swing.JPanel();
        AddChucDanh_Btn = new javax.swing.JButton();
        UpdateChucDanh_Btn = new javax.swing.JButton();
        DelChucDanh_Btn = new javax.swing.JButton();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Luong_TBL = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        TxtSoTTLuong = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        CB_MaCB_Luong = new javax.swing.JComboBox();
        jLabel50 = new javax.swing.JLabel();
        TxtHeSoLuong = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        CBx_Ngay_Luong_TGBD = new javax.swing.JComboBox();
        Cbx_Thang_Luong_TGBD = new javax.swing.JComboBox();
        Cbx_Nam_Luong_TGBD = new javax.swing.JComboBox();
        jLabel49 = new javax.swing.JLabel();
        TxtTen_CBLuong = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        Txt_TrinhDo_Luong = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        AddLuongBtn = new javax.swing.JButton();
        UpdateLuongBtn = new javax.swing.JButton();
        DelLuongBtn = new javax.swing.JButton();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        DoanPhi_TBL = new javax.swing.JTable();
        jPanel29 = new javax.swing.JPanel();
        Cbx_Nam_DoanPhi = new javax.swing.JComboBox();
        TxtSoTienDong_DoanVien = new javax.swing.JTextField();
        Cbx_Thang_DoanPhi = new javax.swing.JComboBox();
        Cbx_Ngay_DoanPhi = new javax.swing.JComboBox();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        Txt_TenCanBo_DoanVien = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        CB_MaCB_DoanVien = new javax.swing.JComboBox();
        TxtStt_DoanVien = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        DelDoanVienBtn = new javax.swing.JButton();
        UpdateDoanVienBtn = new javax.swing.JButton();
        AddDoanVienBtn = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        CongDoanPhi_TBL = new javax.swing.JTable();
        jPanel28 = new javax.swing.JPanel();
        TxtSoTienDong_CDV = new javax.swing.JTextField();
        Cbx_Nam_CongDoanPhi = new javax.swing.JComboBox();
        Cbx_Thang_CongDoanPhi = new javax.swing.JComboBox();
        Cbx_Ngay_CongDoanPhi = new javax.swing.JComboBox();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        TxtTenCb_CDV = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        Cb_MaCB_CDV = new javax.swing.JComboBox();
        TxtSoThuTuCongDoanVien = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        AddCDVBtn = new javax.swing.JButton();
        UpdateCDVBtn = new javax.swing.JButton();
        DelCDVBtn = new javax.swing.JButton();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        DangPhi_TBL = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        Cbx_Ngay_DangPhi = new javax.swing.JComboBox();
        Cbx_Thang_DangPhi = new javax.swing.JComboBox();
        Cbx_Nam_DangPhi = new javax.swing.JComboBox();
        TxtSoTienDongDangVien = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        TxtTen_CBDangVien = new javax.swing.JTextField();
        CB_MaCb_DangVien = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        TxtSttDangVien = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        AddDangPhiBtn = new javax.swing.JButton();
        UpdateDangPhiBtn = new javax.swing.JButton();
        DelDangPhiBtn = new javax.swing.JButton();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        Chamthi_TBL = new javax.swing.JTable();
        jPanel38 = new javax.swing.JPanel();
        DelChamThi_Btn = new javax.swing.JButton();
        UpdateChamThi_Btn = new javax.swing.JButton();
        AddChamThi_Btn = new javax.swing.JButton();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        TxtMa_Lop = new javax.swing.JTextField();
        TxtMa_ChamThi = new javax.swing.JTextField();
        CB_MaCB_ChamThi = new javax.swing.JComboBox();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        TxtTen_CB_ChamThi = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        TxtSoBaiThi = new javax.swing.JTextField();
        Cbx_Ngay_ChamThi = new javax.swing.JComboBox();
        Cbx_Thang_ChamThi = new javax.swing.JComboBox();
        Cbx_Nam_ChamThi = new javax.swing.JComboBox();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        Cbx_MaMH_ChamThi = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        NCKH_TBL = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        GV_NCKH_TBL = new javax.swing.JTable();
        jPanel44 = new javax.swing.JPanel();
        RBtn_GV_NCKH = new javax.swing.JRadioButton();
        jLabel87 = new javax.swing.JLabel();
        Txt_Stt_NCKH = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        CB_MaCB_NCKH = new javax.swing.JComboBox();
        jLabel37 = new javax.swing.JLabel();
        TxtTen_CBNCKH = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        CB_Ma_DTai = new javax.swing.JComboBox();
        jPanel45 = new javax.swing.JPanel();
        AddNCKHBtn = new javax.swing.JButton();
        UpdateNCKHBtn = new javax.swing.JButton();
        DelNCKHBtn = new javax.swing.JButton();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        RBtn_NCKH = new javax.swing.JRadioButton();
        jLabel38 = new javax.swing.JLabel();
        Txt_MaDT = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        Cbx_Ngay_NCKH_TGKT = new javax.swing.JComboBox();
        Cbx_Thang_NCKH_TGKT = new javax.swing.JComboBox();
        Cbx_Nam_NCKH_TGKT = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        TxtTenDT = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        TxtCap = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        TxtKinhPhi = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        Cbx_Ngay_NCKH_TGBD = new javax.swing.JComboBox();
        Cbx_Thang_NCKH_TGBD = new javax.swing.JComboBox();
        CBx_Nam_NCKH_TGBD = new javax.swing.JComboBox();
        TxtChuTri = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        TxtTinhTrang = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        TxtKetQua = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        BaiBao_TBL = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        CB_BB_TBL = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        RBtn_CB_BB = new javax.swing.JRadioButton();
        jLabel42 = new javax.swing.JLabel();
        Txt_Stt_BB = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CB_MaCB_BB = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        TxtTen_CBBB = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        CB_MaBB = new javax.swing.JComboBox();
        jPanel36 = new javax.swing.JPanel();
        RBtn_BBao = new javax.swing.JRadioButton();
        TxtMaBaiBao = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        TxtTenTapChi = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        TxtSo = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        Cbx_Nam_BB = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        TxtChiSoISSN = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        TxtHeSoIF = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        Cbx_Thang_baiBao = new javax.swing.JComboBox();
        jPanel37 = new javax.swing.JPanel();
        AddBBBtn = new javax.swing.JButton();
        UpdateBBBtn = new javax.swing.JButton();
        DelBBBtn = new javax.swing.JButton();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        GDayBTL = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        CB_GDay_TBL = new javax.swing.JTable();
        jPanel43 = new javax.swing.JPanel();
        AddGDyBtn = new javax.swing.JButton();
        DelGDyBtn = new javax.swing.JButton();
        UpdateGDyBtn = new javax.swing.JButton();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        TxtPhuCap = new javax.swing.JTextField();
        TxtNamHoc = new javax.swing.JTextField();
        TxtHocKy = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        TxtSoSinhVien = new javax.swing.JTextField();
        TxtLop = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        TxtSoTinChi = new javax.swing.JTextField();
        TxtTenMon = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        TxtMa_MH = new javax.swing.JTextField();
        RBtn_GDay = new javax.swing.JRadioButton();
        jLabel101 = new javax.swing.JLabel();
        TxtSoGioDay = new javax.swing.JTextField();
        jPanel48 = new javax.swing.JPanel();
        CB_Ma_MH = new javax.swing.JComboBox();
        jLabel94 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        TxtTen_GV = new javax.swing.JTextField();
        CB_MaCB_Gday = new javax.swing.JComboBox();
        jLabel59 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        Txt_STT_CB_GDay = new javax.swing.JTextField();
        RBtn_CB_GDay = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        GiaoTrinh_TBL = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        CB_GiaoTrinh_TBL = new javax.swing.JTable();
        jPanel41 = new javax.swing.JPanel();
        RBtn_CB_GTrinh = new javax.swing.JRadioButton();
        jLabel93 = new javax.swing.JLabel();
        Txt_Stt_CBGTrinh = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        CB_MaCB_GiaoTrinh = new javax.swing.JComboBox();
        jLabel91 = new javax.swing.JLabel();
        Txt_TenCB_GTrinh = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        CB_Ma_GTrinh = new javax.swing.JComboBox();
        jPanel42 = new javax.swing.JPanel();
        TxtNhaXuatBan = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        Cbx_Nam_GiaoTrinh = new javax.swing.JComboBox();
        TxtTenTacGia = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        TxtTenGiaoTrinh = new javax.swing.JTextField();
        TxtMa_GT = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        RBtn_GiaoTrinh = new javax.swing.JRadioButton();
        jPanel40 = new javax.swing.JPanel();
        AddGiaoTrinhBtn = new javax.swing.JButton();
        UpdateGiaoTrinhBtn = new javax.swing.JButton();
        DelGiaoTrinhBtn = new javax.swing.JButton();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        Print_Btn = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý");

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1360, 720));

        jPanel11.setPreferredSize(new java.awt.Dimension(1332, 663));

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel18.setPreferredSize(new java.awt.Dimension(125, 301));

        AddCbBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        AddCbBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddCbBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCbBtnActionPerformed(evt);
            }
        });

        UpdateCbBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateCbBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateCbBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateCbBtnActionPerformed(evt);
            }
        });

        DelCbBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelCbBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelCbBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelCbBtnActionPerformed(evt);
            }
        });

        jLabel109.setText("Thêm thông tin");

        jLabel110.setText("Xóa thông tin");

        jLabel111.setText("Cập nhật thông tin");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(UpdateCbBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(DelCbBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddCbBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel111))
                .addGap(27, 27, 27))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddCbBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateCbBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelCbBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DelCbBtn, UpdateCbBtn});

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel19.setPreferredSize(new java.awt.Dimension(802, 301));

        jLabel8.setText("Mã Số Thuế ");

        jLabel9.setText("Số Tài Khoản");

        jLabel10.setText("Địa Chỉ");

        jLabel11.setText("Số Điện Thoại");

        jLabel12.setText("Email");

        jLabel13.setText("Thành Tích");

        jLabel14.setText("Thông Tin Khác");

        Cbx_NamSinh_CB.setEditable(true);
        Cbx_NamSinh_CB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        Cbx_NamSinh_CB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_ThangSinh_CB.setEditable(true);
        Cbx_ThangSinh_CB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng" }));
        Cbx_ThangSinh_CB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_NgaySinh_CB.setEditable(true);
        Cbx_NgaySinh_CB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngày" }));
        Cbx_NgaySinh_CB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Rbtn_Nam.setText("Nam");
        Rbtn_Nam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rbtn_Nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rbtn_NamActionPerformed(evt);
            }
        });

        RBtn_Nu.setText("Nữ");
        RBtn_Nu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RBtn_Nu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBtn_NuActionPerformed(evt);
            }
        });

        CBx_Nam_Ctac.setEditable(true);
        CBx_Nam_Ctac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        CBx_Nam_Ctac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        CBx_Thang_Ctac.setEditable(true);
        CBx_Thang_Ctac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng" }));
        CBx_Thang_Ctac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        CBx_Ngay_Ctac.setEditable(true);
        CBx_Ngay_Ctac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngày" }));
        CBx_Ngay_Ctac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setText("Mã Cán Bộ   (* )  ");

        jLabel5.setText("Tên Đăng Nhập (*)");

        jLabel2.setText("Tên Cán Bộ");

        jLabel4.setText("Ngày Sinh ");

        jLabel6.setText("Giới Tính");

        jLabel7.setText("Nơi Công Tác");

        jLabel107.setText("Thời gian bắt đầu công tác");

        jLabel108.setText("Trình Độ");

        Rbtn_DangVien.setText("Đảng viên");
        Rbtn_DangVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rbtn_DangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rbtn_DangVienActionPerformed(evt);
            }
        });

        RBtn_CongDoanVien.setText("Công đoàn viên");
        RBtn_CongDoanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        RBtn_DoanVien.setText("Đoàn viên");
        RBtn_DoanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RBtn_DoanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBtn_DoanVienActionPerformed(evt);
            }
        });

        Cbx_TrinhDo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "THPT", "Cao đẳng", "Đại học", "Thạc sĩ", "Tiến sĩ", "Phó giáo sư", "Giáo sư", "Kỹ sư", "Cử nhân", "Chuyên viên" }));
        Cbx_TrinhDo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel107)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(Rbtn_DangVien))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtCanBoID, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTenCanBo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(Cbx_NgaySinh_CB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cbx_ThangSinh_CB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cbx_NamSinh_CB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TxtNoiCongTac, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(Rbtn_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(RBtn_Nu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(RBtn_DoanVien)
                        .addGap(45, 45, 45)
                        .addComponent(RBtn_CongDoanVien))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(CBx_Ngay_Ctac, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CBx_Thang_Ctac, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CBx_Nam_Ctac, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel108))
                .addGap(24, 24, 24)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtThongTinKhac)
                    .addComponent(TxtMaSoThue, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(TxtSoTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(TxtDiaChi)
                    .addComponent(TxtSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(TxtEmail)
                    .addComponent(TxtThanhTich)
                    .addComponent(Cbx_TrinhDo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TxtDiaChi, TxtEmail, TxtMaSoThue, TxtSoDienThoai, TxtSoTaiKhoan, TxtThanhTich, TxtThongTinKhac});

        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TxtCanBoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxtTenCanBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Cbx_NgaySinh_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cbx_ThangSinh_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cbx_NamSinh_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(Rbtn_Nam)
                            .addComponent(RBtn_Nu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Rbtn_DangVien)
                            .addComponent(RBtn_CongDoanVien)
                            .addComponent(RBtn_DoanVien))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtNoiCongTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TxtMaSoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TxtSoTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(TxtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(TxtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(TxtThanhTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtThongTinKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel107)
                        .addComponent(CBx_Ngay_Ctac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CBx_Thang_Ctac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CBx_Nam_Ctac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel108)
                        .addComponent(Cbx_TrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CanBo_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        CanBo_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CanBo_TBLMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(CanBo_TBL);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 1320, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Cán Bộ", jPanel5);

        GiaDinhTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        GiaDinhTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GiaDinhTBLMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(GiaDinhTBL);

        CB_GD_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        CB_GD_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_GD_TBLMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(CB_GD_TBL);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel20.setPreferredSize(new java.awt.Dimension(125, 300));

        addGDBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        addGDBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addGDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGDBtnActionPerformed(evt);
            }
        });

        UpdateGDBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateGDBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateGDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateGDBtnActionPerformed(evt);
            }
        });

        DelGDBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelGDBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelGDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelGDBtnActionPerformed(evt);
            }
        });

        jLabel112.setText("Thêm thông tin");

        jLabel113.setText("Cập nhật thông tin");

        jLabel114.setText("Xóa người dùng");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(addGDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel112))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DelGDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UpdateGDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addGDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateGDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelGDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DelGDBtn, UpdateGDBtn, addGDBtn});

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin Gia Đình", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel21.setPreferredSize(new java.awt.Dimension(729, 301));

        Cbx_NamSinh_Con.setEditable(true);
        Cbx_NamSinh_Con.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        Cbx_NamSinh_Con.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel19.setText("Thành Tích");

        jLabel18.setText("Năm Sinh");

        jLabel17.setText("Họ Tên Con");

        jLabel15.setText("Mã Gia Đình");

        jLabel77.setText("Số thứ tự(*)");

        RBtn_GD.setText("Gia Đình");
        RBtn_GD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBtn_GD)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel77, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtThanhTichCon, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(TxtStt_GD, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(Cbx_NamSinh_Con, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtMa_GD, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(TxtTenCon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(342, Short.MAX_VALUE))
        );

        jPanel21Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TxtMa_GD, TxtStt_GD, TxtThanhTichCon});

        jPanel21Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel15, jLabel17, jLabel18, jLabel19, jLabel77});

        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RBtn_GD)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(TxtStt_GD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(TxtMa_GD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(TxtTenCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(Cbx_NamSinh_Con, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(TxtThanhTichCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin Cán Bộ - Gia Đình", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        RBtn_CBGD.setText("Cán Bộ - Gia Đình");
        RBtn_CBGD.setActionCommand("Cán Bộ  Gia Đình");
        RBtn_CBGD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RBtn_CBGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBtn_CBGDActionPerformed(evt);
            }
        });

        jLabel78.setText("Số thứ tự(*)");

        CB_MaCB_GDinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CB_MaCB_GDinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        TxtTen_CBGiaDinh.setEditable(false);

        jLabel16.setText("Tên Cán Bộ");

        jLabel20.setText("Mã Cán Bộ");

        jLabel79.setText("Mã gia đình");

        CB_Ma_GD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CB_Ma_GD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel79))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TxtTen_CBGiaDinh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CB_MaCB_GDinh, 0, 166, Short.MAX_VALUE)
                            .addComponent(CB_Ma_GD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(TxtStt_CBGD, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(RBtn_CBGD))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel23Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel16, jLabel20, jLabel78, jLabel79});

        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RBtn_CBGD)
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(TxtStt_CBGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_MaCB_GDinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTen_CBGiaDinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(CB_Ma_GD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 5, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Gia Đình", jPanel6);

        ChucVu_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ChucVu_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChucVu_TBLMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(ChucVu_TBL);

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel96.setText("Số thứ tự(*)");

        jLabel97.setText("Mã Cán Bộ");

        CBx_MaCB_ChucVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CBx_MaCB_ChucVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel98.setText("Tên cán bộ");

        Txt_TenCB_ChucVu.setEditable(false);

        jLabel100.setText("Thời gian nhận");

        jLabel99.setText("Chức vụ");

        Cbx_Ngay_ChucVu.setEditable(true);
        Cbx_Ngay_ChucVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngày" }));
        Cbx_Ngay_ChucVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Thang_ChucVu.setEditable(true);
        Cbx_Thang_ChucVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng" }));
        Cbx_Thang_ChucVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Nam_ChucVu.setEditable(true);
        Cbx_Nam_ChucVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        Cbx_Nam_ChucVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel96)
                    .addComponent(jLabel97)
                    .addComponent(jLabel98))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Txt_STT_ChucVu)
                    .addComponent(CBx_MaCB_ChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Txt_TenCB_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel100, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(32, 32, 32)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel31Layout.createSequentialGroup()
                        .addComponent(Cbx_Ngay_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cbx_Thang_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cbx_Nam_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Txt_ChucVu))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel96)
                            .addComponent(Txt_STT_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel99))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel97)
                            .addComponent(CBx_MaCB_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel98)
                            .addComponent(Txt_TenCB_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(Txt_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel100)
                            .addComponent(Cbx_Ngay_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cbx_Thang_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cbx_Nam_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel32.setPreferredSize(new java.awt.Dimension(248, 301));

        AddChucVu_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        AddChucVu_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddChucVu_Btn.setPreferredSize(new java.awt.Dimension(80, 80));
        AddChucVu_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddChucVu_BtnActionPerformed(evt);
            }
        });

        UpdateChucVu_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateChucVu_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateChucVu_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateChucVu_BtnActionPerformed(evt);
            }
        });

        DelChucVu_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelChucVu_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelChucVu_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelChucVu_BtnActionPerformed(evt);
            }
        });

        jLabel124.setText("Xóa thông tin");

        jLabel125.setText("Cập nhật thông tin");

        jLabel126.setText("Thêm thông tin");
        jLabel126.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddChucVu_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateChucVu_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelChucVu_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel125, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(AddChucVu_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UpdateChucVu_Btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DelChucVu_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Chức vụ", jPanel16);

        ChucDanh_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ChucDanh_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChucDanh_TBLMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(ChucDanh_TBL);

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel102.setText("Số thứ tự");

        jLabel103.setText("Mã Cán Bộ");

        jLabel104.setText("Tên Cán Bộ");

        Txt_tenCB_ChucDanh.setEditable(false);

        CBx_MaCB_ChucDanh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CBx_MaCB_ChucDanh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel105.setText("Chức Danh");

        jLabel106.setText("Thời Gian Nhận");

        Cbx_Ngay_ChucDanh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngày" }));
        Cbx_Ngay_ChucDanh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Thang_ChucDanh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng" }));
        Cbx_Thang_ChucDanh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Nam_ChucDanh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        Cbx_Nam_ChucDanh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel104)
                    .addComponent(jLabel103)
                    .addComponent(jLabel102))
                .addGap(39, 39, 39)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Txt_tenCB_ChucDanh)
                    .addComponent(CBx_MaCB_ChucDanh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Txt_Stt_ChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel106)
                    .addComponent(jLabel105))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(Cbx_Ngay_ChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cbx_Thang_ChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cbx_Nam_ChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Txt_ChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(400, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel102)
                        .addComponent(Txt_Stt_ChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel105)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(Txt_ChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel103)
                        .addComponent(CBx_MaCB_ChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel106)
                        .addComponent(Cbx_Ngay_ChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cbx_Thang_ChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cbx_Nam_ChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_tenCB_ChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel34.setPreferredSize(new java.awt.Dimension(248, 301));

        AddChucDanh_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        AddChucDanh_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddChucDanh_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddChucDanh_BtnActionPerformed(evt);
            }
        });

        UpdateChucDanh_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateChucDanh_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateChucDanh_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateChucDanh_BtnActionPerformed(evt);
            }
        });

        DelChucDanh_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelChucDanh_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelChucDanh_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelChucDanh_BtnActionPerformed(evt);
            }
        });

        jLabel130.setText("Thêm thông tin");
        jLabel130.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel131.setText("Cập nhật thông tin");

        jLabel132.setText("Xóa thông tin");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(UpdateChucDanh_Btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(DelChucDanh_Btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddChucDanh_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel131, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(AddChucDanh_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UpdateChucDanh_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DelChucDanh_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel34Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AddChucDanh_Btn, UpdateChucDanh_Btn});

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane18)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Chức danh", jPanel17);

        Luong_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Luong_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Luong_TBLMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Luong_TBL);

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cập nhật", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel47.setText("Số Thứ Tự(*)");

        jLabel48.setText("Mã Cán Bộ");

        CB_MaCB_Luong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel50.setText("Hệ Số Lương");

        TxtHeSoLuong.setEnabled(false);

        jLabel51.setText("Thời Gian Bắt Đầu");

        CBx_Ngay_Luong_TGBD.setEditable(true);
        CBx_Ngay_Luong_TGBD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngày" }));
        CBx_Ngay_Luong_TGBD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Thang_Luong_TGBD.setEditable(true);
        Cbx_Thang_Luong_TGBD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng" }));
        Cbx_Thang_Luong_TGBD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Nam_Luong_TGBD.setEditable(true);
        Cbx_Nam_Luong_TGBD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        Cbx_Nam_Luong_TGBD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel49.setText("Tên Cán Bộ");

        TxtTen_CBLuong.setEditable(false);

        jLabel53.setText("Trình độ");

        Txt_TrinhDo_Luong.setEditable(false);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel48)
                            .addComponent(jLabel47))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CB_MaCB_Luong, javax.swing.GroupLayout.Alignment.LEADING, 0, 210, Short.MAX_VALUE)
                            .addComponent(TxtSoTTLuong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtHeSoLuong)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBx_Ngay_Luong_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cbx_Thang_Luong_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cbx_Nam_Luong_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtTen_CBLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(Txt_TrinhDo_Luong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(TxtSoTTLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(TxtTen_CBLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(CB_MaCB_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(Txt_TrinhDo_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(TxtHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(CBx_Ngay_Luong_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_Thang_Luong_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_Nam_Luong_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        AddLuongBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        AddLuongBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddLuongBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddLuongBtnActionPerformed(evt);
            }
        });

        UpdateLuongBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateLuongBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateLuongBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateLuongBtnActionPerformed(evt);
            }
        });

        DelLuongBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelLuongBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelLuongBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelLuongBtnActionPerformed(evt);
            }
        });

        jLabel115.setText("Thêm thông tin");

        jLabel116.setText("Cập nhật thông tin");

        jLabel117.setText("Xóa thông tin");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UpdateLuongBtn, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddLuongBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelLuongBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel115)
                    .addComponent(jLabel116, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddLuongBtn, DelLuongBtn, UpdateLuongBtn});

        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddLuongBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateLuongBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DelLuongBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Lương", jPanel7);

        DoanPhi_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        DoanPhi_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DoanPhi_TBLMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(DoanPhi_TBL);

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        Cbx_Nam_DoanPhi.setEditable(true);
        Cbx_Nam_DoanPhi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        Cbx_Nam_DoanPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Thang_DoanPhi.setEditable(true);
        Cbx_Thang_DoanPhi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng" }));
        Cbx_Thang_DoanPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Ngay_DoanPhi.setEditable(true);
        Cbx_Ngay_DoanPhi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngày" }));
        Cbx_Ngay_DoanPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel69.setText("Số Tiền Đóng");

        jLabel70.setText("Thời Gian Đóng");

        Txt_TenCanBo_DoanVien.setEditable(false);

        jLabel68.setText("Tên Cán Bộ");

        jLabel67.setText("Mã Cán Bộ");

        CB_MaCB_DoanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel66.setText("Số Thứ Tự");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel67)
                    .addComponent(jLabel66))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtStt_DoanVien)
                    .addComponent(Txt_TenCanBo_DoanVien)
                    .addComponent(CB_MaCB_DoanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtSoTienDong_DoanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addGap(18, 18, 18)
                        .addComponent(Cbx_Ngay_DoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cbx_Thang_DoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cbx_Nam_DoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 364, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtStt_DoanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66)
                    .addComponent(jLabel69)
                    .addComponent(TxtSoTienDong_DoanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel70)
                        .addComponent(Cbx_Ngay_DoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cbx_Thang_DoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cbx_Nam_DoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel67)
                        .addComponent(CB_MaCB_DoanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_TenCanBo_DoanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        DelDoanVienBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelDoanVienBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelDoanVienBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelDoanVienBtnActionPerformed(evt);
            }
        });

        UpdateDoanVienBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateDoanVienBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateDoanVienBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateDoanVienBtnActionPerformed(evt);
            }
        });

        AddDoanVienBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        AddDoanVienBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddDoanVienBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDoanVienBtnActionPerformed(evt);
            }
        });

        jLabel121.setText("Thêm thông tin");

        jLabel122.setText("Cập nhật thông tin");

        jLabel123.setText("Xóa thông tin");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DelDoanVienBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddDoanVienBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateDoanVienBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel121)
                    .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddDoanVienBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateDoanVienBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DelDoanVienBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Đoàn Phí", jPanel10);

        CongDoanPhi_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        CongDoanPhi_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CongDoanPhi_TBLMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(CongDoanPhi_TBL);

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        Cbx_Nam_CongDoanPhi.setEditable(true);
        Cbx_Nam_CongDoanPhi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        Cbx_Nam_CongDoanPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cbx_Nam_CongDoanPhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbx_Nam_CongDoanPhiActionPerformed(evt);
            }
        });

        Cbx_Thang_CongDoanPhi.setEditable(true);
        Cbx_Thang_CongDoanPhi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng" }));
        Cbx_Thang_CongDoanPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Ngay_CongDoanPhi.setEditable(true);
        Cbx_Ngay_CongDoanPhi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngày" }));
        Cbx_Ngay_CongDoanPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel64.setText("Số Tiền Đóng");

        jLabel65.setText("Thời Gian Đóng");

        TxtTenCb_CDV.setEditable(false);

        jLabel63.setText("Tên Cán Bộ");

        jLabel62.setText("Mã Cán Bộ");

        Cb_MaCB_CDV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        TxtSoThuTuCongDoanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSoThuTuCongDoanVienActionPerformed(evt);
            }
        });

        jLabel61.setText("Số Thứ Tự");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtSoThuTuCongDoanVien)
                    .addComponent(Cb_MaCB_CDV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtTenCb_CDV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addComponent(TxtSoTienDong_CDV, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cbx_Ngay_CongDoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cbx_Thang_CongDoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cbx_Nam_CongDoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(339, Short.MAX_VALUE))
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Cbx_Nam_CongDoanPhi, Cbx_Ngay_CongDoanPhi, Cbx_Thang_CongDoanPhi});

        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(TxtSoThuTuCongDoanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62)
                            .addComponent(Cb_MaCB_CDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(Cbx_Ngay_CongDoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cbx_Thang_CongDoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cbx_Nam_CongDoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtSoTienDong_CDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64))))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(TxtTenCb_CDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Cbx_Nam_CongDoanPhi, Cbx_Ngay_CongDoanPhi, Cbx_Thang_CongDoanPhi});

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jPanel35.setPreferredSize(new java.awt.Dimension(248, 301));

        AddCDVBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        AddCDVBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddCDVBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCDVBtnActionPerformed(evt);
            }
        });

        UpdateCDVBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateCDVBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateCDVBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateCDVBtnActionPerformed(evt);
            }
        });

        DelCDVBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelCDVBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelCDVBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelCDVBtnActionPerformed(evt);
            }
        });

        jLabel127.setText("Xóa người dùng");

        jLabel128.setText("Cập nhật thông tin");

        jLabel129.setText("Thêm thông tin");
        jLabel129.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UpdateCDVBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(DelCDVBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddCDVBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddCDVBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(UpdateCDVBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DelCDVBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel35Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DelCDVBtn, UpdateCDVBtn});

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Công Đoàn Phí", jPanel9);

        DangPhi_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        DangPhi_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DangPhi_TBLMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(DangPhi_TBL);

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel58.setText("Thời Gian Đóng");

        Cbx_Ngay_DangPhi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngày" }));
        Cbx_Ngay_DangPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Thang_DangPhi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng" }));
        Cbx_Thang_DangPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Nam_DangPhi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        Cbx_Nam_DangPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel57.setText("Số Tiền Đóng");

        TxtTen_CBDangVien.setEditable(false);

        CB_MaCb_DangVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel55.setText("Mã Cán Bộ");

        jLabel56.setText("Tên Cán Bộ");

        jLabel54.setText("Số Thứ Tự");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel56)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtSttDangVien)
                    .addComponent(TxtTen_CBDangVien)
                    .addComponent(CB_MaCb_DangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(jLabel57))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(Cbx_Ngay_DangPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cbx_Thang_DangPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cbx_Nam_DangPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TxtSoTienDongDangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(TxtSttDangVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(CB_MaCb_DangVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel58)
                        .addComponent(Cbx_Ngay_DangPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cbx_Thang_DangPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cbx_Nam_DangPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(TxtSoTienDongDangVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)))
                .addGap(35, 35, 35)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(TxtTen_CBDangVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));

        AddDangPhiBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        AddDangPhiBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddDangPhiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDangPhiBtnActionPerformed(evt);
            }
        });

        UpdateDangPhiBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateDangPhiBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateDangPhiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateDangPhiBtnActionPerformed(evt);
            }
        });

        DelDangPhiBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelDangPhiBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelDangPhiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelDangPhiBtnActionPerformed(evt);
            }
        });

        jLabel118.setText("Thêm thông tin");

        jLabel119.setText("Cập nhật thông tin");

        jLabel120.setText("Xóa thông tin");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(UpdateDangPhiBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(AddDangPhiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelDangPhiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel118)
                    .addComponent(jLabel119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddDangPhiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(UpdateDangPhiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DelDangPhiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1320, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Đảng Phí", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản Lý Cán Bộ", jPanel1);

        Chamthi_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Chamthi_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chamthi_TBLMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(Chamthi_TBL);

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));

        DelChamThi_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelChamThi_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelChamThi_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelChamThi_BtnActionPerformed(evt);
            }
        });

        UpdateChamThi_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateChamThi_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateChamThi_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateChamThi_BtnActionPerformed(evt);
            }
        });

        AddChamThi_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        AddChamThi_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddChamThi_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddChamThi_BtnActionPerformed(evt);
            }
        });

        jLabel133.setText("Thêm thông tin");

        jLabel134.setText("Cập nhật thông tin");

        jLabel135.setText("Xóa thông tin");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddChamThi_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateChamThi_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelChamThi_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel133)
                    .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel134, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(AddChamThi_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UpdateChamThi_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DelChamThi_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel80.setText("Mã Chấm Thi(*)");

        jLabel81.setText("Mã Lớp");

        CB_MaCB_ChamThi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CB_MaCB_ChamThi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel82.setText("Mã giảng viên");

        jLabel83.setText("Tên giảng viên");

        TxtTen_CB_ChamThi.setEditable(false);

        jLabel86.setText("Số Bài Thi");

        Cbx_Ngay_ChamThi.setEditable(true);
        Cbx_Ngay_ChamThi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngày" }));
        Cbx_Ngay_ChamThi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Thang_ChamThi.setEditable(true);
        Cbx_Thang_ChamThi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng" }));
        Cbx_Thang_ChamThi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Nam_ChamThi.setEditable(true);
        Cbx_Nam_ChamThi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        Cbx_Nam_ChamThi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel84.setText("Mã Môn Học");

        jLabel85.setText("Ngày Nộp");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel80)
                    .addComponent(jLabel81)
                    .addComponent(jLabel82)
                    .addComponent(jLabel83))
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtTen_CB_ChamThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtMa_Lop)
                            .addComponent(TxtMa_ChamThi, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(CB_MaCB_ChamThi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel84)
                            .addComponent(jLabel85)
                            .addComponent(jLabel86))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addComponent(Cbx_Ngay_ChamThi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cbx_Thang_ChamThi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cbx_Nam_ChamThi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Cbx_MaMH_ChamThi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtSoBaiThi))))
                .addContainerGap(359, Short.MAX_VALUE))
        );

        jPanel39Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CB_MaCB_ChamThi, TxtMa_ChamThi, TxtMa_Lop, TxtTen_CB_ChamThi});

        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jLabel84)
                    .addComponent(TxtMa_ChamThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_MaMH_ChamThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(jLabel85)
                    .addComponent(TxtMa_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_Ngay_ChamThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_Thang_ChamThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_Nam_ChamThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(jLabel86)
                    .addComponent(TxtSoBaiThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_MaCB_ChamThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(TxtTen_CB_ChamThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản Lý Chấm Thi", jPanel15);

        NCKH_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        NCKH_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NCKH_TBLMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(NCKH_TBL);

        GV_NCKH_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        GV_NCKH_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GV_NCKH_TBLMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(GV_NCKH_TBL);

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cán bộ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        RBtn_GV_NCKH.setText("Cán bộ thực hiện đề tài");
        RBtn_GV_NCKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel87.setText("Số thứ tự(*)");

        jLabel36.setText("Mã Cán Bộ");

        CB_MaCB_NCKH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CB_MaCB_NCKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel37.setText("Tên Cán Bộ");

        TxtTen_CBNCKH.setEditable(false);

        jLabel88.setText("Mã Đề Tài");

        CB_Ma_DTai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CB_Ma_DTai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel88)
                            .addComponent(jLabel36)
                            .addComponent(jLabel87)
                            .addComponent(jLabel37))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CB_MaCB_NCKH, javax.swing.GroupLayout.Alignment.TRAILING, 0, 158, Short.MAX_VALUE)
                            .addComponent(Txt_Stt_NCKH, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtTen_CBNCKH)
                            .addComponent(CB_Ma_DTai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(RBtn_GV_NCKH))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RBtn_GV_NCKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_Stt_NCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87))
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(CB_MaCB_NCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTen_CBNCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(CB_Ma_DTai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel45.setPreferredSize(new java.awt.Dimension(248, 301));

        AddNCKHBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        AddNCKHBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddNCKHBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNCKHBtnActionPerformed(evt);
            }
        });

        UpdateNCKHBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateNCKHBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateNCKHBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNCKHBtnActionPerformed(evt);
            }
        });

        DelNCKHBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelNCKHBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelNCKHBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelNCKHBtnActionPerformed(evt);
            }
        });

        jLabel139.setText("Xóa thông tin");

        jLabel140.setText("Cập nhật thông tin");

        jLabel141.setText("Thêm thông tin");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UpdateNCKHBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(DelNCKHBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNCKHBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel141)
                    .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel140, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNCKHBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UpdateNCKHBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DelNCKHBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nghiên cứu khoa học"));

        RBtn_NCKH.setText("Nghiên Cứu Khoa Học");
        RBtn_NCKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel38.setText("Mã Đề Tài (*)");

        jLabel43.setText("Thời Gian Kết Thúc");

        Cbx_Ngay_NCKH_TGKT.setEditable(true);
        Cbx_Ngay_NCKH_TGKT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngày" }));
        Cbx_Ngay_NCKH_TGKT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Thang_NCKH_TGKT.setEditable(true);
        Cbx_Thang_NCKH_TGKT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng" }));
        Cbx_Thang_NCKH_TGKT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Nam_NCKH_TGKT.setEditable(true);
        Cbx_Nam_NCKH_TGKT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        Cbx_Nam_NCKH_TGKT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel39.setText("Tên Đề Tài");

        jLabel40.setText("Cấp");

        jLabel89.setText("Kinh Phí");

        jLabel41.setText("Thời Gian Bắt Đầu");

        Cbx_Ngay_NCKH_TGBD.setEditable(true);
        Cbx_Ngay_NCKH_TGBD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngày" }));
        Cbx_Ngay_NCKH_TGBD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cbx_Thang_NCKH_TGBD.setEditable(true);
        Cbx_Thang_NCKH_TGBD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng" }));
        Cbx_Thang_NCKH_TGBD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        CBx_Nam_NCKH_TGBD.setEditable(true);
        CBx_Nam_NCKH_TGBD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        CBx_Nam_NCKH_TGBD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel44.setText("Chủ Trì");

        jLabel46.setText("Kết Quả");

        TxtKetQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtKetQuaActionPerformed(evt);
            }
        });

        jLabel45.setText("Tình Trạng");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBtn_NCKH)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addGroup(jPanel46Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel38))
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel89))
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel46Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TxtTenDT)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel46Layout.createSequentialGroup()
                                        .addComponent(Cbx_Ngay_NCKH_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Cbx_Thang_NCKH_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Cbx_Nam_NCKH_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TxtCap)
                                    .addComponent(TxtKinhPhi)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(Txt_MaDT, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel44)
                    .addComponent(jLabel46)
                    .addComponent(jLabel41))
                .addGap(23, 23, 23)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(Cbx_Ngay_NCKH_TGBD, 0, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cbx_Thang_NCKH_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBx_Nam_NCKH_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TxtKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtChuTri, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RBtn_NCKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(Txt_MaDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_Ngay_NCKH_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_Thang_NCKH_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBx_Nam_NCKH_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(9, 9, 9)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbx_Thang_NCKH_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_Nam_NCKH_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_Ngay_NCKH_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(TxtChuTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(TxtTenDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(TxtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel46)
                        .addComponent(TxtKetQua))
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(TxtKinhPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jPanel46Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Cbx_Nam_NCKH_TGKT, Cbx_Ngay_NCKH_TGKT, Cbx_Thang_NCKH_TGKT});

        jPanel46Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CBx_Nam_NCKH_TGBD, Cbx_Ngay_NCKH_TGBD, Cbx_Thang_NCKH_TGBD});

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGap(0, 24, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản Lý Nghiên Cứu Khoa Học", jPanel13);

        BaiBao_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        BaiBao_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BaiBao_TBLMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(BaiBao_TBL);

        CB_BB_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        CB_BB_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_BB_TBLMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(CB_BB_TBL);

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cán bộ quản lý", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        RBtn_CB_BB.setText("Cán bộ quản lý bài báo");
        RBtn_CB_BB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel42.setText("Số thứ tự(*)");

        jLabel3.setText("Mã Cán Bộ");

        CB_MaCB_BB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CB_MaCB_BB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel29.setText("Tên Cán Bộ");

        TxtTen_CBBB.setEditable(false);

        jLabel90.setText("Mã Bài Báo(Tạp Chí)");

        CB_MaBB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CB_MaBB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel90)
                            .addComponent(jLabel3)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TxtTen_CBBB, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CB_MaCB_BB, javax.swing.GroupLayout.Alignment.LEADING, 0, 155, Short.MAX_VALUE)
                            .addComponent(Txt_Stt_BB, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CB_MaBB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(RBtn_CB_BB))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(RBtn_CB_BB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(Txt_Stt_BB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(TxtTen_CBBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CB_MaCB_BB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(40, 40, 40)))
                .addGap(15, 15, 15)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(CB_MaBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin Bài báo - Tạp Chí", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        RBtn_BBao.setText("Bài Báo - Tạp Chí");
        RBtn_BBao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel30.setText("Mã Bài Báo(Tạp Chí) (*)");

        jLabel32.setText("Số");

        jLabel33.setText("Thời Gian Xuất Bản");

        Cbx_Nam_BB.setEditable(true);
        Cbx_Nam_BB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        Cbx_Nam_BB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel34.setText("Chỉ Số ISSN");

        jLabel35.setText(" Hệ Số IF");

        jLabel31.setText("Tên Tạp Chí");

        Cbx_Thang_baiBao.setEditable(true);
        Cbx_Thang_baiBao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng" }));
        Cbx_Thang_baiBao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(RBtn_BBao)
                        .addGap(84, 84, 84))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtChiSoISSN, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(TxtMaBaiBao, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addComponent(TxtSo)
                                .addComponent(TxtTenTapChi)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel36Layout.createSequentialGroup()
                                    .addComponent(Cbx_Thang_baiBao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Cbx_Nam_BB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(TxtHeSoIF, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 252, Short.MAX_VALUE))))
        );

        jPanel36Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel33, jLabel34});

        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(RBtn_BBao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(TxtMaBaiBao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTenTapChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(TxtSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbx_Nam_BB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(Cbx_Thang_baiBao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtChiSoISSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtHeSoIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        AddBBBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        AddBBBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddBBBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBBBtnActionPerformed(evt);
            }
        });

        UpdateBBBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateBBBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateBBBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBBBtnActionPerformed(evt);
            }
        });

        DelBBBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelBBBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelBBBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelBBBtnActionPerformed(evt);
            }
        });

        jLabel142.setText("Xóa thông tin");

        jLabel143.setText("Cập nhật thông tin");

        jLabel144.setText("Thêm thông tin");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(AddBBBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(UpdateBBBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelBBBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel143)
                    .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel144))
                .addGap(0, 79, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddBBBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateBBBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel143, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DelBBBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản Lý Bài Báo - Tạp Chí", jPanel4);

        GDayBTL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        GDayBTL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GDayBTLMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(GDayBTL);

        CB_GDay_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        CB_GDay_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_GDay_TBLMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(CB_GDay_TBL);

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel43.setPreferredSize(new java.awt.Dimension(248, 301));

        AddGDyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        AddGDyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddGDyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGDyBtnActionPerformed(evt);
            }
        });

        DelGDyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelGDyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelGDyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelGDyBtnActionPerformed(evt);
            }
        });

        UpdateGDyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateGDyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateGDyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateGDyBtnActionPerformed(evt);
            }
        });

        jLabel145.setText("Thêm thông tin");

        jLabel146.setText("Cập nhật thông tin");

        jLabel147.setText("Xóa thông tin");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UpdateGDyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(DelGDyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel146)))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(AddGDyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel145)))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddGDyBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel145, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateGDyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelGDyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin giảng dạy", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel28.setText("Phụ Cấp Giảng Dạy");

        jLabel27.setText("Năm Học");

        jLabel26.setText("Học Kỳ");

        jLabel25.setText("Số Sinh Viên");

        jLabel24.setText("Lớp");

        jLabel23.setText("Số Tín Chỉ");

        jLabel22.setText("Tên Môn");

        jLabel21.setText("Mã Môn Học(*)");

        RBtn_GDay.setText("Quản Lý Giảng Dạy");
        RBtn_GDay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel101.setText("Số giờ dạy");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel27)
                            .addComponent(jLabel21)
                            .addComponent(jLabel24)
                            .addComponent(jLabel26)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtTenMon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtSoSinhVien)
                            .addComponent(TxtHocKy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtLop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtMa_MH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtSoTinChi))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel101))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtPhuCap, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(TxtSoGioDay)))
                    .addComponent(RBtn_GDay))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanel47Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TxtHocKy, TxtLop, TxtMa_MH, TxtNamHoc, TxtSoSinhVien, TxtSoTinChi, TxtTenMon});

        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RBtn_GDay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(TxtMa_MH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(TxtPhuCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(TxtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101)
                    .addComponent(TxtSoGioDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(TxtSoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(TxtSoSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(TxtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(184, 184, 184))
        );

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin cán bộ - giảng dạy"));

        CB_Ma_MH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CB_Ma_MH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel94.setText("Mã Môn Học");

        jLabel60.setText("Tên Giảng Viên");

        TxtTen_GV.setEditable(false);

        CB_MaCB_Gday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CB_MaCB_Gday.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel59.setText("Mã Giảng Viên");

        jLabel95.setText("Số thứ tự(*)");

        RBtn_CB_GDay.setText("Quản Lý Cán Bộ - Giảng Dạy");
        RBtn_CB_GDay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBtn_CB_GDay)
                    .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel48Layout.createSequentialGroup()
                            .addComponent(jLabel94)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CB_Ma_MH, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel48Layout.createSequentialGroup()
                            .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel60)
                                .addComponent(jLabel59)
                                .addComponent(jLabel95))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(CB_MaCB_Gday, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Txt_STT_CB_GDay, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtTen_GV, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RBtn_CB_GDay)
                .addGap(18, 18, 18)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(Txt_STT_CB_GDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(CB_MaCB_Gday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(TxtTen_GV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(CB_Ma_MH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(156, 156, 156))
        );

        jPanel48Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CB_MaCB_Gday, CB_Ma_MH, TxtTen_GV, Txt_STT_CB_GDay});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(jPanel47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản Lý Giảng Dạy", jPanel2);

        GiaoTrinh_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        GiaoTrinh_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GiaoTrinh_TBLMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(GiaoTrinh_TBL);

        CB_GiaoTrinh_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        CB_GiaoTrinh_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_GiaoTrinh_TBLMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CB_GiaoTrinh_TBLMouseEntered(evt);
            }
        });
        jScrollPane15.setViewportView(CB_GiaoTrinh_TBL);

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cán bộ quản lý", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        RBtn_CB_GTrinh.setText("Cán Bộ quản lý giáo trình");
        RBtn_CB_GTrinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel93.setText("Số thứ tự(*)");

        jLabel76.setText("Mã Cán Bộ");

        CB_MaCB_GiaoTrinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CB_MaCB_GiaoTrinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel91.setText("Tên Cán Bộ");

        Txt_TenCB_GTrinh.setEditable(false);

        jLabel92.setText("Mã Giáo Trình");

        CB_Ma_GTrinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CB_Ma_GTrinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBtn_CB_GTrinh)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel93)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel91))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(CB_MaCB_GiaoTrinh, javax.swing.GroupLayout.Alignment.LEADING, 0, 165, Short.MAX_VALUE)
                                    .addComponent(Txt_Stt_CBGTrinh, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Txt_TenCB_GTrinh)))
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addComponent(jLabel92)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CB_Ma_GTrinh, 0, 163, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(RBtn_CB_GTrinh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(Txt_Stt_CBGTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(CB_MaCB_GiaoTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(Txt_TenCB_GTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(CB_Ma_GTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin giáo trình"));

        jLabel75.setText("Nhà Xuất Bản");

        jLabel74.setText("Năm Xuất Bản");

        Cbx_Nam_GiaoTrinh.setEditable(true);
        Cbx_Nam_GiaoTrinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm" }));
        Cbx_Nam_GiaoTrinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel73.setText("Tên Tác Giả");

        jLabel72.setText("Tên Giáo Trình");

        jLabel71.setText("Mã Giáo Trình(*)");

        RBtn_GiaoTrinh.setText("Giáo Trình");
        RBtn_GiaoTrinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBtn_GiaoTrinh)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel72)
                            .addComponent(jLabel71))
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtTenGiaoTrinh))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtMa_GT, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel74)
                                    .addComponent(jLabel75))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cbx_Nam_GiaoTrinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtNhaXuatBan, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtTenTacGia)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TxtMa_GT, TxtNhaXuatBan, TxtTenGiaoTrinh, TxtTenTacGia});

        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(RBtn_GiaoTrinh)
                .addGap(9, 9, 9)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(TxtMa_GT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(TxtTenGiaoTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(TxtTenTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(Cbx_Nam_GiaoTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(TxtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        AddGiaoTrinhBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thêm.png"))); // NOI18N
        AddGiaoTrinhBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddGiaoTrinhBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGiaoTrinhBtnActionPerformed(evt);
            }
        });

        UpdateGiaoTrinhBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cập nhật.png"))); // NOI18N
        UpdateGiaoTrinhBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateGiaoTrinhBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateGiaoTrinhBtnActionPerformed(evt);
            }
        });

        DelGiaoTrinhBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xóa.png"))); // NOI18N
        DelGiaoTrinhBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelGiaoTrinhBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelGiaoTrinhBtnActionPerformed(evt);
            }
        });

        jLabel136.setText("Thêm thông tin");

        jLabel137.setText("Cập nhật thông tin");

        jLabel138.setText("Xóa thông tin");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(UpdateGiaoTrinhBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(DelGiaoTrinhBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddGiaoTrinhBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel137)
                    .addComponent(jLabel136)
                    .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel136, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddGiaoTrinhBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UpdateGiaoTrinhBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DelGiaoTrinhBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản Lý Giáo Trình", jPanel3);

        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Quay lại.png"))); // NOI18N
        BackBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        Print_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/In.png"))); // NOI18N
        Print_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Print_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_BtnActionPerformed(evt);
            }
        });

        jLabel52.setText("In");

        jLabel148.setText("Quay lại");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1354, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Print_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel148, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Print_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
    }//GEN-LAST:event_BackBtnActionPerformed

    private void Print_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_BtnActionPerformed
    }//GEN-LAST:event_Print_BtnActionPerformed

    private void DelGiaoTrinhBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelGiaoTrinhBtnActionPerformed

    }//GEN-LAST:event_DelGiaoTrinhBtnActionPerformed

    private void UpdateGiaoTrinhBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateGiaoTrinhBtnActionPerformed

    }//GEN-LAST:event_UpdateGiaoTrinhBtnActionPerformed

    private void AddGiaoTrinhBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGiaoTrinhBtnActionPerformed

    }//GEN-LAST:event_AddGiaoTrinhBtnActionPerformed

    private void CB_GiaoTrinh_TBLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_GiaoTrinh_TBLMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_GiaoTrinh_TBLMouseEntered

    private void CB_GiaoTrinh_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_GiaoTrinh_TBLMouseClicked

    }//GEN-LAST:event_CB_GiaoTrinh_TBLMouseClicked

    private void GiaoTrinh_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GiaoTrinh_TBLMouseClicked

    }//GEN-LAST:event_GiaoTrinh_TBLMouseClicked

    private void UpdateGDyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateGDyBtnActionPerformed

    }//GEN-LAST:event_UpdateGDyBtnActionPerformed

    private void DelGDyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelGDyBtnActionPerformed

    }//GEN-LAST:event_DelGDyBtnActionPerformed

    private void AddGDyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGDyBtnActionPerformed

    }//GEN-LAST:event_AddGDyBtnActionPerformed

    private void CB_GDay_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_GDay_TBLMouseClicked

    }//GEN-LAST:event_CB_GDay_TBLMouseClicked

    private void GDayBTLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GDayBTLMouseClicked

    }//GEN-LAST:event_GDayBTLMouseClicked

    private void DelBBBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelBBBtnActionPerformed

    }//GEN-LAST:event_DelBBBtnActionPerformed

    private void UpdateBBBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBBBtnActionPerformed

    }//GEN-LAST:event_UpdateBBBtnActionPerformed

    private void AddBBBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBBBtnActionPerformed

    }//GEN-LAST:event_AddBBBtnActionPerformed

    private void CB_BB_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_BB_TBLMouseClicked

    }//GEN-LAST:event_CB_BB_TBLMouseClicked

    private void BaiBao_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BaiBao_TBLMouseClicked

    }//GEN-LAST:event_BaiBao_TBLMouseClicked

    private void TxtKetQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtKetQuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtKetQuaActionPerformed

    private void DelNCKHBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelNCKHBtnActionPerformed

    }//GEN-LAST:event_DelNCKHBtnActionPerformed

    private void UpdateNCKHBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNCKHBtnActionPerformed

    }//GEN-LAST:event_UpdateNCKHBtnActionPerformed

    private void AddNCKHBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNCKHBtnActionPerformed

    }//GEN-LAST:event_AddNCKHBtnActionPerformed

    private void GV_NCKH_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GV_NCKH_TBLMouseClicked

    }//GEN-LAST:event_GV_NCKH_TBLMouseClicked

    private void NCKH_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NCKH_TBLMouseClicked

    }//GEN-LAST:event_NCKH_TBLMouseClicked

    private void AddChamThi_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddChamThi_BtnActionPerformed

    }//GEN-LAST:event_AddChamThi_BtnActionPerformed

    private void UpdateChamThi_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateChamThi_BtnActionPerformed

    }//GEN-LAST:event_UpdateChamThi_BtnActionPerformed

    private void DelChamThi_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelChamThi_BtnActionPerformed

    }//GEN-LAST:event_DelChamThi_BtnActionPerformed

    private void Chamthi_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chamthi_TBLMouseClicked

    }//GEN-LAST:event_Chamthi_TBLMouseClicked

    private void DelDangPhiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelDangPhiBtnActionPerformed

    }//GEN-LAST:event_DelDangPhiBtnActionPerformed

    private void UpdateDangPhiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateDangPhiBtnActionPerformed

    }//GEN-LAST:event_UpdateDangPhiBtnActionPerformed

    private void AddDangPhiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDangPhiBtnActionPerformed

    }//GEN-LAST:event_AddDangPhiBtnActionPerformed

    private void DangPhi_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DangPhi_TBLMouseClicked

    }//GEN-LAST:event_DangPhi_TBLMouseClicked

    private void DelCDVBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelCDVBtnActionPerformed

    }//GEN-LAST:event_DelCDVBtnActionPerformed

    private void UpdateCDVBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateCDVBtnActionPerformed

    }//GEN-LAST:event_UpdateCDVBtnActionPerformed

    private void AddCDVBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCDVBtnActionPerformed

    }//GEN-LAST:event_AddCDVBtnActionPerformed

    private void TxtSoThuTuCongDoanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSoThuTuCongDoanVienActionPerformed

    }//GEN-LAST:event_TxtSoThuTuCongDoanVienActionPerformed

    private void Cbx_Nam_CongDoanPhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbx_Nam_CongDoanPhiActionPerformed

    }//GEN-LAST:event_Cbx_Nam_CongDoanPhiActionPerformed

    private void CongDoanPhi_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CongDoanPhi_TBLMouseClicked

    }//GEN-LAST:event_CongDoanPhi_TBLMouseClicked

    private void AddDoanVienBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDoanVienBtnActionPerformed

    }//GEN-LAST:event_AddDoanVienBtnActionPerformed

    private void UpdateDoanVienBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateDoanVienBtnActionPerformed

    }//GEN-LAST:event_UpdateDoanVienBtnActionPerformed

    private void DelDoanVienBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelDoanVienBtnActionPerformed

    }//GEN-LAST:event_DelDoanVienBtnActionPerformed

    private void DoanPhi_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DoanPhi_TBLMouseClicked

    }//GEN-LAST:event_DoanPhi_TBLMouseClicked

    private void DelLuongBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelLuongBtnActionPerformed

    }//GEN-LAST:event_DelLuongBtnActionPerformed

    private void UpdateLuongBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateLuongBtnActionPerformed

    }//GEN-LAST:event_UpdateLuongBtnActionPerformed

    private void AddLuongBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddLuongBtnActionPerformed

    }//GEN-LAST:event_AddLuongBtnActionPerformed

    private void Luong_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Luong_TBLMouseClicked

    }//GEN-LAST:event_Luong_TBLMouseClicked

    private void DelChucDanh_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelChucDanh_BtnActionPerformed

    }//GEN-LAST:event_DelChucDanh_BtnActionPerformed

    private void UpdateChucDanh_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateChucDanh_BtnActionPerformed

    }//GEN-LAST:event_UpdateChucDanh_BtnActionPerformed

    private void AddChucDanh_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddChucDanh_BtnActionPerformed

    }//GEN-LAST:event_AddChucDanh_BtnActionPerformed

    private void ChucDanh_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChucDanh_TBLMouseClicked

    }//GEN-LAST:event_ChucDanh_TBLMouseClicked

    private void DelChucVu_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelChucVu_BtnActionPerformed

    }//GEN-LAST:event_DelChucVu_BtnActionPerformed

    private void UpdateChucVu_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateChucVu_BtnActionPerformed

    }//GEN-LAST:event_UpdateChucVu_BtnActionPerformed

    private void AddChucVu_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddChucVu_BtnActionPerformed

    }//GEN-LAST:event_AddChucVu_BtnActionPerformed

    private void ChucVu_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChucVu_TBLMouseClicked

    }//GEN-LAST:event_ChucVu_TBLMouseClicked

    private void RBtn_CBGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBtn_CBGDActionPerformed

    }//GEN-LAST:event_RBtn_CBGDActionPerformed

    private void DelGDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelGDBtnActionPerformed

    }//GEN-LAST:event_DelGDBtnActionPerformed

    private void UpdateGDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateGDBtnActionPerformed

    }//GEN-LAST:event_UpdateGDBtnActionPerformed

    private void addGDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGDBtnActionPerformed

    }//GEN-LAST:event_addGDBtnActionPerformed

    private void CB_GD_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_GD_TBLMouseClicked

    }//GEN-LAST:event_CB_GD_TBLMouseClicked

    private void GiaDinhTBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GiaDinhTBLMouseClicked

    }//GEN-LAST:event_GiaDinhTBLMouseClicked

    private void CanBo_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CanBo_TBLMouseClicked

    }//GEN-LAST:event_CanBo_TBLMouseClicked

    private void RBtn_DoanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBtn_DoanVienActionPerformed
        Rbtn_DangVien.setSelected(false);
    }//GEN-LAST:event_RBtn_DoanVienActionPerformed

    private void Rbtn_DangVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rbtn_DangVienActionPerformed
        RBtn_DoanVien.setSelected(false);
    }//GEN-LAST:event_Rbtn_DangVienActionPerformed

    private void RBtn_NuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBtn_NuActionPerformed
        Rbtn_Nam.setSelected(false);
    }//GEN-LAST:event_RBtn_NuActionPerformed

    private void Rbtn_NamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rbtn_NamActionPerformed
        RBtn_Nu.setSelected(false);
    }//GEN-LAST:event_Rbtn_NamActionPerformed

    private void DelCbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelCbBtnActionPerformed

    }//GEN-LAST:event_DelCbBtnActionPerformed

    private void UpdateCbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateCbBtnActionPerformed

    }//GEN-LAST:event_UpdateCbBtnActionPerformed

    private void AddCbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCbBtnActionPerformed

    }//GEN-LAST:event_AddCbBtnActionPerformed
    
    public void GiangDayTBLActionListener(MouseListener me){
        GDayBTL.addMouseListener(me);
    }
    
    public void AddCanBoBtnActionListener(ActionListener al){
        AddCbBtn.addActionListener(al);
    }
    
    public void UpdateCanBoBtnActionListener(ActionListener al){
        UpdateCbBtn.addActionListener(al);
    }
    
    public void DelCanBoBtnActionListener(ActionListener al){
        DelCbBtn.addActionListener(al);
    }

    public void AddCanBo_GiaDinhBtnActionListener(ActionListener al){
        addGDBtn.addActionListener(al);
    }
    
    public void UpdateCanBo_GiaDinhBtnActionListener(ActionListener al){
        UpdateGDBtn.addActionListener(al);
    }
    
    public void DelCanBo_GiaDinhBtnActionListener(ActionListener al){
        DelGDBtn.addActionListener(al);
    }

    public void AddGiaDinhBtnActionListener(ActionListener al){
        addGDBtn.addActionListener(al);
    }
    
    public void UpdateGiaDinhBtnActionListener(ActionListener al){
        UpdateGDBtn.addActionListener(al);
    }
    
    public void DelGiaDinhBtnActionListener(ActionListener al){
        DelGDBtn.addActionListener(al);
    }
    
    public void AddLuongBtnActionListener(ActionListener al){
        AddLuongBtn.addActionListener(al);
    }
    
    public void UpdateLuongBtnActionListener(ActionListener al){
        UpdateLuongBtn.addActionListener(al);
    }
    
    public void DelLuongBtnActionListener(ActionListener al){
        DelLuongBtn.addActionListener(al);
    }
    public void AddDangPhiBtnActionListener(ActionListener al){
        AddDangPhiBtn.addActionListener(al);
    }
    
    public void UpdateDangPhiBtnActionListener(ActionListener al){
        UpdateDangPhiBtn.addActionListener(al);
    }
    
    public void DelDangPhiBtnActionListener(ActionListener al){
        DelDangPhiBtn.addActionListener(al);
    }
    public void AddDoanPhiBtnActionListener(ActionListener al){
        AddDoanVienBtn.addActionListener(al);
    }
    
    public void UpdateDoanPhiBtnActionListener(ActionListener al){
        UpdateDoanVienBtn.addActionListener(al);
    }
    
    public void DelDoanPhiBtnActionListener(ActionListener al){
        DelDoanVienBtn.addActionListener(al);
    }
    public void AddCongDoanPhiBtnActionListener(ActionListener al){
        AddCDVBtn.addActionListener(al);
    }
    
    public void UpdateCongDoanPhiBtnActionListener(ActionListener al){
        UpdateCDVBtn.addActionListener(al);
    }
    
    public void DelCongDoanPhiBtnActionListener(ActionListener al){
        DelCDVBtn.addActionListener(al);
    }
    public void AddChucVuBtnActionListener(ActionListener al){
        AddChucVu_Btn.addActionListener(al);
    }
    
    public void UpdateChucVuBtnActionListener(ActionListener al){
        UpdateChucVu_Btn.addActionListener(al);
    }
    
    public void DelChucVuBtnActionListener(ActionListener al){
        DelChucVu_Btn.addActionListener(al);
    }
    public void AddChucDanhBtnActionListener(ActionListener al){
        AddChucDanh_Btn.addActionListener(al);
    }
    
    public void UpdateChucDanhBtnActionListener(ActionListener al){
        UpdateChucDanh_Btn.addActionListener(al);
    }
    
    public void DelChucDanhBtnActionListener(ActionListener al){
        DelChucDanh_Btn.addActionListener(al);
    }
    public void AddCanBo_GiangDayBtnActionListener(ActionListener al){
        AddGDyBtn.addActionListener(al);
    }
    
    public void UpdatedCanBo_GiangDayBtnActionListener(ActionListener al){
        UpdateGDyBtn.addActionListener(al);
    }
    
    public void DeldCanBo_GiangDayoBtnActionListener(ActionListener al){
        DelGDyBtn.addActionListener(al);
    }
    public void AddGiangDayBtnActionListener(ActionListener al){
        AddGDyBtn.addActionListener(al);
    }
    
    public void UpdateGiangDayBtnActionListener(ActionListener al){
        UpdateGDyBtn.addActionListener(al);
    }
    
    public void DelGiangDayBtnActionListener(ActionListener al){
        DelGDyBtn.addActionListener(al);
    }
    public void AddChamThiBtnActionListener(ActionListener al){
        AddChamThi_Btn.addActionListener(al);
    }
    
    public void UpdateChamThiBtnActionListener(ActionListener al){
        UpdateChamThi_Btn.addActionListener(al);
    }
    
    public void DelChamThiBtnActionListener(ActionListener al){
        DelChamThi_Btn.addActionListener(al);
    }
    public void AddCanBo_GiaoTrinhBtnActionListener(ActionListener al){
        AddGiaoTrinhBtn.addActionListener(al);
    }
    
    public void UpdateCanBo_GiaoTrinhBtnActionListener(ActionListener al){
        UpdateGiaoTrinhBtn.addActionListener(al);
    }
    
    public void DelCanBo_GiaoTrinhBtnActionListener(ActionListener al){
        DelGiaoTrinhBtn.addActionListener(al);
    }
    
    public void AddGiaoTrinhBtnActionListener(ActionListener al){
        AddGiaoTrinhBtn.addActionListener(al);
    }
    
    public void UpdateGiaoTrinhBtnActionListener(ActionListener al){
        UpdateGiaoTrinhBtn.addActionListener(al);
    }
    
    public void DelGiaoTrinhBtnActionListener(ActionListener al){
        DelGiaoTrinhBtn.addActionListener(al);
    }
    
    public void AddCanBo_NCKHBtnActionListener(ActionListener al){
        AddNCKHBtn.addActionListener(al);
    }
    
    public void UpdateCanBo_NCKHBtnActionListener(ActionListener al){
        UpdateNCKHBtn.addActionListener(al);
    }
    
    public void DelCanBo_NCKHBtnActionListener(ActionListener al){
        DelNCKHBtn.addActionListener(al);
    }
    
    public void AddNCKHBtnActionListener(ActionListener al){
        AddNCKHBtn.addActionListener(al);
    }
    
    public void UpdateNCKHBtnActionListener(ActionListener al){
        UpdateNCKHBtn.addActionListener(al);
    }
    
    public void DelNCKHBtnActionListener(ActionListener al){
        DelNCKHBtn.addActionListener(al);
    }
    
    public void AddCanBo_BBBtnActionListener(ActionListener al){
        AddBBBtn.addActionListener(al);
    }
    
    public void UpdateCanBo_BBBtnActionListener(ActionListener al){
        UpdateBBBtn.addActionListener(al);
    }
    
    public void DelCanBo_BBBtnActionListener(ActionListener al){
        DelBBBtn.addActionListener(al);
    }
    
    public void AddBBBtnActionListener(ActionListener al){
        AddBBBtn.addActionListener(al);
    }
    
    public void UpdateBBBtnActionListener(ActionListener al){
        UpdateBBBtn.addActionListener(al);
    }
    
    public void DelBBBtnActionListener(ActionListener al){
        DelBBBtn.addActionListener(al);
    }
    
    public void BackBtnActionListener(ActionListener al){
        BackBtn.addActionListener(al);
    }
    
    public void PrintBtnActionListener(ActionListener al){
        Print_Btn.addActionListener(al);
    }
    
    public void ClickTableCanBoListener(ListSelectionListener lsl) {
       CanBo_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableCanBo_GiaDinh(ListSelectionListener lsl){
        CB_GD_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableGiaDinh(ListSelectionListener lsl){
        GiaDinhTBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableLuong(ListSelectionListener lsl){
        Luong_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableChucVu(ListSelectionListener lsl){
        ChucVu_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableChucDanh(ListSelectionListener lsl){
        ChucDanh_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableCongDoanPhi(ListSelectionListener lsl){
        CongDoanPhi_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableDoanPhi(ListSelectionListener lsl){
        DoanPhi_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableDangPhi(ListSelectionListener lsl){
        DangPhi_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableChamThi(ListSelectionListener lsl){
        Chamthi_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableCanBo_NCKH(ListSelectionListener lsl){
        GV_NCKH_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableNCKH(ListSelectionListener lsl){
        NCKH_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableCanBo_BB(ListSelectionListener lsl){
        CB_BB_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableBaiBao(ListSelectionListener lsl){
        BaiBao_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableCanBo_GiaoTrinh(ListSelectionListener lsl){
        CB_GiaoTrinh_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public  void ClickTableGiaoTrinh(ListSelectionListener lsl){
        GiaoTrinh_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableGiangDay(ListSelectionListener lsl){
        GDayBTL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void ClickTableCB_GiangDay(ListSelectionListener lsl){
        CB_GDay_TBL.getSelectionModel().addListSelectionListener(lsl);
    }
    
    public void Cbx_MaCBBBActionListener(ActionListener al){
        CB_MaCB_BB.addActionListener(al);
    }
    
    public void Cbx_MaCBChamThiActionListener(ActionListener al){
        CB_MaCB_ChamThi.addActionListener(al);
    }
    
    public void Cbx_MaCBDoanVienActionListener(ActionListener al){
        CB_MaCB_DoanVien.addActionListener(al);
    }
    
    public void Cbx_MaCBGDinhActionListener(ActionListener al){
        CB_MaCB_GDinh.addActionListener(al); 
    }
    
    public void Cbx_MaCBGDayActionListener(ActionListener al){
        CB_MaCB_Gday.addActionListener(al); 
    }
    
    public void Cbx_MaCBGiaoTrinhActionListener(ActionListener al){
        CB_MaCB_GiaoTrinh.addActionListener(al); 
    }
    
    public void Cbx_MaCBLuongActionListener(ActionListener al){
        CB_MaCB_Luong.addActionListener(al); 
    }
    
    public void Cbx_MaCB_NCKHActionListener(ActionListener al){
        CB_MaCB_NCKH.addActionListener(al); 
    }
    
    public void Cbx_MaCB_DangVienActionListener(ActionListener al){
        CB_MaCb_DangVien.addActionListener(al); 
    }
    
    public void Cbx_MaCB_CDVActionListener(ActionListener al){
        Cb_MaCB_CDV.addActionListener(al); 
    }
    
    public void Cbx_MaCB_ChucDanhActionListener(ActionListener al){
        CBx_MaCB_ChucDanh.addActionListener(al); 
    }
    
    public void Cbx_MaCB_ChucVuActionListener(ActionListener al){
        CBx_MaCB_ChucVu.addActionListener(al); 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton AddBBBtn;
    public javax.swing.JButton AddCDVBtn;
    public javax.swing.JButton AddCbBtn;
    public javax.swing.JButton AddChamThi_Btn;
    public javax.swing.JButton AddChucDanh_Btn;
    public javax.swing.JButton AddChucVu_Btn;
    public javax.swing.JButton AddDangPhiBtn;
    public javax.swing.JButton AddDoanVienBtn;
    public javax.swing.JButton AddGDyBtn;
    public javax.swing.JButton AddGiaoTrinhBtn;
    public javax.swing.JButton AddLuongBtn;
    public javax.swing.JButton AddNCKHBtn;
    public javax.swing.JButton BackBtn;
    public javax.swing.JTable BaiBao_TBL;
    public javax.swing.JTable CB_BB_TBL;
    public javax.swing.JTable CB_GD_TBL;
    public javax.swing.JTable CB_GDay_TBL;
    public javax.swing.JTable CB_GiaoTrinh_TBL;
    public javax.swing.JComboBox CB_MaBB;
    public javax.swing.JComboBox CB_MaCB_BB;
    public javax.swing.JComboBox CB_MaCB_ChamThi;
    public javax.swing.JComboBox CB_MaCB_DoanVien;
    public javax.swing.JComboBox CB_MaCB_GDinh;
    public javax.swing.JComboBox CB_MaCB_Gday;
    public javax.swing.JComboBox CB_MaCB_GiaoTrinh;
    public javax.swing.JComboBox CB_MaCB_Luong;
    public javax.swing.JComboBox CB_MaCB_NCKH;
    public javax.swing.JComboBox CB_MaCb_DangVien;
    public javax.swing.JComboBox CB_Ma_DTai;
    public javax.swing.JComboBox CB_Ma_GD;
    public javax.swing.JComboBox CB_Ma_GTrinh;
    public javax.swing.JComboBox CB_Ma_MH;
    public javax.swing.JComboBox CBx_MaCB_ChucDanh;
    public javax.swing.JComboBox CBx_MaCB_ChucVu;
    public javax.swing.JComboBox CBx_Nam_Ctac;
    public javax.swing.JComboBox CBx_Nam_NCKH_TGBD;
    public javax.swing.JComboBox CBx_Ngay_Ctac;
    public javax.swing.JComboBox CBx_Ngay_Luong_TGBD;
    public javax.swing.JComboBox CBx_Thang_Ctac;
    public javax.swing.JTable CanBo_TBL;
    public javax.swing.JComboBox Cb_MaCB_CDV;
    public javax.swing.JComboBox Cbx_MaMH_ChamThi;
    public javax.swing.JComboBox Cbx_NamSinh_CB;
    public javax.swing.JComboBox Cbx_NamSinh_Con;
    public javax.swing.JComboBox Cbx_Nam_BB;
    public javax.swing.JComboBox Cbx_Nam_ChamThi;
    public javax.swing.JComboBox Cbx_Nam_ChucDanh;
    public javax.swing.JComboBox Cbx_Nam_ChucVu;
    public javax.swing.JComboBox Cbx_Nam_CongDoanPhi;
    public javax.swing.JComboBox Cbx_Nam_DangPhi;
    public javax.swing.JComboBox Cbx_Nam_DoanPhi;
    public javax.swing.JComboBox Cbx_Nam_GiaoTrinh;
    public javax.swing.JComboBox Cbx_Nam_Luong_TGBD;
    public javax.swing.JComboBox Cbx_Nam_NCKH_TGKT;
    public javax.swing.JComboBox Cbx_NgaySinh_CB;
    public javax.swing.JComboBox Cbx_Ngay_ChamThi;
    public javax.swing.JComboBox Cbx_Ngay_ChucDanh;
    public javax.swing.JComboBox Cbx_Ngay_ChucVu;
    public javax.swing.JComboBox Cbx_Ngay_CongDoanPhi;
    public javax.swing.JComboBox Cbx_Ngay_DangPhi;
    public javax.swing.JComboBox Cbx_Ngay_DoanPhi;
    public javax.swing.JComboBox Cbx_Ngay_NCKH_TGBD;
    public javax.swing.JComboBox Cbx_Ngay_NCKH_TGKT;
    public javax.swing.JComboBox Cbx_ThangSinh_CB;
    public javax.swing.JComboBox Cbx_Thang_ChamThi;
    public javax.swing.JComboBox Cbx_Thang_ChucDanh;
    public javax.swing.JComboBox Cbx_Thang_ChucVu;
    public javax.swing.JComboBox Cbx_Thang_CongDoanPhi;
    public javax.swing.JComboBox Cbx_Thang_DangPhi;
    public javax.swing.JComboBox Cbx_Thang_DoanPhi;
    public javax.swing.JComboBox Cbx_Thang_Luong_TGBD;
    public javax.swing.JComboBox Cbx_Thang_NCKH_TGBD;
    public javax.swing.JComboBox Cbx_Thang_NCKH_TGKT;
    public javax.swing.JComboBox Cbx_Thang_baiBao;
    public javax.swing.JComboBox Cbx_TrinhDo;
    public javax.swing.JTable Chamthi_TBL;
    public javax.swing.JTable ChucDanh_TBL;
    public javax.swing.JTable ChucVu_TBL;
    public javax.swing.JTable CongDoanPhi_TBL;
    public javax.swing.JTable DangPhi_TBL;
    public javax.swing.JButton DelBBBtn;
    public javax.swing.JButton DelCDVBtn;
    public javax.swing.JButton DelCbBtn;
    public javax.swing.JButton DelChamThi_Btn;
    public javax.swing.JButton DelChucDanh_Btn;
    public javax.swing.JButton DelChucVu_Btn;
    public javax.swing.JButton DelDangPhiBtn;
    public javax.swing.JButton DelDoanVienBtn;
    public javax.swing.JButton DelGDBtn;
    public javax.swing.JButton DelGDyBtn;
    public javax.swing.JButton DelGiaoTrinhBtn;
    public javax.swing.JButton DelLuongBtn;
    public javax.swing.JButton DelNCKHBtn;
    public javax.swing.JTable DoanPhi_TBL;
    public javax.swing.JTable GDayBTL;
    public javax.swing.JTable GV_NCKH_TBL;
    public javax.swing.JTable GiaDinhTBL;
    public javax.swing.JTable GiaoTrinh_TBL;
    public javax.swing.JTable Luong_TBL;
    public javax.swing.JTable NCKH_TBL;
    public javax.swing.JButton Print_Btn;
    public javax.swing.JRadioButton RBtn_BBao;
    public javax.swing.JRadioButton RBtn_CBGD;
    public javax.swing.JRadioButton RBtn_CB_BB;
    public javax.swing.JRadioButton RBtn_CB_GDay;
    public javax.swing.JRadioButton RBtn_CB_GTrinh;
    public javax.swing.JRadioButton RBtn_CongDoanVien;
    public javax.swing.JRadioButton RBtn_DoanVien;
    public javax.swing.JRadioButton RBtn_GD;
    public javax.swing.JRadioButton RBtn_GDay;
    public javax.swing.JRadioButton RBtn_GV_NCKH;
    public javax.swing.JRadioButton RBtn_GiaoTrinh;
    public javax.swing.JRadioButton RBtn_NCKH;
    public javax.swing.JRadioButton RBtn_Nu;
    public javax.swing.JRadioButton Rbtn_DangVien;
    public javax.swing.JRadioButton Rbtn_Nam;
    public javax.swing.JTextField TxtCanBoID;
    public javax.swing.JTextField TxtCap;
    public javax.swing.JTextField TxtChiSoISSN;
    public javax.swing.JTextField TxtChuTri;
    public javax.swing.JTextField TxtDiaChi;
    public javax.swing.JTextField TxtEmail;
    public javax.swing.JTextField TxtHeSoIF;
    public javax.swing.JTextField TxtHeSoLuong;
    public javax.swing.JTextField TxtHocKy;
    public javax.swing.JTextField TxtKetQua;
    public javax.swing.JTextField TxtKinhPhi;
    public javax.swing.JTextField TxtLop;
    public javax.swing.JTextField TxtMaBaiBao;
    public javax.swing.JTextField TxtMaSoThue;
    public javax.swing.JTextField TxtMa_ChamThi;
    public javax.swing.JTextField TxtMa_GD;
    public javax.swing.JTextField TxtMa_GT;
    public javax.swing.JTextField TxtMa_Lop;
    public javax.swing.JTextField TxtMa_MH;
    public javax.swing.JTextField TxtNamHoc;
    public javax.swing.JTextField TxtNhaXuatBan;
    public javax.swing.JTextField TxtNoiCongTac;
    public javax.swing.JTextField TxtPhuCap;
    public javax.swing.JTextField TxtSo;
    public javax.swing.JTextField TxtSoBaiThi;
    public javax.swing.JTextField TxtSoDienThoai;
    public javax.swing.JTextField TxtSoGioDay;
    public javax.swing.JTextField TxtSoSinhVien;
    public javax.swing.JTextField TxtSoTTLuong;
    public javax.swing.JTextField TxtSoTaiKhoan;
    public javax.swing.JTextField TxtSoThuTuCongDoanVien;
    public javax.swing.JTextField TxtSoTienDongDangVien;
    public javax.swing.JTextField TxtSoTienDong_CDV;
    public javax.swing.JTextField TxtSoTienDong_DoanVien;
    public javax.swing.JTextField TxtSoTinChi;
    public javax.swing.JTextField TxtSttDangVien;
    public javax.swing.JTextField TxtStt_CBGD;
    public javax.swing.JTextField TxtStt_DoanVien;
    public javax.swing.JTextField TxtStt_GD;
    public javax.swing.JTextField TxtTenCanBo;
    public javax.swing.JTextField TxtTenCb_CDV;
    public javax.swing.JTextField TxtTenCon;
    public javax.swing.JTextField TxtTenDT;
    public javax.swing.JTextField TxtTenDangNhap;
    public javax.swing.JTextField TxtTenGiaoTrinh;
    public javax.swing.JTextField TxtTenMon;
    public javax.swing.JTextField TxtTenTacGia;
    public javax.swing.JTextField TxtTenTapChi;
    public javax.swing.JTextField TxtTen_CBBB;
    public javax.swing.JTextField TxtTen_CBDangVien;
    public javax.swing.JTextField TxtTen_CBGiaDinh;
    public javax.swing.JTextField TxtTen_CBLuong;
    public javax.swing.JTextField TxtTen_CBNCKH;
    public javax.swing.JTextField TxtTen_CB_ChamThi;
    public javax.swing.JTextField TxtTen_GV;
    public javax.swing.JTextField TxtThanhTich;
    public javax.swing.JTextField TxtThanhTichCon;
    public javax.swing.JTextField TxtThongTinKhac;
    public javax.swing.JTextField TxtTinhTrang;
    public javax.swing.JTextField Txt_ChucDanh;
    public javax.swing.JTextField Txt_ChucVu;
    public javax.swing.JTextField Txt_MaDT;
    public javax.swing.JTextField Txt_STT_CB_GDay;
    public javax.swing.JTextField Txt_STT_ChucVu;
    public javax.swing.JTextField Txt_Stt_BB;
    public javax.swing.JTextField Txt_Stt_CBGTrinh;
    public javax.swing.JTextField Txt_Stt_ChucDanh;
    public javax.swing.JTextField Txt_Stt_NCKH;
    public javax.swing.JTextField Txt_TenCB_ChucVu;
    public javax.swing.JTextField Txt_TenCB_GTrinh;
    public javax.swing.JTextField Txt_TenCanBo_DoanVien;
    public javax.swing.JTextField Txt_TrinhDo_Luong;
    public javax.swing.JTextField Txt_tenCB_ChucDanh;
    public javax.swing.JButton UpdateBBBtn;
    public javax.swing.JButton UpdateCDVBtn;
    public javax.swing.JButton UpdateCbBtn;
    public javax.swing.JButton UpdateChamThi_Btn;
    public javax.swing.JButton UpdateChucDanh_Btn;
    public javax.swing.JButton UpdateChucVu_Btn;
    public javax.swing.JButton UpdateDangPhiBtn;
    public javax.swing.JButton UpdateDoanVienBtn;
    public javax.swing.JButton UpdateGDBtn;
    public javax.swing.JButton UpdateGDyBtn;
    public javax.swing.JButton UpdateGiaoTrinhBtn;
    public javax.swing.JButton UpdateLuongBtn;
    public javax.swing.JButton UpdateNCKHBtn;
    public javax.swing.JButton addGDBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    public javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables


}
