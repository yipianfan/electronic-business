package com.canoe.eb.account.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 日期切面处理类
 * example:
 * @JsonSerialize(using = LocalDateTimeConverter.class)
 * private LocalDateTime localDateTime;
 */
public class LocalDateTimeConverter extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(value.toLocalDate() + " " + value.toLocalTime());
    }
}