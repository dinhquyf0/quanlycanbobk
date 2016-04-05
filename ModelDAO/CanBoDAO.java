/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;
import Model.CanBo;
import Model.ChucDanh;
import Model.ChucVu;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
/**
 *
 * @author dinhq
 */
public class CanBoDAO {
    CanBo cb = new CanBo();
    ArrayList<CanBo> listcb = new ArrayList<>();
    
    ChucVu cv = new ChucVu();
    ArrayList<ChucVu> listcv = new ArrayList<>();
    
    ChucDanh cd = new ChucDanh();
    ArrayList<ChucDanh> listcd = new ArrayList<>();
    

    public void CBbxMaCB(JComboBox CBx1,JComboBox CBx2,JComboBox CBx3,JComboBox CBx4,
                            JComboBox CBx5, JComboBox CBx6, JComboBox CBx7, JComboBox CBx8,
                            JComboBox CBx9, JComboBox CBx10, JComboBox CBx11, JComboBox CBx12, JComboBox CBx13){
        listcb = cb.getALL();
        for (CanBo cb : listcb) {
            CBx1.addItem(cb.getMa_CB());
            CBx2.addItem(cb.getMa_CB());
            CBx3.addItem(cb.getMa_CB());
            CBx4.addItem(cb.getMa_CB());
            CBx5.addItem(cb.getMa_CB());
            CBx6.addItem(cb.getMa_CB());
            CBx7.addItem(cb.getMa_CB());
            CBx8.addItem(cb.getMa_CB());
            CBx9.addItem(cb.getMa_CB());
            CBx10.addItem(cb.getMa_CB());
            CBx11.addItem(cb.getMa_CB());
            CBx12.addItem(cb.getMa_CB());
            CBx13.addItem(cb.getMa_CB());
        }
    }
    
    public Vector loadSearchTable(){
        listcb = cb.getALL();
        
        Vector data = new Vector();
        
            for (CanBo cbo : listcb) {
            Vector row = new Vector();
            listcv = cv.getByID(cbo.getMa_CB());
            listcd = cd.getByID(cbo.getMa_CB());
            row.add(cbo.getMa_CB());
            row.add(cbo.getHoVaTen());
            row.add(cbo.getNgaySinh());
            row.add(cbo.getGioiTinh());
            row.add(cbo.getNoiCongTac());
            row.add(cbo.getThoiGianBDCT());
            row.add(cbo.getTrinhDo());
            if (listcv.size() > 0) {
                row.add(listcv.get(0).getChucVu());
            } else {
                row.add("isEmpty");
            }
            if (listcd.size() > 0) {
                row.add(listcd.get(0).getChucDanh());
            } else {
                row.add("isEmpty");
            }
            row.add(cbo.getDiaChi());
            row.add(cbo.getSoDienThoai());
            row.add(cbo.getEmail());
            row.add(cbo.getThanhTich());
            row.add(cbo.getThongTinKhac());
            data.add(row);
        }
        return data;

    }
    
    public Vector loadTableCanBo(){
        listcb = cb.getALL();
  
        Vector data = new Vector();
        
            for (CanBo cbo : listcb) {
            Vector row = new Vector();
            
            row.add(cbo.getMa_CB());
            row.add(cbo.getUserName());
            row.add(cbo.getHoVaTen());
            row.add(cbo.getNgaySinh());
            row.add(cbo.getGioiTinh());
            row.add(cbo.getNoiCongTac());
            row.add(cbo.getThoiGianBDCT());
            row.add(cbo.getTrinhDo());
            row.add(cbo.getSoTaiKhoan());
            row.add(cbo.getMaSoThue());
            row.add(cbo.getDiaChi());
            row.add(cbo.getSoDienThoai());
            row.add(cbo.getEmail());
            row.add(cbo.getThanhTich());
            row.add(cbo.getThongTinKhac());

            data.add(row);
        }
        return data;
    }
    
    public void AddCanBo(String MaCB, String user, String Password, 
                         String HovaTen, String NgaySinh, String GioiTinh, 
                         String NoiCongTac, String ThoiGianBatDau, String TrinhDo, 
                         String MaSoThue, String SoTaiKhoan, String DiaChi,
                         String SoDienThoai, String Email,String ThanhTich, String ThongTinKhac, int Dgv, int dv, int cdv){
        
        cb.setMa_CB(MaCB);
        cb.setUserName(user);
        cb.setPassword(Password);
        cb.setHoVaTen(HovaTen);
        cb.setNgaySinh(NgaySinh);
        cb.setGioiTinh(GioiTinh);
        cb.setNoiCongTac(NoiCongTac);
        cb.setThoiGianBDCT(ThoiGianBatDau);
        cb.setMaSoThue(MaSoThue);
        cb.setSoTaiKhoan(SoTaiKhoan);
        cb.setDiaChi(DiaChi);
        cb.setSoDienThoai(SoDienThoai);
        cb.setEmail(Email);
        cb.setThanhTich(ThanhTich);
        cb.setThongTinKhac(ThongTinKhac);
        cb.setDangVien(Dgv);
        cb.setDoanVien(dv);
        cb.setCongDoanVien(cdv);
        
        if((MaCB.length() != 0) && (user.length() != 0)) {
            if (cb.AddData(cb)) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công.!" + "\n"+"Mật khẩu đăng nhập là : 123456");
                
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại .!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại. !");
        }
    }
    
    public void UpdateCanBo(String MaCB, String user,  
                            String HovaTen, String NgaySinh, String GioiTinh, 
                            String NoiCongTac, String ThoiGianBatDau, String TrinhDo, 
                            String MaSoThue, String SoTaiKhoan, String DiaChi,
                            String SoDienThoai, String Email,String ThanhTich, String ThongTinKhac, int Dgv, int dv, int cdv){
        
        cb.setMa_CB(MaCB);
        cb.setUserName(user);
        cb.setHoVaTen(HovaTen);
        cb.setNgaySinh(NgaySinh);
        cb.setGioiTinh(GioiTinh);
        cb.setNoiCongTac(NoiCongTac);
        cb.setThoiGianBDCT(ThoiGianBatDau);
        cb.setMaSoThue(MaSoThue);
        cb.setSoTaiKhoan(SoTaiKhoan);
        cb.setDiaChi(DiaChi);
        cb.setSoDienThoai(SoDienThoai);
        cb.setEmail(Email);
        cb.setThanhTich(ThanhTich);
        cb.setThongTinKhac(ThongTinKhac);
        cb.setDangVien(Dgv);
        cb.setDoanVien(dv);
        cb.setCongDoanVien(cdv);
        
        if (cb.Update(cb)) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại .!");
            }
    }
    
    public void ChangePass(String s,String oldpass, String newpass, String renewpass){
       
        listcb =cb.getByUser(s);
        for(CanBo cbo : listcb){
            String pass = cbo.getPassword();
            if(oldpass.equals(pass)){
                if(renewpass.equals(newpass)){
                    cbo.setUserName(s);
                    cbo.setPassword(renewpass);
                    
                    if(cbo.UpdatePass(cbo)){
                        JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thành công.!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thất bại.!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "mật khẩu mới không trùng. Nhập lại.!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "mật khẩu cũ không chính xác. Nhập lại!");
            }
        }
}
    
    public void DelCanBo(JTable table){
        if (table.getSelectedRow() != -1) {
            int row = table.getSelectedRow();
            listcb= cb.getALL();

            if (cb.DeleteData(listcb.get(row).getMa_CB())) {
                JOptionPane.showMessageDialog(null, "Xóa thành công.!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.!");
            }
        }
    }
}
    
