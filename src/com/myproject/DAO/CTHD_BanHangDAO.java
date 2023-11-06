package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.CTHD_BanHangDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CTHD_BanHangDAO extends conndb{
    public List<CTHD_BanHangDTO> getList() {
        List<CTHD_BanHangDTO> list = new ArrayList<>();
        if (openConnection()) {
            try {
                String sql = "SELECT*FROM CTHD_BANHANG";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    CTHD_BanHangDTO cthd = new CTHD_BanHangDTO();
                    cthd.setMaHD(rs.getString("MaHD"));
                    cthd.setMaCT_HH(rs.getString("MaCT_HH"));
                    cthd.setSLBan(rs.getFloat("SoLuongBan"));
                    cthd.setDonGia(rs.getFloat("DonGia"));
                    list.add(cthd);
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
    
    // TIẾN ĐẠT
    // lấy toàn bộ trường dữ liệu chi tiết hóa đơn bán hàng
    public ArrayList<CTHD_BanHangDTO> getAllBillDetails() {
        ArrayList<CTHD_BanHangDTO> BillDetailsList = new ArrayList<CTHD_BanHangDTO>();
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM CTHD_BANHANG";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    String MaHD = rs.getString("MaHD");
                    String MaCT_HH = rs.getString("MaCT_HH");
                    float SoLuongBan = rs.getInt("SoLuongBan");
                    float DonGia = rs.getFloat("DonGia");
                }
            } catch (Exception e) {
            }
        }
        
        return BillDetailsList;
    }
    
    // thêm dữ liệu hóa đơn bán hàng mới 
    public int addBillDetails(CTHD_BanHangDTO billDetails) {
        if(openConnection()) {
            try {
                String sql = "INSERT INTO CTHD_BANHANG (MaHD, MaCT_HH, SoLuongBan, DonGia) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, billDetails.getMaHD());
                preparedStatement.setString(2, billDetails.getMaCT_HH());
                preparedStatement.setFloat(3, billDetails.getSLBan());
                preparedStatement.setFloat(4, billDetails.getDonGia());
                return preparedStatement.executeUpdate();
            } catch (Exception e) {
            }
        }
        
        return -1;
    }
}

