package lipamar.auctions_winner_api.api.AllegroAPI.enums;

public enum Include {
    ALL("all"),
    NOTHING("-all"),
    ITEMS("items"),
    SEARCH_META("searchMeta"),
    CATEGORIES("categories"),
    FILTERS("filters"),
    SORT("sort"),
    NOT_ITEMS("-items"),
    NOT_SEARCH_META("-searchMeta"),
    NOT_CATEGORIES("-categories"),
    NOT_FILTERS("-filters"),
    NOT_SORT("-sort");
    private String value;

    Include(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
