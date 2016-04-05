 
package Controller;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author DINHQUY
 */
public class LoginViewController extends CheckEmpty {
    private CanBo cb;
    private LoginView lgv;
    
    String u,p;
    
    public LoginViewController(LoginView lgv,CanBo cb){
        this.cb = cb;
        this.lgv = lgv;
        
        this.lgv.LoginBtnListener(new LoginViewController.LoginBtnListener());
        this.lgv.GuestLoginActionListener(new LoginViewController.GuestLoginListener());
    }

    private class GuestLoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            lgv.setVisible(false);
            Main m = new Main();
            Log lg = new Log();
            MainViewController mc = new MainViewController(m, lg, "Khách");
            m.setVisible(true);
        }
    }
        
    public class LoginBtnListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
            
            u = lgv.getTfUser().getText();
            p = lgv.getStringPass();
            
            if(!checkEmpty(lgv.getTfUser(), u, "Tên Đăng Nhập")&&!checkEmpty(lgv.getTfPass(), p, "Password")){
                return;
            }
            else if(cb.getLogin(u, p)){
                lgv.setVisible(false);
                Main m = new Main();
                Log lg = new Log();
                MainViewController mc = new MainViewController(m, lg, u);
                m.setVisible(true);
                    
                }else {
                    JOptionPane.showMessageDialog(lgv, "Tên đăng nhập hoặc mật khẩu không đúng. Đề nghị nhập lại.!");
                
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    
   
    
}
