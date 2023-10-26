package com.myproject.BUS;

import com.myproject.DAO.PhieuNhapDAO;
import com.myproject.DTO.CTPN_CTHH_HH_DTO;
import com.myproject.DTO.PhieuNhapDTO;
import java.util.ArrayList;

public class PhieuNhapBUS {
    PhieuNhapDAO pn;
    public ArrayList<PhieuNhapDTO> getAllPN() {
        pn = new PhieuNhapDAO();
        return pn.getAllPN();
    }
    public ArrayList<CTPN_CTHH_HH_DTO> getAllCTPN() {
        pn = new PhieuNhapDAO();
        return pn.getAllCTPN();
    }

    public boolean DuyetPN(String MaPN) {
        pn = new PhieuNhapDAO();
        return pn.DuyetPN(MaPN);
    }

    public boolean XoaPN(String MaPN) {
        pn = new PhieuNhapDAO();
        return pn.XoaPN(MaPN);
    }

    public String getLastestNum() {
        pn = new PhieuNhapDAO(); 
        String MaCT_HH = pn.getLastestNum().trim();
        int index = Integer.parseInt(MaCT_HH.substring(2));
        return "CT" + String.format("%03d", index+1);
    }

    public boolean addCTPN(CTPN_CTHH_HH_DTO p) {
        pn = new PhieuNhapDAO();
        return pn.addCTPN(p);
    }

    public boolean XoaCTPN(String MaPN, String MaCT_HH) {
        pn = new PhieuNhapDAO();
        return pn.XoaCTPN(MaPN,MaCT_HH);
    }

    public boolean fixCTPN(String maPN, String maCTHH, float soLuong, float donGiaNhap, String NCC, String NSX, String HSD) {
        pn = new PhieuNhapDAO();
        return pn.fixCTPN(maPN,maCTHH,soLuong,donGiaNhap,NCC,NSX,HSD);
    }

    public void updateThanhTien(String MaPN, float thanhTien) {
        pn = new PhieuNhapDAO();
        pn.updateThanhTien(MaPN,thanhTien);
    }
}
