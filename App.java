
import Controller.LoginViewController;
import Model.CanBo;
import View.LoginView;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DINHQUY
 */
public class App {
    CanBo cb = new CanBo();
    LoginView lgv = new LoginView();
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
            try {
                UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
                //</editor-fold>
            } catch (ParseException ex) {
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
    }
    
}



