/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.*;
import ModelDAO.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
/**
 *
 * @author dinhq
 */
public class PrintChangeViewController {
    private PrintAdminView pav;
    private CanBoDAO cb;
    private BaiBaoTapChiDAO bb;
    private CanBoCongDoanVienDAO cdv;
    private CanBoDangVienDAO dgv;
    private CanBoDoanVienDAO dv;
    private ChucVuDAO cv;
    private ChucDanhDAO cd;
    private NghienCuuKhoaHocDAO nckh;
    private GiaDinhDAO gd;
    private GiangDayDAO gdy;
    private GiaoTrinhDAO gt;
    private ChamThiDAO ct;
    private LuongDAO l;
    
    
    public PrintChangeViewController(PrintAdminView pav, CanBoDAO cb, BaiBaoTapChiDAO bb, CanBoCongDoanVienDAO cdv, CanBoDangVienDAO dgv, CanBoDoanVienDAO dv,
                                    ChucVuDAO cv, ChucDanhDAO cd, NghienCuuKhoaHocDAO nckh, GiaDinhDAO gd, GiangDayDAO gdy, GiaoTrinhDAO gt, ChamThiDAO ct, LuongDAO l){
        this.pav = pav;
        this.cb = cb;
        this.bb = bb;
        this.cdv = cdv;
        this.dgv = dgv;
        this.dv = dv;
        this.cv = cv;
        this.cd = cd;
        this.nckh = nckh;
        this.gd = gd;
        this.gdy = gdy;
        this.gt = gt;
        this.ct = ct;
        this.l = l;
        this.pav.PrintActionListener(new PrintChangeViewController.PrintListener());
        this.pav.CBxTableActionListener(new PrintChangeViewController.CbxTableListener());
    }
    
    public void BindingCanBo(){
        pav.BindingCanBo(cb.loadTableCanBo());
    }
    
    public void BindingGD(){
        pav.BindingGD(gd.loadTableGiaDinh());
    }
    
    public void BindingLuong(){
        pav.BindingLuong(l.loadTableLuong());
    }
    
    public void BindingDangPhi(){
        pav.BindingDangPhi(dgv.loadTableDangPhi());
    }
    public void BindingDoanPhi(){
        pav.BindingDoanPhi(dv.loadTableDoanVien());
    }
    
    public void BindingCongDoanPhi(){
        pav.BindingCongDoanPhi(cdv.loadTableCongDoanPhi());
    }
    public void BindingChucVu(){
        pav.BindingChucVu(cv.loadTableChucVu());
    }
    public void BindingChucDanh(){
        pav.BindingChucDanh(cd.loadTableChucDanh());
    }
    public void BindingBB(){
        pav.BindingBB(bb.loadTabelBaiBao_TapChi());
    }
    public void BindingNCKH(){
        pav.BindingNCKH(nckh.loadTableNCKH());
    }
    public void BindingGiaoTrinh(){
        pav.BindingGiaoTrinh(gt.loadTableGiaoTrinh());
    }
    public void BindingChamThi(){
        pav.BindingChamThi(ct.loadTableChamThi());
    }
    
    
    
    private class PrintListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }

    private class CbxTableListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            pav.LB_TenBang.setText(pav.Cbx_bang.getSelectedItem().toString());
            String item = pav.Cbx_bang.getSelectedItem().toString();
            switch(item){
                case("Cán Bộ"):{
                    BindingCanBo();
                    break;
                }
                case("Gia Đình"):{
                    BindingGD();
                    break;
                }
                case("Lương"):{
                    BindingLuong();
                    break;
                }
                case("Đảng Phí"):{
                    BindingDangPhi();
                    break;
                }
                case("Đoàn Phí"):{
                    BindingDoanPhi();
                    break;
                }
                case("Công Đoàn Phí"):{
                    BindingCongDoanPhi();
                    break;
                }
                case("Chức Vụ"):{
                    BindingChucVu();
                    break;
                }
                case("Chức Danh"):{
                    BindingChucDanh();
                    break;
                }
                case("Nghiên Cứu Khoa Học"):{
                    BindingNCKH();
                    break;
                }
                case("Bài Báo - Tạp Chí"):{
                    BindingBB();
                    break;
                }
                case("Giáo trình"):{
                    BindingGiaoTrinh();
                    break;
                }
                case("Chấm Thi"):{
                    BindingChamThi();
                    break;
                }
        }
        }
    }
    
}
