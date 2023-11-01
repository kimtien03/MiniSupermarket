package com.myproject.DTO;

import java.util.ArrayList;

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
