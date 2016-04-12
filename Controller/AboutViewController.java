/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.AboutView;
import View.Main;
import Model.*;
import ModelDAO.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Calendar;

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
            ChucVu cv = new ChucVu();
            ChucDanh cd = new ChucDanh();
            Luong lg = new Luong();
            GiangDay gdy = new GiangDay();
            NghienCuuKhoaHoc nckh = new NghienCuuKhoaHoc();
            BaiBaoTapChi bb = new BaiBaoTapChi();
            ChamThi ct = new ChamThi();
            
            GiaDinhDAO gdd = new GiaDinhDAO();
            GiangDayDAO gdyd = new GiangDayDAO();
            NghienCuuKhoaHocDAO nckhd = new NghienCuuKhoaHocDAO();
            BaiBaoTapChiDAO bbd = new BaiBaoTapChiDAO();
            LuongDAO ld = new LuongDAO();
            CanBoCongDoanVienDAO cdvd = new CanBoCongDoanVienDAO();
            CanBoDangVienDAO dgvd = new CanBoDangVienDAO();
            CanBoDoanVienDAO dvd = new CanBoDoanVienDAO();
            GiaoTrinhDAO gtd = new GiaoTrinhDAO();
            ChamThiDAO ctd = new ChamThiDAO();
            ChucVuDAO cvd = new ChucVuDAO();
            ChucDanhDAO cdd = new ChucDanhDAO();
            
            
            if(user!=null){
                ArrayList<CanBo> listcb = cb.getByUser(user);
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
                    av.BindingBB(bbd.loadTableBaiBaoCaNhan(id));
                    av.BindingCD(cdd.loadTableChucDanhCanhan(id));
                    av.BindingCV(cvd.loadTableChucVuCanhan(id));
                    av.BindingChamThi(ctd.loadTableChamThiCanhan(id));
                    av.BindingCongDoanPhi(cdvd.loadTableCongDoanPhiCanhan(id));
                    av.BindingDangPhi(dgvd.loadTableDangPhiCanhan(id));
                    av.BindingGD(gdd.loadTableGiaDinhCanhan(id));
                    av.BindingGday(gdyd.loadTableGiangDayCanhan(id));
                    av.BindingGiaoTrinh(gtd.loadTableGiaoTrinhCanhan(id));
                    av.BindingLuong(ld.loadTableLuongCanhan(id));
                    av.BindingNCKH(nckhd.loadTableNCKHCanhan(id));
                    av.BindingDoanPhi(dvd.loadTableDoanPhiCanhan(id));
                    PhuPhiViewController ppc = new PhuPhiViewController(lg,cb,gdy);
                    double hsl = ppc.HeSoLuongtheonam(id,Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
                    double pccd = ppc.HeSoChucDanh(cd.getByIDCB(id));
                    double pccv = ppc.PhuCapChucVu(cv.getChucVuByTime(id));
                    double hstn = ppc.HeSoThamniem(cbo.getGioiTinh(), id);
                    double pcgd = ppc.HeSoGiangDay(id, Integer.toString(Calendar.getInstance().get(Calendar.MONTH)+1), Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
                    double lcb = 1500000;
                    double M1 = 700000;
                    double M2 = 600000;
                    double M3 = 700000;

                    int luong = (int) ((lcb*(hsl+pccd))+(M1+(pccv+hstn)*M2+M3));
                    int dangphi = (int) (((hsl+pccv+pcgd)*lcb)*(1/100d));
                    int doanphi = (int) ((hsl*lcb)*(1/100d));
                    int congdoanphi = (int) (((hsl+pcgd)*lcb)*(1/100d));

                    av.LBL_TienLuongThang.setText(Integer.toString(luong));
                    if(cbo.getDoanVien()==1){
                        av.LBL_DoanPhi.setText(Integer.toString(doanphi));
                    }else{
                        av.LBL_DoanPhi.setText("0");
                    }
                    if(cbo.getDangVien()==1){
                        av.LBL_DangPhi.setText(Integer.toString(dangphi));
                    }else{
                        av.LBL_DangPhi.setText("0");
                    }
                    if(cbo.getCongDoanVien()==1){
                        av.LBL_CongDoanPhi.setText(Integer.toString(congdoanphi));
                    }else{
                        av.LBL_CongDoanPhi.setText("0");
                    }
                    ArrayList<NghienCuuKhoaHoc> listnckh = nckh.getByIDCB(id);
                    int tiennckh=0;
                    for(NghienCuuKhoaHoc nnckh : listnckh){
                        int kinhphi = Integer.parseInt(nnckh.getKinhPhi());
                        tiennckh = tiennckh +kinhphi;
                    }
                    av.LBL_TienNCKH.setText(Integer.toString(tiennckh));
                    ArrayList<BaiBaoTapChi> listbb = bb.getByIDCB(id);
                    int tienbb=0;
                    for(BaiBaoTapChi bbt : listbb){
                        int issn = Integer.parseInt(bbt.getChiSo_ISSN());
                        int hesoif = Integer.parseInt(bbt.getHeSo_IF());
                        tienbb = tienbb +issn*hesoif;
                    }
                    av.LBL_TienBaiBao.setText(Integer.toString(tienbb));
                    ArrayList<GiangDay> listgdy = gdy.getByIDCB(id);
                    int tiengiangday=0;
                    for(GiangDay gday : listgdy){
                        int sogioday = Integer.parseInt(gday.getSoGioDay());
                        tiengiangday = tiengiangday + sogioday*60000;
                    }
                    av.LBL_TienGiangDay.setText(Integer.toString(tiengiangday));
                    ArrayList<ChamThi> listct = ct.getByIDCB(id);
                    int tienchamthi = 0;
                    for(ChamThi cthi : listct){
                        int sobaithi = Integer.parseInt(cthi.getSoBaiThi());
                        tienchamthi = tienchamthi + sobaithi*10000;
                    }
                    av.LBL_TienChamTHi.setText(Integer.toString(tienchamthi));
                }
            } else{
                JOptionPane.showMessageDialog(null, "Mã cán bộ sai hoặc không có dữ liệu.!");
                av.TxtcanboID.setFocusable(true);
            }
           
        
        }
    }

    private class BackBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Main m = new Main();
            Log lg = new Log();
            av.setVisible(false);
            MainViewController mvc = new MainViewController(m,lg, user);
            m.setVisible(true);
            
        }
    }

}
