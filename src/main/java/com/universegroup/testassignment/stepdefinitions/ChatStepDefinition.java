package com.universegroup.testassignment.stepdefinitions;

import com.universegroup.testassignment.contexts.ScenarioContext;
import com.universegroup.testassignment.services.ChatService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

import static com.universegroup.testassignment.contexts.ContextKeys.AUTH_TOKEN;
import static com.universegroup.testassignment.contexts.ContextKeys.COMPLETION_RESP_BODY;

@RequiredArgsConstructor
public class ChatStepDefinition {

    private final ChatService chatService;
    private final ScenarioContext scenarioContext;

    @When("the user sends a valid stream request to the chat")
    public void sendValidStreamRequest() {
        String authToken = scenarioContext.getContext(AUTH_TOKEN);
        var response = chatService.sendValidStreamRequest(authToken);
        scenarioContext.setContext(COMPLETION_RESP_BODY, response);
    }

    @When("the user sends a valid non-stream request to the chat")
    public void sendValidNonStreamRequest() {
        String authToken = scenarioContext.getContext(AUTH_TOKEN);
        var response = chatService.sendValidNonStreamRequest(authToken);
        scenarioContext.setContext(COMPLETION_RESP_BODY, response);
    }

    @When("the user sends an invalid non-stream request to the chat without a mandatory field")
    public void sendInvalidNonStreamRequest() {
        String authToken = scenarioContext.getContext(AUTH_TOKEN);
        var response = chatService.sendInvalidNonStreamRequest(authToken);
        scenarioContext.setContext(COMPLETION_RESP_BODY, response);
    }

    @When("the user sends a malformed request to the chat")
    public void sendMalformedRequest() {
        String authToken = scenarioContext.getContext(AUTH_TOKEN);
        var response = chatService.sendMalformedRequest(authToken);
        scenarioContext.setContext(COMPLETION_RESP_BODY, response);
    }

    @Then("the user receives a successful stream response with a 200 OK and the correct content")
    public void verifySuccessfulStreamResponse() {
        Response response = scenarioContext.getContext(COMPLETION_RESP_BODY);
        chatService.verifySuccessfulStreamResponse(response);
    }

    @Then("the user receives a successful non-stream response with a 200 OK and the correct content")
    public void verifySuccessfulNonStreamResponse() {
        Response response = scenarioContext.getContext(COMPLETION_RESP_BODY);
        chatService.verifySuccessfulNonStreamResponse(response);
    }
}
