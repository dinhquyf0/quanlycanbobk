/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author DINHQUY
 */
public class AboutView extends javax.swing.JFrame {
    String s= "";
    String id ="";
    
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
    
    public void BindingDoanPhi(Vector data){
        Vector clums = new Vector();
        clums.add("Đoàn Phí");
        clums.add("Thời Gian Đóng");
        model.setColumnIdentifiers(clums);

        DefaultTableModel model = new DefaultTableModel(data, clums);
        DoanPhi_TBL.setModel(model);
        jTable1.setModel(model);
    }
    
    public void BindingChamThi(Vector data){
        Vector clums = new Vector();
        clums.add("Mã chấm thi");
        clums.add("Mã Lớp");
        clums.add("Mã Môn Học");
        clums.add("Ngày Nộp");
        clums.add("Số Bài Thi");
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data, clums);
        TBL_ChamThi.setModel(model);
        jTable1.setModel(model);
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
        TBL_GiaoTrinh.setModel(model);
        jTable1.setModel(model);
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
        TBL_NCKH.setModel(model);
        jTable1.setModel(model);
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
        TBL_GiangDay.setModel(model);
        jTable1.setModel(model);
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
        TBL_BB_TC.setModel(model);
        jTable1.setModel(model);
    }
    
    public void BindingCongDoanPhi(Vector data){
        
        Vector clums = new Vector();
        
        clums.add("Công Đoàn Phí");
        clums.add("Thời Gian Đóng");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model =new DefaultTableModel(data, clums);
        CongDoanPhiTBL.setModel(model);
        jTable1.setModel(model);
        
    }
    
    public void BindingDangPhi(Vector data){
        Vector clums = new Vector();
        
        clums.add("Đảng Phí");
        clums.add("Thời Gian Đóng");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data, clums);
        DangPhiTBL.setModel(model);
        jTable1.setModel(model);
    
    }
    
    public void BindingCD(Vector data){
        Vector clums = new Vector();
        
        clums.add("Chức Danh");
        clums.add("Thời Gian");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model =new DefaultTableModel(data, clums);
        ChucDanhTBL.setModel(model);
        jTable1.setModel(model);
    }
    
    public void BindingCV(Vector data){
        
        Vector clums = new Vector();
        
        clums.add("Chức Vụ");
        clums.add("Thời Gian Nhận");
        clums.add("Phụ cấp Chức Vụ");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model =new DefaultTableModel(data, clums);
        ChucVuTBL.setModel(model);
        jTable1.setModel(model);
    }
    
    public void BindingGD(Vector data){
        
        Vector clums = new Vector();
        clums.add("Họ và Tên Con");
        clums.add("Năm Sinh");
        clums.add("Thành Tích");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data, clums);
        GDinhTBL.setModel(model);
        jTable1.setModel(model);
    }
    
    public void BindingLuong(Vector data){
        Vector clums = new Vector();
        
        clums.add("Hệ Số Lương");
        clums.add("Thời Gian Bắt Đầu");
        
        model.setColumnIdentifiers(clums);
       
        
        DefaultTableModel model =new DefaultTableModel(data, clums);
        LuongTBL.setModel(model);
        jTable1.setModel(model);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane13 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        getDataBtn = new javax.swing.JButton();
        TxtcanboID = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel_GiaDinh = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GDinhTBL = new javax.swing.JTable();
        jPanel_Luong = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LuongTBL = new javax.swing.JTable();
        jPanel_ChucVu = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ChucVuTBL = new javax.swing.JTable();
        jPanel_ChucDanh = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ChucDanhTBL = new javax.swing.JTable();
        jPanel_DangPhi = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        DangPhiTBL = new javax.swing.JTable();
        JPanel_CongDoanPhi = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        CongDoanPhiTBL = new javax.swing.JTable();
        jPanel_NCKH = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TBL_NCKH = new javax.swing.JTable();
        jPanel_GiangDay = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TBL_GiangDay = new javax.swing.JTable();
        jPanel_BaiBao = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TBL_BB_TC = new javax.swing.JTable();
        jPanel_GiaoTrinh = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TBL_GiaoTrinh = new javax.swing.JTable();
        jPanel_ChamThi = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TBL_ChamThi = new javax.swing.JTable();
        jPanel_DoanPhi = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        DoanPhi_TBL = new javax.swing.JTable();
        jPanel_ThongKeTaiChinh = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        LBL_TienNCKH = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        LBL_TienBaiBao = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        LBL_TienGiangDay = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        LBL_TienChamTHi = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        LBL_TienLuongThang = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        LBL_DangPhi = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        LBL_DoanPhi = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        LBL_CongDoanPhi = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Print_About_Btn = new javax.swing.JButton();
        jPanel_thongtincanhan = new javax.swing.JPanel();
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
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane13.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thông Tin Cá Nhân");

        jLabel1.setText("Mã Cán Bộ");

        getDataBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/XemCB.png"))); // NOI18N
        getDataBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        javax.swing.GroupLayout jPanel_GiaDinhLayout = new javax.swing.GroupLayout(jPanel_GiaDinh);
        jPanel_GiaDinh.setLayout(jPanel_GiaDinhLayout);
        jPanel_GiaDinhLayout.setHorizontalGroup(
            jPanel_GiaDinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        jPanel_GiaDinhLayout.setVerticalGroup(
            jPanel_GiaDinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_GiaDinhLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gia Đình", jPanel_GiaDinh);

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

        javax.swing.GroupLayout jPanel_LuongLayout = new javax.swing.GroupLayout(jPanel_Luong);
        jPanel_Luong.setLayout(jPanel_LuongLayout);
        jPanel_LuongLayout.setHorizontalGroup(
            jPanel_LuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        jPanel_LuongLayout.setVerticalGroup(
            jPanel_LuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lương", jPanel_Luong);

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

        javax.swing.GroupLayout jPanel_ChucVuLayout = new javax.swing.GroupLayout(jPanel_ChucVu);
        jPanel_ChucVu.setLayout(jPanel_ChucVuLayout);
        jPanel_ChucVuLayout.setHorizontalGroup(
            jPanel_ChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        jPanel_ChucVuLayout.setVerticalGroup(
            jPanel_ChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Chức vụ", jPanel_ChucVu);

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

        javax.swing.GroupLayout jPanel_ChucDanhLayout = new javax.swing.GroupLayout(jPanel_ChucDanh);
        jPanel_ChucDanh.setLayout(jPanel_ChucDanhLayout);
        jPanel_ChucDanhLayout.setHorizontalGroup(
            jPanel_ChucDanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        jPanel_ChucDanhLayout.setVerticalGroup(
            jPanel_ChucDanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Chức danh", jPanel_ChucDanh);

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

        javax.swing.GroupLayout jPanel_DangPhiLayout = new javax.swing.GroupLayout(jPanel_DangPhi);
        jPanel_DangPhi.setLayout(jPanel_DangPhiLayout);
        jPanel_DangPhiLayout.setHorizontalGroup(
            jPanel_DangPhiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        jPanel_DangPhiLayout.setVerticalGroup(
            jPanel_DangPhiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Đảng Phí", jPanel_DangPhi);

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

        javax.swing.GroupLayout JPanel_CongDoanPhiLayout = new javax.swing.GroupLayout(JPanel_CongDoanPhi);
        JPanel_CongDoanPhi.setLayout(JPanel_CongDoanPhiLayout);
        JPanel_CongDoanPhiLayout.setHorizontalGroup(
            JPanel_CongDoanPhiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        JPanel_CongDoanPhiLayout.setVerticalGroup(
            JPanel_CongDoanPhiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Công Đoàn Phí", JPanel_CongDoanPhi);

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

        javax.swing.GroupLayout jPanel_NCKHLayout = new javax.swing.GroupLayout(jPanel_NCKH);
        jPanel_NCKH.setLayout(jPanel_NCKHLayout);
        jPanel_NCKHLayout.setHorizontalGroup(
            jPanel_NCKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        jPanel_NCKHLayout.setVerticalGroup(
            jPanel_NCKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Nghiên cứu khoa học", jPanel_NCKH);

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

        javax.swing.GroupLayout jPanel_GiangDayLayout = new javax.swing.GroupLayout(jPanel_GiangDay);
        jPanel_GiangDay.setLayout(jPanel_GiangDayLayout);
        jPanel_GiangDayLayout.setHorizontalGroup(
            jPanel_GiangDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        jPanel_GiangDayLayout.setVerticalGroup(
            jPanel_GiangDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Giảng dạy", jPanel_GiangDay);

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

        javax.swing.GroupLayout jPanel_BaiBaoLayout = new javax.swing.GroupLayout(jPanel_BaiBao);
        jPanel_BaiBao.setLayout(jPanel_BaiBaoLayout);
        jPanel_BaiBaoLayout.setHorizontalGroup(
            jPanel_BaiBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        jPanel_BaiBaoLayout.setVerticalGroup(
            jPanel_BaiBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BaiBaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bài Báo - Tạp Chí", jPanel_BaiBao);

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

        javax.swing.GroupLayout jPanel_GiaoTrinhLayout = new javax.swing.GroupLayout(jPanel_GiaoTrinh);
        jPanel_GiaoTrinh.setLayout(jPanel_GiaoTrinhLayout);
        jPanel_GiaoTrinhLayout.setHorizontalGroup(
            jPanel_GiaoTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        jPanel_GiaoTrinhLayout.setVerticalGroup(
            jPanel_GiaoTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_GiaoTrinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Giáo Trình", jPanel_GiaoTrinh);

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

        javax.swing.GroupLayout jPanel_ChamThiLayout = new javax.swing.GroupLayout(jPanel_ChamThi);
        jPanel_ChamThi.setLayout(jPanel_ChamThiLayout);
        jPanel_ChamThiLayout.setHorizontalGroup(
            jPanel_ChamThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        jPanel_ChamThiLayout.setVerticalGroup(
            jPanel_ChamThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Chấm Thi", jPanel_ChamThi);

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

        javax.swing.GroupLayout jPanel_DoanPhiLayout = new javax.swing.GroupLayout(jPanel_DoanPhi);
        jPanel_DoanPhi.setLayout(jPanel_DoanPhiLayout);
        jPanel_DoanPhiLayout.setHorizontalGroup(
            jPanel_DoanPhiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        jPanel_DoanPhiLayout.setVerticalGroup(
            jPanel_DoanPhiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Đoàn Phí", jPanel_DoanPhi);

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setText("Tiền từ nguồn khác");

        jLabel24.setText("Tiền nghiên cứu khoa học :");

        jLabel26.setText("VND");

        jLabel27.setText("Tiền bài báo - tạp chí :");

        jLabel28.setText("VND");

        jLabel29.setText("Tiền giảng dạy :");

        jLabel30.setText("VND");

        jLabel31.setText("Tiền chấm thi :");

        jLabel32.setText("VND");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel21))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel27))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(LBL_TienNCKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(LBL_TienBaiBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LBL_TienGiangDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LBL_TienChamTHi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel26)
                            .addComponent(jLabel30)
                            .addComponent(jLabel32))))
                .addContainerGap())
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel31))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBL_TienNCKH, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(LBL_TienBaiBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30)
                    .addComponent(LBL_TienGiangDay, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel32)
                    .addComponent(LBL_TienChamTHi, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setText("Lương");

        jLabel23.setText("Lương tháng :");

        jLabel25.setText("VND");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel20))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addComponent(LBL_TienLuongThang, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_TienLuongThang, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setText("Phụ phí");

        jLabel33.setText("Đảng phí :");

        jLabel34.setText("VND");

        jLabel35.setText("Đoàn phí :");

        jLabel37.setText("VND");

        jLabel36.setText("Công đoàn phí :");

        jLabel39.setText("VND");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(90, 90, 90))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBL_CongDoanPhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LBL_DoanPhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36))
                                .addGap(0, 64, Short.MAX_VALUE))
                            .addComponent(LBL_DangPhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel34)
                            .addComponent(jLabel37))))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(72, 72, 72))
                            .addComponent(jLabel39)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBL_DangPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LBL_DoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(LBL_CongDoanPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel_ThongKeTaiChinhLayout = new javax.swing.GroupLayout(jPanel_ThongKeTaiChinh);
        jPanel_ThongKeTaiChinh.setLayout(jPanel_ThongKeTaiChinhLayout);
        jPanel_ThongKeTaiChinhLayout.setHorizontalGroup(
            jPanel_ThongKeTaiChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_ThongKeTaiChinhLayout.setVerticalGroup(
            jPanel_ThongKeTaiChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thông kê tài chính", jPanel_ThongKeTaiChinh);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Quay lại.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Print_About_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/In.png"))); // NOI18N
        Print_About_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Print_About_Btn.setPreferredSize(new java.awt.Dimension(30, 30));
        Print_About_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_About_BtnActionPerformed(evt);
            }
        });

        jPanel_thongtincanhan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cá nhân", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        TxtThongTinKhac.setEditable(false);

        jLabel12.setText("Thông Tin Khác");

        jLabel11.setText("Thành Tích");

        TxtThanhTich.setEditable(false);

        TxtEmail.setEditable(false);

        jLabel10.setText("Email");

        jLabel7.setText("Điện Thoại");

        TxtSoDienThoai.setEditable(false);

        TxtDiaChi.setEditable(false);

        jLabel9.setText("Địa Chỉ");

        jLabel6.setText("Số Tài Khoản");

        TxtSoTaiKhoan.setEditable(false);

        TxtMaSoThue.setEditable(false);

        jLabel5.setText("Mã Số Thuế");

        jLabel13.setText("Nơi Công Tác");

        TxtNoiCongTac.setEditable(false);

        TxtGioiTinh.setEditable(false);

        jLabel4.setText("Giới Tính");

        jLabel3.setText("Ngày Sinh");

        TxtNgaySinh.setEditable(false);

        TxtPassword.setEditable(false);

        jLabel8.setText("Password");

        jLabel14.setText("Tên Đăng Nhập");

        TxtTenDangNhap.setEditable(false);

        TxtHoVaTen.setEditable(false);

        jLabel2.setText("Họ và tên cán bộ");

        jLabel15.setText("Bắt đầu công tác");

        TxtThoiGianCongTac.setEditable(false);

        jLabel16.setText("Trình Độ");

        TxtTrinhDo.setEditable(false);

        javax.swing.GroupLayout jPanel_thongtincanhanLayout = new javax.swing.GroupLayout(jPanel_thongtincanhan);
        jPanel_thongtincanhan.setLayout(jPanel_thongtincanhanLayout);
        jPanel_thongtincanhanLayout.setHorizontalGroup(
            jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_thongtincanhanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_thongtincanhanLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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

        jPanel_thongtincanhanLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TxtDiaChi, TxtEmail, TxtGioiTinh, TxtHoVaTen, TxtMaSoThue, TxtNgaySinh, TxtNoiCongTac, TxtPassword, TxtSoDienThoai, TxtSoTaiKhoan, TxtTenDangNhap, TxtThanhTich, TxtThoiGianCongTac, TxtThongTinKhac, TxtTrinhDo});

        jPanel_thongtincanhanLayout.setVerticalGroup(
            jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_thongtincanhanLayout.createSequentialGroup()
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(13, 13, 13)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(TxtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNoiCongTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(TxtThoiGianCongTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(TxtTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtMaSoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtSoTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TxtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtThanhTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtThongTinKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setText("XEM");

        jLabel18.setText("Xuất báo cáo");

        jLabel19.setText("Quay Lại");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtcanboID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(getDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(456, 456, 456))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Print_About_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel_thongtincanhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtcanboID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(getDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_thongtincanhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Print_About_Btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static class Printer implements Printable {
        final Component comp;

        public Printer(Component comp){
            this.comp = comp;
        }

        @Override
        public int print(Graphics g, PageFormat format, int page_index) 
                throws PrinterException {
            if (page_index > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            // get the bounds of the component
            Dimension dim = comp.getSize();
            double cHeight = dim.getHeight();
            double cWidth = dim.getWidth();

            // get the bounds of the printable area
            double pHeight = format.getImageableHeight();
            double pWidth = format.getImageableWidth();

            double pXStart = format.getImageableX();
            double pYStart = format.getImageableY();

            double xRatio = pWidth / cWidth;
            double yRatio = pHeight / cHeight;


            Graphics2D g2 = (Graphics2D) g;
            g2.translate(pXStart, pYStart);
            g2.scale(xRatio, yRatio);
            comp.paint(g2);

            return Printable.PAGE_EXISTS;
        }
    }
    
    JFrame frame = new JFrame();
    
    public void doPrint1(JPanel panel){
        
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.PAGE_START);
        frame.setSize(1000,1000);
        frame.setLocation(500, 200);
        frame.setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat preformat = pjob.defaultPage();
        PageFormat postformat = pjob.pageDialog(preformat);
        preformat.setOrientation(PageFormat.LANDSCAPE);
        if (preformat != postformat) {
            pjob.setPrintable(new Printer(frame), postformat);
            if (pjob.printDialog()) {
                try {
                    pjob.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(AboutView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void toExcel(JTable table, File file){    
        try{
            TableModel model = table.getModel();
            FileWriter excel = new FileWriter(file);
            BufferedWriter bw=new BufferedWriter(excel);
            for(int i = 0; i < model.getColumnCount(); i++){
                bw.write(model.getColumnName(i) + "\t");
                }

            bw.write("\n");

            for(int i=0; i< model.getRowCount(); i++) {
                for(int j=0; j < model.getColumnCount(); j++) {
                    String string = model.getValueAt(i,j).toString()+"\t";
                    byte[] utf8 = string.getBytes("UTF-8");
    
                    string = new String(utf8, "UTF-8");
                    bw.write(string);
                }
                bw.write("\n");
            }
        bw.close();
        }catch(IOException e){ System.out.println(e); }
        }
    
    private void Print_About_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_About_BtnActionPerformed
        
        String input = JOptionPane.showInputDialog(this,"chọn phương thức xuất báo cáo(1/n) :");
        switch (input) {
            case "1":
                String input1 = JOptionPane.showInputDialog(this,"Chọn bảng xuất(Thông tin cá nhân hoặc các bảng liên quan) :");
                switch (input1) {
                    case "Thông tin cá nhân":
                        doPrint1(jPanel_thongtincanhan);
                        break;
                    case"Gia đình":
                        doPrint1(jPanel_GiaDinh);
                        break;
                    case "Lương" :
                        doPrint1(jPanel_Luong);
                        break;
                    case "Bài Báo - Tạp Chí":
                        doPrint1(jPanel_BaiBao);
                        break;
                    case "Chức vụ":
                        doPrint1(jPanel_ChucVu);
                        break;
                    case "Chức danh":
                        doPrint1(jPanel_ChucDanh);
                        break;
                    case "Đảng Phí":
                        doPrint1(jPanel_DangPhi);
                        break;
                    case "Đoàn Phí":
                        doPrint1(jPanel_DoanPhi);
                        break;
                    case "Công Đoàn Phí":
                        doPrint1(JPanel_CongDoanPhi);
                        break;
                    case "Nghiên cứu khoa học":
                        doPrint1(jPanel_NCKH);
                        break;
                    case "Giảng dạy":
                        doPrint1(jPanel_GiangDay);
                        break;
                    case "Giáo Trình":
                        doPrint1(jPanel_GiaoTrinh);
                        break;
                    case "Chấm Thi":
                        doPrint1(jPanel_ChamThi);
                        break;
                    case "Thông kê tài chính":
                        doPrint1(jPanel_ThongKeTaiChinh);
                        break;
                }
                break;
            case"n":
                doPrint1(jPanel_thongtincanhan);
                
                JFileChooser fc = new JFileChooser();
                    int option = fc.showSaveDialog(AboutView.this);
                    if(option == JFileChooser.APPROVE_OPTION){
                        String filename = fc.getSelectedFile().getName(); 
                        String path = fc.getSelectedFile().getParentFile().getPath();

                        int len = filename.length();
                        String ext = "";
                        String file = "";

                        if(len > 4){
                            ext = filename.substring(len-4, len);
                        }

                        if(ext.equals(".xls")){
                            file = path + "\\" + filename; 
                        }else{
                            file = path + "\\" + filename + ".xls"; 
                        }
                            toExcel(jTable1, new File(file));
                    }
                break;
        }
        
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
    public javax.swing.JPanel JPanel_CongDoanPhi;
    public javax.swing.JLabel LBL_CongDoanPhi;
    public javax.swing.JLabel LBL_DangPhi;
    public javax.swing.JLabel LBL_DoanPhi;
    public javax.swing.JLabel LBL_TienBaiBao;
    public javax.swing.JLabel LBL_TienChamTHi;
    public javax.swing.JLabel LBL_TienGiangDay;
    public javax.swing.JLabel LBL_TienLuongThang;
    public javax.swing.JLabel LBL_TienNCKH;
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
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel_BaiBao;
    public javax.swing.JPanel jPanel_ChamThi;
    public javax.swing.JPanel jPanel_ChucDanh;
    public javax.swing.JPanel jPanel_ChucVu;
    public javax.swing.JPanel jPanel_DangPhi;
    public javax.swing.JPanel jPanel_DoanPhi;
    public javax.swing.JPanel jPanel_GiaDinh;
    public javax.swing.JPanel jPanel_GiangDay;
    public javax.swing.JPanel jPanel_GiaoTrinh;
    public javax.swing.JPanel jPanel_Luong;
    public javax.swing.JPanel jPanel_NCKH;
    public javax.swing.JPanel jPanel_ThongKeTaiChinh;
    public javax.swing.JPanel jPanel_thongtincanhan;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
