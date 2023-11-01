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
    // TRUY XUẤT DỮ LIỆU
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
                    if(MaQuyen == null) {
                        MaQuyen = "";
                    }
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    String ChucVu = rs.getString("ChucVu");
                    boolean KhoaTK = rs.getBoolean("KhoaTK");
                    
                    NhanVienDTO staffItem = new NhanVienDTO(MaNV, TenNV, Gioitinh, 
                            Email, SDT, Passwd, NgSinh, MaQuyen, TinhTrang, ChucVu, KhoaTK);
                    staffArrayList.add(staffItem);
                }
                closeConnection();
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
                String sql = "SELECT * FROM NHANVIEN WHERE MaNV = ? AND TinhTrang = 1";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, MaNV);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    String TenNV = rs.getString("TenNV");
                    String Gioitinh = rs.getString("GioiTinh");
                    String Email = rs.getString("Email");
                    String SDT = rs.getString("SDT");
                    String Passwd = rs.getString("MatKhau");
                    Date NgSinh = rs.getDate("NgSinh");
                    String MaQuyen = rs.getString("MaQuyen");
                    if(MaQuyen == null) {
                        MaQuyen = "";
                    }
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    String ChucVu = rs.getString("ChucVu");
                    boolean KhoaTK = rs.getBoolean("KhoaTK");
                    
                    staff = new NhanVienDTO(MaNV, TenNV, Gioitinh, Email, SDT, 
                            Passwd, NgSinh, MaQuyen, TinhTrang, ChucVu, KhoaTK);
                }
                closeConnection();
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
                String sql = "SELECT * FROM NHANVIEN WHERE TenNV = ? AND TinhTrang = 1";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, TenNV);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    String MaNV = rs.getString("MaNV");
                    String Gioitinh = rs.getString("GioiTinh");
                    String Email = rs.getString("Email");
                    String SDT = rs.getString("SDT");
                    String Passwd = rs.getString("MatKhau");
                    Date NgSinh = rs.getDate("NgSinh");
                    String MaQuyen = rs.getString("MaQuyen");
                    if(MaQuyen == null) {
                        MaQuyen = "";
                    }
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    String ChucVu = rs.getString("ChucVu");
                    boolean KhoaTK = rs.getBoolean("KhoaTK");
                    
                    staff = new NhanVienDTO(MaNV, TenNV, Gioitinh, Email, SDT, 
                            Passwd, NgSinh, MaQuyen, TinhTrang, ChucVu, KhoaTK);
                }
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return staff;
    }
    
    // lấy toàn bộ trường dữ liệu nhân viên theo mã nhân viên
    public ArrayList<NhanVienDTO> getAllStaffByID(String MaNV) {
        ArrayList<NhanVienDTO> staffArrayListByID = new ArrayList<NhanVienDTO>();

        if(openConnection()) {
            try {
                String sql = "SELECT * FROM NHANVIEN WHERE MaNV = ? AND TinhTrang = 1";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, MaNV);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()) {
                    String TenNV = rs.getString("TenNV");
                    String Gioitinh = rs.getString("GioiTinh");
                    String Email = rs.getString("Email");
                    String SDT = rs.getString("SDT");
                    String Passwd = rs.getString("MatKhau");
                    Date NgSinh = rs.getDate("NgSinh");
                    String MaQuyen = rs.getString("MaQuyen");
                    if(MaQuyen == null) {
                        MaQuyen = "";
                    }
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    String ChucVu = rs.getString("ChucVu");
                    boolean KhoaTK = rs.getBoolean("KhoaTK");

                    NhanVienDTO staffItem = new NhanVienDTO(MaNV, TenNV, Gioitinh, 
                         Email, SDT, Passwd, NgSinh, MaQuyen, TinhTrang, ChucVu, KhoaTK);
                    staffArrayListByID.add(staffItem);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
       }
       
       return staffArrayListByID;
    }
   
   // lấy toàn bộ trường dữ liệu nhân viên theo tên nhân viên
    public ArrayList<NhanVienDTO> getAllStaffByName(String TenNV) {
        ArrayList<NhanVienDTO> staffArrayListByID = new ArrayList<NhanVienDTO>();

        if(openConnection()) {
            try {
                String sql = "SELECT * FROM NHANVIEN WHERE TenNV = ? AND TinhTrang = 1";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, TenNV);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()) {
                    String MaNV = rs.getString("MaNV");
                    String Gioitinh = rs.getString("GioiTinh");
                    String Email = rs.getString("Email");
                    String SDT = rs.getString("SDT");
                    String Passwd = rs.getString("MatKhau");
                    Date NgSinh = rs.getDate("NgSinh");
                    String MaQuyen = rs.getString("MaQuyen");
                    if(MaQuyen == null) {
                        MaQuyen = "";
                    }
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    String ChucVu = rs.getString("ChucVu");
                    boolean KhoaTK = rs.getBoolean("KhoaTK");

                    NhanVienDTO staffItem = new NhanVienDTO(MaNV, TenNV, Gioitinh, 
                         Email, SDT, Passwd, NgSinh, MaQuyen, TinhTrang, ChucVu, KhoaTK);
                    staffArrayListByID.add(staffItem);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
       }
       
       return staffArrayListByID;
    }
   
    // lấy toàn bộ trường dữ liệu nhân viên theo chức vụ nhân viên
    public ArrayList<NhanVienDTO> getAllStaffByPosition(String ChucVu) {
        ArrayList<NhanVienDTO> staffArrayListByPosition = new ArrayList<NhanVienDTO>();

        if(openConnection()) {
            try {
                String sql = "SELECT * FROM NHANVIEN WHERE ChucVu = ? AND TinhTrang = 1";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, ChucVu);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()) {
                    String MaNV = rs.getString("MaNV");
                    String TenNV = rs.getString("TenNV");
                    String Gioitinh = rs.getString("GioiTinh");
                    String Email = rs.getString("Email");
                    String SDT = rs.getString("SDT");
                    String Passwd = rs.getString("MatKhau");
                    Date NgSinh = rs.getDate("NgSinh");
                    String MaQuyen = rs.getString("MaQuyen");
                    if(MaQuyen == null) {
                        MaQuyen = "";
                    }
                    System.out.println(MaQuyen);
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    boolean KhoaTK = rs.getBoolean("KhoaTK");

                    NhanVienDTO staffItem = new NhanVienDTO(MaNV, TenNV, Gioitinh, 
                          Email, SDT, Passwd, NgSinh, MaQuyen, TinhTrang, ChucVu, KhoaTK);
                    staffArrayListByPosition.add(staffItem);
                 }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return staffArrayListByPosition;
    }
   
   // CẬP NHẬT DŨ LIỆU 
    // cập nhật thông tin cho một nhân viên
    public int updateStaff(NhanVienDTO staff) {
        if (openConnection()) {
            try {
                String sql = "UPDATE NHANVIEN SET TenNV = ?, NgSinh = ?, "
                        + "GioiTinh = ?, SDT = ?, Email = ?, MatKhau = ?, MaQuyen = ?, "
                        + "TinhTrang = ?, ChucVu = ?, KhoaTK = ? WHERE MaNV = ?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, staff.getTenNV());
                preparedStatement.setDate(2, (Date) staff.getNgSinh());
                preparedStatement.setString(3, staff.getGioitinh());
                preparedStatement.setString(4, staff.getSDT());
                preparedStatement.setString(5, staff.getEmail());
                preparedStatement.setString(6, staff.getPasswd());
                preparedStatement.setString(7, staff.getMaQuyen());
                preparedStatement.setBoolean(8, staff.isTinhTrang());
                preparedStatement.setString(9, staff.getChucVu());
                preparedStatement.setBoolean(10, staff.getKhoaTK());
                preparedStatement.setString(11, staff.getMaNV());
                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}
