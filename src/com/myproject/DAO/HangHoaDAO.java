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
                String sql = 
                "SELECT hanghoa.mahh, hanghoa.tenhh, SUM(ct_hanghoa.soluong) AS 'soluong'\n" +
                "FROM hanghoa\n" +
                "INNER JOIN ct_hanghoa ON hanghoa.mahh = ct_hanghoa.mahh\n" +
                "WHERE hanghoa.tinhtrang = 1 AND ct_hanghoa.tinhtrang = 1\n" +
                "GROUP BY hanghoa.mahh, hanghoa.tenhh\n" +
                "UNION ALL\n" +
                "SELECT hanghoa.mahh, hanghoa.tenhh, 0 AS soluong\n" +
                "FROM hanghoa\n" +
                "WHERE hanghoa.tinhtrang = 1 and hanghoa.mahh NOT IN \n" +
                "(SELECT hanghoa.mahh\n" +
                "FROM hanghoa\n" +
                "INNER JOIN ct_hanghoa ON hanghoa.mahh = ct_hanghoa.mahh\n" +
                "WHERE hanghoa.tinhtrang = 1 AND ct_hanghoa.tinhtrang = 1\n" +
                "GROUP BY hanghoa.mahh, hanghoa.tenhh) order by mahh";
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
