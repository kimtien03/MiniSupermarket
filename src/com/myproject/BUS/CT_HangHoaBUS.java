/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.BUS;

import com.myproject.DAO.CT_HangHoaDAO;
import com.myproject.DTO.CT_HangHoaDTO;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class CT_HangHoaBUS {
    public ArrayList<CT_HangHoaDTO> getAllMaCT() {
        CT_HangHoaDAO ct = new CT_HangHoaDAO();
        return ct.getAllMaHH();
    }
    
    public boolean insertCTHH(CT_HangHoaDTO cth) {
        CT_HangHoaDAO ct = new CT_HangHoaDAO();
        ct.insertCTHH(cth);
        return true;
    }
}
