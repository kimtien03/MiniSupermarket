package com.myproject.BUS;

import com.myproject.DAO.HoaDonBanHangDAO;
import com.myproject.DTO.HoaDonBanHangDTO;
import java.util.ArrayList;

import java.util.List;

public class HoaDonBanHangBUS {

    HoaDonBanHangDAO HDBHDAO=new HoaDonBanHangDAO();
    public List<HoaDonBanHangDTO> getList() {
        return HDBHDAO.getList();
    }
    
    
    
    
    //TIENDAT
    // lấy toàn bộ danh sách hóa đơn bán hàng
    public ArrayList<HoaDonBanHangDTO> getAllBillAsArrayList() {
        return HDBHDAO.getALLBillAsArrayList();
    }
    
    // thêm một hóa đơn mới 
    public int addNewBill(HoaDonBanHangDTO bill) {
        return HDBHDAO.addBill(bill);
    }
}

