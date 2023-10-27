package com.myproject.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CT_PhieuNhapDTO {
    private String MaPN;
    private String MaCT_HH;
    private String MaNCC;
    private float SLNhap;
    private float DonGiaNhap;
    private PhieuNhapDTO phieuNhap;
    private NhaCungCapDTO NCC;
    private CT_HangHoaDTO CT_hangHoa;

    public CT_PhieuNhapDTO(String MaPN, String MaCT_HH, String MaNCC, int SLNhap, float DonGiaNhap) {
        this.MaPN = MaPN;
        this.MaCT_HH = MaCT_HH;
        this.MaNCC = MaNCC;
        this.SLNhap = SLNhap;
        this.DonGiaNhap = DonGiaNhap;
    }

    public CT_PhieuNhapDTO(float SLNhap, float DonGiaNhap, PhieuNhapDTO phieuNhap, NhaCungCapDTO NCC, CT_HangHoaDTO CT_hangHoa) {
        this.SLNhap = SLNhap;
        this.DonGiaNhap = DonGiaNhap;
        this.phieuNhap = phieuNhap;
        this.NCC = NCC;
        this.CT_hangHoa = CT_hangHoa;
    }

    public CT_PhieuNhapDTO() {
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }
    
    public String getMaCT_HH() {
        return MaCT_HH;
    }

    public void setMaCT_HH(String MaCT_HH) {
        this.MaCT_HH = MaCT_HH;
    }
    
    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }
    
    public float getSLNhap() {
        return SLNhap;
    }

    public void setSLNhap(float SLNhap) {
        this.SLNhap = SLNhap;
    }

    public float getDonGiaNhap() {
        return DonGiaNhap;
    }

    public void setDonGiaNhap(float DonGiaNhap) {
        this.DonGiaNhap = DonGiaNhap;
    }

    public PhieuNhapDTO getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhapDTO phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public NhaCungCapDTO getNCC() {
        return NCC;
    }

    public void setNCC(NhaCungCapDTO NCC) {
        this.NCC = NCC;
    }

    public CT_HangHoaDTO getCT_hangHoa() {
        return CT_hangHoa;
    }

    public void setCT_hangHoa(CT_HangHoaDTO CT_hangHoa) {
        this.CT_hangHoa = CT_hangHoa;
    }
    
    @Override
    public String toString() {
        return this.CT_hangHoa.getHangHoaDTO().getMaHH() + ", " + this.CT_hangHoa.getHangHoaDTO().getTenHH() + ", " + this.CT_hangHoa.getNgaySX() + ", " +
                this.CT_hangHoa.getHSD()+ ", " + this.NCC.getTenNCC()+ ", " + this.SLNhap + ", " + this.DonGiaNhap;
    }
}
