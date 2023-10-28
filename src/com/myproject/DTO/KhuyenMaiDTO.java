package com.myproject.DTO;

import java.sql.Timestamp;


public class KhuyenMaiDTO {
    private String MaKM;
    private float TiLeGiam;
    private Timestamp NgBD;
    private Timestamp NgKT;
    private String MoTa;
    private boolean TinhTrang;

    public KhuyenMaiDTO(String MaKM, float TiLeGiam, Timestamp NgBD, Timestamp NgKT, String MoTa, boolean TinhTrang) {
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

    public Timestamp getNgBD() {
        return NgBD;
    }

    public void setNgBD(Timestamp NgBD) {
        this.NgBD = NgBD;
    }

    public Timestamp getNgKT() {
        return NgKT;
    }

    public void setNgKT(Timestamp NgKT) {
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

