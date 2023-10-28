package com.myproject.BUS;

import com.myproject.DAO.HoaDonBanHangDAO;
import com.myproject.DTO.HoaDonBanHangDTO;
import java.util.List;

public class HoaDonBanHangBUS {
    HoaDonBanHangDAO HDDAO = new HoaDonBanHangDAO();
    public List<HoaDonBanHangDTO> getAllHoaDon() {
        return HDDAO.getAllHoaDon();
    }
}
