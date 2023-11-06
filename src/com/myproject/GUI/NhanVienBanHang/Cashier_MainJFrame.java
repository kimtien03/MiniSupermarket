package com.myproject.GUI.NhanVienBanHang;

import com.formdev.flatlaf.FlatLightLaf;
import com.myproject.BUS.CTHD_BanHangBUS;
import com.myproject.BUS.CT_HangHoaBUS;
import com.myproject.BUS.HangHoaBUS;
import com.myproject.BUS.HoaDonBanHangBUS;
import com.myproject.BUS.KhachHangBUS;
import com.myproject.BUS.KhuyenMaiBUS;
import com.myproject.DTO.CTHD_BanHangDTO;
import com.myproject.DTO.CT_HangHoaDTO;
import com.myproject.DTO.HangHoaDTO;
import com.myproject.DTO.KhachHangDTO;
import com.myproject.DTO.KhuyenMaiDTO;
import com.myproject.GUI.Login.Login_JFrame;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Cashier_MainJFrame extends javax.swing.JFrame {
    private String MaNV;
    private String TenNV;
    private HangHoaBUS hangHoaBUS = new HangHoaBUS();
    private CT_HangHoaBUS cT_HangHoaBUS = new CT_HangHoaBUS();
    private KhuyenMaiBUS khuyenMaiBUS = new KhuyenMaiBUS();
    private KhachHangBUS khachHangBUS = new KhachHangBUS();
    private HoaDonBanHangBUS hoaDonBanHangBUS = new HoaDonBanHangBUS();
    private CTHD_BanHangBUS cTHD_BanHangBUS = new CTHD_BanHangBUS();
    private KhachHangDTO customer = null;
    private HangHoaDTO product = null;
    private ArrayList<CTHD_BanHangDTO> billDetailsList = new ArrayList<CTHD_BanHangDTO>();
    private ArrayList<HangHoaDTO> productsList = new ArrayList<HangHoaDTO>();
    private ArrayList<Integer> quantityOfProductList = new ArrayList<Integer>();
    private float quantityOfProduct;
    private float total = 0;
    private float totalAfterUsePoint;
    private boolean isApplyingLoyaltyPoints = false;
    private String idBill;
    // liên quan đến bảng
    private DefaultTableModel tableModelProduct;
    private int selectedRowProductTable;

    public Cashier_MainJFrame(String MaNV, String TenNV) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        initComponents();
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cashier_MainJFrame.class.
                    getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.setLocationRelativeTo(null);
        this.staffName_JTF.setText(TenNV);
        setTimeNow();
        createIdBill();
        tableInitialization();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        quantity_JTF = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        quantity_JBTN = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cashierTitle = new javax.swing.JLabel();
        staffName_JTF = new javax.swing.JLabel();
        currnetly_JLB = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        productID_JTF = new javax.swing.JTextField();
        phoneNumOfCus_JTF = new javax.swing.JTextField();
        namOfCus_JTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        total_JTF = new javax.swing.JTextField();
        accumulatedPoints_JTF = new javax.swing.JTextField();
        addProduct_JBTN = new javax.swing.JButton();
        findCusJBTN = new javax.swing.JButton();
        idBill_JTF = new javax.swing.JTextField();
        findCusJBTN1 = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        product_JTB = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        addCusJBTN = new javax.swing.JButton();
        closeJBTN = new javax.swing.JButton();
        deleteProduct_JBTN = new javax.swing.JButton();
        paymentJBTN = new javax.swing.JButton();
        returnGoodJBTN1 = new javax.swing.JButton();

        jDialog1.setMinimumSize(new java.awt.Dimension(400, 160));
        jDialog1.setModal(true);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Số lượng sản phẩm"));

        quantity_JTF.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton2.setText("Thoát");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitPageQuantity(evt);
            }
        });

        quantity_JBTN.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        quantity_JBTN.setText("Thêm");
        quantity_JBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quantity_JBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterQuantityOfProduct(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quantity_JTF)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(quantity_JBTN)
                .addGap(50, 50, 50))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quantity_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantity_JBTN)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(3, 169, 244));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel2.setBackground(new java.awt.Color(3, 169, 244));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 42));

        cashierTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        cashierTitle.setForeground(new java.awt.Color(255, 255, 255));
        cashierTitle.setText("Nhân viên:");

        staffName_JTF.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        staffName_JTF.setForeground(new java.awt.Color(255, 255, 255));
        staffName_JTF.setText("Nguyễn Vũ Tiến Đạt");
        staffName_JTF.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        staffName_JTF.setPreferredSize(new java.awt.Dimension(250, 27));

        currnetly_JLB.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        currnetly_JLB.setForeground(new java.awt.Color(255, 255, 255));
        currnetly_JLB.setText("Ngày: 25/09/2023");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quầy: 1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(54, 54, 54)
                .addComponent(cashierTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(staffName_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(currnetly_JLB)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cashierTitle)
                    .addComponent(staffName_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currnetly_JLB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(3, 169, 244));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(1200, 652));

        jPanel6.setBackground(new java.awt.Color(3, 169, 244));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã sản phẩm");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Khách hàng");

        productID_JTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productID_JTF.setBorder(null);
        productID_JTF.setPreferredSize(new java.awt.Dimension(340, 31));

        phoneNumOfCus_JTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phoneNumOfCus_JTF.setBorder(null);
        phoneNumOfCus_JTF.setPreferredSize(new java.awt.Dimension(100, 31));

        namOfCus_JTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        namOfCus_JTF.setBorder(null);
        namOfCus_JTF.setPreferredSize(new java.awt.Dimension(194, 31));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tổng hóa đơn");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Điểm tích lũy");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Hóa đơn");

        total_JTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        total_JTF.setBorder(null);
        total_JTF.setEnabled(false);
        total_JTF.setPreferredSize(new java.awt.Dimension(340, 31));

        accumulatedPoints_JTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        accumulatedPoints_JTF.setBorder(null);
        accumulatedPoints_JTF.setEnabled(false);
        accumulatedPoints_JTF.setPreferredSize(new java.awt.Dimension(340, 31));

        addProduct_JBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addProduct_JBTN.setText("Thêm SP");
        addProduct_JBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProduct_JBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addProduct_JBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProduct(evt);
            }
        });

        findCusJBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        findCusJBTN.setText("Tìm kiếm");
        findCusJBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        findCusJBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        findCusJBTN.setPreferredSize(new java.awt.Dimension(32, 32));
        findCusJBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findCustomer(evt);
            }
        });

        idBill_JTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        idBill_JTF.setBorder(null);
        idBill_JTF.setEnabled(false);
        idBill_JTF.setPreferredSize(new java.awt.Dimension(340, 31));

        findCusJBTN1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        findCusJBTN1.setText("Áp dụng điểm tích lũy");
        findCusJBTN1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        findCusJBTN1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        findCusJBTN1.setPreferredSize(new java.awt.Dimension(32, 32));
        findCusJBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyingLoyaltyPoints(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancel.setText("Hủy");
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancel.setPreferredSize(new java.awt.Dimension(32, 32));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApplyingLoyaltyPoints(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(phoneNumOfCus_JTF, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namOfCus_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(productID_JTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idBill_JTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(findCusJBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addProduct_JBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addGap(75, 75, 75)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(findCusJBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(total_JTF, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                            .addComponent(accumulatedPoints_JTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(productID_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(total_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProduct_JBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(findCusJBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(phoneNumOfCus_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(namOfCus_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(accumulatedPoints_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(idBill_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findCusJBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(3, 169, 244));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(3, 169, 244));

        product_JTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên hàng hóa", "ĐVT", "Số lượng", "Giá bán", "KM(%)", "Tiền KM", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(product_JTB);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(3, 169, 244));

        addCusJBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addCusJBTN.setText("Thêm KH");
        addCusJBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCusJBTN.setPreferredSize(new java.awt.Dimension(100, 70));
        addCusJBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomer(evt);
            }
        });

        closeJBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        closeJBTN.setText("Thoát");
        closeJBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeJBTN.setPreferredSize(new java.awt.Dimension(100, 70));
        closeJBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closePage(evt);
            }
        });

        deleteProduct_JBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteProduct_JBTN.setText("Xóa H.H");
        deleteProduct_JBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteProduct_JBTN.setPreferredSize(new java.awt.Dimension(100, 70));
        deleteProduct_JBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProduct(evt);
            }
        });

        paymentJBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paymentJBTN.setText("Thanh toán");
        paymentJBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paymentJBTN.setPreferredSize(new java.awt.Dimension(100, 70));
        paymentJBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment(evt);
            }
        });

        returnGoodJBTN1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        returnGoodJBTN1.setText("Làm mới");
        returnGoodJBTN1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnGoodJBTN1.setPreferredSize(new java.awt.Dimension(100, 70));
        returnGoodJBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refeshPage(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCusJBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(returnGoodJBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paymentJBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteProduct_JBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeJBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCusJBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeJBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteProduct_JBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentJBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnGoodJBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1201, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1201, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1201, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closePage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closePage
        int choose = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất?","Đăng xuất",JOptionPane.OK_CANCEL_OPTION);
        if (choose == JOptionPane.OK_OPTION) {
            this.dispose();
            new Login_JFrame().setVisible(true);
        }
    }//GEN-LAST:event_closePage

    private void deleteProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProduct
        int selectedRow = this.product_JTB.getSelectedRow();
        if(selectedRow != -1) {
            int selection = JOptionPane.showConfirmDialog(null, 
                    "BẠN CÓ CHẮC MUỐN XÓA KHÔNG?", "XOÁ HÀNG HÓA", 
                    JOptionPane.OK_CANCEL_OPTION);
            if(selection == JOptionPane.OK_OPTION) {
                this.total -= (float) this.tableModelProduct.getValueAt(selectedRow, 8);
                this.total_JTF.setText(this.total + "");
                HangHoaDTO tmp = hangHoaBUS.getProductByID((String) 
                        this.tableModelProduct.getValueAt(selectedRow, 1));
                this.productsList.remove(selectedRow);
                this.tableModelProduct.removeRow(selectedRow);
                // xét lại số thứ tự cho các sản phẩm
                for (int i=0; i<this.tableModelProduct.getRowCount(); i++) {
                    this.tableModelProduct.setValueAt(i + 1, i, 0);
                }
                this.product = null;
            } 
        } else {
            JOptionPane.showMessageDialog(null, "VUI LÒNG "
                    + "CHỌN SẢN PHẨM MUỐN XÓA!");
        }
    }//GEN-LAST:event_deleteProduct

    private void payment(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment
        if(!this.total_JTF.getText().isEmpty()) {
            String tmp = this.total_JTF.getText();
            float total = Float.parseFloat(tmp);
            if(this.customer == null) {
                getAllBillDetails();
                KhachHangDTO transientGuests = khachHangBUS.getTransientGuests();
                Payment_JDialog payment_JDialog = new Payment_JDialog(this, 
                        rootPaneCheckingEnabled, transientGuests, total, this.idBill, 
                        this.productsList, this.billDetailsList, MaNV);
                payment_JDialog.setLocationRelativeTo(null);
                payment_JDialog.setVisible(true);
                return;
            } else {
                getAllBillDetails();
                Payment_JDialog payment_JDialog = new Payment_JDialog(this, 
                        rootPaneCheckingEnabled, this.customer, total, this.idBill, 
                        this.productsList, this.billDetailsList, MaNV);
                payment_JDialog.setLocationRelativeTo(null);
                payment_JDialog.setVisible(true);
                return;
            }  
        } else {
            JOptionPane.showMessageDialog(null, "VUI LÒNG CHỌN "
                    + "SẢN PHẨM ĐỂ THANH TOÁN!");
        }
    }//GEN-LAST:event_payment

    private void addCustomer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomer
        Cus_Info_JDialog cus_Info_JDialog = new Cus_Info_JDialog(this, 
                rootPaneCheckingEnabled);
        cus_Info_JDialog.setLocationRelativeTo(null);
        cus_Info_JDialog.setVisible(true);
    }//GEN-LAST:event_addCustomer

    private void addProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProduct
        String productID = this.productID_JTF.getText().toUpperCase();
        if(!productID.isEmpty()) {
            product = hangHoaBUS.getProductByID(productID);
            if(product != null) {
                jDialog1.setLocationRelativeTo(null);
                jDialog1.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "MÃ SẢN "
                        + "PHẨM SAI HOẶC KHÔNG TỒN TẠI!");
                this.productID_JTF.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "VUI LÒNG "
                    + "NHẬP MÃ SẢN PHẨM!");
        }
    }//GEN-LAST:event_addProduct

    private void exitPageQuantity(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitPageQuantity
        jDialog1.dispose();
    }//GEN-LAST:event_exitPageQuantity

    private void enterQuantityOfProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterQuantityOfProduct
        String quantity = this.quantity_JTF.getText();
        if(quantity != null && !quantity.isEmpty()) {
            if(isNunmber(quantity)) {
                float tmp = Float.parseFloat(quantity);
                // kiểm tra xem số lượng trong kho có đủ không
                int selectRow = checkExistenceOfProductOnTable(this.product.getMaHH());
                if(selectRow != -1) {
                    // kiểm tra xem khuyến mãi có đang được bật hay không
                    if(this.isApplyingLoyaltyPoints) {
                        int selection = JOptionPane.showConfirmDialog(null, 
                    "ÁP DỤNG ĐIỂM TÍCH LŨY ĐANG ĐƯỢC ÁP DỤNG! HỦY ÁP "
                            + "DỤNG TÍNH ĐIỂM TÍCH LŨY?", "HỦY TÍNH ĐIỂM TÍCH LŨY", 
                    JOptionPane.OK_CANCEL_OPTION);
                        if(selection == JOptionPane.OK_OPTION) {
                            cancelApplyingLoyaltyPoints();
                        } else {
                            return;
                        }
                    }
                    float oldQuantity = (float) this.product_JTB.getValueAt(selectRow, 4);
                    if(hangHoaBUS.checkQuantityOfProduct(tmp + oldQuantity, this.product.getMaHH())) {
                        updateProductOnTable(selectRow, Integer.parseInt(quantity));
                        this.quantity_JTF.setText("");
                        product = null;
                        this.productID_JTF.setText("");
                        jDialog1.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "SỐ "
                                + "LƯỢNG HÀNG HÓA TRONG KHO KHÔNG ĐỦ!");
                        this.quantity_JTF.setText("");
                    }
                } else {
                    if(this.isApplyingLoyaltyPoints) {
                        // kiểm tra xem khuyến mãi có đang được bật hay không
                        int selection = JOptionPane.showConfirmDialog(null, 
                              "ÁP DỤNG ĐIỂM TÍCH LŨY ĐANG ĐƯỢC ÁP DỤNG! HỦY ÁP "
                            + "DỤNG TÍNH ĐIỂM TÍCH LŨY?", "HỦY TÍNH ĐIỂM TÍCH LŨY", 
                    JOptionPane.OK_CANCEL_OPTION);
                        if(selection == JOptionPane.OK_OPTION) {
                            cancelApplyingLoyaltyPoints();
                        } else {
                            return;
                        }
                    }
                    if(hangHoaBUS.checkQuantityOfProduct(tmp, this.product.getMaHH())) {
                        this.productsList.add(this.product);
                        this.quantityOfProduct = Integer.parseInt(quantity);
                        this.quantity_JTF.setText("");
                        loadProductToTable(product);
                        product = null;
                        this.productID_JTF.setText("");
                        jDialog1.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "SỐ "
                                + "LƯỢNG HÀNG HÓA TRONG KHO KHÔNG ĐỦ!");
                        this.quantity_JTF.setText("");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "DỮ LIỆU "
                        + "NHẬP VÀO KHÔNG PHẢI LÀ SỐ NGUYÊN VÀ LỚN HƠN 0!");
                this.quantity_JTF.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "VUI LÒNG "
                    + "NHẬP SỐ LƯỢNG SẢN PHẨM!");
        }
    }//GEN-LAST:event_enterQuantityOfProduct

    private void findCustomer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findCustomer
        String phoneNumOfCus = this.phoneNumOfCus_JTF.getText();
        String nameOfCus = this.namOfCus_JTF.getText();
        // tìm kiếm theo số điện thoại
        if(this.customer == null) {
            if(!phoneNumOfCus.equals("") && nameOfCus.equals("")) {
                if(isValidPhoneNumber(phoneNumOfCus)) {
                    findCusByPhoneNum(phoneNumOfCus);
                } else {
                    JOptionPane.showMessageDialog(null, "SỐ "
                            + "ĐIỆN THOẠI KHÔNG HỢP LỆ!");
                    this.phoneNumOfCus_JTF.setText("");
                }
            } 
            // tìm kiếm theo tên khách hàng
            else if(phoneNumOfCus.equals("") && !nameOfCus.equals("")) {
                findCusByName(nameOfCus);
            } else if(phoneNumOfCus.equals("") && nameOfCus.equals("")) {
                JOptionPane.showMessageDialog(null, "VUI LÒNG "
                        + "NHẬP THÔNG TIN ĐỂ TÌM KIẾM!");
            } else {
                JOptionPane.showMessageDialog(null, "CHỈ NHẬP "
                        + "SỐ ĐIỆN THOẠI HOẶC THÔNG TÊN KHÁCH HÀNG ĐỂ TÌM KIẾM!");
                this.phoneNumOfCus_JTF.setText("");
                this.namOfCus_JTF.setText("");
            }
        } else {
            int selection = JOptionPane.showConfirmDialog(null, 
                    "ĐÃ CÓ KHÁCH HÀNG THANH TOÁN! BẠN MUỐN HỦY THANH TOÁN "
                            + "KHÁCH HÀNG HIỆN TẠI?", "ĐỔI KHÁCH HÀNG", 
                            JOptionPane.OK_CANCEL_OPTION);
           if(selection == JOptionPane.OK_OPTION) {
               this.phoneNumOfCus_JTF.setText("");
               this.namOfCus_JTF.setText("");
               this.accumulatedPoints_JTF.setText("");
               this.customer = null;
           }
        }
    }//GEN-LAST:event_findCustomer

    private void applyingLoyaltyPoints(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyingLoyaltyPoints
        if(this.customer != null) {
            if(!this.isApplyingLoyaltyPoints) {
                if(total > 0) {
                    if(this.customer.getDiem() > 0) {
                        this.isApplyingLoyaltyPoints = true;
                        this.totalAfterUsePoint = this.total;
                        // áp dụng công thức tính điểm ra tiền
                        this.totalAfterUsePoint = (float) (this.total - (this.customer.getDiem() / 0.0003));
                        if(this.totalAfterUsePoint < 0) {
                            this.totalAfterUsePoint = 0;
                        }
                        this.total_JTF.setText(this.totalAfterUsePoint + "");
                        this.accumulatedPoints_JTF.setText("0");
                        this.isApplyingLoyaltyPoints = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "KHÁCH "
                                + "HÀNG KHÔNG ĐỦ ĐIỂM TÍCH LŨY!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "VUI LÒNG "
                            + "CHỌN SẢN PHẦM ĐỂ THANH TOÁN");
                }
            } else {
                JOptionPane.showMessageDialog(null, "ÁP DỤNG "
                        + "ĐIỂM TÍCH LŨY ĐÃ ĐƯỢC SỬ DỤNG");
            }
        } else {
            JOptionPane.showMessageDialog(null, "VUI LÒNG TÌM "
                    + "THÔNG TIN KHÁCH HÀNG!");
        }
    }//GEN-LAST:event_applyingLoyaltyPoints

    private void cancelApplyingLoyaltyPoints(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApplyingLoyaltyPoints
        cancelApplyingLoyaltyPoints();
    }//GEN-LAST:event_cancelApplyingLoyaltyPoints

    private void refeshPage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refeshPage
        refeshPage();
    }//GEN-LAST:event_refeshPage


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accumulatedPoints_JTF;
    private javax.swing.JButton addCusJBTN;
    private javax.swing.JButton addProduct_JBTN;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel cashierTitle;
    private javax.swing.JButton closeJBTN;
    private javax.swing.JLabel currnetly_JLB;
    private javax.swing.JButton deleteProduct_JBTN;
    private javax.swing.JButton findCusJBTN;
    private javax.swing.JButton findCusJBTN1;
    private javax.swing.JTextField idBill_JTF;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namOfCus_JTF;
    private javax.swing.JButton paymentJBTN;
    private javax.swing.JTextField phoneNumOfCus_JTF;
    private javax.swing.JTextField productID_JTF;
    private javax.swing.JTable product_JTB;
    private javax.swing.JButton quantity_JBTN;
    private javax.swing.JTextField quantity_JTF;
    private javax.swing.JButton returnGoodJBTN1;
    private javax.swing.JLabel staffName_JTF;
    private javax.swing.JTextField total_JTF;
    // End of variables declaration//GEN-END:variables

    // PHƯƠNG THỨC
    // set ngày tháng năm hiện tại cho page
    public void setTimeNow() {
        // Lấy ngày tháng năm hiện tại
        LocalDate currentDate = LocalDate.now();
        // Định dạng ngày tháng năm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        this.currnetly_JLB.setText("Ngày: " + formattedDate);
    }
    
    // các phương thức liên quan đến bảng
    public void tableInitialization() {
        this.tableModelProduct = (DefaultTableModel) this.product_JTB.getModel();
        this.selectedRowProductTable = -1;
    }
    
    public Object loadProductInfoToRow(HangHoaDTO product) {
        Object[] row = null;
        KhuyenMaiDTO promotion = khuyenMaiBUS.getPromtionByID(product.getMaKM());
        if(promotion != null) {
            float discount = promotion.getTiLeGiam() * 100;
            float promotionalPrice = product.getDonGiaBan() * promotion.getTiLeGiam();
            float total = product.getDonGiaBan() - promotionalPrice;
            this.total += total*quantityOfProduct;
            this.total_JTF.setText(this.total + "");
            row = new Object[] {
                this.tableModelProduct.getRowCount() + 1, product.getMaHH(), 
                product.getTenHH(), product.getDonVi(),
                this.quantityOfProduct, product.getDonGiaBan(), discount, promotionalPrice, 
                total*quantityOfProduct
            };
        } else {
            row = new Object[] {
                this.tableModelProduct.getRowCount() + 1, product.getMaHH(), 
                product.getTenHH(), product.getDonVi(),
                this.quantityOfProduct, product.getDonGiaBan(), 0, 0, 
                product.getDonGiaBan()*quantityOfProduct
            };
            this.total += product.getDonGiaBan() * quantityOfProduct;
            this.total_JTF.setText(this.total + "");
        }
        return row;
    }
    
    public void loadProductToTable(HangHoaDTO product) {
        Object[] row = (Object[]) loadProductInfoToRow(product);
        if(row != null) {
            this.tableModelProduct.addRow(row);
        } else {
            JOptionPane.showMessageDialog(null, "NHẬP DỮ LIỆU "
                    + "KHÔNG THÀNH CÔNG!");
        }
    }
    
    // kiểm tra xem dữ liệu nhập vào có phải là số không
    public boolean isNunmber(String quantity) {
        try {
            Double.parseDouble(quantity); // Thử chuyển đổi văn bản thành số
            return true && Double.parseDouble(quantity) != 0;
        } catch (NumberFormatException e) {
            return false; // Nếu không thể chuyển đổi, không phải số
        }
    }
    
    // kiểm tra xem sản phẩm đó đã có trên bảng hay chưa
    public int checkExistenceOfProductOnTable(String productID) {
        for(int i=0; i<this.tableModelProduct.getRowCount(); i++) {
            String productIdItem = (String) this.tableModelProduct.getValueAt(i, 1);
            if(productIdItem.equals(productID)) {
                return i;
            }
        }
        return -1;
    }
    
    // cập nhật lại sản phầm trên bảng
    public void updateProductOnTable(int selectRow, int quantity) {
        float oldQuantity = (float) this.tableModelProduct.getValueAt(selectRow, 4);
        this.tableModelProduct.setValueAt(quantity + oldQuantity, selectRow, 4);
        int newQuantity = quantity;
        quantity += oldQuantity;
        KhuyenMaiDTO promotion = khuyenMaiBUS.getPromtionByID(product.getMaKM());
        if(promotion != null) {
            float promotionalPrice = product.getDonGiaBan() * promotion.getTiLeGiam();
            float total = product.getDonGiaBan() - promotionalPrice;
            this.tableModelProduct.setValueAt(quantity*total, selectRow, 8);
            this.total += total * newQuantity;
            this.total_JTF.setText(this.total + "");
        } else {
            this.tableModelProduct.setValueAt(product.getDonGiaBan()*quantity, selectRow, 8);
            this.total += product.getDonGiaBan() * newQuantity;
            this.total_JTF.setText(this.total + "");
        }
    }
    
    // tìm kiếm khách hàng theo tên 
    public void findCusByName(String nameOfCus) {
        this.customer = khachHangBUS.getCusByName(nameOfCus);
        if(customer != null) {
            this.phoneNumOfCus_JTF.setText(customer.getSDT());
            this.namOfCus_JTF.setText(customer.getHoTen());
            this.accumulatedPoints_JTF.setText(customer.getDiem() + "");
        } else {
            JOptionPane.showMessageDialog(null, "TÊN KHÁCH "
                    + "HÀNG SAI HOẶC KHÔNG TỒN TẠI!");
            this.namOfCus_JTF.setText("");
        }
    }
    
    // tìm kiếm khách hàng theo số điện thoại
    public void findCusByPhoneNum(String phoneNumOfCus) {
        this.customer = khachHangBUS.getCusByPhoneNum(phoneNumOfCus);
        if(customer != null) {
            this.phoneNumOfCus_JTF.setText(customer.getSDT());
            this.namOfCus_JTF.setText(customer.getHoTen());
            this.accumulatedPoints_JTF.setText(customer.getDiem() + "");
        } else {
            JOptionPane.showMessageDialog(null, "SỐ ĐIỆN "
                    + "THOẠI KHÔNG TỒN TẠI!");
        }
    }
    
    // kiểm tra số điện thoại nhập vào có đúng k 
    public boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^0[97]\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    
    // hủy việc áp dụng tính điêm tích lũy
    public void cancelApplyingLoyaltyPoints() {
        if(this.isApplyingLoyaltyPoints) {
            this.total_JTF.setText(this.total + "");
            this.accumulatedPoints_JTF.setText(this.customer.getDiem() + "");
            this.isApplyingLoyaltyPoints = false;
        } else {
            JOptionPane.showMessageDialog(null, "ÁP DỤNG "
                    + "ĐIỂM TÍCH LŨY ĐANG KHÔNG ĐƯỢC SỬ DỤNG!");
        }
    }
    
    // khởi tạo một hóa đơn bán hàng mới
    public void createIdBill() {
        this.idBill = generateNewIdBill();
        this.idBill_JTF.setText(this.idBill);
    }
    
    // tạo mã hóa đơn tự động tự động
    private String generateNewIdBill() {
        int rowCount = this.hoaDonBanHangBUS.getAllBillAsArrayList().size();    
        int newSequence = rowCount + 1;
        return "HD" + String.format("%02d", newSequence);
    }
    
    // refesh lại trang 
    public void refeshPage() {
        // giao diện
        this.productID_JTF.setText("");
        this.phoneNumOfCus_JTF.setText("");
        this.namOfCus_JTF.setText("");
        this.total_JTF.setText("");
        this.accumulatedPoints_JTF.setText("");
        this.product_JTB.clearSelection();
        this.tableModelProduct.setRowCount(0);
        this.tableModelProduct.fireTableDataChanged();
        // bên trong code
        this.customer = null;
        this.product = null;
        this.quantityOfProduct = 0;
        this.total = 0;
        this.totalAfterUsePoint = 0;
        this.isApplyingLoyaltyPoints = false;
        this.productsList.clear();
        this.billDetailsList.clear();
    }
    
    // lấy toàn bộ chi tiết hóa đơn khi bắt đầu thanh toán
    public void getAllBillDetails() {
        for(int i=0; i<this.tableModelProduct.getRowCount(); i++) {
            String MaHH = (String) this.tableModelProduct.getValueAt(i, 1);
            System.out.println("ma hang hoa: " + MaHH);
            String MaHD = this.idBill;
            float SLBan = (float) this.tableModelProduct.getValueAt(i, 4);
            float total = (float) this.tableModelProduct.getValueAt(i, 8);
            float unitPrice = total / SLBan;
            // kiểm ta xem số lượng khách mua = số lượng trong kho không
            if(SLBan == this.hangHoaBUS.getQuantityOfProductInWarehouse(MaHH)) {
                for (CT_HangHoaDTO productDetailsItem : cT_HangHoaBUS.getProductDetailsByProductID(MaHH)) {
                    CTHD_BanHangDTO billDetailsItem = new CTHD_BanHangDTO(MaHD, productDetailsItem.getMaCT_HH(), productDetailsItem.getSoLuong(), unitPrice);
                    this.billDetailsList.add(billDetailsItem);
                }
            } 
            // xử lý trường hợp số lượng khách mau nhỏ hơn số lượng trong kho
            else {
                for (CT_HangHoaDTO productDetailsItem : cT_HangHoaBUS.getProductDetailsByProductID(MaHH)) {
                    if(SLBan <= productDetailsItem.getSoLuong()) {
                        CTHD_BanHangDTO billDetailsItem = new CTHD_BanHangDTO(MaHD, productDetailsItem.getMaCT_HH(), SLBan, unitPrice);
                        this.billDetailsList.add(billDetailsItem);
                        break;  
                    } else {
                        SLBan -= productDetailsItem.getSoLuong();
                        CTHD_BanHangDTO billDetailsItem = new CTHD_BanHangDTO(MaHD, productDetailsItem.getMaCT_HH(), productDetailsItem.getSoLuong(), unitPrice);
                        this.billDetailsList.add(billDetailsItem);
                    }
                }
            }
        }
    }
}
