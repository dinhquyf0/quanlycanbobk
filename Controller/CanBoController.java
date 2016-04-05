/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import ModelDAO.CanBoDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author DINHQUY
 */
public class CanBoController extends CheckEmpty{
    CanBoDAO cbd = new CanBoDAO();  
    public ChangeView cw;
    public CanBo cb;
    ArrayList<CanBo> listcbo = new ArrayList<>();
    public CanBoController(ChangeView cw, CanBo cb, CanBoDAO cbd) {
        this.cb = cb;
        this.cbd = cbd;
        this.cw = cw;
        this.cw.AddCanBoBtnActionListener(new CanBoController.AddCanBoListener());
        this.cw.UpdateCanBoBtnActionListener(new CanBoController.UpdateCanBoListener());
        this.cw.DelCanBoBtnActionListener(new CanBoController.DelCanBoListener());
        BindingCanBo();
    }

    private void BindingCanBo(){
        cw.BindingCanBo(cbd.loadTableCanBo());
    }

    private  class DelCanBoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            cbd.DelCanBo(cw.CanBo_TBL);
            cw.BindingCanBo(cbd.loadTableCanBo());
        }
    }
    
 
    
    private  class UpdateCanBoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            listcbo = cb.getALL();
            int row = cw.CanBo_TBL.getSelectedRow();
            String Ma_CB = listcbo.get(row).getMa_CB();
            String user = cw.TxtTenDangNhap.getText();
            String HovaTen = cw.TxtTenCanBo.getText();
            String NgaySinh = cw.Cbx_NamSinh_CB.getSelectedItem().toString()
                                +cw.Cbx_ThangSinh_CB.getSelectedItem().toString()
                                    +cw.Cbx_NgaySinh_CB.getSelectedItem().toString();
            String GioiTinh ="";
            if(cw.Rbtn_Nam.isSelected()){
                GioiTinh = "nam\n";
            }else if(cw.RBtn_Nu.isSelected()){
                GioiTinh = "nu\n";
            }
            String NoiCongTac = cw.TxtNoiCongTac.getText();
            String ThoiGianBatDau  = cw.CBx_Nam_Ctac.getSelectedItem().toString()
                                        +cw.CBx_Thang_Ctac.getSelectedItem().toString()
                                            +cw.CBx_Ngay_Ctac.getSelectedItem().toString();
            String TrinhDo = "";
            String MaSoThue = cw.TxtMaSoThue.getText();
            String SoTaiKhoan = cw.TxtSoTaiKhoan.getText();
            String DiaChi = cw.TxtDiaChi.getText();
            String SoDienThoai = cw.TxtSoDienThoai.getText();
            String Email = cw.TxtEmail.getText();
            String ThanhTich = cw.TxtThanhTich.getText();
            String ThongTinKhac = cw.TxtThongTinKhac.getText();
           
            cbd.UpdateCanBo(Ma_CB, user, HovaTen, NgaySinh, GioiTinh, NoiCongTac, ThoiGianBatDau, TrinhDo, MaSoThue, SoTaiKhoan, DiaChi, SoDienThoai, Email, ThanhTich, ThongTinKhac);
            cw.BindingCanBo(cbd.loadTableCanBo());            
        }
    }

    private class AddCanBoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String Ma_CB = cw.TxtCanBoID.getText();
            String Password = "123456";
            String user = cw.TxtTenDangNhap.getText();
            String HovaTen = cw.TxtTenCanBo.getText();
            String NgaySinh = cw.Cbx_NamSinh_CB.getSelectedItem().toString()
                                +cw.Cbx_ThangSinh_CB.getSelectedItem().toString()
                                    +cw.Cbx_NgaySinh_CB.getSelectedItem().toString();
            String GioiTinh ="";
            if(cw.Rbtn_Nam.isSelected()){
                GioiTinh = "nam\n";
            }else if(cw.RBtn_Nu.isSelected()){
                GioiTinh = "nu\n";
            }
            String NoiCongTac = cw.TxtNoiCongTac.getText();
            String ThoiGianBatDau  = cw.CBx_Nam_Ctac.getSelectedItem().toString()
                                        +cw.CBx_Thang_Ctac.getSelectedItem().toString()
                                            +cw.CBx_Ngay_Ctac.getSelectedItem().toString();
            String TrinhDo = cw.TxtTrinhDo.getText();
            String MaSoThue = cw.TxtMaSoThue.getText();
            String SoTaiKhoan = cw.TxtSoTaiKhoan.getText();
            String DiaChi = cw.TxtDiaChi.getText();
            String SoDienThoai = cw.TxtSoDienThoai.getText();
            String Email = cw.TxtEmail.getText();
            String ThanhTich = cw.TxtThanhTich.getText();
            String ThongTinKhac = cw.TxtThongTinKhac.getText();
            
            if (!checkEmpty(cw.TxtCanBoID, Ma_CB, "Mã Cán Bộ")&&!checkEmpty(cw.TxtTenDangNhap, user, "Tên Đăng Nhập")) {
                return;
            }else {
            cbd.AddCanBo(Ma_CB, user, Password, HovaTen, NgaySinh, GioiTinh, NoiCongTac, ThoiGianBatDau, TrinhDo, MaSoThue, SoTaiKhoan, DiaChi, SoDienThoai, Email, ThanhTich, ThongTinKhac);
            }
            cw.BindingCanBo(cbd.loadTableCanBo());
        }
     
    }
}

