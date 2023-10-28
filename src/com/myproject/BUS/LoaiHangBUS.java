package com.myproject.BUS;

import com.myproject.DAO.LoaiHangDAO;
import com.myproject.DTO.LoaiHangDTO;
import java.util.List;
import java.util.ArrayList;

public class LoaiHangBUS {
    LoaiHangDAO lh;
    public ArrayList<LoaiHangDTO> getALLLH() {
        lh = new LoaiHangDAO();
        return lh.getAllLH();
    }

    public boolean addLH(String MaLH, String TenLH) {
        lh = new LoaiHangDAO();
        return lh.addLH(MaLH,TenLH);
    }

    public boolean fixLH(String MaLH, String TenLH, boolean TinhTrang) {
        lh = new LoaiHangDAO();
        return lh.fixLH(MaLH,TenLH,TinhTrang);
    }
    public List<LoaiHangDTO> getList() {
        lh = new LoaiHangDAO();
        return lh.getList();

    }
}
