package com.myproject.GUI.Login;

import com.formdev.flatlaf.FlatLightLaf;
import com.myproject.BUS.CT_HangHoaBUS;
import com.myproject.BUS.KhuyenMaiBUS;
import com.myproject.BUS.NhanVienBUS;
import com.myproject.DTO.NhanVienDTO;
import com.myproject.GUI.Admin.Admin_MainJFrame;
import com.myproject.GUI.NhanVienBanHang.Cashier_MainJFrame;
import com.myproject.GUI.NhanVienKho.MainInventory;
import com.myproject.GUI.QuanLy.MainFrame;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
public class Login_JFrame extends javax.swing.JFrame {
    NhanVienBUS nv = new NhanVienBUS();
    CT_HangHoaBUS cthh = new CT_HangHoaBUS();
    KhuyenMaiBUS km = new KhuyenMaiBUS();
    ArrayList <NhanVienDTO> arrNV = (ArrayList <NhanVienDTO>) nv.getList();
    public Login_JFrame() {
        initComponents();
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.setLocationRelativeTo(null);
        java.util.Date currentDate = new java.util.Date();
        Date date = new Date(currentDate.getTime());
        AutoUpdateCT_HH(date);
        AutoUpdateKM(date);
    }
    private void AutoUpdateCT_HH(Date date) {
        cthh.AutoUpdateCT_HH(date);
    }
    private void AutoUpdateKM(Date date) {
        km.AutoUpdateKM(date);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfTK = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jlbQMK = new javax.swing.JLabel();
        jpfMK = new javax.swing.JPasswordField();
        jbttnDN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login_JFrame");

        jPanel1.setBackground(new java.awt.Color(3, 169, 244));

        jPanel2.setBackground(new java.awt.Color(3, 169, 244));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tài khoản:");

        jtfTK.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jtfTK.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mật khẩu:");

        jlbQMK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbQMK.setForeground(new java.awt.Color(102, 102, 102));
        jlbQMK.setText("Quên mật khẩu?");
        jlbQMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbQMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quenMatKhau(evt);
            }
        });

        jpfMK.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jpfMK.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfTK)
                    .addComponent(jpfMK)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbQMK)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 204, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpfMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbQMK, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbttnDN.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jbttnDN.setText("Đăng nhập");
        jbttnDN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnDNActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/rsz_logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jbttnDN)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbttnDN)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean isExistTK(String taiKhoan) {
        boolean result = false;
        for (NhanVienDTO nv : arrNV) {
            if (nv.getMaNV().trim().equalsIgnoreCase(taiKhoan.trim()) && nv.getMaQuyen() != null) {
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean isValidMK(String taiKhoan, String matKhau) {
        boolean result = false;
        for (NhanVienDTO nv : arrNV) {
            if (nv.getMaNV().trim().equalsIgnoreCase(taiKhoan.trim()) &&
                nv.getPasswd().trim().equals(matKhau.trim())) {
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean isBlock(String taiKhoan) {
        boolean result = false;
        for (NhanVienDTO nv : arrNV) {
            if (nv.getMaNV().trim().equalsIgnoreCase(taiKhoan.trim()) && !nv.isKhoaTK()) {
                result = true;
                break;
            }
        }
        return result;
    }
    public void DividePermission(String taiKhoan) {
        String maQuyen = null;
        String tenNV = null;
        for (NhanVienDTO nv : arrNV) {
            if (nv.getMaNV().trim().equalsIgnoreCase(taiKhoan.trim())) {
                maQuyen = nv.getMaQuyen().trim();
                tenNV = nv.getTenNV().trim();
            }
        }
        if (maQuyen.equalsIgnoreCase("MQ01")) {
            new MainFrame(tenNV).setVisible(true);
        } 
        else if (maQuyen.equalsIgnoreCase("MQ02")) {
            new Cashier_MainJFrame().setVisible(true);
        }
        else if (maQuyen.equalsIgnoreCase("MQ03")) {
            new MainInventory(taiKhoan.trim().toUpperCase(),tenNV).setVisible(true);
        }
        else if (maQuyen.equalsIgnoreCase("MQ04")) {
            new Admin_MainJFrame(tenNV).setVisible(true);
        }
        this.dispose();
    }
    private void jbttnDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnDNActionPerformed
        String taiKhoan = jtfTK.getText();
        char[] matKhauChar = jpfMK.getPassword();
        String matKhau = new String(matKhauChar);
        if (taiKhoan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản!");
            return;
        }
        if (!isExistTK(taiKhoan)) {
            JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại hoặc chưa được kích hoạt!");
            return;
        }
        if (matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu!");
            return;
        }
        if (!isValidMK(taiKhoan,matKhau)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không đúng!");
            return;
        }
        if (!isBlock(taiKhoan)) {
            JOptionPane.showMessageDialog(null, "Tài khoản của bạn đã bị khóa!");
            return;
        }
        DividePermission(taiKhoan);
    }//GEN-LAST:event_jbttnDNActionPerformed

    private void quenMatKhau(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quenMatKhau
        Forgot_Password_JDialog forgot_Password_JDialog = new Forgot_Password_JDialog(this, rootPaneCheckingEnabled);
        forgot_Password_JDialog.setVisible(true);
    }//GEN-LAST:event_quenMatKhau


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbttnDN;
    private javax.swing.JLabel jlbQMK;
    private javax.swing.JPasswordField jpfMK;
    private javax.swing.JTextField jtfTK;
    // End of variables declaration//GEN-END:variables
}
