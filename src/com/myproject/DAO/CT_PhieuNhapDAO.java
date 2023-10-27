package com.myproject.DAO;
import com.myproject.DTO.CT_HangHoaDTO;
import com.myproject.DTO.CT_PhieuNhapDTO;
import com.myproject.DTO.NhaCungCapDTO;
import com.myproject.DTO.PhieuNhapDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class CT_PhieuNhapDAO extends conndb{
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
                    Timestamp ngaySX = rs.getTimestamp(3);
                    Timestamp hanSuDung = rs.getTimestamp(4);
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
                    Timestamp ngaySX = rs.getTimestamp(3);
                    Timestamp hanSuDung = rs.getTimestamp(4);
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
   
}
