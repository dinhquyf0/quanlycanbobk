/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Model.CanBo;
import Model.ChucDanh;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dinhq
 */
public class ChucDanhDAO {
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    ChucDanh cd = new ChucDanh();
    ArrayList<ChucDanh> listcd = new ArrayList<>();
    
    public Vector loadTableChucDanh(){
        listcd = cd.getALL();
        Vector data = new Vector();
        for(ChucDanh cd : listcd){
            Vector row = new Vector();
            listcb = cb.getByID(cd.getMa_CB());
            row.add(cd.getStt());
            row.add(cd.getMa_CB());
            row.add(listcb.get(0).getHoVaTen());
            row.add(cd.getChucDanh());
            row.add(cd.getThoiGianNhan());
            
            data.add(row);
        }
       return data;
    }
    
    public void AddChucDanh(String Stt, String ma_canbo, String ChucDanh,String ThoiGianNhan){
        
        cd.setStt(Stt);
        cd.setMa_CB(ma_canbo);
        cd.setChucDanh(ChucDanh);
        cd.setThoiGianNhan(ThoiGianNhan);
        
        if(Stt.length() != 0) {
            if (cd.AddData(cd)) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại .!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateChucDanh(String Stt, String ma_canbo, String ChucDanh,String ThoiGianNhan){
        
        cd.setStt(Stt);
        cd.setMa_CB(ma_canbo);
        cd.setChucDanh(ChucDanh);
        cd.setThoiGianNhan(ThoiGianNhan);
        
        if (cd.Update(cd)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại.!");
        }
    }
    
    public void DelChucDanh(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listcd= cd.getALL();

            if (cd.DeleteData(listcd.get(row).getStt())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
    
}
