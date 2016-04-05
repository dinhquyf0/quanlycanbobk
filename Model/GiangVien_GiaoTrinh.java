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
 * @author dinhq
 */
public class GiangVien_GiaoTrinh extends DBConnect{
    String Stt;
    String Ma_CB;
    String Ma_GT;
    
    private final String GET_ALL_GVGT = "select * from giangvien_giaotrinh";
    private final String GET_BY_ID_GVGT = "select * from giangvien_giaotrinh where Stt=?";
    private final String ADD_DATA_GVGT ="insert into giangvien_giaotrinh(Stt,Ma_CB,Ma_GT) value (?,?,?)";
    private final String UPDATE_DATA_GVGT = "update giangvien_giaotrinh set Ma_CB =?,Ma_GT=? where Stt=?";
    private final String REMOVE_DATA_GVGT ="Delete from giangvien_giaotrinh where Stt=?";
   
    public ArrayList<GiangVien_GiaoTrinh> getByIDGVGT(String id){
        ArrayList<GiangVien_GiaoTrinh> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_GVGT);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null){
                while( rs.next()){
                GiangVien_GiaoTrinh item = new GiangVien_GiaoTrinh();
                item.setStt(rs.getString("Stt"));
                item.setMa_CB(rs.getString("Ma_CB"));
                item.setMa_GT(rs.getString("Ma_GT"));
                                            
                objs.add(item);
                }
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs; 
    }
    
    public ArrayList<GiangVien_GiaoTrinh> getALLGVGT(){
        ArrayList<GiangVien_GiaoTrinh> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL_GVGT);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    GiangVien_GiaoTrinh item = new GiangVien_GiaoTrinh();
                    
                item.setStt(rs.getString("Stt"));
                item.setMa_CB(rs.getString("Ma_CB"));
                item.setMa_GT(rs.getString("Ma_GT"));
                    
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddDataGVGT(GiangVien_GiaoTrinh gvnckh){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA_GVGT);
            ps.setString(1, gvnckh.getStt());
            ps.setString(2, gvnckh.getMa_CB());
            ps.setString(3, gvnckh.getMa_GT());
            
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
    
    public boolean DeleteDataGVGT(String u){
       boolean check = false;
       try {
           getConnect();
            PreparedStatement ps = con.prepareStatement(REMOVE_DATA_GVGT);
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
    
    public boolean UpdateGVGT(GiangVien_GiaoTrinh gvnckh){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA_GVGT);
            ps.setString(1, gvnckh.getMa_CB());
            ps.setString(2, gvnckh.getMa_GT());
            ps.setString(3, gvnckh.getStt());
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
    
    
    public String getMa_CB(){
        return Ma_CB;
    }

    public void setMa_CB(String Ma_CB) {
        this.Ma_CB = Ma_CB;
    }

    public String getStt() {
        return Stt;
    }

    public void setStt(String Stt) {
        this.Stt = Stt;
    }

    public String getMa_GT() {
        return Ma_GT;
    }

    public void setMa_GT(String Ma_GT) {
        this.Ma_GT = Ma_GT;
    }
}
