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
    
    
}
