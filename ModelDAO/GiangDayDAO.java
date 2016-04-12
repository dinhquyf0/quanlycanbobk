/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Model.CanBo;
import Model.GiangDay;
import Model.GiangVien_GiangDay;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dinhq
 */
public class GiangDayDAO {
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    GiangVien_GiangDay gvgd = new GiangVien_GiangDay();
    ArrayList<GiangVien_GiangDay> listgvgd = new ArrayList<>();
    
    GiangDay gd = new GiangDay();
    ArrayList<GiangDay> listgd = new ArrayList<>();
    
    
    public void BindingMaMH(JComboBox cbx){
        listgd = gd.getALL();
        for(GiangDay gd : listgd){
            cbx.addItem(gd.getMa_MH());
        }
    }
    
    public Vector loadTableGiangDayCanhan(String id){
        listgd = gd.getByIDCB(id);
        Vector data = new Vector();
        
            for (GiangDay gdy : listgd) {
            Vector row = new Vector();
            
            row.add(gdy.getMa_MH());
            row.add(gdy.getTenMon());
            row.add(gdy.getSoTinChi());
            row.add(gdy.getLop());
            row.add(gdy.getSoSinhVien());
            row.add(gdy.getHocKy());
            row.add(gdy.getNamHoc());
            row.add(gdy.getPhuCap_GD());
            data.add(row);
        }
        return data;    
    }
    
    public Vector loadTableGiangVien_GiangDay(){
        listgvgd = gvgd.getALLGVGD();
        Vector data = new Vector();
        for(GiangVien_GiangDay gvgd : listgvgd){
            Vector row = new Vector();
            listcb = cb.getByID(gvgd.getMa_CB());
            row.add(gvgd.getStt());
            row.add(gvgd.getMa_CB());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }        
            row.add(gvgd.getMa_MH());
            data.add(row);
        }
        return data;
    }
    
    public Vector loadTableGiangDay(){
        listgd = gd.getALL();
        Vector data = new Vector();
        
            for (GiangDay gdy : listgd) {
            Vector row = new Vector();
            
            row.add(gdy.getMa_MH());
            row.add(gdy.getTenMon());
            row.add(gdy.getSoTinChi());
            row.add(gdy.getLop());
            row.add(gdy.getSoSinhVien());
            row.add(gdy.getHocKy());
            row.add(gdy.getNamHoc());
            row.add(gdy.getPhuCap_GD());
            data.add(row);
        }
        return data;
    }
    
    public void AddGiangVien_GiangDay(String Stt, String Ma_CB, String Ma_MH){
        
        gvgd.setStt(Stt);
        gvgd.setMa_CB(Ma_CB);
        gvgd.setMa_MH(Ma_MH);
        if(Stt.length()!= 0){
            if(gvgd.AddDataGVGD(gvgd)){
                JOptionPane.showMessageDialog(null, "Thêm mới thành công. !");
            }else{
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateGiangVien_GiangDay(String Stt, String Ma_CB, String Ma_MH){
        
        gvgd.setStt(Stt);
        gvgd.setMa_CB(Ma_CB);
        gvgd.setMa_MH(Ma_MH);
        if(gvgd.UpdateGVGD(gvgd)){
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        }else{
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
        }
    }
    
    public void DelCanBo_GiangDay(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listgvgd = gvgd.getALLGVGD();

            if (gvgd.DeleteDataGVGD(listgvgd.get(row).getStt())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
    
    public void AddGiangDay(String Ma_MH, String TenMon, String SoTinChi, 
                                String Lop, String SoSinhVien, String Hocky, String NamHoc, String PhuCap_GD){
        
        gd.setMa_MH(Ma_MH);
        gd.setTenMon(TenMon);
        gd.setSoTinChi(SoTinChi);
        gd.setLop(Lop);
        gd.setSoSinhVien(SoSinhVien);
        gd.setHocKy(Hocky);
        gd.setNamHoc(NamHoc);
        gd.setPhuCap_GD(PhuCap_GD);
        
        if(Ma_MH.length() != 0) {
            if (gd.AddData(gd)) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateGiangDay(String Ma_MH, String TenMon, String SoTinChi, 
                                String Lop, String SoSinhVien, String Hocky, String NamHoc, String PhuCap_GD){
        
        gd.setMa_MH(Ma_MH);
        gd.setTenMon(TenMon);
        gd.setSoTinChi(SoTinChi);
        gd.setLop(Lop);
        gd.setSoSinhVien(SoSinhVien);
        gd.setHocKy(Hocky);
        gd.setNamHoc(NamHoc);
        gd.setPhuCap_GD(PhuCap_GD);
        
       
        if (gd.Update(gd)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại.!");
        }
    }
        
    public void DelGiangDay(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listgd = gd.getALL();

            if (gd.DeleteData(listgd.get(row).getMa_MH())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }    
}
