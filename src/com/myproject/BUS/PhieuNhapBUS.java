package com.myproject.BUS;

import com.myproject.DAO.PhieuNhapDAO;
import com.myproject.DTO.PhieuNhapDTO;
import java.util.ArrayList;

public class PhieuNhapBUS {
    PhieuNhapDAO pn;
    public ArrayList<PhieuNhapDTO> getAllPN() {
        pn = new PhieuNhapDAO();
        return pn.getAllPN();
    }
}
