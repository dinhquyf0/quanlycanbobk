/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBoDangVien;
import ModelDAO.CanBoDangVienDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author dinhq
 */
public class DangPhiController extends CheckEmpty{
    CanBoDangVienDAO dvd = new CanBoDangVienDAO();  
    public ChangeView cw;
    public CanBoDangVien dv;
    ArrayList<CanBoDangVien> listdv = new ArrayList<>();
    
    public DangPhiController(ChangeView cw, CanBoDangVien dv, CanBoDangVienDAO dvd) {
        this.dv = dv;
        this.dvd = dvd;
        this.cw = cw;
        this.cw.AddDangPhiBtnActionListener(new DangPhiController.AddDangPhiListener());
        this.cw.UpdateDangPhiBtnActionListener(new DangPhiController.UpdateDangPhiListener());
        this.cw.DelDangPhiBtnActionListener(new DangPhiController.DelDangPhiListener());
        BindingDangPhi();
    }

    private void BindingDangPhi(){
        cw.BindingDangPhi(dvd.loadTableDangPhi());
    }

    private  class DelDangPhiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            dvd.DelCanBoDangVien(cw.CongDoanPhi_TBL);
            BindingDangPhi();
        }
    }
    
 
    
    private  class UpdateDangPhiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            listdv = dv.getALL();
            int row = cw.DangPhi_TBL.getSelectedRow();
            String Stt = listdv.get(row).getStt();
            String Ma_CB = cw.CB_MaCb_DangVien.getSelectedItem().toString();
            String SoTienDong = cw.TxtSoTienDongDangVien.getText();
            String ThoiGianDong = cw.Cbx_Nam_DangPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Thang_DangPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_DangPhi.getSelectedItem().toString();
            dvd.UpdateDangVien(Stt, Ma_CB, SoTienDong, ThoiGianDong);
            BindingDangPhi();
        }
    }

    private class AddDangPhiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String Stt = cw.TxtSttDangVien.getText();
            String Ma_CB = cw.CB_MaCb_DangVien.getSelectedItem().toString();
            String SoTienDong = cw.TxtSoTienDongDangVien.getText();
            String ThoiGianDong = cw.Cbx_Nam_DangPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Thang_DangPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_DangPhi.getSelectedItem().toString();
            if(!checkEmpty(cw.TxtSttDangVien,Stt, "Số Thứ Tự")){
                dvd.AddDangVien(Stt, Ma_CB, SoTienDong, ThoiGianDong);
                BindingDangPhi();
            }
        }
     
    }
}
