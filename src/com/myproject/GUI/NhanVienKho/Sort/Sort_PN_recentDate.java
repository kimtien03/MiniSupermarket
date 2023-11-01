package com.myproject.GUI.NhanVienKho.Sort;

import com.myproject.DTO.PhieuNhapDTO;
import java.util.Comparator;

public class Sort_PN_recentDate implements Comparator<PhieuNhapDTO>{
     @Override
    public int compare(PhieuNhapDTO o1, PhieuNhapDTO o2) {
        return o1.getNgLapPhieu().compareTo(o2.getNgLapPhieu());
    }
}
