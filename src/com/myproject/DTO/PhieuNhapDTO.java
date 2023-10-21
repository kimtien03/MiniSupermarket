package com.myproject.DTO;

public class PhieuNhapDTO {
    private String MaPN;
    private String NgLapPhieu;
    private String MaNV;
    private float ThanhTien;
    private boolean TinhTrang;

    public PhieuNhapDTO(String MaPN, String NgLapPhieu, String MaNV, float ThanhTien, boolean TinhTrang) {
        this.MaPN = MaPN;
        this.NgLapPhieu = NgLapPhieu;
        this.MaNV = MaNV;
        this.ThanhTien = ThanhTien;
        this.TinhTrang = TinhTrang;
    }
    public PhieuNhapDTO() {
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public String getNgLapPhieu() {
        return NgLapPhieu;
    }

    public void setNgLapPhieu(String NgLapPhieu) {
        this.NgLapPhieu = NgLapPhieu;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
}
