/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo_GiaDinh;
import Model.GiaDinh;
import ModelDAO.GiaDinhDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhq
 */
public class GiaDinhController extends CheckEmpty {
    GiaDinhDAO gdd = new GiaDinhDAO();
    
    public ChangeView cw;
    public GiaDinh gd;
    public CanBo_GiaDinh cbgd;
    
    ArrayList<GiaDinh> listgd = new ArrayList<>();
    ArrayList<CanBo_GiaDinh> listcbgd = new ArrayList<>();
    
    public GiaDinhController(GiaDinh gd, CanBo_GiaDinh cbgd, GiaDinhDAO gdd, ChangeView cw) {
        this.gd = gd;
        this.cbgd = cbgd;
        this.gdd = gdd;
        this.cw = cw;
        this.cw.AddGiaDinhBtnActionListener(new GiaDinhController.AddGiaDinhListener());
        this.cw.UpdateGiaDinhBtnActionListener(new GiaDinhController.UpdateGiaDinhListener());
        this.cw.DelGiaDinhBtnActionListener(new GiaDinhController.DelGiaDinhListener());
        BindingGiaDinh();
    }

    private void BindingGiaDinh(){
        cw.BindingGD(gdd.loadTableGiaDinh());
        cw.BindingCanBo_GiaDinh(gdd.loadTableCanBo_GiaDinh());
    }

    private  class DelGiaDinhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(cw.RBtn_CBGD.isSelected()){
                gdd.DelCanBo_GiaDinh(cw.CB_GD_TBL);
                cw.BindingGD(gdd.loadTableGiaDinh());
            }
            if(cw.RBtn_GD.isSelected()){
                gdd.DelGiaDinh(cw.GiaDinhTBL);
                cw.BindingCanBo_GiaDinh(gdd.loadTableCanBo_GiaDinh());
            }
           
        }
           
    }
    
 
    
    private  class UpdateGiaDinhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            listgd = gd.getALL();
            listcbgd = cbgd.getALLCBGD();
            
            int row1 = cw.GiaDinhTBL.getSelectedRow();
            int row2 = cw.CB_GD_TBL.getSelectedRow();
            
            String Stt = listgd.get(row1).getStt();
            String Ma_GD = cw.TxtMa_GD.getText();
            String HoVaTenCon = cw.TxtTenCon.getText();
            String NamSinhCon = cw.Cbx_NamSinh_Con.getSelectedItem().toString();
            String ThanhTichCon = cw.TxtThanhTichCon.getText();
           
            String stt = listcbgd.get(row2).getstt();
            String Ma_gd = cw.CB_Ma_GD.getSelectedItem().toString();
            String Ma_cb = cw.CB_MaCB_GDinh.getSelectedItem().toString();
            
            
            if(cw.RBtn_GD.isSelected()){
                gdd.UpdateGiaDinh(Stt, Ma_GD, HoVaTenCon, NamSinhCon, ThanhTichCon);
                cw.BindingGD(gdd.loadTableGiaDinh());
            }else{
                JOptionPane.showMessageDialog(null, "Đề nghị chọn bảng sẽ cập nhật");
            }

            if(cw.RBtn_CBGD.isSelected()){
                gdd.UpdateCanBo_GiaDinh(stt, Ma_cb, Ma_gd);
                cw.BindingCanBo_GiaDinh(gdd.loadTableCanBo_GiaDinh());
            }else{
                JOptionPane.showMessageDialog(null, "Đề nghị chọn bảng sẽ cập nhật");
            }
            
        }
    }

    private class AddGiaDinhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String Stt = cw.TxtStt_GD.getText();
            String Ma_GD = cw.TxtMa_GD.getText();
            String HoVaTenCon = cw.TxtSo.getText();
            String NamSinhCon = cw.Cbx_NamSinh_Con.getSelectedItem().toString();
            String ThanhTichCon = cw.TxtThanhTichCon.getText();
           
            String stt = cw.TxtStt_CBGD.getText();
            String Ma_gd = cw.CB_Ma_GD.getSelectedItem().toString();
            String Ma_cb = cw.CB_MaCB_GDinh.getSelectedItem().toString();           
            
            if(cw.RBtn_GD.isSelected()){
                if (!checkEmpty(cw.TxtStt_GD, Stt, "Số Thứ Tự")) {
                    return;
                }else {
                    gdd.AddGiaDinh(Stt, Ma_GD, HoVaTenCon, NamSinhCon, ThanhTichCon);
                    cw.BindingGD(gdd.loadTableGiaDinh());
                }
            }
            
            if(cw.RBtn_CBGD.isSelected()){
                if(!checkEmpty(cw.TxtStt_CBGD , stt, "Số thứ tự")){
                    return;
                }else{
                    gdd.AddCanBo_GiaDinh(Stt, Ma_cb, Ma_gd);
                    cw.BindingCanBo_GiaDinh(gdd.loadTableCanBo_GiaDinh());
                }
            }
        }
     
    }
}
