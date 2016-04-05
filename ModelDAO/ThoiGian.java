/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import java.util.Calendar;
import javax.swing.JComboBox;

/**
 *
 * @author dinhq
 */
public class ThoiGian {
    
    public void BindingCBxNam(JComboBox Cbx_1,JComboBox Cbx_2, JComboBox Cbx_3, JComboBox Cbx_4,
                                JComboBox Cbx_5, JComboBox Cbx_6, JComboBox Cbx_7, JComboBox Cbx_8,
                                JComboBox Cbx_9, JComboBox Cbx_10, JComboBox Cbx_11, JComboBox Cbx_12, 
                                JComboBox Cbx_13, JComboBox Cbx_14, JComboBox Cbx_15){
        for(int years=Calendar.getInstance().get(Calendar.YEAR);years>=1950;years--){
            Cbx_1.addItem(years);
            Cbx_2.addItem(years);
            Cbx_3.addItem(years);
            Cbx_4.addItem(years);
            Cbx_5.addItem(years);
            Cbx_6.addItem(years);
            Cbx_7.addItem(years);
            Cbx_8.addItem(years);
            Cbx_9.addItem(years);
            Cbx_10.addItem(years);
            Cbx_11.addItem(years);
            Cbx_12.addItem(years);
            Cbx_13.addItem(years);
            Cbx_14.addItem(years);
            Cbx_15.addItem(years);
       }
    }
    
    public void BindingCBxThang(JComboBox Cbx_1,JComboBox Cbx_2, JComboBox Cbx_3, JComboBox Cbx_4,
                                JComboBox Cbx_5, JComboBox Cbx_6, JComboBox Cbx_7, JComboBox Cbx_8,
                                JComboBox Cbx_9, JComboBox Cbx_10, JComboBox Cbx_11, JComboBox Cbx_12){
        for(int month = 1;month <= 12;month++){
            Cbx_1.addItem(month);
            Cbx_2.addItem(month);
            Cbx_3.addItem(month);
            Cbx_4.addItem(month);
            Cbx_5.addItem(month);
            Cbx_6.addItem(month);
            Cbx_7.addItem(month);
            Cbx_8.addItem(month);
            Cbx_9.addItem(month);
            Cbx_10.addItem(month);
            Cbx_11.addItem(month);
            Cbx_12.addItem(month);
            
       }
    }
    
    public void BindingCBxNgay(JComboBox Cbx_1,JComboBox Cbx_2, JComboBox Cbx_3, JComboBox Cbx_4,
                                JComboBox Cbx_5, JComboBox Cbx_6, JComboBox Cbx_7, JComboBox Cbx_8,
                                JComboBox Cbx_9, JComboBox Cbx_10, JComboBox Cbx_11, JComboBox Cbx_12){
        for(int date = 1 ; date<=31;date++){
            Cbx_1.addItem(date);
            Cbx_2.addItem(date);
            Cbx_3.addItem(date);
            Cbx_4.addItem(date);
            Cbx_5.addItem(date);
            Cbx_6.addItem(date);
            Cbx_7.addItem(date);
            Cbx_8.addItem(date);
            Cbx_9.addItem(date);
            Cbx_10.addItem(date);
            Cbx_11.addItem(date);
            Cbx_12.addItem(date);
       }
    }
    
}
