package lipamar.auctions_winner_api.api.AllegroAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lipamar.auctions_winner_api.api.AllegroAPI.converter.CategoriesDeserializer;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = CategoriesDeserializer.class)
public class Categories {
    private List<Category> categories = null;

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }
}