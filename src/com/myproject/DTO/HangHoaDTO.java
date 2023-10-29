package com.myproject.DTO;
import java.security.Timestamp;

public class HangHoaDTO {
    private String MaHH;
    private String TenHH;
    private String MaKM;
    private String MaLH;
    private float DonGiaBan;
    private String DonVi;
    private boolean TinhTrang;
    

    public HangHoaDTO(String MaHH, String TenHH, String MaLH, float DonGiaBan, String DonVi, String MaKM ,boolean TinhTrang) {
        this.MaHH = MaHH;
        this.TenHH = TenHH;
        this.MaLH = MaLH;
        this.DonGiaBan = DonGiaBan;
        this.DonVi = DonVi;
        this.MaKM = MaKM;
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

    public String getDonVi() {
        return DonVi;
    }

    public void setDonVi(String DonVi) {
        this.DonVi = DonVi;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
}