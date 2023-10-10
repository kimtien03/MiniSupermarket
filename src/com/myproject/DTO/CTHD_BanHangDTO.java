package com.myproject.DTO;

public class CTHD_BanHangDTO {
    private String MaHD;
    private String MaHH;
    private float SLBan;

    public CTHD_BanHangDTO() {
    }

    public CTHD_BanHangDTO(String MaHD, String MaHH, float SLBan) {
        this.MaHD = MaHD;
        this.MaHH = MaHH;
        this.SLBan = SLBan;
    }
    
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }
    
    public String getMaHH() {
        return MaHH;
    }

    public void setMaHH(String MaHH) {
        this.MaHH = MaHH;
    }
    
    public float getSLBan() {
        return SLBan;
    }

    public void setSLBan(float SLBan) {
        this.SLBan = SLBan;
    }
}
