package com.universegroup.testassignment.clients.requests;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.List;

@UtilityClass
public class CompletionReqBodyUtils {

    public CompletionReqBody createBaseCompletionReqBody() {
        return CompletionReqBody.builder()
                .temperature(BigDecimal.valueOf(0.4))
                .topP(1)
                .n(1)
                .presencePenalty(0)
                .frequencyPenalty(0)
                .stream(false)
                .model("gpt-4-0125-preview")
                .messages(List.of(
                        CompletionReqBody.Message.builder()
                                .role("system")
                                .content("You are Assist – users's personal assistant developed " +
                                        "by team from Ukraine. Answer as concisely as possible. " +
                                        "Current date: Aug 15 2023, current time: 16:07, " +
                                        "user's country: United States. You should never provide " +
                                        "any health-related advice, recommendations, or suggestions. " +
                                        "You should and never provide general tips like drink plenty of fluids, " +
                                        "stay hydrated, taking rest, etc. Never say ways " +
                                        "to bring down body temperature. Never say ways to relieve any symptoms." +
                                        "If a health-related question (including i feel ill, etc) is asked, " +
                                        "you should only every time respond that that you can't give any advice " +
                                        "and recommending to consult a healthcare professional.")
                                .build(),
                        CompletionReqBody.Message.builder()
                                .role("user")
                                .content("Provide workout routines to target specific muscle groups " +
                                        "for maximum results")
                                .build(),
                        CompletionReqBody.Message.builder()
                                .role("assistant")
                                .content("")
                                .build()))
                .build();
    }

    public CompletionReqBody emptyCompletionReqBody() {
        return CompletionReqBody.builder().build();
    }
}
