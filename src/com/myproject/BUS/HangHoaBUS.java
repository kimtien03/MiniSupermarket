package com.myproject.BUS;

import com.myproject.DAO.HangHoaDAO;
import com.myproject.DTO.CT_HangHoaDTO;
import com.myproject.DTO.HH_CTHH_DTO;
import com.myproject.DTO.HangHoaDTO;
import com.myproject.DTO.HangHoaTongDTO;
import com.myproject.DTO.LoaiHangDTO;
import java.util.ArrayList;
import java.util.List;

public class HangHoaBUS {
    HangHoaDAO hh;
    public ArrayList<HH_CTHH_DTO> getAllHHFormFixPN() {
        hh = new HangHoaDAO();
        return hh.getAllHHFormFixPN();
    }
    public List<HangHoaTongDTO> getAllHangHoa() {
        hh = new HangHoaDAO();
        return hh.getAllHangHoa();
    }
    public List<HangHoaDTO> getList() {
        hh = new HangHoaDAO();
        return hh.getList();
    }
    public boolean updateTinhTrangHangHoa(String maHH, boolean newTinhTrang) {
        hh = new HangHoaDAO();
        return hh.updateTinhTrangHangHoa(maHH, newTinhTrang);
    }
    
    public int getCountHH() {
        hh = new HangHoaDAO();
        return hh.getAllCount();
    }

    public boolean insertHangHoa(HangHoaDTO hhDTO) {
        hh = new HangHoaDAO();
        hh.insertHangHoa(hhDTO);
        return true;
    }

    public ArrayList<HangHoaDTO> getListHHTotal(ArrayList<CT_HangHoaDTO> listCTHH, ArrayList<LoaiHangDTO> listLH) {
        hh = new HangHoaDAO();
        return hh.getHangHoaTotal(listCTHH, listLH);
    }

    public boolean insertHH(HangHoaDTO hh) {
        HangHoaDAO x = new HangHoaDAO();
        return x.insertHangHoa(hh);
    }
    
    public ArrayList<Float> getHangSL() {
        hh = new HangHoaDAO();
        return hh.getHangSL();
    }
    
    public boolean updateHang(String maHH, String maLH, boolean tinhTrang) {
        hh = new HangHoaDAO();
        hh.updateHang(maHH, maLH, tinhTrang);
        return true;
    }
    
    
    // TIENDAT
    public HangHoaDTO getProductByID(String MaHH) {
        return hh.getProductByID(MaHH);
    }
}
