package persistence;

import model.Currency;
import model.Exchangerate;

public interface ExchangeRateLoader {

    public Exchangerate[] load(String info);
    
    public Exchangerate load(Currency currency1, Currency curreny2);
}
