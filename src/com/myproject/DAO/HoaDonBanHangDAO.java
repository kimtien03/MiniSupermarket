package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.HoaDonBanHangDTO;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonBanHangDAO extends conndb {

    conndb ConHDBH = new conndb();
    public List<HoaDonBanHangDTO> getList() {
        List<HoaDonBanHangDTO> list = new ArrayList<>();
        try {
            ConHDBH.openConnection();
            Connection cons = ConHDBH.getConnection();
            String sql = "SELECT*FROM HOADONBANHANG";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonBanHangDTO HDBanHang = new HoaDonBanHangDTO();
                HDBanHang.setMaHD(rs.getString("MaHD"));
                HDBanHang.setNgLap(rs.getTimestamp("NgLapHD"));
                HDBanHang.setThanhTien(rs.getFloat("ThanhTien"));
                HDBanHang.setMaKH(rs.getString("MaKH"));
                HDBanHang.setMaNV(rs.getString("MaNV"));
                list.add(HDBanHang);
            }
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<HoaDonBanHangDTO> getAllHoaDon() {
        List<HoaDonBanHangDTO> hoaDonList = new ArrayList<>();
        if(openConnection()) {
            try {
                String sql1 = "SELECT *"
                        + "FROM HOADONBANHANG "
                        + "INNER JOIN KHACHHANG ON HOADONBANHANG.MaKH = KHACHHANG.MaKH "
                        + "INNER JOIN NHANVIEN ON HOADONBANHANG.MaNV = NHANVIEN.MaNV;";
                PreparedStatement stmt = con.prepareStatement(sql1);
                ResultSet resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    HoaDonBanHangDTO hoaDon = new HoaDonBanHangDTO();
                    hoaDon.setMaHD(resultSet.getString("MaHD"));
                    hoaDon.setNgLap(resultSet.getTimestamp("NgLapHD"));
    //                hoaDon.setThanhTien(resultSet.getFloat("ThanhTien"));
                    hoaDon.setMaKH(resultSet.getString("MaKH"));
                    hoaDon.setMaNV(resultSet.getString("MaNV"));


                    hoaDonList.add(hoaDon);
                }
                resultSet.close();
                stmt.close();
                return hoaDonList;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}