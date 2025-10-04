package baitap_chuong6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai7_PaintDonGian extends JFrame {
    private Color currentColor = Color.BLACK;
    private int strokeSize = 3;
    private DrawPanel drawPanel;
    public Bai7_PaintDonGian() {
        setTitle("Bài 7 - Paint đơn giản");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(new Color(240, 245, 255));
        JButton btnClear = new JButton("Xóa");
        btnClear.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnClear.setBackground(new Color(255, 140, 140));
        btnClear.setForeground(Color.WHITE);
        btnClear.setFocusPainted(false);
        btnClear.setBorder(BorderFactory.createLineBorder(new Color(220, 80, 80), 2));
        JButton btnColor = new JButton("Chọn màu");
        btnColor.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnColor.setBackground(new Color(100, 180, 255));
        btnColor.setForeground(Color.WHITE);
        btnColor.setFocusPainted(false);
        btnColor.setBorder(BorderFactory.createLineBorder(new Color(80, 140, 220), 2));
        JLabel lblStroke = new JLabel("Kích thước nét:");
        lblStroke.setFont(new Font("Segoe UI", Font.BOLD, 16));
        JSpinner spStroke = new JSpinner(new SpinnerNumberModel(3, 1, 20, 1));
        spStroke.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        controlPanel.add(btnClear);
        controlPanel.add(btnColor);
        controlPanel.add(lblStroke);
        controlPanel.add(spStroke);
        add(controlPanel, BorderLayout.SOUTH);
        btnClear.addActionListener(e -> drawPanel.clear());
        btnColor.addActionListener(e -> {
            Color c = JColorChooser.showDialog(this, "Chọn màu vẽ", currentColor);
            if (c != null) {
                currentColor = c;
                drawPanel.setDrawColor(c);
            }
        });
        spStroke.addChangeListener(e -> {
            strokeSize = (int) spStroke.getValue();
            drawPanel.setStrokeSize(strokeSize);
        });
    }
    class DrawPanel extends JPanel {
        private Image image;
        private Graphics2D g2;
        private int oldX, oldY;
        public DrawPanel() {
            setBackground(Color.WHITE);
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    oldX = e.getX();
                    oldY = e.getY();
                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    if (g2 != null) {
                        g2.setColor(currentColor);
                        g2.setStroke(new BasicStroke(strokeSize));
                        g2.drawLine(oldX, oldY, x, y);
                        repaint();
                        oldX = x;
                        oldY = y;
                    }
                }
            });
        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image == null) {
                image = createImage(getSize().width, getSize().height);
                g2 = (Graphics2D) image.getGraphics();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                clear();
            }
            g.drawImage(image, 0, 0, null);
        }
        public void clear() {
            if (g2 != null) {
                g2.setPaint(Color.WHITE);
                g2.fillRect(0, 0, getSize().width, getSize().height);
                g2.setPaint(currentColor);
                repaint();
            }
        }
        public void setDrawColor(Color c) {
            currentColor = c;
        }
        public void setStrokeSize(int s) {
            strokeSize = s;
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai7_PaintDonGian().setVisible(true));
    }
}
