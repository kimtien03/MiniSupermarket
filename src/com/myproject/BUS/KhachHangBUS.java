package com.myproject.BUS;

import com.myproject.DAO.KhachHangDAO;
import com.myproject.DTO.KhachHangDTO;
import java.util.ArrayList;
import java.util.List;

public class KhachHangBUS {
    KhachHangDAO KHDAO=new KhachHangDAO();
    public List<KhachHangDTO> getList() {
        return KHDAO.getList();
    }
    public boolean AddKhNew(KhachHangDTO newkh) {
        int rowsAffected = KHDAO.AddKhNew(newkh);
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean UpdatekhNew(KhachHangDTO Fixkh) {
        int rowsAffected = KHDAO.UpdateKhNew(Fixkh);
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
    
    
    // TIENDAT
    // lấy danh sách khách hàng từ lớp DAO
    public ArrayList<KhachHangDTO> getCusArrayList() {
        return KHDAO.getAllCusInfoAsArrayList();
    }
    
    // lấy một khách hàng theo tên
    public KhachHangDTO getCusByName(String HoTen) {
        return KHDAO.getCusByName(HoTen);
    }
    
    // lấy một khách hàng theo số điện thoại
    public KhachHangDTO getCusByPhoneNum(String SDT) {
        return KHDAO.getCusByPhoneNum(SDT);
    }
    
    // lấy thông tin của khách vãng lai
    public KhachHangDTO getTransientGuests() {
        return KHDAO.getCasualGuests();
    }
    
    // thêm một khách hàng vào cơ sở dữ liệu 
    public int addCustomer(KhachHangDTO customer) {
        return KHDAO.addCustomer(customer);
    }
}
