/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.PhuPhiView;
import Model.*;
import ModelDAO.ChamThiDAO;
import ModelDAO.LuongDAO;
import View.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhq
 */
public class PhuPhiViewController {
    Insertlog isl = new Insertlog();
    String user;
    int LCB = 1500000;
    private PhuPhiView ppv;
    private CanBo cb;
    private Luong lg;
    private GiangDay gdy;
    private ChucDanh cd;
    private ChucVu cv;
    private ChamThi ct;
    private LuongDAO ld;
    private ChamThiDAO ctd;
    
    
    public PhuPhiViewController(PhuPhiView ppv, CanBo cb,Luong lg, GiangDay gdy, ChucDanh cd, ChucVu cv, ChamThi ct,LuongDAO ld,ChamThiDAO ctd, String s){
        this.ppv = ppv;
        this.user = s;
        this.cb = cb;
        this.lg = lg;
        this.gdy = gdy;
        this.cd = cd;
        this.cv = cv;
        this.ct = ct;
        this.ld = ld;
        this.ctd = ctd;
        this.ppv.GetDataBtnActionListener(new PhuPhiViewController.GetDataListener());
        this.ppv.TinhBtnActionListener(new PhuPhiViewController.TinhListener());
        this.ppv.RefreshBtnActionListener(new PhuPhiViewController.RefreshListener());
        this.ppv.SaveBtnActionListener(new PhuPhiViewController.SaveListener());
        this.ppv.BackBtnActionListenter(new PhuPhiViewController.BackListener());
        this.ppv.CBx_MaCbActionListener(new PhuPhiViewController.Cbx_MaCbListener());
        this.ppv.GetTableLuongBtnActionListener(new PhuPhiViewController.GetTableLuongListener());
        this.ppv.GetTableChamThiBtnActionListener(new PhuPhiViewController.GetTableChamThiListener());
        if(s.equals("admin")){
           ppv.Cbx_MaCB.setEnabled(true);
        }else{
            ppv.Cbx_MaCB.setEnabled(false);
            ppv.RBtn_1nguoi.setEnabled(false);
            ppv.Rbtn_NhieuNguoi.setEnabled(false);
            ArrayList<CanBo> listcb = cb.getByUser(s);
            for(CanBo cbo : listcb){
                String macb = cbo.getMa_CB();
                ppv.Cbx_MaCB.setSelectedItem(macb);
            }
            
        }
    }
    
    public double PhuCapChucVu(String ChucVu){
        double pccv = 0;
        switch(ChucVu){
            case("Hiệu trưởng "):{
                pccv = 4.0;
                break;
            }
            case("Phó hiệu trưởng "):{
                pccv = 3.2;
                break;
            }
            case("Trưởng khoa "):{
                pccv = 1.8;
                break;
            }
            case("Viện trưởng "):{
                pccv = 1.8;
                break;
            }
            case("Phó trưởng khoa "):{
                pccv = 1.5;
                break;
            }
            case("Viện phó "):{
                pccv = 1.5;
                break;
            } 
            case("Trưởng bộ môn "):{
                pccv = 1.0;
                break;
            }
            case("Phó trưởng bộ môn "):{
                pccv = 0.6;
                break;
            }
            case("Trưởng phòng "):{
                pccv = 2.0;
                break;
            }
            case("Phó trưởng phòng "):{
                pccv = 1.6;
                break;
            }
            case("Giám đốc trung tâm nghiên cứu "):{
                pccv = 0.8;
                break;
            }
            case("Phó giám đốc trung tâm nghiên cứu "):{
                pccv = 0.6;
                break;
            }
        }
        return pccv;
    }
    
    public double HeSoThamLien(String gioitinh, String macanbo){
        double k3 =0;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        CanBo cb = new CanBo();
        ArrayList<CanBo> listcb = new ArrayList<>();
        listcb = cb.getByID(macanbo);
        switch(gioitinh){
            case("nam"):{
                for(CanBo cbo : listcb){
                    String nam = cbo.getThoiGianBDCT().toString().substring(0, 4);
                    int inam = Integer.parseInt(nam);
                    int kc = year - inam;
                    k3 = kc/30d;
                    break;
                }
            }
            case("nu"):{
                for(CanBo cbo : listcb){
                    String nam = cbo.getThoiGianBDCT().toString().substring(0, 4);
                    int inam = Integer.parseInt(nam);
                    int kc = year - inam;
                    k3 = kc/25d;
                    break;
                }
            }
        }
        return k3;
       
    }
    
