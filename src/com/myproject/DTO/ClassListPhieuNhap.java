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
public class ClassListPhieuNhap {
    private ArrayList<PhieuNhapDTO> listPhieuNhap;

    public ClassListPhieuNhap() {
        listPhieuNhap = new ArrayList<>();
    }

    public ArrayList<PhieuNhapDTO> getListPhieuNhap() {
        return listPhieuNhap;
    }

    public void setListPhieuNhap(ArrayList<PhieuNhapDTO> listPhieuNhap) {
        this.listPhieuNhap = listPhieuNhap;
    }
}
