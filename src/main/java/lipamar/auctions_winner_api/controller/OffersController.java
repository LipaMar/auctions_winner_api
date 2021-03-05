package lipamar.auctions_winner_api.controller;

import lipamar.auctions_winner_api.api.AllegroAPI.enums.Include;
import lipamar.auctions_winner_api.api.AllegroAPI.enums.SortBy;
import lipamar.auctions_winner_api.api.AllegroAPI.handler.CommunicationHandler;
import lipamar.auctions_winner_api.api.AllegroAPI.utils.AllegroURIBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/auctions")
public class OffersController {
    @GetMapping
    public Mono<ResponseEntity<String>> findAuctions(@RequestParam String phrase,
                                                     @RequestParam(required = false) String categoryId,
                                                     @RequestParam(required = false, defaultValue = "relevance") SortBy sort) {
        String uri = new AllegroURIBuilder().path("/offers/listing")
                .queryParam("phrase", phrase)
                .queryParam("sellingMode.format", "AUCTION")
                .queryParam("include", Include.NOTHING, Include.ITEMS)
                .queryParam("sort", sort)
                .queryParam("category.id", categoryId)
                .build().toUriString();
        return CommunicationHandler.get(uri, String.class);
    }
}
