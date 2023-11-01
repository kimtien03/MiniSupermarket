package com.myproject.DAO;


import com.myproject.DTO.HoaDonBanHangDTO;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
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
    
    
    
    //TIENDAT
    // lấy toàn bộ trường dữ liệu  hóa đơn bán hàng 
    public ArrayList<HoaDonBanHangDTO> getALLBillAsArrayList() {
        ArrayList<HoaDonBanHangDTO> billArrayList = new ArrayList<HoaDonBanHangDTO>();
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM HOADONBANHANG";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()) {
                    String MaHD = rs.getString("MaHD");
                    Timestamp NgLapHD = rs.getTimestamp("NgLapHD");
                    float ThanhTien = rs.getFloat("ThanhTien");
                    String MaKH = rs.getString("MaKH");
                    String MaNV =  rs.getString("MaNV");
                    
                    HoaDonBanHangDTO billItem = new HoaDonBanHangDTO(MaHD, NgLapHD, ThanhTien, MaKH, MaNV);
                    billArrayList.add(billItem);
                }
            } catch (SQLException e) {
            }
        }
        
        return billArrayList;
    }
    
    // thêm một hóa đơn mới vào cơ sở dữ liệu 
    public int addBill(HoaDonBanHangDTO bill) {
        if (openConnection()) {
            try {
                String sql = "INSERT INTO HOADONBANHANG (MaHD, NgLapHD, ThanhTien, MaKH, MaNV) VALUES (?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, bill.getMaHD());
                Timestamp currentDateTime = Timestamp.from(Instant.now());
                preparedStatement.setTimestamp(2, currentDateTime);
                preparedStatement.setFloat(3, bill.getThanhTien());
                preparedStatement.setString(4, bill.getMaKH());
                preparedStatement.setString(5, bill.getMaNV());
                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
            }
        }
        return -1;
    }
}

