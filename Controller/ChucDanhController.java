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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    public ChucDanhController(ChangeView cw, ChucDanh cd, ChucDanhDAO cdd, CanBo cb) {
        this.cd = cd;
        this.cdd = cdd;
        this.cw = cw;
        this.cb = cb;
        this.cw.AddChucDanhBtnActionListener(new ChucDanhController.AddChucDanhListener());
        this.cw.UpdateChucDanhBtnActionListener(new ChucDanhController.UpdateChucDanhListener());
        this.cw.DelChucDanhBtnActionListener(new ChucDanhController.DelChucDanhListener());
        this.cw.ClickTableChucDanh(new ChucDanhController.ClickTableChucDanh());
        BindingChucDanh();
    }

    private void BindingChucDanh(){
        cw.BindingChucDanh(cdd.loadTableChucDanh());
    }

    private class ClickTableChucDanh implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (cw.ChucDanh_TBL.getSelectedRow() != -1) {
            int row = cw.ChucDanh_TBL.getSelectedRow();

            listcd = cd.getALL();
            listcb = cb.getByID(listcd.get(row).getMa_CB());
            if (listcb.size() > 0) {
                cw.CBx_MaCB_ChucDanh.setSelectedItem(listcb.get(0).getMa_CB());
            } else {
                cw.CBx_MaCB_ChucDanh.setSelectedIndex(0);
            }
            cw.Txt_Stt_ChucDanh.setText(listcd.get(row).getStt());
            cw.Txt_tenCB_ChucDanh.setText(listcb.get(0).getHoVaTen());
            cw.CBx_MaCB_ChucDanh.setSelectedItem(listcd.get(row).getMa_CB());
            cw.Txt_ChucDanh.setText(listcd.get(row).getChucDanh());
            String nam = listcd.get(row).getThoiGianNhan().substring(0,4);
            String thang = listcd.get(row).getThoiGianNhan().substring(5,7);
            String ngay = listcd.get(row).getThoiGianNhan().substring(8,10);
            
            cw.Cbx_Nam_ChucDanh.setSelectedItem(nam);
            cw.Cbx_Thang_ChucDanh.setSelectedItem(thang);
            cw.Cbx_Ngay_ChucDanh.setSelectedItem(ngay);
            
        }
        }

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
            String ChucDanh = cw.Txt_ChucDanh.getText();
            String ThoiGianDong = cw.Cbx_Nam_ChucDanh.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Thang_ChucDanh.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_ChucDanh.getSelectedItem().toString();
            if(!checkEmpty(cw.Txt_Stt_ChucDanh,Stt, "Số Thứ Tự")){
                cdd.AddChucDanh(Stt, Ma_CB, ChucDanh, ThoiGianDong);
                isl.theQuery("INSERT INTO Log (NoiDung) value('Thêm mới 1 chức danh')");
                BindingChucDanh();
            }
        }
     
    }
}
