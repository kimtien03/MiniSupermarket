package com.myproject.BUS;

import com.myproject.DAO.NhanVienDAO;
import com.myproject.DTO.NhanVienDTO;
import java.util.ArrayList;

public class NhanVienBUS {
    // lấy dữ liệu nhân viên từ lớp DAO
    public ArrayList<NhanVienDTO> getStaffList() {
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        return nhanVienDAO.getStaffList();
    }
}
