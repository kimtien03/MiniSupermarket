package com.myproject.BUS;

import com.myproject.DAO.HangHoaDAO;
import com.myproject.DTO.HH_CTHH_DTO;
import com.myproject.DTO.HangHoaDTO;
import com.myproject.DTO.HangHoaTongDTO;
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
}

