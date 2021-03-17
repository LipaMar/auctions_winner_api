package lipamar.auctions_winner_api.api.AllegroAPI.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lipamar.auctions_winner_api.api.AllegroAPI.model.Categories;
import lipamar.auctions_winner_api.api.AllegroAPI.model.Category;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class CategoriesDeserializer extends JsonDeserializer<Categories> {
    @Override
    public Categories deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.readValueAsTree();
        Iterator<String> iterator = node.fieldNames();
        String name = iterator.next();
        if (iterator.hasNext()) throw new IOException("Cannot parse value to Categories class");
        Categories categories = new Categories();
        categories.setCategories(Arrays.asList(new ObjectMapper().treeToValue(node.get(name),Category[].class)));
        return categories;
    }
}
