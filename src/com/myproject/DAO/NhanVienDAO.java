package com.myproject.DAO;

import com.itextpdf.text.log.Logger;
import com.myproject.DTO.NhanVienDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class NhanVienDAO extends conndb{
    // lấy danh sách nhân viên
    public ArrayList<NhanVienDTO> getStaffList() {
        ArrayList<NhanVienDTO> staffList = new ArrayList<NhanVienDTO>();
        
        if (openConnection()) {
            try {

                String sql = "SELECT * FROM nhacungcap WHERE TrangThai = 1";

                ResultSet rs = con.createStatement().executeQuery(sql);

                while (rs.next()) {
                    String MaNV = rs.getString("MaNV");
                    String TenNV = rs.getString("TenNV");
                    String Gioitinh = rs.getString("GioiTinh");
                    String Email = rs.getString("Email");
                    String SDT = rs.getString("SDT");
                    String Passwd = rs.getString("MatKhau");
                    Date NgSinh = rs.getDate("NgSinh");
                    String MaQuyen = rs.getString("MaQuyen");
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    
                    NhanVienDTO staffItem = new NhanVienDTO(MaNV, TenNV, Gioitinh, 
                            Email, SDT, Passwd, NgSinh, MaQuyen, TinhTrang);
                    staffList.add(staffItem);
                }
                closeConnection();

            } catch (SQLException ex) {
                System.out.println("Lỗi trong việc load dữ liệu");
            }
        }
        
        return staffList;
    }
    
    
}
