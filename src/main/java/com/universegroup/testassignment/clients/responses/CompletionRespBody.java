package com.universegroup.testassignment.clients.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompletionRespBody {

    private String id;
    private String object;
    private int created;
    private String model;
    private List<Choice> choices;
    private Usage usage;
    private String serviceTier;
    private String systemFingerprint;

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Choice {

        private int index;
        private Message message;
        private Delta delta;
        private String logprobs;
        private String finishReason;

        @Data
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class Message {

                private String role;
                private String content;
                private String refusal;
                private List<String> annotations;
        }

        @Data
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class Delta {

            private String role;
            private String content;
            private String refusal;
        }
    }

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Usage {

            private int promptTokens;
            private int completionTokens;
            private int totalTokens;
            private PromptTokensDetails promptTokensDetails;
            private CompletionTokensDetails completionTokensDetails;

        @Data
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class PromptTokensDetails {

                private int cachedTokens;
                private int audioTokens;
        }

        @Data
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class CompletionTokensDetails {

                private int reasoningTokens;
                private int audioTokens;
                private int acceptedPredictionTokens;
                private int rejectedPredictionTokens;
        }
    }
}
