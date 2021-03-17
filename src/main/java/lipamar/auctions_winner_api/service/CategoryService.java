package lipamar.auctions_winner_api.service;

import lipamar.auctions_winner_api.api.AllegroAPI.model.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryService {
    Mono<Category> getCategoryById(String id);

    Flux<Category> getCategories(String parentId);

    Flux<Category> getMatchingCategories(String phrase);
}
