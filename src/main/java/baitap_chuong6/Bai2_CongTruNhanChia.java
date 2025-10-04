package baitap_chuong6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai2_CongTruNhanChia extends JFrame {
    private JTextField txtA, txtB;
    private JComboBox<String> cbPhepToan;
    private JButton btnTinh, btnLamLai;
    private JLabel lblKQ;

    public Bai2_CongTruNhanChia() {
        setTitle("Cộng Trừ Nhân Chia");
        // setSize(460, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Font font = new Font("Segoe UI", Font.BOLD, 18);
        Color bgColor = new Color(235, 245, 255);
        getContentPane().setBackground(bgColor);

        // default constraint settings
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;

        JLabel lblA = new JLabel("Số A:");
        lblA.setFont(font);
        lblA.setForeground(new Color(40, 60, 120));
        gbc.gridx = 0; gbc.gridy = 0; gbc.insets = new Insets(12, 18, 6, 6); gbc.anchor = GridBagConstraints.EAST;
        add(lblA, gbc);

        // make the text field expand horizontally and accept input properly
        txtA = new JTextField(20);
        txtA.setFont(font);
        txtA.setBackground(Color.WHITE);
        txtA.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        // let GridBagLayout size it: use fill + weightx
        gbc.gridx = 1; gbc.gridy = 0; gbc.insets = new Insets(12, 0, 6, 18);
        gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        add(txtA, gbc);
        // reset fill/weightx for next components
        gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;

        JLabel lblB = new JLabel("Số B:");
        lblB.setFont(font);
        lblB.setForeground(new Color(40, 60, 120));
        gbc.gridx = 0; gbc.gridy = 1; gbc.insets = new Insets(6, 18, 6, 6); gbc.anchor = GridBagConstraints.EAST;
        add(lblB, gbc);

        txtB = new JTextField(20);
        txtB.setFont(font);
        txtB.setBackground(Color.WHITE);
        txtB.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        gbc.gridx = 1; gbc.gridy = 1; gbc.insets = new Insets(6, 0, 6, 18);
        gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        add(txtB, gbc);
        gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;

        JLabel lblPhepToan = new JLabel("Phép toán:");
        lblPhepToan.setFont(font);
        lblPhepToan.setForeground(new Color(40, 60, 120));
        gbc.gridx = 0; gbc.gridy = 2; gbc.insets = new Insets(6, 18, 6, 6); gbc.anchor = GridBagConstraints.EAST;
        add(lblPhepToan, gbc);

        cbPhepToan = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        cbPhepToan.setFont(font);
        cbPhepToan.setBackground(Color.WHITE);
        cbPhepToan.setForeground(new Color(40, 60, 120));
        cbPhepToan.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        cbPhepToan.setPreferredSize(new Dimension(80, 36));
        gbc.gridx = 1; gbc.gridy = 2; gbc.insets = new Insets(6, 0, 6, 18); gbc.anchor = GridBagConstraints.WEST;
        add(cbPhepToan, gbc);

        btnTinh = new JButton("Tính");
        btnTinh.setFont(font);
        btnTinh.setBackground(new Color(100, 180, 255));
        btnTinh.setForeground(Color.WHITE);
        btnTinh.setFocusPainted(false);
        btnTinh.setBorder(BorderFactory.createLineBorder(new Color(80, 140, 220), 2));
        btnTinh.setPreferredSize(new Dimension(110, 38));

        btnLamLai = new JButton("Làm lại");
        btnLamLai.setFont(font);
        btnLamLai.setBackground(new Color(255, 140, 140));
        btnLamLai.setForeground(Color.WHITE);
        btnLamLai.setFocusPainted(false);
        btnLamLai.setBorder(BorderFactory.createLineBorder(new Color(220, 80, 80), 2));
        btnLamLai.setPreferredSize(new Dimension(110, 38));

        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 24, 0));
        pnlButtons.setOpaque(false);
        pnlButtons.add(btnTinh);
        pnlButtons.add(btnLamLai);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.insets = new Insets(16, 0, 6, 0); gbc.anchor = GridBagConstraints.CENTER;
        add(pnlButtons, gbc);
        gbc.gridwidth = 1;

        lblKQ = new JLabel("Kết quả: ");
        lblKQ.setFont(font);
        lblKQ.setForeground(new Color(60, 160, 60));
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.insets = new Insets(18, 18, 10, 18); gbc.anchor = GridBagConstraints.CENTER;
        add(lblKQ, gbc);
        gbc.gridwidth = 1;

        btnTinh.addActionListener(e -> {
            String strA = txtA.getText().trim();
            String strB = txtB.getText().trim();
            String phepToan = (String) cbPhepToan.getSelectedItem();
            if (phepToan == null) phepToan = "+";
            double a, b, kq = 0;
            try {
                if (strA.isEmpty() || strB.isEmpty()) {
                    throw new NumberFormatException();
                }
                a = Double.parseDouble(strA);
                b = Double.parseDouble(strB);
                switch (phepToan) {
                    case "+": kq = a + b; break;
                    case "-": kq = a - b; break;
                    case "*": kq = a * b; break;
                    case "/":
                        if (b == 0) throw new ArithmeticException("Không thể chia cho 0!");
                        kq = a / b;
                        break;
                }
                lblKQ.setText("Kết quả: " + kq);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ cho cả hai ô!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                lblKQ.setText("Kết quả: ");
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi phép toán", JOptionPane.ERROR_MESSAGE);
                lblKQ.setText("Kết quả: ");
            }
        });

        btnLamLai.addActionListener(e -> {
            txtA.setText("");
            txtB.setText("");
            lblKQ.setText("Kết quả: ");
            txtA.requestFocus();
        });

        // finalize sizing and focus
        pack();
        setLocationRelativeTo(null);
        txtA.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai2_CongTruNhanChia().setVisible(true));
    }
}
