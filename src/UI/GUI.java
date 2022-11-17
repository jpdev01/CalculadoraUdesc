package UI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Calculadora;
import models.Operation;

public class GUI extends JFrame implements ActionListener {
    public static JFrame frame;
    public static JTextField textField;
    
    Calculadora calculadora =  new Calculadora();

    public boolean isFirstNumber = true;

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

    public String s0 = "";
    public String s1 = "";
    public String s2 = "";

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


        if (selected.equals("+")) {
            this.calculadora.setOperation(Operation.ADICAO);
            this.isFirstNumber = !isFirstNumber;
            textField.setText("");
        } else if (selected.equals("-")) {
            this.calculadora.setOperation(Operation.SUBTRACAO);
            this.isFirstNumber = !isFirstNumber;
            textField.setText("");
        } else if (selected.equals("*")) {
            this.calculadora.setOperation(Operation.MULTIPLICACAO);
            this.isFirstNumber = !isFirstNumber;
            textField.setText("");
        } else if (selected.equals("/")) {
            this.calculadora.setOperation(Operation.DIVISAO);
            this.isFirstNumber = !isFirstNumber;
            textField.setText("");
        }

        if (isFirstNumber && !(selected.equals("+") || selected.equals("-") || selected.equals("*") || selected.equals("/") || selected.equals("=") || selected.equals("C"))) {
            this.s0 += selected;
            textField.setText(s0.toString());
            calculadora.setOperador1(new Double(s0));
        } else if (!isFirstNumber && !(selected.equals("+") || selected.equals("-") || selected.equals("*") || selected.equals("/") || selected.equals("=") || selected.equals("C"))) {
            this.s1 += selected;
            textField.setText(s1.toString());
            calculadora.setOperador2(new Double(s1));
        }

        if (selected.equals("=")) {
            s2 = String.valueOf(calculadora.calcular());
            textField.setText(s2);
            s0 = s2;
            s1 = "";
        } else if (selected.equals("C")) {
            textField.setText("");
            s0 = "";
            s1 = "";
            s2 = "";
        }



        // // if the value is a number
        // if ((selected.charAt(0) >= '0' && selected.charAt(0) <= '9') || selected.charAt(0) == '.') {
        //     // if operand is present then add to second no
        //     if (!s1.equals(""))
        //         s2 = s2 + selected;
        //     else
        //         s0 = s0 + selected;

        //     // set the value of text
        //     textField.setText(s0 + s1 + s2);
        // } else if (selected.charAt(0) == 'C') {
        //     // clear the one letter
        //     s0 = s1 = s2 = "";

        //     // set the value of text
        //     textField.setText(s0 + s1 + s2);
        // } else if (selected.charAt(0) == '=') {

        //     double te;

        //     // store the value in 1st
        //     if (s1.equals("+"))
        //         te = (Double.parseDouble(s0) + Double.parseDouble(s2));
        //     else if (s1.equals("-"))
        //         te = (Double.parseDouble(s0) - Double.parseDouble(s2));
        //     else if (s1.equals("/"))
        //         te = (Double.parseDouble(s0) / Double.parseDouble(s2));
        //     else
        //         te = (Double.parseDouble(s0) * Double.parseDouble(s2));

        //     // set the value of text
        //     textField.setText(s0 + s1 + s2 + "=" + te);

        //     // convert it to string
        //     s0 = Double.toString(te);

        //     s1 = s2 = "";
        // } else {
        //     // if there was no operand
        //     if (s1.equals("") || s2.equals(""))
        //         s1 = selected;
        //     // else evaluate
        //     else {
        //         double te;

        //         // store the value in 1st
        //         if (s1.equals("+"))
        //             te = (Double.parseDouble(s0) + Double.parseDouble(s2));
        //         else if (s1.equals("-"))
        //             te = (Double.parseDouble(s0) - Double.parseDouble(s2));
        //         else if (s1.equals("/"))
        //             te = (Double.parseDouble(s0) / Double.parseDouble(s2));
        //         else
        //             te = (Double.parseDouble(s0) * Double.parseDouble(s2));

        //         // convert it to string
        //         s0 = Double.toString(te);

        //         // place the operator
        //         s1 = selected;

        //         // make the operand blank
        //         s2 = "";
        //     }

        //     // set the value of text
        //     textField.setText(s0 + s1 + s2);
        // }
    }
}
