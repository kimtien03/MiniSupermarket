package com.myproject.DTO;

import java.util.Date;

public class KhachHangDTO {
    private String MaKH;
    private String HoTen;
    private String SDT;
    private int Diem;
    private Date NgSinh;
    private boolean TinhTrang;
    public KhachHangDTO(String MaKH, String HoTen, String SDT, int Diem, Date NgSinh, boolean TinhTrang) {
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.Diem = Diem;
        this.NgSinh = NgSinh;
        this.TinhTrang = TinhTrang;
    }

    public KhachHangDTO() {
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getDiem() {
        return Diem;
    }

    public void setDiem(int Diem) {
        this.Diem = Diem;
    }

    public Date getNgSinh() {
        return NgSinh;
    }

    public void setNgSinh(Date NgSinh) {
        this.NgSinh = NgSinh;
    }

    
    
    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
}
