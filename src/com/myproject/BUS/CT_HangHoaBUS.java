package com.myproject.BUS;

import com.myproject.DAO.CT_HangHoaDAO;
import com.myproject.DTO.CT_HangHoaDTO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CT_HangHoaBUS {
    CT_HangHoaDAO CTHH_DAO=new CT_HangHoaDAO();
    public List<CT_HangHoaDTO> getList() {
        return CTHH_DAO.getList();
    }
    
    public boolean insertCTHH(CT_HangHoaDTO cth) {
        CTHH_DAO.insertCTHH(cth);
        return true;
    }
    public void AutoUpdateCT_HH(Date date) {
        CTHH_DAO.AutoUpdateCT_HH(date);
    }
    
    
    // TIẾN ĐẠT
    // lấy danh sách chi tiết hàng hóa theo mã hàng hóa
    public ArrayList<CT_HangHoaDTO> getProductDetailsByProductID(String MaHH) {
        return this.CTHH_DAO.getProductDetailsByProductID(MaHH);
    }
    
    // lấy chi tiết hàng hóa theo mã hàng hóa
    public CT_HangHoaDTO getProductDetailsByID(String MaCT_HH) {
        return CTHH_DAO.getProductDetailsByID(MaCT_HH);
    }
    
    // cập nhật lại số lượng trong kho 
    public int updateQuantityOfProduct1(String MaCT_HH) {
        return CTHH_DAO.updateQuantityOfProduct1(MaCT_HH);
    }
    
    public int updateQuantityOfProduct2(String MaCT_HH, float soluong, boolean TinhTrang) {
        return CTHH_DAO.updateQuantityOfProduct2(MaCT_HH, soluong, TinhTrang);
    }
}