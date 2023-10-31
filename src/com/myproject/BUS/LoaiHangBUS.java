package com.myproject.BUS;

import com.myproject.DAO.LoaiHangDAO;
import com.myproject.DTO.LoaiHangDTO;
import java.util.ArrayList;

public class LoaiHangBUS {
    public ArrayList<LoaiHangDTO> getAllMaLH() {
        LoaiHangDAO lh = new LoaiHangDAO();
        return lh.getAllMaLH();
    }
    
    public String findTen(String maLH) {
        LoaiHangDAO lh = new LoaiHangDAO();
        return lh.findLH(maLH);
    }
}
