package com.myproject.DTO;

public class CT_PhieuNhapDTO {
    private String MaPN;
    private String MaHH;
    private String MaNCC;
    private float SLNhap;
    private float DonGiaNhap;

    public CT_PhieuNhapDTO(String MaPN, String MaHH, String MaNCC, int SLNhap, float DonGiaNhap) {
        this.MaPN = MaPN;
        this.MaHH = MaHH;
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
    
    public String getMaHH() {
        return MaHH;
    }

    public void setMaHH(String MaHH) {
        this.MaHH = MaHH;
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
