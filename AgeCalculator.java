import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

class AgeDisplay extends JFrame {
    private JLabel lblAge;

    public AgeDisplay(int year, int month, int date) {
        setTitle("Age Display");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblTitle = new JLabel("Your Age", SwingConstants.CENTER);
        lblTitle.setBounds(50, 20, 300, 30);
        lblTitle.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(lblTitle);

        lblAge = new JLabel("", SwingConstants.CENTER);
        lblAge.setBounds(50, 70, 300, 30);
        lblAge.setFont(new Font("Monospaced", Font.PLAIN, 18));
        add(lblAge);

        LocalDate birthDate = LocalDate.of(year, month, date);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        lblAge.setText("You are " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days old.");
    }
}

class AgeCalculator extends JFrame {
    private JTextField txtYear, txtMonth, txtDate;
    private JLabel titleLabel;

    public AgeCalculator() {
        setTitle("Age Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 400);
        panel.setBackground(new Color(12, 191, 181));
        add(panel);

        titleLabel = new JLabel("AGE CALCULATOR", SwingConstants.CENTER);
        titleLabel.setBounds(150, 10, 300, 60);
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        titleLabel.setForeground(new Color(5, 26, 27));
        panel.add(titleLabel);

        JLabel lblYear = new JLabel("Year:");
        lblYear.setBounds(50, 100, 200, 30);
        txtYear = new JTextField(20);
        txtYear.setBounds(250, 100, 200, 30);
        panel.add(lblYear);
        panel.add(txtYear);

        JLabel lblMonth = new JLabel("Month:");
        lblMonth.setBounds(50, 140, 200, 30);
        txtMonth = new JTextField(20);
        txtMonth.setBounds(250, 140, 200, 30);
        panel.add(lblMonth);
        panel.add(txtMonth);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(50, 180, 200, 30);
        txtDate = new JTextField(20);
        txtDate.setBounds(250, 180, 200, 30);
        panel.add(lblDate);
        panel.add(txtDate);

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(250, 240, 100, 30);
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int year = Integer.parseInt(txtYear.getText());
                    int month = Integer.parseInt(txtMonth.getText());
                    int date = Integer.parseInt(txtDate.getText());

                    if (year > 2024) {
                        JOptionPane.showMessageDialog(AgeCalculator.this,
                                "Invalid Input...Please input a valid year.");
                        txtYear.setText("");
                        txtYear.requestFocus();
                    } else {
						JOptionPane.showMessageDialog(AgeCalculator.this,
                                "Welcome to the World !!!");
                        new AgeDisplay(year, month, date).setVisible(true);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AgeCalculator.this,
                            "Invalid Input...Please input a valid year.");
                }
            }
        });
        panel.add(btnCalculate);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AgeCalculator().setVisible(true);
            }
        });
    }
}
