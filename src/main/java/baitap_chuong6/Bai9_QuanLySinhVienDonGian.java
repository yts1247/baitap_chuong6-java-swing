package baitap_chuong6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Bai9_QuanLySinhVienDonGian extends JFrame {
    private DefaultTableModel model;
    public Bai9_QuanLySinhVienDonGian() {
        setTitle("Bài 9 - Quản lý sinh viên đơn giản");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 245, 255));
        Font font = new Font("Segoe UI", Font.BOLD, 16);
        Font fontInput = new Font("Segoe UI", Font.PLAIN, 15);
        model = new DefaultTableModel(new Object[] {"Mã SV","Họ tên","Tuổi","Lớp","SĐT"},0) {
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
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.anchor = GridBagConstraints.WEST;
        JLabel lblMa = new JLabel("Mã SV:"); lblMa.setFont(font);
        gbc.gridx = 0; gbc.gridy = 0; p.add(lblMa, gbc);
        JTextField txtMa = new JTextField(8); txtMa.setFont(fontInput);
        txtMa.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        gbc.gridx = 1; gbc.gridy = 0; p.add(txtMa, gbc);
        JLabel lblTen = new JLabel("Họ tên:"); lblTen.setFont(font);
        gbc.gridx = 2; gbc.gridy = 0; p.add(lblTen, gbc);
        JTextField txtTen = new JTextField(14); txtTen.setFont(fontInput);
        txtTen.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        gbc.gridx = 3; gbc.gridy = 0; p.add(txtTen, gbc);
        JLabel lblTuoi = new JLabel("Tuổi:"); lblTuoi.setFont(font);
        gbc.gridx = 4; gbc.gridy = 0; p.add(lblTuoi, gbc);
        JTextField txtTuoi = new JTextField(4); txtTuoi.setFont(fontInput);
        txtTuoi.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        gbc.gridx = 5; gbc.gridy = 0; p.add(txtTuoi, gbc);
        JLabel lblLop = new JLabel("Lớp:"); lblLop.setFont(font);
        gbc.gridx = 6; gbc.gridy = 0; p.add(lblLop, gbc);
        JTextField txtLop = new JTextField(10); txtLop.setFont(fontInput);
        txtLop.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        gbc.gridx = 7; gbc.gridy = 0; p.add(txtLop, gbc);
        JLabel lblSDT = new JLabel("SĐT:"); lblSDT.setFont(font);
        gbc.gridx = 8; gbc.gridy = 0; p.add(lblSDT, gbc);
        JTextField txtSDT = new JTextField(12); txtSDT.setFont(fontInput);
        txtSDT.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        gbc.gridx = 9; gbc.gridy = 0; p.add(txtSDT, gbc);
        JButton btnAdd = new JButton("Thêm");
        btnAdd.setFont(font);
        btnAdd.setBackground(new Color(100, 180, 255));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFocusPainted(false);
        btnAdd.setBorder(BorderFactory.createLineBorder(new Color(80, 140, 220), 2));
        gbc.gridx = 10; gbc.gridy = 0; p.add(btnAdd, gbc);
        JButton btnDel = new JButton("Xóa dòng chọn");
        btnDel.setFont(font);
        btnDel.setBackground(new Color(255, 140, 140));
        btnDel.setForeground(Color.WHITE);
        btnDel.setFocusPainted(false);
        btnDel.setBorder(BorderFactory.createLineBorder(new Color(220, 80, 80), 2));
        gbc.gridx = 11; gbc.gridy = 0; p.add(btnDel, gbc);
        add(p, BorderLayout.NORTH);
        btnAdd.addActionListener(e -> {
            if (txtMa.getText().isEmpty() || txtTen.getText().isEmpty() || txtTuoi.getText().isEmpty() || txtLop.getText().isEmpty() || txtSDT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                return;
            }
            model.addRow(new Object[] {txtMa.getText(), txtTen.getText(), txtTuoi.getText(), txtLop.getText(), txtSDT.getText()});
            txtMa.setText(""); txtTen.setText(""); txtTuoi.setText(""); txtLop.setText(""); txtSDT.setText("");
            txtMa.requestFocus();
        });
        btnDel.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r>=0) model.removeRow(r);
            else JOptionPane.showMessageDialog(this, "Chọn dòng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai9_QuanLySinhVienDonGian().setVisible(true));
    }
}
