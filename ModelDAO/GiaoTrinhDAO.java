/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Model.CanBo;
import Model.GiangVien_GiaoTrinh;
import Model.GiaoTrinh;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dinhq
 */
public class GiaoTrinhDAO {
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    GiangVien_GiaoTrinh gvgt = new GiangVien_GiaoTrinh();
    ArrayList<GiangVien_GiaoTrinh> listgvgt = new ArrayList<>();
    
    GiaoTrinh gt = new GiaoTrinh();
    ArrayList<GiaoTrinh> listgt = new ArrayList<>();
    
    
    public void BindingMaGT(JComboBox cbx){
        listgt = gt.getALL();
        for(GiaoTrinh gt : listgt){
            cbx.addItem(gt.getMa_GT());
        }
    }
    
    public Vector loadTableGiaoTrinhCanhan(String id){
        listgt = gt.getByIDCB(id);
        Vector data = new Vector();
        
        for(GiaoTrinh gt : listgt){
            
            Vector row = new Vector();
            
            row.add(gt.getMa_GT());
            row.add(gt.getTenGiaoTrinh());
            row.add(gt.getTenTacGia());
            row.add(gt.getNamXuatBan());
            row.add(gt.getNhaXuatBan());
          
            data.add(row);
        }
        return data;
    }
    
    public Vector loadTableCanBo_GiaoTrinh(){
        listgvgt = gvgt.getALLGVGT();
        
        Vector data = new Vector();
        for(GiangVien_GiaoTrinh gvgt : listgvgt){
            Vector row = new Vector();
            listcb = cb.getByID(gvgt.getMa_CB());
            row.add(gvgt.getStt());
            row.add(gvgt.getMa_CB());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }        
            row.add(gvgt.getMa_GT());
            data.add(row);
        }
       return data;
    }
    
    public Vector loadTableGiaoTrinh(){
        listgt = gt.getALL();
        
        Vector data = new Vector();
        
        for(GiaoTrinh gt : listgt){
            
            Vector row = new Vector();
            
            row.add(gt.getMa_GT());
            row.add(gt.getTenGiaoTrinh());
            row.add(gt.getTenTacGia());
            row.add(gt.getNamXuatBan());
            row.add(gt.getNhaXuatBan());
          
            data.add(row);
        }
        return data;
    }
    
    public void AddGiangVien_GiaoTrinh(String Stt, String Ma_CB, String Ma_GT){
        
        gvgt.setStt(Stt);
        gvgt.setMa_CB(Ma_CB);
        gvgt.setMa_GT(Ma_GT);
        if(Stt.length()!= 0){
            if(gvgt.AddDataGVGT(gvgt)){
                JOptionPane.showMessageDialog(null, "Thêm mới thành công. !");
            }else{
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateGiangVien_GiaoTrinh(String Stt, String Ma_CB, String Ma_GT){
        
        gvgt.setStt(Stt);
        gvgt.setMa_CB(Ma_CB);
        gvgt.setMa_GT(Ma_GT);
        if(gvgt.UpdateGVGT(gvgt)){
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        }else{
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
        }
    }
    
    public void DelGiangVien_GiaoTrinh(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listgvgt = gvgt.getALLGVGT();

            if (gvgt.DeleteDataGVGT(listgvgt.get(row).getStt())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
    
    public void AddGiaoTrinh(String Ma_GT, String TenGiaoTrinh, String TenTacGia, 
                                String NamXuatBan, String NhaXuatBan){
        
        gt.setMa_GT(Ma_GT);
        gt.setTenGiaoTrinh(TenGiaoTrinh);
        gt.setTenTacGia(TenTacGia);
        gt.setNamXuatBan(NamXuatBan);
        gt.setNhaXuatBan(NhaXuatBan);
        
        if(Ma_GT.length() != 0) {
            if (gt.AddData(gt)) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateGiaoTrinh(String Ma_GT, String TenGiaoTrinh, String TenTacGia, 
                                    String NamXuatBan, String NhaXuatBan){
        
        gt.setMa_GT(Ma_GT);
        gt.setTenGiaoTrinh(TenGiaoTrinh);
        gt.setTenTacGia(TenTacGia);
        gt.setNamXuatBan(NamXuatBan);
        gt.setNhaXuatBan(NhaXuatBan);
        
       
        if (gt.Update(gt)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại.!");
        }
    }
    
    public void DelGiaoTrinh(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listgt = gt.getALL();

            if (gt.DeleteData(listgt.get(row).getMa_GT())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
}
