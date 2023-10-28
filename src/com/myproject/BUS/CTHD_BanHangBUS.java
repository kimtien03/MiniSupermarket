package com.myproject.BUS;

import com.myproject.DAO.CTHD_BanHangDAO;
import com.myproject.DTO.CTHD_BanHangDTO;

import java.util.List;
public class CTHD_BanHangBUS {
    CTHD_BanHangDAO CTHDDAO = new CTHD_BanHangDAO();
    public List<CTHD_BanHangDTO> getAllCT_HoaDon() {
        return CTHDDAO.getAllCT_HoaDon();
    }
}
