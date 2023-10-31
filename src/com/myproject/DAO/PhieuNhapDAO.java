package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.HangHoaDTO;
import com.myproject.DTO.PhieuNhapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class PhieuNhapDAO extends conndb{
    
    conndb ConPN = new conndb();
    
    public boolean insertPhieuNhap(PhieuNhapDTO pn) {
        boolean check = false;
        try {
            ConPN.openConnection();
            Connection con = ConPN.getConnection();
            String sql = "INSERT INTO PHIEUNHAP VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, pn.getMaPN());
            ps.setTimestamp(2, pn.getNgLapPhieu());
            ps.setBoolean(3, pn.isTinhTrang());
            ps.setString(4, pn.getMaNV());
            ps.setFloat(5, pn.getThanhTien());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
    public ArrayList<PhieuNhapDTO> getAllPN() {
        ArrayList<PhieuNhapDTO> listPN = new ArrayList<>();
        try {
            ConPN.openConnection();
            Connection con = ConPN.getConnection();
            String sql1 = "SELECT * FROM PHIEUNHAP";
            PreparedStatement stmt = con.prepareStatement(sql1);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PhieuNhapDTO pn = new PhieuNhapDTO();
                pn.setMaPN(rs.getString("MaPhieuNhap"));
                pn.setNgLapPhieu(rs.getTimestamp("NgLapPhieu"));
                pn.setTinhTrang(rs.getBoolean("TinhTrang"));
                pn.setMaNV(rs.getString("MaNV"));
                pn.setThanhTien(rs.getFloat("ThanhTien"));
                listPN.add(pn);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConPN.closeConnection();
        }
        return listPN;
    }
}
