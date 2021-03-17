package lipamar.auctions_winner_api.controller;

import lipamar.auctions_winner_api.api.AllegroAPI.model.Category;
import lipamar.auctions_winner_api.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Flux<Category> getCategories(@RequestParam(required = false) String parentId) {
        return categoryService.getCategories(parentId);
    }

    @GetMapping("/{categoryId}")
    public Mono<Category> getCategory(@PathVariable String categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @GetMapping("/find-matching")
    public Flux<Category> matchCategory(@RequestParam String phrase) {
        return categoryService.getMatchingCategories(phrase);
    }
}
