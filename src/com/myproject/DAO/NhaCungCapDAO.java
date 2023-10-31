package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.NhaCungCapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NhaCungCapDAO extends conndb{
    conndb ConHH = new conndb();
    // Phương thức để lấy danh sách các mặt hàng (HangHoa) từ cơ sở dữ liệu

    public ArrayList<NhaCungCapDTO> getAllNCC() {
        ArrayList<NhaCungCapDTO> listTenNCC = new ArrayList<>();
        try {
            ConHH.openConnection();
            Connection con = ConHH.getConnection();
            String sql1 = "SELECT * FROM NHACUNGCAP";
            PreparedStatement stmt = con.prepareStatement(sql1);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                NhaCungCapDTO nnc = new NhaCungCapDTO();
                nnc.setMaNCC(resultSet.getString("MaNCC"));
                nnc.setTenNCC(resultSet.getString("TenNCC"));
                nnc.setDiaChi(resultSet.getString("DiaChi"));
                nnc.setEmail(resultSet.getString("Email"));
                nnc.setSDT(resultSet.getString("SDT"));
                nnc.setTinhTrang(resultSet.getBoolean("TinhTrang"));
                listTenNCC.add(nnc);
            }
            resultSet.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConHH.closeConnection();
        }
        return listTenNCC;
    }
}
