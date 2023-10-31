package com.myproject.DAO;

import com.myproject.DTO.CT_HangHoaDTO;
import com.myproject.DTO.HangHoaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CT_HangHoaDAO extends conndb{
    
    conndb ConCT = new conndb();
    
    public ArrayList<CT_HangHoaDTO> getAllMaHH() {
        ArrayList<CT_HangHoaDTO> listMaCT = new ArrayList<>();
        try {
            ConCT.openConnection();
            Connection con = ConCT.getConnection();
            String sql1 = "SELECT * FROM CT_HANGHOA";
            PreparedStatement stmt = con.prepareStatement(sql1);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CT_HangHoaDTO ct = new CT_HangHoaDTO();
                ct.setMaCT_HH(rs.getString("MaCT_HH"));
                ct.setSoLuong(rs.getFloat("SoLuong"));
                ct.setNgaySX(rs.getTimestamp("NgSanXuat"));
                ct.setHSD(rs.getTimestamp("HanSuDung"));
                ct.setTinhTrang(rs.getBoolean("TinhTrang"));
                ct.setMaHH(rs.getString("MaHH"));
                listMaCT.add(ct);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConCT.closeConnection();
        }
        return listMaCT;
    }
    
    public boolean insertCTHH(CT_HangHoaDTO ct) {
        boolean check = false;
        try {
            ConCT.openConnection();
            Connection con = ConCT.getConnection();
            String sql = "INSERT INTO CT_HANGHOA VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, ct.getMaCT_HH());
            ps.setFloat(2, ct.getSoLuong());
            ps.setTimestamp(3, ct.getNgaySX());
            ps.setTimestamp(4, ct.getHSD());
            ps.setBoolean(5, ct.isTinhTrang());
            ps.setString(6, ct.getMaHH());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
    public boolean updateSL(float soLuong, String maCT_HH) {
        boolean check = false;
        try {
            ConCT.openConnection();
            Connection con = ConCT.getConnection();
            String sql = "Update CT_HangHoa set SoLuong = ? where maCT_HH = '" + maCT_HH + "'";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setFloat(1, soLuong);
            if (ps.executeUpdate() >= 1) {
                check =true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }
}
