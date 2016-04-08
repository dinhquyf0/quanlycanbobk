/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import Model.*;
import ModelDAO.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
/**
 *
 * @author DINHQUY
 */
public class MainViewController {
    String s;
    private Main mw;
    LoginView lgw = new LoginView();
    AboutView abw = new AboutView();
    ChangeView cw = new ChangeView();
    ChangePassView cpw = new ChangePassView();
    CanBoSearchView csw = new CanBoSearchView();
    ListView lw = new ListView();
    PhuPhiView ppw = new PhuPhiView();
    private Log log;
    
    
    public MainViewController(Main m, Log log, String user){
        this.mw = m;
        this.log  = log;
        s = user;
        this.mw.AboutBtnListener(new MainViewController.getAboutBtnListener());
        this.mw.ChangeDatatBtnListener(new MainViewController.getChangeDataBtnListener());
        this.mw.ChangePassBtnListener(new MainViewController.getChangePassBtnListener());
        this.mw.SearchBtnListener(new MainViewController.getSearchBtnListener());
        this.mw.ListBtnListener(new MainViewController.getListBtnListener());
        this.mw.PPBtnListener(new MainViewController.getPPBtnListener());
        this.mw.LogoutBtnListener(new MainViewController.getLogoutBtnListener());
        
        mw.LBL_Ten.setText(user);
        BindingLog();
        
        if(user.equals("admin")){
            mw.ChangeBtn.setEnabled(true);
        }else if(user.equals("Khách")){
            mw.ChangeBtn.setEnabled(false);
            mw.AboutBtn.setEnabled(false);
            mw.ChangePassBtn.setEnabled(false);
            mw.PPBtn.setEnabled(false);
            mw.ListBtn.setEnabled(false);
            
            }else{
            mw.ChangeBtn.setEnabled(false);
        }
    }
    
