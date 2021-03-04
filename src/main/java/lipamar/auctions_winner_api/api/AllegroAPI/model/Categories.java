package lipamar.auctions_winner_api.api.AllegroAPI.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "categories"
})
public class Categories {

    @JsonProperty("categories")
    private List<Category> categories = null;

    @JsonProperty("categories")
    public List<Category> getCategories() {
        return categories;
    }
}