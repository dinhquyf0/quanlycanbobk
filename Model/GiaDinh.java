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
public class GiaDinh extends DBConnect{
    String Stt;
    String Ma_GD;
    String HoVaTenCon;
    String NamSinh;
    String ThanhTich;

    private final String GET_BY_ID = "select gia_dinh.* from canbo, canbo_giadinh,gia_dinh where gia_dinh.Ma_GD = canbo_giadinh.Ma_GD and canbo_giadinh.Ma_CB = canbo.Ma_CB and canbo.Ma_CB =?";
    private final String GET_ALL = "select * from gia_dinh";
    private final String ADD_DATA = "insert into "
            + "gia_dinh(Stt,Ma_GD,HoVaTenCon,NamSinh,ThanhTich)"
            + "values (?,?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "gia_dinh set Ma_GD=?,HoVaTenCon=?,NamSinh=?,ThanhTich=? where Stt=?";
    private final String REMOVE_DATA = "Delete from gia_dinh where Stt=?";
    

    
    public ArrayList<GiaDinh> getByID(String id){
        ArrayList<GiaDinh> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null){
                while( rs.next()){
                GiaDinh item = new GiaDinh();
                
                
                item.setMa_GD(rs.getString("Ma_GD"));
                item.setHoVaTenCon(rs.getString("HoVaTenCon"));
                item.setNamSinh(rs.getString("NamSinh"));
                item.setThanhTich(rs.getString("ThanhTich"));
                                
                objs.add(item);
                }
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public ArrayList<GiaDinh> getALL() {
        ArrayList<GiaDinh> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    GiaDinh item = new GiaDinh();
                    
                    item.setStt(rs.getString("Stt"));
                    item.setMa_GD(rs.getString("Ma_GD"));
                    item.setHoVaTenCon(rs.getString("HoVaTenCon"));
                    item.setNamSinh(rs.getString("NamSinh"));
                    item.setThanhTich(rs.getString("ThanhTich"));
                    
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(GiaDinh gd){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, gd.getStt());
            ps.setString(2, gd.getMa_GD());
            ps.setString(3, gd.getHoVaTenCon());
            ps.setString(4, gd.getNamSinh());
            ps.setString(5, gd.getThanhTich());
            
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
   
    public boolean Update(GiaDinh gd){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, gd.getMa_GD());
            ps.setString(2, gd.getHoVaTenCon());
            ps.setString(3, gd.getNamSinh());
            ps.setString(4, gd.getThanhTich() );
            ps.setString(5, gd.getStt());
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



    public String getStt() {
        return Stt;
    }
    public void setStt(String Stt){
        this.Stt = Stt;
    }
    
    public String getMa_GD() {
        return Ma_GD;
    }

    public void setMa_GD(String Ma_GD) {
        this.Ma_GD = Ma_GD;
    }

    public String getHoVaTenCon() {
        return HoVaTenCon;
    }

    public void setHoVaTenCon(String HoVaTenCon) {
        this.HoVaTenCon = HoVaTenCon;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String NamSinh) {
        this.NamSinh = NamSinh;
    }

    public String getThanhTich() {
        return ThanhTich;
    }

    public void setThanhTich(String ThanhTich) {
        this.ThanhTich = ThanhTich;
    }
    
    
}
