package com.example.demo.ras.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Map;

@Converter(autoApply = true)
public class MapTypeConverter implements AttributeConverter<Map<String, Object>, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapTypeConverter.class);

    private ObjectMapper objectMapper;

    public MapTypeConverter() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String convertToDatabaseColumn(Map<String, Object> theEntity) {
        try {
            if (theEntity == null){
                return null;
            } else {
                return objectMapper.writeValueAsString(theEntity);
            }
        } catch (JsonProcessingException e) {
            LOGGER.error("Error converting Map object to JSON string", e);
            return null;
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String theDBValue) {
        try {
            if (theDBValue == null) {
                return null;
            } else {
                return objectMapper.readValue(theDBValue, new TypeReference<Map<String, Object>>() {
                });
            }
        } catch (IOException e) {
            LOGGER.error("Error converting JSON string to Map object", e);
            return null;
        }
    }

}

