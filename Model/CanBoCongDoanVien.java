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
public class CanBoCongDoanVien extends DBConnect{   
    String Stt;
    String ma_canbo;
    String SoTienDong;
    String ThoiGianDong;

    private final String GET_BY_ID = "select * from canbo_congdoanvien where ma_canbo =?";
    private final String GET_ALL = "select * from canbo_congdoanvien";
    private final String ADD_DATA = "insert into "
            + "canbo_congdoanvien(Stt,ma_canbo,SoTienDong,ThoiGianDong)"
            + "values (?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "canbo_congdoanvien set ma_canbo=?,SoTienDong=?,ThoiGianDong=? where Stt=?";
    private final String REMOVE_DATA = "Delete from canbo_congdoanvien where Stt=?";

    public ArrayList<CanBoCongDoanVien> getByID(String id){
        ArrayList<CanBoCongDoanVien> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                CanBoCongDoanVien item = new CanBoCongDoanVien();
                item.setStt(rs.getString("Stt"));
                item.setma_canbo(rs.getString("ma_canbo"));
                item.setSoTienDong(rs.getString("SoTienDong"));
                item.setThoiGianDong(rs.getString("ThoiGianDong"));

                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public ArrayList<CanBoCongDoanVien> getALL() {
        ArrayList<CanBoCongDoanVien> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    CanBoCongDoanVien item = new CanBoCongDoanVien();
                    item.setStt(rs.getString("Stt"));
                    item.setma_canbo(rs.getString("ma_canbo"));
                    item.setSoTienDong(rs.getString("SoTienDong"));
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
    
    public boolean AddData(CanBoCongDoanVien cbc){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, cbc.getStt());
            ps.setString(2, cbc.getma_canbo());
            ps.setString(3, cbc.getSoTienDong());
            ps.setString(4, cbc.getThoiGianDong());

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
   
    public boolean Update(CanBoCongDoanVien cbc){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, cbc.getma_canbo());
            ps.setString(2, cbc.getSoTienDong());
            ps.setString(3, cbc.getThoiGianDong());
            ps.setString(4, cbc.getStt());
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
//    public CanBoCongDoanVien(int Stt, int ma_canbo, int SoTienDong, String ThoiGianDong) {
//        this.Stt = Stt;
//        this.ma_canbo = ma_canbo;
//        this.SoTienDong = SoTienDong;
//        this.ThoiGianDong = ThoiGianDong;
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

    public String getSoTienDong() {
        return SoTienDong;
    }

    public void setSoTienDong(String SoTienDong) {
        this.SoTienDong = SoTienDong;
    }

    public String getThoiGianDong() {
        return ThoiGianDong;
    }

    public void setThoiGianDong(String ThoiGianDong) {
        this.ThoiGianDong = ThoiGianDong;
    }
    

}
