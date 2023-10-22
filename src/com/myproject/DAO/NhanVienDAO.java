package com.myproject.DAO;

import com.myproject.BUS.*;
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
    // Lấy toàn bộ danh sách nhân viên
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
            } catch (Exception e) {
            }
        }
        
        return staffArrayList;
    }
}
