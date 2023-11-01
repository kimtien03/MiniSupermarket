
package com.myproject.GUI.QuanLy.QuanLyPanels;

import com.myproject.BUS.CT_HangHoaBUS;
import com.myproject.BUS.HangHoaBUS;
import com.myproject.BUS.KhuyenMaiBUS;
import com.myproject.BUS.LoaiHangBUS;
import com.myproject.DAO.HangHoaDAO;
import com.myproject.DTO.CT_HangHoaDTO;
import com.myproject.DTO.HangHoaDTO;
import com.myproject.DTO.KhuyenMaiDTO;
import com.myproject.DTO.LoaiHangDTO;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class QLHangHoaPanel extends javax.swing.JPanel {

    HangHoaBUS HHGUI = new HangHoaBUS();
    List<HangHoaDTO> hangHoaList;
    CT_HangHoaBUS CTHHGUI = new CT_HangHoaBUS();
    List<CT_HangHoaDTO> CThangHoaList;
    KhuyenMaiBUS KMGUI = new KhuyenMaiBUS();
    List<KhuyenMaiDTO> khuyenMaiList = KMGUI.getAllKM();
    LoaiHangBUS LHGUI = new LoaiHangBUS();
    ArrayList<LoaiHangDTO> loaiHangList;
    DefaultTableModel modelTableProduct;
    DefaultTableModel modelTableCTHH;
    /**
     * Creates new form QLHangHoaPanel
     */
    public QLHangHoaPanel() {
        initComponents();
        modelTableProduct = (DefaultTableModel) jtbProduct.getModel();
        modelTableCTHH = (DefaultTableModel) jtbCTHHFormCTHH.getModel();
        loadLH();
        loadDV();
        loadHH();
    }
    public void loadHH() {
        hangHoaList = HHGUI.getList();
        modelTableProduct.setRowCount(0);
        float giaKM = 0;
        for (HangHoaDTO hh : hangHoaList) {
            if (hh.getMaKM() == null) {
                giaKM = 0;
            } 
            else {
                for (KhuyenMaiDTO km : khuyenMaiList) {
                    if (hh.getMaKM().equalsIgnoreCase(km.getMaKM())) {
                        float TL = km.getTiLeGiam();
                        float DG = hh.getDonGiaBan();
                        giaKM = DG * TL;
                        giaKM = hh.getDonGiaBan() - giaKM;
                        break;
                    }
                }
            }
            Object[] rowData = {hh.getMaHH(), hh.getTenHH(),hh.getDonGiaBan(), giaKM, hh.getDonVi(), hh.getMaLH(), hh.isTinhTrang()};
            modelTableProduct.addRow(rowData);
        }
        jtbProduct.setModel(modelTableProduct);
    }
    public void loadCTHH(String maHH) {
        CThangHoaList = CTHHGUI.getList();
        modelTableCTHH.setRowCount(0);
        for (CT_HangHoaDTO cthh : CThangHoaList) {
            if (maHH.trim().equalsIgnoreCase(cthh.getMaHH().trim())) {
                Object[] rowData = {cthh.getMaCT_HH(),cthh.getNgaySX(),cthh.getHSD(),cthh.getSoLuong(),cthh.isTinhTrang()};
                modelTableCTHH.addRow(rowData);
            }
        }
        jtbCTHHFormCTHH.setModel(modelTableCTHH);
    }
    public void loadLH() {
        loaiHangList = LHGUI.getALLLH();
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jcbboxLH.getModel();
        comboBoxModel.addElement("Tất Cả");
        for (LoaiHangDTO lh : loaiHangList) {
            comboBoxModel.addElement(lh.getMaLH().trim());
        }
        jcbboxLH.setModel(comboBoxModel);
    }
    public void loadDV() {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jcbboxUnit.getModel();
        comboBoxModel.addElement("Tất Cả");
        for (HangHoaDTO hh : hangHoaList) {
            boolean flag = true;
            for (int i=1;i<comboBoxModel.getSize();i++) {
                String donVi = (String) comboBoxModel.getElementAt(i);
                if (hh.getDonVi().trim().equalsIgnoreCase(donVi.trim())) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                comboBoxModel.addElement(hh.getDonVi().trim()); 
        }
        jcbboxUnit.setModel(comboBoxModel);
    }
    public void FilterHH() {
        hangHoaList = HHGUI.getList();
        modelTableProduct.setRowCount(0);
        FilterStatus();
        FilterLH();
        FilterDV();
        FilterSearch();
        float giaKM = 0;
        if(hangHoaList.size() !=0) {
            for (HangHoaDTO hh : hangHoaList) {
                if (hh.getMaKM() == null) {
                    giaKM = 0;
                } 
                else {
                    for (KhuyenMaiDTO km : khuyenMaiList) {
                        if (hh.getMaKM().equalsIgnoreCase(km.getMaKM())) {
                            float TL = km.getTiLeGiam();
                            float DG = hh.getDonGiaBan();
                            giaKM = DG * TL;
                            giaKM = hh.getDonGiaBan() - giaKM;
                            break;
                        }
                    }
                }
                Object[] rowData = {hh.getMaHH(), hh.getTenHH(),hh.getDonGiaBan(), giaKM, hh.getDonVi(), hh.getMaLH(), hh.isTinhTrang()};
                modelTableProduct.addRow(rowData);
            }
        }
        jtbProduct.setModel(modelTableProduct);
    }
    public void FilterSearch(){
        String search = jtfSearch.getText();
        if(!search.trim().equalsIgnoreCase("")) {
            int i=0;
            while(i<hangHoaList.size()) {
                String str = "";
                if(!hangHoaList.get(i).getMaHH().toLowerCase().contains(search.toLowerCase()))
                {
                    hangHoaList.remove(hangHoaList.get(i));
                } else {
                    i++;
                }
            }
        }
    }
    public void FilterStatus() {
        if(jcbboxStatus.getSelectedIndex() != 0) {
            int intdex = jcbboxStatus.getSelectedIndex();
            boolean trangThai = false;
            if(intdex == 1) {
                trangThai = true;
            }
            int i=0;
            while(i<hangHoaList.size()) {
                if(hangHoaList.get(i).isTinhTrang()!= trangThai)
                {
                    hangHoaList.remove(hangHoaList.get(i));
                } else {
                    i++;
                }
            }
        }
    }
    public void FilterLH() {
        if(jcbboxLH.getSelectedIndex() != 0) {
            String loaiSP = jcbboxLH.getSelectedItem().toString();
            int i=0;
            while(i<hangHoaList.size()) {
                if(!loaiSP.trim().equalsIgnoreCase(hangHoaList.get(i).getMaLH().trim()))
                {
                    hangHoaList.remove(hangHoaList.get(i));
                } else {
                    i++;
                }
            }
        }
    }
    public void FilterDV() {
        if(jcbboxUnit.getSelectedIndex() != 0) {
            if(jcbboxUnit.getSelectedIndex() != -1) {
                String dvTinh = (String) jcbboxUnit.getSelectedItem();
                int i=0;
                while(i<hangHoaList.size()) {
                    if(!dvTinh.trim().equalsIgnoreCase(hangHoaList.get(i).getDonVi().trim()))
                    {
                        hangHoaList.remove(hangHoaList.get(i));
                    } else {
                        i++;
                    }
                }
            }
        }
    }
    public void DisplaySelectedRowData() {
        int selectedRow = jtbProduct.getSelectedRow();
        if (selectedRow != -1) {
            String maHH = (String) jtbProduct.getValueAt(selectedRow, 0);
            String tenHH = (String) jtbProduct.getValueAt(selectedRow, 1);
            Float donGia = (Float) jtbProduct.getValueAt(selectedRow, 2);
            Float giaKM = (Float) jtbProduct.getValueAt(selectedRow, 3);
            String donVi = (String) jtbProduct.getValueAt(selectedRow, 4);
            String loaiHang = (String) jtbProduct.getValueAt(selectedRow, 5);
            Boolean tinhTrang = (Boolean) jtbProduct.getValueAt(selectedRow, 6);
            jtfMaHH.setText(maHH);
            jtfTenHH.setText(tenHH);
            jtfPrice.setText(Float.toString(donGia));
            jtfGiaKM.setText(Float.toString(giaKM));
            jtfUnit.setText(donVi);
            jtfTTLH.setText(loaiHang);
            jcbboxTTStatus.setSelectedItem(tinhTrang ? "Đang bán" : "Tồn kho"); // Đặt giá trị cho JComboBox TinhTrang
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdlXemCTHH = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jtfMaHHFormCTHH = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfTenHHFormCTHH = new javax.swing.JTextField();
        jtfDGFormCTHH = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtfGKMFormCTHH = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jtfDVFormCTHH = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtfLHFormCTHH = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jcbboxTTFormCTHH = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jtfSLFormCTHH1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbCTHHFormCTHH = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jpnInfo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfMaHH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfTenHH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfUnit = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jcbboxTTStatus = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jtfGiaKM = new javax.swing.JTextField();
        jtfTTLH = new javax.swing.JTextField();
        jpnAct = new javax.swing.JPanel();
        jcbboxLH = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jcbboxUnit = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        jbttnChange = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jbttnExport = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jcbboxStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProduct = new javax.swing.JTable();

        jdlXemCTHH.setMinimumSize(new java.awt.Dimension(780, 590));
        jdlXemCTHH.setModal(true);

        jPanel3.setBackground(new java.awt.Color(3, 169, 244));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/detail.png"))); // NOI18N
        jLabel12.setText("Chi Tiết Hàng Hóa");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Hàng Hóa"));

        jLabel13.setText("Mã Hàng Hóa");

        jLabel14.setText("Tên Hàng Hóa");

        jLabel19.setText("Đơn Giá");

        jLabel20.setText("Giá Khuyến Mãi");

        jLabel21.setText("Đơn Vị");

        jLabel22.setText("Loại Hàng");

        jLabel23.setText("Tình Trạng");

        jcbboxTTFormCTHH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hoạt động", "Ngừng hoạt động" }));

        jLabel24.setText("Số Lượng");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfMaHHFormCTHH))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbboxTTFormCTHH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfTenHHFormCTHH))))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfSLFormCTHH1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDGFormCTHH, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGKMFormCTHH, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(31, 31, 31)
                        .addComponent(jtfDVFormCTHH, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfLHFormCTHH)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jtfMaHHFormCTHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jtfDGFormCTHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jtfDVFormCTHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtfTenHHFormCTHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jtfGKMFormCTHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jtfLHFormCTHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jcbboxTTFormCTHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jtfSLFormCTHH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtbCTHHFormCTHH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã CTHH", "Ngày Sản Xuất", "Hạn Sử Dụng", "Số Lượng", "Tình Trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtbCTHHFormCTHH);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jdlXemCTHHLayout = new javax.swing.GroupLayout(jdlXemCTHH.getContentPane());
        jdlXemCTHH.getContentPane().setLayout(jdlXemCTHHLayout);
        jdlXemCTHHLayout.setHorizontalGroup(
            jdlXemCTHHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdlXemCTHHLayout.setVerticalGroup(
            jdlXemCTHHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 640));

        jpnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel2.setText("Mã hàng hóa");

        jtfMaHH.setBorder(null);

        jLabel3.setText("Tên hàng hóa");

        jtfTenHH.setBorder(null);

        jLabel4.setText("Loại hàng");

        jLabel7.setText("Đơn giá");

        jtfPrice.setBorder(null);

        jLabel8.setText("Đơn vị");

        jtfUnit.setBorder(null);

        jLabel16.setText("Tình trạng");

        jcbboxTTStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang bán", "Tồn kho" }));
        jcbboxTTStatus.setBorder(null);

        jLabel18.setText("Giá khuyến mãi");

        jtfGiaKM.setBorder(null);

        jtfTTLH.setBorder(null);

        javax.swing.GroupLayout jpnInfoLayout = new javax.swing.GroupLayout(jpnInfo);
        jpnInfo.setLayout(jpnInfoLayout);
        jpnInfoLayout.setHorizontalGroup(
            jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jtfMaHH))
                .addGap(47, 47, 47)
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnInfoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jtfTenHH, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnInfoLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jtfTTLH, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel16))
                .addGap(23, 23, 23)
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfPrice)
                    .addComponent(jcbboxTTStatus, 0, 113, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jtfGiaKM)
                .addGap(30, 30, 30))
        );
        jpnInfoLayout.setVerticalGroup(
            jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnInfoLayout.createSequentialGroup()
                        .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(jtfGiaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jcbboxTTStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnInfoLayout.createSequentialGroup()
                        .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfMaHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jtfTenHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jtfTTLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnAct.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        jcbboxLH.setBorder(null);
        jcbboxLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbboxLHActionPerformed(evt);
            }
        });

        jLabel10.setText("Loại hàng");

        jLabel11.setText("Đơn vị");

        jcbboxUnit.setBorder(null);
        jcbboxUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbboxUnitActionPerformed(evt);
            }
        });

        jToolBar1.setRollover(true);

        jbttnChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/status.png"))); // NOI18N
        jbttnChange.setText("Đổi");
        jbttnChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnChange.setFocusable(false);
        jbttnChange.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbttnChange.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbttnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnChangeActionPerformed(evt);
            }
        });
        jToolBar1.add(jbttnChange);
        jToolBar1.add(jSeparator4);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/detail.png"))); // NOI18N
        jButton1.setText("Xem");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator1);

        jbttnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/xls-file.png"))); // NOI18N
        jbttnExport.setText("Excel");
        jbttnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnExport.setFocusable(false);
        jbttnExport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbttnExport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbttnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnExportActionPerformed(evt);
            }
        });
        jToolBar1.add(jbttnExport);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/search.png"))); // NOI18N

        jtfSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfSearch.setToolTipText("Search here...");
        jtfSearch.setBorder(null);
        jtfSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jtfSearchInputMethodTextChanged(evt);
            }
        });
        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });
        jtfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel17.setText("Tình trạng");

        jcbboxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang bán", "Tồn kho" }));
        jcbboxStatus.setBorder(null);
        jcbboxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbboxStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnActLayout = new javax.swing.GroupLayout(jpnAct);
        jpnAct.setLayout(jpnActLayout);
        jpnActLayout.setHorizontalGroup(
            jpnActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnActLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnActLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbboxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbboxLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbboxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jpnActLayout.setVerticalGroup(
            jpnActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnActLayout.createSequentialGroup()
                .addGroup(jpnActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnActLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jcbboxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addGroup(jpnActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jcbboxLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)
                                .addComponent(jcbboxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnActLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jtbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hàng Hóa", "Tên Hàng Hóa", "Đơn Giá", "Giá Khuyến Mãi", "Đơn Vị", "Loại Hàng", "Tình Trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbProductMouseClicked(evt);
            }
        });
        jtbProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbProductKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbProduct);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jpnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbttnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnChangeActionPerformed
        DefaultTableModel table = (DefaultTableModel) jtbProduct.getModel();
        int selectedRow = jtbProduct.getSelectedRow();
        if (selectedRow != -1) {
            int choose = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đổi trạng thái hàng hóa!","Đổi trạng thái",JOptionPane.OK_CANCEL_OPTION);
            if (choose == JOptionPane.OK_OPTION) {
                boolean currentStatus = (boolean) table.getValueAt(selectedRow, 6);
                boolean newStatus = !currentStatus;
                table.setValueAt(newStatus, selectedRow, 6);


                // Cập nhật JComboBox
                if (newStatus) {
                    jcbboxTTStatus.setSelectedItem("Đang bán");
                } else {
                    jcbboxTTStatus.setSelectedItem("Tồn kho");
                }

                // Lấy mã sản phẩm (MaHH) của sản phẩm đã chọn
                String maHH = (String) table.getValueAt(selectedRow, 0);

                // Cập nhật trạng thái trong cơ sở dữ liệu
                HangHoaDAO hangHoaDAO = new HangHoaDAO(); // Tạo một đối tượng DAO
                hangHoaDAO.updateTinhTrangHangHoa(maHH, newStatus); // Gọi phương thức updateTinhTrangHangHoa

                JOptionPane.showMessageDialog(null, "Đổi trạng thái thành công!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm để đổi trạng thái!");
        }
    }//GEN-LAST:event_jbttnChangeActionPerformed

    private void jbttnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnExportActionPerformed
        Workbook workbook = new XSSFWorkbook();

        // Tạo một bảng (sheet) trong Workbook
        Sheet sheet = workbook.createSheet("Danh sách hàng hóa");

        // Lấy dữ liệu từ JTable và điền vào bảng
        DefaultTableModel tableModel = (DefaultTableModel) jtbProduct.getModel();
        int rowCount = tableModel.getRowCount();
        int columnCount = tableModel.getColumnCount();

        for (int row = 0; row < rowCount; row++) {
            Row excelRow = sheet.createRow(row);

            for (int col = 0; col < columnCount; col++) {
                Cell cell = excelRow.createCell(col);
                Object cellValue = tableModel.getValueAt(row, col);

                // Đặt giá trị của ô dựa trên kiểu dữ liệu trong JTable
                if (cellValue instanceof String) {
                    cell.setCellValue((String) cellValue);
                } else if (cellValue instanceof Timestamp) {
                    cell.setCellValue((Timestamp) cellValue);
                } else if (cellValue instanceof Float) {
                    cell.setCellValue((Float) cellValue);
                } else if (cellValue instanceof Boolean) {
                    cell.setCellValue((Boolean) cellValue);
                } else {
                    // Nếu kiểu dữ liệu khác, bạn có thể xử lý tùy theo yêu cầu
                }
            }
        }

        try {
            // Chọn nơi lưu tệp Excel
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                // Đảm bảo tên tệp kết thúc bằng ".xlsx"
                String filePath = file.getPath();
                if (!filePath.endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }

                // Ghi Workbook vào tệp
                try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                    workbook.write(fileOut);
                    fileOut.flush();
                    JOptionPane.showMessageDialog(this, "Dữ liệu đã được xuất ra tệp Excel.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi xuất dữ liệu ra tệp Excel.");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jbttnExportActionPerformed

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed

    }//GEN-LAST:event_jtfSearchActionPerformed

    private void jcbboxUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbboxUnitActionPerformed
        FilterHH();
    }//GEN-LAST:event_jcbboxUnitActionPerformed

    private void jcbboxLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbboxLHActionPerformed
        FilterHH();
    }//GEN-LAST:event_jcbboxLHActionPerformed

    private void jcbboxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbboxStatusActionPerformed
        FilterHH();
    }//GEN-LAST:event_jcbboxStatusActionPerformed

    private void jtfSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtfSearchInputMethodTextChanged

    }//GEN-LAST:event_jtfSearchInputMethodTextChanged

    private void jtbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProductMouseClicked
        DisplaySelectedRowData();
    }//GEN-LAST:event_jtbProductMouseClicked

    private void jtbProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbProductKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbProductKeyPressed

    private void jtfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSearchKeyReleased
        FilterHH();
    }//GEN-LAST:event_jtfSearchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jtbProduct.getSelectedRow() != -1) {
            loadCTHH((String) jtbProduct.getValueAt(jtbProduct.getSelectedRow(), 0));
            jtfMaHHFormCTHH.setText((String) jtbProduct.getValueAt(jtbProduct.getSelectedRow(), 0));
            jtfTenHHFormCTHH.setText((String) jtbProduct.getValueAt(jtbProduct.getSelectedRow(), 1));
            jtfDGFormCTHH.setText(Float.toString((float) jtbProduct.getValueAt(jtbProduct.getSelectedRow(), 2)));
            jtfGKMFormCTHH.setText(Float.toString((float) jtbProduct.getValueAt(jtbProduct.getSelectedRow(), 3)));
            jtfDVFormCTHH.setText((String) jtbProduct.getValueAt(jtbProduct.getSelectedRow(), 4));
            jtfLHFormCTHH.setText((String) jtbProduct.getValueAt(jtbProduct.getSelectedRow(), 5));
            if ((boolean) jtbProduct.getValueAt(jtbProduct.getSelectedRow(), 6))
                jcbboxTTFormCTHH.setSelectedIndex(0);
            else jcbboxTTFormCTHH.setSelectedIndex(1);
            float soLuong = 0;
            for (int i=0;i<modelTableCTHH.getRowCount();i++) {
                if ((boolean)modelTableCTHH.getValueAt(i, 4)) {
                    soLuong+= (float) modelTableCTHH.getValueAt(i, 3);
                }
            }
            jtfSLFormCTHH1.setText(Float.toString(soLuong));
            jdlXemCTHH.setLocationRelativeTo(null);
            jdlXemCTHH.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 hàng hóa để xem chi tiết!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbttnChange;
    private javax.swing.JButton jbttnExport;
    private javax.swing.JComboBox<String> jcbboxLH;
    private javax.swing.JComboBox<String> jcbboxStatus;
    private javax.swing.JComboBox<String> jcbboxTTFormCTHH;
    private javax.swing.JComboBox<String> jcbboxTTStatus;
    private javax.swing.JComboBox<String> jcbboxUnit;
    private javax.swing.JDialog jdlXemCTHH;
    private javax.swing.JPanel jpnAct;
    private javax.swing.JPanel jpnInfo;
    private javax.swing.JTable jtbCTHHFormCTHH;
    private javax.swing.JTable jtbProduct;
    private javax.swing.JTextField jtfDGFormCTHH;
    private javax.swing.JTextField jtfDVFormCTHH;
    private javax.swing.JTextField jtfGKMFormCTHH;
    private javax.swing.JTextField jtfGiaKM;
    private javax.swing.JTextField jtfLHFormCTHH;
    private javax.swing.JTextField jtfMaHH;
    private javax.swing.JTextField jtfMaHHFormCTHH;
    private javax.swing.JTextField jtfPrice;
    private javax.swing.JTextField jtfSLFormCTHH1;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfTTLH;
    private javax.swing.JTextField jtfTenHH;
    private javax.swing.JTextField jtfTenHHFormCTHH;
    private javax.swing.JTextField jtfUnit;
    // End of variables declaration//GEN-END:variables
}
