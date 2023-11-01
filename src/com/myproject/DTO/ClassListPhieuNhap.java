package com.myproject.DTO;

import java.util.ArrayList;

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
