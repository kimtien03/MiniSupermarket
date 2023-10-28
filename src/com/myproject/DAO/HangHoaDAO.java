package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HangHoaDAO extends conndb {

    conndb ConHH = new conndb();
    // Phương thức để lấy danh sách các mặt hàng (HangHoa) từ cơ sở dữ liệu

    public List<HangHoaTongDTO> getAllHangHoa() {
        List<HangHoaTongDTO> hangHoaList = new ArrayList<>();
        try {
            ConHH.openConnection();
            Connection con = ConHH.getConnection();
            String sql1 = "SELECT *"
                    + "FROM CT_HANGHOA "
                    + "INNER JOIN HANGHOA ON CT_HANGHOA.MaHH = HANGHOA.MaHH "
                    + "INNER JOIN LOAIHANG ON HANGHOA.MaLH = LOAIHANG.MaLH;";
            PreparedStatement stmt = con.prepareStatement(sql1);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                HangHoaTongDTO hangHoa = new HangHoaTongDTO();
                hangHoa.setMaCT_HH(resultSet.getString("MaCT_HH"));
                hangHoa.setMaHH(resultSet.getString("MaHH"));
                hangHoa.setTenHH(resultSet.getString("TenHH"));
                hangHoa.setNgaySX(resultSet.getTimestamp("NgSanXuat"));
                hangHoa.setHSD(resultSet.getTimestamp("HanSuDung"));
                hangHoa.setDonGiaBan(resultSet.getFloat("DonGiaBan"));
                hangHoa.setMaKM(resultSet.getString("MaKM"));
                hangHoa.setDonVi(resultSet.getString("DonVi"));
                hangHoa.setTenLH(resultSet.getString("TenLH"));
                hangHoa.setSoLuong(resultSet.getFloat("SoLuong"));
                hangHoa.setTinhTrang(resultSet.getBoolean("TinhTrang"));

                hangHoaList.add(hangHoa);
            }
            resultSet.close();
            stmt.close();
            return hangHoaList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateTinhTrangHangHoa(String MaHH, boolean TinhTrang) {
        try {
            ConHH.openConnection();
            Connection con = ConHH.getConnection();
            String sql = "UPDATE HANGHOA SET TinhTrang = ? WHERE MaHH = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql);) {
                stmt.setBoolean(1, TinhTrang);
                stmt.setString(2, MaHH);
                int rowsUpdated = stmt.executeUpdate();
                return rowsUpdated > 0; // Trả về true nếu có ít nhất một hàng đã được cập nhật
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
