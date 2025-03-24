package com.universegroup.testassignment.services;

import com.universegroup.testassignment.clients.ChatClient;
import com.universegroup.testassignment.clients.requests.CompletionReqBodyUtils;
import com.universegroup.testassignment.validators.ChatValidator;
import com.universegroup.testassignment.validators.CommonValidator;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatService {

    private final ChatClient chatClient;
    private final CommonValidator commonValidator;
    private final ChatValidator chatValidator;

    public Response sendValidStreamRequest(String authToken) {
        var validCompletionReqBody = CompletionReqBodyUtils.createBaseCompletionReqBody();
        validCompletionReqBody.setStream(true);
        return chatClient.postCompletion(authToken, validCompletionReqBody);
    }

    public Response sendValidNonStreamRequest(String authToken) {
        var validCompletionReqBody = CompletionReqBodyUtils.createBaseCompletionReqBody();
        return chatClient.postCompletion(authToken, validCompletionReqBody);
    }

    public Response sendInvalidNonStreamRequest(String authToken) {
        var invalidCompletionReqBody = CompletionReqBodyUtils.createBaseCompletionReqBody();
        invalidCompletionReqBody.setMessages(null);
        return chatClient.postCompletion(authToken, invalidCompletionReqBody);
    }

    public Response sendMalformedRequest(String authToken) {
        var malformedCompletionReqBody = CompletionReqBodyUtils.emptyCompletionReqBody();
        return chatClient.postCompletion(authToken, malformedCompletionReqBody);
    }

    public void verifySuccessfulStreamResponse(Response response) {
        commonValidator.verifyStatusCode(response.getStatusCode(), 200);
        chatValidator.verifyStreamContent(response);
    }

    public void verifySuccessfulNonStreamResponse(Response response) {
        commonValidator.verifyStatusCode(response.getStatusCode(), 200);
        chatValidator.verifyNonStreamContent(response);
    }
}
