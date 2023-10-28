package com.myproject.DAO;

import com.myproject.BUS.*;
import com.myproject.DTO.NhaCungCapDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO extends conndb{
    public ArrayList<NhaCungCapDTO> getAllNCC() {
        ArrayList<NhaCungCapDTO> arr = new ArrayList<>();
        if(openConnection()) {
            try {
                String sql = "SELECT * FROM NHACUNGCAP WHERE TINHTRANG = 1";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                    NhaCungCapDTO p = new NhaCungCapDTO();
                    p.setMaNCC(rs.getString("MaNCC"));
                    p.setTenNCC(rs.getString("TenNCC"));
                    p.setDiaChi(rs.getString("DiaChi"));
                    p.setEmail(rs.getString("Email"));
                    p.setSDT(rs.getString("SDT"));
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
    public List<NhaCungCapDTO> getList() {
        List<NhaCungCapDTO> list = new ArrayList<>();
        if (openConnection()) {
            try {
                String sql = "SELECT*FROM NHACUNGCAP";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    NhaCungCapDTO nhacc = new NhaCungCapDTO();
                    nhacc.setMaNCC(rs.getString("MaNCC"));
                    nhacc.setTenNCC(rs.getString("TenNCC"));
                    nhacc.setDiaChi(rs.getString("DiaChi"));
                    nhacc.setEmail(rs.getString("Email"));
                    nhacc.setSDT(rs.getString("SDT"));
                    nhacc.setTinhTrang(rs.getBoolean("TinhTrang"));
                    list.add(nhacc);
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

    public int AddNccNew(NhaCungCapDTO NewNcc) {
        int rs = 0;
        if (openConnection()) {
            try {
                String sql = "INSERT into NHACUNGCAP(MaNCC, TenNCC, DiaChi, Email, SDT, TinhTrang) VALUES(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, NewNcc.getMaNCC());
                ps.setString(2, NewNcc.getTenNCC());
                ps.setString(3, NewNcc.getDiaChi());
                ps.setString(4, NewNcc.getEmail());
                ps.setString(5, NewNcc.getSDT());
                ps.setBoolean(6, NewNcc.isTinhTrang());
                rs = ps.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }

    public int UpdateNccNew(NhaCungCapDTO FixNcc) {
        int rs = 0;
        if (openConnection()) {
            try {
                String sql = "UPDATE NHACUNGCAP SET TenNCC=?,DiaChi=?,Email=?,SDT=?, TinhTrang=? where MaNCC=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, FixNcc.getTenNCC());
                ps.setString(2, FixNcc.getDiaChi());
                ps.setString(3, FixNcc.getEmail());
                ps.setString(4, FixNcc.getSDT());
                ps.setBoolean(5, FixNcc.isTinhTrang());
                ps.setString(6, FixNcc.getMaNCC());
                rs = ps.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }
}
