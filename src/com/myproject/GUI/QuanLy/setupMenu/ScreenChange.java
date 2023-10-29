package com.myproject.GUI.QuanLy.setupMenu;
import com.myproject.GUI.QuanLy.QuanLyPanels.QLBanHangPanel;
import com.myproject.GUI.QuanLy.QuanLyPanels.QLHangHoaPanel;
import com.myproject.GUI.QuanLy.QuanLyPanels.QLKhachHangPanel;
import com.myproject.GUI.QuanLy.QuanLyPanels.QLNCCPanel;
import com.myproject.GUI.QuanLy.QuanLyPanels.QLNhanVienPanel;
import com.myproject.GUI.QuanLy.QuanLyPanels.QLNhapHangPanel;
import com.myproject.GUI.QuanLy.QuanLyPanels.KhuyenMaiPanel;
import com.myproject.GUI.QuanLy.QuanLyPanels.ThongKePanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 1. đổi màn hình
// 2. đổi màu item được chọn
public class ScreenChange {
    private JPanel root;
    private String kindSelected = "";
    private List<DanhMucMenu> listItem = null;
    public ScreenChange (JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setContent(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "QLBanHang";
        jpnItem.setBackground(new Color(182,224,244));
        jlbItem.setForeground(new Color(255,255,255));
        // xóa tất cả các thành phần con của panel root
        this.root.removeAll();
        // set lại layout và thêm panel mới
        this.root.setLayout(new BorderLayout());
        this.root.add(new QLBanHangPanel());
        // cập nhật hiển thị của panel root
        this.root.validate();
        this.root.repaint();
    }
    
    public void setEvent(List<DanhMucMenu> listItem) {
        this.listItem = listItem;
        for (DanhMucMenu item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener {
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "QLBH":
                    node = new QLBanHangPanel();
                    break;
                case "QLHH":
                    node = new QLHangHoaPanel();
                    break;
                case "QLKH":
                    node = new QLKhachHangPanel();
                    break;
                case "QLNCC":
                    node = new QLNCCPanel();
                    break;
                case "QLNV":
                    node = new QLNhanVienPanel();
                    break;
                case "QLNH":
                    node = new QLNhapHangPanel();
                    break;
                case "KhuyenMai":
                    node = new KhuyenMaiPanel();
                    break;
                case "ThongKe":
                    node = new ThongKePanel();
                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(182,224,244));
            jlbItem.setForeground(new Color(255,255,255));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    private void setChangeBackground(String kind) {
        for (DanhMucMenu item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(182,224,244));
                item.getJlb().setForeground(new Color(255,255,255));
            } else {
                item.getJpn().setBackground(new Color(3,169,244));
                item.getJlb().setForeground(new Color(255,255,255));
            }
        }
    }
}

