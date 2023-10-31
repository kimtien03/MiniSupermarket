package com.myproject.BUS;

import com.myproject.DAO.CT_HangHoaDAO;
import com.myproject.DTO.CT_HangHoaDTO;
import java.util.ArrayList;
import java.util.List;

public class CT_HangHoaBUS {
    CT_HangHoaDAO CTHH_DAO=new CT_HangHoaDAO();
    public List<CT_HangHoaDTO> getList() {
        return CTHH_DAO.getList();
    }
    
    public boolean insertCTHH(CT_HangHoaDTO cth) {
        CTHH_DAO.insertCTHH(cth);
        return true;
    }
}