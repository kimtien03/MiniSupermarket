package com.myproject.GUI.NhanVienBanHang;

import com.myproject.BUS.KhachHangBUS;
import com.myproject.DTO.KhachHangDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cus_Info_JDialog extends javax.swing.JDialog {
    private KhachHangBUS khachHangBUS = new KhachHangBUS();
    
    public Cus_Info_JDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        JTextField dateTextField = (JTextField) dateOfBirth_JDC.getDateEditor().getUiComponent();
        dateTextField.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameOfCus_JTF = new javax.swing.JTextField();
        phoneNumOfCus_JTF = new javax.swing.JTextField();
        dateOfBirth_JDC = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        saveJBTN = new javax.swing.JButton();
        closeJBTN = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(3, 169, 244));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 547));

        jPanel2.setBackground(new java.awt.Color(3, 169, 244));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Tên khách hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Điện thoại");

        nameOfCus_JTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        phoneNumOfCus_JTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        dateOfBirth_JDC.setDateFormatString("yyyy-MM-dd");
        dateOfBirth_JDC.setPreferredSize(new java.awt.Dimension(64, 28));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addComponent(nameOfCus_JTF, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(72, 72, 72)
                        .addComponent(dateOfBirth_JDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(71, 71, 71)
                        .addComponent(phoneNumOfCus_JTF)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameOfCus_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(dateOfBirth_JDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumOfCus_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(211, 211, 211))
        );

        jPanel4.setBackground(new java.awt.Color(3, 169, 244));

        saveJBTN.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        saveJBTN.setText("Lưu");
        saveJBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveJBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCusInfo(evt);
            }
        });

        closeJBTN.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        closeJBTN.setText("Thoát");
        closeJBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeJBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closePage(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(saveJBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeJBTN)
                .addGap(76, 76, 76))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveJBTN)
                    .addComponent(closeJBTN))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Ghi chú: Mã khách hàng sẽ được cấp tự động");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveCusInfo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCusInfo
        String nameOfCus = this.nameOfCus_JTF.getText();
        String phoneNumOfCus = this.phoneNumOfCus_JTF.getText();
        JTextField dateTextField = (JTextField) dateOfBirth_JDC.getDateEditor().getUiComponent();
        if(dateTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP ĐẦY ĐỦ THÔNG TIN KHÁCH HÀNG!");
            return;
        } else if(phoneNumOfCus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP ĐẦY ĐỦ THÔNG TIN KHÁCH HÀNG!");
            return;
        } else if(nameOfCus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP ĐẦY ĐỦ THÔNG TIN KHÁCH HÀNG!");
            return;
        } else if(!isValidPhoneNumber(phoneNumOfCus)) {
            JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI NHẬP VÀO KHÔNG HỢP LỆ!");
            this.phoneNumOfCus_JTF.setText("");
            return;
        } else if(!nameOfCus.isEmpty() || !phoneNumOfCus.isEmpty()) {
            if(!nameOfCus.isEmpty()) {
                KhachHangDTO checkExist = khachHangBUS.getCusByName(nameOfCus);
                if(checkExist != null) {
                    JOptionPane.showMessageDialog(null, "KHÁCH HÀNG ĐÃ TỒN TẠI!");
                    return;
                }
            } else {
                KhachHangDTO checkExist = khachHangBUS.getCusByPhoneNum(phoneNumOfCus);
                if(checkExist != null) {
                    JOptionPane.showMessageDialog(null, "KHÁCH HÀNG ĐÃ TỒN TẠI!");
                    return;
                }
            }
        }
        Date dayOfBirth = Date.valueOf(dateTextField.getText());
        String MaKH = generateNewMaKH();
        KhachHangDTO customer = new KhachHangDTO(MaKH, nameOfCus, phoneNumOfCus, 0, dayOfBirth, true);
        int check = khachHangBUS.addCustomer(customer);
        if(check != -1) {
            JOptionPane.showMessageDialog(null, "THÊM KHÁCH HÀNG THÀNH CÔNG!");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "THÊM KHÁCH HÀNG THẤT BẠI!");
        }
    }//GEN-LAST:event_saveCusInfo

    private void closePage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closePage
        dispose();
    }//GEN-LAST:event_closePage


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeJBTN;
    private com.toedter.calendar.JDateChooser dateOfBirth_JDC;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nameOfCus_JTF;
    private javax.swing.JTextField phoneNumOfCus_JTF;
    private javax.swing.JButton saveJBTN;
    // End of variables declaration//GEN-END:variables

    // PHƯƠNG THỨC
    // kiểm tra số điện thoại nhập vào có đúng k 
    public boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^0[97]\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    
    // tạo mã khách hàng tự động
    private String generateNewMaKH() {
        int rowCount = this.khachHangBUS.getCusArrayList().size();
        int newSequence = rowCount + 1;
        return "KH" + String.format("%03d", newSequence);
    }
}
