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
public class ChucDanh extends DBConnect{
    String Stt;
    String Ma_CB;
    String ChucDanh;
    String ThoiGianNhan;
    private final String GET_BY_ID = "select * from chuc_danh where Ma_CB =?";
    private final String GET_BY_ID_CB ="select ChucDanh from chuc_danh where Ma_CB = ?";
    private final String GET_ALL = "select * from chuc_danh";
    private final String ADD_DATA = "insert into "
            + "chuc_danh(Stt,Ma_CB,ChucDanh,ThoiGianNhan)"
            + "values (?,?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "chuc_danh set Ma_CB =? ,ChucDanh=?,ThoiGianNhan=? where Stt=?";
    private final String REMOVE_DATA = "Delete from chuc_danh where Stt=?";
    
    public String getByIDCB(String id){
        String chucdanh ="";
        try{
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_CB);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null ){
                while (rs.next()) {
                chucdanh = rs.getString("ChucDanh");
                }
            }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return chucdanh;
    }
    
    public ArrayList<ChucDanh> getByID(String id){
        ArrayList<ChucDanh> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null){
                ChucDanh item = new ChucDanh();
                while(rs.next()){
                item.setStt(rs.getString("Stt"));
                item.setMa_CB(rs.getString("Ma_CB"));
                item.setChucDanh(rs.getString("ChucDanh"));
                item.setThoiGianNhan(rs.getString("ThoiGianNhan"));
                }                
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public ArrayList<ChucDanh> getALL() {
        ArrayList<ChucDanh> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ChucDanh item = new ChucDanh();
                    item.setStt(rs.getString("Stt"));
                    item.setMa_CB(rs.getString("Ma_CB"));
                    item.setChucDanh(rs.getString("ChucDanh"));
                    item.setThoiGianNhan(rs.getString("ThoiGianNhan"));
                                                                             
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(ChucDanh cd){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1,cd.getStt());
            ps.setString(2, cd.getMa_CB());
            ps.setString(3, cd.getChucDanh());
            ps.setString(4, cd.getThoiGianNhan());
                
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
   
    public boolean Update(ChucDanh cd){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, cd.getMa_CB());
            ps.setString(2, cd.getChucDanh());
            ps.setString(3, cd.getThoiGianNhan());
            ps.setString(4, cd.getStt());
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
//    public ChucDanh(int Ma_CB, String ChucDanh, String ThoiGian) {
//        this.Ma_CB = Ma_CB;
//        this.ChucDanh = ChucDanh;
//        this.ThoiGian = ThoiGian;
//    }

    public String getStt() {
        return Stt;
    }

    public void setStt(String Stt) {
        this.Stt = Stt;
    }

    public String getMa_CB() {
        return Ma_CB;
    }

    public void setMa_CB(String Ma_CB) {
        this.Ma_CB = Ma_CB;
    }

    public String getChucDanh() {
        return ChucDanh;
    }

    public void setChucDanh(String ChucDanh) {
        this.ChucDanh = ChucDanh;
    }

    public String getThoiGianNhan() {
        return ThoiGianNhan;
    }

    public void setThoiGianNhan(String ThoiGian) {
        this.ThoiGianNhan = ThoiGian;
    }
    
    
}
