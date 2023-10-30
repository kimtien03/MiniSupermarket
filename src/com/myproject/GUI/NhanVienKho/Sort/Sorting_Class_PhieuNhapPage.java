package com.myproject.GUI.NhanVienKho.Sort;

import com.myproject.DTO.PhieuNhapDTO;
import java.util.ArrayList;
import java.util.List;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Sorting_Class_PhieuNhapPage {
    
    public void sort_far_ngayNhapPhieu(List<PhieuNhapDTO> phieuNhap_listSort) {
        phieuNhap_listSort.sort(new Sort_PN_recentDate());
    }

    public void sort_recent_ngayNhapPhieu(ArrayList<PhieuNhapDTO> phieuNhap_listSort) {
        phieuNhap_listSort.sort(new Sort_PN_farDate());
    }
}