    public double HeSoChucDanh(String ChucDanh){
        double pccd =0;
        switch(ChucDanh){
            case("Giảng Viên "):{
                pccd = 1.0;
                break;
            }
            case("Cán bộ phục vụ giảng dạy "):{
                pccd = 1.0;
                break;
            }
            case("Tiến sĩ "):{
                pccd = 1.2;
                break;
            }
            case("Phó Giáo sư "):{
                pccd = 1.4;
                break;
            }
            case("Giáo sư "):{
                pccd = 1.5;
                break;
            }
            case("Giảng viên cao cấp "):{
                pccd = 1.5;
                break;
            }
        }    
        return pccd;
    }
    
    public double HeSoTrinhDo(String TrinhDo){
        double hstd = 0;
        switch(TrinhDo){
            case"Giáo sư ":{
                hstd = 0.7;
            }
            case"Tiến sĩ ":{
                hstd = 0.3;
            }
            case"Phó Giáo sư":{
                hstd = 0.5;
            }
            case"Thạc sĩ":{
                hstd = 0.1;
            }       
        }
        return hstd;
    }
    
    public int SoGioDay(String MaCanBo,String Thang,String Nam){
        int sogio = 0;
        int thang = Integer.parseInt(Thang);
        String hocky="1" ;
        if(8<=thang && thang<=1){
            hocky = "1";
        }else if(2<= thang && thang<= 5){
            hocky = "2";
        }
        ArrayList<GiangDay> listgdy = gdy.getByIDCBTIME(MaCanBo, hocky, Nam);
        for(GiangDay gday : listgdy){
            String sogioday = gday.getSoGioDay();
            sogio = Integer.parseInt(sogioday);
        }
        return sogio;
    }
    
