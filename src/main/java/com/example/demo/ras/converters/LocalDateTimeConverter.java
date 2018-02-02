package com.example.demo.ras.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Date.from(localDateTime.toInstant(ZoneOffset.UTC));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date date) {
        return date == null ? null : LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC);
    }
}
