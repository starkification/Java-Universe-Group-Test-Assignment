package com.universegroup.testassignment.clients;

import com.universegroup.testassignment.clients.requests.CompletionReqBody;
import com.universegroup.testassignment.properties.Properties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public class ChatClient {

    private final String chatUrl;

    public ChatClient(Properties properties) {
        chatUrl = properties.getBaseUrl() + properties.getChatApiUrl();
    }

    public Response postCompletion(String authToken, CompletionReqBody reqBody) {
        return RestAssured.with()
                .auth()
                .oauth2(authToken)
                .contentType(ContentType.JSON)
                .body(reqBody)
                .post(chatUrl);
    }
}
