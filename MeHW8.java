package ru.geekbrains.lesson8;
/*1. Доработать счетчик.
2. Изменить тип отображаемого значения счетчика на тестовое поле (JTextField).
3. Добавить возможность изменять значение счетчика во время работы приложения, с помощью ввода нового значения в текстовое поле и нажатию Enter.
Уточнение: (После нажатия на Enter дальнейшее увеличение и уменьшение счетчика происходит от нового заданного значения)

        Font font = new Font("Arial", Font.BOLD, 32);
        JLabel counterValueView = new JLabel();   //JLabel для неизменяемого поля.
        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValueView, BorderLayout.CENTER);
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MeHW8 extends JFrame {
    private int value;
    public MeHW8(int initialValue) {
        setTitle("Simple counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 500, 300, 120);

        Font font = new Font("Arial", Font.BOLD, 32);
        JTextField counterValueView = new JTextField();
        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValueView, BorderLayout.CENTER);

        value = initialValue;
        counterValueView.setText(String.valueOf(value));

        counterValueView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    value = Integer.parseInt(counterValueView.getText());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                System.out.println(counterValueView.getText());

            }
        });

        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        add(decrementButton, BorderLayout.WEST);

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        add(incrementButton, BorderLayout.EAST);

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value --;
                counterValueView.setText(String.valueOf(value));
            }
        });
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value ++;
                counterValueView.setText(String.valueOf(value));
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new MeHW8(0);
    }


}
