/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.GUI.NhanVienKho.Sort;

import com.myproject.DTO.PhieuNhapDTO;
import java.util.Comparator;

/**
 *
 * @author ADMIN
 */
public class Sort_PN_farDate implements Comparator<PhieuNhapDTO>{
    @Override
    public int compare(PhieuNhapDTO o1, PhieuNhapDTO o2) {
        return o2.getNgLapPhieu().compareTo(o1.getNgLapPhieu());
    }
}
