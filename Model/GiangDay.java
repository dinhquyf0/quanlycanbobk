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
public class GiangDay extends DBConnect{
    String Ma_MH;
    String TenMon;
    String SoTinChi;
    String Lop;
    String SoSinhVien;
    String HocKy;
    String NamHoc;
    String PhuCap_GD;
    private final String GET_BY_ID = "select * from giang_day where Ma_MH =?";
    private final String GET_BY_IDCB = "select giang_day.* from canbo, canbo_giangday ,giang_day where giang_day.Ma_MH = canbo_giangday.Ma_MH and canbo_giangday.Ma_CB = canbo.Ma_CB and canbo.Ma_CB =?";
    private final String GET_ALL = "select * from giang_day";
    private final String ADD_DATA = "insert into "
            + "giang_day(Ma_MH,TenMon,SoTinChi,Lop,SoSinhVien,HocKy,NamHoc,PhuCap_GD)"
            + "values (?,?,?,?,?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "giang_day set TenMon=?,SoTinChi=?,Lop=?,SoSinhVien=?,HocKy=?,NamHoc=?,PhuCap_GD=? where Ma_MH=?";
    private final String REMOVE_DATA = "Delete from giang_day where Ma_MH=?";
    
    public ArrayList<GiangDay> getByIDCB(String id){
        ArrayList<GiangDay> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_IDCB);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                GiangDay item = new GiangDay();
                
                item.setMa_MH(rs.getString("Ma_MH"));
                item.setTenMon(rs.getString("TenMon"));
                item.setSoTinChi(rs.getString("SoTinChi"));
                item.setLop(rs.getString("Lop"));
                item.setSoSinhVien(rs.getString("SoSinhVien"));
                item.setHocKy(rs.getString("HocKy"));
                item.setNamHoc(rs.getString("NamHoc"));
                item.setPhuCap_GD(rs.getString("PhuCap_GD"));
                
                objs.add(item);
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<GiangDay> getByID(String id){
        ArrayList<GiangDay> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                GiangDay item = new GiangDay();
                
                item.setMa_MH(rs.getString("Ma_MH"));
                item.setTenMon(rs.getString("TenMon"));
                item.setSoTinChi(rs.getString("SoTinChi"));
                item.setLop(rs.getString("Lop"));
                item.setSoSinhVien(rs.getString("SoSinhVien"));
                item.setHocKy(rs.getString("HocKy"));
                item.setNamHoc(rs.getString("NamHoc"));
                item.setPhuCap_GD(rs.getString("PhuCap_GD"));
                
                objs.add(item);
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public ArrayList<GiangDay> getALL() {
        ArrayList<GiangDay> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    GiangDay item = new GiangDay();
                    
                    item.setMa_MH(rs.getString("Ma_MH"));
                    item.setTenMon(rs.getString("TenMon"));
                    item.setSoTinChi(rs.getString("SoTinChi"));
                    item.setLop(rs.getString("Lop"));
                    item.setSoSinhVien(rs.getString("SoSinhVien"));
                    item.setHocKy(rs.getString("HocKy"));
                    item.setNamHoc(rs.getString("NamHoc"));
                    item.setPhuCap_GD(rs.getString("PhuCap_GD"));
                    
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(GiangDay gda){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, gda.getMa_MH());
            ps.setString(2, gda.getTenMon());
            ps.setString(3, gda.getSoTinChi());
            ps.setString(4, gda.getLop());
            ps.setString(5, gda.getSoSinhVien());
            ps.setString(6, gda.getHocKy());
            ps.setString(7, gda.getNamHoc());
            ps.setString(8, gda.getPhuCap_GD());
            
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
   
    public boolean Update(GiangDay gda){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, gda.getTenMon());
            ps.setString(2, gda.getSoTinChi());
            ps.setString(3, gda.getLop());
            ps.setString(4, gda.getSoSinhVien());
            ps.setString(5, gda.getHocKy());
            ps.setString(6, gda.getNamHoc());
            ps.setString(7, gda.getPhuCap_GD());
            ps.setString(8, gda.getMa_MH());
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
//    public GiangDay(int Ma_MH, String TenMon, int SoTinChi, String Lop, int SoSinhVien, int HocKy, int NamHoc, String PhuCap_GD) {
//        this.Ma_MH = Ma_MH;
//        this.TenMon = TenMon;
//        this.SoTinChi = SoTinChi;
//        this.Lop = Lop;
//        this.SoSinhVien = SoSinhVien;
//        this.HocKy = HocKy;
//        this.NamHoc = NamHoc;
//        this.PhuCap_GD = PhuCap_GD;
//    }

    public String getMa_MH() {
        return Ma_MH;
    }

    public void setMa_MH(String Ma_MH) {
        this.Ma_MH = Ma_MH;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public String getSoTinChi() {
        return SoTinChi;
    }

    public void setSoTinChi(String SoTinChi) {
        this.SoTinChi = SoTinChi;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public String getSoSinhVien() {
        return SoSinhVien;
    }

    public void setSoSinhVien(String SoSinhVien) {
        this.SoSinhVien = SoSinhVien;
    }

    public String getHocKy() {
        return HocKy;
    }

    public void setHocKy(String HocKy) {
        this.HocKy = HocKy;
    }

    public String getNamHoc() {
        return NamHoc;
    }

    public void setNamHoc(String NamHoc) {
        this.NamHoc = NamHoc;
    }

    public String getPhuCap_GD() {
        return PhuCap_GD;
    }

    public void setPhuCap_GD(String PhuCap_GD) {
        this.PhuCap_GD = PhuCap_GD;
    }
    
    
    



}

