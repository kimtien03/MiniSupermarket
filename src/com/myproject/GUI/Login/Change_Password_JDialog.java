package com.myproject.GUI.Login;

import com.myproject.BUS.NhanVienBUS;
import java.awt.Frame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Change_Password_JDialog extends javax.swing.JDialog {
    private int OTP;
    private String maNV;
    NhanVienBUS nv = new NhanVienBUS();
    
    public Change_Password_JDialog(java.awt.Dialog parent, boolean modal, String maNV, int OTP) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.OTP = OTP;
        this.maNV = maNV;
        System.out.println("otp 2: " + this.OTP);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbttnExit = new javax.swing.JButton();
        jbttnDMK = new javax.swing.JButton();
        jtfOTP = new javax.swing.JTextField();
        jpwMK = new javax.swing.JPasswordField();
        jpwRetypeMK = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(3, 169, 244));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Đổi mật khẩu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mã OTP:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mật khẩu mới:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nhập lại mật khẩu:");

        jbttnExit.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jbttnExit.setText("Thoát");
        jbttnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnExitActionPerformed(evt);
            }
        });

        jbttnDMK.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jbttnDMK.setText("Đổi mật khẩu");
        jbttnDMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnDMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnDMKActionPerformed(evt);
            }
        });

        jtfOTP.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jpwMK.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jpwRetypeMK.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jbttnExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jbttnDMK)
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jtfOTP, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jpwMK)
                    .addComponent(jpwRetypeMK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfOTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(jpwMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpwRetypeMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbttnExit)
                    .addComponent(jbttnDMK))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbttnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnExitActionPerformed
        dispose();
    }//GEN-LAST:event_jbttnExitActionPerformed
    public boolean ValidateOTP(String maOTP) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(maOTP);
        return matcher.matches();
    }
    private void jbttnDMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnDMKActionPerformed
        String maOtp = jtfOTP.getText();
        char[] mkChar = jpwMK.getPassword();
        String mk = new String(mkChar);
        char[] retypemkChar = jpwRetypeMK.getPassword();
        String retypemk = new String(retypemkChar);
        if (maOtp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã OTP!");
            return;
        }
        if (!ValidateOTP(maOtp.trim()) || Integer.parseInt(maOtp.trim()) != OTP) {
            JOptionPane.showMessageDialog(null, "Mã OTP không đúng!");
            return;
        }
        if (mk.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu mới!");
            return;
        }
        if (retypemk.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập lại mật khẩu!");
            return;
        }
        if (!mk.trim().equals(retypemk.trim())) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập lại đúng mật khẩu!");
            return;
        }
        if (nv.UpdateMK(maNV,mk)) {
            JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");
            dispose();
            closeLoginFrame();
            new Login_JFrame().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Đổi mật khẩu thất bại!");
        }
    }//GEN-LAST:event_jbttnDMKActionPerformed
    private void closeLoginFrame() {
        Frame[] frames = Frame.getFrames();
        for (Frame frame : frames) {
            if (frame instanceof JFrame && frame.getTitle().equals("Login_JFrame")) {
                frame.dispose();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbttnDMK;
    private javax.swing.JButton jbttnExit;
    private javax.swing.JPasswordField jpwMK;
    private javax.swing.JPasswordField jpwRetypeMK;
    private javax.swing.JTextField jtfOTP;
    // End of variables declaration//GEN-END:variables
}
