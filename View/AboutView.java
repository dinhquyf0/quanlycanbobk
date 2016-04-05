/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.BaiBaoTapChi;
import Model.CanBo;
import Model.CanBoCongDoanVien;
import Model.CanBoDangVien;
import Model.CanBoDoanVien;
import Model.ChamThi;
import Model.ChucDanh;
import Model.ChucVu;
import Model.GiaDinh;
import Model.GiangDay;
import Model.GiaoTrinh;
import Model.Luong;
import Model.NghienCuuKhoaHoc;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DINHQUY
 */
public class AboutView extends javax.swing.JFrame {
    String s= "";
    
    String id ="";
    
    CanBo canbo = new CanBo();
    
    GiaDinh gd = new GiaDinh();
    
    Luong l = new Luong();
    
    ChucVu cv = new ChucVu();
    
    ChucDanh cd = new ChucDanh();
    
    CanBoDangVien cbdgv = new CanBoDangVien();
    
    CanBoCongDoanVien cbcdv = new CanBoCongDoanVien();
    
    GiangDay gdy = new GiangDay();
    
    NghienCuuKhoaHoc nckh = new NghienCuuKhoaHoc();
    
    BaiBaoTapChi bb = new BaiBaoTapChi();
    
    GiaoTrinh gt = new GiaoTrinh();
    
    ChamThi ct = new ChamThi();
    
    /**
     * Creates new form AboutView
     */
    public AboutView() {
        initComponents();
        model = new DefaultTableModel();
        
    }
    
    public AboutView(String name_in) {
        initComponents();
        model = new DefaultTableModel();
        TxtcanboID.setText(name_in);
        s = TxtcanboID.getText();
        
    }
    
    private DefaultTableModel model;
    
    public void BindingDoanPhi(ArrayList<CanBoDoanVien> listdv){
        Vector clums = new Vector();
        clums.add("Đoàn Phí");
        clums.add("Thời Gian Đóng");
        model.setColumnIdentifiers(clums);
        Vector data = new Vector();
        for(CanBoDoanVien dv : listdv){
            Vector row = new Vector();
            row.add(dv.getSoTien());
            row.add(dv.getThoiGian());
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data, clums);
        DoanPhi_TBL.setModel(model);
    }
    
    public void BindingChamThi(ArrayList<ChamThi> listct){
        Vector clums = new Vector();
        clums.add("Mã chấm thi");
        clums.add("Mã Lớp");
        clums.add("Mã Môn Học");
        clums.add("Ngày Nộp");
        clums.add("Số Bài Thi");
        model.setColumnIdentifiers(clums);
        Vector data = new Vector();
        for(ChamThi ct : listct){
            Vector row = new Vector();
            row.add(ct.getMa_ChamThi());
            row.add(ct.getMa_lop());
            row.add(ct.getMa_MH());
            row.add(ct.getNgayNop());
            row.add(ct.getSoBaiThi());
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data, clums);
        TBL_ChamThi.setModel(model);
    }
    
    public void BindingGiaoTrinh(ArrayList<GiaoTrinh> listgt){
        Vector clums = new Vector();
        
        clums.add("Mã Giáo Trình");
        clums.add("Tên Giáo Trình");
        clums.add("Tên Tác Giả");
        clums.add("Năm Xuất Bản");
        clums.add("Nhà Xuất Bản");
        
        model.setColumnIdentifiers(clums);
        
        Vector data = new Vector();
        
        for(GiaoTrinh gt : listgt){
            
            Vector row = new Vector();
            
            row.add(gt.getMa_GT());
            row.add(gt.getTenGiaoTrinh());
            row.add(gt.getTenTacGia());
            row.add(gt.getNamXuatBan());
            row.add(gt.getNhaXuatBan());
          
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data,clums);
        TBL_GiaoTrinh.setModel(model);
    }
    
    public void BindingNCKH(ArrayList<NghienCuuKhoaHoc> listnckh){
        
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
        
        Vector data = new Vector();
        
        for(NghienCuuKhoaHoc nckh : listnckh){
            Vector row = new Vector();
            row.add(nckh.getMa_DT());
            row.add(nckh.getTenDeTai());
            row.add(nckh.getCap());
            row.add(nckh.getKinhPhi());
            row.add(nckh.getThoiGianBatDau());
            row.add(nckh.getThoiGianKetThuc());
            row.add(nckh.getChuTriDeTai());
            row.add(nckh.getTinhTrang());
            row.add(nckh.getKetQua());
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data,clums);
        TBL_NCKH.setModel(model);
    }
    
