package baitap_chuong6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai2_CongTruNhanChia extends JFrame {
    private JTextField txtA, txtB, txtKQ;
    private JButton btnCong, btnTru, btnNhan, btnChia;

    public Bai2_CongTruNhanChia() {
        setTitle("Cộng Trừ Nhân Chia");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Số A:"));
        txtA = new JTextField();
        add(txtA);

        add(new JLabel("Số B:"));
        txtB = new JTextField();
        add(txtB);

        add(new JLabel("Kết quả:"));
        txtKQ = new JTextField();
        txtKQ.setEditable(false);
        add(txtKQ);

        JPanel panelBtn = new JPanel();
        btnCong = new JButton("+");
        btnTru = new JButton("-");
        btnNhan = new JButton("*");
        btnChia = new JButton("/");
        panelBtn.add(btnCong);
        panelBtn.add(btnTru);
        panelBtn.add(btnNhan);
        panelBtn.add(btnChia);
        add(panelBtn);

        ActionListener action = e -> {
            try {
                double a = Double.parseDouble(txtA.getText());
                double b = Double.parseDouble(txtB.getText());
                double kq = 0;
                if (e.getSource() == btnCong) kq = a + b;
                else if (e.getSource() == btnTru) kq = a - b;
                else if (e.getSource() == btnNhan) kq = a * b;
                else if (e.getSource() == btnChia) kq = a / b;
                txtKQ.setText(String.valueOf(kq));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi nhập số!");
            }
        };

        btnCong.addActionListener(action);
        btnTru.addActionListener(action);
        btnNhan.addActionListener(action);
        btnChia.addActionListener(action);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai2_CongTruNhanChia().setVisible(true));
    }
}
