package lipamar.auctions_winner_api.api.AllegroAPI.utils;

import org.springframework.web.util.UriComponentsBuilder;

public class AllegroURIBuilder extends UriComponentsBuilder {

    public AllegroURIBuilder() {
        this.scheme("https");
        this.host("api.allegro.pl");
    }
}
