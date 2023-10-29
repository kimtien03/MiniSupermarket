package com.myproject.BUS;

import com.myproject.DAO.CTHD_BanHangDAO;
import com.myproject.DTO.CTHD_BanHangDTO;
import java.util.List;

public class CTHD_BanHangBUS {
    CTHD_BanHangDAO CTDAO=new CTHD_BanHangDAO();
    public List<CTHD_BanHangDTO> getList() {
        return CTDAO.getList();
    }
}
