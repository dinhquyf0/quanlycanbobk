/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBoDoanVien;
import ModelDAO.CanBoDoanVienDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author dinhq
 */
public class DoanPhiController extends CheckEmpty{
    CanBoDoanVienDAO dvd = new CanBoDoanVienDAO();  
    public ChangeView cw;
    public CanBoDoanVien dv;
    ArrayList<CanBoDoanVien> listdv = new ArrayList<>();
    
    public DoanPhiController(ChangeView cw, CanBoDoanVien dv, CanBoDoanVienDAO dvd ) {
        this.dv = dv;
        this.dvd = dvd;
        this.cw = cw;
        this.cw.AddDoanPhiBtnActionListener(new DoanPhiController.AddDoanPhiListener());
        this.cw.UpdateDoanPhiBtnActionListener(new DoanPhiController.UpdateDoanPhiListener());
        this.cw.DelDoanPhiBtnActionListener(new DoanPhiController.DelDoanPhiListener());
        BindingDoanPhi();
    }

    private void BindingDoanPhi(){
        cw.BindingDoanPhi(dvd.loadTableDoanVien());
    }

    private  class DelDoanPhiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            dvd.DelCanBoDoanVien(cw.DoanPhi_TBL);
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
                BindingDoanPhi();
            }
        }
     
    }
}
