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
public class GiaoTrinh extends DBConnect{
    String Ma_GT;
    String TenGiaoTrinh;
    String TenTacGia;
    String NamXuatBan;
    String NhaXuatBan;
    private final String GET_BY_ID = "select * from giao_trinh where Ma_GT =?";
    private final String GET_BY_ID_CB ="select giao_trinh.* from canbo, giangvien_giaotrinh ,giao_trinh where giao_trinh.Ma_GT = giangvien_giaotrinh.Ma_GT and giangvien_giaotrinh.Ma_CB = canbo.Ma_CB and canbo.Ma_CB =?";
    private final String GET_ALL = "select * from giao_trinh";
    private final String ADD_DATA = "insert into "
            + "giao_trinh(Ma_GT,TenGiaoTrinh,TenTacGia,NamXuatBan,NhaXuatBan)"
            + "values (?,?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "giao_trinh set TenGiaoTrinh=?,TenTacGia=?,NamXuatBan=?,NhaXuatBan=? where Ma_GT=?";
    private final String REMOVE_DATA = "Delete from giao_trinh where Ma_GT=?";

    public ArrayList<GiaoTrinh> getByIDCB(String id){
        ArrayList<GiaoTrinh> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_CB);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                GiaoTrinh item = new GiaoTrinh();
                
                item.setMa_GT(rs.getString("Ma_GT"));
                item.setTenGiaoTrinh(rs.getString("TenGiaoTrinh"));
                item.setTenTacGia(rs.getString("TenTacGia"));
                item.setNamXuatBan(rs.getString("NamXuatBan"));
                item.setNhaXuatBan(rs.getString("NhaXuatBan"));
                                
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<GiaoTrinh> getByID(String id){
        ArrayList<GiaoTrinh> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                GiaoTrinh item = new GiaoTrinh();
                
                item.setMa_GT(rs.getString("Ma_GT"));
                item.setTenGiaoTrinh(rs.getString("TenGiaoTrinh"));
                item.setTenTacGia(rs.getString("TenTacGia"));
                item.setNamXuatBan(rs.getString("NamXuatBan"));
                item.setNhaXuatBan(rs.getString("NhaXuatBan"));
                                
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public ArrayList<GiaoTrinh> getALL() {
        ArrayList<GiaoTrinh> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    GiaoTrinh item = new GiaoTrinh();
                    
                    item.setMa_GT(rs.getString("Ma_GT"));
                    item.setTenGiaoTrinh(rs.getString("TenGiaoTrinh"));
                    item.setTenTacGia(rs.getString("TenTacGia"));
                    item.setNamXuatBan(rs.getString("NamXuatBan"));
                    item.setNhaXuatBan(rs.getString("NhaXuatBan"));
                    
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(GiaoTrinh gt){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, gt.getMa_GT());
            ps.setString(2, gt.getTenGiaoTrinh());
            ps.setString(3, gt.getTenTacGia());
            ps.setString(4, gt.getNamXuatBan());
            ps.setString(5, gt.getNhaXuatBan());
            
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
   
    public boolean Update(GiaoTrinh gt){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, gt.getTenGiaoTrinh());
            ps.setString(2, gt.getTenTacGia());
            ps.setString(3, gt.getNamXuatBan());
            ps.setString(4, gt.getNhaXuatBan());
            ps.setString(5, gt.getMa_GT());
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

    public String getMa_GT() {
        return Ma_GT;
    }

    public void setMa_GT(String Ma_GT) {
        this.Ma_GT = Ma_GT;
    }

    public String getTenGiaoTrinh() {
        return TenGiaoTrinh;
    }

    public void setTenGiaoTrinh(String TenGiaoTrinh) {
        this.TenGiaoTrinh = TenGiaoTrinh;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String TenTacGia) {
        this.TenTacGia = TenTacGia;
    }
    
    public String getNamXuatBan() {
        return NamXuatBan;
    }

    public void setNamXuatBan(String NamXuatBan) {
        this.NamXuatBan = NamXuatBan;
    }

    public String getNhaXuatBan() {
        return NhaXuatBan;
    }

    public void setNhaXuatBan(String NhaXuatBan) {
        this.NhaXuatBan = NhaXuatBan;
    }
    
    
}
