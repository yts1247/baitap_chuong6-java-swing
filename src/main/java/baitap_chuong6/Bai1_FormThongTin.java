package baitap_chuong6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai1_FormThongTin extends JFrame {
    private JTextField txtHoTen;
    private JRadioButton rdNam, rdNu;
    private JComboBox<String> cbQuocTich;
    private JCheckBox ckDocSach, ckDuLich, ckAmNhac;
    private JButton btnXacNhan;

    public Bai1_FormThongTin() {
        setTitle("Thông tin cá nhân");
        setSize(420, 430);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Font và màu sắc
        Font fontLabel = new Font("Segoe UI", Font.BOLD, 15);
        Font fontInput = new Font("Segoe UI", Font.PLAIN, 15);
        Color bgPanel = new Color(245, 250, 255);
        Color bgButton = new Color(0, 120, 215);
        Color fgButton = Color.WHITE;
        Color borderColor = new Color(200, 220, 240);

        setLayout(new BorderLayout(10, 10));

        // Tiêu đề
        JLabel lblTitle = new JLabel("THÔNG TIN CÁ NHÂN", JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0, 120, 215));
        add(lblTitle, BorderLayout.NORTH);

        JPanel panelInput = new JPanel(new GridBagLayout());
        panelInput.setBackground(bgPanel);
        panelInput.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Họ tên
        JLabel lblHoTen = new JLabel("Họ tên:");
        lblHoTen.setFont(fontLabel);
        panelInput.add(lblHoTen, gbc);
        gbc.gridx = 1;
        txtHoTen = new JTextField();
        txtHoTen.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // font to hơn
        txtHoTen.setBorder(BorderFactory.createLineBorder(borderColor, 1, true));
        txtHoTen.setPreferredSize(new Dimension(260, 32)); // rộng và cao hơn
        panelInput.add(txtHoTen, gbc);

        // Giới tính
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblGioiTinh = new JLabel("Giới tính:");
        lblGioiTinh.setFont(fontLabel);
        panelInput.add(lblGioiTinh, gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        genderPanel.setBackground(bgPanel);
        rdNam = new JRadioButton("Nam");
        rdNu = new JRadioButton("Nữ");
        rdNam.setFont(fontInput);
        rdNu.setFont(fontInput);
        rdNam.setBackground(bgPanel);
        rdNu.setBackground(bgPanel);
        ButtonGroup group = new ButtonGroup();
        group.add(rdNam);
        group.add(rdNu);
        genderPanel.add(rdNam);
        genderPanel.add(rdNu);
        panelInput.add(genderPanel, gbc);

        // Quốc tịch
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblQuocTich = new JLabel("Quốc tịch:");
        lblQuocTich.setFont(fontLabel);
        panelInput.add(lblQuocTich, gbc);
        gbc.gridx = 1;
        cbQuocTich = new JComboBox<>(new String[]{"Việt Nam", "Mỹ", "Nhật", "Hàn"});
        cbQuocTich.setFont(fontInput);
        cbQuocTich.setBackground(Color.WHITE);
        cbQuocTich.setBorder(BorderFactory.createLineBorder(borderColor, 1, true));
        panelInput.add(cbQuocTich, gbc);

        // Sở thích
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblSoThich = new JLabel("Sở thích:");
        lblSoThich.setFont(fontLabel);
        panelInput.add(lblSoThich, gbc);
        gbc.gridx = 1;
        JPanel hobbyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        hobbyPanel.setBackground(bgPanel);
        ckDocSach = new JCheckBox("Đọc sách");
        ckDuLich = new JCheckBox("Du lịch");
        ckAmNhac = new JCheckBox("Âm nhạc");
        ckDocSach.setFont(fontInput);
        ckDuLich.setFont(fontInput);
        ckAmNhac.setFont(fontInput);
        ckDocSach.setBackground(bgPanel);
        ckDuLich.setBackground(bgPanel);
        ckAmNhac.setBackground(bgPanel);
        hobbyPanel.add(ckDocSach);
        hobbyPanel.add(ckDuLich);
        hobbyPanel.add(ckAmNhac);
        panelInput.add(hobbyPanel, gbc);

        // Nút xác nhận
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnXacNhan = new JButton("Xác nhận");
        btnXacNhan.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnXacNhan.setBackground(new Color(0, 120, 215));
        btnXacNhan.setForeground(Color.WHITE);
        btnXacNhan.setFocusPainted(false);
        btnXacNhan.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 120, 215), 1, true),
            BorderFactory.createEmptyBorder(8, 32, 8, 32)));
        btnXacNhan.setPreferredSize(new Dimension(180, 38)); // width vừa đẹp
        panelInput.add(btnXacNhan, gbc);

        add(panelInput, BorderLayout.CENTER);

        // Xoá JTextArea ở footer

        // Sự kiện
        btnXacNhan.addActionListener(e -> {
            String hoTen = txtHoTen.getText();
            String gioiTinh = rdNam.isSelected() ? "Nam" : rdNu.isSelected() ? "Nữ" : "Chưa chọn";
            String quocTich = (String) cbQuocTich.getSelectedItem();
            String soThich = "";
            if (ckDocSach.isSelected()) soThich += "Đọc sách ";
            if (ckDuLich.isSelected()) soThich += "Du lịch ";
            if (ckAmNhac.isSelected()) soThich += "Âm nhạc ";

            String result = "Họ tên: " + hoTen +
                    "\nGiới tính: " + gioiTinh +
                    "\nQuốc tịch: " + quocTich +
                    "\nSở thích: " + soThich;
            JOptionPane.showMessageDialog(this, result, "Thông tin cá nhân", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai1_FormThongTin().setVisible(true));
    }
}
