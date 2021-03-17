package lipamar.auctions_winner_api.controller;

import lipamar.auctions_winner_api.api.AllegroAPI.model.Categories;
import lipamar.auctions_winner_api.api.AllegroAPI.model.Category;
import lipamar.auctions_winner_api.api.AllegroAPI.utils.AllegroURIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final WebClient webClient;
    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping
    public Flux<Category> getCategories(@RequestParam(required = false) String parentId) {
        String uri = new AllegroURIBuilder().path("/sale/categories")
                .queryParam("parent.id", parentId).build().toUriString();
        return getCategoryFlux(uri);
    }

    @GetMapping("/{categoryId}")
    public Mono<Category> getCategory(@PathVariable String categoryId) {
        String uri = new AllegroURIBuilder().path("/sale/categories/" + categoryId).build().toUriString();
        return getMono(uri, Category.class);
    }

    @GetMapping("/find-matching")
    public Flux<Category> matchCategory(@RequestParam String phrase) {
        String uri = new AllegroURIBuilder().path("/sale/matching-categories")
                .queryParam("name", phrase).build().toUriString();
        return getCategoryFlux(uri);
    }

    private Flux<Category> getCategoryFlux(String uri) {
        return getMono(uri, Categories.class)
                .map(Categories::getCategories)
                .flatMapMany(Flux::fromIterable);
    }

    private <T> Mono<T> getMono(String uri, Class<T> aClass) {
        logger.info("GET request to: " + uri);
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(aClass);
    }
}
