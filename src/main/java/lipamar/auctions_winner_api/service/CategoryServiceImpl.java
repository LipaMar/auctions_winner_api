package lipamar.auctions_winner_api.service;

import lipamar.auctions_winner_api.api.AllegroAPI.model.Categories;
import lipamar.auctions_winner_api.api.AllegroAPI.model.Category;
import lipamar.auctions_winner_api.api.AllegroAPI.utils.AllegroURIBuilder;
import lipamar.auctions_winner_api.controller.CategoryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final WebClient webClient;
    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<Category> getCategoryById(String id) {
        String uri = new AllegroURIBuilder().path("/sale/categories/" + id).build().toUriString();
        return getMono(uri, Category.class);
    }

    @Override
    public Flux<Category> getCategories(String parentId) {
        String uri = new AllegroURIBuilder().path("/sale/categories")
                .queryParam("parent.id", parentId).build().toUriString();
        return getCategoryFlux(uri);
    }

    @Override
    public Flux<Category> getMatchingCategories(String phrase) {
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
