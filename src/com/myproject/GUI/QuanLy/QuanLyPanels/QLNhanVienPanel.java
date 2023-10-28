/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.myproject.GUI.QuanLy.QuanLyPanels;

import com.myproject.BUS.NhanVienBUS;
import com.myproject.DTO.NhaCungCapDTO;
import com.myproject.DTO.NhanVienDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class QLNhanVienPanel extends javax.swing.JPanel {

    NhanVienBUS NVBUS = new NhanVienBUS();
    List<NhanVienDTO> nvlist = NVBUS.getList();

    public QLNhanVienPanel() {
        initComponents();
        loadNV();
        SearchNv();
        ComboboxNv();
    }

    public void loadNV() {
        DefaultTableModel table = (DefaultTableModel) jtbStaff.getModel();
        for (NhanVienDTO nv : nvlist) {
            Object[] rowData = {nv.getMaNV(), nv.getTenNV(), nv.getNgSinh(), nv.getGioitinh(), nv.getSDT(), nv.getEmail(), nv.getChucVu(), nv.isTinhTrang()};
            table.addRow(rowData);
        }
    }

    public void SearchNv() {
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFilter();
            }

            private void updateFilter() {
                String text = jtfSearch.getText().toLowerCase(); // Lấy nội dung tìm kiếm và chuyển thành chữ thường
                DefaultTableModel tableModel = (DefaultTableModel) jtbStaff.getModel();
                TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);
                jtbStaff.setRowSorter(rowSorter);
                List<RowFilter<Object, Object>> filters = new ArrayList<>();
                filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(text), 0)); // Tìm kiếm trên cột 0
                filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(text), 1)); // Tìm kiếm trên cột 1
                filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(text), 2)); // Tìm kiếm trên cột 2
                filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(text), 4));
                filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(text), 5)); // Tìm kiếm trên cột 2
                filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(text), 6));
                RowFilter<Object, Object> combinedFilter = RowFilter.orFilter(filters);
                rowSorter.setRowFilter(combinedFilter);
            }
        });
    }

    public void resetFix() {
        String selectedTrangThai = (String) jcbboxFilter.getSelectedItem();
        DefaultTableModel tableModel = (DefaultTableModel) jtbStaff.getModel();
        // Làm sạch dữ liệu trong bảng
        tableModel.setRowCount(0);
        if (selectedTrangThai.equals("Đang hoạt động")) {

            for (NhanVienDTO nv : nvlist) {
                if (nv.isTinhTrang()) { // Kiểm tra nếu tình trạng là 1 (đang hoạt động)
                    Object[] rowData = {nv.getMaNV(), nv.getTenNV(), nv.getNgSinh(), nv.getGioitinh(), nv.getSDT(), nv.getEmail(), nv.getChucVu(), nv.isTinhTrang()};
                    tableModel.addRow(rowData);
                }
            }
        } else if (selectedTrangThai.equals("Ngừng hoạt động")) {
            for (NhanVienDTO nv : nvlist) {
                if (!nv.isTinhTrang()) { // Kiểm tra nếu tình trạng là 0 (ngung đang hoạt động)
                    Object[] rowData = {nv.getMaNV(), nv.getTenNV(), nv.getNgSinh(), nv.getGioitinh(), nv.getSDT(), nv.getEmail(), nv.getChucVu(), nv.isTinhTrang()};
                    tableModel.addRow(rowData);
                }
            }
        } else {
            // Hiển thị toàn bộ dữ liệu nếu chọn "Tất cả"
            for (NhanVienDTO nv : nvlist) {
                Object[] rowData = {nv.getMaNV(), nv.getTenNV(), nv.getNgSinh(), nv.getGioitinh(), nv.getSDT(), nv.getEmail(), nv.getChucVu(), nv.isTinhTrang()};
                tableModel.addRow(rowData);
            }
        }
    }

    public void ComboboxNv() {
        jcbboxFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTrangThai = (String) jcbboxFilter.getSelectedItem();
                DefaultTableModel tableModel = (DefaultTableModel) jtbStaff.getModel();
                // Làm sạch dữ liệu trong bảng
                tableModel.setRowCount(0);
                if (selectedTrangThai.equals("Đang hoạt động")) {

                    for (NhanVienDTO nv : nvlist) {
                        if (nv.isTinhTrang()) { // Kiểm tra nếu tình trạng là 1 (đang hoạt động)
                            Object[] rowData = {nv.getMaNV(), nv.getTenNV(), nv.getNgSinh(), nv.getGioitinh(), nv.getSDT(), nv.getEmail(), nv.getChucVu(), nv.isTinhTrang()};
                            tableModel.addRow(rowData);
                        }
                    }
                } else if (selectedTrangThai.equals("Ngừng hoạt động")) {
                    for (NhanVienDTO nv : nvlist) {
                        if (!nv.isTinhTrang()) { // Kiểm tra nếu tình trạng là 0 (ngung đang hoạt động)
                            Object[] rowData = {nv.getMaNV(), nv.getTenNV(), nv.getNgSinh(), nv.getGioitinh(), nv.getSDT(), nv.getEmail(), nv.getChucVu(), nv.isTinhTrang()};
                            tableModel.addRow(rowData);
                        }
                    }
                } else {
                    // Hiển thị toàn bộ dữ liệu nếu chọn "Tất cả"
                    for (NhanVienDTO nv : nvlist) {
                        Object[] rowData = {nv.getMaNV(), nv.getTenNV(), nv.getNgSinh(), nv.getGioitinh(), nv.getSDT(), nv.getEmail(), nv.getChucVu(), nv.isTinhTrang()};
                        tableModel.addRow(rowData);
                    }
                }
            }
        });
    }

    public boolean exportToExcel(JTable table, String filePath) {
        try {
            File excelFile = new File(filePath);
            Workbook workbook;
            if (excelFile.exists()) {
                FileInputStream inputStream = new FileInputStream(excelFile);
                workbook = WorkbookFactory.create(inputStream);
                inputStream.close();
                String newSheetName = "NhanVien";
                boolean sheetExists = false;
                Iterator<Sheet> sheetIterator = workbook.sheetIterator();
                while (sheetIterator.hasNext()) {
                    if (sheetIterator.next().getSheetName().equals(newSheetName)) {
                        sheetExists = true;
                        break;
                    }
                }
                if (sheetExists) {
                    workbook.removeSheetAt(workbook.getSheetIndex(newSheetName));
                }
            } else {
                workbook = new XSSFWorkbook();
            }

            Sheet sheet = workbook.createSheet("NhanVien");
            if (isExcelFileInUse(new File(filePath))) {
                JOptionPane.showMessageDialog(null, "Tệp Excel đang mở. Hãy đóng tệp Excel trước khi xuất.");
                return false;
            }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Row titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("Danh Sách Nhân Viên");
            Row headerRow = sheet.createRow(1);
            String[] columnHeaders = {"Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Gioi Tính", "STD", "Email", "Chuc Vu", "Tinh Trang"};
            for (int i = 0; i < columnHeaders.length; i++) {
                Cell headerCell = headerRow.createCell(i);
                headerCell.setCellValue(columnHeaders[i]);
            }
            CellStyle titleCellStyle = workbook.createCellStyle();
            titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
            titleCell.setCellStyle(titleCellStyle);
            for (int row = 0; row < model.getRowCount(); row++) {
                Row dataRow = sheet.createRow(row + 2);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Cell cell = dataRow.createCell(col);
                    cell.setCellValue(model.getValueAt(row, col).toString());
                }
            }
            for (int col = 0; col < model.getColumnCount(); col++) {
                sheet.autoSizeColumn(col);
            }

            FileOutputStream output = new FileOutputStream(excelFile);
            workbook.write(output);
            output.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
// Hàm kiểm tra định dạng số điện thoại

    private boolean isValidPhoneNumber(String phoneNumber) {
        String phonePattern = "^[0-9]{10}$"; // Kiểm tra chuỗi có đúng 10 chữ số
        return phoneNumber.matches(phonePattern);
    }

// Hàm kiểm tra định dạng email
    private boolean isValidEmail(String email) {
        // Sử dụng biểu thức chính quy để kiểm tra email (ví dụ)
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailPattern);
    }

    //hàm tang ma
    private String generateNewMaNV() {
        int rowCount = nvlist.size();
        int newSequence = rowCount + 1;
        return "NV" + String.format("%02d", newSequence);
    }

    public boolean isExcelFileInUse(File file) {
        boolean isFileLocked = true;
        try ( RandomAccessFile raf = new RandomAccessFile(file, "rw");  FileChannel channel = raf.getChannel()) {
            FileLock lock = channel.tryLock();
            isFileLocked = lock == null;
        } catch (IOException e) {
            // Xử lý ngoại lệ
        }
        return isFileLocked;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        MaNvText = new javax.swing.JTextField();
        TenNvText = new javax.swing.JTextField();
        EmailNvText = new javax.swing.JTextField();
        SdtNvText = new javax.swing.JTextField();
        GtNvCbb = new javax.swing.JComboBox<>();
        NgSinhNvChoose = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        CVNvCbb = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jDialog2 = new javax.swing.JDialog();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        MaNvFix = new javax.swing.JTextField();
        SdtNvFix = new javax.swing.JTextField();
        TenNvFix = new javax.swing.JTextField();
        EmailNvFix = new javax.swing.JTextField();
        GTNvFix = new javax.swing.JComboBox<>();
        NgSNvFix = new com.toedter.calendar.JDateChooser();
        CvNvFix = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        TTNvFix = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jbttnAdd = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jbttnFix = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jbttnExport = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcbboxFilter = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbStaff = new javax.swing.JTable();

        jDialog1.setMinimumSize(new java.awt.Dimension(750, 350));
        jDialog1.setModal(true);

        jPanel11.setPreferredSize(new java.awt.Dimension(750, 330));

        jPanel12.setBackground(new java.awt.Color(3, 169, 244));
        jPanel12.setPreferredSize(new java.awt.Dimension(752, 80));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/staff.png"))); // NOI18N
        jLabel10.setText("Thêm Nhân Viên");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 258, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin"));

        jLabel11.setText("Mã Nhân Viên");

        jLabel12.setText("Số Điện Thoại");

        jLabel13.setText("Họ Tên");

        jLabel14.setText("Ngày Sinh");

        jLabel3.setText("Giới tính");

        jLabel4.setText("Email");

        MaNvText.setEnabled(false);

        GtNvCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nu" }));

        NgSinhNvChoose.setDateFormatString("dd-MM-yyyy");

        jLabel8.setText("Chức Vụ");

        CVNvCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Nhân Viên Kho", "Nhân Viên Bán Hàng", "Quản Trị Viên" }));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TenNvText)
                    .addComponent(MaNvText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GtNvCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addGap(26, 26, 26)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SdtNvText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EmailNvText)
                            .addComponent(NgSinhNvChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(CVNvCbb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(EmailNvText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(CVNvCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(SdtNvText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(NgSinhNvChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(MaNvText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TenNvText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GtNvCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jDialog2.setMinimumSize(new java.awt.Dimension(750, 340));
        jDialog2.setModal(true);

        jPanel15.setBackground(new java.awt.Color(3, 169, 244));
        jPanel15.setPreferredSize(new java.awt.Dimension(752, 80));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/staff.png"))); // NOI18N
        jLabel15.setText("Sửa Nhân Viên");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 258, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin"));

        jLabel16.setText("Mã Nhân Viên");

        jLabel17.setText("Số Điện Thoại");

        jLabel18.setText("Họ Tên");

        jLabel19.setText("Ngày Sinh");

        jLabel5.setText("Giới tính");

        jLabel6.setText("Email");

        jLabel7.setText("Chức vụ");

        MaNvFix.setEnabled(false);

        TenNvFix.setPreferredSize(new java.awt.Dimension(30, 22));

        EmailNvFix.setPreferredSize(new java.awt.Dimension(30, 22));

        GTNvFix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nu" }));

        NgSNvFix.setDateFormatString("dd-MM-yyyy");

        CvNvFix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Nhân Viên Kho", "Nhân Viên Bán Hàng", "Quản trị Viên" }));

        jLabel9.setText("Tình trạng");

        TTNvFix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hoạt động", "Ngừng hoạt động" }));
        TTNvFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TTNvFixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GTNvFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TenNvFix, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaNvFix, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EmailNvFix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SdtNvFix)
                    .addComponent(NgSNvFix, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CvNvFix, 0, 148, Short.MAX_VALUE)
                    .addComponent(TTNvFix, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(EmailNvFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(CvNvFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(SdtNvFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(TTNvFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(NgSNvFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(MaNvFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(GTNvFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(TenNvFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/fix.png"))); // NOI18N
        jButton3.setText("Sửa");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 640));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        jToolBar1.setRollover(true);

        jbttnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus.png"))); // NOI18N
        jbttnAdd.setText("Thêm");
        jbttnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnAdd.setFocusable(false);
        jbttnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbttnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbttnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(jbttnAdd);
        jToolBar1.add(jSeparator1);

        jbttnFix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/fix.png"))); // NOI18N
        jbttnFix.setText("Sửa");
        jbttnFix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnFix.setFocusable(false);
        jbttnFix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbttnFix.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbttnFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnFixActionPerformed(evt);
            }
        });
        jToolBar1.add(jbttnFix);
        jToolBar1.add(jSeparator3);

        jbttnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/xls-file.png"))); // NOI18N
        jbttnExport.setText("Excel");
        jbttnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbttnExport.setFocusable(false);
        jbttnExport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbttnExport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbttnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttnExportActionPerformed(evt);
            }
        });
        jToolBar1.add(jbttnExport);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/search.png"))); // NOI18N

        jtfSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfSearch.setToolTipText("Search here...");
        jtfSearch.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setText("Lọc");

        jcbboxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang hoạt động", "Ngừng hoạt động" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jcbboxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbboxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jtbStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Giới Tính", "Số Điện Thoại", "Email", "Chức vụ", "Tình trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbStaff.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbStaffMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbStaff);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbttnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnAddActionPerformed
        String newMaNV = generateNewMaNV();
        MaNvText.setText(newMaNV);
        JTextField dateTextField = (JTextField) NgSinhNvChoose.getDateEditor().getUiComponent();
        dateTextField.setEditable(false);
        dateTextField.setText("");
        TenNvText.setText("");
        EmailNvText.setText("");
        SdtNvText.setText("");
        CVNvCbb.setSelectedIndex(0);
        GtNvCbb.setSelectedIndex(0);
        jDialog1.setLocationRelativeTo(null);
        jDialog1.setVisible(true);
    }//GEN-LAST:event_jbttnAddActionPerformed

    private void jbttnFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnFixActionPerformed
        if (jtbStaff.getSelectedRow() != -1) {
            int selectedRow = jtbStaff.getSelectedRow();
            // Lấy thông tin từ dòng đã chọn
            String maNV = (String) jtbStaff.getValueAt(selectedRow, 0);
            String tenNV = (String) jtbStaff.getValueAt(selectedRow, 1);
            Date Ngsinh = (Date) jtbStaff.getValueAt(selectedRow, 2);
            String Gioitinh = (String) jtbStaff.getValueAt(selectedRow, 3);
            String sdt = (String) jtbStaff.getValueAt(selectedRow, 4);
            String email = (String) jtbStaff.getValueAt(selectedRow, 5);
            String chucvu = (String) jtbStaff.getValueAt(selectedRow, 6);
            int tinhTrang = (boolean) jtbStaff.getValueAt(selectedRow, 7) ? 1 : 0;
            if (tinhTrang == 1) {
                TTNvFix.setSelectedItem("Đang hoạt động");
            } else {
                TTNvFix.setSelectedItem("Ngừng hoạt động");
            }
            JTextField dateTextField = (JTextField) NgSNvFix.getDateEditor().getUiComponent();
            dateTextField.setEditable(false);
            // Điền thông tin vào các trường trên jDialog2
            MaNvFix.setText(maNV);
            TenNvFix.setText(tenNV);
            NgSNvFix.setDate(Ngsinh);
            if ("Nam".equals(Gioitinh.trim())) {
                GTNvFix.setSelectedItem("Nam");
            } else if ("Nu".equals(Gioitinh.trim())) {
                GTNvFix.setSelectedItem("Nu");
            }
            if ("Quản Lý".equals(chucvu)) {
                CvNvFix.setSelectedItem("Quản Lý");
            } else if ("Nhân Viên Kho".equals(chucvu)) {
                CvNvFix.setSelectedItem("Nhân Viên Kho");
            } else if ("Nhân Viên Bán Hàng".equals(chucvu)) {
                CvNvFix.setSelectedItem("Nhân Viên Bán Hàng");
            } else if ("Quản trị Viên".equals(chucvu)) {
                CvNvFix.setSelectedItem("Quản trị Viên");
            }
            EmailNvFix.setText(email);
            EmailNvFix.setCaretPosition(0);
            SdtNvFix.setText(sdt);

            jDialog2.setLocationRelativeTo(null);
            jDialog2.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhân viên để sửa!");
        }
    }//GEN-LAST:event_jbttnFixActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (TenNvText.getText().isEmpty() || NgSinhNvChoose.getDate() == null || SdtNvText.getText().isEmpty() || EmailNvText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin!");
        } else {
            String sdt = SdtNvText.getText();
            String email = EmailNvText.getText();
            boolean isDataValid = true;
            // Kiểm tra định dạng số điện thoại
            if (!isValidPhoneNumber(sdt)) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!");
                isDataValid = false;
            }
            // Kiểm tra định dạng email
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email không hợp lệ!");
                isDataValid = false;
            }
            Date ngaySinh = NgSinhNvChoose.getDate();
            if (ngaySinh != null) {
                Calendar calNgaySinh = Calendar.getInstance();
                calNgaySinh.setTime(ngaySinh);
                Calendar calHienTai = Calendar.getInstance();
                // Kiểm tra xem ngày sinh có hợp lệ
                if (calNgaySinh.after(calHienTai)) {
                    JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ (lớn hơn ngày hiện tại)!");
                    isDataValid = false;
                } else {
                    int namHienTai = calHienTai.get(Calendar.YEAR);
                    int namNgaySinh = calNgaySinh.get(Calendar.YEAR);
                    // Kiểm tra xem ngày sinh có hợp lệ (lớn hơn 10 năm)
                    if (namHienTai - namNgaySinh < 18) {
                        JOptionPane.showMessageDialog(null, "Kiểm tra lại ngày sinh vì nhỏ hơn 18 tuổi!");
                        isDataValid = false;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh!");
                isDataValid = false;
            }
            if (isDataValid) {
                // Tiến hành thêm Nhân Viên (NV) với các thông tin tương ứng
                NhanVienDTO newNv = new NhanVienDTO();
                newNv.setMaNV(MaNvText.getText());
                newNv.setTenNV(TenNvText.getText());
                newNv.setSDT(SdtNvText.getText());
                newNv.setEmail(EmailNvText.getText());
                newNv.setTinhTrang(true);
                newNv.setNgSinh(ngaySinh);
                String gioiTinh = (String) GtNvCbb.getSelectedItem();
                newNv.setGioitinh(gioiTinh);
                String chucVu = (String) CVNvCbb.getSelectedItem();
                newNv.setChucVu(chucVu);
                //pass là ngày sinh
                SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
                Date ngaySinhDate = NgSinhNvChoose.getDate();
                String ngaySinhAsString = dateFormat.format(ngaySinhDate);
                newNv.setPasswd(ngaySinhAsString);
                newNv.setMaQuyen(null);
                //defaulf TK chua bi khóa
                newNv.setKhoaTK(false);
                if (NVBUS.AddNvNew(newNv)) {
                    JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
                    // Xóa toàn bộ dữ liệu từ bảng
                    DefaultTableModel tablefilter = (DefaultTableModel) jtbStaff.getModel();
                    tablefilter.setRowCount(0);
                    // Cập nhật dữ liệu trong datanv (nếu cần)
                    nvlist = NVBUS.getList(); // Đảm bảo datanv là danh sách mới sau khi thêm
                    loadNV(); // Load lại dữ liệu vào bảng
                    jDialog1.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm Không Thành Công!");
                }
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (TenNvFix.getText().isEmpty() || NgSNvFix.getDate() == null || SdtNvFix.getText().isEmpty() || EmailNvFix.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin!");
        } else {
            String sdt = SdtNvFix.getText();
            String email = EmailNvFix.getText();
            boolean isDataValid = true;
            // Kiểm tra định dạng số điện thoại
            if (!isValidPhoneNumber(sdt)) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!");
                isDataValid = false;
            }
            // Kiểm tra định dạng email
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email không hợp lệ!");
                isDataValid = false;
            }
            Date ngaySinh = NgSNvFix.getDate();
//            System.out.println(ngaySinh);
            if (ngaySinh != null) {
                Calendar calNgaySinh = Calendar.getInstance();
                calNgaySinh.setTime(ngaySinh);
                Calendar calHienTai = Calendar.getInstance();
                // Kiểm tra xem ngày sinh có hợp lệ
                if (calNgaySinh.after(calHienTai)) {
                    JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ (lớn hơn ngày hiện tại)!");
                    isDataValid = false;
                } else {
                    int namHienTai = calHienTai.get(Calendar.YEAR);
                    int namNgaySinh = calNgaySinh.get(Calendar.YEAR);

                    // Kiểm tra xem ngày sinh có hợp lệ (lớn hơn 10 năm)
                    if (namHienTai - namNgaySinh < 10) {
                        JOptionPane.showMessageDialog(null, "Kiểm tra lại ngày sinh vì nhỏ hơn 10 tuổi!");
                        isDataValid = false;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh!");
                isDataValid = false;
            }
            if (isDataValid) {
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa nhân viên không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // Tiến hành thêm Nhân Viên (NV) với các thông tin tương ứng
                    NhanVienDTO fixNv = new NhanVienDTO();
                    fixNv.setMaNV(MaNvFix.getText());
                    fixNv.setTenNV(TenNvFix.getText());
                    fixNv.setSDT(SdtNvFix.getText());
                    fixNv.setEmail(EmailNvFix.getText());
                    if ("Đang hoạt động".equals(TTNvFix.getSelectedItem())) {
                        fixNv.setTinhTrang(true);
                    } else if ("Ngừng hoạt động".equals(TTNvFix.getSelectedItem())) {
                        fixNv.setTinhTrang(false);
                    }
                    Date ngaySinhDate = NgSNvFix.getDate();
                    fixNv.setNgSinh(ngaySinhDate);
                    if ("Nam".equals(GTNvFix.getSelectedItem())) {
                        fixNv.setGioitinh("Nam");
                    } else {
                        fixNv.setGioitinh("Nu");
                    }
                    if ("Quản Lý".equals(CvNvFix.getSelectedItem())) {
                        fixNv.setChucVu("Quản Lý");
                    } else if ("Nhân Viên Kho".equals(CvNvFix.getSelectedItem())) {
                        fixNv.setChucVu("Nhân Viên Kho");
                    } else if ("Nhân Viên Bán Hàng".equals(CvNvFix.getSelectedItem())) {
                        fixNv.setChucVu("Nhân Viên Bán Hàng");
                    } else if ("Quản trị Viên".equals(CvNvFix.getSelectedItem())) {
                        fixNv.setChucVu("Quản trị Viên");
                    }
                    if (NVBUS.UpdateNvNew(fixNv)) {
                        JOptionPane.showMessageDialog(null, "Sửa Thành Công!"); // Hiển thị thông báo thành công
                        // Xóa toàn bộ dữ liệu từ bảng
                        DefaultTableModel tablefilter = (DefaultTableModel) jtbStaff.getModel();
                        tablefilter.setRowCount(0);
                        // Cập nhật dữ liệu trong datanv (nếu cần)
                        nvlist = NVBUS.getList(); // Đảm bảo datanv là danh sách mới sau khi thêm
//                        loadNV(); // Load lại dữ liệu vào bảng
                        resetFix();
                        jDialog2.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa Không Thành Công!");
                    }
                }

            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbttnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnExportActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        File defaultDirectory = new File("D:\\OneDrive\\Tai Lieu\\CNPM\\ProJectSieuThi_CNPM\\src\\resources\\excel");
        fileChooser.setCurrentDirectory(defaultDirectory);
        // Tạo một FileFilter để chỉ cho phép lựa chọn các tệp có đuôi .xls
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files (.xlsx)", "xlsx");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn và tên file được chọn
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            // Kiểm tra xem tên tệp đã có đuôi .xls chưa
            if (!filePath.toLowerCase().endsWith(".xlsx")) {
                filePath += ".xlsx"; // Nếu chưa có, thêm đuôi .xlsx
            }
            // Thực hiện xuất tệp Excel
            if (exportToExcel(jtbStaff, filePath)) {
                JOptionPane.showMessageDialog(null, "Xuất Excel thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Xuất Excel thất bại!");
            }
        }
    }//GEN-LAST:event_jbttnExportActionPerformed

    private void TTNvFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TTNvFixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TTNvFixActionPerformed

    private void jtbStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbStaffMouseClicked
        // TODO add your handling code here:
        jtbStaff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jtbStaff.getSelectedRow();
                if (e.getClickCount() == 2 && row != -1) {
                    // Đã thực hiện hai lần click, hủy chọn
                    jtbStaff.clearSelection();
                }
            }
        });
    }//GEN-LAST:event_jtbStaffMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CVNvCbb;
    private javax.swing.JComboBox<String> CvNvFix;
    private javax.swing.JTextField EmailNvFix;
    private javax.swing.JTextField EmailNvText;
    private javax.swing.JComboBox<String> GTNvFix;
    private javax.swing.JComboBox<String> GtNvCbb;
    private javax.swing.JTextField MaNvFix;
    private javax.swing.JTextField MaNvText;
    private com.toedter.calendar.JDateChooser NgSNvFix;
    private com.toedter.calendar.JDateChooser NgSinhNvChoose;
    private javax.swing.JTextField SdtNvFix;
    private javax.swing.JTextField SdtNvText;
    private javax.swing.JComboBox<String> TTNvFix;
    private javax.swing.JTextField TenNvFix;
    private javax.swing.JTextField TenNvText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbttnAdd;
    private javax.swing.JButton jbttnExport;
    private javax.swing.JButton jbttnFix;
    private javax.swing.JComboBox<String> jcbboxFilter;
    private javax.swing.JTable jtbStaff;
    private javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
