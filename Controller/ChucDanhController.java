/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import Model.ChucDanh;
import ModelDAO.ChucDanhDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author dinhq
 */
public class ChucDanhController extends CheckEmpty {
    Insertlog isl = new Insertlog();
    ChucDanhDAO cdd = new ChucDanhDAO();  
    CanBo cb  = new CanBo();
    public ChangeView cw;
    public ChucDanh cd;
    ArrayList<ChucDanh> listcd = new ArrayList<>();
    
    public ChucDanhController(ChangeView cw, ChucDanh cd, ChucDanhDAO cdd) {
        this.cd = cd;
        this.cdd = cdd;
        this.cw = cw;
        this.cw.AddChucDanhBtnActionListener(new ChucDanhController.AddChucDanhListener());
        this.cw.UpdateChucDanhBtnActionListener(new ChucDanhController.UpdateChucDanhListener());
        this.cw.DelChucDanhBtnActionListener(new ChucDanhController.DelChucDanhListener());
        BindingChucDanh();
    }

    private void BindingChucDanh(){
        cw.BindingChucDanh(cdd.loadTableChucDanh());
    }

    private  class DelChucDanhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            cdd.DelChucDanh(cw.ChucDanh_TBL);
            isl.theQuery("INSERT INTO Log (NoiDung) value('xóa 1 chức danh')");
            BindingChucDanh();
        }
    }
    
 
    
    private  class UpdateChucDanhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            listcd = cd.getALL();
            int row = cw.ChucDanh_TBL.getSelectedRow();
            String Stt = listcd.get(row).getStt();
            String Ma_CB = cw.CBx_MaCB_ChucDanh.getSelectedItem().toString();
            String ChucVu = cw.Txt_ChucDanh.getText();
            String ThoiGianDong = cw.Cbx_Nam_ChucDanh.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Thang_ChucDanh.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_ChucDanh.getSelectedItem().toString();
            cdd.UpdateChucDanh(Stt, Ma_CB, ChucVu, ThoiGianDong);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật 1 chức danh')");
            BindingChucDanh();
        }
    }

    private class AddChucDanhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String Stt = cw.Txt_Stt_ChucDanh.getText();
            String Ma_CB = cw.CBx_MaCB_ChucDanh.getSelectedItem().toString();
            String ChucVu = cw.Txt_ChucDanh.getText();
            String ThoiGianDong = cw.Cbx_Nam_ChucDanh.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Thang_ChucDanh.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_ChucDanh.getSelectedItem().toString();
            if(!checkEmpty(cw.Txt_Stt_ChucDanh,Stt, "Số Thứ Tự")){
                cdd.AddChucDanh(Stt, Ma_CB, ChucVu, ThoiGianDong);
                isl.theQuery("INSERT INTO Log (NoiDung) value('Thêm mới 1 chức danh')");
                BindingChucDanh();
            }
        }
     
    }
}
