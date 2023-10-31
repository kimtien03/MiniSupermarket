package com.myproject.GUI.Login;

import com.myproject.BUS.NhanVienBUS;
import com.myproject.DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Forgot_Password_JDialog extends javax.swing.JDialog {
    NhanVienBUS nv = new NhanVienBUS();
    ArrayList <NhanVienDTO> arrNV = (ArrayList <NhanVienDTO>) nv.getList();
    public Forgot_Password_JDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbttnExit = new javax.swing.JButton();
        jbttnSendOTP = new javax.swing.JButton();
        jtfMaNV = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(3, 169, 244));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thông tin người dùng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mã nhân viên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email:");

        jbttnExit.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jbttnExit.setText("Thoát");
        jbttnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnExitActionPerformed(evt);
            }
        });

        jbttnSendOTP.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jbttnSendOTP.setText("Gửi mã OTP");
        jbttnSendOTP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnSendOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnSendOTPActionPerformed(evt);
            }
        });

        jtfMaNV.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jtfEmail.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jbttnExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbttnSendOTP)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jtfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbttnExit)
                    .addComponent(jbttnSendOTP))
                .addContainerGap(23, Short.MAX_VALUE))
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
    public int SendEmail(String email) {
        String username = "tn6609092@gmail.com"; 
        String password = "hawn kvok ehjz qucy";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        int otp = 0;
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // Email gửi
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Mã OTP"); 
            otp = generateOTP(); 
            message.setText("Mã OTP của bạn là: " + otp);

            // Gửi email
            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.err.println("Failed to send email. Error: " + e.getMessage());
        }
        return otp;
    }
    private static int generateOTP() {
        return (int) (Math.random() * 9000) + 1000;
    }
    private void jbttnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnExitActionPerformed
        dispose();
    }//GEN-LAST:event_jbttnExitActionPerformed
    public boolean isExistTK(String maNV) {
        boolean result = false;
        for (NhanVienDTO nv : arrNV) {
            if (nv.getMaNV().trim().equalsIgnoreCase(maNV.trim()) && nv.getMaQuyen() != null) {
                result = true;
                break;
            }
        }
        return result;
    }
    private boolean isValidEmail(String maNV, String email) {
        boolean result = false;
        for (NhanVienDTO nv : arrNV) {
            if (nv.getMaNV().trim().equalsIgnoreCase(maNV.trim()) && 
                    nv.getEmail().trim().equals(email.trim())) {
                result = true;
                break;
            }
        }
        return result;
    }
    private void jbttnSendOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnSendOTPActionPerformed
        String maNV = jtfMaNV.getText();
        String email = jtfEmail.getText();
        if (maNV.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã nhân viên!");
            return;
        }
        if (!isExistTK(maNV)) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên không tồn tại hoặc tài khoản chưa được kích hoạt");
            return;
        }
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập email!");
            return;
        }
        if (!isValidEmail(maNV,email)) {
            JOptionPane.showMessageDialog(null, "Email không tồn tại hoặc không đúng định dạng!");
            return;
        }
        int OTP = SendEmail(email);
        System.out.println("otp 1: " + OTP);
        Change_Password_JDialog change_Password_JDialog = new Change_Password_JDialog(this, rootPaneCheckingEnabled,maNV,OTP);
        change_Password_JDialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbttnSendOTPActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Forgot_Password_JDialog dialog = new Forgot_Password_JDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbttnExit;
    private javax.swing.JButton jbttnSendOTP;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfMaNV;
    // End of variables declaration//GEN-END:variables
}
