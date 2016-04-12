/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import Model.GiangDay;
import Model.GiangVien_GiangDay;
import ModelDAO.GiangDayDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author dinhq
 */
public class GiangDayController extends CheckEmpty {
    Insertlog isl = new Insertlog();
    GiangDayDAO gdd = new GiangDayDAO();
    public ChangeView cw;
    public GiangDay gd;
    public GiangVien_GiangDay gvgd;
    private CanBo cb;
    
    ArrayList<GiangDay> listgd = new ArrayList<>();
    ArrayList<GiangVien_GiangDay> listgvgd = new ArrayList<>();
    ArrayList<CanBo> listcbo = new ArrayList<>();
    
    public GiangDayController(GiangDay gd, GiangVien_GiangDay gvgd, GiangDayDAO gdd, ChangeView cw, CanBo cb) {
        this.gd = gd;
        this.gvgd = gvgd;
        this.gdd = gdd;
        this.cw = cw;
        this.cb = cb;
        this.cw.AddGiangDayBtnActionListener(new GiangDayController.AddGiangDayListener());
        this.cw.UpdateGiangDayBtnActionListener(new GiangDayController.UpdateGiangDayListener());
        this.cw.DelGiangDayBtnActionListener(new GiangDayController.DelGiangDayListener());
        this.cw.ClickTableCB_GiangDay(new GiangDayController.ClickTableCanBo_GiangDay());
        this.cw.ClickTableGiangDay(new GiangDayController.ClickTableGiangDay());
        
        BindingGiangDay();
        cw.BindingMaMH(gd.getALL());
    }

    private void BindingGiangDay(){
        cw.BindingGday(gdd.loadTableGiangDay());
        cw.BindingGV_GiangDay(gdd.loadTableGiangVien_GiangDay());
    }

