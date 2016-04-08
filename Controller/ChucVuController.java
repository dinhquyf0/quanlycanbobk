/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import Model.ChucVu;
import ModelDAO.ChucVuDAO;
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
public class ChucVuController extends CheckEmpty {
    Insertlog isl = new Insertlog();
    ChucVuDAO cvd = new ChucVuDAO();  
    CanBo cb = new CanBo();
    public ChangeView cw;
    public ChucVu cv;
    ArrayList<ChucVu> listcv = new ArrayList<>();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    public ChucVuController(ChangeView cw, ChucVu cv, ChucVuDAO cvd, CanBo cb) {
        this.cv = cv;
        this.cvd = cvd;
        this.cw = cw;
        this.cb = cb;
        this.cw.AddChucVuBtnActionListener(new ChucVuController.AddChucVuListener());
        this.cw.UpdateChucVuBtnActionListener(new ChucVuController.UpdateChucVuListener());
        this.cw.DelChucVuBtnActionListener(new ChucVuController.DelChucVuListener());
        this.cw.ClickTableChucVu(new ChucVuController.ClickTableListener());
        BindingChucVu();
    }

    private void BindingChucVu(){
        cw.BindingChucVu(cvd.loadTableChucVu());
    }

    private class ClickTableListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {

            if (cw.ChucVu_TBL.getSelectedRow() != -1) {
            int row =cw.ChucVu_TBL.getSelectedRow();

            listcv = cv.getALL();
            listcb = cb.getByID(listcv.get(row).getMa_CB());
            if (listcb.size() > 0) {
                cw.CBx_MaCB_ChucVu.setSelectedItem(listcb.get(0).getMa_CB());
            } else {
                cw.CBx_MaCB_ChucVu.setSelectedIndex(0);
            }
            cw.Txt_STT_ChucVu.setText(listcv.get(row).getStt());
            cw.Txt_TenCB_ChucVu.setText(listcb.get(0).getHoVaTen());
            cw.CBx_MaCB_ChucVu.setSelectedItem(listcv.get(row).getMa_CB());
            cw.Txt_ChucVu.setText(listcv.get(row).getChucVu());
            cw.Txt_PhuCap_CVu.setText(listcv.get(row).getPhuCap_ChucVu());
            
            String nam = listcv.get(row).getThoiGianNhan().substring(0,4);
            String thang = listcv.get(row).getThoiGianNhan().substring(5,7);
            String ngay = listcv.get(row).getThoiGianNhan().substring(8,10);
            
            cw.Cbx_Nam_ChucVu.setSelectedItem(nam);
            cw.Cbx_Thang_ChucVu.setSelectedItem(thang);
            cw.Cbx_Ngay_ChucVu.setSelectedItem(ngay);
            
        }
        }

    }

    private  class DelChucVuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            cvd.DelChucVu(cw.ChucVu_TBL);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Xóa 1 chức vụ của 1 cán bộ')");
            BindingChucVu();
        }
    }
    
 
    
    private  class UpdateChucVuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            listcv = cv.getALL();
            int row = cw.ChucVu_TBL.getSelectedRow();
            String Stt = listcv.get(row).getStt();
            String Ma_CB = cw.CBx_MaCB_ChucVu.getSelectedItem().toString();
            String ChucVu = cw.Txt_ChucVu.getText();
            String ThoiGianDong = cw.Cbx_Nam_ChucVu.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Thang_ChucVu.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_ChucVu.getSelectedItem().toString();
            cvd.UpdateChucVu(Stt, Ma_CB, ChucVu, ThoiGianDong);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật thông tin chức vụ 1 cán bộ')");
            BindingChucVu();
        }
    }

    private class AddChucVuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String Stt = cw.Txt_STT_ChucVu.getText();
            String Ma_CB = cw.CBx_MaCB_ChucVu.getSelectedItem().toString();
            String ChucVu = cw.Txt_ChucVu.getText();
            String ThoiGianDong = cw.Cbx_Nam_ChucVu.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Thang_ChucVu.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_ChucVu.getSelectedItem().toString();
            if(!checkEmpty(cw.Txt_STT_ChucVu,Stt, "Số Thứ Tự")){
                cvd.AddChucVu(Stt, Ma_CB, ChucVu, ThoiGianDong);
                isl.theQuery("INSERT INTO Log (NoiDung) value('Thêm thông tin chức vụ 1 cán bộ')");
                BindingChucVu();
            }
        }
     
    }
}
