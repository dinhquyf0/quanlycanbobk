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
public class GiangVien_TapChi extends DBConnect{
    String Stt;
    String Ma_CB;
    String Ma_BB;
    
    private final String GET_ALL_GVBB = "select * from giangvien_tapchi";
    private final String GET_BY_ID_GVBB = "select * from giangvien_tapchi where Stt=?";
    private final String ADD_DATA_GVBB ="insert into giangvien_tapchi(Stt,Ma_CB,Ma_BaiBao) value (?,?,?)";
    private final String UPDATE_DATA_GVBB = "update giangvien_tapchi set Ma_Cb =?,Ma_BaiBao=? where Stt=?";
    private final String REMOVE_DATA_GVBB="Delete from giangvien_tapchi where Stt=?";
   
    public ArrayList<GiangVien_TapChi> getByIDGVBB(String id){
        ArrayList<GiangVien_TapChi> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_GVBB);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null){
                while( rs.next()){
                GiangVien_TapChi item = new GiangVien_TapChi();
                item.setStt(rs.getString("Stt"));
                item.setMa_CB(rs.getString("Ma_CB"));
                item.setMa_BB(rs.getString("Ma_BaiBao"));
                                            
                objs.add(item);
                }
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs; 
    }
    
    public ArrayList<GiangVien_TapChi> getALLGVBB(){
        ArrayList<GiangVien_TapChi> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL_GVBB);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    GiangVien_TapChi item = new GiangVien_TapChi();
                    
                item.setStt(rs.getString("Stt"));
                item.setMa_CB(rs.getString("Ma_CB"));
                item.setMa_BB(rs.getString("Ma_BaiBao"));
                    
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddDataGVBB(GiangVien_TapChi gvtc){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA_GVBB);
            ps.setString(1, gvtc.getStt());
            ps.setString(2, gvtc.getMa_CB());
            ps.setString(3, gvtc.getMa_BB());
            
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
    
    public boolean DeleteDataGVBB(String u){
       boolean check = false;
       try {
           getConnect();
            PreparedStatement ps = con.prepareStatement(REMOVE_DATA_GVBB);
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
    
    public boolean UpdateGVBB(GiangVien_TapChi gvtc){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA_GVBB);
            ps.setString(1, gvtc.getMa_CB());
            ps.setString(2, gvtc.getMa_BB());
            ps.setString(3, gvtc.getStt());
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

    public String getMa_BB() {
        return Ma_BB;
    }

    public void setMa_BB(String Ma_BB) {
        this.Ma_BB = Ma_BB;
    }
}
