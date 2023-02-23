package ru.shotin.rsocketclient.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class MarketDataRequest {
    @JsonProperty
    private String stock;

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public MarketDataRequest stock(String stock) {
        this.stock = stock;
        return this;
    }
}
