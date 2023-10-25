package com.myproject.BUS;

import com.myproject.DAO.PhieuNhapDAO;
import com.myproject.DTO.CTPN_CTHH_HH_DTO;
import com.myproject.DTO.PhieuNhapDTO;
import java.util.ArrayList;

public class PhieuNhapBUS {
    PhieuNhapDAO pn;
    public ArrayList<PhieuNhapDTO> getAllPN() {
        pn = new PhieuNhapDAO();
        return pn.getAllPN();
    }
    public ArrayList<CTPN_CTHH_HH_DTO> getAllCTPN() {
        pn = new PhieuNhapDAO();
        return pn.getAllCTPN();
    }

    public boolean DuyetPN(String MaPN) {
        pn = new PhieuNhapDAO();
        return pn.DuyetPN(MaPN);
    }

    public boolean XoaPN(String MaPN) {
        pn = new PhieuNhapDAO();
        return pn.XoaPN(MaPN);
    }
}
