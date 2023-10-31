package com.myproject.BUS;

import com.myproject.DAO.NhaCungCapDAO;
import com.myproject.DTO.NhaCungCapDTO;
import java.util.ArrayList;

public class NhaCungCapBUS {
    public ArrayList<NhaCungCapDTO> getAllNCC() {
        NhaCungCapDAO ncc = new NhaCungCapDAO();
        return ncc.getAllNCC();
    }
}
