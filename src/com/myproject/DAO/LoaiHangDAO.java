package com.myproject.DAO;

import com.myproject.DTO.LoaiHangDTO;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class LoaiHangDAO extends conndb{
    public ArrayList<LoaiHangDTO> getAllLH() {
       ArrayList<LoaiHangDTO> arr = new ArrayList<>();
       if(openConnection()) {
           try {
               String sql = "SELECT * FROM LOAIHANG";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               while(rs.next()) {
                   LoaiHangDTO p = new LoaiHangDTO();
                   p.setMaLH(rs.getString("MaLH"));
                   p.setTenLH(rs.getString("TenLH"));
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

    public boolean addLH(String MaLH, String TenLH) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "Insert into LOAIHANG values(?,?,?)";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                prest.setString(1, MaLH);
                prest.setString(2, TenLH);
                prest.setBoolean(3, true);
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

    public boolean fixLH(String MaLH, String TenLH, boolean TinhTrang) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE LOAIHANG SET TENLH = ?, TINHTRANG = ? WHERE MALH = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                prest = con.prepareStatement(sql);
                prest.setString(1, TenLH);
                prest.setBoolean(2, TinhTrang);
                prest.setString(3, MaLH);
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
}
