/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import Model.CanBoDoanVien;
import ModelDAO.CanBoDoanVienDAO;
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
public class DoanPhiController extends CheckEmpty{
    Insertlog isl = new Insertlog();
    CanBoDoanVienDAO dvd = new CanBoDoanVienDAO();  
    public ChangeView cw;
    public CanBoDoanVien dv;
    private CanBo cb;
    ArrayList<CanBoDoanVien> listdv = new ArrayList<>();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    public DoanPhiController(ChangeView cw, CanBoDoanVien dv, CanBoDoanVienDAO dvd, CanBo cb ) {
        this.dv = dv;
        this.dvd = dvd;
        this.cw = cw;
        this.cb = cb;
        this.cw.AddDoanPhiBtnActionListener(new DoanPhiController.AddDoanPhiListener());
        this.cw.UpdateDoanPhiBtnActionListener(new DoanPhiController.UpdateDoanPhiListener());
        this.cw.DelDoanPhiBtnActionListener(new DoanPhiController.DelDoanPhiListener());
        this.cw.ClickTableDoanPhi(new DoanPhiController.ClickTableListener());
        BindingDoanPhi();
    }

    private void BindingDoanPhi(){
        cw.BindingDoanPhi(dvd.loadTableDoanVien());
    }

    private class ClickTableListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {

            if (cw.DoanPhi_TBL.getSelectedRow() != -1) {
            int row = cw.DoanPhi_TBL.getSelectedRow();
            listdv = dv.getALL();
            listcb =cb.getByID(listdv.get(row).getma_canbo());
            cw.TxtStt_DoanVien.setText(listdv.get(row).getStt());
            cw.CB_MaCB_DoanVien.setSelectedItem(listdv.get(row).getma_canbo());
            cw.Txt_TenCanBo_DoanVien.setText(listcb.get(0).getHoVaTen());
            cw.TxtSoTienDong_DoanVien.setText(listdv.get(row).getSoTien());
            String nam = listdv.get(row).getThoiGian().substring(0,4);
            String thang = listdv.get(row).getThoiGian().substring(5,7);
            String ngay = listdv.get(row).getThoiGian().substring(8,10);
            cw.Cbx_Nam_DoanPhi.setSelectedItem(nam);
            cw.Cbx_Thang_DoanPhi.setSelectedItem(thang);
            cw.Cbx_Ngay_DoanPhi.setSelectedItem(ngay);
        }

        }

    }

    private  class DelDoanPhiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            dvd.DelCanBoDoanVien(cw.DoanPhi_TBL);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Xóa thông tin đoàn phí của 1 cán bộ')");
            BindingDoanPhi();
        }
    }
    
 
    
    private  class UpdateDoanPhiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            listdv = dv.getALL();
            int row = cw.DoanPhi_TBL.getSelectedRow();
            String Stt = listdv.get(row).getStt();
            String Ma_CB = cw.CB_MaCB_DoanVien.getSelectedItem().toString();
            String SoTienDong = cw.TxtSoTienDong_DoanVien.getText();
            String ThoiGianDong = cw.Cbx_Nam_DoanPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Thang_DoanPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_DoanPhi.getSelectedItem().toString();
            dvd.UpdateDoanien(Stt, Ma_CB, SoTienDong, ThoiGianDong);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật thông tin đoàn phí của 1 cán bộ')");
            BindingDoanPhi();
        }
    }

    private class AddDoanPhiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String Stt = cw.TxtStt_DoanVien.getText();
            String Ma_CB = cw.CB_MaCB_DoanVien.getSelectedItem().toString();
            String SoTienDong = cw.TxtSoTienDong_DoanVien.getText();
            String ThoiGianDong = cw.Cbx_Nam_DoanPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Thang_DoanPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_DoanPhi.getSelectedItem().toString();
            if(!checkEmpty(cw.TxtStt_DoanVien,Stt, "Số Thứ Tự")){
                dvd.AddDoanVien(Stt, Ma_CB, SoTienDong, ThoiGianDong);
                isl.theQuery("INSERT INTO Log (NoiDung) value('thêm thông tin đoàn phí của 1 cán bộ')");
                BindingDoanPhi();
            }
        }
     
    }
}
