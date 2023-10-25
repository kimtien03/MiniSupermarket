package com.myproject.DAO;

import com.myproject.DTO.CTPN_CTHH_HH_DTO;
import com.myproject.DTO.PhieuNhapDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PhieuNhapDAO extends conndb{
    public ArrayList<PhieuNhapDTO> getAllPN() {
       ArrayList<PhieuNhapDTO> arr = new ArrayList<>();
       if(openConnection()) {
           try {
               String sql = "SELECT * FROM PHIEUNHAP";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               while(rs.next()) {
                   PhieuNhapDTO p = new PhieuNhapDTO();
                   p.setMaPN(rs.getString("MaPhieuNhap"));
                   p.setMaNV(rs.getString("MaNV"));
                   p.setNgLapPhieu(rs.getTimestamp("NgLapPhieu"));
                   p.setThanhTien(rs.getFloat("ThanhTien"));
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
    public ArrayList<CTPN_CTHH_HH_DTO> getAllCTPN() {
       ArrayList<CTPN_CTHH_HH_DTO> arr = new ArrayList<>();
       if(openConnection()) {
           try {
               String sql = "SELECT HANGHOA.MAHH,CT_HANGHOA.MACT_HH,HANGHOA.TENHH,CT_HANGHOA.NGSANXUAT,CT_HANGHOA.HANSUDUNG,CT_PHIEUNHAP.MANCC,CT_PHIEUNHAP.SOLUONGNHAP,CT_PHIEUNHAP.DONGIANHAP,CT_PHIEUNHAP.MAPHIEUNHAP"
                       + " FROM CT_PHIEUNHAP,CT_HANGHOA,HANGHOA "
                       + "WHERE CT_HANGHOA.MAHH = HANGHOA.MAHH AND CT_HANGHOA.MACT_HH = CT_PHIEUNHAP.MACT_HH";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               while(rs.next()) {
                   CTPN_CTHH_HH_DTO p = new CTPN_CTHH_HH_DTO();
                   p.setMaHH(rs.getString("MaHH"));
                   p.setMaCT_HH(rs.getString("MaCT_HH"));
                   p.setTenHH(rs.getString("TenHH"));
                   p.setNgaySX(rs.getDate("NgSanXuat"));
                   p.setHSD(rs.getDate("HanSuDung"));
                   p.setMaNCC(rs.getString("MaNCC"));
                   p.setSLNhap(rs.getFloat("SoLuongNhap"));
                   p.setDonGiaNhap(rs.getFloat("DonGiaNhap"));
                   p.setMaPN(rs.getString("MaPhieuNhap"));
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

    public boolean DuyetPN(String MaPN) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE PHIEUNHAP SET TINHTRANG = ? WHERE MAPHIEUNHAP = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                prest.setBoolean(1, true);
                prest.setString(2, MaPN);
                if (prest.executeUpdate() >= 1) {
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
//  tìm để xóa các chi tiết hàng hóa trong các chi tiết phiếu nhập của phiếu nhập bị xóa
    public ArrayList<String> getAllCT_HHFromCT_PN(String MaPN) {
        ArrayList<String> result = new ArrayList<>();
        if (openConnection()) {
            try {
                String sql = "SELECT * FROM PHIEUNHAP,CT_PHIEUNHAP WHERE PHIEUNHAP.MAPHIEUNHAP = CT_PHIEUNHAP.MAPHIEUNHAP "
                        + "AND PHIEUNHAP.MAPHIEUNHAP = '"+MaPN+"'";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                   result.add(rs.getString("MACT_HH"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    public boolean XoaCT_HH(String MaPN, ArrayList<String> arrCT_HH) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "DELETE FROM CT_HANGHOA WHERE MACT_HH = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                int count = 0;
                for (int i=0;i<arrCT_HH.size();i++) {
                    prest.setString(1, arrCT_HH.get(i));
                    count+=prest.executeUpdate();
                }
                if (count >= arrCT_HH.size()) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    public boolean XoaPN(String MaPN) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "DELETE FROM PHIEUNHAP WHERE MAPHIEUNHAP = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                prest.setString(1, MaPN);
                ArrayList<String> arrCT_HH = getAllCT_HHFromCT_PN(MaPN);
                if (prest.executeUpdate() >= 1 && XoaCT_HH(MaPN,arrCT_HH)) {
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

}
