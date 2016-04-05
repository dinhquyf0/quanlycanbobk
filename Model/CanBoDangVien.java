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
public class CanBoDangVien extends DBConnect{   
    String Stt;
    String ma_canbo;
    String SoTienThu;
    String ThoiGianDong;
    private final String GET_BY_ID = "select * from canbo_dangvien where ma_canbo =?";
    private final String GET_ALL = "select * from canbo_dangvien";
    private final String ADD_DATA = "insert into "
            + "canbo_dangvien(Stt,ma_canbo,SoTienThu,ThoiGianDong)"
            + "values (?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "canbo_dangvien set ma_canbo=?,SoTienThu=?,ThoiGianDong=? where Stt=?";
    private final String REMOVE_DATA = "Delete from canbo_dangvien where Stt=?";

    public ArrayList<CanBoDangVien> getByID(String id){
        ArrayList<CanBoDangVien> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                CanBoDangVien item = new CanBoDangVien();
                item.setStt(rs.getString("Stt"));
                item.setma_canbo(rs.getString("ma_canbo"));
                item.setSoTienThu(rs.getString("SoTienThu"));
                item.setThoiGianDong(rs.getString("ThoiGianDong"));

                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public ArrayList<CanBoDangVien> getALL() {
        ArrayList<CanBoDangVien> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    CanBoDangVien item = new CanBoDangVien();
                    item.setStt(rs.getString("Stt"));
                    item.setma_canbo(rs.getString("ma_canbo"));
                    item.setSoTienThu(rs.getString("SoTienThu"));
                    item.setThoiGianDong(rs.getString("ThoiGianDong"));
                                     
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(CanBoDangVien cbdv){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, cbdv.getStt());
            ps.setString(2, cbdv.getma_canbo());
            ps.setString(3, cbdv.getSoTienThu());
            ps.setString(4, cbdv.getThoiGianDong());

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
   
    public boolean Update(CanBoDangVien cbdv){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, cbdv.getma_canbo());
            ps.setString(2, cbdv.getSoTienThu());
            ps.setString(3, cbdv.getThoiGianDong());
            ps.setString(4, cbdv.getStt());
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
//    public CanBoDangVien(int Stt, int ma_canbo, int SoTienThu, int ThoiGianDong) {
//        
//        this.Stt = Stt;
//        this.ma_canbo = ma_canbo;
//        this.SoTienThu = SoTienThu;
//        this.ThoiGianDong = this.ThoiGianDong;
//    }

    public String getStt() {
        return Stt;
    }

    public void setStt(String Stt) {
        this.Stt = Stt;
    }

    public String getma_canbo() {
        return ma_canbo;
    }

    public void setma_canbo(String ma_canbo) {
        this.ma_canbo = ma_canbo;
    }

    public String getSoTienThu() {
        return SoTienThu;
    }

    public void setSoTienThu(String SoTienThu) {
        this.SoTienThu = SoTienThu;
    }

    public String getThoiGianDong() {
        return ThoiGianDong;
    }

    public void setThoiGianDong(String ThoiGianDong) {
        this.ThoiGianDong = ThoiGianDong;
    }
    
    
    
}

