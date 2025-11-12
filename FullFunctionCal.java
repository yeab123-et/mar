import java.awt.*;// libraries for GUI components
import java.awt.event.*;//libraries Contain classes to handle events
import javax.swing.*;//libraries provide GUI components JFrame,JButton,JLabel.....

class Calculator extends JFrame implements ActionListener {//create the class that extends JFrame and implemnts actionlistener
    //label creation fn,sn,res
    JLabel fn = new JLabel("Fnum");
    JLabel sn = new JLabel("Snum");
    JLabel res = new JLabel("Result");
    
    //textfield creation
    JTextField txt1 = new JTextField(10);
    JTextField txt2 = new JTextField(10);
    JTextField txt3 = new JTextField(10);
 //buton creation
    JButton add = new JButton("+");
    JButton sub = new JButton("-");
    JButton mul = new JButton("*");
    JButton div = new JButton("/");

    JButton[] numBtn = new JButton[10];
    JButton clear = new JButton("C");

    // Track which text field to enter numbers into
    JTextField activeField = null;

    Calculator() {
        setTitle("Simple Calculator");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        txt3.setEditable(false);

        // Set focus listeners to track active field
        txt1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                activeField = txt1;
            }
        });

        txt2.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                activeField = txt2;
            }
        });

        JPanel topPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        topPanel.add(fn);
        topPanel.add(txt1);
        topPanel.add(sn);
        topPanel.add(txt2);
        topPanel.add(res);
        topPanel.add(txt3);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(4, 4, 5, 5));

        for (int i = 0; i < 10; i++) {
            numBtn[i] = new JButton(String.valueOf(i));
            numBtn[i].addActionListener(this);
        }

        centerPanel.add(numBtn[7]);
        centerPanel.add(numBtn[8]);
        centerPanel.add(numBtn[9]);
        centerPanel.add(add);

        centerPanel.add(numBtn[4]);
        centerPanel.add(numBtn[5]);
        centerPanel.add(numBtn[6]);
        centerPanel.add(sub);

        centerPanel.add(numBtn[1]);
        centerPanel.add(numBtn[2]);
        centerPanel.add(numBtn[3]);
        centerPanel.add(mul);

        centerPanel.add(numBtn[0]);
        centerPanel.add(div);
        centerPanel.add(clear);
        centerPanel.add(new JLabel("")); // empty space

        add(centerPanel, BorderLayout.CENTER);

        // add action listeners
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        clear.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        // Number buttons
        for (int i = 0; i < 10; i++) {
            if (src == numBtn[i]) {
                if (activeField != null)//check the user clicked the text field
                {
                    activeField.setText(activeField.getText() + i);
                } else {
                    // If no field selected, default to txt1
                    txt1.setText(txt1.getText() + i);
                    activeField = txt1;
                }
                return;
            }
        }

        // Clear button
        if (src == clear) {
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            activeField = null;
            return;
        }

        // Operator buttons
        try {
            double n1 = Double.parseDouble(txt1.getText());
            double n2 = Double.parseDouble(txt2.getText());
            double result = 0;

            if (src == add) result = n1 + n2;
            else if (src == sub) result = n1 - n2;
            else if (src == mul) result = n1 * n2;
            else if (src == div) result = n1 / n2;

            txt3.setText(String.valueOf(result));
  // to store the value of result on txt3 by form of string
        } catch (NumberFormatException ex) {
            txt3.setText("Enter numbers");
        } catch (ArithmeticException ex) {
            txt3.setText("Error");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
