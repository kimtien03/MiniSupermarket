package com.myproject.BUS;


import com.myproject.DAO.KhuyenMaiDAO;
import com.myproject.DTO.HangHoaTongDTO;
import com.myproject.DTO.KhuyenMaiDTO;
import java.util.List;

public class KhuyenMaiBUS {
    KhuyenMaiDAO KMDAO = new KhuyenMaiDAO();
    public List<KhuyenMaiDTO> getAllKhuyenMai() {
        return KMDAO.getAllKhuyenMai();
    }

}
