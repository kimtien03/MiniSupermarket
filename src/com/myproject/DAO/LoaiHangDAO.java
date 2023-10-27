package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.LoaiHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class LoaiHangDAO extends conndb{
    conndb ConLH = new conndb();
    public List<LoaiHangDTO> getList() {
        List<LoaiHangDTO> list = new ArrayList<>();
        try {
            ConLH.openConnection();
            Connection cons = ConLH.getConnection();
            String sql = "SELECT*FROM LOAIHANG";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiHangDTO loaihang = new LoaiHangDTO();
                loaihang.setMaLH(rs.getString("MaLH"));
                loaihang.setTenLH(rs.getString("TenLH"));
                loaihang.setTinhTrang(rs.getBoolean("TinhTrang"));
                list.add(loaihang);
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
