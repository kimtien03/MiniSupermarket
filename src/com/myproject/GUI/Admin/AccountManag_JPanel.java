package com.myproject.GUI.Admin;

import com.myproject.BUS.NhanVienBUS;
import com.myproject.DTO.NhanVienDTO;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AccountManag_JPanel extends javax.swing.JPanel {
    private NhanVienBUS nhanVienBUS = new NhanVienBUS();
    // liên quan đến bảng
    private DefaultTableModel tableModelStaff;
    private int seclectRowStaffTable;
        
    public AccountManag_JPanel() {
        initComponents();
        // đẩy dữ liệu lên bảng
        this.tableInitialization();
        this.loadDataToTable(nhanVienBUS.getStaffArrayList());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        position_JCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        StaffID_JTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        StaffName_JTF = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Staff_JTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        refeshPage_JBTN = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(916, 650));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickedOutSide(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Chức vụ");

        position_JCB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        position_JCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân viên bán hàng", "Nhân viên kho", "Quản trị viên" }));
        position_JCB.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        StaffID_JTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        StaffID_JTF.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Họ và tên");

        StaffName_JTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        StaffName_JTF.setBorder(null);

        Staff_JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Họ tên", "Chức vụ ", "Khóa TK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Staff_JTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Staff_JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickedRowOnTable(evt);
            }
        });
        jScrollPane1.setViewportView(Staff_JTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/padlock.png"))); // NOI18N
        jButton4.setText("Khóa tài khoản");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockAccount(evt);
            }
        });

        refeshPage_JBTN.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        refeshPage_JBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/reload.png"))); // NOI18N
        refeshPage_JBTN.setText("Làm mới");
        refeshPage_JBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refeshPage_JBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refeshPage(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/unlock.png"))); // NOI18N
        jButton5.setText("Mở khóa tài khoản");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAccount(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findStaff(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Lọc nhân viên");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterEmployeesByPosition(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(StaffName_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(position_JCB, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(StaffID_JTF, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(refeshPage_JBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(StaffID_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(position_JCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(StaffName_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(refeshPage_JBTN)
                    .addComponent(jButton5))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void openAccount(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAccount
        int selectedRow = this.Staff_JTable.getSelectedRow();
        if(selectedRow != -1) {  
            String MaNV = (String) this.tableModelStaff.getValueAt(selectedRow, 0);
            NhanVienDTO staff = nhanVienBUS.getStaffInfoBYID(MaNV);
            if(!staff.getKhoaTK()) {
                JOptionPane.showMessageDialog(null, "TÀI KHOẢN ĐÃ ĐƯỢC MỞ!");
            } else {
                staff.setKhoaTK(false);
                if(nhanVienBUS.blockAccount(staff) != -1) {
                    JOptionPane.showMessageDialog(null, "MỞ KHÓA TÀI KHOẢN THÀNH CÔNG!");
                    loadDataToTable(nhanVienBUS.getStaffArrayList());
                } else {
                    JOptionPane.showMessageDialog(null, "MỞ KHÓA TÀI KHOẢN KHÔNG THÀNH CÔNG!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "VUI LÒNG CHỌN"
                    + " NHÂN VIÊN MUỐN MỞ KHÓA TÀI KHOẢN!");
        }
        this.Staff_JTable.clearSelection();
    }//GEN-LAST:event_openAccount

    private void refeshPage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refeshPage
        this.Staff_JTable.clearSelection();
        this.StaffID_JTF.setText("");
        this.StaffName_JTF.setText("");
        this.position_JCB.setSelectedIndex(0);
        loadDataToTable(nhanVienBUS.getStaffArrayList());
    }//GEN-LAST:event_refeshPage
    
    private void blockAccount(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockAccount
        int selectedRow = this.Staff_JTable.getSelectedRow();
        if(selectedRow != -1) {
            String MaNV = (String) this.tableModelStaff.getValueAt(selectedRow, 0);
            NhanVienDTO staff = nhanVienBUS.getStaffInfoBYID(MaNV);
            if(staff.getKhoaTK()) {
                JOptionPane.showMessageDialog(null, "TÀI KHOẢN ĐÃ BỊ KHÓA!");
            } else {
                staff.setKhoaTK(true);
                if(nhanVienBUS.blockAccount(staff) != -1) {
                    JOptionPane.showMessageDialog(null, "KHÓA TÀI KHOẢN THÀNH CÔNG!");
                    loadDataToTable(nhanVienBUS.getStaffArrayList());
                } else {
                    JOptionPane.showMessageDialog(null, "KHÓA TÀI KHOẢN KHÔNG THÀNH CÔNG!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "VUI LÒNG CHỌN"
                    + " NHÂN VIÊN MUỐN KHÓA TÀI KHOẢN!");
        }
        this.Staff_JTable.clearSelection();
    }//GEN-LAST:event_blockAccount

    private void clickedRowOnTable(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickedRowOnTable
        int selectedRow = this.Staff_JTable.getSelectedRow();
        if(selectedRow != -1) {
            this.StaffID_JTF.setText((String) this.tableModelStaff.getValueAt(selectedRow, 0));
            this.StaffName_JTF.setText((String) this.tableModelStaff.getValueAt(selectedRow, 1));
            String chucVu = (String) this.tableModelStaff.getValueAt(selectedRow, 2);
            if (chucVu.trim().equalsIgnoreCase("Quản lý")) {
                this.position_JCB.setSelectedIndex(0);
            }
            else if (chucVu.trim().equalsIgnoreCase("Nhân viên bán hàng")) {
                this.position_JCB.setSelectedIndex(1);
            }
            else if (chucVu.trim().equalsIgnoreCase("Nhân viên kho")) {
                this.position_JCB.setSelectedIndex(2);
            }
            else {
                this.position_JCB.setSelectedIndex(3);
            }
        }
    }//GEN-LAST:event_clickedRowOnTable

    private void clickedOutSide(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickedOutSide
        this.Staff_JTable.clearSelection();
        this.StaffID_JTF.setText("");
        this.StaffName_JTF.setText("");
        this.position_JCB.setSelectedIndex(0);
        loadDataToTable(nhanVienBUS.getStaffArrayList());
    }//GEN-LAST:event_clickedOutSide

    private void findStaff(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findStaff
        if(!this.StaffID_JTF.getText().isEmpty() && this.StaffName_JTF.getText().isEmpty()) {
            String staffId = this.StaffID_JTF.getText();
            loadDataToTable(nhanVienBUS.getStaffArrayListByID(staffId));
        } else if(this.StaffID_JTF.getText().isEmpty() && !this.StaffName_JTF.getText().isEmpty()) {
            String staffName = this.StaffName_JTF.getText();
            loadDataToTable(nhanVienBUS.getStaffArrayListByName(staffName));
        } else if(this.StaffID_JTF.getText().isEmpty() && this.StaffName_JTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP THÔNG TIN TÌM KIẾM!");
        } else if(!this.StaffID_JTF.getText().isEmpty() && !this.StaffName_JTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CHỈ NHẬP TÊN HOẶC MÃ NHÂN VIÊN ĐỂ TÌM KIẾM!");
            this.StaffID_JTF.setText("");
            this.StaffName_JTF.setText("");
        }
    }//GEN-LAST:event_findStaff

    private void filterEmployeesByPosition(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterEmployeesByPosition
        String position = (String) this.position_JCB.getSelectedItem();
        loadDataToTable(nhanVienBUS.getStaffArrayListByPosition(position));
    }//GEN-LAST:event_filterEmployeesByPosition

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField StaffID_JTF;
    private javax.swing.JTextField StaffName_JTF;
    private javax.swing.JTable Staff_JTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> position_JCB;
    private javax.swing.JButton refeshPage_JBTN;
    // End of variables declaration//GEN-END:variables

    // PHƯƠNG THỨC
    // Xử lý đẩy dữ liệu lên bảng
    public void tableInitialization() {
        this.tableModelStaff = (DefaultTableModel) this.Staff_JTable.getModel();
        this.seclectRowStaffTable = -1;
    }
    
    public Object loadStaffInfoToRow(NhanVienDTO staffItem) {
        String block = (staffItem.getKhoaTK()) ? "Khóa" : "Mở";
        Object[] row = new Object[] {
            staffItem.getMaNV(), staffItem.getTenNV(), staffItem.getChucVu(),
            block
        };
        return row;
    }
    
    public void loadDataToTable(ArrayList<NhanVienDTO> staffArrayList) {
        this.tableModelStaff.setRowCount(0);
        for (NhanVienDTO staffItem : staffArrayList) {
            Object[] row = (Object[]) loadStaffInfoToRow(staffItem);
            this.tableModelStaff.addRow(row);
        }
    }
    
    // hủy hết tất cả các sự kiện 
    public void destroyAllEvent() {
        this.position_JCB.setSelectedIndex(-1);
    }
}
