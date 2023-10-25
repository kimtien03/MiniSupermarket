/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.myproject.GUI.QuanLy.QuanLyPanels;

import static com.itextpdf.text.pdf.security.LtvTimestamp.timestamp;
import com.myproject.BUS.HangHoaBUS;
import com.myproject.BUS.HoaDonBanHangBUS;
import com.myproject.BUS.LoaiHangBUS;
import com.myproject.BUS.PhieuNhapBUS;
import com.myproject.DAO.PhieuNhapDAO;
import com.myproject.DTO.CTPN_CTHH_HH_DTO;
import com.myproject.DTO.CT_PhieuNhapDTO;
import com.myproject.DTO.HH_CTHH_DTO;
import com.myproject.DTO.HangHoaDTO;
import com.myproject.DTO.LoaiHangDTO;
import com.myproject.DTO.PhieuNhapDTO;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QLNhapHangPanel extends javax.swing.JPanel {
    DefaultTableModel modelTablePN;
    DefaultTableModel modelTableCTPN;
    DefaultTableModel modelTableLH;
    DefaultTableModel modelTableSPN;
    DefaultTableModel modelTableSP;
    PhieuNhapBUS pn = new PhieuNhapBUS();
    LoaiHangBUS lh = new LoaiHangBUS();
    HangHoaBUS hh = new HangHoaBUS();
    ArrayList<PhieuNhapDTO> arrPN = new ArrayList<>();
    ArrayList<CTPN_CTHH_HH_DTO> arrCTPN = pn.getAllCTPN();
    ArrayList<LoaiHangDTO> arrLH;
    public QLNhapHangPanel() {
        initComponents();
        modelTablePN = (DefaultTableModel) jtbPNH.getModel();
        modelTableCTPN = (DefaultTableModel) jtbCTPN.getModel();
        modelTableLH = (DefaultTableModel) jtbDanhMuc.getModel();
        modelTableSPN = (DefaultTableModel) jtbSanPhamNhap.getModel();
        modelTableSP = (DefaultTableModel) jtbSanPham.getModel();
        loadAllPN();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdlFixPN = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfMaPNFormFixPN = new javax.swing.JTextField();
        jtfMaNVFormFixPN = new javax.swing.JTextField();
        jcbboxTinhTrangFormFixPN = new javax.swing.JComboBox<>();
        jButton12 = new javax.swing.JButton();
        jtfNgLapFormFixPN = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jtfThanhTienFormFixPN = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbSanPhamNhap = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbSanPham = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jdlDM = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbDanhMuc = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jtfSearchDM = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jbtnOpenFormAdd = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jbtnOpenFormFix = new javax.swing.JButton();
        jdlAddDM = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfMaLHFormAddDM = new javax.swing.JTextField();
        jtfTenLHFormAddDM = new javax.swing.JTextField();
        jbttnAddFormAdđM = new javax.swing.JButton();
        jdlFixCTPN = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jdlAddCTPN = new javax.swing.JDialog();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel30 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jdlFixDM = new javax.swing.JDialog();
        jPanel17 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jtfMaLHFormFixDM = new javax.swing.JTextField();
        jtfTenLHFormFixDM = new javax.swing.JTextField();
        jbttnFixFormFixDM = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jcbboxTTFormFIxDM = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jbttnDuyetPN = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jbttnXoaPN = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jbttnSuaPN = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jbttnClastify = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPNH = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbCTPN = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcbboxFilter = new javax.swing.JComboBox<>();

        jdlFixPN.setMinimumSize(new java.awt.Dimension(960, 770));
        jdlFixPN.setModal(true);

        jPanel1.setMinimumSize(new java.awt.Dimension(812, 708));

        jPanel6.setBackground(new java.awt.Color(3, 169, 244));
        jPanel6.setPreferredSize(new java.awt.Dimension(752, 80));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/remote-maintenance.png"))); // NOI18N
        jLabel5.setText("Sửa Phiếu Nhập");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin"));

        jLabel6.setText("Mã Phiếu Nhập");

        jLabel7.setText("Nhân Viên");

        jLabel10.setText("Ngày Lập");

        jLabel1.setText("Tình Trạng");

        jtfMaPNFormFixPN.setEnabled(false);

        jtfMaNVFormFixPN.setEnabled(false);

        jcbboxTinhTrangFormFixPN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Duyệt", "Chưa Duyệt" }));
        jcbboxTinhTrangFormFixPN.setEnabled(false);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/checked.png"))); // NOI18N
        jButton12.setText("Hoàn Thành");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jtfNgLapFormFixPN.setEnabled(false);

        jLabel26.setText("Thành Tiền");

        jtfThanhTienFormFixPN.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfMaPNFormFixPN, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNgLapFormFixPN, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jtfMaNVFormFixPN, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jcbboxTinhTrangFormFixPN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jtfThanhTienFormFixPN, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jtfMaPNFormFixPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMaNVFormFixPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jcbboxTinhTrangFormFixPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfNgLapFormFixPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jtfThanhTienFormFixPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Tiết Phiếu Nhập Hàng"));

        jtbSanPhamNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hàng Hóa", "Tên Hàng Hóa", "Ngày Sản Xuất", "Hạn Sử Dụng", "NCC", "Số Lượng", "Đơn Giá Nhập"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
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
        jScrollPane3.setViewportView(jtbSanPhamNhap);

        jtbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hàng Hóa", "Tên Hàng Hóa", "Số Lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jtbSanPham);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/remove.png"))); // NOI18N
        jButton10.setText("Xóa");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus.png"))); // NOI18N
        jButton11.setText("Thêm");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/fix.png"))); // NOI18N
        jButton1.setText("Sửa");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(3, 169, 244));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("SẢN PHẨM NHẬP");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/arrow.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(3, 169, 244));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SẢN PHẨM");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/arrow.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton10)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdlFixPNLayout = new javax.swing.GroupLayout(jdlFixPN.getContentPane());
        jdlFixPN.getContentPane().setLayout(jdlFixPNLayout);
        jdlFixPNLayout.setHorizontalGroup(
            jdlFixPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdlFixPNLayout.setVerticalGroup(
            jdlFixPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jdlDM.setMinimumSize(new java.awt.Dimension(703, 574));
        jdlDM.setModal(true);

        jPanel10.setBackground(new java.awt.Color(3, 169, 244));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/options.png"))); // NOI18N
        jLabel15.setText("Danh Mục");
        jLabel15.setToolTipText("");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jtbDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Loại Hàng", "Tên Loại Hàng", "Tình trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jtbDanhMuc);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/search.png"))); // NOI18N

        jtfSearchDM.setToolTipText("Search here...");
        jtfSearchDM.setBorder(null);
        jtfSearchDM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfSearchDMKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSearchDM, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jtfSearchDM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        jToolBar2.setRollover(true);

        jbtnOpenFormAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus.png"))); // NOI18N
        jbtnOpenFormAdd.setText("Thêm");
        jbtnOpenFormAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnOpenFormAdd.setFocusable(false);
        jbtnOpenFormAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnOpenFormAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnOpenFormAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOpenFormAddActionPerformed(evt);
            }
        });
        jToolBar2.add(jbtnOpenFormAdd);
        jToolBar2.add(jSeparator5);

        jbtnOpenFormFix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/fix.png"))); // NOI18N
        jbtnOpenFormFix.setText("Sửa");
        jbtnOpenFormFix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnOpenFormFix.setFocusable(false);
        jbtnOpenFormFix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnOpenFormFix.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnOpenFormFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOpenFormFixActionPerformed(evt);
            }
        });
        jToolBar2.add(jbtnOpenFormFix);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jdlDMLayout = new javax.swing.GroupLayout(jdlDM.getContentPane());
        jdlDM.getContentPane().setLayout(jdlDMLayout);
        jdlDMLayout.setHorizontalGroup(
            jdlDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdlDMLayout.setVerticalGroup(
            jdlDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jdlAddDM.setMinimumSize(new java.awt.Dimension(377, 120));
        jdlAddDM.setModal(true);

        jLabel4.setText("Mã Loại Hàng");

        jLabel11.setText("Tên Loại Hàng");

        jtfMaLHFormAddDM.setEnabled(false);

        jbttnAddFormAdđM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus.png"))); // NOI18N
        jbttnAddFormAdđM.setText("Thêm");
        jbttnAddFormAdđM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnAddFormAdđM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnAddFormAdđMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jtfMaLHFormAddDM, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jtfTenLHFormAddDM)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jbttnAddFormAdđM)
                .addGap(22, 22, 22))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfMaLHFormAddDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jtfTenLHFormAddDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbttnAddFormAdđM)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdlAddDMLayout = new javax.swing.GroupLayout(jdlAddDM.getContentPane());
        jdlAddDM.getContentPane().setLayout(jdlAddDMLayout);
        jdlAddDMLayout.setHorizontalGroup(
            jdlAddDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdlAddDMLayout.setVerticalGroup(
            jdlAddDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jdlFixCTPN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jdlFixCTPN.setMinimumSize(new java.awt.Dimension(350, 195));
        jdlFixCTPN.setModal(true);

        jLabel2.setText("Số Lượng");

        jLabel19.setText("Đơn Giá Nhập");

        jTextField3.setBorder(null);

        jTextField4.setBorder(null);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/fix.png"))); // NOI18N
        jButton13.setText("Sửa");

        jLabel24.setText("Nhà Cung Cấp");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NCC001", "NCC002", "NCC003" }));
        jComboBox3.setBorder(null);

        jLabel27.setText("Ngày Sản Xuất");

        jLabel28.setText("Hạn Sử Dụng");

        jDateChooser1.setDateFormatString("dd-MM-yyyy");

        jDateChooser2.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jdlFixCTPNLayout = new javax.swing.GroupLayout(jdlFixCTPN.getContentPane());
        jdlFixCTPN.getContentPane().setLayout(jdlFixCTPNLayout);
        jdlFixCTPNLayout.setHorizontalGroup(
            jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlFixCTPNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdlFixCTPNLayout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jdlFixCTPNLayout.createSequentialGroup()
                            .addGroup(jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(jTextField3)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jdlFixCTPNLayout.createSequentialGroup()
                            .addGroup(jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel24)
                                .addComponent(jLabel27))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox3, 0, 132, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdlFixCTPNLayout.setVerticalGroup(
            jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlFixCTPNLayout.createSequentialGroup()
                .addGroup(jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdlFixCTPNLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jdlFixCTPNLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdlFixCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jdlAddCTPN.setMinimumSize(new java.awt.Dimension(380, 220));
        jdlAddCTPN.setModal(true);

        jLabel20.setText("Số Lượng");

        jLabel21.setText("Đơn Giá Nhập");

        jTextField7.setBorder(null);

        jTextField8.setBorder(null);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus.png"))); // NOI18N
        jButton14.setText("Thêm");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel25.setText("Nhà Cung Cấp");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NCC001", "NCC002", "NCC003" }));
        jComboBox4.setBorder(null);

        jLabel29.setText("Ngày Sản Xuất");

        jDateChooser3.setDateFormatString("dd-MM-yyyy");

        jLabel30.setText("Hạn Sử Dụng");

        jDateChooser4.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jdlAddCTPNLayout = new javax.swing.GroupLayout(jdlAddCTPN.getContentPane());
        jdlAddCTPN.getContentPane().setLayout(jdlAddCTPNLayout);
        jdlAddCTPNLayout.setHorizontalGroup(
            jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlAddCTPNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdlAddCTPNLayout.createSequentialGroup()
                        .addGroup(jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox4, 0, 130, Short.MAX_VALUE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(33, 33, 33)
                        .addComponent(jButton14))
                    .addGroup(jdlAddCTPNLayout.createSequentialGroup()
                        .addGroup(jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdlAddCTPNLayout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jdlAddCTPNLayout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGroup(jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdlAddCTPNLayout.setVerticalGroup(
            jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlAddCTPNLayout.createSequentialGroup()
                .addGroup(jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdlAddCTPNLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jdlAddCTPNLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton14)))
                .addGap(18, 18, 18)
                .addGroup(jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdlAddCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jdlFixDM.setMinimumSize(new java.awt.Dimension(377, 150));
        jdlFixDM.setModal(true);

        jLabel17.setText("Mã Loại Hàng");

        jLabel22.setText("Tên Loại Hàng");

        jtfMaLHFormFixDM.setEnabled(false);

        jbttnFixFormFixDM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/fix.png"))); // NOI18N
        jbttnFixFormFixDM.setText("Sửa");
        jbttnFixFormFixDM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnFixFormFixDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnFixFormFixDMActionPerformed(evt);
            }
        });

        jLabel23.setText("Tình Trạng");

        jcbboxTTFormFIxDM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bật", "Tắt" }));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jtfMaLHFormFixDM, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbboxTTFormFIxDM, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTenLHFormFixDM))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jbttnFixFormFixDM)
                .addGap(27, 27, 27))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jtfMaLHFormFixDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTenLHFormFixDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbttnFixFormFixDM)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jcbboxTTFormFIxDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdlFixDMLayout = new javax.swing.GroupLayout(jdlFixDM.getContentPane());
        jdlFixDM.getContentPane().setLayout(jdlFixDMLayout);
        jdlFixDMLayout.setHorizontalGroup(
            jdlFixDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdlFixDMLayout.setVerticalGroup(
            jdlFixDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 640));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        jToolBar1.setRollover(true);

        jbttnDuyetPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus.png"))); // NOI18N
        jbttnDuyetPN.setText("Duyệt");
        jbttnDuyetPN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnDuyetPN.setFocusable(false);
        jbttnDuyetPN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbttnDuyetPN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbttnDuyetPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnDuyetPNActionPerformed(evt);
            }
        });
        jToolBar1.add(jbttnDuyetPN);
        jToolBar1.add(jSeparator1);

        jbttnXoaPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/remove.png"))); // NOI18N
        jbttnXoaPN.setText("Xóa");
        jbttnXoaPN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnXoaPN.setFocusable(false);
        jbttnXoaPN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbttnXoaPN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbttnXoaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnXoaPNActionPerformed(evt);
            }
        });
        jToolBar1.add(jbttnXoaPN);
        jToolBar1.add(jSeparator2);

        jbttnSuaPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/fix.png"))); // NOI18N
        jbttnSuaPN.setText("Sửa");
        jbttnSuaPN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnSuaPN.setFocusable(false);
        jbttnSuaPN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbttnSuaPN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbttnSuaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnSuaPNActionPerformed(evt);
            }
        });
        jToolBar1.add(jbttnSuaPN);
        jToolBar1.add(jSeparator3);

        jbttnClastify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/category.png"))); // NOI18N
        jbttnClastify.setText("Danh Mục");
        jbttnClastify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnClastify.setFocusable(false);
        jbttnClastify.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbttnClastify.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbttnClastify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnClastifyActionPerformed(evt);
            }
        });
        jToolBar1.add(jbttnClastify);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Phiếu Nhập Hàng"));

        jtbPNH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Nhập", "Ngày Lập", "Thành Tiền", "Mã Nhân Viên", "Tình Trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Boolean.class
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
        jtbPNH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbPNHMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbPNHMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtbPNHMouseReleased(evt);
            }
        });
        jtbPNH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbPNHKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbPNHKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtbPNH);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Tiết Phiếu Nhập Hàng"));

        jtbCTPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hàng Hóa", "Mã CTHH", "Tên Hàng Hóa", "Ngày Sản Xuất", "Hạn Sử Dụng", "Nhà Cung Cấp", "Số Lượng", "Đơn Giá Nhập"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtbCTPN);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/search.png"))); // NOI18N

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
        jtfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfSearchKeyTyped(evt);
            }
        });

        jLabel9.setText("Lọc");

        jcbboxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Đã Duyệt", "Chưa Duyệt" }));
        jcbboxFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbboxFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfSearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jcbboxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcbboxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    public String atuoIncreasementMaLH() {
        int rowCount = jtbDanhMuc.getRowCount();
        int newSequence = rowCount + 1;
        return "LH" + String.format("%02d", newSequence);
    }
    public void loadAllPN() {
        modelTablePN.setRowCount(0);
        arrPN = pn.getAllPN();
        for (PhieuNhapDTO p : arrPN) {
            String maPN = p.getMaPN();
            Timestamp ngLap = p.getNgLapPhieu();
            String maNV = p.getMaNV();
            float thanhTien = p.getThanhTien();
            boolean tinhTrang = p.isTinhTrang();
            Object[] row = {maPN,ngLap,thanhTien,maNV,tinhTrang};
            modelTablePN.addRow(row);
        }
        jtbPNH.setModel(modelTablePN);
    }
    public void loadAllLH() {
        arrLH = lh.getALLLH();
        modelTableLH.setRowCount(0);
        for (LoaiHangDTO p : arrLH) {
            Object[] row = {p.getMaLH(),p.getTenLH(),p.isTinhTrang()};
            modelTableLH.addRow(row);
        }
        jtbDanhMuc.setModel(modelTableLH);
    }
    public void FilterPN() {
        modelTablePN.setRowCount(0);
        arrPN = pn.getAllPN();
        FilterStatus();
        FilterSearch();
        if(arrPN.size() !=0) {
            for (PhieuNhapDTO p : arrPN) {
                String maPN = p.getMaPN();
                Timestamp ngLap = p.getNgLapPhieu();
                String maNV = p.getMaNV();
                float thanhTien = p.getThanhTien();
                boolean tinhTrang = p.isTinhTrang();
                Object[] row = {maPN,ngLap,thanhTien,maNV,tinhTrang};
                modelTablePN.addRow(row);
            }
        }
        jtbPNH.setModel(modelTablePN);
    }
    public void FilterSearch(){
        String search = jtfSearch.getText();
        if(!search.trim().equalsIgnoreCase("")) {
            int i=0;
            while(i<arrPN.size()) {
                String str = "";
                if(!arrPN.get(i).getMaPN().toLowerCase().contains(search.toLowerCase()) && 
                        !arrPN.get(i).getMaNV().toLowerCase().contains(search.toLowerCase()))
                {
                    arrPN.remove(arrPN.get(i));
                } else {
                    i++;
                }
            }
        }
    }
    public void FilterSearchDM() {
        modelTableLH.setRowCount(0);
        arrLH = lh.getALLLH();
        String search = jtfSearchDM.getText();
        if(!search.trim().equalsIgnoreCase("")) {
            int i=0;
            while(i<arrLH.size()) {
                String str = "";
                if(!arrLH.get(i).getMaLH().toLowerCase().contains(search.toLowerCase()))
                {
                    arrLH.remove(arrLH.get(i));
                } else {
                    i++;
                }
            }
        }
        if(arrLH.size() !=0) {
            for (LoaiHangDTO p : arrLH) {
                Object[] row = {p.getMaLH(),p.getTenLH(),p.isTinhTrang()};
                modelTableLH.addRow(row);
            }
        }
        jtbDanhMuc.setModel(modelTableLH);
    }
    public void FilterStatus() {
        if(jcbboxFilter.getSelectedIndex() != 0) {
            int intdex = jcbboxFilter.getSelectedIndex();
            boolean trangThai = false;
            if(intdex == 1) {
                trangThai = true;
            }
            int i=0;
            while(i<arrPN.size()) {
                if(arrPN.get(i).isTinhTrang()!= trangThai)
                {
                    arrPN.remove(arrPN.get(i));
                } else {
                    i++;
                }
            }
        }
    }
    private void jbttnClastifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnClastifyActionPerformed
        loadAllLH();
        jtfSearchDM.setText("");
        jdlDM.setLocationRelativeTo(null);
        jdlDM.setVisible(true);
    }//GEN-LAST:event_jbttnClastifyActionPerformed

    private void jbttnSuaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnSuaPNActionPerformed
        if(jtbPNH.getSelectedRow()!=-1) {
            int row = jtbPNH.getSelectedRow();
//          Load thông tin phiếu nhập
            jtfMaPNFormFixPN.setText((String) jtbPNH.getValueAt(row, 0));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp timestamp = (Timestamp)jtbPNH.getValueAt(row, 1);
            String timestampStr = dateFormat.format(new Date(timestamp.getTime()));
            jtfNgLapFormFixPN.setText(timestampStr);
            float ThanhTien = (float) jtbPNH.getValueAt(row, 2);
            jtfThanhTienFormFixPN.setText(String.valueOf(ThanhTien));
            jtfMaNVFormFixPN.setText((String) jtbPNH.getValueAt(row, 3));
            jcbboxTinhTrangFormFixPN.setSelectedIndex(1);
//          Load bảng sản phẩm nhập
            modelTableSPN.setRowCount(0);
            for (int i=0;i<modelTableCTPN.getRowCount();i++) {
                Object [] rowSP = {modelTableCTPN.getValueAt(i, 0),modelTableCTPN.getValueAt(i, 2),
                modelTableCTPN.getValueAt(i, 3),modelTableCTPN.getValueAt(i, 4),modelTableCTPN.getValueAt(i, 5),
                modelTableCTPN.getValueAt(i, 6),modelTableCTPN.getValueAt(i, 7)};
                modelTableSPN.addRow(rowSP);
            }
            jtbSanPhamNhap.setModel(modelTableSPN);
//          Load bảng sản phẩm
            modelTableSP.setRowCount(0);
            ArrayList<HH_CTHH_DTO> arrHH = hh.getAllHHFormFixPN();
            for (int i=0;i<arrHH.size();i++) {
                Object [] rowHH = {arrHH.get(i).getMaHH(),arrHH.get(i).getTenHH(),arrHH.get(i).getSoLuong()};
                modelTableSP.addRow(rowHH);
            }
            jtbSanPham.setModel(modelTableSP);
            jdlFixPN.setLocationRelativeTo(null);
            jdlFixPN.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một phiếu nhập để sửa!");
        }
    }//GEN-LAST:event_jbttnSuaPNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jtbSanPhamNhap.getSelectedRow()!=-1) {
            jdlFixCTPN.setLocationRelativeTo(null);
            jdlFixCTPN.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm để sửa!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtbPNHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPNHMouseClicked
        if ((boolean)jtbPNH.getValueAt(jtbPNH.getSelectedRow(), jtbPNH.getColumnCount() - 1)) {
            jbttnDuyetPN.setEnabled(false);
            jbttnXoaPN.setEnabled(false);
            jbttnSuaPN.setEnabled(false);
        } else {
            jbttnDuyetPN.setEnabled(true);
            jbttnXoaPN.setEnabled(true);
            jbttnSuaPN.setEnabled(true);
        }
        modelTableCTPN.setRowCount(0);
        int row = jtbPNH.getSelectedRow();
        String maPN = (String)jtbPNH.getValueAt(row, 0);
        for (CTPN_CTHH_HH_DTO p : arrCTPN) {
            if (p.getMaPN().equalsIgnoreCase(maPN)) {
                Object[] rowCTPN = {p.getMaHH(),p.getMaCT_HH(),p.getTenHH(),p.getNgaySX(),p.getHSD(),p.getMaNCC(),p.getSLNhap(),p.getDonGiaNhap()};
                modelTableCTPN.addRow(rowCTPN);
            }
        }
        jtbCTPN.setModel(modelTableCTPN);
    }//GEN-LAST:event_jtbPNHMouseClicked

    private void jtbPNHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbPNHKeyReleased
        if ((boolean)jtbPNH.getValueAt(jtbPNH.getSelectedRow(), jtbPNH.getColumnCount() - 1)) {
            jbttnDuyetPN.setEnabled(false);
            jbttnXoaPN.setEnabled(false);
            jbttnSuaPN.setEnabled(false);
        } else {
            jbttnDuyetPN.setEnabled(true);
            jbttnXoaPN.setEnabled(true);
            jbttnSuaPN.setEnabled(true);
        }
    }//GEN-LAST:event_jtbPNHKeyReleased

    private void jtbPNHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbPNHKeyPressed
        if ((boolean)jtbPNH.getValueAt(jtbPNH.getSelectedRow(), jtbPNH.getColumnCount() - 1)) {
            jbttnDuyetPN.setEnabled(false);
            jbttnXoaPN.setEnabled(false);
            jbttnSuaPN.setEnabled(false);
        } else {
            jbttnDuyetPN.setEnabled(true);
            jbttnXoaPN.setEnabled(true);
            jbttnSuaPN.setEnabled(true);
        }
    }//GEN-LAST:event_jtbPNHKeyPressed

    private void jtbPNHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPNHMousePressed
        if ((boolean)jtbPNH.getValueAt(jtbPNH.getSelectedRow(), jtbPNH.getColumnCount() - 1)) {
            jbttnDuyetPN.setEnabled(false);
            jbttnXoaPN.setEnabled(false);
            jbttnSuaPN.setEnabled(false);
        } else {
            jbttnDuyetPN.setEnabled(true);
            jbttnXoaPN.setEnabled(true);
            jbttnSuaPN.setEnabled(true);
        }
    }//GEN-LAST:event_jtbPNHMousePressed

    private void jtbPNHMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPNHMouseReleased
        if ((boolean)jtbPNH.getValueAt(jtbPNH.getSelectedRow(), jtbPNH.getColumnCount() - 1)) {
            jbttnDuyetPN.setEnabled(false);
            jbttnXoaPN.setEnabled(false);
            jbttnSuaPN.setEnabled(false);
        } else {
            jbttnDuyetPN.setEnabled(true);
            jbttnXoaPN.setEnabled(true);
            jbttnSuaPN.setEnabled(true);
        }
    }//GEN-LAST:event_jtbPNHMouseReleased

    private void jbttnDuyetPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnDuyetPNActionPerformed
        if(jtbPNH.getSelectedRow()!=-1) {
            int row = jtbPNH.getSelectedRow();
            String MaPN = (String) jtbPNH.getValueAt(row, 0);
            boolean result = pn.DuyetPN(MaPN);
            if (result) {
                JOptionPane.showMessageDialog(null, "Duyệt thành công!");
                for (int i = 0;i < modelTablePN.getRowCount();i++) {
                    if(MaPN.equalsIgnoreCase((String)modelTablePN.getValueAt(i, 0))) {
                        modelTablePN.setValueAt(true, i, 4);
                        break;
                    }
                }
                jtbPNH.setModel(modelTablePN);
                jbttnDuyetPN.setEnabled(false);
                jbttnSuaPN.setEnabled(false);
                jbttnXoaPN.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Duyệt thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một phiếu nhập để duyệt!");
        }
    }//GEN-LAST:event_jbttnDuyetPNActionPerformed

    private void jbttnXoaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnXoaPNActionPerformed
        if(jtbPNH.getSelectedRow()!=-1) {
            int choose = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xóa?","Xóa Phiếu Nhập", JOptionPane.OK_CANCEL_OPTION);
            if (choose == JOptionPane.OK_OPTION) {
                int row = jtbPNH.getSelectedRow();
                String MaPN = (String) jtbPNH.getValueAt(row, 0);
                boolean result = pn.XoaPN(MaPN);
                if (result) {
                    JOptionPane.showMessageDialog(null, "Xóa Thành Công!");
                    for (int i = 0;i < modelTablePN.getRowCount();i++) {
                        if(MaPN.equalsIgnoreCase((String)modelTablePN.getValueAt(i, 0))) {
                            modelTablePN.removeRow(row);
                            break;
                        }
                    }
                    jtbPNH.setModel(modelTablePN);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                }
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một phiếu nhập để xóa!");
        }
    }//GEN-LAST:event_jbttnXoaPNActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(jtbSanPham.getSelectedRow()!=-1) {
            jdlAddCTPN.setLocationRelativeTo(null);
            jdlAddCTPN.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm để thêm!");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(jtbSanPhamNhap.getSelectedRow()!=-1) {
            JOptionPane.showMessageDialog(null, "Xóa Thành Công!");
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm để xóa!");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jbtnOpenFormAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOpenFormAddActionPerformed
        jtfMaLHFormAddDM.setText(atuoIncreasementMaLH());
        jtfTenLHFormAddDM.setText("");
        jdlAddDM.setLocationRelativeTo(null);
        jdlAddDM.setVisible(true);
    }//GEN-LAST:event_jbtnOpenFormAddActionPerformed

    private void jbtnOpenFormFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOpenFormFixActionPerformed
        if(jtbDanhMuc.getSelectedRow()!=-1) {
//          Load dữ liệu lên form sửa loại hàng
            int row = jtbDanhMuc.getSelectedRow();
            String MaLH = (String) jtbDanhMuc.getValueAt(row, 0);
            String TenLH = (String) jtbDanhMuc.getValueAt(row, 1);
            boolean TinhTrang = (boolean) jtbDanhMuc.getValueAt(row, 2);
            jtfMaLHFormFixDM.setText(MaLH);
            jtfTenLHFormFixDM.setText(TenLH);
            if (TinhTrang) jcbboxTTFormFIxDM.setSelectedIndex(0);
            else jcbboxTTFormFIxDM.setSelectedIndex(1);
//          ------------------------------------
            jdlFixDM.setLocationRelativeTo(null);
            jdlFixDM.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một loại hàng để sửa!");
        }
    }//GEN-LAST:event_jbtnOpenFormFixActionPerformed

    private void jcbboxFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbboxFilterActionPerformed
        FilterPN();
    }//GEN-LAST:event_jcbboxFilterActionPerformed

    private void jtfSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSearchKeyPressed
        
    }//GEN-LAST:event_jtfSearchKeyPressed

    private void jtfSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSearchKeyTyped
        
    }//GEN-LAST:event_jtfSearchKeyTyped

    private void jtfSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtfSearchInputMethodTextChanged
        
    }//GEN-LAST:event_jtfSearchInputMethodTextChanged

    private void jtfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSearchKeyReleased
        FilterPN();
    }//GEN-LAST:event_jtfSearchKeyReleased

    private void jtfSearchDMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSearchDMKeyReleased
        FilterSearchDM();
    }//GEN-LAST:event_jtfSearchDMKeyReleased
    public boolean validateTenLH(String name) {
        String regex = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return name.length() <= 30 && matcher.matches();
    }
    
    private void jbttnAddFormAdđMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnAddFormAdđMActionPerformed
        String MaLH = jtfMaLHFormAddDM.getText();
        String TenLH = jtfTenLHFormAddDM.getText();
        if (validateTenLH(TenLH)) {
            boolean result = lh.addLH(MaLH,TenLH);
            if (result) {
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
                Object[] row = {MaLH,TenLH,true};
                modelTableLH.addRow(row);
                jtbDanhMuc.setModel(modelTableLH);
                jdlAddDM.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập vào đúng định dạng!");
        }
        
                
    }//GEN-LAST:event_jbttnAddFormAdđMActionPerformed

    private void jbttnFixFormFixDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnFixFormFixDMActionPerformed
        String MaLH = jtfMaLHFormFixDM.getText();
        String TenLH = jtfTenLHFormFixDM.getText();
        boolean TinhTrang = false;
        if (jcbboxTTFormFIxDM.getSelectedIndex() == 0) TinhTrang = true;
        if (validateTenLH(TenLH)) {
            boolean result = lh.fixLH(MaLH,TenLH,TinhTrang);
            if (result) {
                JOptionPane.showMessageDialog(null, "Sửa thành công!");
                for (int row = 0;row < modelTableLH.getRowCount();row++) {
                    if(MaLH.equalsIgnoreCase((String)modelTableLH.getValueAt(row, 0))) {
                        modelTableLH.setValueAt(TenLH, row, 1);
                        modelTableLH.setValueAt(TinhTrang, row, 2);
                        break;
                    }
                }
                jtbDanhMuc.setModel(modelTableLH);
                jdlFixDM.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Sửa thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập vào đúng định dạng!");
        }
    }//GEN-LAST:event_jbttnFixFormFixDMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton jbtnOpenFormAdd;
    private javax.swing.JButton jbtnOpenFormFix;
    private javax.swing.JButton jbttnAddFormAdđM;
    private javax.swing.JButton jbttnClastify;
    private javax.swing.JButton jbttnDuyetPN;
    private javax.swing.JButton jbttnFixFormFixDM;
    private javax.swing.JButton jbttnSuaPN;
    private javax.swing.JButton jbttnXoaPN;
    private javax.swing.JComboBox<String> jcbboxFilter;
    private javax.swing.JComboBox<String> jcbboxTTFormFIxDM;
    private javax.swing.JComboBox<String> jcbboxTinhTrangFormFixPN;
    private javax.swing.JDialog jdlAddCTPN;
    private javax.swing.JDialog jdlAddDM;
    private javax.swing.JDialog jdlDM;
    private javax.swing.JDialog jdlFixCTPN;
    private javax.swing.JDialog jdlFixDM;
    private javax.swing.JDialog jdlFixPN;
    private javax.swing.JTable jtbCTPN;
    private javax.swing.JTable jtbDanhMuc;
    private javax.swing.JTable jtbPNH;
    private javax.swing.JTable jtbSanPham;
    private javax.swing.JTable jtbSanPhamNhap;
    private javax.swing.JTextField jtfMaLHFormAddDM;
    private javax.swing.JTextField jtfMaLHFormFixDM;
    private javax.swing.JTextField jtfMaNVFormFixPN;
    private javax.swing.JTextField jtfMaPNFormFixPN;
    private javax.swing.JTextField jtfNgLapFormFixPN;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfSearchDM;
    private javax.swing.JTextField jtfTenLHFormAddDM;
    private javax.swing.JTextField jtfTenLHFormFixDM;
    private javax.swing.JTextField jtfThanhTienFormFixPN;
    // End of variables declaration//GEN-END:variables
}
