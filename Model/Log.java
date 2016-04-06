/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author dinhq
 */
public class Log extends DBConnect{
    String Stt;
    String NoiDung;
    String ThoiGian;

    public String getStt() {
        return Stt;
    }

    public void setStt(String Stt) {
        this.Stt = Stt;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String ThoiGian) {
        this.ThoiGian = ThoiGian;
    }
    
    private final String GET_ALL = "select * from log";
    
    public ArrayList<Log> getALL(){
        ArrayList<Log> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if(rs != null ){
                while (rs.next()) {                    
                    Log item = new Log();
                    item.setNoiDung(rs.getString("NoiDung"));
                    objs.add(item);
                }
                    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    } 
    
    
}