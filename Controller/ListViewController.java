/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

/**
 *
 * @author dinhq
 */
public class ListViewController {
    Insertlog isl = new Insertlog();
    String user;
    public static int tuoi = 20;
    public static int Hocky = 1;
    public static int Namhoc = 2015;
    public static String thanhtich = "";
    
    
    
    private Main m;
    private ListView lv;
    private CanBo cb;
    private GiaDinh gd;
    private ChamThi ct;
    private GiangDay gdy;
    private NghienCuuKhoaHoc nckh;
    private BaiBaoTapChi bb;
    
    public ListViewController(ListView lv,CanBo cb,GiaDinh gd, GiangDay gdy,ChamThi ct,NghienCuuKhoaHoc nckh,BaiBaoTapChi bb, String s){
        this.user = s;
        this.cb = cb;
        this.lv = lv;
        this.gd = gd;
        this.gdy = gdy;
        this.ct = ct;
        this.nckh = nckh;
        this.bb = bb;
        this.lv.BackBtnActionListener(new ListViewController.BackBtnListener());
        this.lv.ChangeBtnActionListener(new ListViewController.ChangeBtnListener());
        this.lv.ChangCbxListTBLActionListener(new ListViewController.CbxListTBLListener());
        if(s.equals("admin")){
            lv.Chbx_ChangeAge.setEnabled(true);
            lv.Chbx_Thaydoithanhtich.setEnabled(true);
            lv.Chbx_Hocki.setEnabled(true);
            lv.Chbx_Nam.setEnabled(true);
        }else{
            lv.Chbx_ChangeAge.setEnabled(false);
            lv.Chbx_Thaydoithanhtich.setEnabled(false);
            lv.Chbx_Hocki.setEnabled(false);
            lv.Chbx_Nam.setEnabled(false);
        }
        
        BindingCbxListTBL();

    }
    
    public void BindingCbxListTBL(){
        lv.Cbx_ListTBL.addItem("Danh sách các cháu nhận quà trung thu");
        lv.Cbx_ListTBL.addItem("Danh sách các cháu có thành tích cao");
        lv.Cbx_ListTBL.addItem("Danh sách tình trạng chấm thi");
        lv.Cbx_ListTBL.addItem("Danh sách các môn học trong 1 học kỳ");
        lv.Cbx_ListTBL.addItem("Danh sách các đề tài nghiên cứu khoa học");
        lv.Cbx_ListTBL.addItem("Danh sách các bài báo đã được công bố");
    }
    
    ArrayList<CanBo> listcbo = new ArrayList<>();
    ArrayList<GiaDinh> listgd = new ArrayList<>();
    ArrayList<ChamThi> listct = new ArrayList<>();
    ArrayList<GiangDay> listgdy = new ArrayList<>();
    ArrayList<BaiBaoTapChi> listbb = new ArrayList<>();
    ArrayList<NghienCuuKhoaHoc> listnckh = new ArrayList<>();
    
    public Vector BaiBao(){
        Vector data = new Vector();
        listbb = bb.getALL();
        for (BaiBaoTapChi bb : listbb){
            
            Vector row = new Vector();
            listcbo = cb.getByIDBB(bb.getMa_BaiBao());
            
            if(listcbo.size() > 0){
                row.add(listcbo.get(0).getHoVaTen());
            }else{
                row.removeAll(row);
            }
            row.add(bb.getTenTapChi());
            row.add(bb.getSo());
            row.add(bb.getThoiGianXuatBan());
            
            data.add(row);
            }
        return data;
    }
    
    public Vector DeTai(){
        Vector data = new Vector();
        listnckh = nckh.getALL();
        for (NghienCuuKhoaHoc nckh : listnckh){
            
            Vector row = new Vector();
            row.add(nckh.getMa_DT());
            row.add(nckh.getChuTriDeTai());
            row.add(nckh.getTenDeTai());
            row.add(nckh.getCap());
            row.add(nckh.getKinhPhi());
            row.add(nckh.getThoiGianBatDau());
            row.add(nckh.getThoiGianKetThuc());
            row.add(nckh.getTinhTrang());
            row.add(nckh.getKetQua());
            data.add(row);
            }
        return data;
    }
    
