package com.cs.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by olgac on 02/06/2017.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Utils {

    public static String asJsonString(final Object obj) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
