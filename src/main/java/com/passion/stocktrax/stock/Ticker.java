package com.passion.stocktrax.stock;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Ticker {

    @Id
    private String symbol;
    private String stockname;

    public Ticker() {}

    public Ticker(String stockname, String symbol) {
        this.stockname = stockname;
        this.symbol = symbol;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockName) {
        this.stockname = stockName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof com.passion.stocktrax.stock.Ticker))
            return false;
        com.passion.stocktrax.stock.Ticker ticker = (com.passion.stocktrax.stock.Ticker) o;
        return Objects.equals(this.symbol, ticker.symbol) && Objects.equals(this.stockname, ticker.stockname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.symbol, this.stockname);
    }

    @Override
    public String toString() {
        return "Ticker{" + "symbol=" + this.symbol + ", stockname='" + this.stockname +'}';
    }
}

