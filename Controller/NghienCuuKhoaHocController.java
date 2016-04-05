/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.NghienCuuKhoaHoc;
import Model.GiangVien_NghienCuuKhoaHoc;
import ModelDAO.NghienCuuKhoaHocDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author dinhq
 */
public class NghienCuuKhoaHocController extends CheckEmpty{
    NghienCuuKhoaHocDAO nckhd = new NghienCuuKhoaHocDAO();
    
    public ChangeView cw;
    public NghienCuuKhoaHoc nckh;
    public GiangVien_NghienCuuKhoaHoc gvnckh;
    
    ArrayList<NghienCuuKhoaHoc> listnckh = new ArrayList<>();
    ArrayList<GiangVien_NghienCuuKhoaHoc> listgvnckh = new ArrayList<>();
    
    public NghienCuuKhoaHocController(ChangeView cw, NghienCuuKhoaHoc nckh,GiangVien_NghienCuuKhoaHoc gvnckh, NghienCuuKhoaHocDAO nckhd) {
        this.nckh = nckh;
        this.gvnckh = gvnckh;
        this.nckhd = nckhd;
        this.cw = cw;
        this.cw.AddNCKHBtnActionListener(new NghienCuuKhoaHocController.AddNCKHListener());
        this.cw.UpdateNCKHBtnActionListener(new NghienCuuKhoaHocController.UpdateNCKHListener());
        this.cw.DelNCKHBtnActionListener(new NghienCuuKhoaHocController.DelNCKHListener());
        BindingNCKH();
    }

    private void BindingNCKH(){
        cw.BindingNCKH(nckhd.loadTableNCKH());
        cw.BindingGiangVien_NCKH(nckhd.loadTableCanBo_NCKH());
    }

    private  class DelNCKHListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(cw.RBtn_GV_NCKH.isSelected()){
                nckhd.DelGiangVian_NghienCuuKhoaHoc(cw.GV_NCKH_TBL);
                cw.BindingGiangVien_NCKH(nckhd.loadTableCanBo_NCKH());
            }
            if(cw.RBtn_NCKH.isSelected()){
                nckhd.DelNghienCuuKhoaHoc(cw.NCKH_TBL);
                cw.BindingNCKH(nckhd.loadTableNCKH());
            }
           
        }
           
    }
    
 
    
    private  class UpdateNCKHListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            listnckh = nckh.getALL();
            listgvnckh = gvnckh.getALLGVDT();
            
            int row1 = cw.NCKH_TBL.getSelectedRow();
            int row2 = cw.GV_NCKH_TBL.getSelectedRow();
            
            String Ma_DT = listnckh.get(row1).getMa_DT();
            String TenDeTai = cw.TxtTenDT.getText();
            String Cap = cw.TxtCap.getText();
            String KinhPhi = cw.TxtKinhPhi.getText();
            String ThoiGianBatDau = cw.CBx_Nam_NCKH_TGBD.getSelectedItem().toString()+"-"
                                        +cw.Cbx_Thang_NCKH_TGBD.getSelectedItem().toString()+"-"
                                            +cw.Cbx_Ngay_NCKH_TGBD.getSelectedItem().toString();
            String ThoiGianKetThuc = cw.Cbx_Nam_NCKH_TGKT.getSelectedItem().toString()+"-"
                                        +cw.Cbx_Thang_NCKH_TGKT.getSelectedItem().toString()+"-"
                                            +cw.Cbx_Ngay_NCKH_TGKT.getSelectedItem().toString();
            String ChuTriDeTai = cw.TxtChuTri.getText();
            String TinhTrang = cw.TxtTinhTrang.getText();
            String KetQua = cw.TxtKetQua.getText();
           
            String Stt = listgvnckh.get(row2).getstt();
            String Ma_dt = cw.CB_Ma_DTai.getSelectedItem().toString();
            String Ma_cb = cw.CB_MaCB_NCKH.getSelectedItem().toString();
            
            if(cw.RBtn_NCKH.isSelected()){
                nckhd.UpdateNghienCuuKhoaHoc(Ma_DT, TenDeTai, Cap, KinhPhi, ThoiGianBatDau, ThoiGianKetThuc, ChuTriDeTai, TinhTrang, KetQua);
                cw.BindingNCKH(nckhd.loadTableNCKH());
            }
            if(cw.RBtn_GV_NCKH.isSelected()){
                nckhd.UpdateGiangVien_NghienCuuKhoaHoc(Stt, Ma_cb, Ma_dt);
                cw.BindingGiangVien_NCKH(nckhd.loadTableCanBo_NCKH());
            }
            
        }
    }

    private class AddNCKHListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String Ma_DT = cw.Txt_MaDT.getText();
            String TenDeTai = cw.TxtTenDT.getText();
            String Cap = cw.TxtCap.getText();
            String KinhPhi = cw.TxtKinhPhi.getText();
            String ThoiGianBatDau = cw.CBx_Nam_NCKH_TGBD.getSelectedItem().toString()+"-"
                                        +cw.Cbx_Thang_NCKH_TGBD.getSelectedItem().toString()+"-"
                                            +cw.Cbx_Ngay_NCKH_TGBD.getSelectedItem().toString();
            String ThoiGianKetThuc = cw.Cbx_Nam_NCKH_TGKT.getSelectedItem().toString()+"-"
                                        +cw.Cbx_Thang_NCKH_TGKT.getSelectedItem().toString()+"-"
                                            +cw.Cbx_Ngay_NCKH_TGKT.getSelectedItem().toString();
            String ChuTriDeTai = cw.TxtChuTri.getText();
            String TinhTrang = cw.TxtTinhTrang.getText();
            String KetQua = cw.TxtKetQua.getText();
           
            String Stt = cw.Txt_Stt_NCKH.getText();
            String Ma_dt = cw.CB_Ma_DTai.getSelectedItem().toString();
            String Ma_cb = cw.CB_MaCB_NCKH.getSelectedItem().toString();
           
            if(cw.RBtn_NCKH.isSelected()){
                if (!checkEmpty(cw.Txt_MaDT, Ma_DT, "Mã Đề Tài")) {
                    return;
                }else {
                    nckhd.AddNghienCuuKhoaHoc(Ma_DT, TenDeTai, Cap, KinhPhi, ThoiGianBatDau, ThoiGianKetThuc, ChuTriDeTai, TinhTrang, KetQua);
                    cw.BindingNCKH(nckhd.loadTableNCKH());
                }
            }
            if(cw.RBtn_GV_NCKH.isSelected()){
                if(!checkEmpty(cw.Txt_Stt_NCKH , Stt, "Số thứ tự")){
                    return;
                }else{
                    nckhd.AddGiangVien_NghienCuuKhoaHoc(Stt, Ma_cb, Ma_dt);
                    cw.BindingGiangVien_NCKH(nckhd.loadTableCanBo_NCKH());
                }
            }
            
        }
     
    } 
}
