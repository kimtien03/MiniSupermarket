package com.myproject.DAO;
import com.myproject.BUS.*;
import com.myproject.DTO.KhachHangDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class KhachHangDAO extends conndb{
    // lấy toàn bộ trường dữ liệu khách hàng
    public ArrayList<KhachHangDTO> getAllCusInfoAsArrayList() {
        ArrayList<KhachHangDTO> cusArrayList = new ArrayList<KhachHangDTO>();
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM KHACHHANG";
                ResultSet rs = con.createStatement().executeQuery(sql);
                while(rs.next()) {
                    String MaKH = rs.getString("MaKH");
                    String HoTen = rs.getString("HoTen");
                    int Diem = rs.getInt("Diem");
                    String SDT = rs.getString("SDT");
                    Date NgSinh = rs.getDate("NgSinh");
                    boolean TinhTrang = rs.getBoolean("TinhTrang");
                    
                    KhachHangDTO cusItem = new KhachHangDTO(MaKH, HoTen, SDT, 
                            Diem, NgSinh, TinhTrang);
                    cusArrayList.add(cusItem);
                }
            } catch (Exception e) {
            }
        }
        
        return cusArrayList;
    }
    
    // lấy một trường dữ liệu khách hàng theo tên
    public KhachHangDTO getCusByName(String HoTen) {
        KhachHangDTO customer = null;
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM KHACHHANG WHERE HoTen = ? AND TinhTrang = 1";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, HoTen);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    String MaKH = rs.getString("MaKH");
                    int Diem = rs.getInt("Diem");
                    String SDT = rs.getString("SDT");
                    Date NgSinh = rs.getDate("NgSinh");
                    
                    customer = new KhachHangDTO(MaKH, HoTen, SDT, Diem, NgSinh, true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return customer;
    }
    
    // lấy một trường dữ liệu khách hàng theo số điện thoại 
    public KhachHangDTO getCusByPhoneNum(String SDT) {
        KhachHangDTO customer = null;
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM KHACHHANG WHERE SDT = ? AND TinhTrang = 1";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, SDT);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    String HoTen = rs.getString("HoTen");
                    String MaKH = rs.getString("MaKH");
                    int Diem = rs.getInt("Diem");
                    Date NgSinh = rs.getDate("NgSinh");
                    
                    customer = new KhachHangDTO(MaKH, HoTen, SDT, Diem, NgSinh, true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return customer;
    }
    
    // lấy dữ liệu của khách vãng lai
    public KhachHangDTO getCasualGuests() {
        KhachHangDTO customer = null;
        
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM KHACHHANG WHERE MaKH = ?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, "KH000");
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    String MaKH = "KH000";
                    String HoTen = rs.getString("HoTen");
                    int Diem = rs.getInt("Diem");
                    String SDT = rs.getString("SDT");
                    Date NgSinh = rs.getDate("NgSinh");
                    
                    customer = new KhachHangDTO(MaKH, HoTen, SDT, Diem, NgSinh, true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return customer;
    }
    
    // ghi dữ liệu một khách hàng mới vào cơ sở dữ liệu 
    public int addCustomer(KhachHangDTO customer) {
        if (openConnection()) {
            try {
                String sql = "INSERT INTO KHACHHANG (MaKH, HoTen, Diem, SDT, NgSinh, TinhTrang) VALUES (?, ?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, customer.getMaKH().trim());
                preparedStatement.setString(2, customer.getHoTen());
                preparedStatement.setInt(3, customer.getDiem());
                preparedStatement.setString(4, customer.getSDT());
                preparedStatement.setDate(5, (java.sql.Date) customer.getNgSinh());
                preparedStatement.setBoolean(6, true);
                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}
