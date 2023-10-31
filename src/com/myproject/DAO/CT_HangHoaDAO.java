package com.myproject.DAO;

import com.myproject.DTO.CT_HangHoaDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CT_HangHoaDAO extends conndb {
    public List<CT_HangHoaDTO> getList() {
        List<CT_HangHoaDTO> list = new ArrayList<>();
        if (openConnection()) {
            try {
                String sql = "SELECT*FROM CT_HANGHOA";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    CT_HangHoaDTO cthh = new CT_HangHoaDTO();
                    cthh.setMaCT_HH(rs.getString("MaCT_HH"));
                    cthh.setSoLuong(rs.getFloat("SoLuong"));
                    cthh.setNgaySX(rs.getDate("NgSanXuat"));
                    cthh.setHSD(rs.getDate("HanSuDung"));
                    cthh.setMaHH(rs.getString("MaHH"));
                    cthh.setTinhTrang(rs.getBoolean("TinhTrang"));
                    list.add(cthh);
                }
                ps.close();
                rs.close();
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    
    public boolean insertCTHH(CT_HangHoaDTO ct) {
        boolean check = false;
        if (openConnection()) {
            try {
                String sql = "INSERT INTO CT_HANGHOA VALUES(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareCall(sql);
                ps.setString(1, ct.getMaCT_HH());
                ps.setDate(2, ct.getNgaySX());
                ps.setDate(3, ct.getHSD());
                ps.setBoolean(4, ct.isTinhTrang());
                ps.setString(5, ct.getMaHH());
                ps.setFloat(6, ct.getSoLuong());
                if (ps.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return check;
    }
    
    public boolean updateSL(float soLuong, String maCT_HH) {
        boolean check = false;
        if (openConnection()) {
            try {
                String sql = "Update CT_HangHoa set SoLuong = ? where maCT_HH = '" + maCT_HH + "'";
                PreparedStatement ps = con.prepareCall(sql);
                ps.setFloat(1, soLuong);
                if (ps.executeUpdate() >= 1) {
                    check =true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return check;
    }
}