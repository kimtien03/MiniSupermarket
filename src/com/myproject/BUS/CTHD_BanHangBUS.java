package com.myproject.BUS;

import com.myproject.DAO.CTHD_BanHangDAO;
import com.myproject.DTO.CTHD_BanHangDTO;
import java.util.ArrayList;
import java.util.List;

public class CTHD_BanHangBUS {
    CTHD_BanHangDAO CTDAO=new CTHD_BanHangDAO();
    public List<CTHD_BanHangDTO> getList() {
        return CTDAO.getList();
    }
    
    // TIẾN ĐẠT
    // lấy toàn bộ trường dữ liệu chi tiết hóa đơn
    public ArrayList<CTHD_BanHangDTO> getAllDetailsBill() {
        return CTDAO.getAllBillDetails();
    }
    
    // thêm danh sach chi tiết hóa đơn 
    public int addBillDetails(ArrayList<CTHD_BanHangDTO> billDetailsList) {
        int check = -1;
        for (CTHD_BanHangDTO billDetailsItem : billDetailsList) {
            check = CTDAO.addBillDetails(billDetailsItem);
        }
        return check;
    }
}
