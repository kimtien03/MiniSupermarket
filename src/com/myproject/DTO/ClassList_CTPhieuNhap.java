
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class ClassList_CTPhieuNhap {
        private ArrayList<CT_PhieuNhapDTO> list_CT_PhieuNhap;

    public ClassList_CTPhieuNhap() {
        list_CT_PhieuNhap = new ArrayList<>();
    }

    public ArrayList<CT_PhieuNhapDTO> getList_CT_PhieuNhap() {
        return list_CT_PhieuNhap;
    }

    public void setList_CT_PhieuNhap(ArrayList<CT_PhieuNhapDTO> list_CT_PhieuNhap) {
        this.list_CT_PhieuNhap = list_CT_PhieuNhap;
    }
}
