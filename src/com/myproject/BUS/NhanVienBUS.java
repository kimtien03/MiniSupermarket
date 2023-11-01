package com.myproject.BUS;

import com.myproject.DAO.NhanVienDAO;
import com.myproject.DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.Collections;

public class NhanVienBUS {
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();
    
    // lấy danh sách nhân viên từ lớp DAO
    public ArrayList<NhanVienDTO> getStaffArrayList() {
        return nhanVienDAO.getAllStaffInfoAsArraylist();
    }
    
    // lấy một nhân viên theo mã từ lớp DAO
    public NhanVienDTO getStaffInfoBYID(String MaNV) {
        return nhanVienDAO.getStaffByID(MaNV);
    }
    
    // khóa tài khoản của một nhân viên
    public int blockAccount(NhanVienDTO staff) {
        return nhanVienDAO.updateStaff(staff);
    }
    
    // mở khóa tài khoản của một nhân viên
    public int openAccount(NhanVienDTO staff) {
        return nhanVienDAO.updateStaff(staff);
    }
    
    // lấy danh sách nhân viên theo mã (tìm kiếm)
    public ArrayList<NhanVienDTO> getStaffArrayListByID(String MaNV) {
        return nhanVienDAO.getAllStaffByID(MaNV);
    }
    
    // lấy danh sách nhân viên theo tên (tìm kiếm)
    public ArrayList<NhanVienDTO> getStaffArrayListByName(String TenNV) {
        return nhanVienDAO.getAllStaffByName(TenNV);
    }
    
    // lấy danh sách nhân viên theo chức vụ (lọc)
    public ArrayList<NhanVienDTO> getStaffArrayListByPosition(String ChucVu) {
        return nhanVienDAO.getAllStaffByPosition(ChucVu);
    }
    
    // cập nhật thông tin cho nhân viên
    public int updateStaffInfo(NhanVienDTO staff) {
        return nhanVienDAO.updateStaff(staff);
    }
}
