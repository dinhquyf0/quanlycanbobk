/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import Model.ChamThi;
import ModelDAO.ChamThiDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author DINHQUY
 */
public class ChamThiController extends CheckEmpty {
    Insertlog isl = new Insertlog();
    ChamThiDAO ctd = new ChamThiDAO();  
    public ChangeView cw;
    public ChamThi ct;
    private CanBo cb;
    ArrayList<ChamThi> listct = new ArrayList<>();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    public ChamThiController(ChangeView cw, ChamThi ct, ChamThiDAO ctd, CanBo cb) {
        this.ct = ct;
        this.ctd = ctd;
        this.cw = cw;
        this.cb = cb;
        this.cw.AddChamThiBtnActionListener(new ChamThiController.AddChamThiListener());
        this.cw.UpdateChamThiBtnActionListener(new ChamThiController.UpdateChamThiListener());
        this.cw.DelChamThiBtnActionListener(new ChamThiController.DelChamThiListener());
        this.cw.ClickTableChamThi(new ChamThiController.ClickTableListener());
        BindingChamThi();
    }

    private void BindingChamThi(){
        cw.BindingChamThi(ctd.loadTableChamThi());
    }

    private class ClickTableListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (cw.Chamthi_TBL.getSelectedRow() != -1) {
            int row = cw.Chamthi_TBL.getSelectedRow();

            listct = ct.getALL();
            listcb = cb.getByID(listct.get(row).getma_canbo());
            if (listcb.size() > 0) {
                cw.CB_MaCB_ChamThi.setSelectedItem(listcb.get(0).getMa_CB());
            } else {
                cw.CB_MaCB_ChamThi.setSelectedIndex(0);
            }
            cw.TxtMa_ChamThi.setText(listct.get(row).getMa_ChamThi());
            cw.TxtMa_MH_ChamThi.setText(listct.get(row).getMa_MH());
            cw.TxtMa_Lop.setText(listct.get(row).getMa_lop());
            
            cw.TxtSoBaiThi.setText(listct.get(row).getSoBaiThi());
            cw.TxtTen_CB_ChamThi.setText(listcb.get(0).getHoVaTen());
            String nam = listct.get(row).getNgayNop().substring(0,4);
            String thang = listct.get(row).getNgayNop().substring(5,7);
            String ngay = listct.get(row).getNgayNop().substring(8,10);
            cw.Cbx_Nam_ChamThi.setSelectedItem(nam);
            cw.Cbx_Thang_ChamThi.setSelectedItem(thang);
            cw.Cbx_Ngay_ChamThi.setSelectedItem(ngay);
        }
        
        }

    }

    private  class DelChamThiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ctd.DelChamThi(cw.Chamthi_TBL);
            isl.theQuery("INSERT INTO Log (NoiDung) value('xóa 1 thông tin chấm thi')");
            BindingChamThi();
        }
    }
    
 
    
    private  class UpdateChamThiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            listct = ct.getALL();
            int row = cw.Chamthi_TBL.getSelectedRow();
            String Ma_CT = listct.get(row).getMa_ChamThi();
            String Ma_Lop = cw.TxtMa_Lop.getText();
            String Ma_CB = cw.CB_MaCB_ChamThi.getSelectedItem().toString();
            String Ma_MH = cw.TxtMa_MH_ChamThi.getText();
            String NgayNop = cw.Cbx_Nam_ChamThi.getSelectedItem().toString()+"-"
                                +cw.Cbx_Thang_ChamThi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_ChamThi.getSelectedItem().toString();
            String SoBaiThi = cw.TxtSoBaiThi.getText();
            
            ctd.UpdateChamThi(Ma_CT, Ma_Lop, Ma_CB, Ma_MH, NgayNop, SoBaiThi);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Cập nhật thông tin chấm thi')");
            BindingChamThi();
        }
    }

    private class AddChamThiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String Ma_CT = cw.TxtMa_ChamThi.getText();
            String Ma_Lop = cw.TxtMa_Lop.getText();
            String Ma_CB = cw.CB_MaCB_ChamThi.getSelectedItem().toString();
            String Ma_MH = cw.TxtMa_MH_ChamThi.getText();
            String NgayNop = cw.Cbx_Nam_ChamThi.getSelectedItem().toString()+"-"
                                +cw.Cbx_Thang_ChamThi.getSelectedItem().toString()+"-"
                                    +cw.Cbx_Ngay_ChamThi.getSelectedItem().toString();
            String SoBaiThi = cw.TxtSoBaiThi.getText();
            if(!checkEmpty(cw.TxtMa_ChamThi,Ma_CT, "Mã Chấm Thi")){
            ctd.AddChamThi(Ma_CT, Ma_Lop, Ma_CB, Ma_MH, NgayNop, SoBaiThi);
            isl.theQuery("INSERT INTO Log (NoiDung) value('Thêm mới 1 thông tin chấm thi')");
            BindingChamThi();
            }
        }
     
    }
}
