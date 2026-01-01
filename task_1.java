import java.awt.*;
import java.awt.event.*;

public class CalculatorAWT extends Frame implements ActionListener {

    TextField t1, t2, t3;
    Button add, sub, mul, div, clr;

    CalculatorAWT() {

        // Frame settings
        setTitle("AWT Calculator");
        setSize(400, 300);
        setLayout(null);

        // Labels
        Label l1 = new Label("Number 1:");
        Label l2 = new Label("Number 2:");
        Label l3 = new Label("Result:");

        l1.setBounds(50, 50, 70, 20);
        l2.setBounds(50, 90, 70, 20);
        l3.setBounds(50, 130, 70, 20);

        add(l1); add(l2); add(l3);

        // TextFields
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t3.setEditable(false);

        t1.setBounds(130, 50, 150, 20);
        t2.setBounds(130, 90, 150, 20);
        t3.setBounds(130, 130, 150, 20);

        add(t1); add(t2); add(t3);

        // Buttons
        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");
        clr = new Button("Clear");

        add.setBounds(50, 180, 50, 30);
        sub.setBounds(110, 180, 50, 30);
        mul.setBounds(170, 180, 50, 30);
        div.setBounds(230, 180, 50, 30);
        clr.setBounds(290, 180, 60, 30);

        add(add); add(sub); add(mul); add(div); add(clr);

        // Action Listeners
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        clr.addActionListener(this);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());
            double result = 0;

            if (e.getSource() == add)
                result = a + b;
            else if (e.getSource() == sub)
                result = a - b;
            else if (e.getSource() == mul)
                result = a * b;
            else if (e.getSource() == div) {
                if (b == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                result = a / b;
            }

            t3.setText(String.valueOf(result));

        } catch (ArithmeticException ex) {
            t3.setText("Divide by Zero!");
        } catch (NumberFormatException ex) {
            tS