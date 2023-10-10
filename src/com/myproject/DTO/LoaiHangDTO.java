package com.myproject.DTO;

public class LoaiHangDTO {
    private String MaLH;
    private String TenLH;
    private boolean TinhTrang;

    public LoaiHangDTO(String MaLH, String TenLH, boolean TinhTrang) {
        this.MaLH = MaLH;
        this.TenLH = TenLH;
        this.TinhTrang = TinhTrang;
    }

    public LoaiHangDTO() {
    }

    public String getMaLH() {
        return MaLH;
    }

    public void setMaLH(String MaLH) {
        this.MaLH = MaLH;
    }

    public String getTenLH() {
        return TenLH;
    }

    public void setTenLH(String TenLH) {
        this.TenLH = TenLH;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
}
