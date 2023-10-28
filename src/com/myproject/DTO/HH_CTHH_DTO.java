package com.myproject.DTO;

public class HH_CTHH_DTO {
    private String MaHH;
    private String TenHH;
    private float SoLuong;

    public HH_CTHH_DTO() {
    }

    public HH_CTHH_DTO(String MaHH, String TenHH, float SoLuong) {
        this.MaHH = MaHH;
        this.TenHH = TenHH;
        this.SoLuong = SoLuong;
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

    public float getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(float SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}
