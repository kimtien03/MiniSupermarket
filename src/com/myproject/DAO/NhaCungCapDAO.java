package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.NhaCungCapDTO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NhaCungCapDAO extends conndb{

    public ArrayList<NhaCungCapDTO> getAllNCC() {
        ArrayList<NhaCungCapDTO> arr = new ArrayList<>();
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM NHACUNGCAP WHERE TINHTRANG = 1";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                    NhaCungCapDTO p = new NhaCungCapDTO();
                    p.setMaNCC(rs.getString("MaNCC"));
                    p.setTenNCC(rs.getString("TenNCC"));
                    p.setDiaChi(rs.getString("DiaChi"));
                    p.setEmail(rs.getString("Email"));
                    p.setSDT(rs.getString("SDT"));
                    p.setTinhTrang(rs.getBoolean("TinhTrang"));
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
