package lipamar.auctions_winner_api.api.AllegroAPI.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CommunicationHandler {
    private static WebClient webClient;
    private static final Logger logger = LoggerFactory.getLogger(CommunicationHandler.class);

    public CommunicationHandler(WebClient webClient) {
        CommunicationHandler.webClient = webClient;
    }

    public static <T> Mono<ResponseEntity<T>> get(String uri, Class<T> aClass) {

        return webClient.get()
                .uri(uri)
                .retrieve()
                .toEntity(aClass);
    }
}
