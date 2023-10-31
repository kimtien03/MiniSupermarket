package com.myproject.BUS;

import com.myproject.DAO.CT_PhieuNhapDAO;
import com.myproject.DTO.CT_PhieuNhapDTO;

public class CT_PhieuNhapBUS {
    public boolean insertCTPhieu(CT_PhieuNhapDTO ct) {
        CT_PhieuNhapDAO cp = new CT_PhieuNhapDAO();
        cp.insertCTPhieuNhap(ct);
        return true;
    }
}
