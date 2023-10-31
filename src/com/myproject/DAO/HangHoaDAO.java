package com.myproject.DAO;

import com.itextpdf.text.pdf.PdfName;
import com.myproject.BUS.*;
import com.myproject.DTO.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HangHoaDAO extends conndb {

    conndb ConHH = new conndb();
    // Phương thức để lấy danh sách các mặt hàng (HangHoa) từ cơ sở dữ liệu

    public int getAllCount() {
        int count = 0;
        try {
            ConHH.openConnection();
            Connection con = ConHH.getConnection();
            String sql1 = "SELECT MaHH "
                    + "FROM HANGHOA ";
            PreparedStatement stmt = con.prepareStatement(sql1);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                count++;
            }
            resultSet.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
                    

    public boolean insertHangHoa(HangHoaDTO hh) {
        boolean check = false;
        try {
            ConHH.openConnection();
            Connection con = ConHH.getConnection();
            String sql = "INSERT INTO HANGHOA VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, hh.getMaHH());
            ps.setString(2, hh.getTenHH());
            ps.setString(3, hh.getMaKM());
            ps.setFloat(4, hh.getDonGiaBan());
            ps.setString(5, hh.getDonVi());
            ps.setString(6, hh.getMaLH());
            ps.setBoolean(7, hh.isTinhTrang());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
    public boolean updateHang(String maHH, String maLH, boolean tinhTrang) {
        boolean check = false;
        try {
            ConHH.openConnection();
            Connection con = ConHH.getConnection();
            String sql = "Update HangHoa set maLH = ?, tinhTrang = ? where maHH = '" + maHH + "'";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, maLH);
            ps.setBoolean(2, tinhTrang);
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
    public ArrayList<HangHoaDTO> getAllMaHH() {
        ArrayList<HangHoaDTO> listMaHH = new ArrayList<>();
        try {
            ConHH.openConnection();
            Connection con = ConHH.getConnection();
            String sql1 = "SELECT * FROM HANGHOA";
            PreparedStatement stmt = con.prepareStatement(sql1);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HangHoaDTO hh = new HangHoaDTO();
                hh.setMaHH(rs.getString("MaHH"));
                hh.setTenHH(rs.getString("TenHH"));
                hh.setMaKM(rs.getString("MaKM"));
                hh.setDonGiaBan(rs.getFloat("DonGiaBan"));
                hh.setDonVi(rs.getString("DonVi"));
                hh.setMaLH(rs.getString("MaLH"));
                hh.setTinhTrang(rs.getBoolean("TinhTrang"));
                listMaHH.add(hh);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConHH.closeConnection();
        }
        return listMaHH;
    }

    public boolean updateTinhTrangHangHoa(String MaHH, boolean TinhTrang) {
        try {
            ConHH.openConnection();
            Connection con = ConHH.getConnection();
            String sql = "UPDATE HANGHOA SET TinhTrang = ? WHERE MaHH = ?";
            try ( PreparedStatement stmt = con.prepareStatement(sql);) {
                stmt.setBoolean(1, TinhTrang);
                stmt.setString(2, MaHH);
                int rowsUpdated = stmt.executeUpdate();
                return rowsUpdated > 0; // Trả về true nếu có ít nhất một hàng đã được cập nhật
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Float> getHangSL() {
        ArrayList<Float> listHang = new ArrayList<>();
        try {
            ConHH.openConnection();
            Connection con = ConHH.getConnection();
            String sql = "SELECT Sum(SoLuong) as TongSL FROM HANGHOA LEFT JOIN CT_HANGHOA on HANGHOA.MAHH = CT_HANGHOA.MAHH AND CT_HANGHOA.TinhTrang = 1 GROUP BY HANGHOA.MAHH, TENHH";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                HangHoaDTO hh = new HangHoaDTO();
//                hh.setMaHH(rs.getString(1));
//                hh.setTenHH(rs.getString(2));
                float tien = rs.getFloat(1);
//                listHH.add(hh);
                listHang.add(tien);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return listHang;
    }

    public ArrayList<HangHoaDTO> getHangHoaTotal(ArrayList<CT_HangHoaDTO> listCTHH, ArrayList<LoaiHangDTO> listLH) {
        ArrayList<HangHoaDTO> hangHoaList = new ArrayList<>();
//        listCTHH = new ArrayList<>();
//        listLH = new ArrayList<>();
        try {
            ConHH.openConnection();
            Connection con = ConHH.getConnection();
            String sql1 = """
                          select * from (HANGHOA left join CT_HANGHOA on HANGHOA.MaHH = CT_HANGHOA.MaHH) left join LOAIHANG on HANGHOA.MaLH = LOAIHANG.MaLH""";
            PreparedStatement stmt = con.prepareStatement(sql1);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                HangHoaDTO hanghoa = new HangHoaDTO();
                hanghoa.setMaHH(resultSet.getString(1));
                hanghoa.setTenHH(resultSet.getString("TenHH"));
                hanghoa.setMaKM(resultSet.getString("MaKM"));
                hanghoa.setDonGiaBan(resultSet.getFloat("DonGiaBan"));
                hanghoa.setDonVi(resultSet.getString("DonVi"));
                hanghoa.setMaLH(resultSet.getString(6));
                hanghoa.setTinhTrang(resultSet.getBoolean(7));
                hangHoaList.add(hanghoa);

                CT_HangHoaDTO ct = new CT_HangHoaDTO();
                ct.setMaCT_HH(resultSet.getString("MaCT_HH"));
                ct.setMaHH(resultSet.getString(13));
                ct.setNgaySX(resultSet.getTimestamp("NgSanXuat"));
                ct.setHSD(resultSet.getTimestamp("HanSuDung"));
                ct.setSoLuong(resultSet.getFloat("SoLuong"));
                ct.setTinhTrang(resultSet.getBoolean(12));
                listCTHH.add(ct);

                LoaiHangDTO lh = new LoaiHangDTO();
                lh.setMaLH(resultSet.getString(14));
                lh.setTenLH(resultSet.getString("TenLH"));
                lh.setTinhTrang(resultSet.getBoolean(16));
                listLH.add(lh);
            }
            resultSet.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hangHoaList;
    }
}
