package com.myproject.BUS;

import com.myproject.DAO.KhachHangDAO;
import com.myproject.DTO.KhachHangDTO;
import java.util.List;

public class KhachHangBUS {
    KhachHangDAO KHDAO=new KhachHangDAO();
    public List<KhachHangDTO> getList() {
        return KHDAO.getList();
    }
    public boolean AddKhNew(KhachHangDTO newkh) {
        int rowsAffected = KHDAO.AddKhNew(newkh);
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean UpdatekhNew(KhachHangDTO Fixkh) {
        int rowsAffected = KHDAO.UpdateKhNew(Fixkh);
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
}
