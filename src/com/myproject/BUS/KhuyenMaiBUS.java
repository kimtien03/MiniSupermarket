package com.myproject.BUS;

import com.myproject.DAO.KhuyenMaiDAO;
import com.myproject.DTO.HH_LH_DTO;
import com.myproject.DTO.KhuyenMaiDTO;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class KhuyenMaiBUS {
    KhuyenMaiDAO km;
    public ArrayList<KhuyenMaiDTO> getAllKM() {
        km = new KhuyenMaiDAO();
        return km.getAllKM();
    }

    public ArrayList<HH_LH_DTO> getAllHHOfKM(String MaKM) {
        km = new KhuyenMaiDAO();
        return km.getAllHHOfKM(MaKM);
    }

    public boolean TatKM(String MaKM, Date NKTDate) {
        km = new KhuyenMaiDAO();
        return km.TatKM(MaKM,NKTDate);
    }
    public String getLastestNum() {
        km = new KhuyenMaiDAO();
        String MaKM = km.getLastestNum().trim();
        int index = Integer.parseInt(MaKM.substring(2));
        return "KM" + String.format("%02d", index+1);
    }

    public ArrayList<HH_LH_DTO> getAllHH_MAKM_NULL() {
        km = new KhuyenMaiDAO();
        return km.getAllHH_MAKM_NULL();
    }

    public boolean addKM(String MaKM, Date NBDDate, Date NKTDate, float tlgFloat, boolean tinhtrang, String MotaString, ArrayList<String> arrHH) {
        km = new KhuyenMaiDAO();
        return km.addKM(MaKM,NBDDate,NKTDate,tlgFloat,tinhtrang,MotaString,arrHH);
    }

    public ArrayList<HH_LH_DTO> getALLHHFormFix(String MaKM) {
        km = new KhuyenMaiDAO();
        return km.getALLHHFormFix(MaKM);
    }

    public boolean updateKM(String MaKM, Date NKTDate, String moTa, ArrayList<HH_LH_DTO> arrHH) {
        km = new KhuyenMaiDAO();
        return km.updateKM(MaKM,NKTDate,moTa,arrHH);
    }

    public void AutoUpdateKM(Date date) {
        km = new KhuyenMaiDAO();
        km.AutoUpdateKM(date);
    }
}