    public void BindingGday(ArrayList<GiangDay> listgdy){
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
        Vector data = new Vector();
        
            for (GiangDay gdy : listgdy) {
            Vector row = new Vector();
            
            row.add(gdy.getMa_MH());
            row.add(gdy.getTenMon());
            row.add(gdy.getSoTinChi());
            row.add(gdy.getLop());
            row.add(gdy.getSoSinhVien());
            row.add(gdy.getHocKy());
            row.add(gdy.getNamHoc());
            row.add(gdy.getPhuCap_GD());
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data, clums);
        TBL_GiangDay.setModel(model);
    }
    
    public void BindingBB(ArrayList<BaiBaoTapChi> listbb){
        
        Vector clums = new Vector();
        clums.add("Mã Tạp Chí");
        clums.add("Tên Tạp Chí");
        clums.add("Số");
        clums.add("Thời Gian Xuất Bản");
        clums.add("Chỉ Số ISSN");
        clums.add("Hệ Số IF");
        
        model.setColumnIdentifiers(clums);
        
        Vector data = new Vector();
        
        for(BaiBaoTapChi bb : listbb){
            Vector row = new Vector();
            row.add(bb.getMa_BaiBao());
            row.add(bb.getTenTapChi());
            row.add(bb.getSo());
            row.add(bb.getThoiGianXuatBan());
            row.add(bb.getChiSo_ISSN());
            row.add(bb.getHeSo_IF());
 
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data,clums);
        TBL_BB_TC.setModel(model);
    }
    
    public void BindingCongDoanPhi(ArrayList<CanBoCongDoanVien> listcdv){
        
        Vector clums = new Vector();
        
        clums.add("Công Đoàn Phí");
        clums.add("Thời Gian Đóng");
        
        model.setColumnIdentifiers(clums);
        Vector data = new Vector();
        for(CanBoCongDoanVien cbcdv : listcdv){
            Vector row = new Vector();
            row.add(cbcdv.getSoTienDong());
            row.add(cbcdv.getThoiGianDong());
            data.add(row);
        }
        DefaultTableModel model =new DefaultTableModel(data, clums);
        CongDoanPhiTBL.setModel(model);
        
        
    }
    
    public void BindingDangPhi(ArrayList<CanBoDangVien> listdgv){
        Vector clums = new Vector();
        
        clums.add("Đảng Phí");
        clums.add("Thời Gian Đóng");
        
        model.setColumnIdentifiers(clums);
        Vector data = new Vector();
        for(CanBoDangVien cbdgv : listdgv){
            Vector row = new Vector();
            row.add(cbdgv.getSoTienThu());
            row.add(cbdgv.getThoiGianDong());
            data.add(row);
        }
        DefaultTableModel model =new DefaultTableModel(data, clums);
        DangPhiTBL.setModel(model);
        
    
    }
    
    public void BindingCD(ArrayList<ChucDanh> listcd){
        Vector clums = new Vector();
        
        clums.add("Chức Danh");
        clums.add("Thời Gian");
        
        model.setColumnIdentifiers(clums);
        Vector data = new Vector();
        for(ChucDanh cd : listcd){
            Vector row = new Vector();
            row.add(cd.getChucDanh());
            row.add(cd.getThoiGianNhan());
            data.add(row);
        }
        DefaultTableModel model =new DefaultTableModel(data, clums);
        ChucDanhTBL.setModel(model);
        
    }
    
    public void BindingCV(ArrayList<ChucVu> listcv){
        
        Vector clums = new Vector();
        
        clums.add("Chức Vụ");
        clums.add("Thời Gian Nhận");
        clums.add("Phụ cấp Chức Vụ");
        
        model.setColumnIdentifiers(clums);
        Vector data = new Vector();
        for(ChucVu cv : listcv){
            Vector row = new Vector();
            
            row.add(cv.getChucVu());
            row.add(cv.getThoiGianNhan());
            row.add(cv.getPhuCap_ChucVu());
            data.add(row);
        }
        DefaultTableModel model =new DefaultTableModel(data, clums);
        ChucVuTBL.setModel(model);
        
    }
    
