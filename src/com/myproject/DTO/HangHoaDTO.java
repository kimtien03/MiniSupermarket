package com.myproject.DTO;
import java.security.Timestamp;

public class HangHoaDTO {
    private String MaHH;
    private String TenHH;
    private Timestamp NgaySX;
    private Timestamp HSD;
    private String MaLH;
    private float DonGiaBan;
    private float SoLuong;
    private String DonVi;
    private boolean TinhTrang;
    

    public HangHoaDTO(String MaHH, String TenHH, Timestamp NgaySX, Timestamp HSD, String MaLH, float DonGiaBan, float SoLuong, String DonVi, boolean TinhTrang) {
        this.MaHH = MaHH;
        this.TenHH = TenHH;
        this.NgaySX = NgaySX;
        this.HSD = HSD;
        this.MaLH = MaLH;
        this.DonGiaBan = DonGiaBan;
        this.SoLuong = SoLuong;
        this.DonVi = DonVi;
        this.TinhTrang = TinhTrang;
    }

    

    public HangHoaDTO() {
    }

    public String getMaHH() {
        return MaHH;
    }

    public void setMaHH(String MaHH) {
        this.MaHH = MaHH;
    }

    public String getTenHH() {
        return TenHH;
    }

    public void setTenHH(String TenHH) {
        this.TenHH = TenHH;
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

    public String getMaLH() {
        return MaLH;
    }

    public void setMaLH(String MaLH) {
        this.MaLH = MaLH;
    }
    
    public float getDonGiaBan() {
        return DonGiaBan;
    }

    public void setDonGiaBan(float DonGiaBan) {
        this.DonGiaBan = DonGiaBan;
    }

    public float getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(float SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getDonVi() {
        return DonVi;
    }

    public void setDonVi(String DonVi) {
        this.DonVi = DonVi;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
}
