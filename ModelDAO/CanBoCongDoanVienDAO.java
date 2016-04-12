/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Model.CanBo;
import Model.CanBoCongDoanVien;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dinhq
 */
public class CanBoCongDoanVienDAO {
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    CanBoCongDoanVien cdv = new CanBoCongDoanVien();
    ArrayList<CanBoCongDoanVien> listcdv = new ArrayList<>();
    
    
    
    public Vector loadTableCongDoanPhidadong(String nam, String thang){
        listcdv = cdv.getByTIME(nam, thang);
        Vector data = new Vector();
        for(CanBoCongDoanVien cbcdv : listcdv){
            listcb = cb.getByID(cbcdv.getma_canbo());
            Vector row = new Vector();
            row.add(cbcdv.getStt());
            row.add(cbcdv.getma_canbo());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            row.add(cbcdv.getSoTienDong());
            row.add(cbcdv.getThoiGianDong());
            data.add(row);
        }
        return data;
    }
    
    public Vector loadTableCongDoanPhiCanhan(String id){
        listcdv = cdv.getByID(id);
        Vector data = new Vector();
        for(CanBoCongDoanVien cbcdv : listcdv){
            Vector row = new Vector();
            row.add(cbcdv.getSoTienDong());
            row.add(cbcdv.getThoiGianDong());
            data.add(row);
        }
        return data;
    }
        
    public Vector loadTableCongDoanPhi(){
        listcdv = cdv.getALL();
        Vector data = new Vector();
        
        for(CanBoCongDoanVien cdv : listcdv){
            
            Vector row = new Vector();
            listcb =cb.getByID(cdv.getma_canbo());
            row.add(cdv.getStt());
            row.add(cdv.getma_canbo());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            row.add(cdv.getSoTienDong());
            row.add(cdv.getThoiGianDong());
          
            data.add(row);
        }
        return data;
    }
    
    
    
    public void AddCongDoanVien(String Stt, String ma_canbo, String SoTienDong, 
                                String ThoiGianDong){
        
        cdv.setStt(Stt);
        cdv.setma_canbo(ma_canbo);
        cdv.setSoTienDong(SoTienDong);
        cdv.setThoiGianDong(ThoiGianDong);
        
        if(Stt.length() != 0) {
            if (cdv.AddData(cdv)) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại .!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại. !");
        }
    }
    
    public void UpdateCongDoanVien(String Stt, String ma_canbo, String SoTienDong, 
                                String ThoiGianDong){
        
        cdv.setStt(Stt);
        cdv.setma_canbo(ma_canbo);
        cdv.setSoTienDong(SoTienDong);
        cdv.setThoiGianDong(ThoiGianDong);
        
        if (cdv.Update(cdv)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        }else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại .!");
        }
    }
    
    public void DelCanBo_CongDoanVien(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listcdv= cdv.getALL();

            if (cdv.DeleteData(listcdv.get(row).getStt())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
}
