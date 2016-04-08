/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Model.CanBo;
import Model.Luong;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dinhq
 */
public class LuongDAO {
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    Luong l = new Luong();
    ArrayList<Luong> listl = new ArrayList<>();
    
    public Vector loadTableLuongMonth(ArrayList<Luong> listl){
        
        Vector data = new Vector();
        
        for(Luong l : listl){
            Vector row = new Vector();
            listcb =cb.getByID(l.getma_canbo());
            
            row.add(l.getStt());
            row.add(l.getma_canbo());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            row.add(l.getHeSoLuong());
            row.add(l.getThoiGianBatDau());
          
            data.add(row);
        }
        return data;
    }
    
    
    public Vector loadTableLuong(){
        listl = l.getALL();
        
        Vector data = new Vector();
        
        for(Luong l : listl){
            Vector row = new Vector();
            listcb =cb.getByID(l.getma_canbo());
            
            row.add(l.getStt());
            row.add(l.getma_canbo());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            row.add(l.getHeSoLuong());
            row.add(l.getThoiGianBatDau());
          
            data.add(row);
        }
        return data;
    }
    
    public void AddLuong(String Stt, String Ma_Cb, String HeSoluong, String ThoiGianBatDau){
        l.setStt(Stt);
        l.setma_canbo(Ma_Cb);
        l.setHeSoLuong(HeSoluong);
        l.setThoiGianBatDau(ThoiGianBatDau);
        if(Stt.length() != 0) {
            if (l.AddData(l)) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công.!");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateLuong(String Stt, String Ma_Cb, String HeSoluong, String ThoiGianBatDau){
        l.setStt(Stt);
        l.setma_canbo(Ma_Cb);
        l.setHeSoLuong(HeSoluong);
        l.setThoiGianBatDau(ThoiGianBatDau);
        if (l.Update(l)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại.!");
        }
    }
    
    public void DelLuong(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listl = l.getALL();

            if (l.DeleteData(listl.get(row).getStt())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
    
}
