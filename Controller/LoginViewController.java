 
package Controller;
import Model.*;
import ModelDAO.*;
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
           
    }
        
    public class LoginBtnListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
            
            u = lgv.getTfUser().getText();
            p = lgv.getStringPass();
//                System.out.println(u+"\n" + p);
                
            if(!checkEmpty(lgv.getTfUser(), u, "Tên Đăng Nhập")&&!checkEmpty(lgv.getTfPass(), p, "Password")){
                return;
            }
            else if(cb.getLogin(u, p)){
                lgv.setVisible(false);
                Main m = new Main();
                
                
                MainViewController mc = new MainViewController(m, u);
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
