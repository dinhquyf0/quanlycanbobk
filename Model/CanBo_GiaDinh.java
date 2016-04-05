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
public class CanBo_GiaDinh extends DBConnect{
    String stt;
    String Ma_GD;
    String Ma_CB;
    
    private final String GET_ALL_CBGD = "select * from canbo_giadinh";
    private final String GET_BY_ID_CBGD = "select * from canbo_giadinh where Stt=?";
    private final String ADD_DATA_CBGD ="insert into canbo_giadinh(Stt,Ma_CB,Ma_GD) value (?,?,?)";
    private final String UPDATE_DATA_CBGD = "update canbo_giadinh set Ma_CB =?,Ma_GD=? where Stt=?";
    private final String REMOVE_DATA_CBGD ="Delete from canbo_giadinh where Stt=?";
    public ArrayList<CanBo_GiaDinh> getByIDCBGD(String id){
        ArrayList<CanBo_GiaDinh> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_CBGD);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null){
                while( rs.next()){
                CanBo_GiaDinh item = new CanBo_GiaDinh();
                item.setstt(rs.getString("Stt"));
                item.setMa_CB(rs.getString("Ma_CB"));
                item.setMa_GD(rs.getString("Ma_GD"));
                                            
                objs.add(item);
                }
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs; 
    }
    
    public ArrayList<CanBo_GiaDinh> getALLCBGD(){
        ArrayList<CanBo_GiaDinh> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL_CBGD);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    CanBo_GiaDinh item = new CanBo_GiaDinh();
                    
                item.setstt(rs.getString("Stt"));
                item.setMa_CB(rs.getString("Ma_CB"));
                item.setMa_GD(rs.getString("Ma_GD"));
                    
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddDataCBGD(CanBo_GiaDinh gd){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA_CBGD);
            ps.setString(1, gd.getstt());
            ps.setString(2, gd.getMa_CB());
            ps.setString(3, gd.getMa_GD());
            
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
    
    public boolean DeleteDataCBGD(String u){
       boolean check = false;
       try {
           getConnect();
            PreparedStatement ps = con.prepareStatement(REMOVE_DATA_CBGD);
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
    
    public boolean UpdateCBGD(CanBo_GiaDinh gd){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA_CBGD);
            ps.setString(1, gd.getMa_CB());
            ps.setString(2, gd.getMa_GD());
            ps.setString(3, gd.getstt());
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

    public String getstt() {
        return stt;
    }

    public void setstt(String stt) {
        this.stt = stt;
    }

    public String getMa_GD() {
        return Ma_GD;
    }

    public void setMa_GD(String Ma_GD) {
        this.Ma_GD = Ma_GD;
    }
    
    
    
}
