/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Luong;
import ModelDAO.LuongDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author dinhq
 */
public class LuongController extends  CheckEmpty{
    Insertlog isl = new Insertlog();
    LuongDAO ld = new LuongDAO();  
    public ChangeView cw;
    public Luong l;
    ArrayList<Luong> listl = new ArrayList<>();
    
    public LuongController(Luong l, LuongDAO ld, ChangeView cw) {
        this.l = l;
        this.ld = ld;
        this.cw = cw;
        this.cw.AddLuongBtnActionListener(new LuongController.AddLuongListener());
        this.cw.UpdateLuongBtnActionListener(new LuongController.UpdateLuongListener());
        this.cw.DelLuongBtnActionListener(new LuongController.DelLuongListener());
        BindingLuong();
    }

    private void BindingLuong(){
        cw.BindingLuong(ld.loadTableLuong());
    }

    private  class DelLuongListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ld.DelLuong(cw.Luong_TBL);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Xóa thông tin lương của 1 cán bộ')");
            BindingLuong();
        }
    }
    
 
    
    private  class UpdateLuongListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            listl = l.getALL();
            int row = cw.Luong_TBL.getSelectedRow();
            String Stt = listl.get(row).getStt();
            String Ma_CB = cw.CB_MaCB_Luong.getSelectedItem().toString();
            String HeSoLuong = cw.TxtHeSoLuong.getText();
            String TGBD = cw.Cbx_Nam_Luong_TGBD.getSelectedItem().toString()+"-"
                            +cw.Cbx_Thang_Luong_TGBD.getSelectedItem().toString()+"-"
                                +cw.CBx_Ngay_Luong_TGBD.getSelectedItem().toString();
            String Luong = cw.TxtTienLuong.getText();
            ld.UpdateLuong(Stt, Ma_CB, HeSoLuong, TGBD,Luong);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật thông tin lương của 1 cán bộ')");
            BindingLuong();
        }
    }

    private class AddLuongListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String Stt = cw.TxtSoTTLuong.getText();
            String Ma_CB = cw.CB_MaCB_Luong.getSelectedItem().toString();
            String HeSoLuong = cw.TxtHeSoLuong.getText();
            String TGBD = cw.Cbx_Nam_Luong_TGBD.getSelectedItem().toString()+"-"
                            +cw.Cbx_Thang_Luong_TGBD.getSelectedItem().toString()+"-"
                                +cw.CBx_Ngay_Luong_TGBD.getSelectedItem().toString();
            String Luong = cw.TxtTienLuong.getText();
            if(!checkEmpty(cw.TxtSoTTLuong,Stt, "Số Thứ Tự")){
                ld.AddLuong(Stt, Ma_CB, HeSoLuong, TGBD, Luong);
                isl.theQuery("INSERT INTO Log (NoiDung) value('Thêm thông tin lương của 1 cán bộ')");
                BindingLuong();
            }
        }
     
    }
}
