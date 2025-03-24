package com.universegroup.testassignment.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Stream;

@UtilityClass
public class ResponseUtils {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<String> parseStreamResp(Response streamResp) {
        var streamRespBodyStr = streamResp.asString();
        return Stream.of(streamRespBodyStr.split("\n"))
                .filter(str -> !str.isEmpty())
                .filter(str -> !str.equals("data: [DONE]"))
                .map(str -> str.replaceFirst("^data: ", ""))
                .toList();
    }

    public <T> T deserializeStrToClass(String respBodyStr, Class<T> clazz) {
        try {
            return objectMapper.readValue(respBodyStr, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
