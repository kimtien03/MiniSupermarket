package com.myproject.BUS;

import com.myproject.DAO.HangHoaDAO;
import com.myproject.DTO.CT_HangHoaDTO;
import com.myproject.DTO.HH_CTHH_DTO;
import com.myproject.DTO.HangHoaDTO;
import com.myproject.DTO.HangHoaTongDTO;
import com.myproject.DTO.LoaiHangDTO;
import java.util.ArrayList;
import java.util.List;

public class HangHoaBUS {
    HangHoaDAO hh = new HangHoaDAO();
    
    public ArrayList<HH_CTHH_DTO> getAllHHFormFixPN() {
        return hh.getAllHHFormFixPN();
    }
    public List<HangHoaTongDTO> getAllHangHoa() {
        return hh.getAllHangHoa();
    }
    public List<HangHoaDTO> getList() {
        return hh.getList();
    }
    public boolean updateTinhTrangHangHoa(String maHH, boolean newTinhTrang) {
        return hh.updateTinhTrangHangHoa(maHH, newTinhTrang);
    }
    
    public int getCountHH() {
        return hh.getAllCount();
    }

    public boolean insertHangHoa(HangHoaDTO hhDTO) {
        hh.insertHangHoa(hhDTO);
        return true;
    }

    public ArrayList<HangHoaDTO> getListHHTotal(ArrayList<CT_HangHoaDTO> listCTHH, ArrayList<LoaiHangDTO> listLH) {
        return hh.getHangHoaTotal(listCTHH, listLH);
    }

    public boolean insertHH(HangHoaDTO hh) {
        HangHoaDAO x = new HangHoaDAO();
        return x.insertHangHoa(hh);
    }
    
    public ArrayList<Float> getHangSL() {
        return hh.getHangSL();
    }
    
    public boolean updateHang(String maHH, String maLH, boolean tinhTrang) {
        hh.updateHang(maHH, maLH, tinhTrang);
        return true;
    }
    
    
    // TIENDAT
    // tìm kiếm sản phầm theo mã 
    public HangHoaDTO getProductByID(String MaHH) {
        ArrayList<HangHoaDTO> productList = hh.getAllProducts();
        for(HangHoaDTO productItem : productList) {
            if(productItem.getMaHH().trim().equals(MaHH)) {
                return productItem;
            }
        }
        return null;
    }
    
    public boolean checkQuantityOfProduct(float quantity, String MaHH) {
        float quantityOfProduct = (float) hh.getQuantityOfProduct(MaHH);
        if(quantityOfProduct >=  quantity) {
            return true;
        }
        return false;
    }
    
    public float getQuantityOfProductInWarehouse(String MaHH) {
        return hh.getQuantityOfProduct(MaHH);
    }
}
