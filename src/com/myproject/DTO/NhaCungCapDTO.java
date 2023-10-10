package com.myproject.DTO;

public class NhaCungCapDTO {
    private String MaNCC;
    private String TenNCC;
    private String DiaChi;
    private String Email;
    private String SDT;
    private boolean TinhTrang;

    public NhaCungCapDTO(String MaNCC, String TenNCC, String DiaChi, String Email, String SDT, boolean TinhTrang) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.SDT = SDT;
        this.TinhTrang = TinhTrang;
    }
    
    public NhaCungCapDTO() {
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
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

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
}