    public void theQuery(String query) {
        Connection con = null;
        Statement st = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/quanlycanbobk", "root", "");
            st = con.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, " Add Successfully! ");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
}  
    
    ArrayList<Luong> listl = new ArrayList<>();
    ArrayList<CanBo> listcb = new ArrayList<>();
    ArrayList<ChamThi> listct = new ArrayList<>();

    private class GetTableChamThiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String thang = ppv.Cbx_Thang_ChamThi.getSelectedItem().toString();
            String nam = ppv.Cbx_Nam_ChamThi.getSelectedItem().toString();
            
            listct = ct.getByTIME(nam, thang);
            ppv.BindingChamThi(ctd.loadTableChamThiTime(listct));
            
        }
    }
    private class GetTableLuongListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String thang = ppv.Cbx_Thang.getSelectedItem().toString();
            String nam = ppv.Cbx_Nam.getSelectedItem().toString();

            listl = lg.getByTime(nam, thang);
            while (listl == null){
                int ithang = Integer.parseInt(ppv.Cbx_Thang_TGBD.getSelectedItem().toString());
                ithang--;
                listl = lg.getByTime(nam, Integer.toString(ithang));
            }

            ppv.BindingLuong(ld.loadTableLuongMonth(listl));
        }
    }



    private class Cbx_MaCbListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String macb = ppv.Cbx_MaCB.getSelectedItem().toString();
        }
    }
    
    private class RefreshListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ppv.setVisible(false);
            PhuPhiViewController ppvc = new PhuPhiViewController(ppv, cb, lg, gdy, cd, cv, ct,ld,ctd,user);
            ppv.setVisible(true);
        }
    }

    private class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String Luong = ppv.Txt_Luong.getText();
            String DangPhi = ppv.Txt_DP.getText();
            String CDPhi = ppv.Txt_CDP.getText();
            
            int sttluong = lg.getStt().length();
        
            try {
                theQuery("insert into luong (Luong) values ('" + Luong +"')where ma_canbo = "+ppv.Cbx_MaCB.getSelectedItem().toString()+" "
                        + "and year(ThoiGianBatDau) = "+ ppv.Cbx_Nam_TGBD.getSelectedItem().toString()+""
                        + "and month(ThoiGianBatDau)= "+ ppv.Cbx_Thang_TGBD.getSelectedItem().toString() +"");
                theQuery("insert into canbo_congdoanvien(SoTienDong) values ('"+CDPhi+"') where ma_canbo = "+ppv.Cbx_MaCB.getSelectedItem().toString()+" "
                        + "anhd year(ThoiGianDong) = "+ppv.Cbx_Nam_TGBD.getSelectedItem().toString()+" "
                        + "and month(ThoiGianDong) = "+ppv.Cbx_Thang_TGBD.getSelectedItem().toString()+"");
                theQuery("insert into canbo_dangvien(SoTienDong) values ('"+DangPhi+"') where ma_canbo = "+ppv.Cbx_MaCB.getSelectedItem().toString()+" "
                        + "anhd year(ThoiGianDong) = "+ppv.Cbx_Nam_TGBD.getSelectedItem().toString()+" "
                        + "and month(ThoiGianDong) = "+ppv.Cbx_Thang_TGBD.getSelectedItem().toString()+"");
                } catch (Exception e) {
                    e.printStackTrace();
            }
        }
    }

    private class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ppv.setVisible(false);
            Main m = new Main();
            Log lg = new Log();
            MainViewController mvc = new MainViewController(m, lg, user);
            m.setVisible(true);
        }
    }

    private class TinhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            double M1 = 700000;
            double M2 = 600000;
            double M3 = 700000;
            Double hsl = Double.parseDouble(ppv.Txt_HSL.getText());
            Double pccv = Double.parseDouble(ppv.Txt_PCCV.getText());
            Double lcb = Double.parseDouble(ppv.Txt_LCB.getText());
            Double pcgd = Double.parseDouble(ppv.Txt_TienChamThi.getText());
            Double hstl = Double.parseDouble(ppv.Txt_HeSoThamLien.getText());
            Double pccd = Double.parseDouble(ppv.Txt_PCCDanh.getText());
            
            Double luong = (lcb*(hsl+pccd))+(M1+(pccv+hstl)*M2+M3);
            Double dangphi = (((hsl+pccv)*lcb)+pcgd)*(1/100d);
            Double congdoanphi = (((hsl)*lcb)+pcgd)*(1/100d);
            
            ppv.Txt_Luong.setText(Double.toString(luong));
            ppv.Txt_DP.setText(Double.toString(dangphi));
            ppv.Txt_CDP.setText(Double.toString(congdoanphi));
        
        }
    }

    private class GetDataListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            ChucDanh cd = new ChucDanh();
            CanBo  cb = new CanBo();
            Luong lg = new Luong();
            ChucVu cv = new ChucVu();
            ChamThi ct = new ChamThi();
            BaiBaoTapChi bb= new BaiBaoTapChi();
            
            ArrayList<CanBo> listcb = new ArrayList<>();
            ArrayList<BaiBaoTapChi> listbb = new ArrayList<>();
            
            String ma_canbo = ppv.Cbx_MaCB.getSelectedItem().toString();

            listcb = cb.getByID(ma_canbo);
            listbb = bb.getByIDCB(ma_canbo);
            int sogioday = SoGioDay(ma_canbo, ppv.Cbx_Thang_TGBD.getSelectedItem().toString(), ppv.Cbx_Nam_TGBD.getSelectedItem().toString());
            String tienday = Integer.toString(60000*sogioday);
            ppv.TxtTienGiangDay.setText(tienday);
            String chucdanh = cd.getByIDCB(ma_canbo);
            String chucvu = cv.getByTime(ma_canbo,ppv.Cbx_Nam_TGBD.getSelectedItem().toString(),ppv.Cbx_Thang_TGBD.getSelectedItem().toString());
            while (chucvu == ""){
                int thang = Integer.parseInt(ppv.Cbx_Thang_TGBD.getSelectedItem().toString());
                thang--;
                chucvu = cv.getByTime(ma_canbo,ppv.Cbx_Nam_TGBD.getSelectedItem().toString(), Integer.toString(thang));
            }
            Double hsl = lg.getByIDandTime(ma_canbo,ppv.Cbx_Nam_TGBD.getSelectedItem().toString(),
                                                                            ppv.Cbx_Thang_TGBD.getSelectedItem().toString());
            while (hsl == 0.0) {                
                int thang = Integer.parseInt(ppv.Cbx_Thang_TGBD.getSelectedItem().toString());
                thang--;
                hsl = lg.getByIDandTime(ma_canbo, ppv.Cbx_Nam_TGBD.getSelectedItem().toString() , Integer.toString(thang));
            }
                
            
            
            ppv.Txt_LCB.setText(Integer.toString(LCB));

            String sbt = ct.getSoBaiThi(ma_canbo,ppv.Cbx_Nam_TGBD.getSelectedItem().toString(),ppv.Cbx_Thang_TGBD.getSelectedItem().toString());
            try {
                int tbt = 10000*Integer.parseInt(sbt);
                ppv.Txt_TienChamThi.setText(Integer.toString(tbt));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            
            
            ppv.Txt_PCGD.setText("1");
            for(CanBo cbo :listcb){
                ppv.Txt_HoVaTen.setText(cbo.getHoVaTen());
                String gioitinh = cbo.getGioiTinh();
                String macanbo = cbo.getMa_CB();
                double k3 = HeSoThamLien(gioitinh, macanbo);
                ppv.Txt_HeSoThamLien.setText(Double.toString(k3));
                
            }
                double pccv = PhuCapChucVu(chucvu);
                ppv.Txt_PCCV.setText(Double.toString(pccv));
                
                double pccd = HeSoChucDanh(chucdanh);
                ppv.Txt_PCCDanh.setText(Double.toString(pccd));
                
                ppv.Txt_HSL.setText(Double.toString(hsl));
                
                
        }
    }
    
}
