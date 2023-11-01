package com.myproject.BUS;

import com.myproject.DAO.NhomQuyenDAO;
import com.myproject.DTO.NhomQuyenDTO;
import java.util.ArrayList;

public class NhomQuyenBUS {
    NhomQuyenDAO nq = new NhomQuyenDAO();
    public ArrayList<NhomQuyenDTO> getAllPermissionAsArrayList() {
        return nq.getAllPermissionAsArrayList();
    }
}
