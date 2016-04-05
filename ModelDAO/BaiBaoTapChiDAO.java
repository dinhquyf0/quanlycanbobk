/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Model.BaiBaoTapChi;
import Model.CanBo;
import Model.GiangVien_TapChi;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dinhq
 */
public class BaiBaoTapChiDAO {
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    BaiBaoTapChi bb = new BaiBaoTapChi();
    ArrayList<BaiBaoTapChi> listbb = new ArrayList();
    
    GiangVien_TapChi cbbb = new GiangVien_TapChi();
    ArrayList<GiangVien_TapChi> listcbbb = new ArrayList<>();
            
    
    public void CBxMaBB(JComboBox Cbx){
        listbb = bb.getALL();
        for (BaiBaoTapChi bb : listbb) {
            Cbx.addItem(bb.getMa_BaiBao());
        }
    }
    
    public Vector loadTableGiangVien_TapChi(){
        listcbbb = cbbb.getALLGVBB();
        Vector data = new Vector();
        for(GiangVien_TapChi gvtc : listcbbb){
            Vector row = new Vector();
            listcb = cb.getByID(gvtc.getMa_CB());
            row.add(gvtc.getStt());
            row.add(gvtc.getMa_CB());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }        
            row.add(gvtc.getMa_BB());
            data.add(row);
        }
        return data;
    }
    
    public Vector loadTabelBaiBao_TapChi(){
        listbb = bb.getALL();
        Vector data = new Vector();
        
        for(BaiBaoTapChi bb : listbb){
            Vector row = new Vector();
            row.add(bb.getMa_BaiBao());
            row.add(bb.getTenTapChi());
            row.add(bb.getSo());
            row.add(bb.getThoiGianXuatBan());
            row.add(bb.getChiSo_ISSN());
            row.add(bb.getHeSo_IF());
 
            data.add(row);
        }
        return data;
    }
    
    public void AddCanBo_TapChi(String Stt, String Ma_CB, String Ma_BB){
        
        cbbb.setStt(Stt);
        cbbb.setMa_CB(Ma_CB);
        cbbb.setMa_BB(Ma_BB);
        if(Stt.length()!= 0){
            if(cbbb.AddDataGVBB(cbbb)){
                JOptionPane.showMessageDialog(null, "Thêm mới thành công. !");
            }else{
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateCanBo_TapChi(String Stt, String Ma_CB, String Ma_BB){
        
        cbbb.setStt(Stt);
        cbbb.setMa_CB(Ma_CB);
        cbbb.setMa_BB(Ma_BB);
        
        if(cbbb.UpdateGVBB(cbbb)){
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        }else{
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
        }
        
    }
    
    public void DelCanBo_TapChi(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listcbbb= cbbb.getALLGVBB();

            if (cbbb.DeleteDataGVBB(listcbbb.get(row).getStt())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
    
    public void DelBaiBao_TapChi(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listbb= bb.getALL();

            if (bb.DeleteData(listbb.get(row).getMa_BaiBao())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        
    }
    }
    public void AddBaiBaoTapChi(String Ma_BaiBao, String TenTapChi, String So, 
                                String ThoiGianXuatBan, String ChiSo_ISSN, String HeSo_IF){
        
        bb.setMa_BaiBao(Ma_BaiBao);
        bb.setTenTapChi(TenTapChi);
        bb.setSo(So);
        bb.setThoiGianXuatBan(ThoiGianXuatBan);
        bb.setChiSo_ISSN(ChiSo_ISSN);
        bb.setHeSo_IF(HeSo_IF);
        
        if((Ma_BaiBao.length() != 0) && (TenTapChi.length() != 0)) {
            if (bb.AddData(bb)) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại.!");
        }
    }
    
    public void UpdateBaiBaoTapChi(String Ma_BaiBao, String TenTapChi, String So, 
                                        String ThoiGianXuatBan, String ChiSo_ISSN, String HeSo_IF){
        
        bb.setMa_BaiBao(Ma_BaiBao);
        bb.setTenTapChi(TenTapChi);
        bb.setSo(So);
        bb.setThoiGianXuatBan(ThoiGianXuatBan);
        bb.setChiSo_ISSN(ChiSo_ISSN);
        bb.setHeSo_IF(HeSo_IF);
        
        if (bb.Update(bb)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
                
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại.!");
        }
    }
}
