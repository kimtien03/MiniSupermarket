package com.myproject.DTO;

import java.util.Date;

public class NhanVienDTO {
    private String MaNV;
    private String TenNV;
    private String Gioitinh;
    private String Email;
    private String SDT;
    private String Passwd;
    private Date NgSinh;
    private String MaQuyen;
    private boolean TinhTrang;
    private String ChucVu;
    private boolean KhoaTK;
    
    public NhanVienDTO(){
    }
    
    public NhanVienDTO(String MaNV, String TenNV, String Gioitinh, String Email, String SDT, String Passwd, Date NgSinh, String MaQuyen, boolean TinhTrang, String ChucVu, boolean KhoaTK) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.Gioitinh = Gioitinh;
        this.Email = Email;
        this.SDT = SDT;
        this.Passwd = Passwd;
        this.NgSinh = NgSinh;
        this.MaQuyen = MaQuyen;
        this.TinhTrang = TinhTrang;
        this.ChucVu = ChucVu;
        this.KhoaTK = KhoaTK;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String Passwd) {
        this.Passwd = Passwd;
    }

    public Date getNgSinh() {
        return NgSinh;
    }

    public void setNgSinh(Date NgSinh) {
        this.NgSinh = NgSinh;
    }
    
    public String getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(String MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public boolean isKhoaTK() {
        return KhoaTK;
    }

    public void setKhoaTK(boolean KhoaTK) {
        this.KhoaTK = KhoaTK;
    }
}