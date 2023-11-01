package com.myproject.BUS;

import com.myproject.DAO.HangHoaDAO;
import com.myproject.DTO.HangHoaDTO;

public class HangHoaBUS {
    private HangHoaDAO  hangHoaDAO = new HangHoaDAO();
    
    // lấy một hàng hóa theo mã hàng hóa
    public HangHoaDTO getProductByID(String MaHH) {
        return hangHoaDAO.getProductByID(MaHH);
    }
}
