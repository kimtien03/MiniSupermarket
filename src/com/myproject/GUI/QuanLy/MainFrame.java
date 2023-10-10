package com.myproject.GUI.QuanLy;
import com.formdev.flatlaf.FlatLightLaf;
import com.myproject.GUI.QuanLy.setupMenu.DanhMucMenu;
import com.myproject.GUI.QuanLy.setupMenu.ScreenChange;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);
        setTitle("SIÊU THỊ MINI");
        ScreenChange controller = new ScreenChange(jPanelContent);
        controller.setContent(jpnQLBH,jlbQLBH);
        
        List<DanhMucMenu> listItem = new ArrayList<>();
        listItem.add(new DanhMucMenu("QLBH",jpnQLBH,jlbQLBH));
        listItem.add(new DanhMucMenu("QLHH",jpnQLHH,jlbQLHH));
        listItem.add(new DanhMucMenu("QLKH",jpnQLKH,jlbQLKH));
        listItem.add(new DanhMucMenu("QLNCC",jpnQLNCC,jlbQLNCC));
        listItem.add(new DanhMucMenu("QLNV",jpnQLNV,jlbQLNV));
        listItem.add(new DanhMucMenu("QLNH",jpnQLNH,jlbQLNH));
        listItem.add(new DanhMucMenu("KhuyenMai",jpnKM,jlbKM));
        listItem.add(new DanhMucMenu("ThongKe",jpnTK,jlbTK));
        controller.setEvent(listItem);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRoot = new javax.swing.JPanel();
        jPanelContent = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jpnQLBH = new javax.swing.JPanel();
        jlbQLBH = new javax.swing.JLabel();
        jpnQLHH = new javax.swing.JPanel();
        jlbQLHH = new javax.swing.JLabel();
        jpnQLKH = new javax.swing.JPanel();
        jlbQLKH = new javax.swing.JLabel();
        jpnQLNCC = new javax.swing.JPanel();
        jlbQLNCC = new javax.swing.JLabel();
        jpnQLNV = new javax.swing.JPanel();
        jlbQLNV = new javax.swing.JLabel();
        jpnQLNH = new javax.swing.JPanel();
        jlbQLNH = new javax.swing.JLabel();
        jpnKM = new javax.swing.JPanel();
        jlbKM = new javax.swing.JLabel();
        jpnTK = new javax.swing.JPanel();
        jlbTK = new javax.swing.JLabel();
        jLbTK = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        jlbInfo = new javax.swing.JLabel();
        jlbLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelRoot.setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanelContent.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContent.setPreferredSize(new java.awt.Dimension(980, 640));

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jPanelMenu.setBackground(new java.awt.Color(3, 169, 244));
        jPanelMenu.setPreferredSize(new java.awt.Dimension(220, 700));

        jpnQLBH.setBackground(new java.awt.Color(3, 169, 244));
        jpnQLBH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnQLBH.setPreferredSize(new java.awt.Dimension(220, 60));

        jlbQLBH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbQLBH.setForeground(new java.awt.Color(255, 255, 255));
        jlbQLBH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/sale.png"))); // NOI18N
        jlbQLBH.setText("Bán Hàng");

        javax.swing.GroupLayout jpnQLBHLayout = new javax.swing.GroupLayout(jpnQLBH);
        jpnQLBH.setLayout(jpnQLBHLayout);
        jpnQLBHLayout.setHorizontalGroup(
            jpnQLBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLBHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLBH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnQLBHLayout.setVerticalGroup(
            jpnQLBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQLBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnQLHH.setBackground(new java.awt.Color(3, 169, 244));
        jpnQLHH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnQLHH.setPreferredSize(new java.awt.Dimension(220, 60));

        jlbQLHH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbQLHH.setForeground(new java.awt.Color(255, 255, 255));
        jlbQLHH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/product.png"))); // NOI18N
        jlbQLHH.setText("Hàng Hóa");

        javax.swing.GroupLayout jpnQLHHLayout = new javax.swing.GroupLayout(jpnQLHH);
        jpnQLHH.setLayout(jpnQLHHLayout);
        jpnQLHHLayout.setHorizontalGroup(
            jpnQLHHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLHHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLHH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnQLHHLayout.setVerticalGroup(
            jpnQLHHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQLHH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnQLKH.setBackground(new java.awt.Color(3, 169, 244));
        jpnQLKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnQLKH.setPreferredSize(new java.awt.Dimension(220, 60));

        jlbQLKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbQLKH.setForeground(new java.awt.Color(255, 255, 255));
        jlbQLKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/customer.png"))); // NOI18N
        jlbQLKH.setText("Khách Hàng");

        javax.swing.GroupLayout jpnQLKHLayout = new javax.swing.GroupLayout(jpnQLKH);
        jpnQLKH.setLayout(jpnQLKHLayout);
        jpnQLKHLayout.setHorizontalGroup(
            jpnQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLKH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnQLKHLayout.setVerticalGroup(
            jpnQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQLKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnQLNCC.setBackground(new java.awt.Color(3, 169, 244));
        jpnQLNCC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnQLNCC.setPreferredSize(new java.awt.Dimension(220, 60));

        jlbQLNCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbQLNCC.setForeground(new java.awt.Color(255, 255, 255));
        jlbQLNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/supplier.png"))); // NOI18N
        jlbQLNCC.setText("Nhà Cung Cấp");

        javax.swing.GroupLayout jpnQLNCCLayout = new javax.swing.GroupLayout(jpnQLNCC);
        jpnQLNCC.setLayout(jpnQLNCCLayout);
        jpnQLNCCLayout.setHorizontalGroup(
            jpnQLNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLNCCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLNCC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnQLNCCLayout.setVerticalGroup(
            jpnQLNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQLNCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnQLNV.setBackground(new java.awt.Color(3, 169, 244));
        jpnQLNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnQLNV.setPreferredSize(new java.awt.Dimension(220, 60));

        jlbQLNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbQLNV.setForeground(new java.awt.Color(255, 255, 255));
        jlbQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/staff.png"))); // NOI18N
        jlbQLNV.setText("Nhân Viên");

        javax.swing.GroupLayout jpnQLNVLayout = new javax.swing.GroupLayout(jpnQLNV);
        jpnQLNV.setLayout(jpnQLNVLayout);
        jpnQLNVLayout.setHorizontalGroup(
            jpnQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLNV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnQLNVLayout.setVerticalGroup(
            jpnQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQLNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnQLNH.setBackground(new java.awt.Color(3, 169, 244));
        jpnQLNH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnQLNH.setPreferredSize(new java.awt.Dimension(220, 60));

        jlbQLNH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbQLNH.setForeground(new java.awt.Color(255, 255, 255));
        jlbQLNH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/truck.png"))); // NOI18N
        jlbQLNH.setText("Nhập Hàng");

        javax.swing.GroupLayout jpnQLNHLayout = new javax.swing.GroupLayout(jpnQLNH);
        jpnQLNH.setLayout(jpnQLNHLayout);
        jpnQLNHLayout.setHorizontalGroup(
            jpnQLNHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLNHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLNH, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnQLNHLayout.setVerticalGroup(
            jpnQLNHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQLNH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnKM.setBackground(new java.awt.Color(3, 169, 244));
        jpnKM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnKM.setPreferredSize(new java.awt.Dimension(220, 60));

        jlbKM.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbKM.setForeground(new java.awt.Color(255, 255, 255));
        jlbKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/marketing.png"))); // NOI18N
        jlbKM.setText("Khuyến Mãi");

        javax.swing.GroupLayout jpnKMLayout = new javax.swing.GroupLayout(jpnKM);
        jpnKM.setLayout(jpnKMLayout);
        jpnKMLayout.setHorizontalGroup(
            jpnKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbKM, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jpnKMLayout.setVerticalGroup(
            jpnKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbKM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnTK.setBackground(new java.awt.Color(3, 169, 244));
        jpnTK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnTK.setPreferredSize(new java.awt.Dimension(220, 60));

        jlbTK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbTK.setForeground(new java.awt.Color(255, 255, 255));
        jlbTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/analytics.png"))); // NOI18N
        jlbTK.setText("Thống Kê");

        javax.swing.GroupLayout jpnTKLayout = new javax.swing.GroupLayout(jpnTK);
        jpnTK.setLayout(jpnTKLayout);
        jpnTKLayout.setHorizontalGroup(
            jpnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTKLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTK, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnTKLayout.setVerticalGroup(
            jpnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTK, javax.swing.GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
        );

        jLbTK.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLbTK.setForeground(new java.awt.Color(255, 255, 255));
        jLbTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/rsz_logo.png"))); // NOI18N
        jLbTK.setPreferredSize(new java.awt.Dimension(225, 80));

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnQLBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnQLHH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnQLKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnQLNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnQLNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnQLNH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLbTK, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLbTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelHeader.setBackground(new java.awt.Color(3, 169, 244));
        jPanelHeader.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelHeader.setPreferredSize(new java.awt.Dimension(980, 60));

        jlbInfo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbInfo.setForeground(new java.awt.Color(255, 255, 255));
        jlbInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/profile.png"))); // NOI18N
        jlbInfo.setText("Nguyễn Hoàng Tiến");
        jlbInfo.setToolTipText("");
        jlbInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jlbLogout.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jlbLogout.setForeground(new java.awt.Color(255, 255, 255));
        jlbLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/logout.png"))); // NOI18N
        jlbLogout.setText("Đăng Xuất");
        jlbLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(586, Short.MAX_VALUE)
                .addComponent(jlbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jlbLogout)
                .addContainerGap())
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLogout)
                    .addComponent(jlbInfo))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelRootLayout = new javax.swing.GroupLayout(jPanelRoot);
        jPanelRoot.setLayout(jPanelRootLayout);
        jPanelRootLayout.setHorizontalGroup(
            jPanelRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRootLayout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRootLayout.createSequentialGroup()
                    .addGap(0, 220, Short.MAX_VALUE)
                    .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelRootLayout.setVerticalGroup(
            jPanelRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRootLayout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelRootLayout.createSequentialGroup()
                    .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 644, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLbTK;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelRoot;
    private javax.swing.JLabel jlbInfo;
    private javax.swing.JLabel jlbKM;
    private javax.swing.JLabel jlbLogout;
    private javax.swing.JLabel jlbQLBH;
    private javax.swing.JLabel jlbQLHH;
    private javax.swing.JLabel jlbQLKH;
    private javax.swing.JLabel jlbQLNCC;
    private javax.swing.JLabel jlbQLNH;
    private javax.swing.JLabel jlbQLNV;
    private javax.swing.JLabel jlbTK;
    private javax.swing.JPanel jpnKM;
    private javax.swing.JPanel jpnQLBH;
    private javax.swing.JPanel jpnQLHH;
    private javax.swing.JPanel jpnQLKH;
    private javax.swing.JPanel jpnQLNCC;
    private javax.swing.JPanel jpnQLNH;
    private javax.swing.JPanel jpnQLNV;
    private javax.swing.JPanel jpnTK;
    // End of variables declaration//GEN-END:variables
}
