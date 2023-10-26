package com.myproject.BUS;

import com.myproject.DAO.NhaCungCapDAO;
import com.myproject.DTO.NhaCungCapDTO;
import java.util.ArrayList;

public class NhaCungCapBUS {
    NhaCungCapDAO ncc;
    public ArrayList<NhaCungCapDTO> getAllNCC() {
        ncc = new NhaCungCapDAO();
        return ncc.getAllNCC();
    }
    
}
