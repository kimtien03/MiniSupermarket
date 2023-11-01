package com.myproject.BUS;

import com.myproject.DAO.NhanVienDAO;
import com.myproject.DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.List;

public class NhanVienBUS {
    NhanVienDAO NVDAO=new NhanVienDAO();
    public List<NhanVienDTO> getList() {
        return NVDAO.getList();
    }
    public boolean AddNvNew(NhanVienDTO NewNv) {
        int rowsAffected = NVDAO.AddNvNew(NewNv);
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean UpdateNvNew(NhanVienDTO FixNv) {
        int rowsAffected = NVDAO.UpdateNvNew(FixNv);
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean UpdateMK(String maNV,String mk) {
        return NVDAO.UpdateMK(maNV,mk);
    }
    
    
    
    
    
    // TIENDAT
    // lấy danh sách nhân viên từ lớp DAO
    public ArrayList<NhanVienDTO> getStaffArrayList() {
        return NVDAO.getAllStaffInfoAsArraylist();
    }
    
    // lấy một nhân viên theo mã từ lớp DAO
    public NhanVienDTO getStaffInfoBYID(String MaNV) {
        return NVDAO.getStaffByID(MaNV);
    }
    
    // khóa tài khoản của một nhân viên
    public int blockAccount(NhanVienDTO staff) {
        return NVDAO.updateStaff(staff);
    }
    
    // mở khóa tài khoản của một nhân viên
    public int openAccount(NhanVienDTO staff) {
        return NVDAO.updateStaff(staff);
    }
    
    // lấy danh sách nhân viên theo mã (tìm kiếm)
    public ArrayList<NhanVienDTO> getStaffArrayListByID(String MaNV) {
        return NVDAO.getAllStaffByID(MaNV);
    }
    
    // lấy danh sách nhân viên theo tên (tìm kiếm)
    public ArrayList<NhanVienDTO> getStaffArrayListByName(String TenNV) {
        return NVDAO.getAllStaffByName(TenNV);
    }
    
    // lấy danh sách nhân viên theo chức vụ (lọc)
    public ArrayList<NhanVienDTO> getStaffArrayListByPosition(String ChucVu) {
        return NVDAO.getAllStaffByPosition(ChucVu);
    }
    
    // cập nhật thông tin cho nhân viên
    public int updateStaffInfo(NhanVienDTO staff) {
        return NVDAO.updateStaff(staff);
    }
}

