 
package Controller;
import Model.*;
import View.*;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaMauveMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

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
        this.lgv.CbxChangeThemeActionListener(new LoginViewController.ChangeThemeListener());
    }

    private class ChangeThemeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String select = lgv.jComboBox1.getSelectedItem().toString();
            
            switch(select) {
                case "Đen": {
                    
                    lgv.setVisible(false);
                    try {
                        UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
                        //</editor-fold>
                    } catch (ParseException ex) {
                        Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                }
                    /* Create and display the form */
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            CanBo cb = new CanBo();
                            LoginView lgv = new LoginView();
                            LoginViewController lgc = new LoginViewController(lgv, cb);
                            lgv.setVisible(true);
                        }
                    });
                    break;
                }
                case "Trắng": {
                lgv.setVisible(false);
                try {
                    UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
                } catch (ParseException ex) {
                    Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                }
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            CanBo cb = new CanBo();
                            LoginView lgv = new LoginView();
                            LoginViewController lgc = new LoginViewController(lgv, cb);
                            lgv.setVisible(true);
                        }
                    });
                break;
                }

                case "Hồng": {
                    lgv.setVisible(false);
                    try {
                        UIManager.setLookAndFeel(new SyntheticaMauveMetallicLookAndFeel());
                    } catch (ParseException ex) {
                        Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            CanBo cb = new CanBo();
                            LoginView lgv = new LoginView();
                            LoginViewController lgc = new LoginViewController(lgv, cb);
                            lgv.setVisible(true);
                        }
                    });
                    break;
                }

                case "Cam": {
                    lgv.setVisible(false);
                    try {
                        UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
                    } catch (ParseException ex) {
                        Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            CanBo cb = new CanBo();
                            LoginView lgv = new LoginView();
                            LoginViewController lgc = new LoginViewController(lgv, cb);
                            lgv.setVisible(true);
                        }
                    });
                    break;
                }
            }
            
        }
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
//                
//                final Browser browser = new Browser();
//                BrowserView browserView = new BrowserView(browser);
//
//                JFrame frame = new JFrame();
//                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                frame.add(browserView, BorderLayout.CENTER);
//                frame.setSize(284, 584);
//                frame.setLocation(1623, 431);
//                frame.setVisible(true);
//                browser.loadURL("http://phuong-chat.herokuapp.com/chat.html?name="+u+"&room=chat");

                }else {
                    JOptionPane.showMessageDialog(lgv, "Tên đăng nhập hoặc mật khẩu không đúng. Đề nghị nhập lại.!");
                
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    
   
    
}
