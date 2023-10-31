package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.HangHoaTongDTO;
import com.myproject.DTO.LoaiHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoaiHangDAO extends conndb {

    conndb ConHH = new conndb();
    // Phương thức để lấy danh sách các mặt hàng (HangHoa) từ cơ sở dữ liệu

    public ArrayList<LoaiHangDTO> getAllMaLH() {
        ArrayList<LoaiHangDTO> listMaLH = new ArrayList<>();
        try {
            ConHH.openConnection();
            Connection con = ConHH.getConnection();
            String sql1 = "SELECT * FROM LOAIHANG";
            PreparedStatement stmt = con.prepareStatement(sql1);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                LoaiHangDTO lh = new LoaiHangDTO();
                lh.setMaLH(resultSet.getString("MaLH"));
                lh.setTenLH(resultSet.getString("TenLH"));
                lh.setTinhTrang(resultSet.getBoolean("TinhTrang"));
                listMaLH.add(lh);
            }
            resultSet.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConHH.closeConnection();
        }
        return listMaLH;
    }
    
    public String findLH(String maLH) {
        String tenLH = "";
        try {
            String query = "SELECT TENLH FROM LOAIHANG WHERE MALH = '" + maLH + "'";
            ConHH.openConnection();
            Connection con = ConHH.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tenLH = rs.getString(1);
            }
        } catch (Exception ex) {
            
        } finally {
            ConHH.closeConnection();
        }
        return tenLH;
    }
}
