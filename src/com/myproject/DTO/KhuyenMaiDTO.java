package com.myproject.DTO;

import java.sql.Date;


public class KhuyenMaiDTO {
    private String MaKM;
    private float TiLeGiam;
    private Date NgBD;
    private Date NgKT;
    private String MoTa;
    private boolean TinhTrang;

    public KhuyenMaiDTO(String MaKM, float TiLeGiam, Date NgBD, Date NgKT, String MoTa, boolean TinhTrang) {
        this.MaKM = MaKM;
        this.TiLeGiam = TiLeGiam;
        this.NgBD = NgBD;
        this.NgKT = NgKT;
        this.MoTa = MoTa;
        this.TinhTrang = TinhTrang;
    }

    public KhuyenMaiDTO() {
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public float getTiLeGiam() {
        return TiLeGiam;
    }

    public void setTiLeGiam(float TiLeGiam) {
        this.TiLeGiam = TiLeGiam;
    }

    public Date getNgBD() {
        return NgBD;
    }

    public void setNgBD(Date NgBD) {
        this.NgBD = NgBD;
    }

    public Date getNgKT() {
        return NgKT;
    }

    public void setNgKT(Date NgKT) {
        this.NgKT = NgKT;
    }
    
    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
}