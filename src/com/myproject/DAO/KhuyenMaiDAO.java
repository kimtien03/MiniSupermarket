package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.KhuyenMaiDTO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class KhuyenMaiDAO extends conndb{
    public ArrayList<KhuyenMaiDTO> getAllKM() {
        ArrayList<KhuyenMaiDTO> arr = new ArrayList<>();
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM KHUYENMAI";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                    KhuyenMaiDTO p = new KhuyenMaiDTO();
                    p.setMaKM(rs.getString("MaKM"));
                    p.setNgBD(rs.getDate("NgBatDauKM"));
                    p.setNgKT(rs.getDate("NgKetThucKM"));
                    p.setTiLeGiam(rs.getFloat("TiLeGiam"));
                    p.setTinhTrang(rs.getBoolean("TinhTrang"));
                    p.setMoTa(rs.getString("MoTa"));
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
