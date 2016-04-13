/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Model.CanBo;
import Model.CanBoDangVien;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dinhq
 */
public class CanBoDangVienDAO {
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    CanBoDangVien dv = new CanBoDangVien();
    ArrayList<CanBoDangVien> listdv = new ArrayList<>();
    
    public Vector loadTableDangPhidadong(String nam,String thang){
        listdv = dv.getByTIME(nam, thang);
        Vector data = new Vector();
        for(CanBoDangVien dvv : listdv){
            listcb =cb.getByID(dvv.getma_canbo());
            Vector row = new Vector();
            row.add(dvv.getStt());
            row.add(dvv.getma_canbo());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }        
            row.add(dvv.getSoTienThu());
            row.add(dvv.getThoiGianDong());
            data.add(row);
        }
        return data;
    }
    
    public Vector loadTableDangPhiCanhan(String id){
        listdv = dv.getByID(id);
        Vector data = new Vector();
        for(CanBoDangVien cbdgv : listdv){
            Vector row = new Vector();
            row.add(cbdgv.getSoTienThu());
            row.add(cbdgv.getThoiGianDong());
            data.add(row);
        }
        return data;
    }
    
    public Vector loadTableDangPhi(){
        listdv = dv.getALL();
        Vector data = new Vector();
        
        for(CanBoDangVien dgv : listdv){
            
            Vector row = new Vector();
            listcb = cb.getByID(dgv.getma_canbo());
            row.add(dgv.getStt());
            row.add(dgv.getma_canbo());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            row.add(dgv.getSoTienThu());
            row.add(dgv.getThoiGianDong());
          
            data.add(row);
        }
        return data;
        
    }
    
    public void AddDangVien(String Stt, String ma_canbo, String SoTienThu,String ThoiGianDong){
        
        dv.setStt(Stt);
        dv.setma_canbo(ma_canbo);
        dv.setSoTienThu(SoTienThu);
        dv.setThoiGianDong(ThoiGianDong);
        
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
    
    public void UpdateDangVien(String Stt, String ma_canbo, String SoTienThu,String ThoiGianDong){
        
        dv.setStt(Stt);
        dv.setma_canbo(ma_canbo);
        dv.setSoTienThu(SoTienThu);
        dv.setThoiGianDong(ThoiGianDong);

        if (dv.Update(dv)) {
            JOptionPane.showMessageDialog(null, "Thêm mới thành công.!");
        } else {
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại .!");
        }
    } 
    
    public void DelCanBoDangVien(JTable table){
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
