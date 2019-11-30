package loc.aliar.monitoringsystemserver.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.SneakyThrows;

// TODO: 12/22/2019 REMAKE
public abstract class EnumDeserializer<E extends Enum<E>> extends JsonDeserializer<E> {
    @Override
    @SneakyThrows
    public E deserialize(JsonParser p, DeserializationContext ctxt) {
        ObjectCodec codec = p.getCodec();
        JsonNode node = codec.readTree(p);

        String name;
        if (node.isObject()) {
            name = node.get("name").asText();
        } else {
            name = node.asText();
        }

        return Enum.valueOf(getEnumClass(), name);
    }

    public abstract Class<E> getEnumClass();
}
