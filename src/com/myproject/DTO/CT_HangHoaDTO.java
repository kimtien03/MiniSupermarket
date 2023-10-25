package com.myproject.DTO;

import java.util.Date;

public class CT_HangHoaDTO {
    private String MaCT_HH;
    private String MaHH;
    private Date NgaySX;
    private Date HSD;
    private float SoLuong;
    private boolean TinhTrang;

    public CT_HangHoaDTO() {
    }

    public CT_HangHoaDTO(String MaCT_HH, String MaHH, Date NgaySX, Date HSD, float SoLuong, boolean TinhTrang) {
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

    public Date getNgaySX() {
        return NgaySX;
    }

    public void setNgaySX(Date NgaySX) {
        this.NgaySX = NgaySX;
    }

    public Date getHSD() {
        return HSD;
    }

    public void setHSD(Date HSD) {
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
