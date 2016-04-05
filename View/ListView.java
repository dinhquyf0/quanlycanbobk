/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.CanBo;
import Model.ChamThi;
import Model.GiaDinh;
import Model.GiangDay;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    String s;
    int tuoi = 16;
    String thanhtich = "";
    /**
     * Creates new form ListView
     */
    public ListView() {
        initComponents();
        model = new DefaultTableModel();
    }

    private DefaultTableModel model;
        CanBo canbo = new CanBo();
        ArrayList<CanBo> listcbo = new ArrayList<>();
        GiaDinh gd = new GiaDinh();
        
        GiangDay gday = new GiangDay();
        
        ChamThi ct = new ChamThi();
        ArrayList<ChamThi> listct = new ArrayList<>();
    public void changeTuoi(int tuoi){
        this.tuoi = tuoi;
    }
    
    public void changeThanhTich(String thanhtich){
        this.thanhtich = thanhtich;
    }
        
    public void BindingQua(ArrayList<GiaDinh> listgd){
        
        Vector clums = new Vector();
        clums.add("Mã Cán Bộ");
        clums.add("Tên Cán Bộ");
        clums.add("Mã Gia Đình");
        clums.add("Họ Tên Con");
        clums.add("Tuổi");
        
        model.setColumnIdentifiers(clums);
        Vector data = new Vector();
        for (GiaDinh gd : listgd){
            String ns = gd.getNamSinh();
            int nsi = Integer.parseInt(ns);
            int x;
            int year = Calendar.getInstance().get(Calendar.YEAR);
            x = year -nsi;
            Vector row = new Vector();
            listcbo = canbo.getByIDGD(gd.getMa_GD());

            if(listcbo.size() > 0){
                row.add(listcbo.get(0).getMa_CB());
            }else{
                row.add("isEmpty");
            }
            if(listcbo.size() > 0){
                row.add(listcbo.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            row.add(gd.getMa_GD());
            row.add(gd.getHoVaTenCon());
            if(year - nsi < tuoi){
                row.add(x);
            }else{
                row.removeAll(row);
            }
            data.add(row);
            }
        DefaultTableModel model = new DefaultTableModel(data, clums);
        TNTBL.setModel(model);
        TNTBL.setAutoCreateRowSorter(true);
                TableRowSorter sorter = (TableRowSorter) TNTBL.getRowSorter();
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
        
        
    public void BindingThanhTichCao(ArrayList<GiaDinh> listgd){
        
        Vector clums = new Vector();
        clums.add("Mã Cán Bộ");
        clums.add("Tên Cán Bộ");
        clums.add("Mã Gia Đình");
        clums.add("Họ Tên Con");
        clums.add("Năm Sinh");
        clums.add("Thành Tích");
        
        model.setColumnIdentifiers(clums);
        Vector data = new Vector();
        for (GiaDinh gd : listgd){

            Vector row = new Vector();
            listcbo = canbo.getByIDGD(gd.getMa_GD());
            if(listcbo.size() > 0){
                row.add(listcbo.get(0).getMa_CB());
            }else{
                row.add("isEmpty");
            }
            if(listcbo.size() > 0){
                row.add(listcbo.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            row.add(gd.getMa_GD());
            row.add(gd.getHoVaTenCon());
            row.add(gd.getNamSinh());
            String ThanhTich = gd.getThanhTich();
           if(ThanhTich.contains(thanhtich)){
                row.add(gd.getThanhTich());
            }else{
                row.removeAll(row);
            }
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data, clums);
        TTCTBL.setModel(model);
        TTCTBL.setAutoCreateRowSorter(true);
                TableRowSorter sorter = (TableRowSorter) TTCTBL.getRowSorter();
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
    public void BindingDanhSachChamThi(ArrayList<GiangDay> listgdy){

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
        Vector data = new Vector();
        for (GiangDay gday : listgdy){

            Vector row = new Vector();
            listct = ct.getByIDCT(gday.getMa_MH());
            if(listct.size() > 0){
                row.add(gday.getMa_MH());
            }else{
                row.removeAll(row);
            }
            if(listct.size() > 0){
                row.add(gday.getTenMon());
            }else{
                row.removeAll(row);
            }
            if(listct.size() > 0){
                row.add(gday.getLop());
            }else{
                row.removeAll(row);
            }
            if(listct.size() > 0){
                row.add(gday.getSoSinhVien());
            }else{
                row.removeAll(row);
            }
            if(listct.size() > 0){
                row.add(listct.get(0).getSoBaiThi());
            }else{
                row.add("isEmpty");
            }
           if(listct.size() > 0){
                row.add(listct.get(0).getNgayNop());
            }else{
                row.add("isEmpty");
            }
           if(listct.size() > 0){
                row.add(gday.getHocKy());
            }else{
                row.removeAll(row);
            }
           if(listct.size() > 0){
                row.add(gday.getNamHoc());
            }else{
                row.removeAll(row);
            }
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data, clums);
        BTTBL.setModel(model);
        BTTBL.setAutoCreateRowSorter(true);
                TableRowSorter sorter = (TableRowSorter) BTTBL.getRowSorter();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TNTBL = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        BTTBL = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TTCTBL = new javax.swing.JTable();
        BackBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Chbx_HSG = new javax.swing.JCheckBox();
        Chbx_qua = new javax.swing.JCheckBox();
        Chbx_baithi = new javax.swing.JCheckBox();
        Chbx_header = new javax.swing.JCheckBox();
        Chbx_footer = new javax.swing.JCheckBox();
        Txt_Header = new javax.swing.JTextField();
        Txt_Footer = new javax.swing.JTextField();
        Chbx_show = new javax.swing.JCheckBox();
        Chbx_fit = new javax.swing.JCheckBox();
        Chbx_Interative = new javax.swing.JCheckBox();
        Print_Btn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtThanhTichCacChau = new javax.swing.JTextField();
        TxtTuoiNhanQua = new javax.swing.JTextField();
        ChangeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TNTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TNTBL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách con cái nhận quà", jPanel1);

        BTTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(BTTBL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Danh sách bài thi", jPanel2);

        TTCTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TTCTBL);

        jTabbedPane1.addTab("Danh sách học sinh đạt thành tích cao", jScrollPane1);

        BackBtn.setText("Quay Lại");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tùy chọn In"));

        Chbx_HSG.setText("Các cháu có thành tích");

        Chbx_qua.setText("Các cháu được nhận quà");

        Chbx_baithi.setText("Danh sách bài thi");

        Chbx_header.setText("Header");
        Chbx_header.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chbx_headerActionPerformed(evt);
            }
        });

        Chbx_footer.setText("Footer");
        Chbx_footer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chbx_footerActionPerformed(evt);
            }
        });

        Txt_Header.setEnabled(false);

        Txt_Footer.setEnabled(false);

        Chbx_show.setSelected(true);
        Chbx_show.setText("Hiển thị cửa sổ in");

        Chbx_fit.setSelected(true);
        Chbx_fit.setText("Chỉnh độ rộng cột");

        Chbx_Interative.setSelected(true);
        Chbx_Interative.setText("Tương tác");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Chbx_qua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Chbx_HSG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Chbx_baithi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(Chbx_Interative)))
                .addGap(243, 243, 243))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Chbx_HSG)
                        .addGap(18, 18, 18)
                        .addComponent(Chbx_qua)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Chbx_baithi)
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

        Print_Btn.setText("In");
        Print_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_BtnActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tùy chọn xem"));

        jLabel1.setText("Độ tuổi nhận quà :");

        jLabel2.setText("Thành tích các cháu :");

        ChangeBtn.setText("Thay đổi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtThanhTichCacChau)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(TxtTuoiNhanQua, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ChangeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtTuoiNhanQua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtThanhTichCacChau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChangeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Print_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Print_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if(Chbx_HSG.isSelected()){
            try {
                boolean complete = TTCTBL.print(mode, header, footer, showPrintDialog, null, interactive, null);
                if (complete) {

                    JOptionPane.showMessageDialog(this,
                        "Printing Complete",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Printing Cancelled",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (PrinterException pe) {
                JOptionPane.showMessageDialog(this,
                    "Printing Failed: " + pe.getMessage(),
                    "Printing Result",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        if(Chbx_HSG.isSelected()){
            try {
                boolean complete = TTCTBL.print(mode, header, footer, showPrintDialog, null, interactive, null);
                if (complete) {

                    JOptionPane.showMessageDialog(this,
                        "Printing Complete",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Printing Cancelled",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (PrinterException pe) {
                JOptionPane.showMessageDialog(this,
                    "Printing Failed: " + pe.getMessage(),
                    "Printing Result",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        if(Chbx_qua.isSelected()){
            try {
                boolean complete = TNTBL.print(mode, header, footer, showPrintDialog, null, interactive, null);
                if (complete) {

                    JOptionPane.showMessageDialog(this,
                        "Printing Complete",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Printing Cancelled",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (PrinterException pe) {
                JOptionPane.showMessageDialog(this,
                    "Printing Failed: " + pe.getMessage(),
                    "Printing Result",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        if(Chbx_baithi.isSelected()){
            try {
                boolean complete = BTTBL.print(mode, header, footer, showPrintDialog, null, interactive, null);
                if (complete) {

                    JOptionPane.showMessageDialog(this,
                        "Printing Complete",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Printing Cancelled",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (PrinterException pe) {
                JOptionPane.showMessageDialog(this,
                    "Printing Failed: " + pe.getMessage(),
                    "Printing Result",
                    JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_Print_BtnActionPerformed

    public void BackBtnActionListener(ActionListener al){
        BackBtn.addActionListener(al);
    }
    
    public void ChangeBtnActionListener(ActionListener al){
        ChangeBtn.addActionListener(al);
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
    public javax.swing.JTable BTTBL;
    public javax.swing.JButton BackBtn;
    private javax.swing.JButton ChangeBtn;
    public javax.swing.JCheckBox Chbx_HSG;
    public javax.swing.JCheckBox Chbx_Interative;
    public javax.swing.JCheckBox Chbx_baithi;
    public javax.swing.JCheckBox Chbx_fit;
    public javax.swing.JCheckBox Chbx_footer;
    public javax.swing.JCheckBox Chbx_header;
    public javax.swing.JCheckBox Chbx_qua;
    public javax.swing.JCheckBox Chbx_show;
    public javax.swing.JButton Print_Btn;
    public javax.swing.JTable TNTBL;
    public javax.swing.JTable TTCTBL;
    public javax.swing.JTextField TxtThanhTichCacChau;
    public javax.swing.JTextField TxtTuoiNhanQua;
    public javax.swing.JTextField Txt_Footer;
    public javax.swing.JTextField Txt_Header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
