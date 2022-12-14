package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Calculator;
import models.Operation;

public class GUI extends JFrame implements ActionListener {
    public static JFrame frame;
    public static JTextField textField;
    
    Calculator calculator =  new Calculator();

    public boolean isFirstValue = true;

    public JButton b0;
    public JButton b1;
    public JButton b2;
    public JButton b3;
    public JButton b4;
    public JButton b5;
    public JButton b6;
    public JButton b7;
    public JButton b8;
    public JButton b9;
    public JButton executeButton;
    public JButton sumButton;
    public JButton subtractButton;
    public JButton divisionButton;
    public JButton multiplicationButton;
    public JButton clearButton;

    public String firstValueInfo = "";
    public String secondValueInfo = "";
    public String resultValue = "";

    private static final String CLEAR_COMMAND = "C";

    private static final String EQUALS_COMMAND = "=";

    private ArrayList<JButton> numericButtonList = new ArrayList();

    private ArrayList<JButton> operatorButtonList = new ArrayList();

    public GUI() {
        frame = new JFrame("CALCULADORA");

        textField = new JTextField(16);
        textField.setEditable(false);

        this.b0 = new JButton("0");
        this.b1 = new JButton("1");
        this.b2 = new JButton("2");
        this.b3 = new JButton("3");
        this.b4 = new JButton("4");
        this.b5 = new JButton("5");
        this.b6 = new JButton("6");
        this.b7 = new JButton("7");
        this.b8 = new JButton("8");
        this.b9 = new JButton("9");
        this.numericButtonList.addAll(new ArrayList<>(Arrays.asList(this.b0, this.b1, this.b2, this.b3, this.b4, this.b5, this.b6, this.b7, this.b8, this.b9)));

        this.executeButton = new JButton(EQUALS_COMMAND);
        this.sumButton = new JButton(Operation.ADICAO.getOperationSymbol());
        this.subtractButton = new JButton(Operation.SUBTRACAO.getOperationSymbol());
        this.divisionButton = new JButton(Operation.DIVISAO.getOperationSymbol());
        this.multiplicationButton = new JButton(Operation.MULTIPLICACAO.getOperationSymbol());
        this.operatorButtonList.addAll(new ArrayList<>(Arrays.asList(this.sumButton, this.multiplicationButton, this.divisionButton, this.subtractButton)));

        this.clearButton = new JButton(CLEAR_COMMAND);

        JPanel panel = new JPanel();

        multiplicationButton.addActionListener(this);
        divisionButton.addActionListener(this);
        subtractButton.addActionListener(this);
        sumButton.addActionListener(this);

        b9.addActionListener(this);
        b8.addActionListener(this);
        b7.addActionListener(this);
        b6.addActionListener(this);
        b5.addActionListener(this);
        b4.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
        b1.addActionListener(this);
        b0.addActionListener(this);
        clearButton.addActionListener(this);
        executeButton.addActionListener(this);

        panel.add(textField);
        panel.add(sumButton);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(subtractButton);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(multiplicationButton);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(divisionButton);
        panel.add(clearButton);
        panel.add(b0);
        panel.add(executeButton);

        for (JButton numericButton : numericButtonList) {
            numericButton.setBackground(Color.ORANGE);
        }
        panel.setBackground(Color.LIGHT_GRAY);
        frame.add(panel);

        frame.setSize(200, 220);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selected = e.getActionCommand();

        if (selected.equals(EQUALS_COMMAND)) {
            calculate();
            return;
        }
        if (selected.equals(CLEAR_COMMAND)) {
            clear();
            return;
        }

        Operation operation = Operation.findByOperationSymbol(selected);
        if (operation != null) {
            this.calculator.setOperation(operation);
            toggleFirstValue();
            textField.setText("");
            return;
        }

        if (isFirstValue) {
            this.firstValueInfo += selected;
            textField.setText(firstValueInfo);
            calculator.setFirstOperator(new Double(firstValueInfo));
        } else {
            this.secondValueInfo += selected;
            textField.setText(secondValueInfo);
            calculator.setSecondOperator(new Double(secondValueInfo));
        }
    }

    private void clear() {
        textField.setText("");
        firstValueInfo = "";
        secondValueInfo = "";
        resultValue = "";

        this.calculator =  new Calculator();
    }

    private void calculate() {
        double result = calculator.execute();
        this.resultValue = String.valueOf(result);
        textField.setText(this.resultValue);

        this.firstValueInfo = this.resultValue;
        calculator.setFirstOperator(calculator.execute());

        this.secondValueInfo = "";
        calculator.setSecondOperator(0);

        this.isFirstValue = true;
    }

    private void toggleFirstValue() {
        this.isFirstValue = !this.isFirstValue;
    }
}
