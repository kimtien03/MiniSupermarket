package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO extends conndb {

    conndb ConKH = new conndb();
    public List<KhachHangDTO> getList() {
        List<KhachHangDTO> list = new ArrayList<>();
        try {
            ConKH.openConnection();
            Connection cons = ConKH.getConnection();
            String sql = "SELECT*FROM KHACHHANG";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangDTO khachhang = new KhachHangDTO();
                khachhang.setMaKH(rs.getString("MaKH"));
                khachhang.setHoTen(rs.getString("HoTen"));
                khachhang.setNgSinh(rs.getDate("NgSinh"));
                khachhang.setDiem(rs.getInt("Diem"));
                khachhang.setSDT(rs.getString("SDT"));
                khachhang.setTinhTrang(rs.getBoolean("TinhTrang"));
                list.add(khachhang);
            }
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public int AddKhNew(KhachHangDTO newkh) {
        int rs = 0;
        try {
            ConKH.openConnection();
            Connection cons = ConKH.getConnection();
            String sql = "INSERT into KHACHHANG(MaKH, HoTen, Diem,SDT,NgSinh, TinhTrang) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, newkh.getMaKH());
            ps.setString(2, newkh.getHoTen());
            ps.setInt(3, newkh.getDiem());
            ps.setString(4, newkh.getSDT());
            java.sql.Date ngaySinhSQL = new java.sql.Date(newkh.getNgSinh().getTime());
            ps.setDate(5, ngaySinhSQL);
            ps.setBoolean(6, newkh.isTinhTrang());
            rs = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    public int UpdateKhNew(KhachHangDTO Fixkh) {
        int rs = 0;
        try {
            ConKH.openConnection();
            Connection cons = ConKH.getConnection();
            String sql = "UPDATE KHACHHANG SET HoTen=?, Diem=?, SDT=?, NgSinh=?,TinhTrang=? where MaKH=?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(6, Fixkh.getMaKH());
            ps.setString(1, Fixkh.getHoTen());
            java.sql.Date ngaySinhSQL = new java.sql.Date(Fixkh.getNgSinh().getTime());
            ps.setInt(2, Fixkh.getDiem());
            ps.setString(3, Fixkh.getSDT());
            ps.setDate(4, ngaySinhSQL);
            ps.setBoolean(5, Fixkh.isTinhTrang());
            
            rs = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
}
