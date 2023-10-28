package com.myproject.DTO;
import java.sql.Timestamp;

public class HoaDonBanHangDTO {
    public String MaHD;
    private Timestamp NgLap;
    private float ThanhTien; 
    private String MaKH;
    private String MaNV;
    
    public HoaDonBanHangDTO(String MaHD, Timestamp NgLap, float ThanhTien, String MaKH, String MaNV) {
        this.MaHD = MaHD;
        this.NgLap = NgLap;
        this.ThanhTien = ThanhTien;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
    }

    public HoaDonBanHangDTO() {
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public Timestamp getNgLap() {
        return NgLap;
    }

    public void setNgLap(Timestamp NgLap) {
        this.NgLap = NgLap;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }
    
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
}
