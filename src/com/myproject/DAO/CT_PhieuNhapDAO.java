package com.myproject.DAO;
import com.myproject.BUS.*;
import com.myproject.DTO.CT_PhieuNhapDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CT_PhieuNhapDAO extends conndb{
    public List<CT_PhieuNhapDTO> getList() {
        List<CT_PhieuNhapDTO> list = new ArrayList<>();
        if (openConnection()) {
            try {
                String sql = "SELECT*FROM CT_PHIEUNHAP";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    CT_PhieuNhapDTO ctpn = new CT_PhieuNhapDTO();
                    ctpn.setMaPN(rs.getString("MaPhieuNhap"));
                    ctpn.setMaCT_HH(rs.getString("MaCT_HH"));
                    ctpn.setMaNCC(rs.getString("MaNCC"));
                    ctpn.setSLNhap(rs.getFloat("SoLuongNhap"));
                    ctpn.setDonGiaNhap(rs.getFloat("DonGiaNhap"));
                    list.add(ctpn);
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
}
