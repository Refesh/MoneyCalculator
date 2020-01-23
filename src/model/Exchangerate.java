package model;

public class Exchangerate {
    private Currency from;
    private Currency to;
    private double rate;
    
    public Exchangerate(Currency from, Currency to, double rate) {
        this.from = from;
        this.to = to;
        this.rate = rate;
    }
    public Currency getFrom() {
        return from;
    }
    public Currency getTo() {
        return to;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
}
