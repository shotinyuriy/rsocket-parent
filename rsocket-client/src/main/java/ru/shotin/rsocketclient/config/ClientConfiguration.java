package ru.shotin.rsocketclient.config;

import io.netty.buffer.ByteBuf;
import io.rsocket.Payload;
import io.rsocket.frame.decoder.PayloadDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.util.MimeTypeUtils;
import reactor.util.retry.Retry;

import java.time.Duration;

@Configuration
public class ClientConfiguration {
    @Bean
    public RSocketRequester getRSocketRequest(
            @Value("${rsocket.host}") String rSocketHost,
            @Value("${rsocket.port}") int rSocketPort) {
        RSocketRequester.Builder builder = RSocketRequester.builder();
        return builder
                .rsocketConnector(rSocketConnector ->
                        rSocketConnector
                                .reconnect(Retry.fixedDelay(2, Duration.ofSeconds(2)))
                                .payloadDecoder(new PayloadDecoder() {
                                    @Override
                                    public Payload apply(ByteBuf byteBuf) {
                                        return null;
                                    }
                                })
                )
                .dataMimeType(MimeTypeUtils.APPLICATION_JSON)
                .tcp(rSocketHost, rSocketPort);
    }
}
