/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import Model.CanBoDangVien;
import ModelDAO.CanBoDangVienDAO;
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
public class DangPhiController extends CheckEmpty{
    Insertlog isl = new Insertlog();
    CanBoDangVienDAO dvd = new CanBoDangVienDAO();  
    public ChangeView cw;
    public CanBoDangVien dv;
    private CanBo cb;
    ArrayList<CanBoDangVien> listdv = new ArrayList<>();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    public DangPhiController(ChangeView cw, CanBoDangVien dv, CanBoDangVienDAO dvd, CanBo cb) {
        this.dv = dv;
        this.dvd = dvd;
        this.cw = cw;
        this.cb = cb;
        this.cw.AddDangPhiBtnActionListener(new DangPhiController.AddDangPhiListener());
        this.cw.UpdateDangPhiBtnActionListener(new DangPhiController.UpdateDangPhiListener());
        this.cw.DelDangPhiBtnActionListener(new DangPhiController.DelDangPhiListener());
        this.cw.ClickTableDangPhi(new DangPhiController.ClickTableListenner());
        BindingDangPhi();
    }

    private void BindingDangPhi(){
        cw.BindingDangPhi(dvd.loadTableDangPhi());
    }

    private class ClickTableListenner implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {

            if (cw.DangPhi_TBL.getSelectedRow() != -1) {
            int row = cw.DangPhi_TBL.getSelectedRow();
            listdv = dv.getALL();
            listcb =cb.getByID(listdv.get(row).getma_canbo());
            cw.CB_MaCb_DangVien.setSelectedItem(listdv.get(row).getma_canbo());
            cw.TxtSttDangVien.setText(listdv.get(row).getStt());
            cw.TxtTen_CBDangVien.setText(listcb.get(0).getHoVaTen());
            cw.TxtSoTienDongDangVien.setText(listdv.get(row).getSoTienThu());
            
            String nam = listdv.get(row).getThoiGianDong().substring(0, 4);
            String thang = listdv.get(row).getThoiGianDong().substring(5, 7);
            String ngay = listdv.get(row).getThoiGianDong().substring(8, 10);
            
            cw.Cbx_Nam_DangPhi.setSelectedItem(nam);
            cw.Cbx_Thang_DangPhi.setSelectedItem(thang);
            cw.Cbx_Ngay_DangPhi.setSelectedItem(ngay);
            
        }
        }

    }

    private  class DelDangPhiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            dvd.DelCanBoDangVien(cw.CongDoanPhi_TBL);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Xóa thông tin thu đảng phí của 1 cán bộ')");
            BindingDangPhi();
            cw.TxtSttDangVien.setText("");
            cw.CB_MaCb_DangVien.setSelectedItem("");
            cw.TxtSoTienDongDangVien.setText("");
            cw.Cbx_Nam_DangPhi.setSelectedItem("");
            cw.Cbx_Thang_DangPhi.setSelectedItem("");
            cw.Cbx_Ngay_DangPhi.setSelectedItem("");
        }
    }
    
 
    
    private  class UpdateDangPhiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            listdv = dv.getALL();
            int row = cw.DangPhi_TBL.getSelectedRow();
            String Stt = listdv.get(row).getStt();
            String tt = cw.TxtSttDangVien.getText();
                if(tt!=Stt){
                    JOptionPane.showMessageDialog(cw, "Số thứ tự không được phép thay đổi.");
                    cw.TxtSttDangVien.requestFocus();
                }
            String Ma_CB = cw.CB_MaCb_DangVien.getSelectedItem().toString();
            String SoTienDong = cw.TxtSoTienDongDangVien.getText();
            String ThoiGianDong = cw.Cbx_Nam_DangPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Thang_DangPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_DangPhi.getSelectedItem().toString();
            if(isNumber(SoTienDong)== false){
                JOptionPane.showMessageDialog(cw, "Trường số tiền đóng phải là số.");
                cw.TxtSoTienDongDangVien.requestFocus();
            }else{
            dvd.UpdateDangVien(Stt, Ma_CB, SoTienDong, ThoiGianDong);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật thông tin đảng phí của 1 cán bộ')");
            BindingDangPhi();
            cw.TxtSttDangVien.setText("");
            cw.CB_MaCb_DangVien.setSelectedItem("");
            cw.TxtSoTienDongDangVien.setText("");
            cw.Cbx_Nam_DangPhi.setSelectedItem("");
            cw.Cbx_Thang_DangPhi.setSelectedItem("");
            cw.Cbx_Ngay_DangPhi.setSelectedItem("");
            }
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
                 return;
            }else if(isNumber(SoTienDong)== false){
                JOptionPane.showMessageDialog(cw, "Trường số tiền đóng phải là số.");
                cw.TxtSoTienDongDangVien.requestFocus();
            }else{
                dvd.AddDangVien(Stt, Ma_CB, SoTienDong, ThoiGianDong);
                isl.theQuery("INSERT INTO Log (NoiDung) value('Thêm thông tin đảng phí của 1 cán bộ')");
                BindingDangPhi();
            }
            cw.TxtSttDangVien.setText("");
            cw.CB_MaCb_DangVien.setSelectedItem("");
            cw.TxtSoTienDongDangVien.setText("");
            cw.Cbx_Nam_DangPhi.setSelectedItem("");
            cw.Cbx_Thang_DangPhi.setSelectedItem("");
            cw.Cbx_Ngay_DangPhi.setSelectedItem("");
        }
     
    }
    public boolean isNumber(String input) {
        return input.matches("^-?[0-9]+(\\.[0-9]+)?$");
    }
    
}
