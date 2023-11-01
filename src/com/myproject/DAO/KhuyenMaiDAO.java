package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.HH_LH_DTO;
import com.myproject.DTO.KhuyenMaiDTO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class KhuyenMaiDAO extends conndb{
    public ArrayList<KhuyenMaiDTO> getAllKM() {
        ArrayList<KhuyenMaiDTO> arr = new ArrayList<>();
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM KHUYENMAI";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                    KhuyenMaiDTO p = new KhuyenMaiDTO();
                    p.setMaKM(rs.getString("MaKM"));
                    p.setNgBD(rs.getDate("NgBatDauKM"));
                    p.setNgKT(rs.getDate("NgKetThucKM"));
                    p.setTiLeGiam(rs.getFloat("TiLeGiam"));
                    p.setTinhTrang(rs.getBoolean("TinhTrang"));
                    p.setMoTa(rs.getString("MoTa"));
                    arr.add(p);
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }

    public ArrayList<HH_LH_DTO> getAllHHOfKM(String MaKM) {
        ArrayList<HH_LH_DTO> arr = new ArrayList<>();
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM HANGHOA,LOAIHANG WHERE HANGHOA.MALH = LOAIHANG.MALH AND "
                        + "HANGHOA.MAKM = '"+MaKM+"'";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                    HH_LH_DTO p = new HH_LH_DTO();
                    p.setMaHH(rs.getString("MaHH"));
                    p.setTenHH(rs.getString("TenHH"));
                    p.setTenLH(rs.getString("TenLH"));
                    p.setMaKM(rs.getString("MAKM"));
                    p.setTinhTrang(rs.getBoolean("TinhTrang"));
                    arr.add(p);
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }
    public boolean SetNullMaKM_HH(String MaKM) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE HANGHOA SET MAKM = NULL WHERE MAKM = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                prest.setString(1, MaKM);
                if (prest.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    public boolean TatKM(String MaKM, Date NKTDate) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE KHUYENMAI SET TINHTRANG = 0, NGKETTHUCKM = ? WHERE MAKM = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                prest.setDate(1, NKTDate);
                prest.setString(2, MaKM);
                if (prest.executeUpdate() >= 1 && SetNullMaKM_HH(MaKM)) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return result;
    }
    public String getLastestNum() {
        String MAKM="";
        if (openConnection()) {
            try {
                String sql = "SELECT TOP 1 MAKM FROM KHUYENMAI ORDER BY MAKM DESC";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                   MAKM = rs.getString("MAKM");
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return MAKM;
    }

    public ArrayList<HH_LH_DTO> getAllHH_MAKM_NULL() {
        ArrayList<HH_LH_DTO> arr = new ArrayList<>();
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM HANGHOA,LOAIHANG WHERE HANGHOA.MALH = LOAIHANG.MALH AND "
                        + "HANGHOA.TINHTRANG = 1 AND HANGHOA.MAKM IS NULL";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                    HH_LH_DTO p = new HH_LH_DTO();
                    p.setMaHH(rs.getString("MaHH"));
                    p.setTenHH(rs.getString("TenHH"));
                    p.setTenLH(rs.getString("TenLH"));
                    p.setMaKM(rs.getString("MAKM"));
                    p.setTinhTrang(rs.getBoolean("TinhTrang"));
                    arr.add(p);
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }
    public boolean addHHKM(String MaKM, ArrayList<String> arrHH) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE HANGHOA SET MAKM = '"+MaKM+"' WHERE MAHH = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                int count = 0;
                for (int i=0;i<arrHH.size();i++) {
                    prest.setString(1, arrHH.get(i));
                    count+=prest.executeUpdate();
                }
                if (count >= arrHH.size()) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    public boolean addKM(String MaKM, Date NBDDate, Date NKTDate, float tlgFloat, boolean tinhtrang, String MotaString, ArrayList<String> arrHH) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "INSERT INTO KHUYENMAI VALUES(?,?,?,?,?,?)";
                PreparedStatement prest = con.prepareStatement(sql);
                prest.setString(1, MaKM);
                prest.setDate(2, NBDDate);
                prest.setDate(3, NKTDate);
                prest.setFloat(4, tlgFloat);
                prest.setBoolean(5, tinhtrang);
                prest.setString(6, MotaString);
                if(prest.executeUpdate() >= 1 && addHHKM(MaKM,arrHH)) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public ArrayList<HH_LH_DTO> getALLHHFormFix(String MaKM) {
        ArrayList<HH_LH_DTO> arr = new ArrayList<>();
        if(openConnection()) {
            try {
                String sql = "SELECT MAHH,TENHH,LOAIHANG.TENLH,HANGHOA.MAKM,HANGHOA.TINHTRANG FROM HANGHOA,LOAIHANG \n" +
                "WHERE HANGHOA.MALH = LOAIHANG.MALH AND HANGHOA.TINHTRANG = 1 AND "
                + "(HANGHOA.MAKM = '"+MaKM+"' OR HANGHOA.MAKM IS NULL)";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                    HH_LH_DTO p = new HH_LH_DTO();
                    p.setMaHH(rs.getString("MaHH"));
                    p.setTenHH(rs.getString("TenHH"));
                    p.setTenLH(rs.getString("TenLH"));
                    p.setMaKM(rs.getString("MAKM"));
                    p.setTinhTrang(rs.getBoolean("TinhTrang"));
                    arr.add(p);
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }
    public boolean updateHHKM(ArrayList<HH_LH_DTO> arrHH) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE HANGHOA SET MAKM = ? WHERE MAHH = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                int count = 0;
                for (int i=0;i<arrHH.size();i++) {
                    prest.setString(1, arrHH.get(i).getMaKM());
                    prest.setString(2, arrHH.get(i).getMaHH());
                    count+=prest.executeUpdate();
                }
                if (count >= arrHH.size()) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    public boolean updateKM(String MaKM, Date NKTDate, String moTa, ArrayList<HH_LH_DTO> arrHH) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE KHUYENMAI SET NGKETTHUCKM = ?, MOTA = ? WHERE MAKM = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest.setDate(1, NKTDate);
                prest.setString(2, moTa);
                prest.setString(3, MaKM);
                if(prest.executeUpdate() >= 1 && updateHHKM(arrHH)) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return result;
    }
    public void AutoUpdateMaKM_HH(Date date) {
        if (openConnection()) {
            try {
                String sql = "UPDATE hanghoa SET hanghoa.makm = null\n" +
                "where hanghoa.mahh in (select hanghoa.mahh from hanghoa,khuyenmai where hanghoa.makm = khuyenmai.makm"
                + " and khuyenmai.tinhtrang = 0)";
                PreparedStatement ps = con.prepareCall(sql);
                ps.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void AutoUpdateKM(Date date) {
        if (openConnection()) {
            try {
                String sql = "Update KhuyenMai set TinhTrang = 0 where NgKetThucKM <= '" + date + "'";
                PreparedStatement ps = con.prepareCall(sql);
                ps.executeUpdate();
                AutoUpdateMaKM_HH(date);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                closeConnection();
            }
        }
    }
}