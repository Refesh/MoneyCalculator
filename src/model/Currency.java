package model;

public class Currency {

    private String code;
    private String name;
    private String symbol;

    public Currency(String name, String code, String symbol) {
        this.name = name;
        this.code = code;
        this.symbol = symbol;
    }

    public Currency(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return getName() + " " + getCode() + " " + getSymbol();
    }
    
    @Override 
    public boolean equals(Object o){
        if(o instanceof Currency){
            Currency c = (Currency) o;
            if(c.code.equals(this.code)) return true;
        }
        return false;
    }
}
