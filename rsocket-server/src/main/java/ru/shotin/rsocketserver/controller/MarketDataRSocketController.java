package ru.shotin.rsocketserver.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;
import ru.shotin.rsocketserver.controller.dto.MarketDataRequest;
import ru.shotin.rsocketserver.repository.MarketDataRepository;
import ru.shotin.rsocketserver.repository.model.MarketData;

@Controller
public class MarketDataRSocketController {
    private final MarketDataRepository marketDataRepository;
    public MarketDataRSocketController(MarketDataRepository marketDataRepository) {
        this.marketDataRepository = marketDataRepository;
    }

    @MessageMapping("currentMarketData")
    public Mono<MarketData> currentMarketData(MarketDataRequest marketDataRequest) {
        return marketDataRepository.getOne(marketDataRequest.getStock());
    }
}
