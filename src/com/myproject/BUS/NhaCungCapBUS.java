package com.myproject.BUS;

import com.myproject.DAO.NhaCungCapDAO;
import com.myproject.DTO.NhaCungCapDTO;
import java.util.List;

public class NhaCungCapBUS {

    NhaCungCapDAO NCCDAO = new NhaCungCapDAO();

    public List<NhaCungCapDTO> getList() {
        return NCCDAO.getList();
    }

    public boolean AddNccNew(NhaCungCapDTO NewNcc) {
        int rowsAffected = NCCDAO.AddNccNew(NewNcc);
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean UpdateNccNew(NhaCungCapDTO FixNcc) {
        int rowsAffected = NCCDAO.UpdateNccNew(FixNcc);
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
}
