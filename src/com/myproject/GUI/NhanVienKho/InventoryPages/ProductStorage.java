package com.myproject.GUI.NhanVienKho.InventoryPages;


import com.myproject.BUS.HangHoaBUS;
import com.myproject.BUS.LoaiHangBUS;
import com.myproject.DTO.CT_HangHoaDTO;
import com.myproject.DTO.HangHoaDTO;
import com.myproject.DTO.HangHoaTongDTO;
import com.myproject.DTO.LoaiHangDTO;
import com.myproject.GUI.NhanVienKho.InventoryDialogs.AddNewProduct;
import com.myproject.GUI.NhanVienKho.InventoryDialogs.UpdateInventory;
import com.myproject.GUI.QuanLy.setupMenu.UniquePanel;
import java.awt.Color;
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
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProductStorage extends javax.swing.JPanel implements ActionListener {
    private JFrame parent;
    public String CurrentLH;
    public String CurrentLHName;
    public String CurrentStatus;
    DefaultTableModel dtm;
    HangHoaBUS hhBUS = new HangHoaBUS();
    ArrayList<CT_HangHoaDTO> listCT = new ArrayList<>();
    ArrayList<LoaiHangDTO> listLH = new ArrayList<>();
    ArrayList<HangHoaDTO> listHH = hhBUS.getListHHTotal(listCT, listLH);
    public ProductStorage(JFrame parent) {
        this.parent = parent;
        initComponents();
        this.addListener();
        setUpTable();
        render("All","All");
        this.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                clearComponents();
                loadLH();
                LoadStatus();
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                // Not necessary for clearing components
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                // Not necessary for clearing components
            }
        });
        CurrentLH = "All";
        CurrentLHName = "Tất Cả";
        CurrentStatus = "All";
    }
    public void LoadStatus() {
        jpnTinhTrang.setLayout(new BoxLayout(jpnTinhTrang, BoxLayout.Y_AXIS));
        String name = "";
        String id = "";
        for (int i=0;i<3;i++) {
            System.out.println(i);
            if(i==0) {
                name = "Tất Cả"; 
                id = "All";
            } else if (i==1) {
                name = "Đang bán";
                id = "1";
            }
            else {
                name = "Tồn kho";
                id = "0";
            }
            UniquePanel jpn = new UniquePanel();
            jpn.setID(id);
            jpn.setName(name);
            jpn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            GroupLayout jpnLayout = new javax.swing.GroupLayout(jpn);
            jpn.setLayout(jpnLayout);
            jpn.setBackground(Color.RED);
            JLabel jlb1 = new JLabel();
            jlb1.setBackground(new java.awt.Color(255, 255, 255));
            jlb1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jlb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jlb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/fast-food.png"))); // NOI18N
            jlb1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(3, 169, 244)));
            JLabel jlb2 = new JLabel();
            jlb2.setBackground(new java.awt.Color(3, 169, 244));
            jlb2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jlb2.setForeground(new java.awt.Color(255, 255, 255));
            jlb2.setText(name);
            jlb2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
            jlb2.setOpaque(true);
            jpnLayout.setHorizontalGroup(
                jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jlb1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jlb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(1, 1, 1))
            );
            jpnLayout.setVerticalGroup(
                jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jlb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlb2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
            );
            if (jpn.getID().equalsIgnoreCase("All")) {
                jpn.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
                jpn.setSelected(true);
            } else {
                jpn.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE));
                jpn.setSelected(false);
            }
            jpn.setBounds(0, 0, 100, 5);
            jpn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    SelectedItemStatus(jpn.getID());
                    render(jpn.getID(), getSelectedLH());
                }
           
            });
            jpnTinhTrang.add(jpn);
        }
        jpnTinhTrang.revalidate();
        jpnTinhTrang.repaint();
    }
    private void clearComponents() {
        this.jpnLH.removeAll();
        this.jpnLH.revalidate();
        this.jpnLH.repaint();
        this.jpnTinhTrang.removeAll();
        this.jpnTinhTrang.revalidate();
        this.jpnTinhTrang.repaint();
    }
    public void loadLH() {
        LoaiHangBUS lh = new LoaiHangBUS();
        ArrayList<LoaiHangDTO> lhlist = new ArrayList<>();
        lhlist.add(new LoaiHangDTO("All","Tất Cả",true));
        for (LoaiHangDTO p: lh.getALLLH()) {
            lhlist.add(p);
        }
        jpnLH.setLayout(new BoxLayout(jpnLH, BoxLayout.Y_AXIS));
        for (LoaiHangDTO p : lhlist) {
            UniquePanel jpn = new UniquePanel();
            jpn.setID(p.getMaLH().trim());
            jpn.setName(p.getTenLH().trim());
            jpn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            GroupLayout jpnLayout = new javax.swing.GroupLayout(jpn);
            jpn.setLayout(jpnLayout);
            jpn.setBackground(Color.RED);
            JLabel jlb1 = new JLabel();
            jlb1.setBackground(new java.awt.Color(255, 255, 255));
            jlb1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jlb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jlb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cubes.png"))); // NOI18N
            jlb1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(3, 169, 244)));
            JLabel jlb2 = new JLabel();
            jlb2.setBackground(new java.awt.Color(3, 169, 244));
            jlb2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jlb2.setForeground(new java.awt.Color(255, 255, 255));
            jlb2.setText(p.getTenLH().trim());
            jlb2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
            jlb2.setOpaque(true);
            jpnLayout.setHorizontalGroup(
                jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jlb1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jlb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(1, 1, 1))
            );
            jpnLayout.setVerticalGroup(
                jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jlb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlb2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
            );
            if (jpn.getID().equalsIgnoreCase("All")) {
                jpn.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
                jpn.setSelected(true);
            } else {
                jpn.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE));
                jpn.setSelected(false);
            }
            jpn.setBounds(5, 5, 110, 28);
            jpn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    SelectedItemLH(jpn.getID());
                    render(getSelectedStatus(), jpn.getID());
                }
            });
            jpnLH.add(jpn);
        }
        jpnLH.revalidate();
        jpnLH.repaint();
    }
    public String getSelectedStatus() {
        String IDStatus = "";
        for (int i=0;i<jpnTinhTrang.getComponentCount();i++) {
            UniquePanel currentPanel = (UniquePanel) jpnTinhTrang.getComponent(i);
            if (currentPanel.isSelected()) {
                IDStatus = currentPanel.getID();
            }
        }
        return IDStatus.trim();
    }
    public String getSelectedLH() {
        String IDLH = "";
        for (int i=0;i<jpnLH.getComponentCount();i++) {
            UniquePanel currentPanel = (UniquePanel) jpnLH.getComponent(i);
            if (currentPanel.isSelected()) {
                IDLH = currentPanel.getID();
            }
        }
        return IDLH.trim();
    }
    public void SelectedItemLH(String jpnID) {
        for (int i=0;i<jpnLH.getComponentCount();i++) {
            UniquePanel currentPanel = (UniquePanel) jpnLH.getComponent(i);
            if (currentPanel.getID().equalsIgnoreCase(jpnID)) {
                currentPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
                currentPanel.setSelected(true);
                this.CurrentLH = currentPanel.getID();
                this.CurrentLHName = currentPanel.getName();
            } else {
                currentPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE));
                currentPanel.setSelected(false);
            }
        }
    }
    public void SelectedItemStatus(String jpnID) {
        for (int i=0;i<jpnTinhTrang.getComponentCount();i++) {
            UniquePanel currentPanel = (UniquePanel) jpnTinhTrang.getComponent(i);
            if (currentPanel.getID().equalsIgnoreCase(jpnID)) {
                currentPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
                currentPanel.setSelected(true);
                this.CurrentStatus = currentPanel.getID();
            } else {
                currentPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE));
                currentPanel.setSelected(false);
            }
        }
    }
    public void setUpTable() {
        dtm = new DefaultTableModel() {
            public Class<?> getColumnClass(int columnIndex) {
                return super.getColumnClass(columnIndex);
            }

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        dtm.addColumn("Mã hàng hóa");
        dtm.addColumn("Mã CTHH");
        dtm.addColumn("Tên Hàng Hóa");
        dtm.addColumn("Ngày Sản Xuất");
        dtm.addColumn("Hạn sử dụng");
        dtm.addColumn("Đơn Giá");
        dtm.addColumn("Mã Khuyến Mãi");
        dtm.addColumn("Đơn Vị");
        dtm.addColumn("Số lượng");
    }
    public void render(String status, String lh) {
        listCT = new ArrayList<>();
        listLH = new ArrayList<>();
        listHH = hhBUS.getListHHTotal(listCT, listLH);
        dtm.setRowCount(0);
        for (int i = 0; i < listHH.size(); i++) {
            if (lh.equalsIgnoreCase("All")) {
                if (status.equalsIgnoreCase("All")) {
                                Object data[] = {listHH.get(i).getMaHH(), listCT.get(i).getMaCT_HH(), listHH.get(i).getTenHH(),
                                listCT.get(i).getNgaySX(), listCT.get(i).getHSD(), listHH.get(i).getDonGiaBan(),
                                listHH.get(i).getMaKM(), listHH.get(i).getDonVi(), listCT.get(i).getSoLuong()};
                    dtm.addRow(data);
                } else {
                    if (status.equalsIgnoreCase("1")) {
                        if (listHH.get(i).isTinhTrang()) {
                                Object data[] = {listHH.get(i).getMaHH(), listCT.get(i).getMaCT_HH(), listHH.get(i).getTenHH(),
                                listCT.get(i).getNgaySX(), listCT.get(i).getHSD(), listHH.get(i).getDonGiaBan(),
                                listHH.get(i).getMaKM(), listHH.get(i).getDonVi(), listCT.get(i).getSoLuong()};
                            dtm.addRow(data);
                        }
                    } else if (status.equalsIgnoreCase("0")){
                            if (!listHH.get(i).isTinhTrang()) {
                                Object data[] = {listHH.get(i).getMaHH(), listCT.get(i).getMaCT_HH(), listHH.get(i).getTenHH(),
                                listCT.get(i).getNgaySX(), listCT.get(i).getHSD(), listHH.get(i).getDonGiaBan(),
                                listHH.get(i).getMaKM(), listHH.get(i).getDonVi(), listCT.get(i).getSoLuong()};
                            dtm.addRow(data);
                        }
                    }
                }
            } else {
                if (status.equalsIgnoreCase("All")) {
                    if (listLH.get(i).getMaLH().trim().equalsIgnoreCase(lh)) {
                                Object data[] = {listHH.get(i).getMaHH(), listCT.get(i).getMaCT_HH(), listHH.get(i).getTenHH(),
                                listCT.get(i).getNgaySX(), listCT.get(i).getHSD(), listHH.get(i).getDonGiaBan(),
                                listHH.get(i).getMaKM(), listHH.get(i).getDonVi(), listCT.get(i).getSoLuong()};
                        dtm.addRow(data);
                    }
                } else {
                    if (status.equalsIgnoreCase("1")) {
                        if (listLH.get(i).getMaLH().trim().equalsIgnoreCase(lh) && listHH.get(i).isTinhTrang()) {
                                Object data[] = {listHH.get(i).getMaHH(), listCT.get(i).getMaCT_HH(), listHH.get(i).getTenHH(),
                                listCT.get(i).getNgaySX(), listCT.get(i).getHSD(), listHH.get(i).getDonGiaBan(),
                                listHH.get(i).getMaKM(), listHH.get(i).getDonVi(), listCT.get(i).getSoLuong()};
                            dtm.addRow(data);
                        }
                    } else if (status.equalsIgnoreCase("0")){
                            if (listLH.get(i).getMaLH().trim().equalsIgnoreCase(lh) && !listHH.get(i).isTinhTrang()) {
                                Object data[] = {listHH.get(i).getMaHH(), listCT.get(i).getMaCT_HH(), listHH.get(i).getTenHH(),
                                listCT.get(i).getNgaySX(), listCT.get(i).getHSD(), listHH.get(i).getDonGiaBan(),
                                listHH.get(i).getMaKM(), listHH.get(i).getDonVi(), listCT.get(i).getSoLuong()};
                                dtm.addRow(data);
                            }
                    }
                }
            }
        }
        jTable1.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Slidear_PN = new javax.swing.JPanel();
        category_Menu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jpnLH = new javax.swing.JPanel();
        jpnLH001 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        category_Menu1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jpnTinhTrang = new javax.swing.JPanel();
        jpnLH2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Container_PN = new javax.swing.JPanel();
        Option_PN = new javax.swing.JPanel();
        addProductBtn = new javax.swing.JButton();
        addProductBtn2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        updateInvenBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1200, 600));

        Slidear_PN.setBackground(new java.awt.Color(3, 169, 244));
        Slidear_PN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Slidear_PN.setMaximumSize(new java.awt.Dimension(227, 283));

        category_Menu.setBackground(new java.awt.Color(3, 169, 244));
        category_Menu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        category_Menu.setVerifyInputWhenFocusTarget(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nhóm Hàng");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/up-chevron.png"))); // NOI18N

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus2.png"))); // NOI18N

        jScrollPane2.setBackground(new java.awt.Color(3, 169, 244));

        jpnLH.setBackground(new java.awt.Color(3, 169, 244));
        jpnLH.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));

        jpnLH001.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cubes.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(3, 169, 244)));

        jLabel8.setBackground(new java.awt.Color(3, 169, 244));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Sản phẩm 1");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel8.setOpaque(true);

        javax.swing.GroupLayout jpnLH001Layout = new javax.swing.GroupLayout(jpnLH001);
        jpnLH001.setLayout(jpnLH001Layout);
        jpnLH001Layout.setHorizontalGroup(
            jpnLH001Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLH001Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jpnLH001Layout.setVerticalGroup(
            jpnLH001Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cubes.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(3, 169, 244)));

        jLabel10.setBackground(new java.awt.Color(3, 169, 244));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sản phẩm 2");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel10.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cubes.png"))); // NOI18N
        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(3, 169, 244)));

        jLabel12.setBackground(new java.awt.Color(3, 169, 244));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Sản phẩm 3");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel12.setOpaque(true);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cubes.png"))); // NOI18N
        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(3, 169, 244)));

        jLabel18.setBackground(new java.awt.Color(3, 169, 244));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Sản phẩm 4");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel18.setOpaque(true);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cubes.png"))); // NOI18N
        jLabel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(3, 169, 244)));

        jLabel20.setBackground(new java.awt.Color(3, 169, 244));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Sản phẩm 5");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel20.setOpaque(true);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnLHLayout = new javax.swing.GroupLayout(jpnLH);
        jpnLH.setLayout(jpnLHLayout);
        jpnLHLayout.setHorizontalGroup(
            jpnLHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnLHLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpnLHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnLH001, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnLHLayout.setVerticalGroup(
            jpnLHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnLH001, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jpnLH);

        javax.swing.GroupLayout category_MenuLayout = new javax.swing.GroupLayout(category_Menu);
        category_Menu.setLayout(category_MenuLayout);
        category_MenuLayout.setHorizontalGroup(
            category_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(category_MenuLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(category_MenuLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        category_MenuLayout.setVerticalGroup(
            category_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(category_MenuLayout.createSequentialGroup()
                .addGroup(category_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
        );

        category_Menu1.setBackground(new java.awt.Color(3, 169, 244));
        category_Menu1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        category_Menu1.setMaximumSize(new java.awt.Dimension(225, 237));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Tình Trạng");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/up-chevron.png"))); // NOI18N

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus2.png"))); // NOI18N

        jScrollPane3.setBackground(new java.awt.Color(3, 169, 244));

        jpnTinhTrang.setBackground(new java.awt.Color(3, 169, 244));

        jpnLH2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/fast-food.png"))); // NOI18N
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(3, 169, 244)));

        jLabel21.setBackground(new java.awt.Color(3, 169, 244));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Tất Cả");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel21.setOpaque(true);

        javax.swing.GroupLayout jpnLH2Layout = new javax.swing.GroupLayout(jpnLH2);
        jpnLH2.setLayout(jpnLH2Layout);
        jpnLH2Layout.setHorizontalGroup(
            jpnLH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLH2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jpnLH2Layout.setVerticalGroup(
            jpnLH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/fast-food.png"))); // NOI18N
        jLabel22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(3, 169, 244)));

        jLabel23.setBackground(new java.awt.Color(3, 169, 244));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Đang bán");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel23.setOpaque(true);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/fast-food.png"))); // NOI18N
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(3, 169, 244)));

        jLabel25.setBackground(new java.awt.Color(3, 169, 244));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Tồn kho");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel25.setOpaque(true);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnTinhTrangLayout = new javax.swing.GroupLayout(jpnTinhTrang);
        jpnTinhTrang.setLayout(jpnTinhTrangLayout);
        jpnTinhTrangLayout.setHorizontalGroup(
            jpnTinhTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTinhTrangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnTinhTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnLH2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jpnTinhTrangLayout.setVerticalGroup(
            jpnTinhTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTinhTrangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnLH2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jpnTinhTrang);

        javax.swing.GroupLayout category_Menu1Layout = new javax.swing.GroupLayout(category_Menu1);
        category_Menu1.setLayout(category_Menu1Layout);
        category_Menu1Layout.setHorizontalGroup(
            category_Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(category_Menu1Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane3)
        );
        category_Menu1Layout.setVerticalGroup(
            category_Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(category_Menu1Layout.createSequentialGroup()
                .addGroup(category_Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Slidear_PNLayout = new javax.swing.GroupLayout(Slidear_PN);
        Slidear_PN.setLayout(Slidear_PNLayout);
        Slidear_PNLayout.setHorizontalGroup(
            Slidear_PNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(category_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(category_Menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Slidear_PNLayout.setVerticalGroup(
            Slidear_PNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Slidear_PNLayout.createSequentialGroup()
                .addComponent(category_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(category_Menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        addProductBtn.setBackground(new java.awt.Color(0, 153, 51));
        addProductBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addProductBtn.setForeground(new java.awt.Color(255, 255, 255));
        addProductBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus.png"))); // NOI18N
        addProductBtn.setText("Thêm Sản Phẩm");
        addProductBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductBtnActionPerformed(evt);
            }
        });

        addProductBtn2.setBackground(new java.awt.Color(0, 153, 51));
        addProductBtn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addProductBtn2.setForeground(new java.awt.Color(255, 255, 255));
        addProductBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/xls-file.png"))); // NOI18N
        addProductBtn2.setText("Xuất File");
        addProductBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProductBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Option_PNLayout = new javax.swing.GroupLayout(Option_PN);
        Option_PN.setLayout(Option_PNLayout);
        Option_PNLayout.setHorizontalGroup(
            Option_PNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Option_PNLayout.createSequentialGroup()
                .addContainerGap(280, Short.MAX_VALUE)
                .addComponent(addProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addProductBtn2)
                .addGap(26, 26, 26))
        );
        Option_PNLayout.setVerticalGroup(
            Option_PNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Option_PNLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(Option_PNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProductBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        updateInvenBtn.setBackground(new java.awt.Color(0, 153, 51));
        updateInvenBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateInvenBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateInvenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/fix.png"))); // NOI18N
        updateInvenBtn.setText("Chỉnh Sữa");
        updateInvenBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateInvenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInvenBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(729, Short.MAX_VALUE)
                .addComponent(updateInvenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(updateInvenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hàng Hóa", "Mã CTHH", "Tên Hàng Hóa", "Ngày Sản Xuất", "Hạn Sử Dụng", "Đơn Giá", "Mã Khuyến Mãi", "Đơn Vị", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout Container_PNLayout = new javax.swing.GroupLayout(Container_PN);
        Container_PN.setLayout(Container_PNLayout);
        Container_PNLayout.setHorizontalGroup(
            Container_PNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Container_PNLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(Container_PNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Container_PNLayout.createSequentialGroup()
                        .addComponent(Option_PN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(Container_PNLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Container_PNLayout.setVerticalGroup(
            Container_PNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Container_PNLayout.createSequentialGroup()
                .addComponent(Option_PN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Slidear_PN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Container_PN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container_PN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Slidear_PN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateInvenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInvenBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateInvenBtnActionPerformed

    private void addProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addProductBtnActionPerformed

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

    public boolean exportToExcel(JTable table, String filePath) {
        try {
            File excelFile = new File(filePath);
            Workbook workbook;
            if (excelFile.exists()) {
                FileInputStream inputStream = new FileInputStream(excelFile);
                workbook = WorkbookFactory.create(inputStream);
                inputStream.close();
                String newSheetName = "HangHoa";
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

            Sheet sheet = workbook.createSheet("HangHoa");
            if (isExcelFileInUse(new File(filePath))) {
                JOptionPane.showMessageDialog(null, "Tệp Excel đang mở. Hãy đóng tệp Excel trước khi xuất.");
                return false;
            }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Row titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("Danh Sách Hàng Hóa");
            
            
            String Status = "Tất Cả";
            if (this.CurrentStatus.equalsIgnoreCase("1")) {
                Status = "Đang bán";
            } else if (this.CurrentStatus.equalsIgnoreCase("0")) {
                Status = "Tồn kho";
            }
            Row DetailRow = sheet.createRow(1);
            String[] columnDetail = {"Loại Hàng: ", this.CurrentLHName.trim(), "Tình Trạng: ", Status};
            for (int i = 0; i < columnDetail.length; i++) {
                Cell headerCell = DetailRow.createCell(i);
                headerCell.setCellValue(columnDetail[i]);
            }

            Row headerRow = sheet.createRow(2);
            String[] columnHeaders = {"Mã hàng hóa", "Mã CTHH", "Tên hàng hóa", "Ngày SX", "Hạn sử dụng", "Ðon giá", "Mã khuyến mãi", "Đơn vị", "Số lượng"};
            for (int i = 0; i < columnHeaders.length; i++) {
                Cell headerCell = headerRow.createCell(i);
                headerCell.setCellValue(columnHeaders[i]);
            }

            CellStyle titleCellStyle = workbook.createCellStyle();
            titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
            titleCell.setCellStyle(titleCellStyle);
            for (int row = 0; row < model.getRowCount(); row++) {
                Row dataRow = sheet.createRow(row + 3);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Cell cell = dataRow.createCell(col);
                    Object cellValue = model.getValueAt(row, col);

                    // Kiểm tra giá trị null và gán giá trị cho ô Excel
                    if (cellValue == null) {
                        cell.setCellValue(""); // Gán khoảng trắng nếu giá trị null
                    } else {
                        cell.setCellValue(cellValue.toString());
                    }
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

    private void addProductBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductBtn2ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        File defaultDirectory = new File("C:\\Documents");
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
            if (exportToExcel(jTable1, filePath)) {
                JOptionPane.showMessageDialog(null, "Xuất Excel thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Xuất Excel thất bại!");
            }
        }
    }//GEN-LAST:event_addProductBtn2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container_PN;
    private javax.swing.JPanel Option_PN;
    private javax.swing.JPanel Slidear_PN;
    private javax.swing.JButton addProductBtn;
    private javax.swing.JButton addProductBtn2;
    private javax.swing.JPanel category_Menu;
    private javax.swing.JPanel category_Menu1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpnLH;
    private javax.swing.JPanel jpnLH001;
    private javax.swing.JPanel jpnLH2;
    private javax.swing.JPanel jpnTinhTrang;
    private javax.swing.JButton updateInvenBtn;
    // End of variables declaration//GEN-END:variables

    private void addListener() {
        this.addProductBtn.addActionListener(this);
        this.updateInvenBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(this.addProductBtn)) {
            new AddNewProduct(parent, true, ProductStorage.this).setVisible(true);
        } else if (src.equals(this.updateInvenBtn)) {
            new UpdateInventory(parent, true, ProductStorage.this).setVisible(true);
        }
    }
}
