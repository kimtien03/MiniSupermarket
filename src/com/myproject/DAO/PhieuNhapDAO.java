package com.myproject.DAO;

import com.myproject.DTO.PhieuNhapDTO;
import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PhieuNhapDAO extends conndb{
    public ArrayList<PhieuNhapDTO> getAllPN() {
       ArrayList<PhieuNhapDTO> arr = new ArrayList<>();
       if(openConnection()) {
           try {
               String sql = "SELECT * FROM PHIEUNHAP";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               System.out.println(rs.next());
               while(rs.next()) {
                   PhieuNhapDTO p = new PhieuNhapDTO();
                   p.setMaPN(rs.getString("MaPhieuNhap"));
                   p.setMaNV(rs.getString("MaNV"));
                   p.setNgLapPhieu(rs.getTimestamp("NgLapPhieu"));
                   p.setThanhTien(rs.getFloat("ThanhTien"));
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
