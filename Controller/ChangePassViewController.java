/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CanBo;
import ModelDAO.CanBoDAO;
import View.ChangePassView;
import View.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author dinhq
 */
public class ChangePassViewController {
    private CanBo cb;
    private CanBoDAO cbd;
    private ChangePassView cpw;
    private Main m;
    String string;
    public ChangePassViewController(ChangePassView cpw,CanBo cb, CanBoDAO cbd, String user){
        string =user;
        this.cb = cb;
        this.cbd= cbd;
        this.cpw = cpw;
        this.cpw.ChangePassActionListener(new ChangePassViewController.ChangePassAction());
        this.cpw.ExitActionListener(new ChangePassViewController.ExitAction());
    }
    
    private class ChangePassAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
        String s = string;
        String oldpass = cpw.Txt_OldPass.getText();
        String newpass = cpw.Txt_NewPass.getText();
        String checknewpass = cpw.Txt_Check_NewPass.getText();
        
        ArrayList<CanBo> listcb = new ArrayList<>();
        
        listcb =cb.getByUser(s);
        for(CanBo cbo : listcb){
            String pass = cbo.getPassword();
            if(oldpass.equals(pass)){
                if(checknewpass.equals(newpass)){
                    cbo.setUserName(s);
                    cbo.setPassword(checknewpass);
                    
                    if(cbo.UpdatePass(cbo)){
                        JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thành công.!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thất bại.!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "mật khẩu mới không trùng. Nhập lại.!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "mật khẩu cũ không chính xác. Nhập lại!");
            }
        }
        
        }

    }

    private class ExitAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            cpw.setVisible(false);
            Main m = new Main();
            MainViewController mvc = new MainViewController(m, string);
            m.setVisible(true);
            
        }
    }
            
}
