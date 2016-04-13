/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DINHQUY
 */
public class ListView extends javax.swing.JFrame {

    /**
     * Creates new form ListView
     */
    public ListView() {
        initComponents();
        model = new DefaultTableModel();
    }

    private DefaultTableModel model;
        
    public void BindingQua(Vector data){
        
        Vector clums = new Vector();
        clums.add("Mã Cán Bộ");
        clums.add("Tên Cán Bộ");
        clums.add("Mã Gia Đình");
        clums.add("Họ Tên Con");
        clums.add("Tuổi");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data, clums);
        List_TBL.setModel(model);
        List_TBL.setAutoCreateRowSorter(true);
                TableRowSorter sorter = (TableRowSorter) List_TBL.getRowSorter();
                sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
                    @Override
                    public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                        boolean included = true;
                        Object cellValue = entry.getModel().getValueAt(entry.getIdentifier(), 0);
                        if (cellValue == null || cellValue.toString().trim().isEmpty()) {
                            included = false;
                        }
                        return included;
                    }
                });
    
    }
        
    public void BindingThanhTichCao(Vector data){
        
        Vector clums = new Vector();
        clums.add("Mã Cán Bộ");
        clums.add("Tên Cán Bộ");
        clums.add("Mã Gia Đình");
        clums.add("Họ Tên Con");
        clums.add("Năm Sinh");
        clums.add("Thành Tích");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data, clums);
        List_TBL.setModel(model);
        List_TBL.setAutoCreateRowSorter(true);
                TableRowSorter sorter = (TableRowSorter) List_TBL.getRowSorter();
                sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
                    @Override
                    public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                        boolean included = true;
                        Object cellValue = entry.getModel().getValueAt(entry.getIdentifier(), 0);
                        if (cellValue == null || cellValue.toString().trim().isEmpty()) {
                            included = false;
                        }
                        return included;
                    }
                });
    }
    
    public void BindingDanhSachChamThi(Vector data){

        Vector clums = new Vector();
        clums.add("Mã Môn Học");
        clums.add("Tên Môn Học");
        clums.add("Lớp Học");
        clums.add("Số Sinh Viên");
        clums.add("Số Bài Thi");
        clums.add("Ngày Nộp Bài");
        clums.add("Học Kỳ");
        clums.add("Năm Học");

        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data, clums);
        List_TBL.setModel(model);
        List_TBL.setAutoCreateRowSorter(true);
                TableRowSorter sorter = (TableRowSorter) List_TBL.getRowSorter();
                sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
                    @Override
                    public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                        boolean included = true;
                        Object cellValue = entry.getModel().getValueAt(entry.getIdentifier(), 0);
                        if (cellValue == null || cellValue.toString().trim().isEmpty()) {
                            included = false;
                        }
                        return included;
                    }
                });
    }
    
    public void BindingDanhSachMonHoc(Vector data){

        Vector clums = new Vector();
        clums.add("Mã Môn Học");
        clums.add("Tên Môn Học");
        clums.add("Tên Giáo Viên");
        clums.add("Số Tín Chỉ");
        clums.add("Học Kỳ");
        clums.add("Năm Học");

        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data, clums);
        List_TBL.setModel(model);
        List_TBL.setAutoCreateRowSorter(true);
                TableRowSorter sorter = (TableRowSorter) List_TBL.getRowSorter();
                sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
                    @Override
                    public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                        boolean included = true;
                        Object cellValue = entry.getModel().getValueAt(entry.getIdentifier(), 0);
                        if (cellValue == null || cellValue.toString().trim().isEmpty()) {
                            included = false;
                        }
                        return included;
                    }
                });
    }
    
    public void BindingDeTai(Vector data){
        
        Vector clums = new Vector();
        clums.add("Mã Đề Tài");
        clums.add("Chủ Trì Đề Tài");
        clums.add("Tên Đề Tài");
        clums.add("Cấp");
        clums.add("Kinh Phí Thực Hiện");
        clums.add("Thời Gian Bắt Đầu");
        clums.add("Thời Gian Kết Thúc");
        clums.add("Tình Trạng");
        clums.add("Kết Quả");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data, clums);
        List_TBL.setModel(model);
        List_TBL.setAutoCreateRowSorter(true);
    
    }
    
    public void BindingBaiBao(Vector data){
        
        Vector clums = new Vector();
        clums.add("Tên Cán Bộ");
        clums.add("Tên Bài Báo");
        clums.add("Số");
        clums.add("Thời Gian Xuất Bản");
        
        model.setColumnIdentifiers(clums);
        
        DefaultTableModel model = new DefaultTableModel(data, clums);
        List_TBL.setModel(model);
        List_TBL.setAutoCreateRowSorter(true);
        TableRowSorter sorter = (TableRowSorter) List_TBL.getRowSorter();
                sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
                    @Override
                    public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                        boolean included = true;
                        Object cellValue = entry.getModel().getValueAt(entry.getIdentifier(), 0);
                        if (cellValue == null || cellValue.toString().trim().isEmpty()) {
                            included = false;
                        }
                        return included;
                    }
                });
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Chbx_header = new javax.swing.JCheckBox();
        Chbx_footer = new javax.swing.JCheckBox();
        Txt_Header = new javax.swing.JTextField();
        Txt_Footer = new javax.swing.JTextField();
        Chbx_show = new javax.swing.JCheckBox();
        Chbx_fit = new javax.swing.JCheckBox();
        Chbx_Interative = new javax.swing.JCheckBox();
        Print_Btn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        TxtThanhTichCacChau = new javax.swing.JTextField();
        TxtTuoiNhanQua = new javax.swing.JTextField();
        ChangeBtn = new javax.swing.JButton();
        Chbx_ChangeAge = new javax.swing.JCheckBox();
        Chbx_Thaydoithanhtich = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        Chbx_Nam = new javax.swing.JCheckBox();
        Txt_NamHoc = new javax.swing.JTextField();
        Chbx_Hocki = new javax.swing.JCheckBox();
        Txt_Hocki = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        List_TBL = new javax.swing.JTable();
        Cbx_ListTBL = new javax.swing.JComboBox();
        LBL_List_TBL = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Quay lại.png"))); // NOI18N
        BackBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tùy chọn In"));

        Chbx_header.setText("Header");
        Chbx_header.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chbx_header.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chbx_headerActionPerformed(evt);
            }
        });

        Chbx_footer.setText("Footer");
        Chbx_footer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chbx_footer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chbx_footerActionPerformed(evt);
            }
        });

        Txt_Header.setEnabled(false);

        Txt_Footer.setEnabled(false);

        Chbx_show.setSelected(true);
        Chbx_show.setText("Hiển thị cửa sổ in");
        Chbx_show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Chbx_fit.setSelected(true);
        Chbx_fit.setText("Chỉnh độ rộng cột");
        Chbx_fit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Chbx_Interative.setSelected(true);
        Chbx_Interative.setText("Tương tác");
        Chbx_Interative.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Chbx_header)
                            .addComponent(Chbx_footer))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Txt_Footer)
                            .addComponent(Txt_Header, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Chbx_show)
                        .addGap(18, 18, 18)
                        .addComponent(Chbx_fit)
                        .addGap(18, 18, 18)
                        .addComponent(Chbx_Interative))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Chbx_Interative)
                            .addComponent(Chbx_show)
                            .addComponent(Chbx_fit)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Chbx_header)
                            .addComponent(Txt_Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Chbx_footer)
                            .addComponent(Txt_Footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Print_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/In.png"))); // NOI18N
        Print_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Print_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_BtnActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tùy chọn xem"));

        TxtThanhTichCacChau.setEnabled(false);

        TxtTuoiNhanQua.setEnabled(false);
        TxtTuoiNhanQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTuoiNhanQuaActionPerformed(evt);
            }
        });

        ChangeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/đổi độ tuổi.png"))); // NOI18N
        ChangeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Chbx_ChangeAge.setText("Đổi độ tuổi");
        Chbx_ChangeAge.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chbx_ChangeAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chbx_ChangeAgeActionPerformed(evt);
            }
        });

        Chbx_Thaydoithanhtich.setText("Thay đổi thành tích");
        Chbx_Thaydoithanhtich.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chbx_Thaydoithanhtich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chbx_ThaydoithanhtichActionPerformed(evt);
            }
        });

        jLabel3.setText("Thay đổi");

        Chbx_Nam.setText("Năm Học");
        Chbx_Nam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chbx_Nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chbx_NamActionPerformed(evt);
            }
        });

        Txt_NamHoc.setEnabled(false);

        Chbx_Hocki.setText("Học kì");
        Chbx_Hocki.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chbx_Hocki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chbx_HockiActionPerformed(evt);
            }
        });

        Txt_Hocki.setToolTipText("");
        Txt_Hocki.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ChangeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Chbx_ChangeAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Chbx_Nam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(TxtTuoiNhanQua, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Chbx_Thaydoithanhtich)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtThanhTichCacChau, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(Txt_NamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Chbx_Hocki)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Txt_Hocki, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TxtTuoiNhanQua, Txt_NamHoc});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTuoiNhanQua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Chbx_ChangeAge)
                    .addComponent(Chbx_Thaydoithanhtich)
                    .addComponent(TxtThanhTichCacChau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Chbx_Nam)
                    .addComponent(Txt_NamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Chbx_Hocki)
                    .addComponent(Txt_Hocki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("In");

        jLabel2.setText("Quay lại");

        List_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(List_TBL);

        Cbx_ListTBL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        LBL_List_TBL.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jLabel4.setText("Chọn Danh sách xem");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(Cbx_ListTBL, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LBL_List_TBL, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Print_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBL_List_TBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cbx_ListTBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Print_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed

    }//GEN-LAST:event_BackBtnActionPerformed

    private void Chbx_headerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chbx_headerActionPerformed
        if(Chbx_header.isSelected()){
            Txt_Header.setEnabled(true);
        }else{
            Txt_Header.setEnabled(false);
        }
        
    }//GEN-LAST:event_Chbx_headerActionPerformed

    private void Chbx_footerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chbx_footerActionPerformed
        if(Chbx_footer.isSelected()){
            Txt_Footer.setEnabled(true);
        }else{
            Txt_Footer.setEnabled(false);
        }
    }//GEN-LAST:event_Chbx_footerActionPerformed

    private void Print_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_BtnActionPerformed

        MessageFormat header = null;
        if(Chbx_header.isSelected()){
            header = new MessageFormat(Txt_Header.getText());
        }
        MessageFormat footer = null;
        if(Chbx_footer.isSelected()){
            footer = new MessageFormat(Txt_Footer.getText());
        }

        boolean fitWidth = Chbx_fit.isSelected();
        boolean showPrintDialog = Chbx_show.isSelected();
        boolean interactive = Chbx_Interative.isSelected();

        JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH
        : JTable.PrintMode.NORMAL;
        try {
            boolean complete = List_TBL.print(mode, header, footer, showPrintDialog, null, interactive, null);
            if (complete) {

                JOptionPane.showMessageDialog(this,
                    "Xuất báo cáo xong.!",
                    "Kết quả xuất :",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Dừng xuất báo cáo.!",
                    "Kết quả xuất : ",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PrinterException pe) {
            JOptionPane.showMessageDialog(this,
                "Xuất báo cáo lỗi: " + pe.getMessage(),
                "Kết quả xuất : ",
                JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Print_BtnActionPerformed

    private void Chbx_ChangeAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chbx_ChangeAgeActionPerformed
        if(Chbx_ChangeAge.isSelected()){
            TxtTuoiNhanQua.setEnabled(true);
        }else{
            TxtTuoiNhanQua.setEnabled(false);
        }
    }//GEN-LAST:event_Chbx_ChangeAgeActionPerformed

    private void Chbx_ThaydoithanhtichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chbx_ThaydoithanhtichActionPerformed

        if(Chbx_Thaydoithanhtich.isSelected()){
            TxtThanhTichCacChau.setEnabled(true);
        }else{
            TxtThanhTichCacChau.setEnabled(false);
        }

    }//GEN-LAST:event_Chbx_ThaydoithanhtichActionPerformed

    private void TxtTuoiNhanQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTuoiNhanQuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTuoiNhanQuaActionPerformed

    private void Chbx_NamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chbx_NamActionPerformed
        if(Chbx_Hocki.isSelected()){
            Txt_NamHoc.setEnabled(true);
        }else{
            Txt_NamHoc.setEnabled(false);
        }
    }//GEN-LAST:event_Chbx_NamActionPerformed

    private void Chbx_HockiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chbx_HockiActionPerformed
        if(Chbx_Hocki.isSelected()){
            Txt_Hocki.setEnabled(true);
        }else{
            Txt_Hocki.setEnabled(false);
        }
    }//GEN-LAST:event_Chbx_HockiActionPerformed

    public void BackBtnActionListener(ActionListener al){
        BackBtn.addActionListener(al);
    }
    
    public void ChangeBtnActionListener(ActionListener al){
        ChangeBtn.addActionListener(al);
    }
    
    public void ChangCbxListTBLActionListener(ActionListener al){
        Cbx_ListTBL.addActionListener(al);
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
            java.util.logging.Logger.getLogger(ListView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BackBtn;
    public javax.swing.JComboBox Cbx_ListTBL;
    private javax.swing.JButton ChangeBtn;
    public javax.swing.JCheckBox Chbx_ChangeAge;
    public javax.swing.JCheckBox Chbx_Hocki;
    public javax.swing.JCheckBox Chbx_Interative;
    public javax.swing.JCheckBox Chbx_Nam;
    public javax.swing.JCheckBox Chbx_Thaydoithanhtich;
    public javax.swing.JCheckBox Chbx_fit;
    public javax.swing.JCheckBox Chbx_footer;
    public javax.swing.JCheckBox Chbx_header;
    public javax.swing.JCheckBox Chbx_show;
    public javax.swing.JLabel LBL_List_TBL;
    private javax.swing.JTable List_TBL;
    public javax.swing.JButton Print_Btn;
    public javax.swing.JTextField TxtThanhTichCacChau;
    public javax.swing.JTextField TxtTuoiNhanQua;
    public javax.swing.JTextField Txt_Footer;
    public javax.swing.JTextField Txt_Header;
    public javax.swing.JTextField Txt_Hocki;
    public javax.swing.JTextField Txt_NamHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
