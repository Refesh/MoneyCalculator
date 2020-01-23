package ui;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Currency;
import model.Money;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {

    private final Currency[] currencies;
    private JComboBox currenciesToolBar;
    private JTextField amount;

    public SwingMoneyDialog(Currency[] c) {
        currencies = c;
        this.add(textFieldAmount());
        this.add(label("€ "));
        this.add(label("To "));
        this.add(toolBarCurrencies());
    }

    @Override
    public Money getMoney() {
        Money money = new Money(getAmount(), fromCurrency());
        return money;
    }

    @Override
    public Currency toCurrency() {
        return (Currency) currenciesToolBar.getSelectedItem();
    }

    public Currency fromCurrency() {
        return new Currency("Euro", "EUR", "€");
    }

    public double getAmount() {
        return Double.parseDouble(amount.getText());
    }

    public Component textFieldAmount() {
        JTextField textField = new JTextField("100");
        textField.setColumns(10);
        amount = textField;
        return textField;
    }

    public Component toolBarCurrencies() {
        JComboBox jcb = new JComboBox(currencies);
        currenciesToolBar = jcb;
        return jcb;
    }

    public Component label(String name) {
        return new JLabel(name);
    }
}
