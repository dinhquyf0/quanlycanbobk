/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ChamThi;
import ModelDAO.ChamThiDAO;
import View.ChangeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author DINHQUY
 */
public class ChamThiController extends CheckEmpty {
    Insertlog isl = new Insertlog();
    ChamThiDAO ctd = new ChamThiDAO();  
    public ChangeView cw;
    public ChamThi ct;
    ArrayList<ChamThi> listct = new ArrayList<>();
    
    public ChamThiController(ChangeView cw, ChamThi ct, ChamThiDAO ctd) {
        this.ct = ct;
        this.ctd = ctd;
        this.cw = cw;
        this.cw.AddChamThiBtnActionListener(new ChamThiController.AddChamThiListener());
        this.cw.UpdateChamThiBtnActionListener(new ChamThiController.UpdateChamThiListener());
        this.cw.DelChamThiBtnActionListener(new ChamThiController.DelChamThiListener());
        BindingChamThi();
    }

    private void BindingChamThi(){
        cw.BindingChamThi(ctd.loadTableChamThi());
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