    public void BindingGD(ArrayList<GiaDinh> listgd){
        
        Vector clums = new Vector();
        clums.add("Họ và Tên Con");
        clums.add("Năm Sinh");
        clums.add("Thành Tích");
        
        model.setColumnIdentifiers(clums);
        Vector data = new Vector();
        
            for (GiaDinh gd : listgd) {
            Vector row = new Vector();
            
            row.add(gd.getHoVaTenCon());
            row.add(gd.getNamSinh());
            row.add(gd.getThanhTich());

            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data, clums);
        GDinhTBL.setModel(model);
        
    }
    
    public void BindingLuong(ArrayList<Luong> listlg){
        Vector clums = new Vector();
        
        clums.add("Hệ Số Lương");
        clums.add("Thời Gian Bắt Đầu");
        
        model.setColumnIdentifiers(clums);
        Vector data = new Vector();
        for(Luong l : listlg){
            Vector row = new Vector();
            
            row.add(l.getHeSoLuong());
            row.add(l.getThoiGianBatDau());
            data.add(row);
        }
        DefaultTableModel model =new DefaultTableModel(data, clums);
        LuongTBL.setModel(model);
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        getDataBtn = new javax.swing.JButton();
        TxtcanboID = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GDinhTBL = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LuongTBL = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ChucVuTBL = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ChucDanhTBL = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        DangPhiTBL = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        CongDoanPhiTBL = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TBL_NCKH = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TBL_GiangDay = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TBL_BB_TC = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TBL_GiaoTrinh = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TBL_ChamThi = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        DoanPhi_TBL = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        Print_About_Btn = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        TxtThongTinKhac = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TxtThanhTich = new javax.swing.JTextField();
        TxtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtSoDienThoai = new javax.swing.JTextField();
        TxtDiaChi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtSoTaiKhoan = new javax.swing.JTextField();
        TxtMaSoThue = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TxtNoiCongTac = new javax.swing.JTextField();
        TxtGioiTinh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtNgaySinh = new javax.swing.JTextField();
        TxtPassword = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TxtTenDangNhap = new javax.swing.JTextField();
        TxtHoVaTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TxtThoiGianCongTac = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TxtTrinhDo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thông Tin Cá Nhân");
        setPreferredSize(new java.awt.Dimension(1090, 800));

        jLabel1.setText("Mã Cán Bộ");

        getDataBtn.setText("Xem");
        getDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getDataBtnActionPerformed(evt);
            }
        });

        TxtcanboID.setEditable(false);
        TxtcanboID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtcanboIDActionPerformed(evt);
            }
        });

        GDinhTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(GDinhTBL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Gia Đình", jPanel1);

        LuongTBL.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(LuongTBL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lương", jPanel3);

        ChucVuTBL.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(ChucVuTBL);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Chức vụ", jPanel4);

        ChucDanhTBL.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(ChucDanhTBL);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Chức danh", jPanel5);

        DangPhiTBL.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(DangPhiTBL);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Đảng Phí", jPanel6);

        CongDoanPhiTBL.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(CongDoanPhiTBL);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Công Đoàn Phí", jPanel7);

        TBL_NCKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(TBL_NCKH);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Nghiên cứu khoa học", jPanel8);

        TBL_GiangDay.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(TBL_GiangDay);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Giảng dạy", jPanel9);

        TBL_BB_TC.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(TBL_BB_TC);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bài Báo - Tạp Chí", jPanel10);

        TBL_GiaoTrinh.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(TBL_GiaoTrinh);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Giáo Trình", jPanel11);

        TBL_ChamThi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(TBL_ChamThi);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Chấm Thi", jPanel12);

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
        jScrollPane12.setViewportView(DoanPhi_TBL);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Đoàn Phí", jPanel14);

        jButton1.setText("Quay lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Print_About_Btn.setText("In");
        Print_About_Btn.setPreferredSize(new java.awt.Dimension(30, 30));
        Print_About_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_About_BtnActionPerformed(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cá nhân", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel12.setText("Thông Tin Khác");

        jLabel11.setText("Thành Tích");

        jLabel10.setText("Email");

        jLabel7.setText("Điện Thoại");

        jLabel9.setText("Địa Chỉ");

        jLabel6.setText("Số Tài Khoản");

        jLabel5.setText("Mã Số Thuế");

        jLabel13.setText("Nơi Công Tác");

        jLabel4.setText("Giới Tính");

        jLabel3.setText("Ngày Sinh");

        jLabel8.setText("Password");

        jLabel14.setText("Tên Đăng Nhập");

        jLabel2.setText("Họ và tên cán bộ");

        jLabel15.setText("Bắt đầu công tác");

        jLabel16.setText("Trình Độ");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtHoVaTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPassword)
                    .addComponent(TxtNgaySinh)
                    .addComponent(TxtSoTaiKhoan)
                    .addComponent(TxtDiaChi)
                    .addComponent(TxtSoDienThoai)
                    .addComponent(TxtEmail)
                    .addComponent(TxtThanhTich)
                    .addComponent(TxtThongTinKhac)
                    .addComponent(TxtGioiTinh)
                    .addComponent(TxtMaSoThue)
                    .addComponent(TxtNoiCongTac)
                    .addComponent(TxtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtThoiGianCongTac)
                    .addComponent(TxtTrinhDo))
                .addGap(25, 25, 25))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TxtDiaChi, TxtEmail, TxtGioiTinh, TxtHoVaTen, TxtMaSoThue, TxtNgaySinh, TxtNoiCongTac, TxtPassword, TxtSoDienThoai, TxtSoTaiKhoan, TxtTenDangNhap, TxtThanhTich, TxtThoiGianCongTac, TxtThongTinKhac, TxtTrinhDo});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(13, 13, 13)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(TxtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNoiCongTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(TxtThoiGianCongTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(TxtTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtMaSoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtSoTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TxtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtThanhTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtThongTinKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Print_About_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtcanboID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(getDataBtn)
                .addGap(487, 487, 487))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getDataBtn)
                    .addComponent(TxtcanboID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print_About_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Print_About_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_About_BtnActionPerformed
        //        Desktop.getDesktop().print(new File("resume.doc"));
    }//GEN-LAST:event_Print_About_BtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void TxtcanboIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtcanboIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtcanboIDActionPerformed

    private void getDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getDataBtnActionPerformed

    }//GEN-LAST:event_getDataBtnActionPerformed

    public void GetBtnActionListener(ActionListener listenforgettbn){
        getDataBtn.addActionListener(listenforgettbn);
    }
    
    public void BackBtnActionListener(ActionListener listenforgetBtn){
        jButton1.addActionListener(listenforgetBtn);
    }
    
    public void PrintBtnActionListener(ActionListener listenforgetBtn){
        Print_About_Btn.addActionListener(listenforgetBtn);
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
            java.util.logging.Logger.getLogger(AboutView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AboutView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AboutView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable ChucDanhTBL;
    public javax.swing.JTable ChucVuTBL;
    public javax.swing.JTable CongDoanPhiTBL;
    public javax.swing.JTable DangPhiTBL;
    public javax.swing.JTable DoanPhi_TBL;
    public javax.swing.JTable GDinhTBL;
    public javax.swing.JTable LuongTBL;
    public javax.swing.JButton Print_About_Btn;
    public javax.swing.JTable TBL_BB_TC;
    public javax.swing.JTable TBL_ChamThi;
    public javax.swing.JTable TBL_GiangDay;
    public javax.swing.JTable TBL_GiaoTrinh;
    public javax.swing.JTable TBL_NCKH;
    public javax.swing.JTextField TxtDiaChi;
    public javax.swing.JTextField TxtEmail;
    public javax.swing.JTextField TxtGioiTinh;
    public javax.swing.JTextField TxtHoVaTen;
    public javax.swing.JTextField TxtMaSoThue;
    public javax.swing.JTextField TxtNgaySinh;
    public javax.swing.JTextField TxtNoiCongTac;
    public javax.swing.JTextField TxtPassword;
    public javax.swing.JTextField TxtSoDienThoai;
    public javax.swing.JTextField TxtSoTaiKhoan;
    public javax.swing.JTextField TxtTenDangNhap;
    public javax.swing.JTextField TxtThanhTich;
    public javax.swing.JTextField TxtThoiGianCongTac;
    public javax.swing.JTextField TxtThongTinKhac;
    public javax.swing.JTextField TxtTrinhDo;
    public javax.swing.JTextField TxtcanboID;
    public javax.swing.JButton getDataBtn;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
