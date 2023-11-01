package com.myproject.GUI.NhanVienKho.Sort;

import com.myproject.DTO.PhieuNhapDTO;
import java.util.ArrayList;
import java.util.List;

public class Sorting_Class_PhieuNhapPage {
    
    public void sort_far_ngayNhapPhieu(List<PhieuNhapDTO> phieuNhap_listSort) {
        phieuNhap_listSort.sort(new Sort_PN_recentDate());
    }

    public void sort_recent_ngayNhapPhieu(ArrayList<PhieuNhapDTO> phieuNhap_listSort) {
        phieuNhap_listSort.sort(new Sort_PN_farDate());
    }
}
