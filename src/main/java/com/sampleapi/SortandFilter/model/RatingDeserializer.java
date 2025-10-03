package com.sampleapi.SortandFilter.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class RatingDeserializer extends JsonDeserializer<Rating> {
    @Override
    public Rating deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        Rating rating = new Rating();

        if (node.isObject()) {
            // If rating is an object
            if (node.has("average")) {
                rating.setAverage(node.get("average").asDouble());
            }
            if (node.has("reviews")) {
                rating.setReviews(node.get("reviews").asInt());
            }
        } else if (node.isTextual()) {
            // If rating is a string like "nice"
            rating.setNote(node.asText());
        }

        return rating;
    }

}
