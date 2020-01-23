package ui;

import model.Currency;
import control.Command;
import java.util.HashMap;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    private final HashMap<String, Command> commands = new HashMap<>();
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;

    public MainFrame(Currency[] c) {
        this.setTitle("Money Calculator");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(moneyDialog(c), BorderLayout.NORTH);
        this.add(moneyDisplay(), BorderLayout.CENTER);
        this.add(southPanel(), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
    
    public void addCommand(Command c) {
        commands.put(c.name(), c);
    }

    private Component moneyDialog(Currency[] currencies) {
        SwingMoneyDialog dialog = new SwingMoneyDialog(currencies);
        moneyDialog = dialog;
        return dialog;
    }

    private Component moneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        moneyDisplay = display;
        return display;
    }

    private Component southPanel() {
        JPanel panel = new JPanel();
        panel.add(buttonCreator("Calculate"));
        return panel;
    }

    private JButton buttonCreator(String name) {
        JButton button = new JButton(name);
        button.addActionListener(addListener(name));
        return button;
    }

    private ActionListener addListener(String name) {
        return (ActionEvent e) -> {
            commands.get(name).execute();
        };
    }
}
