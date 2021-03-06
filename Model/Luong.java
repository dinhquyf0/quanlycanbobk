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
public class Luong extends DBConnect{
    String Stt;
    String ma_canbo;
    String HeSoLuong;
    String ThoiGianBatDau;
    private final String GET_BY_ID = "select * from luong where ma_canbo =?";
    private final String GET_ALL = "select * from luong";
    private final String GET_ID_CB = "select HeSoLuong from luong where ma_canbo = ?";
    private final String GET_BY_TIME = "select * from luong where year(ThoiGianBatDau) = ? and month(ThoiGianBatDau) =?";
    private final String ADD_DATA = "insert into "
            + "luong(Stt,ma_canbo,HeSoLuong,ThoiGianBatDau)"
            + "values (?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "luong set ma_canbo=?,HeSoLuong=?,ThoiGianBatDau=?where Stt=?";
    private final String REMOVE_DATA = "Delete from luong where Stt=?";
    
    public ArrayList<Luong> getByTime(String year,String month){
        ArrayList<Luong> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_TIME);
            ps.setString(1, year);
            ps.setString(2, month);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                Luong item = new Luong();
                
                item.setStt(rs.getString("Stt"));
                item.setma_canbo(rs.getString("ma_canbo"));
                item.setHeSoLuong(rs.getString("HeSoLuong"));
                item.setThoiGianBatDau(rs.getString("ThoiGianBatDau"));
                
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public double getHSL(String macb) {
        double hsl = 0.0;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ID_CB);
            ps.setString(1, macb);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {

                    String HSL = rs.getString("HeSoLuong");
                    hsl = Double.parseDouble(HSL);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hsl;
    }
    
    public ArrayList<Luong> getByID(String id){
        ArrayList<Luong> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null ){
                while (rs.next()){
                Luong item = new Luong();
                
                item.setStt(rs.getString("Stt"));
                item.setma_canbo(rs.getString("ma_canbo"));
                item.setHeSoLuong(rs.getString("HeSoLuong"));
                item.setThoiGianBatDau(rs.getString("ThoiGianBatDau"));
                
                objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public ArrayList<Luong> getALL() {
        ArrayList<Luong> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Luong item = new Luong();
                    
                    item.setStt(rs.getString("Stt"));
                    item.setma_canbo(rs.getString("ma_canbo"));
                    item.setHeSoLuong(rs.getString("HeSoLuong"));
                    item.setThoiGianBatDau(rs.getString("ThoiGianBatDau"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(Luong lg){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, lg.getStt());
            ps.setString(2, lg.getma_canbo());
            ps.setString(3, lg.getHeSoLuong());
            ps.setString(4, lg.getThoiGianBatDau());
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
   
    public boolean Update(Luong lg){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, lg.getma_canbo());
            ps.setString(2, lg.getHeSoLuong());
            ps.setString(3, lg.getThoiGianBatDau());
            ps.setString(4, lg.getStt());
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

    public void setStt(String Stt) {
        this.Stt = Stt;
    }

    public String getma_canbo() {
        return ma_canbo;
    }

    public void setma_canbo(String ma_canbo) {
        this.ma_canbo = ma_canbo;
    }

    public String getHeSoLuong() {
        return HeSoLuong;
    }

    public void setHeSoLuong(String HeSoLuong) {
        this.HeSoLuong = HeSoLuong;
    }

    public String getThoiGianBatDau() {
        return ThoiGianBatDau;
    }

    public void setThoiGianBatDau(String ThoiGianBatDau) {
        this.ThoiGianBatDau = ThoiGianBatDau;
    }
    
}
