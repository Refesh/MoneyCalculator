package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import model.Currency;
import model.Exchangerate;

public class  FileExchangeRateLoader implements ExchangeRateLoader {
    
    Exchangerate[] exchangerates;
    
    public FileExchangeRateLoader(String fileName){
        load(fileName);
    }
    
    @Override
    public Exchangerate[] load(String fileName) {
        FileReader file = null;
        BufferedReader br = null;
        Exchangerate[] res = null;
        try{
            file = new FileReader(new File(fileName));
            br = new BufferedReader(file);
            int numElements = Integer.parseInt(br.readLine());
            res = new Exchangerate[numElements];
            for(int i = 0 ; i < numElements ; i++){
                String[] line = br.readLine().split("\\s*-\\s*");
                res[i] = new Exchangerate(new Currency (line[0]), new Currency (line[1]), Double.parseDouble(line[2]));
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        exchangerates = res;
        return res;
    }
    
    @Override
    public Exchangerate load(Currency currency1, Currency currency2) {
        if(exchangerates == null) return null;
        for (Exchangerate exchangerate : exchangerates) {
            if(exchangerate.getFrom().equals(currency1) && exchangerate.getTo().equals(currency2)){
                return exchangerate;
            }
        }
        return null;
    }
}
