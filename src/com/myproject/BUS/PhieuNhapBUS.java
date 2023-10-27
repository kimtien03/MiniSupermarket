package com.myproject.BUS;

import com.myproject.DAO.PhieuNhapDAO;
import com.myproject.DTO.PhieuNhapDTO;
import java.util.List;

public class PhieuNhapBUS {
    PhieuNhapDAO PNDAO=new PhieuNhapDAO();
    public List<PhieuNhapDTO> getList() {
        return PNDAO.getList();
    }
}