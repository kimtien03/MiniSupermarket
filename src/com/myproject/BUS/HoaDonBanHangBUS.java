package com.myproject.BUS;

import com.myproject.DAO.HoaDonBanHangDAO;
import com.myproject.DTO.HoaDonBanHangDTO;
import java.util.ArrayList;

public class HoaDonBanHangBUS {
    private HoaDonBanHangDAO hoaDonBanHangDAO = new HoaDonBanHangDAO();
            
    // lấy toàn bộ danh sách hóa đơn bán hàng
    public ArrayList<HoaDonBanHangDTO> getAllBillAsArrayList() {
        return hoaDonBanHangDAO.getALLBillAsArrayList();
    }
    
    // thêm một hóa đơn mới 
    public int addNewBill(HoaDonBanHangDTO bill) {
        return hoaDonBanHangDAO.addBill(bill);
    }
}
