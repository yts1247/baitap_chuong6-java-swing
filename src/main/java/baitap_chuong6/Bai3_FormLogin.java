package baitap_chuong6;

import javax.swing.*;
import java.awt.*;

public class Bai3_TinhTienDien extends JFrame {
    private JTextField txtKW;
    private JLabel lblResult;
    public Bai3_TinhTienDien() {
        setTitle("Bài 3 - Tính tiền điện");
        setSize(420,180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2,6,6));

        add(new JLabel("Số kWh tiêu thụ:"));
        txtKW = new JTextField(); add(txtKW);

        lblResult = new JLabel("Tiền phải trả: ");
        add(lblResult);

        JButton btn = new JButton("Tính"); add(btn);
        btn.addActionListener(e -> {
            try {
                double kwh = Double.parseDouble(txtKW.getText().trim());
                double amount = calculate(kwh);
                lblResult.setText(String.format("Tiền phải trả: %.0f VND", amount));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Nhập số kWh không hợp lệ");
            }
        });
    }

    // Ví dụ bậc thang đơn giản
    private double calculate(double kwh) {
        double total = 0;
        double remain = kwh;
        double[] limits = {50, 50, 100, 100, 150, Double.MAX_VALUE};
        double[] price = {1678, 1734, 2014, 2536, 2834, 2927}; // ví dụ VND
        for (int i=0;i<limits.length;i++) {
            double take = Math.min(remain, limits[i]);
            total += take * price[i];
            remain -= take;
            if (remain<=0) break;
        }
        return total;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai3_TinhTienDien().setVisible(true));
    }
}