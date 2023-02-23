package ru.shotin.rsocketserver.repository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.shotin.rsocketserver.repository.model.MarketData;

@Repository
public class MarketDataRepository {
    public Mono<MarketData> getOne(String stock) {
        return Mono.just(new MarketData().stock(stock));
    }
}
