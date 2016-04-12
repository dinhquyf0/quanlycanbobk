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
public class NghienCuuKhoaHoc extends DBConnect{
    String Ma_DT;
    String TenDeTai;
    String Cap;
    String KinhPhi;
    String ThoiGianBatDau;
    String ThoiGianKetThuc;
    String ChuTriDeTai;
    String TinhTrang;
    String KetQua;
    private final String GET_BY_IDCB ="select ngiencuu_khoahoc.* from canbo, giangvien_nckh ,ngiencuu_khoahoc where ngiencuu_khoahoc.Ma_DT = giangvien_nckh.Ma_DeTai and giangvien_nckh.ma_canbo = canbo.Ma_CB and canbo.Ma_CB =?";
    private final String GET_ALL = "select * from ngiencuu_khoahoc";
    private final String ADD_DATA = "insert into "
            + "ngiencuu_khoahoc(Ma_DT,TenDeTai,Cap,KinhPhi,ThoiGianBatDau,ThoiGianKetThuc,ChuTriDeTai,TinhTrang,KetQua)"
            + "values (?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "ngiencuu_khoahoc set TenDeTai =?,Cap=?,KinhPhi=?,ThoiGianBatDau=?,ThoiGianKetThuc=?,ChuTriDeTai=?,TinhTrang=?,KetQua=? where Ma_DT=?";
    private final String REMOVE_DATA = "Delete from ngiencuu_khoahoc where Ma_DT=?";
    
    public ArrayList<NghienCuuKhoaHoc> getByIDCB(String id){
        ArrayList<NghienCuuKhoaHoc> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_IDCB);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null){
                while( rs.next()){
                NghienCuuKhoaHoc item = new NghienCuuKhoaHoc();
                
                    item.setMa_DT(rs.getString("Ma_DT"));
                    item.setTenDeTai(rs.getString("TenDeTai"));
                    item.setCap(rs.getString("Cap"));
                    item.setKinhPhi(rs.getString("KinhPhi"));
                    item.setThoiGianBatDau(rs.getString("ThoiGianBatDau"));
                    item.setThoiGianKetThuc(rs.getString("ThoiGianKetThuc"));
                    item.setChuTriDeTai(rs.getString("ChuTriDeTai"));
                    item.setTinhTrang(rs.getString("TinhTrang"));
                    item.setKetQua(rs.getString("KetQua"));
                    
                objs.add(item);
                }
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public ArrayList<NghienCuuKhoaHoc> getALL() {
        ArrayList<NghienCuuKhoaHoc> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    NghienCuuKhoaHoc item = new NghienCuuKhoaHoc();
                    item.setMa_DT(rs.getString("Ma_DT"));
                    item.setTenDeTai(rs.getString("TenDeTai"));
                    item.setCap(rs.getString("Cap"));
                    item.setKinhPhi(rs.getString("KinhPhi"));
                    item.setThoiGianBatDau(rs.getString("ThoiGianBatDau"));
                    item.setThoiGianKetThuc(rs.getString("ThoiGianKetThuc"));
                    item.setChuTriDeTai(rs.getString("ChuTriDeTai"));
                    item.setTinhTrang(rs.getString("TinhTrang"));
                    item.setKetQua(rs.getString("KetQua"));
                                        
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(NghienCuuKhoaHoc cbo){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, cbo.getMa_DT());
            ps.setString(2, cbo.getTenDeTai());
            ps.setString(3, cbo.getCap());
            ps.setString(4, cbo.getKinhPhi());
            ps.setString(5, cbo.getThoiGianBatDau());
            ps.setString(6, cbo.getThoiGianKetThuc());
            ps.setString(7, cbo.getChuTriDeTai());
            ps.setString(8, cbo.getTinhTrang());
            ps.setString(9, cbo.getKetQua());

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
   
    public boolean Update(NghienCuuKhoaHoc cbo){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, cbo.getTenDeTai());
            ps.setString(2, cbo.getCap());
            ps.setString(3, cbo.getKinhPhi());
            ps.setString(4, cbo.getThoiGianBatDau());
            ps.setString(5, cbo.getThoiGianKetThuc());
            ps.setString(6, cbo.getChuTriDeTai());
            ps.setString(7, cbo.getTinhTrang());
            ps.setString(8, cbo.getKetQua());
            ps.setString(9, cbo.getMa_DT());
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
//    public NghienCuuKhoaHoc(int Ma_DT, String TenDeTai, String Cap, int KinhPhi, String ThoiGianBatDau, String ThoiGianKetThuc, String ChuTriDeTai, String TinhTrang, String KetQua) {
//        this.Ma_DT = Ma_DT;
//        this.TenDeTai = TenDeTai;
//        this.Cap = Cap;
//        this.KinhPhi = KinhPhi;
//        this.ThoiGianBatDau = ThoiGianBatDau;
//        this.ThoiGianKetThuc = ThoiGianKetThuc;
//        this.ChuTriDeTai = ChuTriDeTai;
//        this.TinhTrang = TinhTrang;
//        this.KetQua = KetQua;
//    }

    public String getMa_DT() {
        return Ma_DT;
    }

    public void setMa_DT(String Ma_DT) {
        this.Ma_DT = Ma_DT;
    }

    public String getTenDeTai() {
        return TenDeTai;
    }

    public void setTenDeTai(String TenDeTai) {
        this.TenDeTai = TenDeTai;
    }

    public String getCap() {
        return Cap;
    }

    public void setCap(String Cap) {
        this.Cap = Cap;
    }

    public String getKinhPhi() {
        return KinhPhi;
    }

    public void setKinhPhi(String KinhPhi) {
        this.KinhPhi = KinhPhi;
    }

    public String getThoiGianBatDau() {
        return ThoiGianBatDau;
    }

    public void setThoiGianBatDau(String ThoiGianBatDau) {
        this.ThoiGianBatDau = ThoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return ThoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String ThoiGianKetThuc) {
        this.ThoiGianKetThuc = ThoiGianKetThuc;
    }

    public String getChuTriDeTai() {
        return ChuTriDeTai;
    }

    public void setChuTriDeTai(String ChuTriDeTai) {
        this.ChuTriDeTai = ChuTriDeTai;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getKetQua() {
        return KetQua;
    }

    public void setKetQua(String KetQua) {
        this.KetQua = KetQua;
    }
    
    
}
