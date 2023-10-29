/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.myproject.GUI.QuanLy.QuanLyPanels;

import com.myproject.BUS.HangHoaBUS;
import com.myproject.BUS.KhuyenMaiBUS;
import com.myproject.DAO.HangHoaDAO;
import com.myproject.DTO.HangHoaTongDTO;
import com.myproject.DTO.KhuyenMaiDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    List<HangHoaTongDTO> hangHoaList = HHGUI.getAllHangHoa();
    KhuyenMaiBUS KMGUI = new KhuyenMaiBUS();
    List<KhuyenMaiDTO> khuyenMaiList = KMGUI.getAllKM();

    /**
     * Creates new form QLHangHoaPanel
     */
    public QLHangHoaPanel() {
        initComponents();
        loadHH();
        jtfSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchHH();
            }
        });
        ComboboxUnit();
        ComboboxLH();
        ComboboxTT();
        jtbProduct.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) { // Đảm bảo sự kiện chỉ xảy ra khi người dùng kết thúc việc chọn
                    DisplaySelectedRowData();
                }
            }
        });

    }

    public void loadHH() {
        DefaultTableModel table = (DefaultTableModel) jtbProduct.getModel();
        float giaKM = 0;
        for (HangHoaTongDTO hh : hangHoaList) {
            for (KhuyenMaiDTO km : khuyenMaiList) {
                if (hh.getMaKM() == null || km.isTinhTrang() == false) {
                    giaKM = 0;
                } else if (hh.getMaKM().contains(km.getMaKM()) && km.isTinhTrang() == true) {
                    // Lấy giá khuyến mãi từ đối tượng KhuyenMaiDTO (giả sử bạn có đối tượng này)
                    float TL = km.getTiLeGiam();
                    float DG = hh.getDonGiaBan();
                    giaKM = DG * TL;
                }

            }
            Object[] rowData = {hh.getMaHH(), hh.getMaCT_HH(), hh.getTenHH(), hh.getNgaySX(), hh.getHSD(),
                hh.getDonGiaBan(), giaKM, hh.getDonVi(), hh.getTenLH(), hh.getSoLuong(), hh.isTinhTrang()};
            table.addRow(rowData);
        }
    }

    public void ComboboxUnit() {
        jcbboxUnit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUnit = (String) jcbboxUnit.getSelectedItem();
                DefaultTableModel table = (DefaultTableModel) jtbProduct.getModel();

                // Làm sạch dữ liệu trong bảng
                table.setRowCount(0);

                for (HangHoaTongDTO hh : hangHoaList) {
                    if (selectedUnit.trim().equals(hh.getDonVi().trim())) {
                        addRowToTable(hh, table);
                    }
                }
            }
        });
    }

    public void ComboboxLH() {
        jcbboxLH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLH = ((String) jcbboxLH.getSelectedItem()); // Chuyển thành chữ thường

                DefaultTableModel table = (DefaultTableModel) jtbProduct.getModel();

                // Làm sạch dữ liệu trong bảng
                table.setRowCount(0);

                for (HangHoaTongDTO hh : hangHoaList) {
                    if (selectedLH.trim().equals(hh.getTenLH().trim())) {
                        addRowToTable(hh, table);
                    }
                }

            }
        });
    }

    public void ComboboxTT() {
        jcbboxStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTT = (String) jcbboxStatus.getSelectedItem(); // Lấy giá trị từ JComboBox

                DefaultTableModel table = (DefaultTableModel) jtbProduct.getModel();

                // Làm sạch dữ liệu trong bảng
                table.setRowCount(0);

                for (HangHoaTongDTO hh : hangHoaList) {
                    boolean tinhTrang = hh.isTinhTrang(); // Lấy giá trị Tình Trạng từ đối tượng hh

                    if ("Tất cả".equals(selectedTT) || ("Đang bán".equals(selectedTT) && tinhTrang) || ("Tồn kho".equals(selectedTT) && !tinhTrang)) {
                        addRowToTable(hh, table);
                    }
                }
            }
        });
    }

    private void addRowToTable(HangHoaTongDTO hh, DefaultTableModel table) {
        float giaKM = 0;
        for (KhuyenMaiDTO km : khuyenMaiList) {
            if (hh.getMaKM() != null && km.isTinhTrang() == true && hh.getMaKM().contains(km.getMaKM())) {
                float TL = km.getTiLeGiam();
                float DG = hh.getDonGiaBan();
                giaKM = DG * TL;
            }
        }

        Object[] rowData = {
            hh.getMaHH(), hh.getMaCT_HH(), hh.getTenHH(), hh.getNgaySX(), hh.getHSD(),
            hh.getDonGiaBan(), giaKM, hh.getDonVi(), hh.getTenLH(), hh.getSoLuong(), hh.isTinhTrang()
        };

        table.addRow(rowData);
    }

    public void searchHH() {
        DefaultTableModel table = (DefaultTableModel) jtbProduct.getModel();
        table.setRowCount(0); // Xóa tất cả các hàng khỏi bảng
        String searchText = jtfSearch.getText().trim().toLowerCase();

        for (HangHoaTongDTO hh : hangHoaList) {

            // Kiểm tra nếu thông tin sản phẩm khớp với dữ liệu tìm kiếm
            if (hh.getMaCT_HH().toLowerCase().contains(searchText)
                    || hh.getMaHH().toLowerCase().contains(searchText)) {
                // Tìm thấy kết quả phù hợp, thêm vào bảng
                float giaKM = 0;

                for (KhuyenMaiDTO km : khuyenMaiList) {
                    if (hh.getMaKM() != null && km.isTinhTrang() == true && hh.getMaKM().contains(km.getMaKM())) {
                        float TL = km.getTiLeGiam();
                        float DG = hh.getDonGiaBan();
                        giaKM = DG * TL;
                    }
                }

                Object[] rowData = {
                    hh.getMaHH(), hh.getMaCT_HH(), hh.getTenHH(), hh.getNgaySX(), hh.getHSD(),
                    hh.getDonGiaBan(), giaKM, hh.getDonVi(), hh.getTenLH(), hh.getSoLuong(), hh.isTinhTrang()
                };

                table.addRow(rowData);
            }
        }
    }

    public void DisplaySelectedRowData() {
        int selectedRow = jtbProduct.getSelectedRow();

        if (selectedRow != -1) {
            String maHH = (String) jtbProduct.getValueAt(selectedRow, 0);
            String maCTHH = (String) jtbProduct.getValueAt(selectedRow, 1);
            String tenHH = (String) jtbProduct.getValueAt(selectedRow, 2);
            Timestamp ngSanXuat = (Timestamp) jtbProduct.getValueAt(selectedRow, 3);
            Timestamp hsd = (Timestamp) jtbProduct.getValueAt(selectedRow, 4);
            Float donGia = (Float) jtbProduct.getValueAt(selectedRow, 5);
            Float giaKM = (Float) jtbProduct.getValueAt(selectedRow, 6);
            String donVi = (String) jtbProduct.getValueAt(selectedRow, 7);
            String loaiHang = (String) jtbProduct.getValueAt(selectedRow, 8);
            Float soLuong = (Float) jtbProduct.getValueAt(selectedRow, 9);
            Boolean tinhTrang = (Boolean) jtbProduct.getValueAt(selectedRow, 10);

            jtfMaHH.setText(maHH);
            jtfTenHH1.setText(maCTHH);
            jtfTenHH.setText(tenHH);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            jtfNSX.setText(dateFormat.format(ngSanXuat)); // Chuyển đổi và đặt ngày sản xuất
            jtfHSD.setText(dateFormat.format(hsd)); // Chuyển đổi và đặt hạn sử dụng

            jtfPrice.setText(Float.toString(donGia));
            jtfGiaKM.setText(Float.toString(giaKM));
            jtfUnit.setText(donVi);
            jtfQuantity.setText(Float.toString(soLuong));

            jcbboxTTLH.setSelectedItem(loaiHang); // Đặt giá trị cho JComboBox LoaiHang
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

        jpnInfo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfMaHH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfTenHH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfNSX = new javax.swing.JTextField();
        jcbboxTTLH = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jtfHSD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfUnit = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtfQuantity = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jcbboxTTStatus = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jtfGiaKM = new javax.swing.JTextField();
        jtfTenHH1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jpnAct = new javax.swing.JPanel();
        jcbboxLH = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jcbboxUnit = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        jbttnChange = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jbttnExport = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jcbboxStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProduct = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 640));

        jpnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel2.setText("Mã hàng hóa");

        jtfMaHH.setBorder(null);

        jLabel3.setText("Tên hàng hóa");

        jtfTenHH.setBorder(null);

        jLabel4.setText("Loại hàng");

        jLabel5.setText("Ngày sản xuất");

        jtfNSX.setBorder(null);

        jcbboxTTLH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nước Ngọt", "Thịt, cá", "Mì,Phở,Hủ Tiếu gói", "Bánh Kẹo", "Trái Cây" }));
        jcbboxTTLH.setBorder(null);

        jLabel6.setText("Hạn sử dụng");

        jtfHSD.setBorder(null);

        jLabel7.setText("Đơn giá");

        jtfPrice.setBorder(null);

        jLabel8.setText("Đơn vị");

        jtfUnit.setBorder(null);

        jLabel15.setText("Số lượng");

        jtfQuantity.setBorder(null);

        jLabel16.setText("Tình trạng");

        jcbboxTTStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang bán", "Tồn kho" }));
        jcbboxTTStatus.setBorder(null);

        jLabel18.setText("Giá khuyến mãi");

        jtfGiaKM.setBorder(null);

        jtfTenHH1.setBorder(null);

        jLabel9.setText("Mã CTHH");

        javax.swing.GroupLayout jpnInfoLayout = new javax.swing.GroupLayout(jpnInfo);
        jpnInfo.setLayout(jpnInfoLayout);
        jpnInfoLayout.setHorizontalGroup(
            jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfMaHH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jtfTenHH, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfTenHH1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbboxTTLH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfNSX)
                    .addComponent(jtfHSD, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel7)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnInfoLayout.createSequentialGroup()
                        .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfGiaKM, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jtfPrice))
                        .addGap(18, 18, 18)
                        .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnInfoLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfUnit))
                            .addGroup(jpnInfoLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jcbboxTTStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117))
        );
        jpnInfoLayout.setVerticalGroup(
            jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnInfoLayout.createSequentialGroup()
                        .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfMaHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfTenHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jpnInfoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jtfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfHSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(jtfGiaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jtfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnInfoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbboxTTLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addGroup(jpnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jtfTenHH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcbboxTTStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnAct.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        jcbboxLH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nước Ngọt", "Thịt, cá", "Mì,Phở,Hủ Tiếu gói", "Bánh Kẹo", "Trái Cây" }));
        jcbboxLH.setBorder(null);

        jLabel10.setText("Loại hàng");

        jLabel11.setText("Đơn vị");

        jcbboxUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "chai", "lon", "Kg", "gói" }));
        jcbboxUnit.setBorder(null);

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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbboxLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbboxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnActLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jtbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hàng Hóa", "Mã CTHH", "Tên Hàng Hóa", "Ngày Sản Xuất", "Hạn Sử Dụng", "Đơn Giá", "Giá Khuyến Mãi", "Đơn Vị", "Loại Hàng", "Số Lượng", "Tình Trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
                    .addComponent(jpnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbttnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnChangeActionPerformed
        DefaultTableModel table = (DefaultTableModel) jtbProduct.getModel();
        int selectedRow = jtbProduct.getSelectedRow();
        if (selectedRow != -1) {
            boolean currentStatus = (boolean) table.getValueAt(selectedRow, 10);
            boolean newStatus = !currentStatus;
            table.setValueAt(newStatus, selectedRow, 10); // Cập nhật "Tình Trạng" cho hàng đã chọn

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbttnChange;
    private javax.swing.JButton jbttnExport;
    private javax.swing.JComboBox<String> jcbboxLH;
    private javax.swing.JComboBox<String> jcbboxStatus;
    private javax.swing.JComboBox<String> jcbboxTTLH;
    private javax.swing.JComboBox<String> jcbboxTTStatus;
    private javax.swing.JComboBox<String> jcbboxUnit;
    private javax.swing.JPanel jpnAct;
    private javax.swing.JPanel jpnInfo;
    private javax.swing.JTable jtbProduct;
    private javax.swing.JTextField jtfGiaKM;
    private javax.swing.JTextField jtfHSD;
    private javax.swing.JTextField jtfMaHH;
    private javax.swing.JTextField jtfNSX;
    private javax.swing.JTextField jtfPrice;
    private javax.swing.JTextField jtfQuantity;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfTenHH;
    private javax.swing.JTextField jtfTenHH1;
    private javax.swing.JTextField jtfUnit;
    // End of variables declaration//GEN-END:variables
}
