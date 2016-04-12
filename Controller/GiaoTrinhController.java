/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import Model.GiangVien_GiaoTrinh;
import Model.GiaoTrinh;
import ModelDAO.GiaoTrinhDAO;
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
public class GiaoTrinhController extends CheckEmpty {
    Insertlog isl = new Insertlog();
    GiaoTrinhDAO gtd = new GiaoTrinhDAO();
    public ChangeView cw;
    public GiaoTrinh gt;
    public GiangVien_GiaoTrinh gvgt;
    private CanBo cb;
    
    ArrayList<GiaoTrinh> listgt = new ArrayList<>();
    ArrayList<GiangVien_GiaoTrinh> listgvgt = new ArrayList<>();
    ArrayList<CanBo> listcbo = new ArrayList<>();
    
    public GiaoTrinhController(GiaoTrinh gt, GiangVien_GiaoTrinh gvgt, GiaoTrinhDAO gtd, ChangeView cw, CanBo cb) {
        this.gt = gt;
        this.gvgt = gvgt;
        this.gtd = gtd;
        this.cw = cw;
        this.cb = cb;
        this.cw.AddGiaoTrinhBtnActionListener(new GiaoTrinhController.AddGiaoTrinhListener());
        this.cw.UpdateGiaoTrinhBtnActionListener(new GiaoTrinhController.UpdateGiaoTrinhListener());
        this.cw.DelGiaoTrinhBtnActionListener(new GiaoTrinhController.DelGiaoTrinhListener());
        this.cw.ClickTableCanBo_GiaoTrinh(new GiaoTrinhController.ClickTableCanBo_GiaoTrinhListener());
        this.cw.ClickTableGiaoTrinh(new GiaoTrinhController.ClickTableGiaoTrinhListener());
        BindinhGiaoTring();
        cw.BindingMaGT(gt.getALL());
    }

    private void BindinhGiaoTring(){
        cw.BindingGiangVien_GT(gtd.loadTableCanBo_GiaoTrinh());
        cw.BindingGiaoTrinh(gtd.loadTableGiaoTrinh());
    }

    private class ClickTableCanBo_GiaoTrinhListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (cw.CB_GiaoTrinh_TBL.getSelectedRow() != -1) {
            int row = cw.CB_GiaoTrinh_TBL.getSelectedRow();

