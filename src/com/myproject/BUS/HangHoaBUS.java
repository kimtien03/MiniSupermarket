package com.myproject.BUS;

import com.myproject.DAO.HangHoaDAO;
import com.myproject.DTO.HangHoaDTO;
import com.myproject.DTO.HangHoaTongDTO;
import java.util.List;

public class HangHoaBUS {

    HangHoaDAO HHDAO = new HangHoaDAO();

    public List<HangHoaTongDTO> getAllHangHoa() {
        return HHDAO.getAllHangHoa();
    }

    public List<HangHoaDTO> getList() {
        return HHDAO.getList();
    }
}