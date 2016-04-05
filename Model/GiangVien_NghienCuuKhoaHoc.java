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
public class GiangVien_NghienCuuKhoaHoc extends DBConnect{
    String stt;
    String ma_canbo;
    String Ma_DT;
    
    private final String GET_ALL_GVNCKH = "select * from giangvien_nckh";
    private final String GET_BY_ID_GVNCKH = "select * from giangvien_nckh where Stt=?";
    private final String ADD_DATA_GVNCKH ="insert into giangvien_nckh(Stt,ma_canbo,Ma_DeTai) value (?,?,?)";
    private final String UPDATE_DATA_GVNCKH = "update giangvien_nckh set ma_canbo =?,Ma_DeTai=? where Stt=?";
    private final String REMOVE_DATA_GVNCKH ="Delete from giangvien_nckh where Stt=?";
   
    public ArrayList<GiangVien_NghienCuuKhoaHoc> getByIDGVDT(String id){
        ArrayList<GiangVien_NghienCuuKhoaHoc> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_GVNCKH);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null){
                while( rs.next()){
                GiangVien_NghienCuuKhoaHoc item = new GiangVien_NghienCuuKhoaHoc();
                item.setstt(rs.getString("Stt"));
                item.setma_canbo(rs.getString("ma_canbo"));
                item.setMa_DT(rs.getString("Ma_DeTai"));
                                            
                objs.add(item);
                }
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs; 
    }
    
    public ArrayList<GiangVien_NghienCuuKhoaHoc> getALLGVDT(){
        ArrayList<GiangVien_NghienCuuKhoaHoc> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL_GVNCKH);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    GiangVien_NghienCuuKhoaHoc item = new GiangVien_NghienCuuKhoaHoc();
                    
                item.setstt(rs.getString("Stt"));
                item.setma_canbo(rs.getString("ma_canbo"));
                item.setMa_DT(rs.getString("Ma_DeTai"));
                    
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddDataGVDT(GiangVien_NghienCuuKhoaHoc gvnckh){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA_GVNCKH);
            ps.setString(1, gvnckh.getstt());
            ps.setString(2, gvnckh.getma_canbo());
            ps.setString(3, gvnckh.getMa_DT());
            
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
    
    public boolean DeleteDataGVDT(String u){
       boolean check = false;
       try {
           getConnect();
            PreparedStatement ps = con.prepareStatement(REMOVE_DATA_GVNCKH);
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
    
    public boolean UpdateGVDT(GiangVien_NghienCuuKhoaHoc gvnckh){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA_GVNCKH);
            ps.setString(1, gvnckh.getma_canbo());
            ps.setString(2, gvnckh.getMa_DT());
            ps.setString(3, gvnckh.getstt());
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
    
    
    public String getma_canbo(){
        return ma_canbo;
    }

    public void setma_canbo(String ma_canbo) {
        this.ma_canbo = ma_canbo;
    }

    public String getstt() {
        return stt;
    }

    public void setstt(String stt) {
        this.stt = stt;
    }

    public String getMa_DT() {
        return Ma_DT;
    }

    public void setMa_DT(String Ma_DT) {
        this.Ma_DT = Ma_DT;
    }
}
