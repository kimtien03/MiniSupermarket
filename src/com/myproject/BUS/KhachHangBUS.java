package com.myproject.BUS;

import com.myproject.DAO.KhachHangDAO;
import com.myproject.DTO.KhachHangDTO;
import java.util.List;

public class KhachHangBUS {
    KhachHangDAO KHDAO=new KhachHangDAO();
    public List<KhachHangDTO> getList() {
        return KHDAO.getList();
    }
}
