package lipamar.auctions_winner_api.api.AllegroAPI.utils;

import lipamar.auctions_winner_api.api.AllegroAPI.enums.SortBy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SortEnumConverter implements Converter<String, SortBy> {

    @Override
    public SortBy convert(@Nullable String s) {
        return SortBy.getEnum(s);
    }
}
