package ru.shotin.rsocketserver.repository.model;

public class MarketData {
    private String stock;

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public MarketData stock(String stock) {
        this.stock = stock;
        return this;
    }
}
