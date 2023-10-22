package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.NhaCungCapDTO;
import com.myproject.DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends conndb {

    conndb ConNV = new conndb();

    public List<NhanVienDTO> getList() {
        List<NhanVienDTO> list = new ArrayList<>();
        try {
            ConNV.openConnection();
            Connection cons = ConNV.getConnection();
            String sql = "SELECT*FROM NHANVIEN";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienDTO nhanvien = new NhanVienDTO();
                nhanvien.setMaNV(rs.getString("MaNV"));
                nhanvien.setTenNV(rs.getString("TenNV"));
                nhanvien.setNgSinh(rs.getDate("NgSinh"));
                nhanvien.setGioitinh(rs.getString("GioiTinh"));
                nhanvien.setSDT(rs.getString("SDT"));
                nhanvien.setEmail(rs.getString("Email"));
                nhanvien.setPasswd(rs.getString("MatKhau"));
                nhanvien.setMaQuyen(rs.getString("MaQuyen"));
                nhanvien.setTinhTrang(rs.getBoolean("TinhTrang"));
                nhanvien.setChucVu(rs.getString("ChucVu"));
                nhanvien.setKhoaTK(rs.getBoolean("KhoaTK"));
                list.add(nhanvien);
            }
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int AddNvNew(NhanVienDTO newnv) {
        int rs = 0;
        try {
            ConNV.openConnection();
            Connection cons = ConNV.getConnection();
            String sql = "INSERT into NHANVIEN(MaNV, TenNV, NgSinh, GioiTinh, SDT, Email,MatKhau,MaQuyen,TinhTrang,ChucVu,KhoaTK) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, newnv.getMaNV());
            ps.setString(2, newnv.getTenNV());
            java.sql.Date ngaySinhSQL = new java.sql.Date(newnv.getNgSinh().getTime());
            ps.setDate(3, ngaySinhSQL);
            ps.setString(4, newnv.getGioitinh());
            ps.setString(5, newnv.getSDT());
            ps.setString(6, newnv.getEmail());
            ps.setString(7, newnv.getPasswd());
            ps.setString(8, newnv.getMaQuyen());
            ps.setBoolean(9, newnv.isTinhTrang());
            ps.setString(10, newnv.getChucVu());
            ps.setBoolean(11, newnv.isKhoaTK());
            rs = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    public int UpdateNvNew(NhanVienDTO FixNv) {
        int rs = 0;
        try {
            ConNV.openConnection();
            Connection cons = ConNV.getConnection();
            String sql = "UPDATE NHANVIEN SET TenNV=?, NgSinh=?, GioiTinh=?, SDT=?, Email=?,TinhTrang=?,ChucVu=? where MaNV=?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(8, FixNv.getMaNV());
            ps.setString(1, FixNv.getTenNV());
            java.sql.Date ngaySinhSQL = new java.sql.Date(FixNv.getNgSinh().getTime());
            ps.setDate(2, ngaySinhSQL);
            ps.setString(3, FixNv.getGioitinh());
            ps.setString(4, FixNv.getSDT());
            ps.setString(5, FixNv.getEmail());
            ps.setBoolean(6, FixNv.isTinhTrang());
            ps.setString(7, FixNv.getChucVu());
            rs = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
}
