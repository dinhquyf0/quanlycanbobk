/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Model.CanBo;
import Model.ChamThi;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dinhq
 */
public class ChamThiDAO {
    
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    ChamThi ct = new ChamThi();
    ArrayList<ChamThi> listct = new ArrayList<>();
    
    
    public Vector loadTableChamThi(){
        listct = ct.getALL();
        Vector data = new Vector();
        for(ChamThi ct : listct){
            Vector row = new Vector();
            listcb = cb.getByID(ct.getma_canbo());
            row.add(ct.getMa_ChamThi());
            row.add(ct.getMa_lop());
            row.add(ct.getma_canbo());
            if(listcb.size() > 0){
                row.add(listcb.get(0).getHoVaTen());
            }else{
                row.add("isEmpty");
            }        
            row.add(ct.getMa_MH());
            row.add(ct.getNgayNop());
            row.add(ct.getSoBaiThi());
            data.add(row);
        }
       return data;
    }
    
    public void AddChamThi(String Ma_ChamThi, String Ma_lop, String Ma_canBo, String Ma_monHoc, String NgayNop, String SoBaiThi){
        
        ct.setMa_ChamThi(Ma_ChamThi);
        ct.setMa_lop(Ma_lop);
        ct.setma_canbo(Ma_canBo);
        ct.setMa_MH(Ma_lop);
        ct.setNgayNop(NgayNop);
        ct.setSoBaiThi(SoBaiThi);
        if(Ma_ChamThi.length()!= 0){
            if(ct.AddData(ct)){
                JOptionPane.showMessageDialog(null, "Thêm mới thành công.!");
            }else{
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại. !");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại. !");
        }
    }
    
    public void UpdateChamThi(String Ma_ChamThi, String Ma_lop, String Ma_canBo, String Ma_monHoc, String NgayNop, String SoBaiThi){
        
        ct.setMa_ChamThi(Ma_ChamThi);
        ct.setMa_lop(Ma_lop);
        ct.setma_canbo(Ma_canBo);
        ct.setMa_MH(Ma_lop);
        ct.setNgayNop(NgayNop);
        ct.setSoBaiThi(SoBaiThi);
        if(ct.Update(ct)){
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
        }else{
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại. !");
        }
    }
    
    public void DelChamThi(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listct= ct.getALL();

            if (ct.DeleteData(listct.get(row).getMa_ChamThi())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
}
