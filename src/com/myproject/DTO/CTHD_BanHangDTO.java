package com.myproject.DTO;

public class CTHD_BanHangDTO {
    private String MaHD;
    private String MaCT_HH;
    private float SLBan;

    public CTHD_BanHangDTO() {
    }

    public CTHD_BanHangDTO(String MaHD, String MaCT_HH, float SLBan) {
        this.MaHD = MaHD;
        this.MaCT_HH = MaCT_HH;
        this.SLBan = SLBan;
    }
    
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }
    
    public String getMaCT_HH() {
        return MaCT_HH;
    }

    public void setMaCT_HH(String MaCT_HH) {
        this.MaCT_HH = MaCT_HH;
    }
    
    public float getSLBan() {
        return SLBan;
    }

    public void setSLBan(float SLBan) {
        this.SLBan = SLBan;
    }
}
