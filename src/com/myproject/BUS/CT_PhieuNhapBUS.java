package com.myproject.BUS;

import com.myproject.DAO.CT_PhieuNhapDAO;
import com.myproject.DTO.CT_PhieuNhapDTO;
import java.util.ArrayList;

public class CT_PhieuNhapBUS {
    private CT_PhieuNhapDAO CT_phieuNhapDAO;
    
    public CT_PhieuNhapBUS() { 
        CT_phieuNhapDAO = new CT_PhieuNhapDAO();
    }
    
    public ArrayList<CT_PhieuNhapDTO> getAll_CTPhieuNhap() {
        return CT_phieuNhapDAO.getAll_CT_PhieuNhap();
    }
    
    public ArrayList<CT_PhieuNhapDTO> find_CTPN_row(String ID_PN) {
        return CT_phieuNhapDAO.find_CT_PhieuNhapByRow(ID_PN);
    }
    
}
