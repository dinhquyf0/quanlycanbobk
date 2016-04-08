/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import Model.Luong;
import ModelDAO.CanBoDAO;
import ModelDAO.LuongDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author DINHQUY
 */
public class CanBoController extends CheckEmpty{
    CanBoDAO cbd = new CanBoDAO();  
    public ChangeView cw;
    public CanBo cb;
    private LuongDAO ld;
    ArrayList<CanBo> listcbo = new ArrayList<>();
    ArrayList<Luong> listl = new ArrayList<>();
    private Luong l;
    Insertlog isl = new Insertlog();
    public CanBoController(ChangeView cw, CanBo cb, CanBoDAO cbd, LuongDAO ld,Luong l) {
        this.cb = cb;
        this.cbd = cbd;
        this.cw = cw;
        this.ld = ld;
        this.l = l;
        this.cw.AddCanBoBtnActionListener(new CanBoController.AddCanBoListener());
        this.cw.UpdateCanBoBtnActionListener(new CanBoController.UpdateCanBoListener());
        this.cw.DelCanBoBtnActionListener(new CanBoController.DelCanBoListener());
        this.cw.ClickTableCanBoListener(new CanBoController.ClickTableCanBoListener());
        this.cw.Cbx_MaCBBBActionListener(new CanBoController.Cbx_MaCBBBListener());
        BindingCanBo();
        BindingCbxMaCB();
    }
    
    public void BindingCbxMaCB(){
        cbd.CBbxMaCB(cw.CB_MaCB_GDinh, cw.CB_MaCB_BB, cw.CB_MaCB_ChamThi, cw.CB_MaCB_DoanVien, cw.CB_MaCB_Gday, cw.CB_MaCB_GiaoTrinh, cw.CB_MaCB_Luong, cw.CB_MaCB_NCKH, cw.CB_MaCb_DangVien, cw.CBx_MaCB_ChucDanh, cw.CBx_MaCB_ChucVu, cw.Cb_MaCB_CDV);
    }

    private void BindingCanBo(){
        cw.BindingCanBo(cbd.loadTableCanBo());
    }

