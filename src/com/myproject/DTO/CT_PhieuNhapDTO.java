package com.myproject.DTO;

public class CT_PhieuNhapDTO {
    private String MaPN;
    private String MaCT_HH;
    private String MaNCC;
    private float SLNhap;
    private float DonGiaNhap;

    public CT_PhieuNhapDTO(String MaPN, String MaCT_HH, String MaNCC, int SLNhap, float DonGiaNhap) {
        this.MaPN = MaPN;
        this.MaCT_HH = MaCT_HH;
        this.MaNCC = MaNCC;
        this.SLNhap = SLNhap;
        this.DonGiaNhap = DonGiaNhap;
    }

    public CT_PhieuNhapDTO() {
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }
    
    public String getMaCT_HH() {
        return MaCT_HH;
    }

    public void setMaCT_HH(String MaCT_HH) {
        this.MaCT_HH = MaCT_HH;
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
