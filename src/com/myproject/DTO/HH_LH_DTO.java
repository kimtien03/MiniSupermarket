/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.DTO;

/**
 *
 * @author Admin
 */
public class HH_LH_DTO {
    private String MaHH;
    private String TenHH;
    private String TenLH;
    private String MaKM;
    private boolean TinhTrang;
    public HH_LH_DTO() {
    }

    public HH_LH_DTO(String MaHH, String TenHH, String TenLH, String MaKM, boolean TinhTrang) {
        this.MaHH = MaHH;
        this.TenHH = TenHH;
        this.TenLH = TenLH;
        this.MaKM = MaKM;
        this.TinhTrang = TinhTrang;
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

    public String getTenLH() {
        return TenLH;
    }

    public void setTenLH(String TenLH) {
        this.TenLH = TenLH;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
}
