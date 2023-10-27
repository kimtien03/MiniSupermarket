package com.myproject.BUS;

import com.myproject.DAO.LoaiHangDAO;
import com.myproject.DTO.LoaiHangDTO;
import java.util.List;

public class LoaiHangBUS{
    LoaiHangDAO LHDAO=new LoaiHangDAO();
    public List<LoaiHangDTO> getList() {
        return LHDAO.getList();
    }
}
