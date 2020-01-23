package control;

import ui.MoneyDialog;
import ui.MoneyDisplay;
import persistence.ExchangeRateLoader;
import model.Money;

public class calculateCommand implements Command {

    private final MoneyDialog mDialog;
    private final MoneyDisplay mDisplay;
    private final ExchangeRateLoader cLoader;

    public calculateCommand(MoneyDialog mDialog, MoneyDisplay mDisplay, ExchangeRateLoader cLoader) {
        this.mDialog = mDialog;
        this.mDisplay = mDisplay;
        this.cLoader = cLoader;
    }

    @Override
    public void execute() {
        Money moneyConverted = exchange(mDialog.getMoney());
        mDisplay.display(moneyConverted);
    }
    
    private Money exchange(Money money) {
        return new Money(money.getAmount() * rateOf(money), money.getCurrency());
    }
    
    private double rateOf(Money money) {
        return cLoader.load(money.getCurrency(), mDialog.toCurrency()).getRate();
    }
    
    @Override
    public String name() {
        return "Calculate";
    }
}
