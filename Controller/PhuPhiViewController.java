/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.PhuPhiView;
import Model.*;
import ModelDAO.CanBoCongDoanVienDAO;
import ModelDAO.CanBoDangVienDAO;
import ModelDAO.CanBoDoanVienDAO;
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
    double M1 = 700000;
    double M2 = 600000;
    double M3 = 700000;
    private PhuPhiView ppv;
    private CanBo cb;
    private Luong lg;
    private GiangDay gdy;
    private ChucDanh cd;
    private ChucVu cv;
    private ChamThi ct;
    private LuongDAO ld;
    private ChamThiDAO ctd;
    
    ArrayList<Luong> listl = new ArrayList<>();
    ArrayList<CanBo> listcb = new ArrayList<>();
    ArrayList<ChamThi> listct = new ArrayList<>();
    
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
        this.ppv.BackBtnActionListenter(new PhuPhiViewController.BackListener());
        this.ppv.CBx_MaCbActionListener(new PhuPhiViewController.Cbx_MaCbListener());
        this.ppv.GetTableLuongBtnActionListener(new PhuPhiViewController.GetTableLuongListener());
        this.ppv.GetTableChamThiBtnActionListener(new PhuPhiViewController.GetTableChamThiListener());
        this.ppv.XemPhiBtnActionListener(new PhuPhiViewController.XemPhiBtnListener());
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
    
    public PhuPhiViewController(Luong lg, CanBo cb, GiangDay gdy){
        this.lg = lg;
        this.cb = cb;
        this.gdy = gdy;
    }
    
    public Vector loadLuong(String thang, String nam, ArrayList<Luong> listl){
        Vector data = new Vector();
        for(Luong l : listl){
            Vector row = new Vector();
            listcb =cb.getByID(l.getma_canbo());
            
            row.add(l.getStt());
            row.add(l.getma_canbo());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            row.add(thang+"-"+nam);
            row.add(Luong(LCB, HeSoLuongtheonam(l.getma_canbo(),nam), HeSoChucDanh(l.getma_canbo()), PhuCapChucVu(l.getma_canbo()), HeSoThamniem(listcb.get(0).getGioiTinh(), l.getma_canbo())));
            data.add(row);
        }
        return data;
    }
    
    public void BindingTienChamtthi(){
        ppv.BindingChamThi(ctd.loadTienChamThi());
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
    
    public double HeSoThamniem(String gioitinh, String macanbo){
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
    
    public double HeSoLuongtheonam(String MaCanBo, String nam){
        double HSL = lg.getHSL(MaCanBo);
        String NamCT = cb.getThoiGianBatDauCongTac(MaCanBo).substring(0, 4);
        int namhientai = Integer.parseInt(nam);
        HSL = HSL+(((namhientai - Integer.parseInt(NamCT))/3)*0.33);
        return  HSL;
    }
    
    public double HeSoGiangDay(String MaCanBo,String Thang, String Nam){
        double pcgd =0;
        int thang = Integer.parseInt(Thang);
        String hocky="1" ;
        if(8<=thang || thang<=1){
            hocky = "1";
        }else if(2<= thang && thang<= 5){
            hocky = "2";
        }
        ArrayList<GiangDay> listgdy = gdy.getByIDCBTIME(MaCanBo, hocky, Nam);
        for(GiangDay gday : listgdy){
            String PCGD = gday.getPhuCap_GD();
            pcgd = Double.parseDouble(PCGD);
        }
        return pcgd;
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

    private class XemPhiBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            CanBoDangVienDAO dgvd = new CanBoDangVienDAO();
            CanBoDoanVienDAO dvd = new CanBoDoanVienDAO();
            CanBoCongDoanVienDAO cdvd = new CanBoCongDoanVienDAO();
            String phi = ppv.Cbx_D_CD_phi.getSelectedItem().toString();
            switch (phi) {
                case "đảng phí":
                    ppv.BindingDongDangPhi(dgvd.loadTableDangPhidadong(ppv.Cbx_nam_phi.getSelectedItem().toString(), ppv.Cbx_thang_phi.getSelectedItem().toString()));
                    break;
                case "đoàn phí":
                    ppv.BindingDongDoanPhi(dvd.loadTableDoanPhidadong(ppv.Cbx_nam_phi.getSelectedItem().toString(), ppv.Cbx_thang_phi.getSelectedItem().toString()));
                    break;
                case "công đoàn phí":
                    ppv.BindingDongCongDoanPhi(cdvd.loadTableCongDoanPhidadong(ppv.Cbx_nam_phi.getSelectedItem().toString(), ppv.Cbx_thang_phi.getSelectedItem().toString()));
                    break;
            }
            
        
        }
    }
    
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
            String thang = ppv.Cbx_Thang_Luong.getSelectedItem().toString();
            String nam = ppv.Cbx_Nam_Luong.getSelectedItem().toString();
            listl = lg.getALL();
            ppv.BindingLuong(loadLuong(thang, nam, listl));
        }
    }

    private class Cbx_MaCbListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String macb = ppv.Cbx_MaCB.getSelectedItem().toString();
            listcb = cb.getByID(macb);
            for(CanBo cbo : listcb){
            ppv.Txt_HoVaTen.setText(cbo.getHoVaTen());
            }
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
    
    public String Luong(int lcb, Double hsl,Double pccd, Double pccv, Double hstn){
        String luong = "";
        int iluong = (int) ((lcb*(hsl+pccd))+(M1+(pccv+hstn)*M2+M3));
        luong = Integer.toString(iluong);
        return luong;
    }
    
    public void TinhLuong(){
        
        String macb = ppv.Cbx_MaCB.getSelectedItem().toString();
        listcb = cb.getByID(macb);
        
        
        double hsl = Double.parseDouble(ppv.Txt_HSL.getText());
        double pccv = Double.parseDouble(ppv.Txt_PCCV.getText());
        double lcb = Double.parseDouble(ppv.Txt_LCB.getText());
        double pcgd = Double.parseDouble(ppv.Txt_PCGD.getText());
        double hstn = Double.parseDouble(ppv.Txt_HeSoThamniem.getText());
        double pccd = Double.parseDouble(ppv.Txt_PCCDanh.getText());

        int luong = (int) ((lcb*(hsl+pccd))+(M1+(pccv+hstn)*M2+M3));
        int dangphi = (int) ((((hsl+pccv)*lcb)+pcgd)*(1/100d));
        int doanphi = (int) ((hsl*lcb)*(1/100d));
        int congdoanphi = (int) ((((hsl)*lcb)+pcgd)*(1/100d));

        ppv.LBL_Luong.setText(Integer.toString(luong));
        
        
        
        for(CanBo cbo : listcb){
            if(cbo.getDoanVien()==1){
                    ppv.LBL_DoanPhi.setText(Integer.toString(doanphi));
                }else{
                    ppv.LBL_DoanPhi.setText("0");
                }
                if(cbo.getDangVien()==1){
                    ppv.LBL_DangPhi.setText(Integer.toString(dangphi));
                }else{
                   ppv.LBL_DangPhi.setText("0");
                }
                if(cbo.getCongDoanVien()==1){
                    ppv.LBL_CongDoanPhi.setText(Integer.toString(congdoanphi));
                }else{
                    ppv.LBL_CongDoanPhi.setText("0");
                }
        }
    }
    
    private class TinhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            TinhLuong();
            
        }
    }
    
    public void displayData(String thang, String nam){
        ChucDanh cd = new ChucDanh();
        CanBo  cb = new CanBo();
        ChucVu cv = new ChucVu();

        ArrayList<CanBo> listcb = new ArrayList<>();

        String ma_canbo = ppv.Cbx_MaCB.getSelectedItem().toString();

        listcb = cb.getByID(ma_canbo);
        String chucdanh = cd.getByIDCB(ma_canbo);
        String chucvu = cv.getChucVuByTime(ma_canbo);
        String namhientai = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
        double hsl = HeSoLuongtheonam(ma_canbo,namhientai);
        double pcgd = HeSoGiangDay(ma_canbo, thang, nam);
        ppv.Txt_LCB.setText(Integer.toString(LCB));

        ppv.Txt_PCGD.setText(Double.toString(pcgd));
        for(CanBo cbo :listcb){

            String gioitinh = cbo.getGioiTinh();
            String macanbo = cbo.getMa_CB();
            double k3 = HeSoThamniem(gioitinh, macanbo);
            ppv.Txt_HeSoThamniem.setText(Double.toString(k3));

        }
            double pccv = PhuCapChucVu(chucvu);
            ppv.Txt_PCCV.setText(Double.toString(pccv));

            double pccd = HeSoChucDanh(chucdanh);
            ppv.Txt_PCCDanh.setText(Double.toString(pccd));

            ppv.Txt_HSL.setText(Double.toString(hsl));

    }
    
    private class GetDataListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            displayData(ppv.Cbx_Thang_TGBD.getSelectedItem().toString(), ppv.Cbx_Nam_TGBD.getSelectedItem().toString());
                
        }
    }
    
}
