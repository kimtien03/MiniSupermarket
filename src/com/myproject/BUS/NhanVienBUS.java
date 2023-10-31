package com.myproject.BUS;

import com.myproject.DAO.NhanVienDAO;
import com.myproject.DTO.NhanVienDTO;
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
}
