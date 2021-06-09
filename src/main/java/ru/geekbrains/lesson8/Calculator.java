package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Calculator extends JFrame {
    private String text = "";
    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 500);

        Font font = new Font("Arial", Font.BOLD, 10);
        JLabel screen = new JLabel();
        screen.setFont(font);
        screen.setHorizontalAlignment(SwingConstants.CENTER);
        add(screen, BorderLayout.CENTER);

        setLayout(new GridLayout(6,3));
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("*");
        JButton devide = new JButton("/");
        JButton delete = new JButton("delete");
        JButton eraseAll = new JButton("C");
        JButton equals = new JButton("=");
        JButton zero = new JButton("0");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");

        JButton [] buttons = {plus, minus, multiply, devide, delete, eraseAll, equals,zero,one,two,
        three,four, five, six, seven, eight, nine};
        for (int i = 0; i < buttons.length; i++) {
            add(buttons[i]);
        }

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (text.equals("")) {       // не печатает первым знак
                } else {
                    String lastChar = text.substring(text.length() - 1);   // не печатает два знака подряд
                    if (!lastChar.equals("+") && !lastChar.equals("-") && !lastChar.equals("*") && !lastChar.equals("/")) {
                        text = text + "+";
                        screen.setText(String.valueOf(text));
                    }
                }
            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (text.equals("")) {
                } else {
                    String lastChar = text.substring(text.length() - 1);
                    if (!lastChar.equals("+") && !lastChar.equals("-") && !lastChar.equals("*") && !lastChar.equals("/")) {
                        text = text + "-";
                        screen.setText(String.valueOf(text));
                    }
                }
            }
        });
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (text.equals("")) {
                } else {
                    String lastChar = text.substring(text.length() - 1);
                    if (!lastChar.equals("+") && !lastChar.equals("-") && !lastChar.equals("*") && !lastChar.equals("/")) {
                        text = text + "*";
                        screen.setText(String.valueOf(text));
                    }
                }
            }
        });
        devide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (text.equals("")) {
                } else {
                    String lastChar = text.substring(text.length() - 1);
                    if (!lastChar.equals("+") && !lastChar.equals("-") && !lastChar.equals("*") && !lastChar.equals("/")) {
                        text = text + "/";
                        screen.setText(String.valueOf(text));
                    }
                }
            }
        });
        eraseAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = "";
                screen.setText(String.valueOf(text));
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!text.equals("")) {
                    text = text.substring(0, text.length() - 1);
                    screen.setText(String.valueOf(text));
                }
            }
        });
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = text + "0";
                screen.setText(String.valueOf(text));
            }
        });
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = text + "1";
                screen.setText(String.valueOf(text));
            }
        });
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = text + "2";
                screen.setText(String.valueOf(text));
            }
        });
        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = text + "3";
                screen.setText(String.valueOf(text));
            }
        });
        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = text + "4";
                screen.setText(String.valueOf(text));
            }
        });
        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = text + "5";
                screen.setText(String.valueOf(text));
            }
        });
        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = text + "6";
                screen.setText(String.valueOf(text));
            }
        });
        seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = text + "7";
                screen.setText(String.valueOf(text));
            }
        });
        eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = text + "8";
                screen.setText(String.valueOf(text));
            }
        });
        nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = text + "9";
                screen.setText(String.valueOf(text));
            }
        });
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!text.equals("")) {
                    List<String> list = new ArrayList<>();
                    String part = "";
                    for (int i = 0; i < text.length(); i++) {
                        String current = text.substring(i, i + 1);   // дописать, если первый знак минус, то число отрицательное, чтобы можно было нажимать равно
                        // сейчас нельзя внести отрицательное число и проводить операции с отрицательными числами
                        if (!current.equals("+") && !current.equals("-") && !current.equals("/") &&
                                !current.equals("*")) {
                            part = part + current;
                            if (i == text.length() - 1) {
                                list.add(part);
                            }
                        } else {
                            list.add(part);
                            list.add(current);
                            part = "";
                        }
                    }
                    int result = parseInt(list.get(0));
                    for (int i = 1; i < list.size() - 1; i++) {
                        if (list.get(i).equals("+")) {
                            result = result + parseInt(list.get(i + 1));
                        } else if (list.get(i).equals("-")) {
                            result = result - parseInt(list.get(i + 1));
                        } else if (list.get(i).equals("*")) {
                            result = result * parseInt(list.get(i + 1));
                        } else if (list.get(i).equals("/")) {
                            result = result / parseInt(list.get(i + 1));
                        }
                        i = i + 1;
                    }
                    screen.setText(String.valueOf(result));
                    text = Integer.toString(result);
                }
            }
        });
        setVisible(true);
    }

}
