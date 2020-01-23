package main;

import persistence.FileCurrencyLoader;
import persistence.CurrencyLoader;
import control.calculateCommand;
import ui.MainFrame;
import persistence.ExchangeRateLoader;
import persistence.FileExchangeRateLoader;
import model.Currency;

public class Main {
    public static void main(String args[]){
        CurrencyLoader fcl = new FileCurrencyLoader();
        Currency [] gg = fcl.load("files/Currencies.txt");
        ExchangeRateLoader erl = new FileExchangeRateLoader("files\\ExchangeRate.txt");
        MainFrame m = new MainFrame(gg);
        m.addCommand(new calculateCommand(m.getMoneyDialog(),m.getMoneyDisplay(),erl));
    }
}
