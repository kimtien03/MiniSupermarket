package com.myproject.DAO;

import com.myproject.DTO.CT_HangHoaDTO;
import com.myproject.DTO.CT_PhieuNhapDTO;
import com.myproject.DTO.NhaCungCapDTO;
import com.myproject.DTO.PhieuNhapDTO;
import com.sun.jdi.connect.spi.Connection;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class PhieuNhapDAO extends conndb {

    public ArrayList<PhieuNhapDTO> getAll_PhieuNhap() {
        if (openConnection()) {
            ArrayList<PhieuNhapDTO> DSPhieuNhap = new ArrayList<>();
            try {
                String selectAllQuery = "SELECT * FROM dbo.PHIEUNHAP";
//                WHERE PHIEUNHAP.MaPhieuNhap = ?
                PreparedStatement prepareStm = con.prepareStatement(selectAllQuery);
                ResultSet rs = prepareStm.executeQuery();
                while (rs.next()) {
                    String maPhieuNhap = rs.getString(1);
                    Timestamp ngayLapPhieu = rs.getTimestamp(2);
                    Boolean tinhTrang = rs.getBoolean(3);
                    String maNV = rs.getString(4);
                    float thanhTien = rs.getFloat(5);
                    PhieuNhapDTO phieuNhap = new PhieuNhapDTO(maPhieuNhap, ngayLapPhieu, maNV, thanhTien, tinhTrang);
                    DSPhieuNhap.add(phieuNhap);
                }
                return DSPhieuNhap;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public ArrayList<PhieuNhapDTO> find_PhieuNhap_By_MaSP(String maSP) {
        if (openConnection()) {
            ArrayList<PhieuNhapDTO> DSPhieuNhap = new ArrayList<>();
            try {
                String selectAllQuery = "SELECT PN.MaPhieuNhap, PN.NgLapPhieu, PN.TinhTrang, PN.MaNV, PN.ThanhTien FROM PHIEUNHAP PN\n"
                        + "JOIN CT_PHIEUNHAP CTPN ON CTPN.MaPhieuNhap = PN.MaPhieuNhap\n"
                        + "JOIN CT_HANGHOA CTHH ON  CTHH.MaCT_HH = CTPN.MaCT_HH\n"
                        + "WHERE CTHH.MaHH = ?";
                PreparedStatement prepareStm = con.prepareStatement(selectAllQuery);
                prepareStm.setString(1, maSP);
                ResultSet rs = prepareStm.executeQuery();
                while (rs.next()) {
                    String maPhieuNhap = rs.getString(1);
                    Timestamp ngayLapPhieu = rs.getTimestamp(2);
                    Boolean tinhTrang = rs.getBoolean(3);
                    String maNV = rs.getString(4);
                    float thanhTien = rs.getFloat(5);
                    PhieuNhapDTO phieuNhap = new PhieuNhapDTO(maPhieuNhap, ngayLapPhieu, maNV, thanhTien, tinhTrang);
                    DSPhieuNhap.add(phieuNhap);
                }
                return DSPhieuNhap;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public ArrayList<PhieuNhapDTO> find_PhieuNhap_By_ngayYC(String ngayYC) {
        if (openConnection()) {
            ArrayList<PhieuNhapDTO> DSPhieuNhap = new ArrayList<>();
            try {
                String selectAllQuery = "SELECT * FROM PHIEUNHAP WHERE PHIEUNHAP.NgLapPhieu = ?";
                PreparedStatement prepareStm = con.prepareStatement(selectAllQuery);
                prepareStm.setString(1, ngayYC);
                ResultSet rs = prepareStm.executeQuery();
                while (rs.next()) {
                    String maPhieuNhap = rs.getString(1);
                    Timestamp ngayLapPhieu = rs.getTimestamp(2);
                    Boolean tinhTrang = rs.getBoolean(3);
                    String maNV = rs.getString(4);
                    float thanhTien = rs.getFloat(5);
                    PhieuNhapDTO phieuNhap = new PhieuNhapDTO(maPhieuNhap, ngayLapPhieu, maNV, thanhTien, tinhTrang);
                    DSPhieuNhap.add(phieuNhap);
                }
                return DSPhieuNhap;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public ArrayList<PhieuNhapDTO> find_PhieuNhap_By_maNCC(String maNCC) {
        if (openConnection()) {
            ArrayList<PhieuNhapDTO> DSPhieuNhap = new ArrayList<>();
            try {
                String selectAllQuery = "SELECT * FROM PHIEUNHAP\n"
                        + "WHERE PHIEUNHAP.MaPhieuNhap IN \n"
                        + "(SELECT DISTINCT PN.MaPhieuNhap FROM PHIEUNHAP PN \n"
                        + "JOIN CT_PHIEUNHAP CTPN ON CTPN.MaPhieuNhap = PN.MaPhieuNhap\n"
                        + "JOIN NHACUNGCAP NCC ON NCC.MaNCC = CTPN.MaNCC\n"
                        + "WHERE NCC.MaNCC = ?)";
                PreparedStatement prepareStm = con.prepareStatement(selectAllQuery);
                prepareStm.setString(1, maNCC);
                ResultSet rs = prepareStm.executeQuery();
                while (rs.next()) {
                    String maPhieuNhap = rs.getString(1);
                    Timestamp ngayLapPhieu = rs.getTimestamp(2);
                    Boolean tinhTrang = rs.getBoolean(3);
                    String maNV = rs.getString(4);
                    float thanhTien = rs.getFloat(5);
                    PhieuNhapDTO phieuNhap = new PhieuNhapDTO(maPhieuNhap, ngayLapPhieu, maNV, thanhTien, tinhTrang);
                    DSPhieuNhap.add(phieuNhap);
                }
                return DSPhieuNhap;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public ArrayList<PhieuNhapDTO> find_PhieuNhap_By_tinhTrang(String tinhTrang_input) {
        if (openConnection()) {
            ArrayList<PhieuNhapDTO> DSPhieuNhap = new ArrayList<>();
            try {
                String selectAllQuery = "SELECT * FROM PHIEUNHAP WHERE PHIEUNHAP.TinhTrang = ?";
                PreparedStatement prepareStm = con.prepareStatement(selectAllQuery);
                prepareStm.setString(1, tinhTrang_input);
                ResultSet rs = prepareStm.executeQuery();
                while (rs.next()) {
                    String maPhieuNhap = rs.getString(1);
                    Timestamp ngayLapPhieu = rs.getTimestamp(2);
                    Boolean tinhTrang = rs.getBoolean(3);
                    String maNV = rs.getString(4);
                    float thanhTien = rs.getFloat(5);
                    PhieuNhapDTO phieuNhap = new PhieuNhapDTO(maPhieuNhap, ngayLapPhieu, maNV, thanhTien, tinhTrang);
                    DSPhieuNhap.add(phieuNhap);
                }
                return DSPhieuNhap;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}
