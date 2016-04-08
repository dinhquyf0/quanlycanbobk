/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Chyp
 */
public class CanBo extends DBConnect implements java.io.Serializable {
    
    private final String GET_LOGIN = "select * from canbo where UserName=? and Password=?";
    private final String GET_ALL = "select * from canbo";
    private final String GET_BYID = "select * from canbo where Ma_CB =?";
    private final String GET_BYUSER ="select * from canbo where  UserName=?";
    private final String GET_BYID_CBGD = "select canbo.* from canbo, canbo_giadinh where canbo.Ma_CB = canbo_giadinh.Ma_CB and canbo_giadinh.Ma_CB = ?  ";
    private final String GET_BYIDGD = "select canbo.* from canbo, canbo_giadinh,gia_dinh where canbo.Ma_CB = canbo_giadinh.Ma_CB and canbo_giadinh.Ma_GD = gia_dinh.Ma_GD and gia_dinh.Ma_GD = ?";
    private final String GET_BYIDGDY = "select HoVaTen from canbo, canbo_giangday ,giang_day where giang_day.Ma_MH = canbo_giangday.Ma_MH and canbo_giangday.Ma_CB = canbo.Ma_CB and giang_day.Ma_MH =?";
    private final String GET_BYIDBB = "select HoVaTen from canbo, giangvien_tapchi ,tap_chi where tap_chi.Ma_BaiBao = giangvien_tapchi.Ma_BaiBao and giangvien_tapchi.Ma_CB = canbo.Ma_CB and tap_chi.Ma_BaiBao =?";
    private final String GET_TGBDCT = "select ThoiGianBatDauCongTac from canbo where Ma_CB =?";
    private final String ADD_DATA = "insert into "
            + "canbo(Ma_CB,UserName,Password,HoVaTen,NgaySinh,GioiTinh,NoiCongTac,ThoiGianBatDauCongTac,TrinhDo,MaSoThue,SoTaiKhoan,DiaChi,SoDienThoai,Email,ThanhTich,ThongTinKhac,DangVien,DoanVien,CongDoanVien)"
            + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "canbo set UserName=?,HoVaTen=?,NgaySinh=?,GioiTinh=?,NoiCongTac=?,ThoiGianBatDauCongTac =?,TrinhDo =?,MaSoThue=?,SoTaiKhoan=?,DiaChi=?,SoDienThoai=?,Email=?,ThanhTich=?,ThongTinKhac=?,DangVien = ?, DoanVien = ?, CongDoanVien = ? where Ma_CB=?";
    private final String REMOVE_DATA = "Delete from canbo where Ma_CB=?";
    private final String UPDATE_PASS = "Update canbo set Password =? where UserName =?";
    
        
    public boolean getLogin(String u, String p) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_LOGIN);
            ps.setString(1, u);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public String getThoiGianBatDauCongTac(String id){
        String thoigian="";
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_TGBDCT);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while (rs.next()) {
                    thoigian = rs.getString("ThoiGianBatDauCongTac");
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thoigian;
    }
    
    public ArrayList<CanBo> getByIDCBGD(String s){
        ArrayList<CanBo> objs = new ArrayList<>();
        try{
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BYID_CBGD);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next() ){
                CanBo item = new CanBo();
                item.setMa_CB(rs.getString("Ma_CB"));
                item.setHoVaTen(rs.getString("HoVaTen"));
                objs.add(item);
            }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return objs;
    }
    public ArrayList<CanBo> getByIDGD(String s){
        ArrayList<CanBo> objs = new ArrayList<>();
        try{
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BYIDGD);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next() ){
                CanBo item = new CanBo();
                item.setMa_CB(rs.getString("Ma_CB"));
                item.setHoVaTen(rs.getString("HoVaTen"));
                objs.add(item);
            }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<CanBo> getByIDGDY(String s){
        ArrayList<CanBo> objs = new ArrayList<>();
        try{
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BYIDGDY);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next() ){
                CanBo item = new CanBo();
                item.setHoVaTen(rs.getString("HoVaTen"));
                objs.add(item);
            }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<CanBo> getByIDBB(String s){
        ArrayList<CanBo> objs = new ArrayList<>();
        try{
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BYIDBB);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next() ){
                CanBo item = new CanBo();
                item.setHoVaTen(rs.getString("HoVaTen"));
                objs.add(item);
            }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<CanBo> getALL() {
        ArrayList<CanBo> objs = new ArrayList<CanBo>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    
                    CanBo item = new CanBo();

                    item.setMa_CB(rs.getString("Ma_CB"));
                    item.setUserName(rs.getString("UserName"));
                    item.setPassword(rs.getString("Password"));
                    item.setHoVaTen(rs.getString("HoVaTen"));
                    item.setNgaySinh(rs.getString("NgaySinh"));
                    item.setGioiTinh(rs.getString("GioiTinh"));
                    item.setNoiCongTac(rs.getString("NoiCongTac"));
                    item.setThoiGianBDCT(rs.getString("ThoiGianBatDauCongTac"));
                    item.setTrinhDo(rs.getString("TrinhDo"));
                    item.setMaSoThue(rs.getString("MaSoThue"));
                    item.setSoTaiKhoan(rs.getString("SoTaiKhoan"));
                    item.setDiaChi(rs.getString("DiaChi"));
                    item.setSoDienThoai(rs.getString("SoDienThoai"));
                    item.setEmail(rs.getString("Email"));
                    item.setThanhTich(rs.getString("ThanhTich"));
                    item.setThongTinKhac(rs.getString("ThongTinKhac"));
                    item.setDangVien(rs.getInt("DangVien"));
                    item.setDoanVien(rs.getInt("DoanVien"));
                    item.setCongDoanVien(rs.getInt("CongDoanVien"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    public ArrayList<CanBo> getByID(String s){
        ArrayList<CanBo> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BYID);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                CanBo item = new CanBo();
                    item.setMa_CB(rs.getString("Ma_CB"));
                    item.setUserName(rs.getString("UserName"));
                    item.setPassword(rs.getString("Password"));
                    item.setHoVaTen(rs.getString("HoVaTen"));
                    item.setNgaySinh(rs.getString("NgaySinh"));
                    item.setGioiTinh(rs.getString("GioiTinh"));
                    item.setNoiCongTac(rs.getString("NoiCongTac"));
                    item.setThoiGianBDCT(rs.getString("ThoiGianBatDauCongTac"));
                    item.setTrinhDo(rs.getString("TrinhDo"));
                    item.setMaSoThue(rs.getString("MaSoThue"));
                    item.setSoTaiKhoan(rs.getString("SoTaiKhoan"));
                    item.setDiaChi(rs.getString("DiaChi"));
                    item.setSoDienThoai(rs.getString("SoDienThoai"));
                    item.setEmail(rs.getString("Email"));
                    item.setThanhTich(rs.getString("ThanhTich"));
                    item.setThongTinKhac(rs.getString("ThongTinKhac"));
                    item.setDangVien(rs.getInt("DangVien"));
                    item.setDoanVien(rs.getInt("DoanVien"));
                    item.setCongDoanVien(rs.getInt("CongDoanVien"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<CanBo> getByUser(String s){
        ArrayList<CanBo> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BYUSER);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                CanBo item = new CanBo();
                    item.setMa_CB(rs.getString("Ma_CB"));
                    item.setUserName(rs.getString("UserName"));
                    item.setPassword(rs.getString("Password"));
                    item.setHoVaTen(rs.getString("HoVaTen"));
                    item.setNgaySinh(rs.getString("NgaySinh"));
                    item.setGioiTinh(rs.getString("GioiTinh"));
                    item.setNoiCongTac(rs.getString("NoiCongTac"));
                    item.setThoiGianBDCT(rs.getString("ThoiGianBatDauCongTac"));
                    item.setTrinhDo(rs.getString("TrinhDo"));
                    item.setMaSoThue(rs.getString("MaSoThue"));
                    item.setSoTaiKhoan(rs.getString("SoTaiKhoan"));
                    item.setDiaChi(rs.getString("DiaChi"));
                    item.setSoDienThoai(rs.getString("SoDienThoai"));
                    item.setEmail(rs.getString("Email"));
                    item.setThanhTich(rs.getString("ThanhTich"));
                    item.setThongTinKhac(rs.getString("ThongTinKhac"));
                    item.setDangVien(rs.getInt("DangVien"));
                    item.setDoanVien(rs.getInt("DoanVien"));
                    item.setCongDoanVien(rs.getInt("CongDoanVien"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(CanBo cbo){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, cbo.getMa_CB());
            ps.setString(2, cbo.getUserName());
            ps.setString(3, cbo.getPassword());
            ps.setString(4, cbo.getHoVaTen());
            ps.setString(5, cbo.getNgaySinh());
            ps.setString(6, cbo.getGioiTinh());
            ps.setString(7, cbo.getNoiCongTac());
            ps.setString(8, cbo.getThoiGianBDCT());
            ps.setString(9, cbo.getTrinhDo());
            ps.setString(10, cbo.getMaSoThue());
            ps.setString(11, cbo.getSoTaiKhoan());
            ps.setString(12, cbo.getDiaChi());
            ps.setString(13, cbo.getSoDienThoai());
            ps.setString(14, cbo.getEmail());
            ps.setString(15, cbo.getThanhTich());
            ps.setString(16, cbo.getThongTinKhac());
            ps.setInt(17, cbo.getDangVien());
            ps.setInt(18, cbo.getDoanVien());
            ps.setInt(19, cbo.getCongDoanVien());
            int rs = ps.executeUpdate();
            if(rs > 0){
                check = true;
            }
            
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

   public boolean DeleteData(String u){
       boolean check = false;
       try {
           getConnect();
            PreparedStatement ps = con.prepareStatement(REMOVE_DATA);
            ps.setString(1, u);
            int rs = ps.executeUpdate();
            if(rs > 0){
                check = true;
            }
           getClose();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return check;
   }
    
    public boolean UpdatePass(CanBo cbo){
        
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_PASS);
            ps.setString(1, cbo.getPassword());
            ps.setString(2, cbo.getUserName());
            int rs = ps.executeUpdate();
            if(rs>0){
                check = true;
            }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return check;
    }
   
    public boolean Update(CanBo cbo){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, cbo.getUserName());
            ps.setString(2, cbo.getHoVaTen());
            ps.setString(3, cbo.getNgaySinh());
            ps.setString(4, cbo.getGioiTinh());
            ps.setString(5, cbo.getNoiCongTac());
            ps.setString(6, cbo.getThoiGianBDCT());
            ps.setString(7, cbo.getTrinhDo());
            ps.setString(8, cbo.getMaSoThue());
            ps.setString(9, cbo.getSoTaiKhoan());
            ps.setString(10, cbo.getDiaChi());
            ps.setString(11, cbo.getSoDienThoai());
            ps.setString(12, cbo.getEmail());
            ps.setString(13, cbo.getThanhTich());
            ps.setString(14, cbo.getThongTinKhac());
            ps.setInt(15, cbo.getDangVien());
            ps.setInt(16, cbo.getDoanVien());
            ps.setInt(17, cbo.getCongDoanVien());
            ps.setString(18, cbo.getMa_CB());
            int rs = ps.executeUpdate();
            if(rs > 0){
                check = true;
            }
            
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    
    
    String Ma_CB;
    String UserName;
    String Password;
    String HoVaTen;
    String NgaySinh;
    String GioiTinh;
    String NoiCongTac;
    String MaSoThue;
    String SoTaiKhoan;
    String DiaChi;
    String SoDienThoai;
    String Email;
    String ThanhTich;
    String ThongTinKhac;
    String ThoiGianBDCT;
    String TrinhDo;
    int DoanVien;
    int DangVien;
    int CongDoanVien;

    public int getDoanVien() {
        return DoanVien;
    }

    public void setDoanVien(Integer DoanVien) {
        this.DoanVien = DoanVien;
    }

    public int getDangVien() {
        return DangVien;
    }

    public void setDangVien(Integer DangVien) {
        this.DangVien = DangVien;
    }

    public int getCongDoanVien() {
        return CongDoanVien;
    }

    public void setCongDoanVien(Integer CongDoanVien) {
        this.CongDoanVien = CongDoanVien;
    }

    public String getMa_CB() {
        return Ma_CB;
    }

    public void setMa_CB(String Ma_CB) {
        this.Ma_CB = Ma_CB;
    }
    
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public void setPassword(String Password){
        this.Password = Password;
    }
    
    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
    public String getNoiCongTac() {
        return NoiCongTac;
    }

    public void setNoiCongTac(String NoiCongTac) {
        this.NoiCongTac = NoiCongTac;
    }

    public String getThoiGianBDCT() {
        return ThoiGianBDCT;
    }

    public void setThoiGianBDCT(String ThoiGianBDCT) {
        this.ThoiGianBDCT = ThoiGianBDCT;
    }
    
    
    
    public String getMaSoThue() {
        return MaSoThue;
    }

    public void setMaSoThue(String MaSoThue) {
        this.MaSoThue = MaSoThue;
    }

    public String getSoTaiKhoan() {
        return SoTaiKhoan;
    }

    public void setSoTaiKhoan(String SoTaiKhoan) {
        this.SoTaiKhoan = SoTaiKhoan;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getThanhTich() {
        return ThanhTich;
    }

    public void setThanhTich(String ThanhTich) {
        this.ThanhTich = ThanhTich;
    }

    public String getThongTinKhac() {
        return ThongTinKhac;
    }

    public void setThongTinKhac(String ThongTinKhac) {
        this.ThongTinKhac = ThongTinKhac;
    }

    public String getTrinhDo() {
        return TrinhDo;
    }

    public void setTrinhDo(String TrinhDo) {
        this.TrinhDo = TrinhDo;
    }
    
    
    
}
    

    
    
