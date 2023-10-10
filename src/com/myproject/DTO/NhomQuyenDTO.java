package com.myproject.DTO;

public class NhomQuyenDTO {
    private String MaQuyen;
    private String TenQuyen;
    private String Mota;

    public NhomQuyenDTO(String MaQuyen, String TenQuyen, String Mota) {
        this.MaQuyen = MaQuyen;
        this.TenQuyen = TenQuyen;
        this.Mota = Mota;
    }

    public NhomQuyenDTO() {
    }

    public String getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(String MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public String getTenQuyen() {
        return TenQuyen;
    }

    public void setTenQuyen(String TenQuyen) {
        this.TenQuyen = TenQuyen;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }
}
