package com.universegroup.testassignment.validators;

import com.universegroup.testassignment.clients.responses.CompletionRespBody;
import com.universegroup.testassignment.utilities.ResponseUtils;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public final class ChatValidator {

    public static final String CHAT_COMPLETION = "chat.completion";
    public static final String CHAT_COMPLETION_CHUNK = "chat.completion.chunk";
    public static final String ASSISTANT = "assistant";
    public static final String STOP = "stop";

    public void verifyNonStreamContent(Response response) {
        var completionRespBody = response.as(CompletionRespBody.class);

        assertThat(completionRespBody.getId())
                .hasSize(38);

        assertThat(completionRespBody.getObject())
                .isEqualTo(CHAT_COMPLETION);

        assertThat(completionRespBody.getChoices())
                .isNotEmpty();
        assertThat(completionRespBody.getChoices().getFirst().getMessage().getRole())
                .isEqualTo(ASSISTANT);
        assertThat(completionRespBody.getChoices().getFirst().getMessage().getContent())
                .isNotEmpty();
        assertThat(completionRespBody.getChoices().getFirst().getFinishReason())
                .isEqualTo(STOP);
    }

    public void verifyStreamContent(Response response) {
        var respBodyList = ResponseUtils.parseStreamResp(response);
        var completionRespBodyList = respBodyList.stream()
                .map(respBody -> ResponseUtils.deserializeStrToClass(respBody, CompletionRespBody.class))
                .toList();

        completionRespBodyList.forEach(completionRespBody -> {
            assertThat(completionRespBody.getId()).hasSize(38);
            assertThat(completionRespBody.getObject()).isEqualTo(CHAT_COMPLETION_CHUNK);
            assertThat(completionRespBody.getChoices()).isNotEmpty();
        });

        completionRespBodyList.stream()
                .skip(1) // skip the first element
                .limit(completionRespBodyList.size() - 2) //skip the last element
                .forEach(completionRespBody ->
                    assertThat(completionRespBody.getChoices().getFirst().getDelta().getContent()).isNotEmpty());
    }
}
