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
public class ChamThi extends DBConnect{
    String Ma_ChamThi;
    String Ma_lop;
    String ma_canbo;
    String Ma_MH;
    String NgayNop;
    String SoBaiThi;
    private final String GET_SoBaiThi = "select SoBaiThi from cham_thi where ma_canbo =? and year(NgayNop) = ? and month(NgayNop) =?";
    private final String GET_BY_IDCT = "select cham_thi.* from cham_thi, giang_day where cham_thi.Ma_MH = giang_day.Ma_MH and giang_day.Ma_MH =?";
    private final String GET_BY_ID_CB ="select * from cham_thi where ma_canbo = ? ";
    private final String GET_ALL = "select * from cham_thi";
    private final String ADD_DATA = "insert into "
            + "cham_thi(Ma_ChamThi,Ma_lop,ma_canbo,Ma_MH,NgayNop,SoBaiThi)"
            + "values (?,?,?,?,?,?)";
    private final String UPDATE_DATA = "Update "
            + "cham_thi set Ma_lop=?,ma_canbo=?,Ma_MH=?,NgayNop=?,SoBaiThi=? where Ma_ChamThi=?";
    private final String REMOVE_DATA = "Delete from cham_thi where Ma_ChamThi=?";

      public ArrayList<ChamThi> getByIDCB(String s){
        ArrayList<ChamThi> objs = new ArrayList<>();
        try{
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_CB);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next() ){
                    ChamThi item = new ChamThi();
                    item.setMa_ChamThi(rs.getString("Ma_ChamThi"));
                    item.setMa_lop(rs.getString("Ma_lop"));
                    item.setma_canbo(rs.getString("ma_canbo"));
                    item.setMa_MH(rs.getString("Ma_MH"));
                    item.setNgayNop(rs.getString("NgayNop"));
                    item.setSoBaiThi(rs.getString("SoBaiThi"));
                objs.add(item);
            }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return objs;
    }
    
    public String getSoBaiThi(String id, String Nam, String Thang){
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_SoBaiThi);
            ps.setString(1, id);
            ps.setString(2, Nam);
            ps.setString(3, Thang);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                SoBaiThi=rs.getString("SoBaiThi");
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SoBaiThi;
    }
  public ArrayList<ChamThi> getByIDCT(String s){
        ArrayList<ChamThi> objs = new ArrayList<>();
        try{
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_IDCT);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next() ){
                ChamThi item = new ChamThi();
                item.setSoBaiThi(rs.getString("SoBaiThi"));
                item.setNgayNop(rs.getString("NgayNop"));
                objs.add(item);
            }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return objs;
    }
    public ArrayList<ChamThi> getALL() {
        ArrayList<ChamThi> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ChamThi item = new ChamThi();
                    item.setMa_ChamThi(rs.getString("Ma_ChamThi"));
                    item.setMa_lop(rs.getString("Ma_lop"));
                    item.setma_canbo(rs.getString("ma_canbo"));
                    item.setMa_MH(rs.getString("Ma_MH"));
                    item.setNgayNop(rs.getString("NgayNop"));
                    item.setSoBaiThi(rs.getString("SoBaiThi"));
                                     
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(ChamThi cthi){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, cthi.getMa_ChamThi());
            ps.setString(2, cthi.getMa_lop());
            ps.setString(3, cthi.getma_canbo());
            ps.setString(4, cthi.getMa_MH());
            ps.setString(5, cthi.getNgayNop());
            ps.setString(6, cthi.getSoBaiThi());
            
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
   
    public boolean Update(ChamThi cthi){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, cthi.getMa_lop());
            ps.setString(2, cthi.getma_canbo());
            ps.setString(3, cthi.getMa_MH());
            ps.setString(4, cthi.getNgayNop());
            ps.setString(5, cthi.getSoBaiThi());
            ps.setString(6, cthi.getMa_ChamThi());
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
//    public ChamThi(int Ma_ChamThi, int Ma_lop, int ma_canbo, int Ma_MH, String NgayNop, int SoBaiThi) {
//        this.Ma_ChamThi = Ma_ChamThi;
//        this.Ma_lop = Ma_lop;
//        this.ma_canbo = ma_canbo;
//        this.Ma_MH = Ma_MH;
//        this.NgayNop = NgayNop;
//        this.SoBaiThi = SoBaiThi;
//    }

    public String getMa_ChamThi() {
        return Ma_ChamThi;
    }

    public void setMa_ChamThi(String Ma_ChamThi) {
        this.Ma_ChamThi = Ma_ChamThi;
    }

    public String getMa_lop() {
        return Ma_lop;
    }

    public void setMa_lop(String Ma_lop) {
        this.Ma_lop = Ma_lop;
    }

    public String getma_canbo() {
        return ma_canbo;
    }

    public void setma_canbo(String ma_canbo) {
        this.ma_canbo = ma_canbo;
    }

    public String getMa_MH() {
        return Ma_MH;
    }

    public void setMa_MH(String Ma_MH) {
        this.Ma_MH = Ma_MH;
    }

    public String getNgayNop() {
        return NgayNop;
    }

    public void setNgayNop(String NgayNop) {
        this.NgayNop = NgayNop;
    }

    public String getSoBaiThi() {
        return SoBaiThi;
    }

    public void setSoBaiThi(String SoBaiThi) {
        this.SoBaiThi = SoBaiThi;
    }
    
    
}
