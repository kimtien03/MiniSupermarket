     package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.NhomQuyenDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class NhomQuyenDAO extends conndb{
    // lấy toàn bộ trường dữ liệu nhóm quyền
    public ArrayList<NhomQuyenDTO> getAllPermissionAsArrayList() {
        ArrayList<NhomQuyenDTO> permissionArrayList = new ArrayList<NhomQuyenDTO>();
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM NHOMQUYEN";
                ResultSet rs = con.createStatement().executeQuery(sql);
                while(rs.next()) {
                    String MaQuyen = rs.getString("MaQuyen");
                    String TenQuyen = rs.getString("TenQuyen");
                    String Mota = rs.getString("MoTa");
                    NhomQuyenDTO permissionItem = new NhomQuyenDTO(MaQuyen, TenQuyen, Mota);
                    permissionArrayList.add(permissionItem);
                }
            } catch (SQLException e) {
            }
        }
        
        return permissionArrayList;
    }
}
