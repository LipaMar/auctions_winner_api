package lipamar.auctions_winner_api.api.AllegroAPI.enums;

import java.util.Arrays;

public enum SortBy {
    RELEVANCE("relevance"),
    PRICE_ASC("+price"),
    PRICE_DESC("-price"),
    DELIVERY_PRICE_ASC("+withDeliveryPrice"),
    DELIVERY_PRICE_DESC("-withDeliveryPrice"),
    POPULARITY("-popularity"),
    END_TIME("+endTime"),
    START_TIME("-startTime");
    private String value;

    SortBy(String value) {
        this.value = value;
    }
    public static SortBy getEnum(String value){
        return Arrays.stream(SortBy.values()).filter(sortBy -> sortBy.value.equals(value)).findFirst().orElse(RELEVANCE);
    }

    @Override
    public String toString() {
        return value;
    }
}