    private class ClickTableCanBo_GiangDay implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
             if (cw.CB_GDay_TBL.getSelectedRow() != -1) {
            int row = cw.CB_GDay_TBL.getSelectedRow();

            listgvgd = gvgd.getALLGVGD();
            listcbo = cb.getByID(listgvgd.get(row).getMa_CB());
            if (listcbo.size() > 0) {
                cw.CB_MaCB_Gday.setSelectedItem(listcbo.get(0).getMa_CB());
            } else {
                cw.CB_MaCB_Gday.setSelectedIndex(0);
            }
            cw.Txt_STT_CB_GDay.setText(listgvgd.get(row).getStt());
            cw.TxtTen_GV.setText(listcbo.get(0).getHoVaTen());
            cw.CB_Ma_MH.setSelectedItem(listgvgd.get(row).getMa_MH());
            
        }
        
        }

    }

    private class ClickTableGiangDay implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {

            if (cw.GDayBTL.getSelectedRow() != -1) {
                int row = cw.GDayBTL.getSelectedRow();
                listgd = gd.getALL();


                cw.TxtMa_MH.setText(listgd.get(row).getMa_MH());
                cw.TxtTenMon.setText(listgd.get(row).getTenMon());
                cw.TxtSoTinChi.setText(listgd.get(row).getSoTinChi());
                cw.TxtLop.setText(listgd.get(row).getLop());
                cw.TxtSoSinhVien.setText(listgd.get(row).getSoSinhVien());
                cw.TxtHocKy.setText(listgd.get(row).getHocKy());
                cw.TxtNamHoc.setText(listgd.get(row).getNamHoc());
                cw.TxtPhuCap.setText(listgd.get(row).getPhuCap_GD());
            }
        
        }

    }

    private  class DelGiangDayListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(cw.RBtn_GDay.isSelected()==false && cw.RBtn_CB_GDay.isSelected()==false){
                JOptionPane.showMessageDialog(cw, "Đề nghị chọn bảng để thực hiện thao tác này");
            }
            
            if(cw.RBtn_CB_GDay.isSelected()){
                gdd.DelCanBo_GiangDay(cw.CB_GDay_TBL);
                 cw.BindingGV_GiangDay(gdd.loadTableGiangVien_GiangDay());
            }
            if(cw.RBtn_GDay.isSelected()){
                gdd.DelGiangDay(cw.GDayBTL);
                isl.theQuery("INSERT INTO Log (NoiDung) value('Xóa thông tin giảng dạy của 1 môn học')");
                cw.BindingGday(gdd.loadTableGiangDay());
            }
           
        }
           
    }
    
 
    
    private  class UpdateGiangDayListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            listgd = gd.getALL();
            listgvgd = gvgd.getALLGVGD();
            
            int row1 = cw.GDayBTL.getSelectedRow();
            int row2 = cw.CB_GDay_TBL.getSelectedRow();
            
            if(cw.RBtn_GDay.isSelected()==false && cw.RBtn_CB_GDay.isSelected()==false){
                JOptionPane.showMessageDialog(cw, "Đề nghị chọn bảng để thực hiện thao tác này");
            }
            
            if(cw.RBtn_GDay.isSelected()){
                String Ma_MH = listgd.get(row1).getMa_MH();
                String TenMon = cw.TxtMa_GD.getText();
                String SoTinChi = cw.TxtTenCon.getText();
                String Lop = cw.Cbx_NamSinh_Con.getSelectedItem().toString();
                String SoSinhVien = cw.TxtThanhTichCon.getText();
                String HocKy = cw.TxtHocKy.getText();
                String NamHoc = cw.TxtNamHoc.getText();
                String PhuCap_GD = cw.TxtPhuCap.getText();
                gdd.UpdateGiangDay(Ma_MH, TenMon, SoTinChi, Lop, SoSinhVien, HocKy, NamHoc, PhuCap_GD);
                isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật thông tin giảng dạy của 1 môn học')");
                 cw.BindingGday(gdd.loadTableGiangDay());
            }
            if(cw.RBtn_CB_GDay.isSelected()){
                 String stt = listgvgd.get(row2).getStt();
                String Ma_mh = cw.CB_Ma_MH.getSelectedItem().toString();
                String Ma_cb = cw.CB_MaCB_Gday.getSelectedItem().toString();
                gdd.UpdateGiangVien_GiangDay(stt, Ma_cb, Ma_mh);
                 cw.BindingGV_GiangDay(gdd.loadTableGiangVien_GiangDay());
            }
            
        }
    }

    private class AddGiangDayListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String Ma_MH = cw.TxtMa_MH.getText();
            String TenMon = cw.TxtMa_GD.getText();
            String SoTinChi = cw.TxtTenCon.getText();
            String Lop = cw.Cbx_NamSinh_Con.getSelectedItem().toString();
            String SoSinhVien = cw.TxtThanhTichCon.getText();
            String HocKy = cw.TxtHocKy.getText();
            String NamHoc = cw.TxtNamHoc.getText();
            String PhuCap_GD = cw.TxtPhuCap.getText();
            
            String stt = cw.Txt_STT_CB_GDay.getText();
            String Ma_mh = cw.CB_Ma_MH.getSelectedItem().toString();
            String Ma_cb = cw.CB_MaCB_Gday.getSelectedItem().toString();
            
            if(cw.RBtn_GDay.isSelected()==false && cw.RBtn_CB_GDay.isSelected()==false){
                JOptionPane.showMessageDialog(cw, "Đề nghị chọn bảng để thực hiện thao tác này");
            }
            
            if(cw.RBtn_GDay.isSelected()){
                if (!checkEmpty(cw.TxtMa_MH, Ma_MH, "Mã Môn Học")) {
                    return;
                }else {
                    gdd.AddGiangDay(Ma_MH, TenMon, SoTinChi, Lop, SoSinhVien, HocKy, NamHoc, PhuCap_GD);
                    isl.theQuery("INSERT INTO Log (NoiDung) value('Thêm thông tin giảng dạy của 1 môn học')");
                    cw.BindingGday(gdd.loadTableGiangDay());
                }
            }
            
            if(cw.RBtn_CB_GDay.isSelected()){
                if(!checkEmpty(cw.TxtStt_CBGD , stt, "Số thứ tự")){
                    return;
                }else{
                    gdd.AddGiangVien_GiangDay(stt, Ma_cb, Ma_mh);
                    cw.BindingGV_GiangDay(gdd.loadTableGiangVien_GiangDay());
                }
            }
            
        }
     
    }
}
