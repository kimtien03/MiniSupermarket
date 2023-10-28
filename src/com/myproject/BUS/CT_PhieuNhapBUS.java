package com.myproject.BUS;

import com.myproject.DAO.CT_PhieuNhapDAO;
import com.myproject.DTO.CT_PhieuNhapDTO;
import java.util.List;

public class CT_PhieuNhapBUS {

    CT_PhieuNhapDAO CTPNDAO=new CT_PhieuNhapDAO();

    public List<CT_PhieuNhapDTO> getList() {
        return CTPNDAO.getList();
    }
}
