/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.myproject.GUI.QuanLy.QuanLyPanels;

import com.myproject.BUS.NhaCungCapBUS;
import com.myproject.DTO.NhaCungCapDTO;
import java.awt.Font;
import static java.awt.PageAttributes.MediaType.D;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class QLNCCPanel extends javax.swing.JPanel {

    NhaCungCapBUS NCCBUS = new NhaCungCapBUS();
    List<NhaCungCapDTO> nccList = NCCBUS.getList();

    public QLNCCPanel() {
        initComponents();
        loadNCC();
        SearchNcc();
        ComboboxNcc();
    }

    public void loadNCC() {
        DefaultTableModel table = (DefaultTableModel) jtbNCC.getModel();
        for (NhaCungCapDTO nhacc : nccList) {
            Object[] rowData = {nhacc.getMaNCC(), nhacc.getTenNCC(), nhacc.getDiaChi(), nhacc.getEmail(), nhacc.getSDT(), nhacc.isTinhTrang()};
            table.addRow(rowData);
        }
    }

    public void SearchNcc() {
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
                DefaultTableModel tableModel = (DefaultTableModel) jtbNCC.getModel();
                TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);
                jtbNCC.setRowSorter(rowSorter);
                List<RowFilter<Object, Object>> filters = new ArrayList<>();
                filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(text), 0)); // Tìm kiếm trên cột 0
                filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(text), 1)); // Tìm kiếm trên cột 1
                filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(text), 3)); // Tìm kiếm trên cột 2
                filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(text), 4));
                RowFilter<Object, Object> combinedFilter = RowFilter.orFilter(filters);
                rowSorter.setRowFilter(combinedFilter);
            }
        });
    }

    public void ComboboxNcc() {
        jcbboxFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTrangThai = (String) jcbboxFilter.getSelectedItem();
                DefaultTableModel tableModel = (DefaultTableModel) jtbNCC.getModel();

                // Làm sạch dữ liệu trong bảng
                tableModel.setRowCount(0);

                if (selectedTrangThai.equals("Đang hoạt động")) {
                    List<NhaCungCapDTO> nccList = NCCBUS.getList();
                    for (NhaCungCapDTO nhacc : nccList) {
                        if (nhacc.isTinhTrang()) { // Kiểm tra nếu tình trạng là 1 (đang hoạt động)
                            Object[] rowData = {nhacc.getMaNCC(), nhacc.getTenNCC(), nhacc.getDiaChi(), nhacc.getEmail(), nhacc.getSDT(), nhacc.isTinhTrang()};
                            tableModel.addRow(rowData);
                        }
                    }
                } else if (selectedTrangThai.equals("Ngừng hoạt động")) {
                    List<NhaCungCapDTO> nccList = NCCBUS.getList();
                    for (NhaCungCapDTO nhacc : nccList) {
                        if (!nhacc.isTinhTrang()) { // Kiểm tra nếu tình trạng là 0 (ngừng hoạt động)
                            Object[] rowData = {nhacc.getMaNCC(), nhacc.getTenNCC(), nhacc.getDiaChi(), nhacc.getEmail(), nhacc.getSDT(), nhacc.isTinhTrang()};
                            tableModel.addRow(rowData);
                        }
                    }
                } else {
                    // Hiển thị toàn bộ dữ liệu nếu chọn "Tất cả"
                    List<NhaCungCapDTO> nccList = NCCBUS.getList();
                    for (NhaCungCapDTO nhacc : nccList) {
                        Object[] rowData = {nhacc.getMaNCC(), nhacc.getTenNCC(), nhacc.getDiaChi(), nhacc.getEmail(), nhacc.getSDT(), nhacc.isTinhTrang()};
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
                // Nếu tệp Excel đã tồn tại, thử mở nó để kiểm tra xem sheet đã có chưa
                FileInputStream inputStream = new FileInputStream(excelFile);
                workbook = WorkbookFactory.create(inputStream);
                inputStream.close();

                // Kiểm tra xem sheet đã có trong tệp Excel chưa
                String newSheetName = "NhaCungCap"; // Tên sheet mới
                boolean sheetExists = false;
                Iterator<Sheet> sheetIterator = workbook.sheetIterator();
                while (sheetIterator.hasNext()) {
                    if (sheetIterator.next().getSheetName().equals(newSheetName)) {
                        sheetExists = true;
                        break;
                    }
                }

                if (sheetExists) {
                    // Nếu sheet đã tồn tại, ghi đè lên sheet hiện có
                    workbook.removeSheetAt(workbook.getSheetIndex(newSheetName));
                }
            } else {
                workbook = new XSSFWorkbook();
            }

            // Tạo sheet mới
            Sheet sheet = workbook.createSheet("NhaCungCap");
            if (isExcelFileInUse(new File(filePath))) {
                JOptionPane.showMessageDialog(null, "Tệp Excel đang mở. Hãy đóng tệp Excel trước khi xuất.");
                return false;
            }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            // Tạo dòng cho tiêu đề
            Row titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("Danh Sách Nhà Cung Câp");
            
            Row headerRow = sheet.createRow(1);
            String[] columnHeaders = {"Mã Nhà Cung Câp", "Tên Nhà Cung Câp", "Ðia Chi", "Email", "SDT","Tinh Trang"};
            for (int i = 0; i < columnHeaders.length; i++) {
                Cell headerCell = headerRow.createCell(i);
                headerCell.setCellValue(columnHeaders[i]);
            }
            // Tạo kiểu cell cho tiêu đề (tùy chọn)
            CellStyle titleCellStyle = workbook.createCellStyle();
            titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
            titleCell.setCellStyle(titleCellStyle);

            // Thêm dữ liệu vào các dòng
            for (int row = 0; row < model.getRowCount(); row++) {
                Row dataRow = sheet.createRow(row + 2);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Cell cell = dataRow.createCell(col);
                    cell.setCellValue(model.getValueAt(row, col).toString());
                }
            }

            // Tự động điều chỉnh độ rộng của các cột
            for (int col = 0; col < model.getColumnCount(); col++) {
                sheet.autoSizeColumn(col);
            }

            // Lưu tệp Excel
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
    private String generateNewMaNCC() {
        int rowCount = jtbNCC.getRowCount();
        int newSequence = rowCount + 1;
        return "NCC" + String.format("%02d", newSequence);
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
        jLabel1 = new javax.swing.JLabel();
        TenNCCText = new javax.swing.JTextField();
        MaNCCText = new javax.swing.JTextField();
        DChiNCCText = new javax.swing.JTextField();
        EmailNCCText = new javax.swing.JTextField();
        SdtNCCText = new javax.swing.JTextField();
        btnAddNCC = new javax.swing.JButton();
        jDialog2 = new javax.swing.JDialog();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MaNCCFix = new javax.swing.JTextField();
        TenNCCFix = new javax.swing.JTextField();
        SdtNCCFix = new javax.swing.JTextField();
        EmailNCCFix = new javax.swing.JTextField();
        CbbNCCFix = new javax.swing.JComboBox<>();
        DChiNCCFix = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jbttnAdd = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jbttnFix = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jbttnExport = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbboxFilter = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbNCC = new javax.swing.JTable();

        jDialog1.setMinimumSize(new java.awt.Dimension(725, 370));
        jDialog1.setModal(true);

        jPanel12.setBackground(new java.awt.Color(3, 169, 244));
        jPanel12.setPreferredSize(new java.awt.Dimension(752, 80));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/supplier.png"))); // NOI18N
        jLabel10.setText("Thêm Nhà Cung Cấp");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 130, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin"));

        jLabel11.setText("Mã Nhà Cung Cấp");

        jLabel12.setText("Số Điện Thoại");

        jLabel13.setText("Tên Nhà Cung Cấp");

        jLabel14.setText("Email");

        jLabel1.setText("Địa Chỉ");

        MaNCCText.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DChiNCCText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TenNCCText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MaNCCText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SdtNCCText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailNCCText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(MaNCCText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TenNCCText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(SdtNCCText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(EmailNCCText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(DChiNCCText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnAddNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus.png"))); // NOI18N
        btnAddNCC.setText("Thêm");
        btnAddNCC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddNCC)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddNCC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog2.setMinimumSize(new java.awt.Dimension(620, 350));
        jDialog2.setModal(true);

        jPanel15.setBackground(new java.awt.Color(3, 169, 244));
        jPanel15.setPreferredSize(new java.awt.Dimension(752, 80));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/supplier.png"))); // NOI18N
        jLabel15.setText("Sửa Nhà Cung Cấp");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin"));

        jLabel16.setText("Mã Nhà Cung Cấp");

        jLabel17.setText("Số Điện Thoại");

        jLabel18.setText("Tên Nhà Cung Cấp");

        jLabel19.setText("Email");

        jLabel2.setText("Địa Chỉ");

        jLabel3.setText("Tình trạng");

        MaNCCFix.setEnabled(false);

        TenNCCFix.setPreferredSize(new java.awt.Dimension(30, 22));

        SdtNCCFix.setMaximumSize(new java.awt.Dimension(210, 2147483647));

        EmailNCCFix.setMaximumSize(new java.awt.Dimension(210, 2147483647));
        EmailNCCFix.setPreferredSize(new java.awt.Dimension(30, 22));

        CbbNCCFix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hoạt động", "Ngừng hoạt động" }));

        DChiNCCFix.setPreferredSize(new java.awt.Dimension(30, 22));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(MaNCCFix, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TenNCCFix, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(DChiNCCFix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(SdtNCCFix, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EmailNCCFix, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbbNCCFix, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(SdtNCCFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(EmailNCCFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(CbbNCCFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(MaNCCFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TenNCCFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(DChiNCCFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
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
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
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
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/search.png"))); // NOI18N

        jtfSearch.setToolTipText("Search here...");
        jtfSearch.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel8.setText("Lọc");

        jcbboxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang hoạt động", "Ngừng hoạt động" }));
        jcbboxFilter.setBorder(null);
        jcbboxFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbboxFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jcbboxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jcbboxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jtbNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "Email", "Số Điện Thoại", "Tình trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbNCC.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbNCCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbNCC);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbttnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnAddActionPerformed
        String newMaNCC = generateNewMaNCC();
        MaNCCText.setText(newMaNCC);

        jDialog1.setLocationRelativeTo(this);
        jDialog1.setVisible(true);
    }//GEN-LAST:event_jbttnAddActionPerformed

    private void jbttnFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttnFixActionPerformed
        if (jtbNCC.getSelectedRow() != -1) {
            int selectedRow = jtbNCC.getSelectedRow();
            // Lấy thông tin từ dòng đã chọn
            String maNCC = (String) jtbNCC.getValueAt(selectedRow, 0);
            String tenNCC = (String) jtbNCC.getValueAt(selectedRow, 1);
            String diaChi = (String) jtbNCC.getValueAt(selectedRow, 2);
            String email = (String) jtbNCC.getValueAt(selectedRow, 3);
            String sdt = (String) jtbNCC.getValueAt(selectedRow, 4);
            int tinhTrang = (boolean) jtbNCC.getValueAt(selectedRow, 5) ? 1 : 0;
            if (tinhTrang == 1) {
                CbbNCCFix.setSelectedItem("Đang hoạt động");
            } else {
                CbbNCCFix.setSelectedItem("Ngừng hoạt động");
            }
            // Điền thông tin vào các trường trên jDialog2
            MaNCCFix.setText(maNCC);
            TenNCCFix.setText(tenNCC);
            DChiNCCFix.setText(diaChi);
            DChiNCCFix.setCaretPosition(0);
            EmailNCCFix.setText(email.trim());
            SdtNCCFix.setText(sdt);

            jDialog2.setLocationRelativeTo(this);
            jDialog2.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhà cung cấp để sửa!");
        }
    }//GEN-LAST:event_jbttnFixActionPerformed

    private void jcbboxFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbboxFilterActionPerformed

    }//GEN-LAST:event_jcbboxFilterActionPerformed

    private void btnAddNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNCCActionPerformed
        if (TenNCCText.getText().isEmpty() || DChiNCCText.getText().isEmpty() || SdtNCCText.getText().isEmpty() || EmailNCCText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin!");
        } else {
            String sdt = SdtNCCText.getText();
            String email = EmailNCCText.getText();
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
            // Chỉ khi tất cả điều kiện đều thỏa mãn thì thực hiện câu lệnh
            if (isDataValid) {
                NhaCungCapDTO newncc = new NhaCungCapDTO();
                newncc.setMaNCC(MaNCCText.getText());
                newncc.setTenNCC(TenNCCText.getText());
                newncc.setDiaChi(DChiNCCText.getText());
                newncc.setSDT(SdtNCCText.getText());
                newncc.setEmail(EmailNCCText.getText());
                newncc.setTinhTrang(true);
                if (NCCBUS.AddNccNew(newncc)) {
                    JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
                    // Xóa toàn bộ dữ liệu từ bảng
                    DefaultTableModel tablefilter = (DefaultTableModel) jtbNCC.getModel();
                    tablefilter.setRowCount(0);
                    // Cập nhật dữ liệu trong datancc (nếu cần)
                    nccList = NCCBUS.getList(); // Đảm bảo datancc là danh sách mới sau khi thêm
                    loadNCC(); // Load lại dữ liệu vào bảng
                    jDialog1.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm Không Thành Công!");
                }
            }
        }
    }//GEN-LAST:event_btnAddNCCActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (TenNCCFix.getText().isEmpty() || DChiNCCFix.getText().isEmpty() || EmailNCCFix.getText().isEmpty() || SdtNCCFix.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhâp đu Thông tin!");
        } else {
            String sdt = SdtNCCFix.getText();
            String email = EmailNCCFix.getText();
            boolean isDataValid = true;
            if (!isValidPhoneNumber(sdt)) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!");
                isDataValid = false;
            }
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email không hợp lệ!");
                isDataValid = false;
            }
            if (isDataValid) {
                // Hiển thị hộp thoại xác nhận
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa nhà cung cấp?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    NhaCungCapDTO fixncc = new NhaCungCapDTO();
                    fixncc.setMaNCC(MaNCCFix.getText());
                    fixncc.setTenNCC(TenNCCFix.getText());
                    fixncc.setDiaChi(DChiNCCFix.getText());
                    fixncc.setSDT(SdtNCCFix.getText());
                    fixncc.setEmail(EmailNCCFix.getText());
                    String selectedTinhTrang = (String) CbbNCCFix.getSelectedItem();
                    if ("Đang hoạt động".equals(selectedTinhTrang)) {
                        fixncc.setTinhTrang(true); // Hoặc đặt giá trị tương ứng nếu true/false là kiểu dữ liệu của TinhTrang
                    } else {
                        fixncc.setTinhTrang(false);
                    }
                    if (NCCBUS.UpdateNccNew(fixncc)) {
                        JOptionPane.showMessageDialog(null, "Sửa Thành Công!");
                        DefaultTableModel tablefilter = (DefaultTableModel) jtbNCC.getModel();
                        tablefilter.setRowCount(0); // Clear the table
                        nccList = NCCBUS.getList(); // Đảm bảo datancc là danh sách mới sau khi thêm
                        loadNCC();
                        jDialog2.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa Không Thành Công!");
                    }
                }
            }
        }
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
                filePath += ".xlsx"; // Nếu chưa có, thêm đuôi .xls
            }
            if (exportToExcel(jtbNCC, filePath)) {
                JOptionPane.showMessageDialog(null, "Xuất Excel thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Xuất Excel thất bại!");
            }
        }
    }//GEN-LAST:event_jbttnExportActionPerformed

    private void jtbNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbNCCMouseClicked
        // TODO add your handling code here:
        jtbNCC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jtbNCC.getSelectedRow();
                if (e.getClickCount() == 2 && row != -1) {
                    // Đã thực hiện hai lần click, hủy chọn
                    jtbNCC.clearSelection();
                }
            }
        });
    }//GEN-LAST:event_jtbNCCMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbbNCCFix;
    private javax.swing.JTextField DChiNCCFix;
    private javax.swing.JTextField DChiNCCText;
    private javax.swing.JTextField EmailNCCFix;
    private javax.swing.JTextField EmailNCCText;
    private javax.swing.JTextField MaNCCFix;
    private javax.swing.JTextField MaNCCText;
    private javax.swing.JTextField SdtNCCFix;
    private javax.swing.JTextField SdtNCCText;
    private javax.swing.JTextField TenNCCFix;
    private javax.swing.JTextField TenNCCText;
    private javax.swing.JButton btnAddNCC;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbttnAdd;
    private javax.swing.JButton jbttnExport;
    private javax.swing.JButton jbttnFix;
    private javax.swing.JComboBox<String> jcbboxFilter;
    private javax.swing.JTable jtbNCC;
    private javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
