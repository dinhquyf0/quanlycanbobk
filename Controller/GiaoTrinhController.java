/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GiangVien_GiaoTrinh;
import Model.GiaoTrinh;
import ModelDAO.GiaoTrinhDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author dinhq
 */
public class GiaoTrinhController extends CheckEmpty {
    GiaoTrinhDAO gtd = new GiaoTrinhDAO();
    public ChangeView cw;
    public GiaoTrinh gt;
    public GiangVien_GiaoTrinh gvgt;
    
    ArrayList<GiaoTrinh> listgt = new ArrayList<>();
    ArrayList<GiangVien_GiaoTrinh> listgvgt = new ArrayList<>();
    
    public GiaoTrinhController(GiaoTrinh gt, GiangVien_GiaoTrinh gvgt, GiaoTrinhDAO gtd, ChangeView cw) {
        this.gt = gt;
        this.gvgt = gvgt;
        this.gtd = gtd;
        this.cw = cw;
        this.cw.AddGiaoTrinhBtnActionListener(new GiaoTrinhController.AddGiaoTrinhListener());
        this.cw.UpdateGiaoTrinhBtnActionListener(new GiaoTrinhController.UpdateGiaoTrinhListener());
        this.cw.DelGiaoTrinhBtnActionListener(new GiaoTrinhController.DelGiaoTrinhListener());
        BindinhGiaoTring();
    }

    private void BindinhGiaoTring(){
        cw.BindingGiangVien_GT(gtd.loadTableCanBo_GiaoTrinh());
        cw.BindingGiaoTrinh(gtd.loadTableGiaoTrinh());
    }

    private class DelGiaoTrinhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(cw.RBtn_CB_GDay.isSelected()){
                gtd.DelGiangVien_GiaoTrinh(cw.CB_GiaoTrinh_TBL);
                cw.BindingGiangVien_GT(gtd.loadTableCanBo_GiaoTrinh());
            }
            if(cw.RBtn_GiaoTrinh.isSelected()){
                gtd.DelGiaoTrinh(cw.GiaoTrinh_TBL);
                cw.BindingGiaoTrinh(gtd.loadTableGiaoTrinh());
            }
           
        }
           
    }
    
 
    
    private  class UpdateGiaoTrinhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            listgt = gt.getALL();
            listgvgt = gvgt.getALLGVGT();
            
            int row1 = cw.GiaoTrinh_TBL.getSelectedRow();
            int row2 = cw.CB_GiaoTrinh_TBL.getSelectedRow();
            
            String Ma_GT = listgt.get(row1).getMa_GT();
            String TenGiaoTrinh = cw.TxtTenGiaoTrinh.getText();
            String TenTacGia = cw.TxtTenTacGia.getText();
            String NamXuatBan = cw.Cbx_Nam_GiaoTrinh.getSelectedItem().toString();
            String NhaXuatBan = cw.TxtNhaXuatBan.getText();
            
            String stt = listgvgt.get(row2).getStt();
            String Ma_gt = cw.CB_Ma_GTrinh.getSelectedItem().toString();
            String Ma_cb = cw.CB_MaCB_GiaoTrinh.getSelectedItem().toString();
            
            if(cw.RBtn_GiaoTrinh.isSelected()){
                gtd.UpdateGiaoTrinh(Ma_GT, TenGiaoTrinh, TenTacGia, NamXuatBan, NhaXuatBan);
                cw.BindingGiaoTrinh(gtd.loadTableGiaoTrinh());
            }
            if(cw.RBtn_CB_GTrinh.isSelected()){
                gtd.UpdateGiangVien_GiaoTrinh(stt, Ma_cb, Ma_gt);
                cw.BindingGiangVien_GT(gtd.loadTableCanBo_GiaoTrinh());
            }
            
        }
    }

    private class AddGiaoTrinhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String Ma_GT = cw.TxtMa_GT.getText();
            String TenGiaoTrinh = cw.TxtTenGiaoTrinh.getText();
            String TenTacGia = cw.TxtTenTacGia.getText();
            String NamXuatBan = cw.Cbx_Nam_GiaoTrinh.getSelectedItem().toString();
            String NhaXuatBan = cw.TxtNhaXuatBan.getText();
            
            String stt = cw.Txt_Stt_CBGTrinh.getText();
            String Ma_gt = cw.CB_Ma_GTrinh.getSelectedItem().toString();
            String Ma_cb = cw.CB_MaCB_GiaoTrinh.getSelectedItem().toString();
            
            if(cw.RBtn_GiaoTrinh.isSelected()){
                if (!checkEmpty(cw.TxtMa_GT, Ma_GT, "Mã Giáo Trình")) {
                    return;
                }else {
                    gtd.AddGiaoTrinh(Ma_GT, TenGiaoTrinh, TenTacGia, NamXuatBan, NhaXuatBan);
                    cw.BindingGiaoTrinh(gtd.loadTableGiaoTrinh());
                }
            }
            
            if(cw.RBtn_CB_GTrinh.isSelected()){
                if(!checkEmpty(cw.Txt_Stt_CBGTrinh , stt, "Số thứ tự")){
                    return;
                }else{
                    gtd.AddGiangVien_GiaoTrinh(stt, Ma_cb, Ma_gt);
                    cw.BindingGiangVien_GT(gtd.loadTableCanBo_GiaoTrinh());
                }
            }
            
        }
     
    }
}
