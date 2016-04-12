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
public class CanBoDoanVien extends DBConnect{
    String Stt;
    String ma_canbo;
    String ThoiGian;
    String SoTien;
    private final String GET_BY_ID = "select * from canbo_doanvien where Stt =?";
    private final String GET_BY_ID_CB = "select * from canbo_doanvien where ma_canbo =?";
    private final String GET_ALL = "select * from canbo_doanvien";
    private final String GET_BY_TIME = "select * from canbo_doanvien where year(ThoiGian)=? and month(ThoiGian) =?";
    private final String ADD_DATA = "insert into "
            + "canbo_doanvien(Stt,ma_canbo,SoTien,ThoiGian)"
            + "values (?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "canbo_doanvien set ma_canbo=?,SoTien=?,ThoiGian=? where Stt=?";
    private final String REMOVE_DATA = "Delete from canbo_doanvien where Stt=?";

    
    public ArrayList<CanBoDoanVien> getByTIME(String year, String month){
        ArrayList<CanBoDoanVien> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_TIME);
            ps.setString(1, year);
            ps.setString(2, month);
            ResultSet rs = ps.executeQuery();
            if(rs!= null){
                while (rs.next()) {
                    CanBoDoanVien item = new CanBoDoanVien();
                    item.setStt(rs.getString("Stt"));
                    item.setma_canbo(rs.getString("ma_canbo"));
                    item.setSoTien(rs.getString("SoTien"));
                    item.setThoiGian(rs.getString("ThoiGian"));

                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<CanBoDoanVien> getByIDCB(String id){
        ArrayList<CanBoDoanVien> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_CB);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                CanBoDoanVien item = new CanBoDoanVien();
                item.setStt(rs.getString("Stt"));
                item.setma_canbo(rs.getString("ma_canbo"));
                item.setSoTien(rs.getString("SoTien"));
                item.setThoiGian(rs.getString("ThoiGian"));
                
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<CanBoDoanVien> getByID(String id){
        ArrayList<CanBoDoanVien> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                CanBoDoanVien item = new CanBoDoanVien();
                item.setStt(rs.getString("Stt"));
                item.setma_canbo(rs.getString("ma_canbo"));
                item.setSoTien(rs.getString("SoTien"));
                item.setThoiGian(rs.getString("ThoiGian"));
                
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public ArrayList<CanBoDoanVien> getALL() {
        ArrayList<CanBoDoanVien> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    CanBoDoanVien item = new CanBoDoanVien();
                    item.setStt(rs.getString("Stt"));
                    item.setma_canbo(rs.getString("ma_canbo"));
                    item.setSoTien(rs.getString("SoTien"));
                    item.setThoiGian(rs.getString("ThoiGian"));
                                     
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(CanBoDoanVien cbdv){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, cbdv.getStt());
            ps.setString(2, cbdv.getma_canbo());
            ps.setString(3, cbdv.getSoTien());
            ps.setString(4, cbdv.getThoiGian());
            

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
   
    public boolean Update(CanBoDoanVien cbdv){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, cbdv.getma_canbo());
            ps.setString(2, cbdv.getSoTien());
            ps.setString(3, cbdv.getThoiGian());
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
//    public CanBoDoanVien(int Stt, String ma_canbo, String ThoiGian, int SoTien) {
//        this.Stt = Stt;
//        this.ma_canbo = ma_canbo;
//        this.ThoiGian = ThoiGian;
//        this.SoTien = SoTien;
//        
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

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public String getSoTien() {
        return SoTien;
    }

    public void setSoTien(String SoTien) {
        this.SoTien = SoTien;
    }

    


}
