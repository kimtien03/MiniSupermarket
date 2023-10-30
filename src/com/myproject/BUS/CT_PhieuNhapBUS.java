package com.myproject.BUS;

import com.myproject.DAO.CT_PhieuNhapDAO;
import com.myproject.DTO.CT_PhieuNhapDTO;
import java.util.ArrayList;
import java.util.List;

public class CT_PhieuNhapBUS {

    CT_PhieuNhapDAO CTPNDAO=new CT_PhieuNhapDAO();

    public List<CT_PhieuNhapDTO> getList() {
        return CTPNDAO.getList();
    }
    
    public ArrayList<CT_PhieuNhapDTO> getAll_CTPhieuNhap() {
        return CTPNDAO.getAll_CT_PhieuNhap();
    }
    
    public ArrayList<CT_PhieuNhapDTO> find_CTPN_row(String ID_PN) {
        return CTPNDAO.find_CT_PhieuNhapByRow(ID_PN);
    }
}