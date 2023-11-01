package com.myproject.GUI.NhanVienKho.InventoryPages;

import com.myproject.BUS.CT_PhieuNhapBUS;
import com.myproject.BUS.PhieuNhapBUS;
import com.myproject.DTO.CT_PhieuNhapDTO;
import com.myproject.DTO.ClassListPhieuNhap;
import com.myproject.DTO.ClassList_CTPhieuNhap;
import com.myproject.DTO.PhieuNhapDTO;
import com.myproject.GUI.NhanVienKho.Sort.Sorting_Class_PhieuNhapPage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Preview_Inventory extends javax.swing.JPanel implements ActionListener {

    //Khai bao BUS
    private PhieuNhapBUS phieuNhapBUS;
    private CT_PhieuNhapBUS CTPNhap_BUS;

    //Khai bao classList
    private ClassListPhieuNhap classListPhieuNhap;
    private ClassList_CTPhieuNhap classList_CT_PhieuNhap;

    //Khai bao table
    private DefaultTableModel tableModel_PhieuNhap;
    private int select_PhieuNhap;
    private DefaultTableModel tableModel_CT_PhieuNhap;
    private int CT_PhieuNhap;

    //ListSort
    private Sorting_Class_PhieuNhapPage sorting_class;
    private ArrayList<PhieuNhapDTO> phieuNhap_listSort;
    private ArrayList<CT_PhieuNhapDTO> CT_phieuNhap_listSort;


    private String maNV;
    public Preview_Inventory(String maNV) {
        initComponents();
        this.maNV = maNV;
        initArea();
        loadDataFromSql();
        loadDataToTable();
        addActionListener();
        handle_render_CTPN_row();
        JTextField dateTextField = (JTextField) ngayYeuCau_DateChooser.getDateEditor().getUiComponent();
        dateTextField.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGr_Finding = new javax.swing.ButtonGroup();
        btnGr_sort = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_CTPN = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        refreshBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        maSP_RB = new javax.swing.JRadioButton();
        ngayYeuCau_RB = new javax.swing.JRadioButton();
        ma_NCC_RB = new javax.swing.JRadioButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        maSP_txt = new javax.swing.JTextField();
        ngayYeuCau_DateChooser = new com.toedter.calendar.JDateChooser();
        maNCC_txt = new javax.swing.JTextField();
        search_PN_btn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        sortFarDate = new javax.swing.JRadioButton();
        jLabel48 = new javax.swing.JLabel();
        sortRecentDate = new javax.swing.JRadioButton();
        jLabel49 = new javax.swing.JLabel();
        checkBill_RB = new javax.swing.JRadioButton();
        jLabel50 = new javax.swing.JLabel();
        unCheckBill_RB = new javax.swing.JRadioButton();
        jLabel51 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_PN = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 169, 244)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(621, 621));

        table_CTPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hàng Hóa", "Tên Hàng Hóa", "Ngày Sản Xuất", "Hạn Sử Dụng", "Nhà Cung Cấp", "Số Lượng", "Đơn Giá Nhập"
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
        table_CTPN.setGridColor(new java.awt.Color(3, 169, 244));
        jScrollPane1.setViewportView(table_CTPN);

        jLabel1.setBackground(new java.awt.Color(3, 169, 244));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cubes.png"))); // NOI18N
        jLabel1.setText("DANH SÁCH CÁC YÊU CẦU NHẬP HÀNG");
        jLabel1.setOpaque(true);

        jPanel30.setBackground(new java.awt.Color(3, 169, 244));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        refreshBtn.setBackground(new java.awt.Color(0, 153, 51));
        refreshBtn.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        refreshBtn.setForeground(new java.awt.Color(255, 255, 255));
        refreshBtn.setText("Làm Mới");
        refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(3, 169, 244));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        btnGr_Finding.add(maSP_RB);
        maSP_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maSP_RBActionPerformed(evt);
            }
        });

        btnGr_Finding.add(ngayYeuCau_RB);
        ngayYeuCau_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngayYeuCau_RBActionPerformed(evt);
            }
        });

        btnGr_Finding.add(ma_NCC_RB);
        ma_NCC_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ma_NCC_RBActionPerformed(evt);
            }
        });

        jLabel47.setBackground(new java.awt.Color(3, 169, 244));
        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Mã Nhà Cung Cấp");
        jLabel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel47.setOpaque(true);

        jLabel46.setBackground(new java.awt.Color(3, 169, 244));
        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Theo Ngày Yêu Cầu");
        jLabel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel46.setOpaque(true);

        jLabel43.setBackground(new java.awt.Color(3, 169, 244));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Theo Mã Sản Phẩm");
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel43.setOpaque(true);

        ngayYeuCau_DateChooser.setDateFormatString("yyyy-MM-dd");

        maNCC_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maNCC_txtActionPerformed(evt);
            }
        });

        search_PN_btn.setBackground(new java.awt.Color(0, 153, 51));
        search_PN_btn.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        search_PN_btn.setForeground(new java.awt.Color(255, 255, 255));
        search_PN_btn.setText("Tìm Kiếm");
        search_PN_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search_PN_btn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(maSP_RB)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(ma_NCC_RB)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(maSP_txt)
                                .addComponent(maNCC_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(ngayYeuCau_RB)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ngayYeuCau_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(search_PN_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maSP_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(maSP_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(ngayYeuCau_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ngayYeuCau_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(ma_NCC_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maNCC_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(search_PN_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(3, 169, 244));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc"));

        sortFarDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortFarDateActionPerformed(evt);
            }
        });

        jLabel48.setBackground(new java.awt.Color(3, 169, 244));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Theo Ngày Yêu Cầu Xa Nhất");
        jLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel48.setOpaque(true);

        sortRecentDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortRecentDateActionPerformed(evt);
            }
        });

        jLabel49.setBackground(new java.awt.Color(3, 169, 244));
        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Theo Ngày Yêu Cầu Gần Nhất");
        jLabel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel49.setOpaque(true);

        checkBill_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBill_RBActionPerformed(evt);
            }
        });

        jLabel50.setBackground(new java.awt.Color(3, 169, 244));
        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Các Đơn Đã Được Duyệt");
        jLabel50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel50.setOpaque(true);

        unCheckBill_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unCheckBill_RBActionPerformed(evt);
            }
        });

        jLabel51.setBackground(new java.awt.Color(3, 169, 244));
        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Các Đơn Chưa Được Duyệt");
        jLabel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel51.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(checkBill_RB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(unCheckBill_RB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(sortRecentDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(sortFarDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(sortFarDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(sortRecentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(checkBill_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(unCheckBill_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshBtn)
                .addContainerGap())
        );

        jLabel2.setBackground(new java.awt.Color(3, 169, 244));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cubes.png"))); // NOI18N
        jLabel2.setText("CHI TIẾT CÁC YÊU CẦU NHẬP HÀNG");
        jLabel2.setOpaque(true);

        table_PN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Nhập", "Ngày Lập", "Thành Tiền", "Tình Trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_PN.setGridColor(new java.awt.Color(3, 169, 244));
        jScrollPane2.setViewportView(table_PN);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void unCheckBill_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unCheckBill_RBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unCheckBill_RBActionPerformed

    private void checkBill_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBill_RBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBill_RBActionPerformed

    private void sortRecentDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortRecentDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortRecentDateActionPerformed

    private void sortFarDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortFarDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortFarDateActionPerformed

    private void maNCC_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maNCC_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maNCC_txtActionPerformed

    private void ma_NCC_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ma_NCC_RBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ma_NCC_RBActionPerformed

    private void ngayYeuCau_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngayYeuCau_RBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngayYeuCau_RBActionPerformed

    private void maSP_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maSP_RBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maSP_RBActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGr_Finding;
    private javax.swing.ButtonGroup btnGr_sort;
    private javax.swing.JRadioButton checkBill_RB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField maNCC_txt;
    private javax.swing.JRadioButton maSP_RB;
    private javax.swing.JTextField maSP_txt;
    private javax.swing.JRadioButton ma_NCC_RB;
    private com.toedter.calendar.JDateChooser ngayYeuCau_DateChooser;
    private javax.swing.JRadioButton ngayYeuCau_RB;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton search_PN_btn;
    private javax.swing.JRadioButton sortFarDate;
    private javax.swing.JRadioButton sortRecentDate;
    private javax.swing.JTable table_CTPN;
    private javax.swing.JTable table_PN;
    private javax.swing.JRadioButton unCheckBill_RB;
    // End of variables declaration//GEN-END:variables

    private void loadDataFromSql() {
        read_PhieuNhapSQL();
        read_CT_PhieuNhapSQL();
    }

    private void initArea() {
        this.classListPhieuNhap = new ClassListPhieuNhap();
        this.classList_CT_PhieuNhap = new ClassList_CTPhieuNhap();

        this.phieuNhapBUS = new PhieuNhapBUS();
        this.CTPNhap_BUS = new CT_PhieuNhapBUS();

        tableModel_PhieuNhap = (DefaultTableModel) table_PN.getModel();
        tableModel_CT_PhieuNhap = (DefaultTableModel) table_CTPN.getModel();

        this.btnGr_Finding.add(maSP_RB);
        this.btnGr_Finding.add(ngayYeuCau_RB);
        this.btnGr_Finding.add(ma_NCC_RB);

        this.btnGr_sort.add(sortFarDate);
        this.btnGr_sort.add(sortRecentDate);
        this.btnGr_sort.add(checkBill_RB);
        this.btnGr_sort.add(unCheckBill_RB);

        this.sorting_class = new Sorting_Class_PhieuNhapPage();
    }

    private void read_PhieuNhapSQL() {
        ArrayList<PhieuNhapDTO> data_phieuNhaps = phieuNhapBUS.getPNTheoMaNV(maNV);
        this.classListPhieuNhap.setListPhieuNhap(data_phieuNhaps);
    }

    private void loadDataToTable() {
        this.phieuNhap_listSort = this.classListPhieuNhap.getListPhieuNhap();
        load_PN_table(this.phieuNhap_listSort);
    }

    private void load_PN_table(ArrayList<PhieuNhapDTO> array) {
        tableModel_PhieuNhap.setRowCount(0);
        for (PhieuNhapDTO phieuNhapDTO : array) {
            addRowPN_table(phieuNhapDTO);
        }
        table_PN.setModel(tableModel_PhieuNhap);
    }

    private void addRowPN_table(PhieuNhapDTO phieuNhapDTO) {
        Object[] row = new Object[]{
            phieuNhapDTO.getMaPN(), phieuNhapDTO.getNgLapPhieu(),
            phieuNhapDTO.getThanhTien(), phieuNhapDTO.isTinhTrang()
        };
        tableModel_PhieuNhap.addRow(row);
    }

    private void load_CTPN_table(ArrayList<CT_PhieuNhapDTO> list_PN_render) {
        tableModel_CT_PhieuNhap.setRowCount(0);
        for (CT_PhieuNhapDTO CT_phieuNhapDTO : list_PN_render) {
            addRow_CTPN_table(CT_phieuNhapDTO);
        }
    }

    private void addRow_CTPN_table(CT_PhieuNhapDTO CT_phieuNhapDTO) {
        Object[] row = new Object[]{
            CT_phieuNhapDTO.getCT_hangHoa().getHangHoaDTO().getMaHH(), CT_phieuNhapDTO.getCT_hangHoa().getHangHoaDTO().getTenHH(), CT_phieuNhapDTO.getCT_hangHoa().getNgaySX(),
            CT_phieuNhapDTO.getCT_hangHoa().getHSD(), CT_phieuNhapDTO.getNCC().getTenNCC(), CT_phieuNhapDTO.getSLNhap(), CT_phieuNhapDTO.getDonGiaNhap()
        };
        tableModel_CT_PhieuNhap.addRow(row);
    }

    private void read_CT_PhieuNhapSQL() {
        ArrayList<CT_PhieuNhapDTO> data_CTPNs = this.CTPNhap_BUS.getAll_CTPhieuNhap();
        this.classList_CT_PhieuNhap.setList_CT_PhieuNhap(data_CTPNs);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(search_PN_btn)) {
            this.searchFromOption();
        } else if (src.equals(sortFarDate)) {
            sorting_class.sort_far_ngayNhapPhieu(phieuNhap_listSort);
            load_PN_table(phieuNhap_listSort);
            this.clearCTPN_table();
        } else if (src.equals(sortRecentDate)) {
            sorting_class.sort_recent_ngayNhapPhieu(phieuNhap_listSort);
            load_PN_table(phieuNhap_listSort);
            this.clearCTPN_table();
        } else if (src.equals(checkBill_RB)) {
            this.phieuNhap_listSort = this.phieuNhapBUS.find_PhieuNhap_By_tinhTrang("1",this.maNV);
            load_PN_table(phieuNhap_listSort);
            this.clearCTPN_table();
        } else if (src.equals(unCheckBill_RB)) {
            this.phieuNhap_listSort = this.phieuNhapBUS.find_PhieuNhap_By_tinhTrang("0",this.maNV);
            load_PN_table(phieuNhap_listSort);
            this.clearCTPN_table();
        } else if (src.equals(refreshBtn)) {
            this.btnGr_Finding.clearSelection();
            this.btnGr_sort.clearSelection();
            this.clearCTPN_table();
            clearInputTxt();
            this.phieuNhap_listSort = this.phieuNhapBUS.getPNTheoMaNV(maNV);
            load_PN_table(phieuNhap_listSort);
        } else if (src.equals(this.maSP_RB)) {
            this.maSP_txt.setEnabled(true);
            this.ngayYeuCau_DateChooser.setEnabled(false);
            this.maNCC_txt.setEnabled(false);
        } else if (src.equals(this.ma_NCC_RB)) {
            this.maSP_txt.setEnabled(false);
            this.ngayYeuCau_DateChooser.setEnabled(false);
            this.maNCC_txt.setEnabled(true);
        } else if (src.equals(this.ngayYeuCau_RB)) {
            this.maSP_txt.setEnabled(false);
            this.ngayYeuCau_DateChooser.setEnabled(true);
            this.maNCC_txt.setEnabled(false);
        }
    }

    private void searchFromOption() {
        if (maSP_RB.isSelected()) {
            String input_maSP = maSP_txt.getText().trim();
            if (!input_maSP.isEmpty()) {
                this.phieuNhap_listSort = this.phieuNhapBUS.find_PhieuNhap_By_MaSP(input_maSP,this.maNV);
                this.load_PN_table(phieuNhap_listSort);
                this.maSP_txt.setText("");
                if (this.phieuNhap_listSort.size() > 0) {
                    this.btnGr_sort.clearSelection();
                    JOptionPane.showMessageDialog(this, "LỌC THÀNH CÔNG!");
                    clearCTPN_table();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Không tìm thấy dữ liệu!");
                    clearCTPN_table();
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "VUI LÒNG NHẬP TÊN CẦN TÌM KIẾM!");
            }
        } else if (ngayYeuCau_RB.isSelected()) {
            JTextField dateTextField = (JTextField) ngayYeuCau_DateChooser.getDateEditor().getUiComponent();
            String input_ngayYC = dateTextField.getText();
            if (!input_ngayYC.isEmpty()) {
                this.phieuNhap_listSort = this.phieuNhapBUS.find_PhieuNhap_By_ngayYC(input_ngayYC,this.maNV);
                if (this.phieuNhap_listSort.size() > 0) {
                    this.load_PN_table(phieuNhap_listSort);
                    dateTextField.setText("");
                    if (this.phieuNhap_listSort.size() > 0) {
                        this.btnGr_sort.clearSelection();
                        JOptionPane.showMessageDialog(this, "LỌC THÀNH CÔNG!");
                        clearCTPN_table();
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Không tìm thấy dữ liệu!");
                        clearCTPN_table();
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Không tìm thấy dữ liệu!");
                    clearCTPN_table();
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "VUI LÒNG NHẬP TÊN CẦN TÌM KIẾM!");
            }
        } else if (ma_NCC_RB.isSelected()) {
            String input_maNCC = maNCC_txt.getText().trim();
            if (!input_maNCC.isEmpty()) {
                this.phieuNhap_listSort = this.phieuNhapBUS.find_PhieuNhap_By_maNCC(input_maNCC,this.maNV);
                this.load_PN_table(phieuNhap_listSort);
                this.maNCC_txt.setText("");
                if (this.phieuNhap_listSort.size() > 0) {
                    this.btnGr_sort.clearSelection();
                    JOptionPane.showMessageDialog(this, "LỌC THÀNH CÔNG!");
                    clearCTPN_table();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Không tìm thấy dữ liệu!");
                    clearCTPN_table();
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "VUI LÒNG NHẬP TÊN CẦN TÌM KIẾM!");
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "VUI LÒNG CHỌN VÙNG MUỐN TÌM KIẾM!");
        }
    }

    private void addActionListener() {
        this.search_PN_btn.addActionListener(this);
        this.sortFarDate.addActionListener(this);
        this.sortRecentDate.addActionListener(this);
        this.checkBill_RB.addActionListener(this);
        this.unCheckBill_RB.addActionListener(this);
        this.refreshBtn.addActionListener(this);
        this.maSP_RB.addActionListener(this);
        this.ma_NCC_RB.addActionListener(this);
        this.ngayYeuCau_RB.addActionListener(this);
    }

    private void handle_render_CTPN_row() {
        table_PN.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (table_PN.getSelectedRow() >= 0) {
                    String maPN_rowSelected = table_PN.getValueAt(table_PN.getSelectedRow(), 0).toString();
                    CT_phieuNhap_listSort = CTPNhap_BUS.find_CTPN_row(maPN_rowSelected);
                    load_CTPN_table(CT_phieuNhap_listSort);
                }
            }
        });
    }
    
    private void clearCTPN_table() {
        this.CT_phieuNhap_listSort = new ArrayList<>();
        this.load_CTPN_table(CT_phieuNhap_listSort);
    }

    private void clearInputTxt() {
        this.maSP_txt.setText("");
        JTextField dateTextField = (JTextField) ngayYeuCau_DateChooser.getDateEditor().getUiComponent();
        dateTextField.setText("");
        this.maNCC_txt.setText("");
    }
}
