package com.myproject.DAO;

import com.myproject.DTO.NhanVienDTO;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

import java.util.List;

import java.util.List;

import com.myproject.DTO.NhanVienDTO;

public class NhanVienDAO extends conndb{
    // Lấy toàn bộ trường dữ liệu nhân viên
    public ArrayList<NhanVienDTO> getAllStaffInfoAsArraylist() {
        ArrayList<NhanVienDTO> staffArrayList = new ArrayList<NhanVienDTO>();
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM NHANVIEN WHERE TinhTrang = 1";
                ResultSet rs = con.createStatement().executeQuery(sql);
                while(rs.next()) {
                    String MaNV = rs.getString("MaNV");
                    String TenNV = rs.getString("TenNV");
                    String Gioitinh = rs.getString("GioiTinh");
                    String Email = rs.getString("Email");
                    String SDT = rs.getString("SDT");
                    String Passwd = rs.getString("MatKhau");
                    Date NgSinh = rs.getDate("NgSinh");
                    String MaQuyen = rs.getString("MaQuyen");
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    String ChucVu = rs.getString("ChucVu");
                    boolean KhoaTK = rs.getBoolean("KhoaTK");
                    
                    NhanVienDTO staffItem = new NhanVienDTO(MaNV, TenNV, Gioitinh, 
                            Email, SDT, Passwd, NgSinh, MaQuyen, TinhTrang, ChucVu, KhoaTK);
                    staffArrayList.add(staffItem);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return staffArrayList;
    }
    
    // lấy trường dữ liệu một nhân viên theo mã
    public NhanVienDTO getStaffByID(String MaNV) {
        NhanVienDTO staff = null;
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM NHANVIEN WHERE MaNV = ?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(0, MaNV);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    String TenNV = rs.getString("TenNV");
                    String Gioitinh = rs.getString("GioiTinh");
                    String Email = rs.getString("Email");
                    String SDT = rs.getString("SDT");
                    String Passwd = rs.getString("MatKhau");
                    Date NgSinh = rs.getDate("NgSinh");
                    String MaQuyen = rs.getString("MaQuyen");
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    String ChucVu = rs.getString("ChucVu");
                    boolean KhoaTK = rs.getBoolean("KhoaTK");
                    
                    staff = new NhanVienDTO(MaNV, TenNV, Gioitinh, Email, SDT, 
                            Passwd, NgSinh, MaQuyen, TinhTrang, ChucVu, KhoaTK);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return staff;
    }
    
    // lấy trường dữ liệu một nhân viên theo tên 
    public NhanVienDTO getStaffByName(String TenNV) {
        NhanVienDTO staff = null;
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM NHANVIEN WHERE TenNV = ?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(0, TenNV);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    String MaNV = rs.getString("MaNV");
                    String Gioitinh = rs.getString("GioiTinh");
                    String Email = rs.getString("Email");
                    String SDT = rs.getString("SDT");
                    String Passwd = rs.getString("MatKhau");
                    Date NgSinh = rs.getDate("NgSinh");
                    String MaQuyen = rs.getString("MaQuyen");
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    String ChucVu = rs.getString("ChucVu");
                    boolean KhoaTK = rs.getBoolean("KhoaTK");
                    
                    staff = new NhanVienDTO(MaNV, TenNV, Gioitinh, Email, SDT, 
                            Passwd, NgSinh, MaQuyen, TinhTrang, ChucVu, KhoaTK);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return staff;
    }

    public List<NhanVienDTO> getList() {
        List<NhanVienDTO> list = new ArrayList<>();
        if (openConnection()) {
            try {
                String sql = "SELECT*FROM NHANVIEN";
                PreparedStatement ps = con.prepareStatement(sql);
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
        }
        return null;
    }

    public int AddNvNew(NhanVienDTO newnv) {
        int rs = 0;
        if (openConnection()) {
            try {
                String sql = "INSERT into NHANVIEN(MaNV, TenNV, NgSinh, GioiTinh, SDT, Email,MatKhau,MaQuyen,TinhTrang,ChucVu,KhoaTK) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
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
        }
        return rs;
    }
    public int UpdateNvNew(NhanVienDTO FixNv) {
        int rs = 0;
        if (openConnection()) {
            try {
                String sql = "UPDATE NHANVIEN SET TenNV=?, NgSinh=?, GioiTinh=?, SDT=?, Email=?,TinhTrang=?,ChucVu=? where MaNV=?";
                PreparedStatement ps = con.prepareStatement(sql);
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
        }
        return rs;
    }
}
