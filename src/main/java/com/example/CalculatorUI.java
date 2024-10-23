package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI extends JFrame implements ActionListener {
    private JTextField display;
    private Calculator calculator;
    private String currentInput;
    private String operator;
    private int firstOperand;

    public CalculatorUI() {
        calculator = new Calculator();
        currentInput = "";
        operator = "";
        firstOperand = 0;

        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            currentInput += command;
            display.setText(currentInput);
        } else if (command.equals("C")) {
            currentInput = "";
            operator = "";
            firstOperand = 0;
            display.setText("");
        } else if (command.equals("=")) {
            int secondOperand = Integer.parseInt(currentInput);
            int result = 0;

            switch (operator) {
                case "+":
                    result = calculator.add(firstOperand, secondOperand);
                    break;
                case "-":
                    result = calculator.subtract(firstOperand, secondOperand);
                    break;
                case "*":
                    result = calculator.multiply(firstOperand, secondOperand);
                    break;
                case "/":
                    result = calculator.divide(firstOperand, secondOperand);
                    break;
            }

            display.setText(String.valueOf(result));
            currentInput = "";
            operator = "";
            firstOperand = 0;
        } else {
            operator = command;
            firstOperand = Integer.parseInt(currentInput);
            currentInput = "";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorUI calculatorUI = new CalculatorUI();
            calculatorUI.setVisible(true);
        });
    }
}
