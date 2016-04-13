/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import Model.Luong;
import ModelDAO.LuongDAO;
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
public class LuongController extends  CheckEmpty{
    Insertlog isl = new Insertlog();
    LuongDAO ld = new LuongDAO();  
    public ChangeView cw;
    public Luong l;
    private CanBo cb;
    ArrayList<Luong> listl = new ArrayList<>();
    ArrayList<CanBo> listcbo = new ArrayList<>();
    
    public LuongController(Luong l, LuongDAO ld, ChangeView cw, CanBo cb) {
        this.l = l;
        this.ld = ld;
        this.cw = cw;
        this.cb = cb;
        this.cw.AddLuongBtnActionListener(new LuongController.AddLuongListener());
        this.cw.UpdateLuongBtnActionListener(new LuongController.UpdateLuongListener());
        this.cw.DelLuongBtnActionListener(new LuongController.DelLuongListener());
        this.cw.ClickTableLuong(new LuongController.ClickTableLuongListener());
        BindingLuong();
    }

    private void BindingLuong(){
        cw.BindingLuong(ld.loadTableLuong());
    }

    private class ClickTableLuongListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {

             if (cw.Luong_TBL.getSelectedRow() != -1) {
            int row = cw.Luong_TBL.getSelectedRow();
            listl = l.getALL();
            listcbo =cb.getByID(listl.get(row).getma_canbo());
            cw.TxtSoTTLuong.setText(listl.get(row).getStt());
            cw.CB_MaCB_Luong.setSelectedItem(listl.get(row).getma_canbo());
            cw.TxtHeSoLuong.setText(listl.get(row).getHeSoLuong());
            cw.TxtTen_CBLuong.setText(listcbo.get(0).getHoVaTen());

            String nam_bd = listl.get(row).getThoiGianBatDau().substring(0, 4);
            String thang_bd = listl.get(row).getThoiGianBatDau().substring(5, 7);
            String ngay_bd = listl.get(row).getThoiGianBatDau().substring(8, 10);

            cw.Cbx_Nam_Luong_TGBD.setSelectedItem(nam_bd);
            cw.Cbx_Thang_Luong_TGBD.setSelectedItem(thang_bd);
            cw.CBx_Ngay_Luong_TGBD.setSelectedItem(ngay_bd);
        }
        
        }

    }

    private  class DelLuongListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ld.DelLuong(cw.Luong_TBL);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Xóa thông tin lương của 1 cán bộ')");
            BindingLuong();
            cw.TxtSoTTLuong.setText("");
            cw.CB_MaCB_Luong.setSelectedItem("");
            cw.TxtHeSoLuong.setText("");
            cw.TxtTen_CBLuong.setText("");
            cw.Cbx_Nam_Luong_TGBD.setSelectedItem("");
            cw.Cbx_Thang_Luong_TGBD.setSelectedItem("");
            cw.CBx_Ngay_Luong_TGBD.setSelectedItem("");
        }
    }
    
    public double HeSoLuongTheoTrinhDo(String trinhdo){
        double hsl = 1;
        switch (trinhdo) {
            case "Thạc sĩ":{
                hsl = 2.67;
                break;
            }
            case"Tiến sĩ":{
                hsl = 3;
                break;
            }
            case"Phó giáo sư":{
                hsl = 3.33;
                break;
            }
            case"Giáo sư":{
                hsl = 3.66;
                break;
            }        
        }
        return hsl;
    }
    
    private  class UpdateLuongListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            listl = l.getALL();
            int row = cw.Luong_TBL.getSelectedRow();
            String Stt = listl.get(row).getStt();
            String stt = cw.TxtSoTTLuong.getText();
            if(stt!=Stt){
                JOptionPane.showMessageDialog(cw, "Số thứ tự không được phép thay đổi.");
                cw.TxtSoTTLuong.requestFocus();
            }
            String Ma_CB = cw.CB_MaCB_Luong.getSelectedItem().toString();
            String HeSoLuong = cw.TxtHeSoLuong.getText();
            String TGBD = cw.Cbx_Nam_Luong_TGBD.getSelectedItem().toString()+"-"
                            +cw.Cbx_Thang_Luong_TGBD.getSelectedItem().toString()+"-"
                                +cw.CBx_Ngay_Luong_TGBD.getSelectedItem().toString();
            ld.UpdateLuong(Stt, Ma_CB, HeSoLuong, TGBD);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật thông tin lương của 1 cán bộ')");
            BindingLuong();
            cw.TxtSoTTLuong.setText("");
            cw.CB_MaCB_Luong.setSelectedItem("");
            cw.TxtHeSoLuong.setText("");
            cw.TxtTen_CBLuong.setText("");
            cw.Cbx_Nam_Luong_TGBD.setSelectedItem("");
            cw.Cbx_Thang_Luong_TGBD.setSelectedItem("");
            cw.CBx_Ngay_Luong_TGBD.setSelectedItem("");
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
            if(!checkEmpty(cw.TxtSoTTLuong,Stt, "Số Thứ Tự")){
                 return;
            }else {
                ld.AddLuong(Stt, Ma_CB, HeSoLuong, TGBD);
                isl.theQuery("INSERT INTO Log (NoiDung) value('Thêm thông tin lương của 1 cán bộ')");
                BindingLuong();
            }
            cw.TxtSoTTLuong.setText("");
            cw.CB_MaCB_Luong.setSelectedItem("");
            cw.TxtHeSoLuong.setText("");
            cw.TxtTen_CBLuong.setText("");
            cw.Cbx_Nam_Luong_TGBD.setSelectedItem("");
            cw.Cbx_Thang_Luong_TGBD.setSelectedItem("");
            cw.CBx_Ngay_Luong_TGBD.setSelectedItem("");
        }
     
    }
}
