package com.myproject.BUS;

import com.myproject.DAO.HoaDonBanHangDAO;
import com.myproject.DTO.HoaDonBanHangDTO;
import java.util.List;

public class HoaDonBanHangBUS {

    HoaDonBanHangDAO HDBHDAO=new HoaDonBanHangDAO();
    public List<HoaDonBanHangDTO> getList() {
        return HDBHDAO.getList();
    }
    public List<HoaDonBanHangDTO> getAllHoaDon() {
        return HDBHDAO.getAllHoaDon();
    }
}