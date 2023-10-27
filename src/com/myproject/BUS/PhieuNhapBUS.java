package com.myproject.BUS;

import com.myproject.DAO.PhieuNhapDAO;
import com.myproject.DTO.PhieuNhapDTO;
import java.util.ArrayList;

public class PhieuNhapBUS {
    private  PhieuNhapDAO phieuNhapDAO;
    
    public PhieuNhapBUS() { 
        phieuNhapDAO = new PhieuNhapDAO();
    }
    
    public ArrayList<PhieuNhapDTO> getAll_CTPhieuNhap() {
        return phieuNhapDAO.getAll_PhieuNhap();
    }
    
    public ArrayList<PhieuNhapDTO> find_PhieuNhap_By_MaSP(String maSP) {
        return phieuNhapDAO.find_PhieuNhap_By_MaSP(maSP);
    }
    
    public ArrayList<PhieuNhapDTO> find_PhieuNhap_By_ngayYC(String ngayYC) {
        return phieuNhapDAO.find_PhieuNhap_By_ngayYC(ngayYC);
    }
    
    public ArrayList<PhieuNhapDTO> find_PhieuNhap_By_maNCC(String maNCC) {
        return phieuNhapDAO.find_PhieuNhap_By_maNCC(maNCC);
    }
    
    
    public ArrayList<PhieuNhapDTO> find_PhieuNhap_By_tinhTrang(String tinhTrang) {
        return phieuNhapDAO.find_PhieuNhap_By_tinhTrang(tinhTrang);
    }
}
