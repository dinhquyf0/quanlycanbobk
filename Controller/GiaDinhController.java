/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import Model.CanBo_GiaDinh;
import Model.GiaDinh;
import ModelDAO.GiaDinhDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author dinhq
 */
public class GiaDinhController extends CheckEmpty {
    Insertlog isl = new Insertlog();
    GiaDinhDAO gdd = new GiaDinhDAO();
    public ChangeView cw;
    public GiaDinh gd;
    public CanBo_GiaDinh cbgd;
    private CanBo cb;
    
    ArrayList<GiaDinh> listgd = new ArrayList<>();
    ArrayList<CanBo_GiaDinh> listcbgd = new ArrayList<>();
    ArrayList<CanBo> listcbo = new ArrayList<>();
    
    public GiaDinhController(GiaDinh gd, CanBo_GiaDinh cbgd, GiaDinhDAO gdd, ChangeView cw, CanBo cb) {
        this.gd = gd;
        this.cbgd = cbgd;
        this.gdd = gdd;
        this.cw = cw;
        this.cb = cb;
        this.cw.AddGiaDinhBtnActionListener(new GiaDinhController.AddGiaDinhListener());
        this.cw.UpdateGiaDinhBtnActionListener(new GiaDinhController.UpdateGiaDinhListener());
        this.cw.DelGiaDinhBtnActionListener(new GiaDinhController.DelGiaDinhListener());
        this.cw.ClickTableCanBo_GiaDinh(new GiaDinhController.ClickTableCanBo_GiaDinhListener());
        this.cw.ClickTableGiaDinh(new GiaDinhController.ClickTableGaiDinhListener());
        BindingGiaDinh();
        BindingMaGD();
    }
    
    public void BindingMaGD(){
        listgd = gd.getALL();
        for(GiaDinh gdi : listgd){
            cw.CB_Ma_GD.addItem(gdi.getMa_GD());
        }
    }
    
    private void BindingGiaDinh(){
        cw.BindingGD(gdd.loadTableGiaDinh());
        cw.BindingCanBo_GiaDinh(gdd.loadTableCanBo_GiaDinh());
    }

    private class ClickTableCanBo_GiaDinhListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (cw.CB_GD_TBL.getSelectedRow() != -1) {
                int row = cw.CB_GD_TBL.getSelectedRow();

                listcbgd = cbgd.getALLCBGD();
                listcbo = cb.getByIDCBGD(listcbgd.get(row).getMa_CB());
                if (listcbo.size() > 0) {
                    cw.CB_MaCB_GDinh.setSelectedItem(listcbo.get(0).getMa_CB());
                } else {
                    cw.CB_MaCB_GDinh.setSelectedIndex(0);
                }
                cw.TxtStt_CBGD.setText(listcbgd.get(row).getstt());
                cw.CB_Ma_GD.setSelectedItem(listcbgd.get(row).getMa_GD());
                cw.TxtTen_CBGiaDinh.setText(listcbo.get(0).getHoVaTen());
            }
        
        }

    }

    private class ClickTableGaiDinhListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (cw.GiaDinhTBL.getSelectedRow() != -1) {
                int row = cw.GiaDinhTBL.getSelectedRow();

                listgd = gd.getALL();
                cw.TxtStt_GD.setText(listgd.get(row).getStt());
                cw.TxtMa_GD.setText(listgd.get(row).getMa_GD());
                cw.TxtTenCon.setText(listgd.get(row).getHoVaTenCon());
                cw.TxtThanhTichCon.setText(listgd.get(row).getThanhTich());
                cw.Cbx_NamSinh_Con.setSelectedItem(listgd.get(row).getNamSinh());
            }
        }

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
                isl.theQuery("INSERT INTO Log (NoiDung) value('Xóa thông tin gia đình của 1 cán bộ')");
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
            
            if(cw.RBtn_GD.isSelected()){
                String Stt = listgd.get(row1).getStt();
                String Ma_GD = cw.TxtMa_GD.getText();
                String HoVaTenCon = cw.TxtTenCon.getText();
                String NamSinhCon = cw.Cbx_NamSinh_Con.getSelectedItem().toString();
                String ThanhTichCon = cw.TxtThanhTichCon.getText();
                gdd.UpdateGiaDinh(Stt, Ma_GD, HoVaTenCon, NamSinhCon, ThanhTichCon);
                isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật thông tin gia đình 1 cán bộ')");
                cw.BindingGD(gdd.loadTableGiaDinh());
            }else{
                JOptionPane.showMessageDialog(null, "Đề nghị chọn bảng sẽ cập nhật");
            }

            if(cw.RBtn_CBGD.isSelected()){
                
                String stt = listcbgd.get(row2).getstt();
                String Ma_gd = cw.CB_Ma_GD.getSelectedItem().toString();
                String Ma_cb = cw.CB_MaCB_GDinh.getSelectedItem().toString();
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
                    isl.theQuery("INSERT INTO Log (NoiDung) value('Thêm thông tin gia đình 1 cán bộ')");
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
