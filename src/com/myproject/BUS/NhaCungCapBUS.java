package com.myproject.BUS;
import com.myproject.DAO.NhaCungCapDAO;
import com.myproject.DTO.NhaCungCapDTO;

import java.util.ArrayList;
import java.util.List;

public class NhaCungCapBUS {
    NhaCungCapDAO ncc;
    public ArrayList<NhaCungCapDTO> getAllNCC() {
        ncc = new NhaCungCapDAO();
        return ncc.getAllNCC();
    }
    public List<NhaCungCapDTO> getList() {
        ncc = new NhaCungCapDAO();
        return ncc.getList();
    }

    public boolean AddNccNew(NhaCungCapDTO NewNcc) {
        ncc = new NhaCungCapDAO();
        int rowsAffected = ncc.AddNccNew(NewNcc);
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean UpdateNccNew(NhaCungCapDTO FixNcc) {
        ncc = new NhaCungCapDAO();
        int rowsAffected = ncc.UpdateNccNew(FixNcc);
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
}
