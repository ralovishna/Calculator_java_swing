import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.util.ArrayList;

class RoundedBorder implements javax.swing.border.Border {
    private int radius;
    private Color color;
    private Component c;

    public RoundedBorder(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    public Insets getBorderInsets(Component c) {
        this.c = c;
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.color);
        g2.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius, radius));
    }
}

public class CalcClass extends JFrame implements ActionListener {
    private JButton answer = new JButton("Ans");
    private JButton buttons[] = new JButton[18];

    private JTextField screen = new JTextField();
    private JFrame myFrame = new JFrame();


    public CalcClass() {
        screen.setBounds(0, 0, 425, 100);
        screen.setBackground(Color.black);
        screen.setBorder(BorderFactory.createBevelBorder(1));
        screen.setForeground(Color.white);
        screen.setOpaque(true);
        screen.setFont(new Font("ink free", Font.BOLD, 40));
        screen.setBorder(BorderFactory.createLineBorder(Color.decode("#FD7F20")));
        screen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    answer.doClick();
                } else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
                    buttons[11].doClick();
                else {
                    if (String.valueOf(e.getKeyChar()).equals("+")) {
                        buttons[13].doClick();
                    } else if (String.valueOf(e.getKeyChar()).equals("-")) {
                        buttons[14].doClick();
                    } else if (String.valueOf(e.getKeyChar()).equals("*")) {
                        buttons[15].doClick();
                    } else if (String.valueOf(e.getKeyChar()).equals("/")) {
                        buttons[16].doClick();
                    } else if (String.valueOf(e.getKeyChar()).equals("%")) {
                        buttons[17].doClick();
                    } else if (String.valueOf(e.getKeyChar()).equals(".")) {
                        buttons[12].doClick();
                    } else {
                        int index = Integer.parseInt(String.valueOf(e.getKeyChar()));
                        buttons[index].doClick();
                    }
                    e.consume();
                }

            }
        });

        answer.setFont(new Font("ink free", Font.BOLD, 54));
        answer.setBounds(425, 0, 175, 100);
        answer.setForeground(Color.decode("#FD7F20"));
        answer.setBorder(BorderFactory.createLineBorder(Color.decode("#FD7F20")));
        answer.setBackground(Color.decode("#301934"));
        answer.setOpaque(true);
        answer.setFocusable(false);
        answer.addActionListener(this);

        String[] s = {"AC", "C"};
        String[] q = {".", "+", "-", "*", "/", "%"};

        for (int i = 0, y = 100, k = 0; i < 3; i++) {
            int x = 0;

            if (i == 0) {
                for (int j = 0; j < 4; j++) {
                    String o = Integer.toString(k++);
                    buttons[j] = new JButton(o);
                    buttons[j].setFont(new Font("Ink free", Font.BOLD, 40));
                    buttons[j].setBounds(x, y, 150, 100);
                    buttons[j].setBorder(BorderFactory.createLineBorder(Color.black));
                    buttons[j].setBackground(Color.black);
                    buttons[j].setForeground(Color.white);
                    buttons[j].setOpaque(true);
                    buttons[j].setFocusable(false);
                    buttons[j].addActionListener(this);

                    x += 150;

                    myFrame.add(buttons[j]);
                }
            } else if (i == 1) {
                for (int j = (2 * i + 2); j < (2 * i + 5); j++) {
                    String o = Integer.toString(k++);

                    buttons[j] = new JButton(o);
                    buttons[j].setFont(new Font("Ink free", Font.BOLD, 40));
                    buttons[j].setBounds(x, y, 150, 100);
                    buttons[j].setBorder(BorderFactory.createLineBorder(Color.black));
                    buttons[j].setBackground(Color.black);
                    buttons[j].setForeground(Color.white);
                    buttons[j].setOpaque(true);
                    buttons[j].setFocusable(false);
                    buttons[j].addActionListener(this);

                    x += 150;

                    myFrame.add(buttons[j]);
                }
            } else {
                for (int j = (3 * i + 1); j < (3 * i + 4); j++) {
                    String o = Integer.toString(k++);

                    buttons[j] = new JButton(o);
                    buttons[j].setFont(new Font("Ink free", Font.BOLD, 40));
                    buttons[j].setBounds(x, y, 150, 100);
                    buttons[j].setBorder(BorderFactory.createLineBorder(Color.black));
                    buttons[j].setBackground(Color.black);
                    buttons[j].setForeground(Color.white);
                    buttons[j].setOpaque(true);
                    buttons[j].setFocusable(false);
                    buttons[j].addActionListener(this);

                    x += 150;

                    myFrame.add(buttons[j]);
                }
            }
            y += 100;
        }


        for (int i = 10, y = 200; i < 12; i++) {
            buttons[i] = new JButton(s[(i - 10)]);
            buttons[i].setFont(new Font("times new roman", Font.BOLD, 40));
            buttons[i].setBounds(450, y, 150, 100);
            buttons[i].setBorder(new RoundedBorder(15, Color.decode("#FF8300")));
            buttons[i].setForeground(Color.decode("#FF8300"));
            buttons[i].setBackground(Color.black);
            buttons[i].setOpaque(true);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

            myFrame.add(buttons[i]);

            y += 100;
        }

        for (int i = 12, y = 400, x = 0; i < 18; i++) {
            buttons[i] = new JButton(q[(i - 12)]);
            buttons[i].setFont(new Font("times new roman", Font.BOLD, 65));
            buttons[i].setBounds(x, y, 200, 100);
            buttons[i].setBackground(Color.black);
            buttons[i].setForeground(Color.decode("#FD7F20"));
            buttons[i].setBorder(BorderFactory.createBevelBorder(2));
            buttons[i].setOpaque(true);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

            myFrame.add(buttons[i]);

            if (x <= 399)
                x += 200;
            else {
                x = 0;
                y += 100;
            }
        }

        myFrame.add(screen);
        myFrame.add(answer);
        myFrame.setTitle("Calculator");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(614, 633);
        myFrame.setResizable(false);
        myFrame.setBackground(Color.decode("#FD7F20"));
        myFrame.setLayout(null);
        myFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            String buttonText = ((JButton)e.getSource()).getText();

            if (buttonText.equals("Ans")) {
                ArrayList<Double> nums = new ArrayList<>();
                ArrayList<Character> ops= new ArrayList<>();

                String n = screen.getText();
                int i = 0, m = 0;

                while(i < n.length()) {
                    if (checkOperator(n.charAt(i))) {
                        ops.add(n.charAt(i));
                        nums.add(Double.valueOf(n.substring(m, i)));
                        m = ++i;
                    }
                    i++;
                }

                nums.add(Double.valueOf(n.substring(m, i)));
                
                double result = nums.get(0);
                i = 0;
                if (nums.size() >= 2 && ops.size() >= 1) {
                    while (i < ops.size()) {
                        switch (ops.get(i)) {
                            case '+' :
                                result += nums.get(++i);
                                break;
                            case '-' :
                                result -= nums.get(++i);
                                break;
                            case '*' :
                                result *= nums.get(++i);
                                break;
                            case '/' :
                                result /= nums.get(++i);
                                break;
                            case '%' :
                                result %= nums.get(++i);
                                break;
                        }
                    }
                }
                screen.setText(String.valueOf(result));

            }

            else if (buttonText.equals("C")) {
                screen.setText(screen.getText().substring(0,screen.getText().length()));
            }

            else if (buttonText.equals(".")) {
                screen.setText(screen.getText() + ".");
            }

            else if (buttonText.equals("AC")) {
                screen.setText("0");
            }

            else if (buttonText.equals("0")) {
                if (screen.getText().equals("0") && screen.getText().length() == 1)
                    screen.setText("0");
                else
                    screen.setText(screen.getText() + "0");
            }

            else {
                screen.setText(screen.getText() + buttonText);
            }
    }

    private boolean checkOperator(char charAt) {
        switch (charAt) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
                return true;
            default:
                return false;
        }
    }
}