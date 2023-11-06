package com.myproject.GUI.NhanVienBanHang;

import com.myproject.BUS.HoaDonBanHangBUS;
import com.myproject.DTO.HoaDonBanHangDTO;
import com.myproject.DTO.KhachHangDTO;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import com.itextpdf.text.DocumentException;
import com.myproject.DTO.HangHoaDTO;
import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.myproject.BUS.CTHD_BanHangBUS;
import com.myproject.BUS.CT_HangHoaBUS;
import com.myproject.BUS.HangHoaBUS;
import com.myproject.DTO.CTHD_BanHangDTO;
import com.myproject.DTO.CT_HangHoaDTO;
import java.sql.Timestamp;

public class Payment_JDialog extends javax.swing.JDialog {
    private String MaNV;
    private CT_HangHoaBUS cT_HangHoaBUS = new CT_HangHoaBUS();
    private HangHoaBUS hangHoaBUS = new HangHoaBUS();
    private HoaDonBanHangBUS hoaDonBanHangBUS = new HoaDonBanHangBUS();
    private CTHD_BanHangBUS cTHD_BanHangBUS = new CTHD_BanHangBUS();
    private KhachHangDTO customer = null;
    private ArrayList<HangHoaDTO> productsList;
    private ArrayList<CTHD_BanHangDTO> billDetailsList;
    private float total = 0;
    private String MaHD;
    
    // constructor có truyền tham số vào
    public Payment_JDialog(java.awt.Frame parent, boolean modal, KhachHangDTO 
            customer, float total, String MaHD, ArrayList<HangHoaDTO> productList, 
            ArrayList<CTHD_BanHangDTO> billDetailsList, String MaNV) {
        super(parent, modal);
        this.MaNV = MaNV;
        this.MaHD = MaHD;
        this.customer = customer;
        this.total = total;
        this.productsList = productList;
        this.billDetailsList = billDetailsList;
        initComponents();
        setUpPage(); 
    }
    
