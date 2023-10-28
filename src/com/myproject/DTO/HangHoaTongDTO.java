/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.DTO;

import java.sql.Timestamp;

/**
 *
 * @author ACER
 */
public class HangHoaTongDTO  {
    private String MaCT_HH;
    private String MaHH;
    private String TenHH;
    private Timestamp NgaySX;
    private Timestamp HSD;
    private float DonGiaBan;
    private String MaKM;
    private String DonVi;
    private String TenLH;
    private float SoLuong;
    private boolean TinhTrang;

    public HangHoaTongDTO() {
    }

    public HangHoaTongDTO(String MaCT_HH, String MaHH, String TenHH, Timestamp NgaySX, Timestamp HSD, float DonGiaBan, String MaKM, String DonVi, String TenLH, float SoLuong, boolean TinhTrang) {
        this.MaCT_HH = MaCT_HH;
        this.MaHH = MaHH;
        this.TenHH = TenHH;
        this.NgaySX = NgaySX;
        this.HSD = HSD;
        this.DonGiaBan = DonGiaBan;
        this.MaKM = MaKM;
        this.DonVi = DonVi;
        this.TenLH = TenLH;
        this.SoLuong = SoLuong;
        this.TinhTrang = TinhTrang;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getMaCT_HH() {
        return MaCT_HH;
    }

    public void setMaCT_HH(String MaCT_HH) {
        this.MaCT_HH = MaCT_HH;
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

    public Timestamp getNgaySX() {
        return NgaySX;
    }

    public void setNgaySX(Timestamp NgaySX) {
        this.NgaySX = NgaySX;
    }

    public Timestamp getHSD() {
        return HSD;
    }

    public void setHSD(Timestamp HSD) {
        this.HSD = HSD;
    }

    public float getDonGiaBan() {
        return DonGiaBan;
    }

    public void setDonGiaBan(float DonGiaBan) {
        this.DonGiaBan = DonGiaBan;
    }

    public String getDonVi() {
        return DonVi;
    }

    public void setDonVi(String DonVi) {
        this.DonVi = DonVi;
    }

    public String getTenLH() {
        return TenLH;
    }

    public void setTenLH(String TenLH) {
        this.TenLH = TenLH;
    }

    public float getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(float SoLuong) {
        this.SoLuong = SoLuong;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
}
