package com.myproject.DAO;
import com.myproject.DTO.CT_HangHoaDTO;
import com.myproject.DTO.CT_PhieuNhapDTO;
import com.myproject.DTO.NhaCungCapDTO;
import com.myproject.DTO.PhieuNhapDTO;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CT_PhieuNhapDAO extends conndb{
    public List<CT_PhieuNhapDTO> getList() {
        List<CT_PhieuNhapDTO> list = new ArrayList<>();
        if (openConnection()) {
            try {
                String sql = "SELECT*FROM CT_PHIEUNHAP";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    CT_PhieuNhapDTO ctpn = new CT_PhieuNhapDTO();
                    ctpn.setMaPN(rs.getString("MaPhieuNhap"));
                    ctpn.setMaCT_HH(rs.getString("MaCT_HH"));
                    ctpn.setMaNCC(rs.getString("MaNCC"));
                    ctpn.setSLNhap(rs.getFloat("SoLuongNhap"));
                    ctpn.setDonGiaNhap(rs.getFloat("DonGiaNhap"));
                    list.add(ctpn);
                }
                ps.close();
                rs.close();
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }   
        }
        return null;
    }
    public ArrayList<CT_PhieuNhapDTO> getAll_CT_PhieuNhap() {
        if (openConnection()) {
            ArrayList<CT_PhieuNhapDTO> DS_CTPhieuNhap = new ArrayList<>();
            try {
                String selectAllQuery = "SELECT HH.MaHH, TenHH, NgSanXuat, HanSuDung, NCC.TenNCC, CTPN.SoLuongNhap, DonGiaNhap\n" +
                    "FROM PHIEUNHAP PN JOIN CT_PHIEUNHAP CTPN ON PN.MaPhieuNhap = CTPN.MaPhieuNhap \n" +
                    "JOIN NHACUNGCAP NCC ON NCC.MaNCC = CTPN.MaNCC \n" +
                    "JOIN CT_HANGHOA CTHH ON CTHH.MaCT_HH = CTPN.MaCT_HH\n" +
                    "JOIN HANGHOA HH ON HH.MaHH = CTHH.MaHH";
                PreparedStatement prepareStm = con.prepareStatement(selectAllQuery);
                ResultSet rs = prepareStm.executeQuery();   
                while (rs.next()) {
                    String maHH = rs.getString(1);
                    String tenHH = rs.getString(2);
                    Date ngaySX = rs.getDate(3);
                    Date hanSuDung = rs.getDate(4);
                    String tenNCC = rs.getString(5);
                    float soLuong = rs.getFloat(6);
                    float donGiaNhap = rs.getFloat(7);
//                  public CT_PhieuNhapDTO(float SLNhap, float DonGiaNhap, PhieuNhapDTO phieuNhap, NhaCungCapDTO NCC, CT_HangHoaDTO CT_hangHoa) {

                    PhieuNhapDTO phieuNhapDTO = new PhieuNhapDTO();
                    
                    NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO();
                    nhaCungCapDTO.setTenNCC(tenNCC);
                    
                    CT_HangHoaDTO CT_hangHoaDTO = new CT_HangHoaDTO();
                    CT_hangHoaDTO.setNgaySX(ngaySX);
                    CT_hangHoaDTO.setHSD(hanSuDung);
                    CT_hangHoaDTO.getHangHoaDTO().setTenHH(tenHH);
                    CT_hangHoaDTO.getHangHoaDTO().setMaHH(maHH);
                    
                    CT_PhieuNhapDTO CT_phieuNhap = new CT_PhieuNhapDTO(soLuong, donGiaNhap, phieuNhapDTO, nhaCungCapDTO, CT_hangHoaDTO);
                    
                    DS_CTPhieuNhap.add(CT_phieuNhap);
                }
                
                return DS_CTPhieuNhap;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public ArrayList<CT_PhieuNhapDTO> find_CT_PhieuNhapByRow(String ID_PN) {
        if (openConnection()) {
            ArrayList<CT_PhieuNhapDTO> DS_CTPhieuNhap = new ArrayList<>();
            try {
                String selectAllQuery = "SELECT HH.MaHH, TenHH, NgSanXuat, HanSuDung, NCC.TenNCC, CTPN.SoLuongNhap, DonGiaNhap\n" +
                    "FROM PHIEUNHAP PN JOIN CT_PHIEUNHAP CTPN ON PN.MaPhieuNhap = CTPN.MaPhieuNhap \n" +
                    "JOIN NHACUNGCAP NCC ON NCC.MaNCC = CTPN.MaNCC \n" +
                    "JOIN CT_HANGHOA CTHH ON CTHH.MaCT_HH = CTPN.MaCT_HH\n" +
                    "JOIN HANGHOA HH ON HH.MaHH = CTHH.MaHH where PN.MaPhieuNhap = ?";
                PreparedStatement prepareStm = con.prepareStatement(selectAllQuery);
                prepareStm.setString(1, ID_PN);
                ResultSet rs = prepareStm.executeQuery();   
                while (rs.next()) {
                    String maHH = rs.getString(1);
                    String tenHH = rs.getString(2);
                    Date ngaySX = rs.getDate(3);
                    Date hanSuDung = rs.getDate(4);
                    String tenNCC = rs.getString(5);
                    float soLuong = rs.getFloat(6);
                    float donGiaNhap = rs.getFloat(7);
//                  public CT_PhieuNhapDTO(float SLNhap, float DonGiaNhap, PhieuNhapDTO phieuNhap, NhaCungCapDTO NCC, CT_HangHoaDTO CT_hangHoa) {

                    PhieuNhapDTO phieuNhapDTO = new PhieuNhapDTO();
                    
                    NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO();
                    nhaCungCapDTO.setTenNCC(tenNCC);
                    
                    CT_HangHoaDTO CT_hangHoaDTO = new CT_HangHoaDTO();
                    CT_hangHoaDTO.setNgaySX(ngaySX);
                    CT_hangHoaDTO.setHSD(hanSuDung);
                    CT_hangHoaDTO.getHangHoaDTO().setTenHH(tenHH);
                    CT_hangHoaDTO.getHangHoaDTO().setMaHH(maHH);
                    
                    CT_PhieuNhapDTO CT_phieuNhap = new CT_PhieuNhapDTO(soLuong, donGiaNhap, phieuNhapDTO, nhaCungCapDTO, CT_hangHoaDTO);
                    
                    DS_CTPhieuNhap.add(CT_phieuNhap);
                }
                
                return DS_CTPhieuNhap;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
    
    conndb ConPN = new conndb();
    
    public boolean insertCTPhieuNhap(CT_PhieuNhapDTO ct) {
        boolean check = false;
        if (openConnection()) {
            try {
                String sql = "INSERT INTO CT_PHIEUNHAP VALUES(?,?,?,?,?)";
                java.sql.PreparedStatement ps = con.prepareCall(sql);
                ps.setString(1, ct.getMaPN());
                ps.setString(2, ct.getMaCT_HH());
                ps.setString(3, ct.getMaNCC());
                ps.setFloat(4, ct.getSLNhap());
                ps.setFloat(5, ct.getDonGiaNhap());
                if (ps.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return check;
    }
    
    public ArrayList<Float> getSLNhap(String maPN, String maCTHH) {
        ArrayList<Float> ctp = new ArrayList<>();
        if (openConnection()) {
            try {
                String sql = "Select SoLuongNhap From CT_PhieuNhap where maPhieuNhap = '"+ maPN +"' and maCT_HH = '" + maCTHH +"'";
                PreparedStatement ps = con.prepareCall(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    float soLuong = rs.getFloat(1);
                    ctp.add(soLuong);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return ctp;
    }
}