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
public class GiangVien_GiangDay extends DBConnect{
    String Stt;
    String Ma_CB;
    String Ma_MH;
    
    private final String GET_ALL_GVGD = "select * from canbo_giangday";
    private final String GET_BY_ID_GVGD = "select * from canbo_giangday where Stt=?";
    private final String ADD_DATA_GVGD ="insert into canbo_giangday(Stt,Ma_CB,Ma_MH) value (?,?,?)";
    private final String UPDATE_DATA_GVGD = "update canbo_giangday set Ma_CB =?,Ma_MH=? where Stt=?";
    private final String REMOVE_DATA_GVGD ="Delete from canbo_giangday where Stt=?";
   
    public ArrayList<GiangVien_GiangDay> getByIDGVGD(String id){
        ArrayList<GiangVien_GiangDay> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_GVGD);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null){
                while( rs.next()){
                GiangVien_GiangDay item = new GiangVien_GiangDay();
                item.setStt(rs.getString("Stt"));
                item.setMa_CB(rs.getString("Ma_CB"));
                item.setMa_MH(rs.getString("Ma_MH"));
                                            
                objs.add(item);
                }
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs; 
    }
    
    public ArrayList<GiangVien_GiangDay> getALLGVGD(){
        ArrayList<GiangVien_GiangDay> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL_GVGD);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    GiangVien_GiangDay item = new GiangVien_GiangDay();
                    
                item.setStt(rs.getString("Stt"));
                item.setMa_CB(rs.getString("Ma_CB"));
                item.setMa_MH(rs.getString("Ma_MH"));
                    
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddDataGVGD(GiangVien_GiangDay gvnckh){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA_GVGD);
            ps.setString(1, gvnckh.getStt());
            ps.setString(2, gvnckh.getMa_CB());
            ps.setString(3, gvnckh.getMa_MH());
            
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
    
    public boolean DeleteDataGVGD(String u){
       boolean check = false;
       try {
           getConnect();
            PreparedStatement ps = con.prepareStatement(REMOVE_DATA_GVGD);
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
    
    public boolean UpdateGVGD(GiangVien_GiangDay gvnckh){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA_GVGD);
            ps.setString(1, gvnckh.getMa_CB());
            ps.setString(2, gvnckh.getMa_MH());
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

    public String getMa_MH() {
        return Ma_MH;
    }

    public void setMa_MH(String Ma_MH) {
        this.Ma_MH = Ma_MH;
    }
}