    public void BindingLog(){
        ArrayList<Log> listlog = new ArrayList<Log>();
        listlog = log.getALL();
//        String s ;
        String[] string = new String[5];
        DefaultListModel dlm = new DefaultListModel();
        for(Log lg :listlog){
            
            dlm.addElement(lg.getNoiDung().toString());
        }
        mw.ListLog.setModel(dlm);

        
    }
    private  class getAboutBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            mw.setVisible(false);
            CanBo cb = new CanBo();
            AboutViewController abvc = new AboutViewController(abw, cb, s);
            abw.setVisible(true);
        }

    }

    private  class getChangeDataBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            mw.setVisible(false);
            ChangeView cw = new ChangeView();
            
            CanBo cb = new CanBo();
            BaiBaoTapChi bb = new BaiBaoTapChi();
            CanBoCongDoanVien cdv = new CanBoCongDoanVien();
            CanBoDangVien dgv = new CanBoDangVien();
            CanBoDoanVien dv = new CanBoDoanVien();
            CanBo_GiaDinh cbgd = new CanBo_GiaDinh();
            ChamThi ct = new ChamThi();
            ChucDanh cd = new ChucDanh();
            ChucVu cv = new ChucVu();
            GiaDinh gd = new GiaDinh();
            GiangDay gdy = new GiangDay();
            GiangVien_GiangDay gvgd = new GiangVien_GiangDay();
            GiangVien_GiaoTrinh gvgt = new GiangVien_GiaoTrinh();
            GiangVien_NghienCuuKhoaHoc gvnckh = new GiangVien_NghienCuuKhoaHoc();
            GiangVien_TapChi gvtc = new GiangVien_TapChi();
            GiaoTrinh gt = new GiaoTrinh();
            Luong l = new Luong();
            NghienCuuKhoaHoc nckh = new NghienCuuKhoaHoc();
            
            BaiBaoTapChiDAO bbd = new BaiBaoTapChiDAO();
            CanBoCongDoanVienDAO cdvd = new CanBoCongDoanVienDAO();
            CanBoDAO cbd = new CanBoDAO();
            CanBoDangVienDAO dgvd = new CanBoDangVienDAO();
            CanBoDoanVienDAO dvd = new CanBoDoanVienDAO();
            ChamThiDAO ctd = new ChamThiDAO();
            ChucDanhDAO cdd = new ChucDanhDAO();
            ChucVuDAO cvd = new ChucVuDAO();
            GiaDinhDAO gdd  = new GiaDinhDAO();
            GiangDayDAO gdyd = new GiangDayDAO();
            GiaoTrinhDAO gtd = new GiaoTrinhDAO();
            LuongDAO ld = new LuongDAO();
            NghienCuuKhoaHocDAO nckhd = new NghienCuuKhoaHocDAO();
            
            BaiBaoTapChiController bbc = new BaiBaoTapChiController(cw, bb, gvtc, bbd, cb);
            CanBoController cbc = new CanBoController(cw, cb, cbd,ld,l);
            ChamThiController ctc = new ChamThiController(cw, ct, ctd,cb);
            ChucDanhController cdc = new ChucDanhController(cw, cd, cdd,cb);
            ChucVuController cvc = new ChucVuController(cw, cv, cvd,cb);
            CongDoanVienController cdvc = new CongDoanVienController(cw, cdv, cdvd,cb);
            DangPhiController dgc = new DangPhiController(cw, dgv, dgvd,cb);
            DoanPhiController dc = new DoanPhiController(cw, dv, dvd,cb);
            GiaDinhController gdc = new GiaDinhController(gd, cbgd, gdd, cw,cb);
            GiangDayController gdyc = new GiangDayController(gdy, gvgd, gdyd, cw,cb);
            GiaoTrinhController gtc = new GiaoTrinhController(gt, gvgt, gtd, cw,cb);
            LuongController lc = new LuongController(l, ld, cw,cb);
            NghienCuuKhoaHocController nckhc = new NghienCuuKhoaHocController(cw, nckh, gvnckh, nckhd,cb);
            
            ChangeViewController cvwc = new ChangeViewController(cw, bbc, cbc, ctc, cdc, cvc, cdvc, dgc, dc, gdc, gdyc, gtc, lc, nckhc, s);
            
            cw.setVisible(true);
        }

    }

    private class getChangePassBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            CanBo cb = new CanBo();
            CanBoDAO cbd = new CanBoDAO();
            ChangePassViewController cpc = new ChangePassViewController(cpw, cb, cbd, s);
            cpw.setVisible(true);
        }

    }

    private  class getListBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            mw.setVisible(false);
            GiaDinh gd = new GiaDinh();
            GiangDay gdy = new GiangDay();
            CanBo cb = new CanBo();
            ChamThi ct = new ChamThi();
            NghienCuuKhoaHoc nckh = new NghienCuuKhoaHoc();
            BaiBaoTapChi bb = new BaiBaoTapChi();
            ListViewController lvc = new ListViewController(lw, cb, gd, gdy, ct, nckh, bb, s);
            lw.setVisible(true);
        }
    }

    private class getLogoutBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            mw.setVisible(false);
            
            CanBo cb = new CanBo();
            LoginViewController lgvc = new LoginViewController(lgw, cb);
            lgw.setVisible(true);
        }

    }

    private  class getPPBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ppw.setVisible(true);
            CanBo cb = new CanBo();
            Luong lg = new Luong();
            GiangDay gdy = new GiangDay();
            ChucDanh cd = new ChucDanh();
            ChucVu cv = new ChucVu();
            ChamThi ct = new ChamThi();
            LuongDAO ld = new LuongDAO();
            ChamThiDAO ctd = new ChamThiDAO();
            PhuPhiViewController ppv = new PhuPhiViewController(ppw, cb, lg, gdy, cd, cv, ct,ld,ctd, s);
            mw.setVisible(false);
        }
    }

    private class getSearchBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            csw.setVisible(true);
            CanBo cb = new CanBo();
            CanBoDAO cbd = new CanBoDAO();
            CanBoSearchViewController cbsv = new CanBoSearchViewController(csw, cb, cbd,s);
            mw.setVisible(false);
        }
    }
}
