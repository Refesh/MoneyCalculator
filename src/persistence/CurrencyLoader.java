package persistence;

import model.Currency;

public interface CurrencyLoader {

    public Currency[] load(String info);
    
    public Currency load(Currency currency);
}
