package com.cs.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonToken = jsonParser.getCurrentToken();
        if (jsonToken == JsonToken.VALUE_STRING) {
            String text = jsonParser.getText().trim();
            if (StringUtils.isEmpty(text)) {
                return null;
            }
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(text);
            } catch (ParseException e) {
                throw new IOException(e);
            }
        } else if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
            return new Date(jsonParser.getLongValue());
        } else {
            throw new IOException("Expecting String for Date Deserializing Token:" + jsonToken);
        }
    }
}