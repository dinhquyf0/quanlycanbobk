/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author dinhq
 */
public class CheckEmpty {
        public boolean checkEmpty(JTextField tfField, String value, String field) {
        if(value.isEmpty()) {
            JOptionPane.showMessageDialog(null, "field: " + field + " could not be empty", "Empty field",  JOptionPane.ERROR_MESSAGE);
            tfField.requestFocus();
        }
        return true;
    }
}
