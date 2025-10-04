package baitap_chuong6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai6_MenuDonGian extends JFrame {
    public Bai6_MenuDonGian() {
        setTitle("Bài 6 - Menu đơn giản");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480,340);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 245, 255));

        Font menuFont = new Font("Segoe UI", Font.BOLD, 16);
        Font itemFont = new Font("Segoe UI", Font.PLAIN, 15);
        Color menuBg = new Color(220, 230, 250);
        Color menuFg = new Color(40, 60, 120);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(menuBg);
        menuBar.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 240), 2));

        JMenu mFile = new JMenu("File");
        mFile.setFont(menuFont);
        mFile.setForeground(menuFg);
        JMenuItem miExit = new JMenuItem("Exit", UIManager.getIcon("OptionPane.errorIcon"));
        miExit.setFont(itemFont);
        miExit.setBackground(Color.WHITE);
        miExit.setForeground(new Color(180, 80, 80));
        mFile.add(miExit);

        JMenu mOpen = new JMenu("Open");
        mOpen.setFont(menuFont);
        mOpen.setForeground(menuFg);
        JMenuItem miBai1 = new JMenuItem("Bài 1: Form thông tin", UIManager.getIcon("OptionPane.informationIcon"));
        JMenuItem miBai2 = new JMenuItem("Bài 2: Cộng Trừ Nhân Chia", UIManager.getIcon("OptionPane.informationIcon"));
        JMenuItem miBai3 = new JMenuItem("Bài 3: Đăng nhập", UIManager.getIcon("OptionPane.informationIcon"));
        JMenuItem miBai4 = new JMenuItem("Bài 4: Quản lý SV", UIManager.getIcon("OptionPane.informationIcon"));
        JMenuItem miBai5 = new JMenuItem("Bài 5: Đổi màu hình", UIManager.getIcon("OptionPane.informationIcon"));
        JMenuItem miBai6 = new JMenuItem("Bài 6: Menu đơn giản", UIManager.getIcon("OptionPane.informationIcon"));
        JMenuItem miBai7 = new JMenuItem("Bài 7: Paint đơn giản", UIManager.getIcon("OptionPane.informationIcon"));
        JMenuItem miBai8 = new JMenuItem("Bài 8: Quiz trắc nghiệm", UIManager.getIcon("OptionPane.informationIcon"));
        JMenuItem miBai9 = new JMenuItem("Bài 9: Quản lý SV đơn giản", UIManager.getIcon("OptionPane.informationIcon"));
        JMenuItem miBai10 = new JMenuItem("Bài 10: Quản lý sản phẩm", UIManager.getIcon("OptionPane.informationIcon"));
        miBai1.setFont(itemFont); miBai2.setFont(itemFont); miBai3.setFont(itemFont); miBai4.setFont(itemFont);
        miBai5.setFont(itemFont); miBai6.setFont(itemFont); miBai7.setFont(itemFont); miBai8.setFont(itemFont); miBai9.setFont(itemFont); miBai10.setFont(itemFont);
        miBai1.setBackground(Color.WHITE); miBai2.setBackground(Color.WHITE); miBai3.setBackground(Color.WHITE); miBai4.setBackground(Color.WHITE);
        miBai5.setBackground(Color.WHITE); miBai6.setBackground(Color.WHITE); miBai7.setBackground(Color.WHITE); miBai8.setBackground(Color.WHITE); miBai9.setBackground(Color.WHITE); miBai10.setBackground(Color.WHITE);
        mOpen.add(miBai1); mOpen.add(miBai2); mOpen.add(miBai3); mOpen.add(miBai4); mOpen.add(miBai5); mOpen.add(miBai6); mOpen.add(miBai7); mOpen.add(miBai8); mOpen.add(miBai9); mOpen.add(miBai10);

        JMenu mHelp = new JMenu("Help");
        mHelp.setFont(menuFont);
        mHelp.setForeground(menuFg);
        JMenuItem miHelp = new JMenuItem("Hướng dẫn", UIManager.getIcon("OptionPane.questionIcon"));
        miHelp.setFont(itemFont);
        miHelp.setBackground(Color.WHITE);
        miHelp.setForeground(new Color(60, 120, 180));
        mHelp.add(miHelp);

        menuBar.add(mFile); menuBar.add(mOpen); menuBar.add(mHelp);
        setJMenuBar(menuBar);

        miExit.addActionListener(e -> System.exit(0));
        miHelp.addActionListener(e -> JOptionPane.showMessageDialog(this, "Chọn menu Open để thực hiện các bài tập.\nBài 3: Đăng nhập hệ thống.\nBài 4: Quản lý sinh viên.", "Hướng dẫn", JOptionPane.INFORMATION_MESSAGE));
        miBai1.addActionListener(e -> new Bai1_FormThongTin().setVisible(true));
        miBai2.addActionListener(e -> new Bai2_CongTruNhanChia().setVisible(true));
        miBai3.addActionListener(e -> new Bai3_FormLogin().setVisible(true));
        miBai4.addActionListener(e -> new Bai4_QuanLySinhVien().setVisible(true));
        miBai7.addActionListener(e -> new Bai7_PaintDonGian().setVisible(true));
        miBai8.addActionListener(e -> new Bai8_QuizTracNghiem().setVisible(true));
        miBai9.addActionListener(e -> new Bai9_QuanLySinhVienDonGian().setVisible(true));
        miBai10.addActionListener(e -> new Bai10_QuanLySanPham().setVisible(true));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai6_MenuDonGian().setVisible(true));
    }
}