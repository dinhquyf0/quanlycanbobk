/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GiangDay;
import Model.GiangVien_GiangDay;
import ModelDAO.GiangDayDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    
    ArrayList<GiangDay> listgd = new ArrayList<>();
    ArrayList<GiangVien_GiangDay> listgvgd = new ArrayList<>();
    
    public GiangDayController(GiangDay gd, GiangVien_GiangDay gvgd, GiangDayDAO gdd, ChangeView cw) {
        this.gd = gd;
        this.gvgd = gvgd;
        this.gdd = gdd;
        this.cw = cw;
        this.cw.AddGiangDayBtnActionListener(new GiangDayController.AddGiangDayListener());
        this.cw.UpdateGiangDayBtnActionListener(new GiangDayController.UpdateGiangDayListener());
        this.cw.DelGiangDayBtnActionListener(new GiangDayController.DelGiangDayListener());
        
        BindingGiangDay();
    }

    private void BindingGiangDay(){
        cw.BindingGday(gdd.loadTableGiangDay());
        cw.BindingGV_GiangDay(gdd.loadTableGiangVien_GiangDay());
    }

    private  class DelGiangDayListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
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
            
            String Ma_MH = listgd.get(row1).getMa_MH();
            String TenMon = cw.TxtMa_GD.getText();
            String SoTinChi = cw.TxtTenCon.getText();
            String Lop = cw.Cbx_NamSinh_Con.getSelectedItem().toString();
            String SoSinhVien = cw.TxtThanhTichCon.getText();
            String HocKy = cw.TxtHocKy.getText();
            String NamHoc = cw.TxtNamHoc.getText();
            String PhuCap_GD = cw.TxtPhuCap.getText();
            
            String stt = listgvgd.get(row2).getStt();
            String Ma_mh = cw.CB_Ma_MH.getSelectedItem().toString();
            String Ma_cb = cw.CB_MaCB_Gday.getSelectedItem().toString();
            
            if(cw.RBtn_GDay.isSelected()){
                gdd.UpdateGiangDay(Ma_MH, TenMon, SoTinChi, Lop, SoSinhVien, HocKy, NamHoc, PhuCap_GD);
                isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật thông tin giảng dạy của 1 môn học')");
                 cw.BindingGday(gdd.loadTableGiangDay());
            }
            if(cw.RBtn_CB_GDay.isSelected()){
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
