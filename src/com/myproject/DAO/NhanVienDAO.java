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
                String sql = "UPDATE NHANVIEN SET TenNV=?, NgSinh=?, GioiTinh=?, SDT=?, Email=?,TinhTrang=?,ChucVu=?,KhoaTK=? where MaNV=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(9, FixNv.getMaNV());
                ps.setString(1, FixNv.getTenNV());
                java.sql.Date ngaySinhSQL = new java.sql.Date(FixNv.getNgSinh().getTime());
                ps.setDate(2, ngaySinhSQL);
                ps.setString(3, FixNv.getGioitinh());
                ps.setString(4, FixNv.getSDT());
                ps.setString(5, FixNv.getEmail());
                ps.setBoolean(6, FixNv.isTinhTrang());
                ps.setString(7, FixNv.getChucVu());
                ps.setBoolean(8, FixNv.isKhoaTK());
                rs = ps.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }

    public boolean UpdateMK(String maNV, String mk) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE NHANVIEN SET MATKHAU = ? WHERE MANV = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                    prest.setString(1,mk);
                    prest.setString(2, maNV);
                if (prest.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    
    
    
    //TIENDAT
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
                preparedStatement.setBoolean(10, staff.isKhoaTK());
                preparedStatement.setString(11, staff.getMaNV());
                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}

