package com.myproject.DAO;

import com.myproject.DTO.CT_HangHoaDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CT_HangHoaDAO extends conndb {

    conndb ConCTHH = new conndb();

    public List<CT_HangHoaDTO> getList() {
        List<CT_HangHoaDTO> list = new ArrayList<>();
        try {
            ConCTHH.openConnection();
            Connection cons = ConCTHH.getConnection();
            String sql = "SELECT*FROM CT_HANGHOA";
            PreparedStatement ps = cons.prepareStatement(sql);
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
        return null;
    }
}
