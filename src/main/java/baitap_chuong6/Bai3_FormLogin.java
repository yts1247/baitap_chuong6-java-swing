package baitap_chuong6;

import javax.swing.*;
import java.awt.*;

public class Bai3_FormLogin extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin, btnExit;

    public Bai3_FormLogin() {
        setTitle("Đăng nhập hệ thống");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Font font = new Font("Segoe UI", Font.BOLD, 18);
        Color bgColor = new Color(240, 245, 255);
        getContentPane().setBackground(bgColor);

        JLabel lblTitle = new JLabel("ĐĂNG NHẬP HỆ THỐNG");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(new Color(40, 60, 120));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.insets = new Insets(18, 0, 18, 0); gbc.anchor = GridBagConstraints.CENTER;
        add(lblTitle, gbc);
        gbc.gridwidth = 1;

        JLabel lblUser = new JLabel("Tên đăng nhập:");
        lblUser.setFont(font);
        lblUser.setForeground(new Color(40, 60, 120));
        gbc.gridx = 0; gbc.gridy = 1; gbc.insets = new Insets(8, 18, 8, 8); gbc.anchor = GridBagConstraints.EAST;
        add(lblUser, gbc);

        txtUser = new JTextField(20);
        txtUser.setFont(font);
        txtUser.setBackground(Color.WHITE);
        txtUser.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        gbc.gridx = 1; gbc.gridy = 1; gbc.insets = new Insets(8, 0, 8, 18); gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        add(txtUser, gbc);
        gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;

        JLabel lblPass = new JLabel("Mật khẩu:");
        lblPass.setFont(font);
        lblPass.setForeground(new Color(40, 60, 120));
        gbc.gridx = 0; gbc.gridy = 2; gbc.insets = new Insets(8, 18, 8, 8); gbc.anchor = GridBagConstraints.EAST;
        add(lblPass, gbc);

        txtPass = new JPasswordField(20);
        txtPass.setFont(font);
        txtPass.setBackground(Color.WHITE);
        txtPass.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));
        gbc.gridx = 1; gbc.gridy = 2; gbc.insets = new Insets(8, 0, 8, 18); gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        add(txtPass, gbc);
        gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(font);
        btnLogin.setBackground(new Color(100, 180, 255));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorder(BorderFactory.createLineBorder(new Color(80, 140, 220), 2));
        btnLogin.setPreferredSize(new Dimension(130, 38));

        btnExit = new JButton("Thoát");
        btnExit.setFont(font);
        btnExit.setBackground(new Color(255, 140, 140));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFocusPainted(false);
        btnExit.setBorder(BorderFactory.createLineBorder(new Color(220, 80, 80), 2));
        btnExit.setPreferredSize(new Dimension(130, 38));

        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 24, 0));
        pnlButtons.setOpaque(false);
        pnlButtons.add(btnLogin);
        pnlButtons.add(btnExit);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.insets = new Insets(18, 0, 18, 0); gbc.anchor = GridBagConstraints.CENTER;
        add(pnlButtons, gbc);
        gbc.gridwidth = 1;

        btnLogin.addActionListener(e -> {
            String user = txtUser.getText().trim();
            String pass = new String(txtPass.getPassword());
            if (user.equals("admin") && pass.equals("123456")) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Đăng nhập thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnExit.addActionListener(e -> System.exit(0));

        pack();
        setLocationRelativeTo(null);
        txtUser.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai3_FormLogin().setVisible(true));
    }
}