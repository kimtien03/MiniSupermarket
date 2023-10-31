package com.myproject.BUS;

import com.myproject.DTO.PhieuNhapDTO;
import com.myproject.DAO.PhieuNhapDAO;
import java.util.ArrayList;

public class PhieuNhapBUS {
    public boolean insertPhieu(PhieuNhapDTO pn) {
        PhieuNhapDAO cp = new PhieuNhapDAO();
        cp.insertPhieuNhap(pn);
        return true;
    }
    
    public ArrayList<PhieuNhapDTO> getAllPN() {
        PhieuNhapDAO pn = new PhieuNhapDAO();
        return pn.getAllPN();
    }
}
