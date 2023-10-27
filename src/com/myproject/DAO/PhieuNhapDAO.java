package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.PhieuNhapDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhieuNhapDAO extends conndb {

    conndb ConKH = new conndb();

    public List<PhieuNhapDTO> getList() {
        List<PhieuNhapDTO> list = new ArrayList<>();
        try {
            ConKH.openConnection();
            Connection cons = ConKH.getConnection();
            String sql = "SELECT*FROM PHIEUNHAP";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuNhapDTO pn = new PhieuNhapDTO();
                pn.setMaPN(rs.getString("MaPhieuNhap"));
                pn.setNgLapPhieu(rs.getTimestamp("NgLapPhieu"));
                pn.setThanhTien(rs.getFloat("ThanhTien"));
                pn.setMaNV(rs.getString("MaNV"));
                pn.setTinhTrang(rs.getBoolean("TinhTrang"));
                list.add(pn);
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
