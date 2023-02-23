package ru.shotin.rsocketclient.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class MarketData {
    @JsonProperty
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
