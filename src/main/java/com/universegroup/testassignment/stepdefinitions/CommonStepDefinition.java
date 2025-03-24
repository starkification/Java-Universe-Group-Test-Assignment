package com.universegroup.testassignment.stepdefinitions;

import com.universegroup.testassignment.contexts.ScenarioContext;
import com.universegroup.testassignment.services.CommonService;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

import static com.universegroup.testassignment.contexts.ContextKeys.COMPLETION_RESP_BODY;

@RequiredArgsConstructor
public class CommonStepDefinition {

    private final CommonService commonService;
    private final ScenarioContext scenarioContext;

    @Then("the user receives a client error response with a 401 Unauthorized and the error message")
    public void verifyUnauthorizedClientErrorResponse() {
        Response response = scenarioContext.getContext(COMPLETION_RESP_BODY);
        commonService.verifyUnauthorizedClientErrorResponse(response);
    }

    @Then("the user receives a client error response with a 400 Bad Request and the error message")
    public void verifyBadRequestClientErrorResponse() {
        Response response = scenarioContext.getContext(COMPLETION_RESP_BODY);
        commonService.verifyBadRequestClientErrorResponse(response);
    }

    @Then("the user receives a server error response with a 500 Internal Server Error and the error message")
    public void verifyInternalServerErrorResponse() {
        Response response = scenarioContext.getContext(COMPLETION_RESP_BODY);
        commonService.verifyServerErrorResponse(response);
    }
}
