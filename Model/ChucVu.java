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
public class ChucVu extends DBConnect{
    String Stt;
    String Ma_CB;
    String ChucVu;
    String ThoiGianNhan;
    private final String GET_BY_ID = "select * from chuc_vu where Ma_CB =?";
    private final String GET_BY_ID_AND_TIME = "select * from chuc_vu where Ma_CB =? ";
    private final String GET_ALL = "select * from chuc_vu";
    private final String ADD_DATA = "insert into "
            + "chuc_vu(Stt,Ma_CB,ChucVu,ThoiGian)"
            + "values (?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "chuc_vu set Ma_CB = ?,ChucVu=?,ThoiGian=? where Stt=?";
    private final String REMOVE_DATA = "Delete from chuc_vu where Stt=?";
    
    public String getChucVuByTime(String id){
        String chucvu ="";
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_AND_TIME);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null ){
                while (rs.next()) {
                    chucvu = rs.getString("ChucVu");
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucvu;
    }
    
    public ArrayList<ChucVu> getByID(String id){
        ArrayList<ChucVu> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null){
                ChucVu item = new ChucVu();
                while(rs.next()){
                
                item.setStt(rs.getString("Stt"));
                item.setMa_CB(rs.getString("Ma_CB"));
                item.setChucVu(rs.getString("ChucVu"));
                item.setThoiGianNhan(rs.getString("ThoiGian"));
                }                
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<ChucVu> getALL() {
        ArrayList<ChucVu> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ChucVu item = new ChucVu();
                    item.setStt(rs.getString("Stt"));
                    item.setMa_CB(rs.getString("Ma_CB"));
                    item.setChucVu(rs.getString("ChucVu"));
                    item.setThoiGianNhan(rs.getString("ThoiGian"));
                    
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(ChucVu cv){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, cv.Stt);
            ps.setString(2, cv.getMa_CB());
            ps.setString(3, cv.getChucVu());
            ps.setString(4, cv.getThoiGianNhan());
            
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
   
    public boolean Update(ChucVu cv){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1,cv.getMa_CB() );
            ps.setString(2,cv.getChucVu() );
            ps.setString(3,cv.getThoiGianNhan());
            ps.setString(4,cv.getStt());
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
//    public ChucVu(int Ma_CB, String ChucVu, String ThoiGianNhan, String PhuCap_ChucVu) {
//        this.Ma_CB = Ma_CB;
//        this.ChucVu = ChucVu;
//        this.ThoiGianNhan = ThoiGianNhan;
//        this.PhuCap_ChucVu = PhuCap_ChucVu;
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

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getThoiGianNhan() {
        return ThoiGianNhan;
    }

    public void setThoiGianNhan(String ThoiGianNhan) {
        this.ThoiGianNhan = ThoiGianNhan;
    }

    
    
}
