package baitap_chuong6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai8_QuizTracNghiem extends JFrame {
    private int current = 0, score = 0;
    private final String[] questions = {
        "Thủ đô của Việt Nam là?",
        "Số pi xấp xỉ bằng?",
        "Java là ngôn ngữ gì?",
        "Màu cờ Việt Nam là?"
    };
    private final String[][] answers = {
        {"Hà Nội", "Huế", "Đà Nẵng", "TP.HCM"},
        {"2.14", "3.14", "4.13", "1.34"},
        {"Lập trình", "Thiết kế", "Đồ họa", "Kế toán"},
        {"Đỏ vàng", "Xanh trắng", "Đỏ xanh", "Vàng xanh"}
    };
    private final int[] correct = {0,1,0,0};
    private ButtonGroup group;
    private JRadioButton[] rbs;
    private JLabel lblQ, lblScore;
    private JButton btnNext;
    public Bai8_QuizTracNghiem() {
        setTitle("Bài 8 - Quiz trắc nghiệm");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(480,340);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Font font = new Font("Segoe UI", Font.BOLD, 16);
        Color bgColor = new Color(240, 245, 255);
        getContentPane().setBackground(bgColor);
        lblQ = new JLabel();
        lblQ.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblQ.setForeground(new Color(40, 60, 120));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.insets = new Insets(18, 0, 18, 0); gbc.anchor = GridBagConstraints.CENTER;
        add(lblQ, gbc);
        gbc.gridwidth = 1;
        rbs = new JRadioButton[4];
        group = new ButtonGroup();
        for (int i=0; i<4; i++) {
            rbs[i] = new JRadioButton();
            rbs[i].setFont(font);
            rbs[i].setBackground(bgColor);
            group.add(rbs[i]);
            gbc.gridx = 0; gbc.gridy = i+1; gbc.gridwidth = 2; gbc.insets = new Insets(4, 24, 4, 0); gbc.anchor = GridBagConstraints.WEST;
            add(rbs[i], gbc);
        }
        btnNext = new JButton("Tiếp tục");
        btnNext.setFont(font);
        btnNext.setBackground(new Color(100, 180, 255));
        btnNext.setForeground(Color.WHITE);
        btnNext.setFocusPainted(false);
        btnNext.setBorder(BorderFactory.createLineBorder(new Color(80, 140, 220), 2));
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; gbc.insets = new Insets(18, 0, 18, 0); gbc.anchor = GridBagConstraints.CENTER;
        add(btnNext, gbc);
        lblScore = new JLabel();
        lblScore.setFont(font);
        lblScore.setForeground(new Color(60, 160, 60));
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2; gbc.insets = new Insets(8, 0, 8, 0); gbc.anchor = GridBagConstraints.CENTER;
        add(lblScore, gbc);
        showQuestion();
        btnNext.addActionListener(e -> {
            int ans = -1;
            for (int i=0; i<4; i++) if (rbs[i].isSelected()) ans = i;
            if (ans == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn đáp án!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (ans == correct[current]) score++;
            current++;
            if (current < questions.length) {
                showQuestion();
            } else {
                int diem = (int)Math.round(score*10.0/questions.length);
                lblScore.setText("Điểm của bạn: " + diem + "/10");
                btnNext.setEnabled(false);
            }
            group.clearSelection();
        });
    }
    private void showQuestion() {
        lblQ.setText("Câu hỏi " + (current+1) + ": " + questions[current]);
        for (int i=0; i<4; i++) rbs[i].setText(answers[current][i]);
        lblScore.setText("");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai8_QuizTracNghiem().setVisible(true));
    }
}

