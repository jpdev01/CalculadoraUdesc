package UI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Calculator;
import models.Operation;

public class GUI extends JFrame implements ActionListener {
    public static JFrame frame;
    public static JTextField textField;
    
    Calculator calculadora =  new Calculator();

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
    public JButton beq1;
    public JButton ba;
    public JButton bs;
    public JButton bd;
    public JButton bm;
    public JButton beq;

    public String firstValueInfo = "";
    public String secondValueInfo = "";
    public String resultValue = "";

    private static final String CLEAR_COMMAND = "C";

    private static final String EQUALS_COMMAND = "=";

    public GUI() {

        frame = new JFrame("calculator");

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
        this.beq1 = new JButton("=");
        this.ba = new JButton("+");
        this.bs = new JButton("-");
        this.bd = new JButton("/");
        this.bm = new JButton("*");
        this.beq = new JButton("C");

        JPanel painel = new JPanel();

        bm.addActionListener(this);
        bd.addActionListener(this);
        bs.addActionListener(this);
        ba.addActionListener(this);

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
        beq.addActionListener(this);
        beq1.addActionListener(this);

        painel.add(textField);
        painel.add(ba);
        painel.add(b1);
        painel.add(b2);
        painel.add(b3);
        painel.add(bs);
        painel.add(b4);
        painel.add(b5);
        painel.add(b6);
        painel.add(bm);
        painel.add(b7);
        painel.add(b8);
        painel.add(b9);
        painel.add(bd);
        painel.add(b0);
        painel.add(beq);
        painel.add(beq1);

        painel.setBackground(Color.GRAY);
        frame.add(painel);

        frame.setSize(200, 220);
        frame.show();
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
            this.calculadora.setOperation(operation);
            this.isFirstValue = !isFirstValue;
            textField.setText("");
        }

        final List<String> commands = new ArrayList<>();
        commands.add(CLEAR_COMMAND);
        commands.add(EQUALS_COMMAND);

        boolean isNumber = operation == null && !commands.contains(selected);
        if (isNumber) {
            if (isFirstValue) {
                this.firstValueInfo += selected;
                textField.setText(firstValueInfo);
                calculadora.setFirstOperator(new Double(firstValueInfo));
            } else {
                this.secondValueInfo += selected;
                textField.setText(secondValueInfo);
                calculadora.setSecondOperator(new Double(secondValueInfo));
            }
        }
    }

    private void clear() {
        textField.setText("");
        firstValueInfo = "";
        secondValueInfo = "";
        resultValue = "";
    }

    private void calculate() {
        double result = calculadora.execute();
        this.resultValue = String.valueOf(result);
        textField.setText(this.resultValue);

        this.firstValueInfo = this.resultValue;
        calculadora.setFirstOperator(calculadora.execute());

        this.secondValueInfo = "";
        calculadora.setSecondOperator(0);

        this.isFirstValue = true;
    }
}
