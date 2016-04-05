/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dinhq
 */
public class ListViewController {
    String user;
    
    private Main m;
    private ListView lv;
    private CanBo cb;
    private GiaDinh gd;
    private ChamThi ct;
    private GiangDay gdy;
    
    public ListViewController(ListView lv,GiaDinh gd, GiangDay gdy, String s){
        this.user = s;
        this.lv = lv;
        this.gd = gd;
        this.gdy = gdy;
        this.lv.BackBtnActionListener(new ListViewController.BackBtnListener());
        this.lv.ChangeBtnActionListener(new ListViewController.ChangeBtnListener());
        
        Binding();
    }
    
    public void Binding(){
        lv.BindingDanhSachChamThi(gdy.getALL());
        lv.BindingQua(gd.getALL());
        lv.BindingThanhTichCao(gd.getALL());
    }
    
    private class BackBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            lv.setVisible(false);
            Main m = new Main();
            Log lg = new Log();
            MainViewController mvc = new MainViewController(m,lg, user);
            m.setVisible(true);
        }
    }

    private class ChangeBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
