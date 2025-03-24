package com.universegroup.testassignment.stepdefinitions;

import com.universegroup.testassignment.contexts.ScenarioContext;
import com.universegroup.testassignment.properties.Properties;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;

import static com.universegroup.testassignment.contexts.ContextKeys.AUTH_TOKEN;

@RequiredArgsConstructor
public class AuthorizationStepDefinition {

    private static final String INVALID_AUTH_TOKEN = "INVALID_AUTH_TOKEN";

    private final ScenarioContext scenarioContext;
    private final Properties properties;

    @Given("the user has a valid authorization token")
    public void getValidAuthToken() {
        scenarioContext.setContext(AUTH_TOKEN, properties.getAuthToken());
    }

    @Given("the user has an invalid authorization token")
    public void getInvalidAuthToken() {
        scenarioContext.setContext(AUTH_TOKEN, INVALID_AUTH_TOKEN);
    }
}
