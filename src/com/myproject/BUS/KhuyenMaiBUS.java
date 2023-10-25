package com.myproject.BUS;

import com.myproject.DAO.KhuyenMaiDAO;
import com.myproject.DTO.KhuyenMaiDTO;
import java.util.ArrayList;

public class KhuyenMaiBUS {
    KhuyenMaiDAO km;
    public ArrayList<KhuyenMaiDTO> getAllKM() {
        km = new KhuyenMaiDAO();
        return km.getAllKM();
    }
}
