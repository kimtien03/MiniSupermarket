
package com.myproject.GUI.QuanLy.QuanLyPanels;

import com.myproject.BUS.CTHD_BanHangBUS;
import com.myproject.BUS.HangHoaBUS;
import com.myproject.BUS.HoaDonBanHangBUS;
import com.myproject.BUS.KhuyenMaiBUS;
import com.myproject.DTO.CTHD_BanHangDTO;
import com.myproject.DTO.HangHoaTongDTO;
import com.myproject.DTO.HoaDonBanHangDTO;
import com.myproject.DTO.KhuyenMaiDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class QLBanHangPanel extends javax.swing.JPanel {

    HoaDonBanHangBUS HDGUI = new HoaDonBanHangBUS();
    List<HoaDonBanHangDTO> hoaDonList = HDGUI.getList();
    CTHD_BanHangBUS CTHDGUI = new CTHD_BanHangBUS();
    List<CTHD_BanHangDTO> ct_hoaDonList = CTHDGUI.getList();
    KhuyenMaiBUS KMGUI = new KhuyenMaiBUS();
    HangHoaBUS HHGUI = new HangHoaBUS();
    List<HangHoaTongDTO> hangHoaList = HHGUI.getAllHangHoa();

    /**
     * Creates new form QLBanHangPanel
     */
    public QLBanHangPanel() {
        initComponents();
        loadHD();
        setupHDTableClickListener();
        jtfSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchHD();
            }
        });
        ComboboxStaff();
        jdcDateFounded.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("date")) {
                    loadHDBySelectedDate(jdcDateFounded.getDate());
                }
            }
        });

    }

    private void loadHD() {
        DefaultTableModel table = (DefaultTableModel) jtbHD.getModel();
        table.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng Chi Tiết Hóa Đơn
        for (HoaDonBanHangDTO hd : hoaDonList) {
            Object[] rowData = {hd.getMaHD(), hd.getNgLap(), hd.getThanhTien(),hd.getMaKH(), hd.getMaNV()};
            table.addRow(rowData);
        }
        jtbHD.setModel(table);
    }

    private void setupHDTableClickListener() {
        jtbHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jtbHD.getSelectedRow();
                if (e.getClickCount() == 2 && selectedRow != -1) {
                    String maHD = (String) jtbHD.getValueAt(selectedRow, 0);
                    loadCTHD(maHD);
                    jtbHD.clearSelection();
                }
            }
        });

    }

    private void loadCTHD(String maHD) {
        DefaultTableModel table = (DefaultTableModel) jtbCTHD.getModel();
        table.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng Chi Tiết Hóa Đơn
        for (CTHD_BanHangDTO cthd : ct_hoaDonList) {
            if (cthd.getMaHD().trim().equals(maHD.trim())) {
                for (HangHoaTongDTO hht : hangHoaList) {
                    if (cthd.getMaCT_HH().trim().equals(hht.getMaCT_HH().trim())) {
                        Object[] rowcthd = {hht.getMaHH(), hht.getTenHH(), cthd.getSLBan(), cthd.getDonGia()};
                        table.addRow(rowcthd);
                    }
                }
            }
        }
        jtbCTHD.setModel(table);
    }

    public void searchHD() {
        DefaultTableModel table = (DefaultTableModel) jtbHD.getModel();
        table.setRowCount(0); // Xóa tất cả các hàng khỏi bảng
        String searchText = jtfSearch.getText().trim().toLowerCase();
        for (HoaDonBanHangDTO hd : hoaDonList) {
            if (hd.getMaHD().toLowerCase().contains(searchText)) {
                Object[] rowData = {hd.getMaHD(), hd.getNgLap(), hd.getThanhTien(),hd.getMaKH(), hd.getMaNV()};
                table.addRow(rowData);
            }
        }
        jtbHD.setModel(table);
    }

    public void ComboboxStaff() {
        jcbboxStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedStaff = (String) jcbboxStaff.getSelectedItem();
                DefaultTableModel table = (DefaultTableModel) jtbHD.getModel();
                table.setRowCount(0); // Xóa tất cả các hàng khỏi bảng

                for (HoaDonBanHangDTO hd : hoaDonList) {
                    if ("Tất Cả".equals(selectedStaff)) {
                        addRowToTable(hd, table);
                    } else if (selectedStaff.trim().equals(hd.getMaNV().trim())) {
                        addRowToTable(hd, table);
                    }
                }
            }
        }
        );
    }

    private void addRowToTable(HoaDonBanHangDTO hd, DefaultTableModel table) {
        Object[] rowData = {hd.getMaHD(), hd.getNgLap(), hd.getThanhTien(), hd.getMaKH(), hd.getMaNV()};
        table.addRow(rowData);
    }

    private void loadHDBySelectedDate(Date selectedDate) {
        DefaultTableModel table = (DefaultTableModel) jtbHD.getModel();
        table.setRowCount(0); // Xóa tất cả các hàng khỏi bảng

        for (HoaDonBanHangDTO hd : hoaDonList) {
            if (hd.getNgLap() != null && isSameDay(hd.getNgLap(), selectedDate)) {
                addRowToTable(hd, table);
            }
        }
    }

    private boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnHD = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbHD = new javax.swing.JTable();
        jpnCTHD = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbCTHD = new javax.swing.JTable();
        jpnAct = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jcbboxStaff = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jdcDateFounded = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 640));

        jpnHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa Đơn"));

        jtbHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Ngày Lập", "Thành Tiền", "Mã Khách Hàng", "Mã Nhân Viên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
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
        jtbHD.setToolTipText("");
        jScrollPane1.setViewportView(jtbHD);

        javax.swing.GroupLayout jpnHDLayout = new javax.swing.GroupLayout(jpnHD);
        jpnHD.setLayout(jpnHDLayout);
        jpnHDLayout.setHorizontalGroup(
            jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jpnHDLayout.setVerticalGroup(
            jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHDLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnCTHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Tiết Hóa Đơn"));

        jtbCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hàng Hóa", "Tên Hàng Hóa", "Số lượng", "Đơn Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
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
        jScrollPane2.setViewportView(jtbCTHD);

        javax.swing.GroupLayout jpnCTHDLayout = new javax.swing.GroupLayout(jpnCTHD);
        jpnCTHD.setLayout(jpnCTHDLayout);
        jpnCTHDLayout.setHorizontalGroup(
            jpnCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCTHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jpnCTHDLayout.setVerticalGroup(
            jpnCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCTHDLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnAct.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/search.png"))); // NOI18N

        jtfSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfSearch.setToolTipText("Search here...");
        jtfSearch.setBorder(null);
        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfSearch)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setText("Ngày Lập");

        jcbboxStaff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "NV01", "NV02", "NV03", "NV04" }));
        jcbboxStaff.setBorder(null);

        jLabel4.setText("Nhân Viên");

        jdcDateFounded.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jpnActLayout = new javax.swing.GroupLayout(jpnAct);
        jpnAct.setLayout(jpnActLayout);
        jpnActLayout.setHorizontalGroup(
            jpnActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnActLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jcbboxStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcDateFounded, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpnActLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnActLayout.setVerticalGroup(
            jpnActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnActLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcDateFounded, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jcbboxStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnAct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnCTHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jpnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed

    }//GEN-LAST:event_jtfSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbboxStaff;
    private com.toedter.calendar.JDateChooser jdcDateFounded;
    private javax.swing.JPanel jpnAct;
    private javax.swing.JPanel jpnCTHD;
    private javax.swing.JPanel jpnHD;
    private javax.swing.JTable jtbCTHD;
    private javax.swing.JTable jtbHD;
    private javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
