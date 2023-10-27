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
    conndb ConCTHD = new conndb();
    public List<CTHD_BanHangDTO> getList() {
        List<CTHD_BanHangDTO> list = new ArrayList<>();
        try {
            ConCTHD.openConnection();
            Connection cons = ConCTHD.getConnection();
            String sql = "SELECT*FROM CTHD_BANHANG";
            PreparedStatement ps = cons.prepareStatement(sql);
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
        return null;
    }

}
