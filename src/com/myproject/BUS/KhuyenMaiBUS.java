package com.myproject.BUS;

import com.myproject.DAO.KhuyenMaiDAO;
import com.myproject.DTO.KhuyenMaiDTO;

public class KhuyenMaiBUS {
    KhuyenMaiDAO khuyenMaiDAO = new KhuyenMaiDAO();
    
    // lấy khuyễn mãi theo mã khuyến mãi
    public KhuyenMaiDTO getPromtionByID(String MaKM) {
        return khuyenMaiDAO.getPromotion(MaKM);
    }
}
