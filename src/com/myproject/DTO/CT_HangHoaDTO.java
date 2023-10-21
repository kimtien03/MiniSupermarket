package com.myproject.DTO;

import java.security.Timestamp;

public class CT_HangHoaDTO {
    private String MaCT_HH;
    private String MaHH;
    private Timestamp NgaySX;
    private Timestamp HSD;
    private float SoLuong;
    private boolean TinhTrang;

    public CT_HangHoaDTO() {
    }

    public CT_HangHoaDTO(String MaCT_HH, String MaHH, Timestamp NgaySX, Timestamp HSD, float SoLuong, boolean TinhTrang) {
        this.MaCT_HH = MaCT_HH;
        this.MaHH = MaHH;
        this.NgaySX = NgaySX;
        this.HSD = HSD;
        this.SoLuong = SoLuong;
        this.TinhTrang = TinhTrang;
    }

    public String getMaCT_HH() {
        return MaCT_HH;
    }

    public void setMaCT_HH(String MaCT_HH) {
        this.MaCT_HH = MaCT_HH;
    }

    public String getMaHH() {
        return MaHH;
    }

    public void setMaHH(String MaHH) {
        this.MaHH = MaHH;
    }

    public Timestamp getNgaySX() {
        return NgaySX;
    }

    public void setNgaySX(Timestamp NgaySX) {
        this.NgaySX = NgaySX;
    }

    public Timestamp getHSD() {
        return HSD;
    }

    public void setHSD(Timestamp HSD) {
        this.HSD = HSD;
    }

    public float getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(float SoLuong) {
        this.SoLuong = SoLuong;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
}
