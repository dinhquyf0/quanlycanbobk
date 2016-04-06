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
    
    public ChucVuController(ChangeView cw, ChucVu cv, ChucVuDAO cvd) {
        this.cv = cv;
        this.cvd = cvd;
        this.cw = cw;
        this.cw.AddChucVuBtnActionListener(new ChucVuController.AddChucVuListener());
        this.cw.UpdateChucVuBtnActionListener(new ChucVuController.UpdateChucVuListener());
        this.cw.DelChucVuBtnActionListener(new ChucVuController.DelChucVuListener());
        BindingChucVu();
    }

    private void BindingChucVu(){
        cw.BindingChucVu(cvd.loadTableChucVu());
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
