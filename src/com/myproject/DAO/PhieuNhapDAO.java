package com.myproject.DAO;

import com.myproject.DTO.CTPN_CTHH_HH_DTO;
import com.myproject.DTO.PhieuNhapDTO;
import java.sql.Date;
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
    public boolean DuyetCTHH(String MaPN) {
        ArrayList<String> arrCTHH = getAllCT_HHFromCT_PN(MaPN);
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE CT_HANGHOA SET TINHTRANG = 1 WHERE MACT_HH = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                int count = 0;
                for (int i=0;i<arrCTHH.size();i++) {
                    prest.setString(1, arrCTHH.get(i));
                    count+=prest.executeUpdate();
                }
                if (count >= arrCTHH.size()) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
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
                if (prest.executeUpdate() >= 1 && DuyetCTHH(MaPN)) {
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
//  tìm tất cả các chi tiết hàng hóa trong tất cả các chi tiết phiếu nhập của phiếu nhập chưa được duyệt
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
//  xóa các chi tiết hàng hóa trong các chi tiết phiếu nhập của phiếu nhập bị xóa
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

    public String getLastestNum() {
        String maCT_HH="";
        if (openConnection()) {
            try {
                String sql = "SELECT TOP 1 MACT_HH FROM CT_HANGHOA ORDER BY MACT_HH DESC";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                   maCT_HH = rs.getString("MaCT_HH");
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return maCT_HH;
    }
    
    public boolean addCTHH(CTPN_CTHH_HH_DTO p) {
        boolean result = false;
        if(openConnection()) {
            try {
                String sql = "INSERT INTO CT_HANGHOA VALUES(?,?,?,?,?,?)";
                PreparedStatement prest = con.prepareStatement(sql);
                prest.setString(1, p.getMaCT_HH());
                prest.setDate(2, (Date) p.getNgaySX());
                prest.setDate(3, (Date) p.getHSD());
                prest.setBoolean(4, false);
                prest.setString(5, p.getMaHH());
                prest.setFloat(6, p.getSLNhap());
                if(prest.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    public boolean addCTPN(CTPN_CTHH_HH_DTO p) {
        boolean result = false;
        if(openConnection()) {
            try {
                String sql = "INSERT INTO CT_PHIEUNHAP VALUES(?,?,?,?,?)";
                PreparedStatement prest = con.prepareStatement(sql);
                prest.setString(1, p.getMaPN());
                prest.setString(2, p.getMaCT_HH());
                prest.setString(3, p.getMaNCC());
                prest.setFloat(4, p.getSLNhap());
                prest.setFloat(5, p.getDonGiaNhap());
                if(addCTHH(p) && prest.executeUpdate() >= 1) {
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
    //  tìm chi tiết hàng hóa cần xóa
    public ArrayList<String> getCT_HHFromCT_PN(String MaPN, String MaCT_HH) {
        ArrayList<String> arrCT_HH = new ArrayList<>();
        if (openConnection()) {
            try {
                String sql = "SELECT * FROM PHIEUNHAP,CT_PHIEUNHAP WHERE PHIEUNHAP.MAPHIEUNHAP = CT_PHIEUNHAP.MAPHIEUNHAP "
                        + "AND PHIEUNHAP.MAPHIEUNHAP = '"+MaPN+"' AND CT_PHIEUNHAP.MACT_HH ='"+MaCT_HH+"'";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                   arrCT_HH.add(rs.getString("MACT_HH"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return arrCT_HH;
    }
    public boolean XoaCTPN(String MaPN, String MaCT_HH) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "DELETE FROM CT_PHIEUNHAP WHERE MAPHIEUNHAP = ? AND MACT_HH = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                prest.setString(1, MaPN);
                prest.setString(2, MaCT_HH);
                ArrayList<String> arrCT_HH = getCT_HHFromCT_PN(MaPN,MaCT_HH);
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
    public boolean fixCTHH(String maPN, String maCTHH, float soLuong, float donGiaNhap, String NCC, String NSX, String HSD) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE CT_HANGHOA SET NGSANXUAT = ?, HANSUDUNG = ?,SOLUONG = ?"
                        + " WHERE MACT_HH = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                prest.setDate(1, Date.valueOf(NSX));
                prest.setDate(2, Date.valueOf(HSD));
                prest.setFloat(3, soLuong);
                prest.setString(4, maCTHH);
                if (prest.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    public boolean fixCTPN(String maPN, String maCTHH, float soLuong, float donGiaNhap, String NCC, String NSX, String HSD) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE CT_PHIEUNHAP SET SOLUONGNHAP = ?,DONGIANHAP = ?,MANCC = ? "
                        + "WHERE MAPHIEUNHAP = ? AND MACT_HH = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                prest.setFloat(1, soLuong);
                prest.setFloat(2, donGiaNhap);
                prest.setString(3, NCC);
                prest.setString(4, maPN);
                prest.setString(5, maCTHH);
                if (prest.executeUpdate() >= 1 && fixCTHH(maPN,maCTHH,soLuong,donGiaNhap,NCC,NSX,HSD)) {
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

    public void updateThanhTien(String MaPN, float thanhTien) {
        if (openConnection()) {
            try {
                String sql = "UPDATE PHIEUNHAP SET THANHTIEN = ? WHERE MAPHIEUNHAP = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                prest.setFloat(1, thanhTien);
                prest.setString(2, MaPN);
                prest.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
