package com.myproject.DAO;
import com.myproject.BUS.*;
import com.myproject.DTO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonBanHangDAO extends conndb {

        conndb ConHD = new conndb();
        // Phương thức để lấy danh sách các mặt hàng (HangHoa) từ cơ sở dữ liệu
        public List<HoaDonBanHangDTO> getAllHoaDon() {
            List<HoaDonBanHangDTO> hoaDonList = new ArrayList<>();
            try {
                ConHD.openConnection();
                Connection con = ConHD.getConnection();
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
        return null;
    }

}
