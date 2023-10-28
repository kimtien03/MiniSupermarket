package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.HangHoaTongDTO;
import com.myproject.DTO.KhuyenMaiDTO;
import java.sql.Connection; // Đảm bảo import java.sql.Connection
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class KhuyenMaiDAO extends conndb {

    conndb ConKM = new conndb();
    
    // Phương thức để lấy danh sách các mặt hàng (HangHoa) từ cơ sở dữ liệu
    public List<KhuyenMaiDTO> getAllKhuyenMai() {
        List<KhuyenMaiDTO> khuyenMaiList = new ArrayList<>();
        try {
            ConKM.openConnection();
            java.sql.Connection con = ConKM.getConnection();
            String sql1 = "SELECT *FROM KHUYENMAI ";

            PreparedStatement stmt = con.prepareStatement(sql1);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                KhuyenMaiDTO khuyenMai = new KhuyenMaiDTO();
                khuyenMai.setMaKM(resultSet.getString("MaKM"));
                khuyenMai.setNgBD(resultSet.getTimestamp("NgBatDauKM"));
                khuyenMai.setNgKT(resultSet.getTimestamp("NgKetThucKM"));
                khuyenMai.setTiLeGiam(resultSet.getFloat("TiLeGiam"));
                khuyenMai.setTinhTrang(resultSet.getBoolean("TinhTrang"));
                khuyenMai.setMoTa(resultSet.getString("MoTa"));
                khuyenMaiList.add(khuyenMai);
            }
            resultSet.close();
            stmt.close();
            
            return khuyenMaiList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
