package com.myproject.BUS;

import com.myproject.DAO.KhachHangDAO;
import com.myproject.DTO.KhachHangDTO;
import java.util.ArrayList;

public class KhachHangBUS {
    private KhachHangDAO khachHangDAO = new KhachHangDAO();
    
    // lấy danh sách khách hàng từ lớp DAO
    public ArrayList<KhachHangDTO> getCusArrayList() {
        return khachHangDAO.getAllCusInfoAsArrayList();
    }
    
    // lấy một khách hàng theo tên
    public KhachHangDTO getCusByName(String HoTen) {
        return khachHangDAO.getCusByName(HoTen);
    }
    
    // lấy một khách hàng theo số điện thoại
    public KhachHangDTO getCusByPhoneNum(String SDT) {
        return khachHangDAO.getCusByPhoneNum(SDT);
    }
    
    // lấy thông tin của khách vãng lai
    public KhachHangDTO getTransientGuests() {
        return khachHangDAO.getCasualGuests();
    }
    
    // thêm một khách hàng vào cơ sở dữ liệu 
    public int addCustomer(KhachHangDTO customer) {
        return khachHangDAO.addCustomer(customer);
    }
}
