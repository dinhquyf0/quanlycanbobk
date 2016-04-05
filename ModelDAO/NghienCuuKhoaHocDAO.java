/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Model.CanBo;
import Model.GiangVien_NghienCuuKhoaHoc;
import Model.NghienCuuKhoaHoc;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dinhq
 */
public class NghienCuuKhoaHocDAO {
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    GiangVien_NghienCuuKhoaHoc gv_nckh = new GiangVien_NghienCuuKhoaHoc();
    ArrayList<GiangVien_NghienCuuKhoaHoc> listgvnckh = new ArrayList<>();

    NghienCuuKhoaHoc  nckh = new NghienCuuKhoaHoc();
    ArrayList<NghienCuuKhoaHoc> listnckh = new ArrayList<>();
    
    public void BindingMaNCKH(JComboBox cbx){
        listnckh = nckh.getALL();
        for(NghienCuuKhoaHoc nckh : listnckh){
            cbx.addItem(nckh.getMa_DT());
        }
    }
    
    public Vector loadTableCanBo_NCKH(){
        listgvnckh = gv_nckh.getALLGVDT();
        
        Vector data = new Vector();
        for(GiangVien_NghienCuuKhoaHoc gvnckh : listgvnckh){
            Vector row = new Vector();
            listcb = cb.getByID(gvnckh.getma_canbo());
            row.add(gvnckh.getstt());
            row.add(gvnckh.getma_canbo());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }
            
            row.add(gvnckh.getMa_DT());
            data.add(row);
        }
        return data;
    }
    
    public Vector loadTableNCKH(){
        listnckh = nckh.getALL();
        
        Vector data = new Vector();
        
        for(NghienCuuKhoaHoc nckh : listnckh){
            Vector row = new Vector();
            row.add(nckh.getMa_DT());
            row.add(nckh.getTenDeTai());
            row.add(nckh.getCap());
            row.add(nckh.getKinhPhi());
            row.add(nckh.getThoiGianBatDau());
            row.add(nckh.getThoiGianKetThuc());
            row.add(nckh.getChuTriDeTai());
            row.add(nckh.getTinhTrang());
            row.add(nckh.getKetQua());
            data.add(row);
        }
        return data;
    }
    
    public void AddGiangVien_NghienCuuKhoaHoc(String Stt, String Ma_CB, String Ma_DT){
        
        gv_nckh.setstt(Stt);
        gv_nckh.setma_canbo(Ma_CB);
        gv_nckh.setMa_DT(Ma_DT);
        if(Stt.length()!= 0){
            if(gv_nckh.AddDataGVDT(gv_nckh)){
                JOptionPane.showMessageDialog(null, "Thêm mới thành công. !");
            }else{
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateGiangVien_NghienCuuKhoaHoc(String Stt, String Ma_CB, String Ma_DT){
       
        gv_nckh.setstt(Stt);
        gv_nckh.setma_canbo(Ma_CB);
        gv_nckh.setMa_DT(Ma_DT);
        if(gv_nckh.UpdateGVDT(gv_nckh)){
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        }else{
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
        }
    }
    
    public void DelGiangVian_NghienCuuKhoaHoc(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listgvnckh = gv_nckh.getALLGVDT();

            if (gv_nckh.DeleteDataGVDT(listgvnckh.get(row).getMa_DT())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
    
    public void AddNghienCuuKhoaHoc(String Ma_DT, String TenDeTai, String Cap, String KinhPhi,String ThoiGianBatDau, 
                                    String ThoiGianKetThuc, String ChuTriDeTai, String TinhTrang, String KetQua){
        
        nckh.setMa_DT(Ma_DT);
        nckh.setTenDeTai(TenDeTai);
        nckh.setCap(Cap);
        nckh.setKinhPhi(KinhPhi);
        nckh.setThoiGianBatDau(ThoiGianBatDau);
        nckh.setThoiGianKetThuc(ThoiGianKetThuc);
        nckh.setChuTriDeTai(ChuTriDeTai);
        nckh.setTinhTrang(TinhTrang);
        nckh.setKetQua(KetQua);
        
        if(Ma_DT.length()!= 0) {
            if (nckh.AddData(nckh)) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateNghienCuuKhoaHoc(String Ma_DT, String TenDeTai, String Cap, String KinhPhi,String ThoiGianBatDau, 
                                    String ThoiGianKetThuc, String ChuTriDeTai, String TinhTrang, String KetQua){
        
        nckh.setMa_DT(Ma_DT);
        nckh.setTenDeTai(TenDeTai);
        nckh.setCap(Cap);
        nckh.setKinhPhi(KinhPhi);
        nckh.setThoiGianBatDau(ThoiGianBatDau);
        nckh.setThoiGianKetThuc(ThoiGianKetThuc);
        nckh.setChuTriDeTai(ChuTriDeTai);
        nckh.setTinhTrang(TinhTrang);
        nckh.setKetQua(KetQua);
        
       
        if (nckh.Update(nckh)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại.!");
        }
    }
    
    public void DelNghienCuuKhoaHoc(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listnckh = nckh.getALL();

            if (nckh.DeleteData(listnckh.get(row).getMa_DT())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
}