            listgvgt = gvgt.getALLGVGT();
            listcbo = cb.getByID(listgvgt.get(row).getMa_CB());
            if (listcbo.size() > 0) {
                cw.CB_MaCB_GiaoTrinh.setSelectedItem(listcbo.get(0).getMa_CB());
            } else {
                cw.CB_MaCB_GiaoTrinh.setSelectedIndex(0);
            }
            cw.Txt_Stt_CBGTrinh.setText(listgvgt.get(row).getStt());
            cw.CB_Ma_GTrinh.setSelectedItem(listgvgt.get(row).getMa_GT());
            cw.Txt_TenCB_GTrinh.setText(listcbo.get(0).getHoVaTen());
        }
        }

    }

    private class ClickTableGiaoTrinhListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (cw.GiaoTrinh_TBL.getSelectedRow() != -1) {
            int row = cw.GiaoTrinh_TBL.getSelectedRow();
            listgt = gt.getALL();
            
            cw.TxtMa_GT.setText(listgt.get(row).getMa_GT());
            cw.TxtTenGiaoTrinh.setText(listgt.get(row).getTenGiaoTrinh());
            cw.TxtTenTacGia.setText(listgt.get(row).getTenTacGia());
            cw.TxtNhaXuatBan.setText(listgt.get(row).getNhaXuatBan());
            cw.Cbx_Nam_GiaoTrinh.setSelectedItem(listgt.get(row).getNamXuatBan());
        }
        
        }
    }

    private class DelGiaoTrinhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(cw.RBtn_GiaoTrinh.isSelected()==false && cw.RBtn_CB_GTrinh.isSelected()==false){
                JOptionPane.showMessageDialog(cw, "Đề nghị chọn bảng để thực hiện thao tác này");
            }
            
            if(cw.RBtn_CB_GDay.isSelected()){
                gtd.DelGiangVien_GiaoTrinh(cw.CB_GiaoTrinh_TBL);
                cw.BindingGiangVien_GT(gtd.loadTableCanBo_GiaoTrinh());
            }
            if(cw.RBtn_GiaoTrinh.isSelected()){
                gtd.DelGiaoTrinh(cw.GiaoTrinh_TBL);
                isl.theQuery("INSERT INTO Log (NoiDung) value('Xóa thông tin của 1 giáo trình')");
                cw.BindingGiaoTrinh(gtd.loadTableGiaoTrinh());
            }
           
        }
           
    }
    
 
    
    private  class UpdateGiaoTrinhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            listgt = gt.getALL();
            listgvgt = gvgt.getALLGVGT();
            
            int row1 = cw.GiaoTrinh_TBL.getSelectedRow();
            int row2 = cw.CB_GiaoTrinh_TBL.getSelectedRow();
            
            if(cw.RBtn_GiaoTrinh.isSelected()==false && cw.RBtn_CB_GTrinh.isSelected()==false){
                JOptionPane.showMessageDialog(cw, "Đề nghị chọn bảng để thực hiện thao tác này");
            }
            
            if(cw.RBtn_GiaoTrinh.isSelected()){
                String Ma_GT = listgt.get(row1).getMa_GT();
                String TenGiaoTrinh = cw.TxtTenGiaoTrinh.getText();
                String TenTacGia = cw.TxtTenTacGia.getText();
                String NamXuatBan = cw.Cbx_Nam_GiaoTrinh.getSelectedItem().toString();
                String NhaXuatBan = cw.TxtNhaXuatBan.getText();
                gtd.UpdateGiaoTrinh(Ma_GT, TenGiaoTrinh, TenTacGia, NamXuatBan, NhaXuatBan);
                isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật thông tin giáo trình của 1 giáo viên')");
                cw.BindingGiaoTrinh(gtd.loadTableGiaoTrinh());
            }
            if(cw.RBtn_CB_GTrinh.isSelected()){
                String stt = listgvgt.get(row2).getStt();
                String Ma_gt = cw.CB_Ma_GTrinh.getSelectedItem().toString();
                String Ma_cb = cw.CB_MaCB_GiaoTrinh.getSelectedItem().toString();
                gtd.UpdateGiangVien_GiaoTrinh(stt, Ma_cb, Ma_gt);
                cw.BindingGiangVien_GT(gtd.loadTableCanBo_GiaoTrinh());
            }
            
        }
    }

    private class AddGiaoTrinhListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String Ma_GT = cw.TxtMa_GT.getText();
            String TenGiaoTrinh = cw.TxtTenGiaoTrinh.getText();
            String TenTacGia = cw.TxtTenTacGia.getText();
            String NamXuatBan = cw.Cbx_Nam_GiaoTrinh.getSelectedItem().toString();
            String NhaXuatBan = cw.TxtNhaXuatBan.getText();
            
            String stt = cw.Txt_Stt_CBGTrinh.getText();
            String Ma_gt = cw.CB_Ma_GTrinh.getSelectedItem().toString();
            String Ma_cb = cw.CB_MaCB_GiaoTrinh.getSelectedItem().toString();
            
            if(cw.RBtn_GiaoTrinh.isSelected()==false && cw.RBtn_CB_GTrinh.isSelected()==false){
                JOptionPane.showMessageDialog(cw, "Đề nghị chọn bảng để thực hiện thao tác này");
            }
            
            if(cw.RBtn_GiaoTrinh.isSelected()){
                if (!checkEmpty(cw.TxtMa_GT, Ma_GT, "Mã Giáo Trình")) {
                    return;
                }else {
                    gtd.AddGiaoTrinh(Ma_GT, TenGiaoTrinh, TenTacGia, NamXuatBan, NhaXuatBan);
                    isl.theQuery("INSERT INTO Log (NoiDung) value('Thêm thông tin giáo trình của 1 giảng viên')");
                    cw.BindingGiaoTrinh(gtd.loadTableGiaoTrinh());
                }
            }
            
            if(cw.RBtn_CB_GTrinh.isSelected()){
                if(!checkEmpty(cw.Txt_Stt_CBGTrinh , stt, "Số thứ tự")){
                    return;
                }else{
                    gtd.AddGiangVien_GiaoTrinh(stt, Ma_cb, Ma_gt);
                    cw.BindingGiangVien_GT(gtd.loadTableCanBo_GiaoTrinh());
                }
            }
            
        }
     
    }
}
