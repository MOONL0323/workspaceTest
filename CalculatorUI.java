import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI extends JFrame {
    private JTextField number1Field;
    private JTextField number2Field;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JLabel resultLabel;

    public CalculatorUI() {
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        number1Field = new JTextField();
        number1Field.setBounds(50, 50, 100, 30);
        add(number1Field);

        number2Field = new JTextField();
        number2Field.setBounds(200, 50, 100, 30);
        add(number2Field);

        addButton = new JButton("Add");
        addButton.setBounds(50, 100, 100, 30);
        add(addButton);

        subtractButton = new JButton("Subtract");
        subtractButton.setBounds(200, 100, 100, 30);
        add(subtractButton);

        multiplyButton = new JButton("Multiply");
        multiplyButton.setBounds(50, 150, 100, 30);
        add(multiplyButton);

        divideButton = new JButton("Divide");
        divideButton.setBounds(200, 150, 100, 30);
        add(divideButton);

        resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50, 200, 250, 30);
        add(resultLabel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(number1Field.getText());
                int num2 = Integer.parseInt(number2Field.getText());
                int result = num1 + num2;
                resultLabel.setText("Result: " + result);
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(number1Field.getText());
                int num2 = Integer.parseInt(number2Field.getText());
                int result = num1 - num2;
                resultLabel.setText("Result: " + result);
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(number1Field.getText());
                int num2 = Integer.parseInt(number2Field.getText());
                int result = num1 * num2;
                resultLabel.setText("Result: " + result);
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(number1Field.getText());
                int num2 = Integer.parseInt(number2Field.getText());
                if (num2 != 0) {
                    int result = num1 / num2;
                    resultLabel.setText("Result: " + result);
                } else {
                    resultLabel.setText("Error: Division by zero");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorUI().setVisible(true);
            }
        });
    }
}