    private class Cbx_MaCBBBListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            listcbo = cb.getByID(cw.CB_MaCB_BB.getSelectedItem().toString());
            for(CanBo cbo : listcbo){
                cw.TxtTen_CBBB.setText(cbo.getHoVaTen());
            }
        
        }
    }

    private class ClickTableCanBoListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (cw.CanBo_TBL.getSelectedRow() != -1) {
            int row = cw.CanBo_TBL.getSelectedRow();

            listcbo = cb.getALL();
            cw.TxtCanBoID.setText(listcbo.get(row).getMa_CB());
            cw.TxtTenDangNhap.setText(listcbo.get(row).getUserName());
            cw.TxtTenCanBo.setText(listcbo.get(row).getHoVaTen());
            
            String genre = listcbo.get(row).getGioiTinh();
            switch(genre){
                case("nam"):{
                    cw.Rbtn_Nam.setSelected(true);
                    cw.RBtn_Nu.setSelected(false);
                    break;
                }
                case("nu"):{
                    cw.RBtn_Nu.setSelected(true);
                    cw.Rbtn_Nam.setSelected(false);
                    break;
                }
            }
            int dgv = listcbo.get(row).getDangVien();
            int dv = listcbo.get(row).getDoanVien();
            int cdv = listcbo.get(row).getCongDoanVien();
            if(dgv == 1){
                cw.Rbtn_DangVien.setSelected(true);
            }else if(dgv == 0){
                cw.Rbtn_DangVien.setSelected(false);
            }
            
            if(dv == 1){
                cw.RBtn_DoanVien.setSelected(true);
            }else if(dv == 0){
                cw.RBtn_DoanVien.setSelected(false);
            }
            
            if(cdv == 1){
                cw.RBtn_CongDoanVien.setSelected(true);
            }else if(cdv == 0){
                cw.RBtn_CongDoanVien.setSelected(false);
            }
            cw.TxtNoiCongTac.setText(listcbo.get(row).getNoiCongTac());
            cw.TxtMaSoThue.setText(listcbo.get(row).getMaSoThue());
            cw.TxtSoTaiKhoan.setText(listcbo.get(row).getSoTaiKhoan());
            cw.TxtDiaChi.setText(listcbo.get(row).getDiaChi());
            cw.TxtSoDienThoai.setText(listcbo.get(row).getSoDienThoai());
            cw.TxtEmail.setText(listcbo.get(row).getEmail());
            cw.TxtThanhTich.setText(listcbo.get(row).getThanhTich());
            cw.TxtThongTinKhac.setText(listcbo.get(row).getThongTinKhac());
            cw.Cbx_TrinhDo.setSelectedItem(listcbo.get(row).getTrinhDo());
            
            String nam = listcbo.get(row).getNgaySinh().substring(0, 4);
            String thang = listcbo.get(row).getNgaySinh().substring(5, 7);
            String ngay = listcbo.get(row).getNgaySinh().substring(8, 10);
            
            cw.Cbx_NamSinh_CB.setSelectedItem(nam);
            cw.Cbx_ThangSinh_CB.setSelectedItem(thang);
            cw.Cbx_NgaySinh_CB.setSelectedItem(ngay);
            cw.CBx_Nam_Ctac.setSelectedItem(listcbo.get(row).getThoiGianBDCT().substring(0, 4));
            cw.CBx_Thang_Ctac.setSelectedItem(listcbo.get(row).getThoiGianBDCT().substring(5, 7));
            cw.CBx_Ngay_Ctac.setSelectedItem(listcbo.get(row).getThoiGianBDCT().substring(8, 10));
        }
        }
    }

    private  class DelCanBoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            cbd.DelCanBo(cw.CanBo_TBL);
            isl.theQuery("INSERT INTO Log (NoiDung) value('xóa cán bộ')");
            cw.BindingCanBo(cbd.loadTableCanBo());
            BindingCbxMaCB();
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
            String TrinhDo = cw.Cbx_TrinhDo.getSelectedItem().toString();
            String MaSoThue = cw.TxtMaSoThue.getText();
            String SoTaiKhoan = cw.TxtSoTaiKhoan.getText();
            String DiaChi = cw.TxtDiaChi.getText();
            String SoDienThoai = cw.TxtSoDienThoai.getText();
            String Email = cw.TxtEmail.getText();
            String ThanhTich = cw.TxtThanhTich.getText();
            String ThongTinKhac = cw.TxtThongTinKhac.getText();
            int Dgv, dv, cdv;
            if(cw.Rbtn_DangVien.isSelected()){
                Dgv = 1;
            }else {
                Dgv =0;
            }
            if(cw.RBtn_DoanVien.isSelected()){
                dv = 1;
            }else{
                dv = 0;
            }
            if(cw.RBtn_CongDoanVien.isSelected()){
                cdv = 1;
            }else {
                cdv = 0;
            }
            
            cbd.UpdateCanBo(Ma_CB, user, HovaTen, NgaySinh, GioiTinh, NoiCongTac, ThoiGianBatDau, TrinhDo, MaSoThue, SoTaiKhoan, DiaChi, SoDienThoai, Email, ThanhTich, ThongTinKhac, Dgv, dv,cdv);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật thông tin cán bộ')");
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
            String NgaySinh = cw.Cbx_NamSinh_CB.getSelectedItem().toString() +"-"
                                +cw.Cbx_ThangSinh_CB.getSelectedItem().toString() +"-"
                                    +cw.Cbx_NgaySinh_CB.getSelectedItem().toString();
            String GioiTinh ="";
            if(cw.Rbtn_Nam.isSelected()){
                GioiTinh = "nam\n";
            }else if(cw.RBtn_Nu.isSelected()){
                GioiTinh = "nu\n";
            }
            String NoiCongTac = cw.TxtNoiCongTac.getText();
            String ThoiGianBatDau  = cw.CBx_Nam_Ctac.getSelectedItem().toString() +"-"
                                        +cw.CBx_Thang_Ctac.getSelectedItem().toString()+"-"
                                            +cw.CBx_Ngay_Ctac.getSelectedItem().toString();
            String TrinhDo = cw.Cbx_TrinhDo.getSelectedItem().toString();
            String MaSoThue = cw.TxtMaSoThue.getText();
            String SoTaiKhoan = cw.TxtSoTaiKhoan.getText();
            String DiaChi = cw.TxtDiaChi.getText();
            String SoDienThoai = cw.TxtSoDienThoai.getText();
            String Email = cw.TxtEmail.getText();
            String ThanhTich = cw.TxtThanhTich.getText();
            String ThongTinKhac = cw.TxtThongTinKhac.getText();
             int Dgv, dv, cdv;
            if(cw.Rbtn_DangVien.isSelected()){
                Dgv = 1;
            }else {
                Dgv =0;
            }
            if(cw.RBtn_DoanVien.isSelected()){
                dv = 1;
            }else{
                dv = 0;
            }
            if(cw.RBtn_CongDoanVien.isSelected()){
                cdv = 1;
            }else {
                cdv = 0;
            }
            
            if (!checkEmpty(cw.TxtCanBoID, Ma_CB, "Mã Cán Bộ")&&!checkEmpty(cw.TxtTenDangNhap, user, "Tên Đăng Nhập")) {
                return;
            }else {
            cbd.AddCanBo(Ma_CB, user, Password, HovaTen, NgaySinh, GioiTinh, NoiCongTac, ThoiGianBatDau, TrinhDo, MaSoThue, SoTaiKhoan, DiaChi, SoDienThoai, Email, ThanhTich, ThongTinKhac,Dgv,dv,cdv);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Thêm cán bộ')");
            }
            
            cw.BindingCanBo(cbd.loadTableCanBo());
            BindingCbxMaCB();
        }
     
    }
    
   
    
}

