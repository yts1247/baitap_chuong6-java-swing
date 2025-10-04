package baitap_chuong6;

import javax.swing.*;
import java.awt.*;

public class Bai3_FormLogin extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin, btnExit;

    public Bai3_FormLogin() {
        setTitle("Đăng nhập hệ thống");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Font font = new Font("Segoe UI", Font.PLAIN, 18);
        Color bgColor = new Color(240, 245, 255);
        getContentPane().setBackground(bgColor);

        JLabel lblUser = new JLabel("Tên đăng nhập:");
        lblUser.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 15, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        add(lblUser, gbc);

        txtUser = new JTextField(16);
        txtUser.setFont(font);
        txtUser.setBackground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 0, 5, 15);
        add(txtUser, gbc);

        JLabel lblPass = new JLabel("Mật khẩu:");
        lblPass.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 15, 5, 5);
        add(lblPass, gbc);

        txtPass = new JPasswordField(16);
        txtPass.setFont(font);
        txtPass.setBackground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 5, 15);
        add(txtPass, gbc);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(font);
        btnLogin.setBackground(new Color(100, 180, 255));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setPreferredSize(new Dimension(130, 36));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 15, 10, 5);
        add(btnLogin, gbc);

        btnExit = new JButton("Thoát");
        btnExit.setFont(font);
        btnExit.setBackground(new Color(255, 140, 140));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFocusPainted(false);
        btnExit.setPreferredSize(new Dimension(130, 36));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 0, 10, 15);
        add(btnExit, gbc);

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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai3_FormLogin().setVisible(true));
    }
}