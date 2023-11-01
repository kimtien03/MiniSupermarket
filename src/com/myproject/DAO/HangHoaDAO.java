package com.myproject.DAO;
import com.myproject.BUS.*;
import com.myproject.DTO.HangHoaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HangHoaDAO extends conndb{
    // lấy một trường dữ liệu hàng hóa theo mã hàng hóa
    public HangHoaDTO getProductByID(String MaHH) {
        HangHoaDTO product = null;
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM HANGHOA WHERE MaHH = ?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, MaHH);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    String TenHH = rs.getString("TenHH");
                    String MaKM = rs.getString("MaKM");
                    float DonGiaBan = rs.getFloat("DonGiaBan");
                    String DonVi = rs.getString("DonVi");
                    String MaLH = rs.getString("MaLH");
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    
                    product = new HangHoaDTO(MaHH, TenHH, MaLH, DonGiaBan, DonVi, MaKM, TinhTrang);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return product;
    }
}
