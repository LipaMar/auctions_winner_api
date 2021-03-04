package lipamar.auctions_winner_api.api.AllegroAPI.model;

import com.fasterxml.jackson.annotation.*;

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
    private Object parent;
    @JsonProperty("leaf")
    private Boolean leaf;


    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("parent")
    public Object getParent() {
        return parent;
    }

    @JsonProperty("parent")
    public void setParent(Object parent) {
        this.parent = parent;
    }

    @JsonProperty("leaf")
    public Boolean getLeaf() {
        return leaf;
    }

    @JsonProperty("leaf")
    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }
}