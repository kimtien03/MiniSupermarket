package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.KhuyenMaiDTO;
import java.security.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KhuyenMaiDAO extends conndb{
    public KhuyenMaiDTO getPromotion(String MaKM) {
        KhuyenMaiDTO promotion = null;
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM KHUYENMAI WHERE MaKM = ? AND TinhTrang = ?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, MaKM);
                preparedStatement.setBoolean(2, true);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    Date NgBD = rs.getDate("NgBatDauKM");
                    Date NgKT = rs.getDate("NgKetThucKM");
                    float TiLeGiam = rs.getFloat("Tilegiam");
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    String MoTa = rs.getString("MoTa");
                    
                    promotion = new KhuyenMaiDTO(MaKM, TiLeGiam, NgBD, NgKT, MoTa, TinhTrang);
                }
            } catch (Exception e) {
            }
        }
        
        return promotion;
    }
}
