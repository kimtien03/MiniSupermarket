package com.myproject.DTO;

import java.util.Date;

public class CTPN_CTHH_HH_DTO {
    private String MaHH;
    private String MaCT_HH;
    private String TenHH;
    private Date NgaySX;
    private Date HSD;
    private String MaNCC;
    private float SLNhap;
    private float DonGiaNhap;
    private String MaPN;
    public CTPN_CTHH_HH_DTO() {
    }

    public CTPN_CTHH_HH_DTO(String MaHH, String MaCT_HH, String TenHH, Date NgaySX, Date HSD, String MaNCC, float SLNhap, float DonGiaNhap) {
        this.MaHH = MaHH;
        this.MaCT_HH = MaCT_HH;
        this.TenHH = TenHH;
        this.NgaySX = NgaySX;
        this.HSD = HSD;
        this.MaNCC = MaNCC;
        this.SLNhap = SLNhap;
        this.DonGiaNhap = DonGiaNhap;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public String getMaHH() {
        return MaHH;
    }

    public void setMaHH(String MaHH) {
        this.MaHH = MaHH;
    }

    public String getMaCT_HH() {
        return MaCT_HH;
    }

    public void setMaCT_HH(String MaCT_HH) {
        this.MaCT_HH = MaCT_HH;
    }

    public String getTenHH() {
        return TenHH;
    }

    public void setTenHH(String TenHH) {
        this.TenHH = TenHH;
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

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public float getSLNhap() {
        return SLNhap;
    }

    public void setSLNhap(float SLNhap) {
        this.SLNhap = SLNhap;
    }

    public float getDonGiaNhap() {
        return DonGiaNhap;
    }

    public void setDonGiaNhap(float DonGiaNhap) {
        this.DonGiaNhap = DonGiaNhap;
    }
    
}
