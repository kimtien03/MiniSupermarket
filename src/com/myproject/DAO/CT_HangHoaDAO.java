package com.myproject.DAO;

import com.myproject.DTO.CT_HangHoaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class CT_HangHoaDAO extends conndb{
    // lấy mã chi tiết hoàng hóa theo mã hàng hóa
    public ArrayList<CT_HangHoaDTO> getBillDetailsByProductID(String MaHH) {
        ArrayList<CT_HangHoaDTO> productDetails = new ArrayList<CT_HangHoaDTO>();
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM CT_HANGHOA WHERE MaHH = ? AND TinhTrang = 1";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, MaHH);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()) {
                    String MaCT_HH = rs.getString("");
                    int SoLuong = rs.getInt("");
                    Date NgSanXuat = rs.getDate("");
                    Date HanSuDung = rs.getDate("");
                    boolean TinhTrang = rs.getBoolean("");
                    
                    CT_HangHoaDTO productDetail = new CT_HangHoaDTO(MaCT_HH, MaHH, 
                            NgSanXuat, HanSuDung, SoLuong, TinhTrang);
                    
                }
            } catch (Exception e) {
            }
        }
        
        return productDetails;
    }
}
