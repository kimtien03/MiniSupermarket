package com.myproject.DAO;
import com.myproject.DTO.HH_CTHH_DTO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HangHoaDAO extends conndb{
    public ArrayList<HH_CTHH_DTO> getAllHHFormFixPN() {
        ArrayList<HH_CTHH_DTO> arr = new ArrayList<>();
        if(openConnection()) {
            try {
                String sql = "select ct_hanghoa.mahh,tenhh,sum(soluong) as 'soluong' from ct_hanghoa,hanghoa\n" +
                             "where hanghoa.tinhtrang = 1 and ct_hanghoa.tinhtrang = 1 and ct_hanghoa.mahh = hanghoa.mahh\n" +
                             "group by ct_hanghoa.mahh,tenhh";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                    HH_CTHH_DTO p = new HH_CTHH_DTO();
                    p.setMaHH(rs.getString("mahh"));
                    p.setTenHH(rs.getString("tenhh"));
                    p.setSoLuong(rs.getFloat("soluong"));
                    arr.add(p);
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }
    
}
