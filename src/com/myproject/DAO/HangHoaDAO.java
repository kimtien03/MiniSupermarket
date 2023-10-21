package com.myproject.DAO;
import com.myproject.BUS.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import com.myproject.DTO.HangHoaDTO;
import java.sql.Connection;
import java.util.ArrayList;

public class HangHoaDAO extends conndb{
    conndb ConHH = new conndb();

    public ArrayList<HangHoaDTO> getListHangHoa() {

        ArrayList<HangHoaDTO> listHang = new ArrayList<>();
        try {
            ConHH.openConnection();
            Connection con = (Connection) ConHH.getConnection();
            String query = "SELECT * FROM HANGHOA";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HangHoaDTO t = new HangHoaDTO();
                t.setMaHH(rs.getString("MaHH"));
                t.setTenHH(rs.getString("TenHH"));
                t.setMaKM(rs.getString("MaKM"));
                t.setDonGiaBan(rs.getFloat("DonGiaBan"));
                t.setDonVi(rs.getString("DonVi"));
                t.setMaLH(rs.getString("MaLH"));
                t.setTinhTrang(rs.getBoolean("TinhTrang"));
            }
            ps.close();
            rs.close();
            con.close();
            return listHang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
