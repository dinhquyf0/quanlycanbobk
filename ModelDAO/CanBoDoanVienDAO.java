/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Model.CanBo;
import Model.CanBoDoanVien;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dinhq
 */
public class CanBoDoanVienDAO {
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    CanBoDoanVien dv = new CanBoDoanVien();
    ArrayList<CanBoDoanVien> listdv = new ArrayList<>();
    
    
    public Vector loadTableDoanVien(){
        listdv = dv.getALL();
        Vector data = new Vector();
        
        for(CanBoDoanVien dv : listdv){
            
            Vector row = new Vector();
            listcb =cb.getByID(dv.getma_canbo());
            row.add(dv.getStt());
            row.add(dv.getma_canbo());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            row.add(dv.getSoTien());
            row.add(dv.getThoiGian());
          
            data.add(row);
        }
        return data;
    }
    
    public void AddDoanVien(String Stt, String ma_canbo, String SoTien,String ThoiGian){
        
        dv.setStt(Stt);
        dv.setma_canbo(ma_canbo);
        dv.setSoTien(SoTien);
        dv.setThoiGian(ThoiGian);
        
        if(Stt.length() != 0) {
            if (dv.AddData(dv)) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại .!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại. !");
        }
    } 
    
    public void UpdateDoanien(String Stt, String ma_canbo, String SoTien,String ThoiGian){
        
        dv.setStt(Stt);
        dv.setma_canbo(ma_canbo);
        dv.setSoTien(SoTien);
        dv.setThoiGian(ThoiGian);
        
        if (dv.Update(dv)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại .!");
        }
    } 
    
    public void DelCanBoDoanVien(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listdv= dv.getALL();

            if (dv.DeleteData(listdv.get(row).getStt())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
    
}
