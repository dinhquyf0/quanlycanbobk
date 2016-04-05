/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.AboutView;
import View.Main;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhq
 */
public class AboutViewController {
    private CanBo cb;
    private AboutView av;
    private Main m;
    String user;
    
    public AboutViewController(AboutView av, CanBo cb, String s){
        this.av = av;
        this.cb = cb;
        user = s;
        this.av.GetBtnActionListener(new AboutViewController.GetDataListener());
        this.av.PrintBtnActionListener(new AboutViewController.PrintActionListener());
        this.av.BackBtnActionListener(new AboutViewController.BackBtnActionListener());
        av.TxtcanboID.setText(s);
        if(s.equals("admin")){
            av.TxtcanboID.setEditable(true);
        }else{
            av.TxtcanboID.setEditable(false);
        }
    }

    private class GetDataListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            CanBo cb = new CanBo();
            ArrayList<CanBo> listcb = new ArrayList<>();
            GiaDinh gd = new GiaDinh();
            GiangDay gdy = new GiangDay();
            NghienCuuKhoaHoc nckh = new NghienCuuKhoaHoc();
            BaiBaoTapChi bb = new BaiBaoTapChi();
            Luong l = new Luong();
            CanBoCongDoanVien cdv = new CanBoCongDoanVien();
            CanBoDangVien dgv = new CanBoDangVien();
            CanBoDoanVien dv = new CanBoDoanVien();
            GiaoTrinh gt = new GiaoTrinh();
            ChamThi ct = new ChamThi();
            ChucVu cv = new ChucVu();
            ChucDanh cd = new ChucDanh();
            
            if(user!=null){
            listcb = cb.getByUser(user);
            for(CanBo cbo : listcb){
                av.TxtcanboID.setText(cbo.getMa_CB());
                String id = cbo.getMa_CB();
                av.TxtTenDangNhap.setText(cbo.getUserName());
                av.TxtHoVaTen.setText(cbo.getHoVaTen());
                av.TxtPassword.setText(cbo.getPassword());
                av.TxtNgaySinh.setText(cbo.getNgaySinh());
                av.TxtGioiTinh.setText(cbo.getGioiTinh());
                av.TxtNoiCongTac.setText(cbo.getNoiCongTac());
                av.TxtThoiGianCongTac.setText(cbo.getThoiGianBDCT());
                av.TxtTrinhDo.setText(cbo.getTrinhDo());
                av.TxtMaSoThue.setText(cbo.getMaSoThue());
                av.TxtSoTaiKhoan.setText(cbo.getSoTaiKhoan());
                av.TxtDiaChi.setText(cbo.getDiaChi());
                av.TxtSoDienThoai.setText(cbo.getSoDienThoai());
                av.TxtEmail.setText(cbo.getEmail());
                av.TxtThanhTich.setText(cbo.getThanhTich());
                av.TxtThongTinKhac.setText(cbo.getThongTinKhac());
                av.BindingBB(bb.getByID(id));
                av.BindingCD(cd.getByID(id));
                av.BindingCV(cv.getByID(id));
                av.BindingChamThi(ct.getByIDCB(id));
                av.BindingCongDoanPhi(cdv.getByID(id));
                av.BindingDangPhi(dgv.getByID(id));
                av.BindingGD(gd.getByID(id));
                av.BindingGday(gdy.getByIDCB(id));
                av.BindingGiaoTrinh(gt.getByIDCB(id));
                av.BindingLuong(l.getByID(id));
                av.BindingNCKH(nckh.getByID(id));
                av.BindingDoanPhi(dv.getByIDCB(id));
                
                }
            } else{
                JOptionPane.showMessageDialog(null, "Mã cán bộ sai hoặc không có dữ liệu.!");
                av.TxtcanboID.setFocusable(true);
            }
           
        
        }
    }

    private class PrintActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
    }

    private class BackBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Main m = new Main();
            av.setVisible(false);
            MainViewController mvc = new MainViewController(m, user);
            m.setVisible(true);
            
        }
    }

}
