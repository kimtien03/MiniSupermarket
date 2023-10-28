package com.myproject.BUS;

import com.myproject.DAO.HangHoaDAO;
import com.myproject.DTO.HH_CTHH_DTO;
import java.util.ArrayList;

public class HangHoaBUS {
    HangHoaDAO hh;
    public ArrayList<HH_CTHH_DTO> getAllHHFormFixPN() {
        hh = new HangHoaDAO();
        return hh.getAllHHFormFixPN();
    }
    
}