    public Vector DanhSachMonHoc(){
        Vector data = new Vector();
        listgdy = gdy.getALL();
        for (GiangDay gdy : listgdy){
            String namhoc = gdy.getNamHoc();
            int namhocint = Integer.parseInt(namhoc);
            String hocky = gdy.getHocKy();
            int hocki = Integer.parseInt(hocky);
            Vector row = new Vector();
            listcbo = cb.getByIDGDY(gdy.getMa_MH());
            if(listgdy.size() > 0){
                row.add(gdy.getMa_MH());
            }else{
                row.removeAll(row);
            }
            if(listgdy.size() > 0){
                row.add(gdy.getTenMon());
            }else{
                row.removeAll(row);
            }
            if(listcbo.size() > 0){
                row.add(listcbo.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            if(listgdy.size() > 0){
                row.add(gdy.getSoTinChi());
            }else{
                row.removeAll(row);
            }
           if(hocki == Hocky){
                row.add(gdy.getHocKy());
            }else{
                row.removeAll(row);
            }
           if(namhocint >= Namhoc){
                row.add(gdy.getNamHoc());
            }else{
                row.removeAll(row);
            }
            data.add(row);
        }
        return data;
    }
    
    public Vector ChamThi(){
        Vector data = new Vector();
        listgdy = gdy.getALL();
        for (GiangDay gday : listgdy){

            Vector row = new Vector();
            listct = ct.getByIDCT(gday.getMa_MH());
            if(listct.size() > 0){
                row.add(gday.getMa_MH());
            }else{
                row.removeAll(row);
            }
            if(listct.size() > 0){
                row.add(gday.getTenMon());
            }else{
                row.removeAll(row);
            }
            if(listct.size() > 0){
                row.add(gday.getLop());
            }else{
                row.removeAll(row);
            }
            if(listct.size() > 0){
                row.add(gday.getSoSinhVien());
            }else{
                row.removeAll(row);
            }
            if(listct.size() > 0){
                row.add(listct.get(0).getSoBaiThi());
            }else{
                row.add("isEmpty");
            }
           if(listct.size() > 0){
                row.add(listct.get(0).getNgayNop());
            }else{
                row.add("isEmpty");
            }
           if(listct.size() > 0){
                row.add(gday.getHocKy());
            }else{
                row.removeAll(row);
            }
           if(listct.size() > 0){
                row.add(gday.getNamHoc());
            }else{
                row.removeAll(row);
            }
            data.add(row);
        }
        return data;
    }
    
    public Vector ThanhTichCacChau(){
        Vector data = new Vector();
        listgd = gd.getALL();
        for (GiaDinh gd : listgd){

            Vector row = new Vector();
            listcbo = cb.getByIDGD(gd.getMa_GD());
            if(listcbo.size() > 0){
                row.add(listcbo.get(0).getMa_CB());
            }else{
                row.add("isEmpty");
            }
            if(listcbo.size() > 0){
                row.add(listcbo.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            row.add(gd.getMa_GD());
            row.add(gd.getHoVaTenCon());
            row.add(gd.getNamSinh());
            String ThanhTich = gd.getThanhTich();
           if(ThanhTich.contains(thanhtich)){
                row.add(gd.getThanhTich());
            }else{
                row.removeAll(row);
            }
            data.add(row);
        }
        return data;
    }
    
    public Vector NhanQua(){
        listgd = gd.getALL();
        Vector data = new Vector();
        for (GiaDinh gd : listgd){
            String ns = gd.getNamSinh();
            int nsi = Integer.parseInt(ns);
            int x;
            int year = Calendar.getInstance().get(Calendar.YEAR);
            x = year -nsi;
            Vector row = new Vector();
            listcbo = cb.getByIDGD(gd.getMa_GD());

            if(listcbo.size() > 0){
                row.add(listcbo.get(0).getMa_CB());
            }else{
                row.add("isEmpty");
            }
            if(listcbo.size() > 0){
                row.add(listcbo.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            row.add(gd.getMa_GD());
            row.add(gd.getHoVaTenCon());
            if(year - nsi <= tuoi){
                row.add(x);
            }else{
                row.removeAll(row);
            }
            data.add(row);
            }
        return data;
    }
    
    public void changeTuoi(int tuoi){
        this.tuoi = tuoi;
    }
    
    public void changeThanhTich(String thanhtich){
        this.thanhtich = thanhtich;
    }

    public void changeNamHoc(int Namhoc){
        this.Namhoc = Namhoc;
    }
    public void changeHocKy(int hocky){
        this.Hocky = hocky;
    }
    
    private class CbxListTBLListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String chon = lv.Cbx_ListTBL.getSelectedItem().toString();
            lv.LBL_List_TBL.setText(chon);
            switch(chon){
                case"Danh sách các cháu nhận quà trung thu":{
                    lv.BindingQua(NhanQua());
                    break;
                }
                case"Danh sách các cháu có thành tích cao":{
                    lv.BindingThanhTichCao(ThanhTichCacChau());
                    break;
                }
                case"Danh sách tình trạng chấm thi":{
                    lv.BindingDanhSachChamThi(ChamThi());
                    break;
                }
                case"Danh sách các môn học trong 1 học kì":{
                    lv.BindingDanhSachMonHoc(DanhSachMonHoc());
                    break;
                }
                case"Danh sách các đề tài nghiên cứu khoa học":{
                    lv.BindingDeTai(DeTai());
                    break;
                }
                case"Danh sách các bài báo đã được công bố":{
                    lv.BindingBaiBao(BaiBao());
                    break;
                }
            }
            
        }
    }
    
    private class BackBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            lv.setVisible(false);
            Main m = new Main();
            Log lg = new Log();
            MainViewController mvc = new MainViewController(m,lg, user);
            m.setVisible(true);
        }
    }

    private class ChangeBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(lv.Chbx_ChangeAge.isSelected()){
                changeTuoi(Integer.parseInt(lv.TxtTuoiNhanQua.getText().toString()));
                lv.BindingQua(NhanQua());
            }
            if(lv.Chbx_Thaydoithanhtich.isSelected()){
                changeThanhTich(lv.TxtThanhTichCacChau.getText());
                lv.BindingThanhTichCao(ThanhTichCacChau());
            }
            if(lv.Chbx_Nam.isSelected()){
                changeNamHoc(Integer.parseInt(lv.Txt_NamHoc.getText()));
                lv.BindingDanhSachMonHoc(DanhSachMonHoc());
            }
            if(lv.Chbx_Hocki.isSelected()){
                changeHocKy(Integer.parseInt(lv.Txt_Hocki.getText()));
                lv.BindingDanhSachMonHoc(DanhSachMonHoc());
            }
        }
    }
    
}
