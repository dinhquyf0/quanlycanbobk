/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import Model.CanBoCongDoanVien;
import ModelDAO.CanBoCongDoanVienDAO;
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
public class CongDoanVienController extends CheckEmpty{
    Insertlog isl = new Insertlog();
    CanBoCongDoanVienDAO cdvd = new CanBoCongDoanVienDAO();  
    public ChangeView cw;
    public CanBoCongDoanVien cdv;
    private CanBo cb;
    ArrayList<CanBoCongDoanVien> listcdv = new ArrayList<>();
    ArrayList<CanBo> listcbo = new ArrayList<>();
    
    public CongDoanVienController(ChangeView cw, CanBoCongDoanVien cdv, CanBoCongDoanVienDAO cdvd, CanBo cb) {
        this.cdv = cdv;
        this.cdvd = cdvd;
        this.cw = cw;
        this.cb = cb;
        this.cw.AddCongDoanPhiBtnActionListener(new CongDoanVienController.AddCongDoanVienListener());
        this.cw.UpdateCongDoanPhiBtnActionListener(new CongDoanVienController.UpdateCongDoanVienListener());
        this.cw.DelCongDoanPhiBtnActionListener(new CongDoanVienController.DelCongDoanVienListener());
        this.cw.ClickTableCongDoanPhi(new CongDoanVienController.ClickTableListener());
        BindingCongDoanPhi();
    }

    private void BindingCongDoanPhi(){
        cw.BindingCongDoanPhi(cdvd.loadTableCongDoanPhi());
    }

    private class ClickTableListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
        
            if (cw.CongDoanPhi_TBL.getSelectedRow() != -1) {
            int row = cw.CongDoanPhi_TBL.getSelectedRow();
            listcdv = cdv.getALL();
            listcbo =cb.getByID(listcdv.get(row).getma_canbo());
            cw.TxtSoThuTuCongDoanVien.setText(listcdv.get(row).getStt());
            cw.Cb_MaCB_CDV.setSelectedItem(listcdv.get(row).getma_canbo());
            cw.TxtTenCb_CDV.setText(listcbo.get(0).getHoVaTen());
            cw.TxtSoTienDong_CDV.setText(listcdv.get(row).getSoTienDong());
            String nam = listcdv.get(row).getThoiGianDong().substring(0,4);
            String thang = listcdv.get(row).getThoiGianDong().substring(5,7);
            String ngay = listcdv.get(row).getThoiGianDong().substring(8,10);
            cw.Cbx_Nam_CongDoanPhi.setSelectedItem(nam);
            cw.Cbx_Thang_CongDoanPhi.setSelectedItem(thang);
            cw.Cbx_Ngay_CongDoanPhi.setSelectedItem(ngay);
                    
        }
            
        }
    }

    private  class DelCongDoanVienListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            cdvd.DelCanBo_CongDoanVien(cw.CongDoanPhi_TBL);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Xóa thông tin công đoàn phí 1 cán bộ')");
             BindingCongDoanPhi();
        }
    }
    
 
    
    private  class UpdateCongDoanVienListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            listcdv = cdv.getALL();
            int row = cw.CongDoanPhi_TBL.getSelectedRow();
            String Stt = listcdv.get(row).getStt();
            String Ma_CB = cw.Cb_MaCB_CDV.getSelectedItem().toString();
            String SoTienDong = cw.TxtSoTienDong_CDV.getText();
            String ThoiGianDong = cw.Cbx_Nam_CongDoanPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Thang_CongDoanPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_CongDoanPhi.getSelectedItem().toString();
            cdvd.UpdateCongDoanVien(Stt, Ma_CB, SoTienDong, ThoiGianDong);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật thông tin công đoàn phí 1 cán bộ')");
            BindingCongDoanPhi();
        }
    }

    private class AddCongDoanVienListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String Stt = cw.TxtSoThuTuCongDoanVien.getText();
            String Ma_CB = cw.Cb_MaCB_CDV.getSelectedItem().toString();
            String SoTienDong = cw.TxtSoTienDong_CDV.getText();
            String NgayNop = cw.Cbx_Nam_CongDoanPhi.getSelectedItem().toString()+"-"
                                +cw.Cbx_Thang_CongDoanPhi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_CongDoanPhi.getSelectedItem().toString();
            if(!checkEmpty(cw.TxtSoThuTuCongDoanVien,Stt, "Số Thứ Tự")){
                cdvd.AddCongDoanVien(Stt, Ma_CB, SoTienDong, SoTienDong);
                isl.theQuery("INSERT INTO Log (NoiDung) value('thêm thông tin công đoàn phí 1 cán bộ')");
                 BindingCongDoanPhi();
            }
        }
     
    }
}
