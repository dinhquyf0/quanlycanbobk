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
public class BaiBaoTapChi extends DBConnect{
    String Ma_BaiBao;
    String TenTapChi;
    String So;
    String ThoiGianXuatBan;
    String ChiSo_ISSN;
    String HeSo_IF;
    
    private final String GET_BY_ID = "select tap_chi.* from canbo, giangvien_tapchi ,tap_chi where tap_chi.Ma_BaiBao = giangvien_tapchi.Ma_BaiBao and giangvien_tapchi.Ma_CB = canbo.Ma_CB and canbo.Ma_CB =?";
    private final String GET_ALL = "select * from tap_chi";
    private final String ADD_DATA = "insert into "
            + "tap_chi(Ma_BaiBao,TenTapChi,So,ThoiGianXuatBan,ChiSo_ISSN,HeSo_IF)"
            + "values (?,?,?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "tap_chi set TenTapChi=?,So=?,ThoiGianXuatBan=?,ChiSo_ISSN=?,HeSo_IF=? where Ma_BaiBao=?";
    private final String REMOVE_DATA = "Delete from tap_chi where Ma_BaiBao=?";

    public ArrayList<BaiBaoTapChi> getByID(String id){
        ArrayList<BaiBaoTapChi> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                BaiBaoTapChi item = new BaiBaoTapChi();
                item.setMa_BaiBao(rs.getString("Ma_BaiBao"));
                item.setTenTapChi(rs.getString("TenTapChi"));
                item.setSo(rs.getString("So"));
                item.setThoiGianXuatBan(rs.getString("ThoiGianXuatBan"));
                item.setChiSo_ISSN(rs.getString("ChiSo_ISSN"));
                item.setHeSo_IF(rs.getString("HeSo_IF"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public ArrayList<BaiBaoTapChi> getALL() {
        ArrayList<BaiBaoTapChi> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    BaiBaoTapChi item = new BaiBaoTapChi();
                    item.setMa_BaiBao(rs.getString("Ma_BaiBao"));
                    item.setTenTapChi(rs.getString("TenTapChi"));
                    item.setSo(rs.getString("So"));
                    item.setThoiGianXuatBan(rs.getString("ThoiGianXuatBan"));
                    item.setChiSo_ISSN(rs.getString("ChiSo_ISSN"));
                    item.setHeSo_IF(rs.getString("HeSo_IF"));
                                     
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(BaiBaoTapChi bbt){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, bbt.getMa_BaiBao());
            ps.setString(2, bbt.getTenTapChi());
            ps.setString(3, bbt.getSo());
            ps.setString(4, bbt.getThoiGianXuatBan());
            ps.setString(5, bbt.getChiSo_ISSN());
            ps.setString(6, bbt.getHeSo_IF());
            
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
   
    public boolean Update(BaiBaoTapChi bbt){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, bbt.getTenTapChi());
            ps.setString(2, bbt.getSo());
            ps.setString(3, bbt.getThoiGianXuatBan());
            ps.setString(4, bbt.getChiSo_ISSN());
            ps.setString(5, bbt.getHeSo_IF());
            ps.setString(6, bbt.getMa_BaiBao());
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
    
    public String getMa_BaiBao() {
        return Ma_BaiBao;
    }

    public void setMa_BaiBao(String Ma_BaiBao) {
        this.Ma_BaiBao = Ma_BaiBao;
    }

    public String getTenTapChi() {
        return TenTapChi;
    }

    public void setTenTapChi(String TenTapChi) {
        this.TenTapChi = TenTapChi;
    }

    public String getSo() {
        return So;
    }

    public void setSo(String So) {
        this.So = So;
    }

    public String getThoiGianXuatBan() {
        return ThoiGianXuatBan;
    }

    public void setThoiGianXuatBan(String ThoiGianXuatBan) {
        this.ThoiGianXuatBan = ThoiGianXuatBan;
    }

    public String getChiSo_ISSN() {
        return ChiSo_ISSN;
    }

    public void setChiSo_ISSN(String ChiSo_ISSN) {
        this.ChiSo_ISSN = ChiSo_ISSN;
    }

    public String getHeSo_IF() {
        return HeSo_IF;
    }

    public void setHeSo_IF(String HeSo_IF) {
        this.HeSo_IF = HeSo_IF;
    }
    
    
}
