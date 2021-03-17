package lipamar.auctions_winner_api.api.AllegroAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "parent",
        "leaf"
})
@JsonIgnoreProperties({"options"})
public class Category {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("parent")
    private Category parent;
    @JsonProperty("leaf")
    private Boolean leaf;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getParent() {
        return parent;
    }

    public Boolean isLeaf() {
        return leaf;
    }
}