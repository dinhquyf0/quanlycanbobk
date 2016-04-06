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
    int tuoi = 16;
    String thanhtich = "";
    
    private Main m;
    private ListView lv;
    private CanBo cb;
    private GiaDinh gd;
    private ChamThi ct;
    private GiangDay gdy;
    
    public ListViewController(ListView lv,CanBo cb,GiaDinh gd, GiangDay gdy,ChamThi ct, String s){
        this.user = s;
        this.cb = cb;
        this.lv = lv;
        this.gd = gd;
        this.gdy = gdy;
        this.ct = ct;
        this.lv.BackBtnActionListener(new ListViewController.BackBtnListener());
        this.lv.ChangeBtnActionListener(new ListViewController.ChangeBtnListener());
        if(s.equals("admin")){
            lv.Chbx_ChangeAge.setEnabled(true);
            lv.Chbx_Thaydoithanhtich.setEnabled(true);
        }else{
            lv.Chbx_ChangeAge.setEnabled(false);
            lv.Chbx_Thaydoithanhtich.setEnabled(false);
        }
        
        Binding();
    }
    
    ArrayList<CanBo> listcbo = new ArrayList<>();
    ArrayList<GiaDinh> listgd = new ArrayList<>();
    ArrayList<ChamThi> listct = new ArrayList<>();
    ArrayList<GiangDay> listgdy = new ArrayList<>();
    
    public void Binding(){
        lv.BindingDanhSachChamThi(ChamThi());
        lv.BindingQua(NhanQua());
        lv.BindingThanhTichCao(ThanhTichCacChau());
    }
    
    public Vector ChamThi(){
        Vector data = new Vector();
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
            if(year - nsi < tuoi){
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
                Binding();
            }
            if(lv.Chbx_Thaydoithanhtich.isSelected()){
                changeThanhTich(lv.TxtThanhTichCacChau.getText());
            }
        }
    }
    
}
