package com.myproject.DAO;
import com.myproject.BUS.*;
import com.myproject.DTO.CT_PhieuNhapDTO;
import com.myproject.DTO.PhieuNhapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CT_PhieuNhapDAO extends conndb{
    conndb ConPN = new conndb();
    
    public boolean insertCTPhieuNhap(CT_PhieuNhapDTO ct) {
        boolean check = false;
        try {
            ConPN.openConnection();
            Connection con = ConPN.getConnection();
            String sql = "INSERT INTO CT_PHIEUNHAP VALUES(?,?,?,?,?)";
            java.sql.PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, ct.getMaPN());
            ps.setString(2, ct.getMaCT_HH());
            ps.setString(3, ct.getMaNCC());
            ps.setFloat(4, ct.getSLNhap());
            ps.setFloat(5, ct.getDonGiaNhap());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
    public ArrayList<Float> getSLNhap(String maPN, String maCTHH) {
        ArrayList<Float> ctp = new ArrayList<>();
        try {
            ConPN.openConnection();
            Connection con = ConPN.getConnection();
            String sql = "Select SoLuongNhap From CT_PhieuNhap where maPhieuNhap = '"+ maPN +"' and maCT_HH = '" + maCTHH +"'";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                float soLuong = rs.getFloat(1);
                ctp.add(soLuong);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ctp;
    }
    
//    public boolean
}
