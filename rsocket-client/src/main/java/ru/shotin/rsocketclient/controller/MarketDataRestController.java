package ru.shotin.rsocketclient.controller;

import org.reactivestreams.Publisher;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.shotin.rsocketclient.controller.dto.MarketData;
import ru.shotin.rsocketclient.controller.dto.MarketDataRequest;

@RestController
public class MarketDataRestController {
    private final RSocketRequester rSocketRequester;

    public MarketDataRestController(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }

    @GetMapping(value = "/current/{stock}")
    public Publisher<MarketData> current(@PathVariable("stock") String stock) {
        return rSocketRequester
                .route("currentMarketData")
                .data(new MarketDataRequest().stock(stock))
                .retrieveMono(MarketData.class);
    }
}
