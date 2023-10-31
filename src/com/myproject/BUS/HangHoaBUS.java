package com.myproject.BUS;

import com.myproject.DAO.HangHoaDAO;
import com.myproject.DTO.CT_HangHoaDTO;
import com.myproject.DTO.HangHoaDTO;
import com.myproject.DTO.HangHoaTongDTO;
import com.myproject.DTO.LoaiHangDTO;
import java.util.ArrayList;
import java.util.List;

public class HangHoaBUS {

    public ArrayList<HangHoaDTO> getAllHH() {
        HangHoaDAO hh = new HangHoaDAO();
        return hh.getAllMaHH();
    }
    
    public int getCountHH() {
        HangHoaDAO hh = new HangHoaDAO();
        return hh.getAllCount();
    }

    public boolean insertHangHoa(HangHoaDTO hhDTO) {
        HangHoaDAO hh = new HangHoaDAO();
        hh.insertHangHoa(hhDTO);
        return true;
    }

    public ArrayList<HangHoaDTO> getListHHTotal(ArrayList<CT_HangHoaDTO> listCTHH, ArrayList<LoaiHangDTO> listLH) {
        HangHoaDAO hh = new HangHoaDAO();
        return hh.getHangHoaTotal(listCTHH, listLH);
    }

    public boolean insertHH(HangHoaDTO hh) {
        HangHoaDAO x = new HangHoaDAO();
        return x.insertHangHoa(hh);
    }
    
    public ArrayList<Float> getHangSL() {
        HangHoaDAO hh = new HangHoaDAO();
        return hh.getHangSL();
    }
    
    public boolean updateHang(String maHH, String maLH, boolean tinhTrang) {
        HangHoaDAO hh = new HangHoaDAO();
        hh.updateHang(maHH, maLH, tinhTrang);
        return true;
    }
    
    
}
