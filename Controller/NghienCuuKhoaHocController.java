/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import Model.NghienCuuKhoaHoc;
import Model.GiangVien_NghienCuuKhoaHoc;
import ModelDAO.NghienCuuKhoaHocDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author dinhq
 */
public class NghienCuuKhoaHocController extends CheckEmpty{
    Insertlog isl = new Insertlog();
    NghienCuuKhoaHocDAO nckhd = new NghienCuuKhoaHocDAO();
    public ChangeView cw;
    public NghienCuuKhoaHoc nckh;
    public GiangVien_NghienCuuKhoaHoc gvnckh;
    private CanBo cb;
    
    ArrayList<NghienCuuKhoaHoc> listnckh = new ArrayList<>();
    ArrayList<GiangVien_NghienCuuKhoaHoc> listgvnckh = new ArrayList<>();
    ArrayList<CanBo> listcbo = new ArrayList<>();
    
    public NghienCuuKhoaHocController(ChangeView cw, NghienCuuKhoaHoc nckh,GiangVien_NghienCuuKhoaHoc gvnckh, NghienCuuKhoaHocDAO nckhd, CanBo cb) {
        this.nckh = nckh;
        this.gvnckh = gvnckh;
        this.nckhd = nckhd;
        this.cw = cw;
        this.cb = cb;
        this.cw.AddNCKHBtnActionListener(new NghienCuuKhoaHocController.AddNCKHListener());
        this.cw.UpdateNCKHBtnActionListener(new NghienCuuKhoaHocController.UpdateNCKHListener());
        this.cw.DelNCKHBtnActionListener(new NghienCuuKhoaHocController.DelNCKHListener());
        this.cw.ClickTableCanBo_NCKH(new NghienCuuKhoaHocController.ClickTableCanBo_NCKH());
        this.cw.ClickTableNCKH(new NghienCuuKhoaHocController.ClickTableNCKH());
        BindingNCKH();
        cw.BindingMaNCKH(nckh.getALL());
    }

    private void BindingNCKH(){
        cw.BindingNCKH(nckhd.loadTableNCKH());
        cw.BindingGiangVien_NCKH(nckhd.loadTableCanBo_NCKH());
    }

    private class ClickTableCanBo_NCKH implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {

            if (cw.GV_NCKH_TBL.getSelectedRow() != -1) {
            int row = cw.GV_NCKH_TBL.getSelectedRow();

            listgvnckh = gvnckh.getALLGVDT();
            listcbo = cb.getByID(listgvnckh.get(row).getma_canbo());
            if (listcbo.size() > 0) {
                cw.CB_MaCB_NCKH.setSelectedItem(listcbo.get(0).getMa_CB());
            } else {
                cw.CB_MaCB_NCKH.setSelectedIndex(0);
            }
            cw.Txt_Stt_NCKH.setText(listgvnckh.get(row).getstt());
            cw.CB_Ma_DTai.setSelectedItem(listgvnckh.get(row).getMa_DT());
            cw.TxtTen_CBNCKH.setText(listcbo.get(0).getHoVaTen());
        }
        
        }
    }

    private class ClickTableNCKH implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (cw.NCKH_TBL.getSelectedRow() != -1) {
            int row = cw.NCKH_TBL.getSelectedRow();
            listnckh = nckh.getALL();

            cw.Txt_MaDT.setText(listnckh.get(row).getMa_DT());
            cw.TxtTenDT.setText(listnckh.get(row).getTenDeTai());
            cw.TxtCap.setText(listnckh.get(row).getCap());
            cw.TxtKinhPhi.setText(listnckh.get(row).getKinhPhi());
            cw.TxtChuTri.setText(listnckh.get(row).getChuTriDeTai());
            cw.TxtTinhTrang.setText(listnckh.get(row).getTinhTrang());
            cw.TxtKetQua.setText(listnckh.get(row).getKetQua());
                
            String nam_bd = listnckh.get(row).getThoiGianBatDau().substring(0, 4);
            String thang_bd = listnckh.get(row).getThoiGianBatDau().substring(5, 7);
            String ngay_bd = listnckh.get(row).getThoiGianBatDau().substring(8, 10);
            String nam_kt = listnckh.get(row).getThoiGianKetThuc().substring(0, 4);
            String thang_kt = listnckh.get(row).getThoiGianKetThuc().substring(5, 7);
            String ngay_kt = listnckh.get(row).getThoiGianKetThuc().substring(8, 10);
            
            cw.CBx_Nam_NCKH_TGBD.setSelectedItem(nam_bd);
            cw.Cbx_Thang_NCKH_TGBD.setSelectedItem(thang_bd);
            cw.Cbx_Ngay_NCKH_TGBD.setSelectedItem(ngay_bd);
            cw.Cbx_Nam_NCKH_TGKT.setSelectedItem(nam_kt);
            cw.Cbx_Thang_NCKH_TGKT.setSelectedItem(thang_kt);
            cw.Cbx_Ngay_NCKH_TGKT.setSelectedItem(ngay_kt);
            
        }    
        
        }

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
                isl.theQuery("INSERT INTO Log (NoiDung) value('Xóa thông tin 1 đề tài NCKH')");
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
            
            if(cw.RBtn_NCKH.isSelected()){
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
                nckhd.UpdateNghienCuuKhoaHoc(Ma_DT, TenDeTai, Cap, KinhPhi, ThoiGianBatDau, ThoiGianKetThuc, ChuTriDeTai, TinhTrang, KetQua);
                isl.theQuery("INSERT INTO Log (NoiDung) value('cập nhật thông tin 1 đề tài NCKH')");
                cw.BindingNCKH(nckhd.loadTableNCKH());
            }
            if(cw.RBtn_GV_NCKH.isSelected()){
                String Stt = listgvnckh.get(row2).getstt();
                String Ma_dt = cw.CB_Ma_DTai.getSelectedItem().toString();
                String Ma_cb = cw.CB_MaCB_NCKH.getSelectedItem().toString();
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
                    isl.theQuery("INSERT INTO Log (NoiDung) value('Thêm mới thông tin 1 đề tài NCKH')");
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
