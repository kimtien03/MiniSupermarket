package com.myproject.GUI.Admin;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.UIManager;

public class Admin_MainJFrame extends javax.swing.JFrame {
    private Decentrazilation_JPanel decentrazilation_JPanel = new Decentrazilation_JPanel();
    private AccountManag_JPanel accountManag_JPanel = new AccountManag_JPanel();
    
    public Admin_MainJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setItemJPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        decentralizationJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        accoutManagJPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ItemJPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(3, 169, 244));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel5.setBackground(new java.awt.Color(3, 169, 244));
        jPanel5.setPreferredSize(new java.awt.Dimension(243, 700));

        decentralizationJPanel.setBackground(new java.awt.Color(3, 169, 244));
        decentralizationJPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        decentralizationJPanel.setPreferredSize(new java.awt.Dimension(139, 60));
        decentralizationJPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickedDecentralization(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(3, 169, 244));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/decentralized.png"))); // NOI18N
        jLabel1.setText("Phân quyền");

        javax.swing.GroupLayout decentralizationJPanelLayout = new javax.swing.GroupLayout(decentralizationJPanel);
        decentralizationJPanel.setLayout(decentralizationJPanelLayout);
        decentralizationJPanelLayout.setHorizontalGroup(
            decentralizationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        decentralizationJPanelLayout.setVerticalGroup(
            decentralizationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        accoutManagJPanel.setBackground(new java.awt.Color(3, 169, 244));
        accoutManagJPanel.setForeground(new java.awt.Color(255, 255, 255));
        accoutManagJPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accoutManagJPanel.setPreferredSize(new java.awt.Dimension(219, 60));
        accoutManagJPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickedAccounManagement(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/management.png"))); // NOI18N
        jLabel4.setText("Quản lý tài khoản");

        javax.swing.GroupLayout accoutManagJPanelLayout = new javax.swing.GroupLayout(accoutManagJPanel);
        accoutManagJPanel.setLayout(accoutManagJPanelLayout);
        accoutManagJPanelLayout.setHorizontalGroup(
            accoutManagJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        accoutManagJPanelLayout.setVerticalGroup(
            accoutManagJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(3, 169, 244));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/rsz_logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addComponent(decentralizationJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
            .addComponent(accoutManagJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(decentralizationJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accoutManagJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ItemJPanel.setPreferredSize(new java.awt.Dimension(945, 700));
        ItemJPanel.setRequestFocusEnabled(false);
        ItemJPanel.setLayout(new javax.swing.BoxLayout(ItemJPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/profile.png"))); // NOI18N
        jLabel5.setText("Nguyễn Vũ Tiến Đạt");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/logout.png"))); // NOI18N
        jLabel2.setText("Đăng xuất");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closePage(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ItemJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1206, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clickedDecentralization(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickedDecentralization
        this.ItemJPanel.removeAll();
        this.ItemJPanel.setLayout(new GridLayout(1,1));
        this.ItemJPanel.add(decentrazilation_JPanel);
        this.ItemJPanel.validate();
        this.ItemJPanel.repaint();
        decentrazilation_JPanel.setVisible(true);
        accountManag_JPanel.setVisible(false);
        accoutManagJPanel.setBackground(new Color(3,169,244));
        decentralizationJPanel.setBackground(new Color(182,224,244));
    }//GEN-LAST:event_clickedDecentralization

    private void clickedAccounManagement(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickedAccounManagement
        this.ItemJPanel.removeAll();
        this.ItemJPanel.setLayout(new GridLayout(1,1));
        this.ItemJPanel.add(accountManag_JPanel);
        this.ItemJPanel.validate();
        this.ItemJPanel.repaint();
        accountManag_JPanel.setVisible(true);
        decentrazilation_JPanel.setVisible(false);
        accoutManagJPanel.setBackground(new Color(182,224,244));
        decentralizationJPanel.setBackground(new Color(3,169,244));
    }//GEN-LAST:event_clickedAccounManagement

    private void closePage(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closePage
        System.exit(0);
    }//GEN-LAST:event_closePage

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ItemJPanel;
    private javax.swing.JPanel accoutManagJPanel;
    private javax.swing.JPanel decentralizationJPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

    // mặc định đăng nhập vào trang addmin sẽ hiển thị giao diện phân quyền
    public void setItemJPanel() {
        Decentrazilation_JPanel decentrazilation_JPanel = new Decentrazilation_JPanel();
        this.ItemJPanel.setLayout(new GridLayout(1,1));
        this.ItemJPanel.add(decentrazilation_JPanel);
        this.ItemJPanel.validate();
        this.ItemJPanel.repaint();
        decentrazilation_JPanel.setVisible(true);
        accountManag_JPanel.setVisible(false);
        decentralizationJPanel.setBackground(new Color(182,224,244));
        accoutManagJPanel.setBackground(new Color(3,169,244));
    }
}



