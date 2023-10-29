package com.myproject.DAO;
import com.myproject.DTO.HH_CTHH_DTO;
import com.myproject.DTO.HangHoaDTO;
import com.myproject.DTO.HangHoaTongDTO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class HangHoaDAO extends conndb{
    public ArrayList<HH_CTHH_DTO> getAllHHFormFixPN() {
        ArrayList<HH_CTHH_DTO> arr = new ArrayList<>();
        if(openConnection()) {
            try {
                String sql = 
                "SELECT hanghoa.mahh, hanghoa.tenhh, SUM(ct_hanghoa.soluong) AS 'soluong'\n" +
                "FROM hanghoa\n" +
                "INNER JOIN ct_hanghoa ON hanghoa.mahh = ct_hanghoa.mahh\n" +
                "WHERE hanghoa.tinhtrang = 1 AND ct_hanghoa.tinhtrang = 1\n" +
                "GROUP BY hanghoa.mahh, hanghoa.tenhh\n" +
                "UNION ALL\n" +
                "SELECT hanghoa.mahh, hanghoa.tenhh, 0 AS soluong\n" +
                "FROM hanghoa\n" +
                "WHERE hanghoa.tinhtrang = 1 and hanghoa.mahh NOT IN \n" +
                "(SELECT hanghoa.mahh\n" +
                "FROM hanghoa\n" +
                "INNER JOIN ct_hanghoa ON hanghoa.mahh = ct_hanghoa.mahh\n" +
                "WHERE hanghoa.tinhtrang = 1 AND ct_hanghoa.tinhtrang = 1\n" +
                "GROUP BY hanghoa.mahh, hanghoa.tenhh) order by mahh";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                    HH_CTHH_DTO p = new HH_CTHH_DTO();
                    p.setMaHH(rs.getString("mahh"));
                    p.setTenHH(rs.getString("tenhh"));
                    p.setSoLuong(rs.getFloat("soluong"));
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
    // Phương thức để lấy danh sách các mặt hàng (HangHoa) từ cơ sở dữ liệu
    public List<HangHoaTongDTO> getAllHangHoa() {
        List<HangHoaTongDTO> hangHoaList = new ArrayList<>();
        if (openConnection()) {
            try {
                String sql1 = "SELECT *"
                        + "FROM HANGHOA "
                        + "INNER JOIN CT_HANGHOA ON HANGHOA.MaHH = CT_HANGHOA.MaHH "
                        + "INNER JOIN LOAIHANG ON HANGHOA.MaLH = LOAIHANG.MaLH;";
                PreparedStatement stmt = con.prepareStatement(sql1);
                ResultSet resultSet = stmt.executeQuery();

                while (resultSet.next()) {
                    HangHoaTongDTO hangHoa = new HangHoaTongDTO();
                    hangHoa.setMaCT_HH(resultSet.getString("MaCT_HH"));
                    hangHoa.setMaHH(resultSet.getString("MaHH"));
                    hangHoa.setTenHH(resultSet.getString("TenHH"));
                    hangHoa.setNgaySX(resultSet.getTimestamp("NgSanXuat"));
                    hangHoa.setHSD(resultSet.getTimestamp("HanSuDung"));
                    hangHoa.setDonGiaBan(resultSet.getFloat("DonGiaBan"));
                    hangHoa.setMaKM(resultSet.getString("MaKM"));
                    hangHoa.setDonVi(resultSet.getString("DonVi"));
                    hangHoa.setTenLH(resultSet.getString("TenLH"));
                    hangHoa.setSoLuong(resultSet.getFloat("SoLuong"));
                    hangHoa.setTinhTrang(resultSet.getBoolean("TinhTrang"));
                    hangHoaList.add(hangHoa);
                }
                resultSet.close();
                stmt.close();
                return hangHoaList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<HangHoaDTO> getList() {
        List<HangHoaDTO> list = new ArrayList<>();
        if (openConnection()) {
            try {
                String sql = "SELECT*FROM HANGHOA";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    HangHoaDTO hh = new HangHoaDTO();
                    hh.setMaHH(rs.getString("MaHH"));
                    hh.setTenHH(rs.getString("TenHH"));
                    hh.setMaKM(rs.getString("MaKM"));
                    hh.setDonGiaBan(rs.getFloat("DonGiaBan"));
                    hh.setDonVi(rs.getString("DonVi"));
                    hh.setMaLH(rs.getString("MaLH"));
                    hh.setTinhTrang(rs.getBoolean("TinhTrang"));
                    list.add(hh);
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

    public boolean updateTinhTrangHangHoa(String MaHH, boolean TinhTrang) {
        if (openConnection()) {
            try {
                String sql = "UPDATE HANGHOA SET TinhTrang = ? WHERE MaHH = ?";
                try (PreparedStatement stmt = con.prepareStatement(sql);) {
                    stmt.setBoolean(1, TinhTrang);
                    stmt.setString(2, MaHH);
                    int rowsUpdated = stmt.executeUpdate();
                    return rowsUpdated > 0; // Trả về true nếu có ít nhất một hàng đã được cập nhật
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}