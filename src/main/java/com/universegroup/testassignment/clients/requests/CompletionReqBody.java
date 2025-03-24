package com.universegroup.testassignment.clients.requests;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompletionReqBody {

    private BigDecimal temperature;
    private Integer topP;
    private Integer n;
    private Integer presencePenalty;
    private Integer frequencyPenalty;
    private Boolean stream;
    private String model;
    private List<Message> messages;

    @Data
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Message {

            private String role;
            private String content;
    }
}
