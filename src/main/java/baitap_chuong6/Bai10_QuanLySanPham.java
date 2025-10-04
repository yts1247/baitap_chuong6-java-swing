package baitap_chuong6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Bai10_QuanLySanPham extends JFrame {
    private DefaultTableModel model;
    public Bai10_QuanLySanPham() {
        setTitle("Bài 10 - Quản lý sản phẩm đơn giản");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 245, 255));
        Font font = new Font("Segoe UI", Font.BOLD, 16);
        Font fontInput = new Font("Segoe UI", Font.PLAIN, 15);
        model = new DefaultTableModel(new Object[] {"Mã SP","Tên SP","Số lượng","Đơn giá","Thành tiền"},0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        JTable table = new JTable(model);
        table.setFont(fontInput);
        table.getTableHeader().setFont(font);
        table.setRowHeight(28);
        table.setBackground(new Color(235, 245, 255));
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        add(scroll, BorderLayout.CENTER);
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(new Color(240, 245, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        JLabel lblTitle = new JLabel("QUẢN LÝ SẢN PHẨM");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(new Color(40, 60, 120));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 10; gbc.insets = new Insets(18, 0, 18, 0); gbc.anchor = GridBagConstraints.CENTER;
        p.add(lblTitle, gbc);
        gbc.gridwidth = 1;
        JLabel lblMa = new JLabel("Mã SP:"); lblMa.setFont(font);
        gbc.gridx = 0; gbc.gridy = 1; p.add(lblMa, gbc);
        JTextField txtMa = new JTextField(8); txtMa.setFont(fontInput);
        txtMa.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        gbc.gridx = 1; gbc.gridy = 1; p.add(txtMa, gbc);
        JLabel lblTen = new JLabel("Tên SP:"); lblTen.setFont(font);
        gbc.gridx = 2; gbc.gridy = 1; p.add(lblTen, gbc);
        JTextField txtTen = new JTextField(14); txtTen.setFont(fontInput);
        txtTen.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        gbc.gridx = 3; gbc.gridy = 1; p.add(txtTen, gbc);
        JLabel lblSL = new JLabel("Số lượng:"); lblSL.setFont(font);
        gbc.gridx = 4; gbc.gridy = 1; p.add(lblSL, gbc);
        JTextField txtSL = new JTextField(6); txtSL.setFont(fontInput);
        txtSL.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        gbc.gridx = 5; gbc.gridy = 1; p.add(txtSL, gbc);
        JLabel lblDG = new JLabel("Đơn giá:"); lblDG.setFont(font);
        gbc.gridx = 6; gbc.gridy = 1; p.add(lblDG, gbc);
        JTextField txtDG = new JTextField(8); txtDG.setFont(fontInput);
        txtDG.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        gbc.gridx = 7; gbc.gridy = 1; p.add(txtDG, gbc);
        JButton btnAdd = new JButton("Thêm");
        btnAdd.setFont(font);
        btnAdd.setBackground(new Color(100, 180, 255));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFocusPainted(false);
        btnAdd.setBorder(BorderFactory.createLineBorder(new Color(80, 140, 220), 2));
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        p.add(btnAdd, gbc);
        gbc.gridwidth = 1;
        JButton btnEdit = new JButton("Sửa");
        btnEdit.setFont(font);
        btnEdit.setBackground(new Color(180, 180, 80));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFocusPainted(false);
        btnEdit.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 80), 2));
        gbc.gridx = 2; gbc.gridy = 2; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        p.add(btnEdit, gbc);
        gbc.gridwidth = 1;
        JButton btnDel = new JButton("Xóa");
        btnDel.setFont(font);
        btnDel.setBackground(new Color(255, 140, 140));
        btnDel.setForeground(Color.WHITE);
        btnDel.setFocusPainted(false);
        btnDel.setBorder(BorderFactory.createLineBorder(new Color(220, 80, 80), 2));
        gbc.gridx = 4; gbc.gridy = 2; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        p.add(btnDel, gbc);
        gbc.gridwidth = 1;
        JButton btnFind = new JButton("Tìm kiếm");
        btnFind.setFont(font);
        btnFind.setBackground(new Color(80, 180, 120));
        btnFind.setForeground(Color.WHITE);
        btnFind.setFocusPainted(false);
        btnFind.setBorder(BorderFactory.createLineBorder(new Color(80, 180, 120), 2));
        gbc.gridx = 6; gbc.gridy = 2; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        p.add(btnFind, gbc);
        gbc.gridwidth = 1;
        add(p, BorderLayout.NORTH);
        btnAdd.addActionListener(e -> {
            if (txtMa.getText().isEmpty() || txtTen.getText().isEmpty() || txtSL.getText().isEmpty() || txtDG.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int sl, dg;
            try {
                sl = Integer.parseInt(txtSL.getText());
                dg = Integer.parseInt(txtDG.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Số lượng và đơn giá phải là số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int thanhTien = sl * dg;
            model.addRow(new Object[] {txtMa.getText(), txtTen.getText(), sl, dg, thanhTien});
            txtMa.setText(""); txtTen.setText(""); txtSL.setText(""); txtDG.setText("");
            txtMa.requestFocus();
        });
        btnEdit.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r<0) {
                JOptionPane.showMessageDialog(this, "Chọn dòng để sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (txtMa.getText().isEmpty() || txtTen.getText().isEmpty() || txtSL.getText().isEmpty() || txtDG.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin để sửa!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int sl, dg;
            try {
                sl = Integer.parseInt(txtSL.getText());
                dg = Integer.parseInt(txtDG.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Số lượng và đơn giá phải là số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int thanhTien = sl * dg;
            model.setValueAt(txtMa.getText(), r, 0);
            model.setValueAt(txtTen.getText(), r, 1);
            model.setValueAt(sl, r, 2);
            model.setValueAt(dg, r, 3);
            model.setValueAt(thanhTien, r, 4);
        });
        btnDel.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r>=0) model.removeRow(r);
            else JOptionPane.showMessageDialog(this, "Chọn dòng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
        });
        btnFind.addActionListener(e -> {
            String keyword = JOptionPane.showInputDialog(this, "Nhập mã hoặc tên sản phẩm cần tìm:");
            if (keyword == null || keyword.trim().isEmpty()) return;
            for (int i=0; i<model.getRowCount(); i++) {
                String ma = model.getValueAt(i,0).toString();
                String ten = model.getValueAt(i,1).toString();
                if (ma.equalsIgnoreCase(keyword) || ten.toLowerCase().contains(keyword.toLowerCase())) {
                    table.setRowSelectionInterval(i,i);
                    table.scrollRectToVisible(table.getCellRect(i,0,true));
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm!", "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
        });
        table.getSelectionModel().addListSelectionListener(e -> {
            int r = table.getSelectedRow();
            if (r>=0) {
                txtMa.setText(model.getValueAt(r,0).toString());
                txtTen.setText(model.getValueAt(r,1).toString());
                txtSL.setText(model.getValueAt(r,2).toString());
                txtDG.setText(model.getValueAt(r,3).toString());
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai10_QuanLySanPham().setVisible(true));
    }
}
