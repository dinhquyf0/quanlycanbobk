/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Model.CanBo;
import Model.ChucVu;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dinhq
 */
public class ChucVuDAO {
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    ChucVu cv = new ChucVu();
    ArrayList<ChucVu> listcv = new ArrayList<>();
    
    public Vector loadTableChucVuCanhan(String id){
        listcv = cv.getByID(id);
        Vector data = new Vector();
        for(ChucVu cv : listcv){
            Vector row = new Vector();
            
            row.add(cv.getChucVu());
            row.add(cv.getThoiGianNhan());
            row.add(cv.getPhuCap_ChucVu());
            data.add(row);
        }
        return data;
    }
    
    public Vector loadTableChucVu(){
        listcv = cv.getALL();
        Vector data = new Vector();
        for(ChucVu cv : listcv){
            Vector row = new Vector();
            listcb = cb.getByID(cv.getMa_CB());
            row.add(cv.getStt());
            row.add(cv.getMa_CB());
            row.add(listcb.get(0).getHoVaTen());
            row.add(cv.getChucVu());
            row.add(cv.getThoiGianNhan());
            row.add(cv.getPhuCap_ChucVu());
            data.add(row);
        }
        return data;
    }
    
    public void AddChucVu(String Stt, String ma_canbo, String ChucVu,String ThoiGianNhan){
        
        cv.setStt(Stt);
        cv.setMa_CB(ma_canbo);
        cv.setChucVu(ChucVu);
        cv.setThoiGianNhan(ThoiGianNhan);
        
        if(Stt.length() != 0) {
            if (cv.AddData(cv)) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại .!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateChucVu(String Stt, String ma_canbo, String ChucVu,String ThoiGianNhan){
        
        cv.setStt(Stt);
        cv.setMa_CB(ma_canbo);
        cv.setChucVu(ChucVu);
        cv.setThoiGianNhan(ThoiGianNhan);
        
        if (cv.Update(cv)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại.!");
        }
    }
    
    public void DelChucVu(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listcv= cv.getALL();

            if (cv.DeleteData(listcv.get(row).getStt())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
}
