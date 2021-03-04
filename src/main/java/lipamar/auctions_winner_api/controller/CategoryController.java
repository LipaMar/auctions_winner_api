package lipamar.auctions_winner_api.controller;

import lipamar.auctions_winner_api.api.AllegroAPI.handler.CommunicationHandler;
import lipamar.auctions_winner_api.api.AllegroAPI.model.Categories;
import lipamar.auctions_winner_api.api.AllegroAPI.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    public CategoryController() {
    }

    @GetMapping
    public Mono<List<Category>> getCategories(@RequestParam(required = false) String parentId) {
        String uri = "https://api.allegro.pl/sale/categories";
        if (parentId != null)
            uri += "?parent.id=" + parentId;
        Mono<ResponseEntity<Categories>> categories = CommunicationHandler.get(uri, Categories.class);
        return categories.map(c -> {
            if (c.getBody() == null) return Collections.emptyList();
            else return c.getBody().getCategories();
        });
    }
}
