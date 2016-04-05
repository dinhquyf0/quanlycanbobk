/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ModelDAO.BaiBaoTapChiDAO;
import ModelDAO.CanBoCongDoanVienDAO;
import ModelDAO.CanBoDAO;
import ModelDAO.CanBoDangVienDAO;
import ModelDAO.CanBoDoanVienDAO;
import ModelDAO.ChamThiDAO;
import ModelDAO.ChucDanhDAO;
import ModelDAO.ChucVuDAO;
import ModelDAO.GiaDinhDAO;
import ModelDAO.GiangDayDAO;
import ModelDAO.GiaoTrinhDAO;
import ModelDAO.LuongDAO;
import ModelDAO.NghienCuuKhoaHocDAO;
import View.ChangeView;
import View.Main;
import View.PrintAdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
       

/**
 *
 * @author dinhq
 */
public class ChangeViewController {
    
    String user;
    private ChangeView cw;
    private BaiBaoTapChiController bbc;
    private CanBoController cbc;
    private ChamThiController ctc;
    private ChucDanhController cdc;
    private ChucVuController cvc;
    private CongDoanVienController cdvc;
    private DangPhiController dgc;
    private DoanPhiController dc;
    private GiaDinhController gdc;
    private GiangDayController gdyc;
    private GiaoTrinhController gtc;
    private LuongController lc;
    private NghienCuuKhoaHocController nckhc;
    
    public ChangeViewController(ChangeView cw, BaiBaoTapChiController bbc, CanBoController cbc, ChamThiController ctc,
                                ChucDanhController cdc, ChucVuController cvc, CongDoanVienController cdvc,
                                DangPhiController dgc, DoanPhiController dc, GiaDinhController gdc, 
                                GiangDayController gdyc, GiaoTrinhController gtc, LuongController lc, NghienCuuKhoaHocController nckhc, 
                                String user){
        this.cw = cw;
        this.bbc = bbc;
        this.cbc = cbc;
        this.ctc = ctc;
        this.cdc = cdc;
        this.cvc = cvc;
        this.cdvc = cdvc;
        this.dgc = dgc;
        this.dc = dc;
        this.gdc = gdc;
        this.gdyc = gdyc;
        this.gtc = gtc;
        this.lc = lc;
        this.nckhc = nckhc;
        this.user = user;
        this.cw.BackBtnActionListener(new ChangeViewController.BackBtnActionListener());
        this.cw.PrintBtnActionListener(new ChangeViewController.PrintActionListener());
    }

    private class PrintActionListener implements ActionListener {

        public PrintActionListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            PrintAdminView pav = new PrintAdminView();
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
            PrintChangeViewController pcvc = new PrintChangeViewController(pav, cbd, bbd, cdvd, dgvd, dvd, cvd, cdd, nckhd, gdd, gdyd, gtd, ctd, ld);
            pav.setVisible(true);
        }
    }

    private class BackBtnActionListener implements ActionListener {

        public BackBtnActionListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            cw.setVisible(false);
            Main m = new Main();
            MainViewController mvc = new MainViewController(m, user);
            m.setVisible(true);
        }
    }
}
