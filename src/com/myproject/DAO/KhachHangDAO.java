package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO extends conndb {

    conndb ConKH = new conndb();
    public List<KhachHangDTO> getList() {
        List<KhachHangDTO> list = new ArrayList<>();
        try {
            ConKH.openConnection();
            Connection cons = ConKH.getConnection();
            String sql = "SELECT*FROM KHACHHANG";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangDTO khachhang = new KhachHangDTO();
                khachhang.setMaKH(rs.getString("MaKH"));
                khachhang.setHoTen(rs.getString("HoTen"));
                khachhang.setNgSinh(rs.getDate("NgSinh"));
                khachhang.setDiem(rs.getInt("Diem"));
                khachhang.setSDT(rs.getString("SDT"));
                khachhang.setTinhTrang(rs.getBoolean("TinhTrang"));
                list.add(khachhang);
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