    // constructor không truyền tham số khách hàng vào
    public Payment_JDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cusID_JTF = new javax.swing.JTextField();
        nameOfCus_JTF = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        total_JLB = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalPayment_JTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        change_JLB = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cash_JTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bank_JTF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        amountPaid_JLB = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(3, 169, 244));

        jPanel2.setBackground(new java.awt.Color(3, 169, 244));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Khách hàng");

        cusID_JTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cusID_JTF.setEnabled(false);

        nameOfCus_JTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nameOfCus_JTF.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cusID_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameOfCus_JTF)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cusID_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameOfCus_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(3, 169, 244));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Tổng tiền phải trả");

        total_JLB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        total_JLB.setText("0 (VND)");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Tiền khách đưa");

        totalPayment_JTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        totalPayment_JTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashIsReceived(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("(VND)");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Tiền trả lại khách");

        change_JLB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        change_JLB.setText("0 (VND)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total_JLB))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalPayment_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(change_JLB)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(total_JLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(totalPayment_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(change_JLB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(3, 169, 244));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Hình thức thanh toán");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Tiền mặt");

        cash_JTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Tiền ngân hàng");

        bank_JTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("Khách đã trả");

        amountPaid_JLB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        amountPaid_JLB.setText("0 (VND)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(amountPaid_JLB))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bank_JTF)
                            .addComponent(cash_JTF))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cash_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(bank_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(amountPaid_JLB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/floppy-disk.png"))); // NOI18N
        jButton1.setText("In & lưu");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new java.awt.Dimension(108, 108));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/printer.png"))); // NOI18N
        jButton2.setText("In HĐ");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setPreferredSize(new java.awt.Dimension(108, 108));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBill(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/floppy-disk.png"))); // NOI18N
        jButton3.setText("Lưu");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setPreferredSize(new java.awt.Dimension(108, 108));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBill(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/close.png"))); // NOI18N
        jButton4.setText("Đóng");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setPreferredSize(new java.awt.Dimension(108, 108));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closePage(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closePage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closePage
        this.dispose();
    }//GEN-LAST:event_closePage

    private void cashIsReceived(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashIsReceived
        String tmp = this.totalPayment_JTF.getText();
        if(ValidateNumber(tmp)) {
            float moneyOfCus = Float.parseFloat(tmp);
            if(moneyOfCus >= total) {
                this.change_JLB.setText((moneyOfCus - this.total) + " (VND)");
                this.cash_JTF.setText((moneyOfCus) + " (VND)");
                this.amountPaid_JLB.setText(this.total + " (VND)");
            } else {
                JOptionPane.showMessageDialog(null, "SỐ TIỀN KHÔNG ĐỦ ĐỂ THANH TOÁN!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "DỮ LIỆU NHẬP VÀO KHÔNG ĐÚNG!");
        }
    }//GEN-LAST:event_cashIsReceived

    private void saveBill(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBill
        if(!this.totalPayment_JTF.getText().isEmpty()) {
            String tmp = this.totalPayment_JTF.getText();
            if(ValidateNumber(tmp)) {
                float moneyOfCus = Float.parseFloat(tmp);
                if(moneyOfCus >= total) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Timestamp currentDateTime = new Timestamp(currentTimeMillis);
                    HoaDonBanHangDTO bill = new HoaDonBanHangDTO(this.MaHD, 
                            currentDateTime, this.total, this.customer.getMaKH(), MaNV);
                    int checkBill = this.hoaDonBanHangBUS.addNewBill(bill);
                    int checkBillDetails = this.cTHD_BanHangBUS.addBillDetails(billDetailsList);
                    int checkuUpdateQuantity = updateQuantityOfProduct();
                    if(checkBill != -1 && checkBillDetails != -1 && checkuUpdateQuantity != -1) {
                        JOptionPane.showMessageDialog(null, "LƯU HÓA ĐƠN THÀNH CÔNG!");
                        Cashier_MainJFrame cashier_MainJFrame = (Cashier_MainJFrame) this.getParent();
                        cashier_MainJFrame.refeshPage();
                        cashier_MainJFrame.createIdBill();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "LƯU HÓA ĐƠN THẤT BẠI!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "SỐ TIỀN KHÔNG ĐỦ ĐỂ THANH TOÁN!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "DỮ LIỆU NHẬP VÀO KHÔNG ĐÚNG!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP SỐ TIỀN KHÁCH ĐÃ TRẢ!");
        }
    }//GEN-LAST:event_saveBill

    private void printBill(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBill
        printBill();
    }//GEN-LAST:event_printBill

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Payment_JDialog dialog = new Payment_JDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountPaid_JLB;
    private javax.swing.JTextField bank_JTF;
    private javax.swing.JTextField cash_JTF;
    private javax.swing.JLabel change_JLB;
    private javax.swing.JTextField cusID_JTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nameOfCus_JTF;
    private javax.swing.JTextField totalPayment_JTF;
    private javax.swing.JLabel total_JLB;
    // End of variables declaration//GEN-END:variables

    // PHƯƠNG THỨC
    // set up page
    public void setUpPage() {
        this.cusID_JTF.setText(this.customer.getMaKH());
        this.nameOfCus_JTF.setText(this.customer.getHoTen());
        this.total_JLB.setText(this.total + " (VND)");
    }
    
    // kiểm tra dữ liệu nhập vào có phải là số không
    public static boolean ValidateNumber(String num) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }
    
    // xuất vé cho khách
    public void printBill() {
        // lấy ngày giờ hiện tại lập hóa đơn
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        String formattedDate = dateFormat.format(currentDate);
        
        // tạo một document
        Document document = new Document();

        try {
            // khởi tạo một PdfWriter truyền vào document và FileOutputStream
            PdfWriter.getInstance((com.itextpdf.text.Document) document, new FileOutputStream("C:\\Users\\ADMIN\\OneDrive\\Máy tính\\BILL.pdf"));

            // mở file để thực hiện viết
            document.open();
            // thêm nội dung sử dụng add function
            document.add(new Paragraph("HOA DON BAN HANG"));
            document.add(new Paragraph("Ngay ban: " + formattedDate + "          Quay: 1"));
            document.add(new Paragraph("Ma hoa don: " + this.MaHD + "          Ma nhan vien: " + this.MaNV));
            document.add(new Paragraph(""));
            document.add(new Paragraph("DANH SACH SAN PHAM"));
            
            for(HangHoaDTO productItem : this.productsList) {
                document.add(new Paragraph(productItem.getTenHH() + "--"));
            }
            // đóng file
            document.close();
            System.out.println("ghi thanh cong!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException ex) {
            Logger.getLogger(Payment_JDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // cập nhật lại số lượng trong kho
    public int updateQuantityOfProduct() {
        int check = -1;
        for (CTHD_BanHangDTO billDetailsItem : this.billDetailsList) {
            CT_HangHoaDTO productDetails = this.cT_HangHoaBUS.
                    getProductDetailsByID(billDetailsItem.getMaCT_HH());
            productDetails.setSoLuong(productDetails.getSoLuong() - billDetailsItem.getSLBan());
            if(productDetails.getSoLuong() == 0) {
                productDetails.setTinhTrang(false);
            } 
            check = this.cT_HangHoaBUS.updateQuantityOfProduct2(productDetails.getMaCT_HH(), 
                    productDetails.getSoLuong(), productDetails.isTinhTrang());
        }
        return check;
    }
}
