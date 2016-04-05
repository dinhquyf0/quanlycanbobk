/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Model.CanBo;
import Model.CanBo_GiaDinh;
import Model.GiaDinh;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dinhq
 */
public class GiaDinhDAO {
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    GiaDinh gd = new GiaDinh();
    ArrayList<GiaDinh> listgd = new ArrayList();
    
    CanBo_GiaDinh cbgd = new CanBo_GiaDinh();
    ArrayList<CanBo_GiaDinh> listcbgd = new ArrayList<>();
    
    
     public void BindingMaGD(JComboBox cbx){
        listgd = gd.getALL();
        for(GiaDinh gd : listgd){
            cbx.addItem(gd.getMa_GD());
        }
    }
    
    public Vector loadTableCanBo_GiaDinh(){
        listcbgd = cbgd.getALLCBGD();
        
        Vector data = new Vector();
        for(CanBo_GiaDinh cbgd : listcbgd){
            Vector row = new Vector();
            listcb = cb.getByIDCBGD(cbgd.getMa_CB());
            row.add(cbgd.getstt());
            row.add(cbgd.getMa_CB());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            
            row.add(cbgd.getMa_GD());
            data.add(row);
        }
        return data;
    }
    
    public Vector loadTableGiaDinh(){
        listgd = gd.getALL();
        Vector data = new Vector();
        for (GiaDinh gd : listgd){
            
            Vector row = new Vector();
            row.add(gd.getStt());
            row.add(gd.getMa_GD());
            row.add(gd.getHoVaTenCon());
            row.add(gd.getNamSinh());
            row.add(gd.getThanhTich());
            data.add(row);
        }
       return data;
    }
    
    public void AddCanBo_GiaDinh(String Stt, String Ma_CB, String Ma_GD){
        
        cbgd.setstt(Stt);
        cbgd.setMa_CB(Ma_CB);
        cbgd.setMa_GD(Ma_GD);
        if(Stt.length()!= 0){
            if(cbgd.AddDataCBGD(cbgd)){
                JOptionPane.showMessageDialog(null, "Thêm mới thành công. !");
            }else{
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateCanBo_GiaDinh(String Stt, String Ma_CB, String Ma_GD){
        
        cbgd.setstt(Stt);
        cbgd.setMa_CB(Ma_CB);
        cbgd.setMa_GD(Ma_GD);
        if(cbgd.UpdateCBGD(cbgd)){
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        }else{
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
        }
    }
    
    public void DelCanBo_GiaDinh(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listcbgd= cbgd.getALLCBGD();

            if (cbgd.DeleteDataCBGD(listcbgd.get(row).getstt())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
    
    public void AddGiaDinh(String Stt, String Ma_GD, String HoVaTenCon, 
                                String NamSinhCon, String ThanhTich){
        
        gd.setStt(Stt);
        gd.setMa_GD(Ma_GD);
        gd.setHoVaTenCon(HoVaTenCon);
        gd.setNamSinh(NamSinhCon);
        gd.setThanhTich(ThanhTich);
        
        if(Stt.length() != 0) {
            if (gd.AddData(gd)) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateGiaDinh(String Stt, String Ma_GD, String HoVaTenCon, 
                                    String NamSinhCon, String ThanhTich){
        
        gd.setStt(Stt);
        gd.setMa_GD(Ma_GD);
        gd.setHoVaTenCon(HoVaTenCon);
        gd.setNamSinh(NamSinhCon);
        gd.setThanhTich(ThanhTich);
        
       
        if (gd.Update(gd)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại.!");
        }
    }
        
    public void DelGiaDinh(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listgd = gd.getALL();

            if (gd.DeleteData(listgd.get(row).getStt())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
}
