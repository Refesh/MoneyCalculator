package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import model.Currency;

public class FileCurrencyLoader implements CurrencyLoader {

    private Currency[] currencies;

    @Override
    public Currency[] load(String fileName) {
        FileReader file = null;
        BufferedReader br = null;
        Currency[] res = null;
        try {
            file = new FileReader(new File(fileName));
            br = new BufferedReader(file);
            int numElements = Integer.parseInt(br.readLine());
            res = new Currency[numElements];
            for (int i = 0; i < numElements; i++) {
                String[] line = br.readLine().split("\\s*-\\s*");
                res[i] = new Currency(line[0], line[1], line[2]);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        currencies = res;
        return res;
    }

    @Override
    public Currency load(Currency currency) {
        for (Currency currency1 : currencies) {
            if (currency1.equals(currency)) return currency1;
        }
        return null;
    }
}
