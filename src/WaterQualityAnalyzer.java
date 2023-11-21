import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaterQualityAnalyzer extends JFrame {

    private JTextField[] attributeFields;
    private JTextArea resultArea;

    public WaterQualityAnalyzer() {
        setTitle("데이터 마이닝 GUI");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 속성 입력 필드
        attributeFields = new JTextField[9];
        String[] attributeNames = {"ph", "hardness", "solids", "chloramines", "sulfate", "conductivity", "organic_carbon", "trihalomethanes", "turbidity"};
        for (int i = 0; i < 9; i++) {
            attributeFields[i] = new JTextField(10);
            attributeFields[i].setToolTipText(attributeNames[i]);
        }

        // 확인 버튼
        JButton analyzeButton = new JButton("확인");
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzeWaterQuality();
            }
        });

        // 결과 텍스트 영역
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        // 레이아웃 설정 (GridBagLayout for centering)
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        // Add input fields
        for (int i = 0; i < 9; i++) {
            gbc.gridx = 0; // Column 0
            gbc.gridy = i; // Row i
            add(new JLabel(attributeNames[i] + ":"), gbc);

            gbc.gridx = 1; // Column 1
            add(attributeFields[i], gbc);
        }

        // Add analyze button
        gbc.gridx = 0; // Column 0
        gbc.gridy = 9; // Row 9
        gbc.gridwidth = 2; // Span two columns
        add(analyzeButton, gbc);

        // Add result area
        gbc.gridx = 0; // Column 0
        gbc.gridy = 10; // Row 10
        gbc.gridwidth = 2; // Span two columns
        add(new JScrollPane(resultArea), gbc);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void analyzeWaterQuality() {
        // 각 속성 값 가져오기
        double[] attributes = new double[9];
        for (int i = 0; i < 9; i++) {
            try {
                attributes[i] = Double.parseDouble(attributeFields[i].getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "숫자를 입력하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // 여기에서 데이터 마이닝 알고리즘을 적용하여 potability 계산
        double potability = calculatePotability(attributes);

        // 결과 출력
        resultArea.setText("Potability: " + potability);
    }

    private double calculatePotability(double[] attributes) {
        // 실제 데이터 마이닝 알고리즘을 적용하여 potability를 계산하는 로직을 작성

        return 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WaterQualityAnalyzer();
            }
        });
    }
}
