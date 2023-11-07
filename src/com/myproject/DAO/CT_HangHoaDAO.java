package com.myproject.DAO;

import com.myproject.DTO.CT_HangHoaDTO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CT_HangHoaDAO extends conndb {
    public List<CT_HangHoaDTO> getList() {
        List<CT_HangHoaDTO> list = new ArrayList<>();
        if (openConnection()) {
            try {
                String sql = "SELECT*FROM CT_HANGHOA";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    CT_HangHoaDTO cthh = new CT_HangHoaDTO();
                    cthh.setMaCT_HH(rs.getString("MaCT_HH"));
                    cthh.setSoLuong(rs.getFloat("SoLuong"));
                    cthh.setNgaySX(rs.getDate("NgSanXuat"));
                    cthh.setHSD(rs.getDate("HanSuDung"));
                    cthh.setMaHH(rs.getString("MaHH"));
                    cthh.setTinhTrang(rs.getBoolean("TinhTrang"));
                    list.add(cthh);
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

    
    public boolean insertCTHH(CT_HangHoaDTO ct) {
        boolean check = false;
        if (openConnection()) {
            try {
                String sql = "INSERT INTO CT_HANGHOA VALUES(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareCall(sql);
                ps.setString(1, ct.getMaCT_HH());
                ps.setDate(2, ct.getNgaySX());
                ps.setDate(3, ct.getHSD());
                ps.setBoolean(4, ct.isTinhTrang());
                ps.setString(5, ct.getMaHH());
                ps.setFloat(6, ct.getSoLuong());
                if (ps.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return check;
    }
    
    public boolean updateSL(float soLuong, String maCT_HH) {
        boolean check = false;
        if (openConnection()) {
            try {
                String sql = "Update CT_HangHoa set SoLuong = ? where maCT_HH = '" + maCT_HH + "'";
                PreparedStatement ps = con.prepareCall(sql);
                ps.setFloat(1, soLuong);
                if (ps.executeUpdate() >= 1) {
                    check =true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return check;
    }

    public void AutoUpdateCT_HH(Date date) {
        if (openConnection()) {
            try {
                String sql = "Update CT_HangHoa set TinhTrang = 0 where HanSuDung <= '" + date + "'";
                PreparedStatement ps = con.prepareCall(sql);
                ps.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                closeConnection();
            }
        }
    }
    
    
    
    
    // TIENDAT
    // lấy mã chi tiết hoàng hóa theo mã hàng hóa
    public ArrayList<CT_HangHoaDTO> getProductDetailsByProductID(String MaHH) {
        ArrayList<CT_HangHoaDTO> productDetailsList = new ArrayList<CT_HangHoaDTO>();
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM CT_HANGHOA WHERE MaHH = ? AND TinhTrang = 1 AND HanSuDung >= GETDATE() ORDER BY NgSanXuat";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, MaHH);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()) {
                    String MaCT_HH = rs.getString("MaCT_HH");
                    int SoLuong = rs.getInt("SoLuong");
                    Date NgSanXuat = rs.getDate("NgSanXuat");
                    Date HanSuDung = rs.getDate("HanSuDung");
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    
                    CT_HangHoaDTO productDetail = new CT_HangHoaDTO(MaCT_HH, MaHH, 
                            NgSanXuat, HanSuDung, SoLuong, TinhTrang);
                    productDetailsList.add(productDetail);
                    
                }
            } catch (Exception e) {
            }
        }
        
        return productDetailsList;
    }
    
    // lấy chi tiết hàng hóa theo mã chi tiết hàng hóa
    public CT_HangHoaDTO getProductDetailsByID(String MaCT_HH) {
        CT_HangHoaDTO productDetails = null;
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM CT_HANGHOA WHERE MaCT_HH = ?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, MaCT_HH);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()) {
                    Date NgSanXuat = rs.getDate("NgSanXuat");
                    Date HanSuDung = rs.getDate("HanSuDung");
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    String MaHH = rs.getString("MaHH");
                    float soluong = rs.getFloat("soluong");
                    
                    productDetails = new CT_HangHoaDTO(MaCT_HH, MaHH, 
                            NgSanXuat, HanSuDung, soluong, TinhTrang);
                }
            } catch (Exception e) {
            }
        }
        
        return productDetails;
    }
    
    // CẬP NHẬT DỮ LIỆU 
    // cập nhật lại số lượng hàng hóa trong kho khi số lượng khách mua = số lượng trong kho 
    public int updateQuantityOfProduct1(String MaCT_HH) {
        if(openConnection()) {
            try {
                String sql = "UPDATE CT_HANGHOA SET TinhTrang = 0, soluong = 0 WHERE MaCT_HH = ?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, MaCT_HH);
                return preparedStatement.executeUpdate();
            } catch (Exception e) {
            }
        }
        return -1;
    }
    
    // cập nhật lại số lượng hàng háo trong kho 
    public int updateQuantityOfProduct2(String MaCT_HH, float soluong, boolean TinhTrang) {
        if(openConnection()) {
            try {
                String sql = "UPDATE CT_HANGHOA SET soluong = ?, TinhTrang = ? WHERE MaCT_HH = ?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setFloat(1, soluong);
                preparedStatement.setBoolean(2, TinhTrang);
                preparedStatement.setString(3, MaCT_HH);
                return preparedStatement.executeUpdate();
            } catch (Exception e) {
            }
        }
        return -1;
    }
}
