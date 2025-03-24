package com.universegroup.testassignment.validators;

import com.universegroup.testassignment.clients.responses.ErrorRespBody;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public class CommonValidator {

    public static final String ASSERT_ERROR_MSG_TEMPLATE = "Expected error message: \"%s\", but was: \"%s\"";

    public void verifyStatusCode(int actStatusCode, int expStatusCode) {
        assertThat(actStatusCode)
                .as(ASSERT_ERROR_MSG_TEMPLATE, expStatusCode, actStatusCode)
                .isEqualTo(expStatusCode);
    }

    public void verifyErrorMessage(Response response, String expErrorMsg) {
        var errorRespBody = response.as(ErrorRespBody.class);
        String actErrorMsg = errorRespBody.getMessage();
        assertThat(actErrorMsg)
                .as(ASSERT_ERROR_MSG_TEMPLATE, expErrorMsg, actErrorMsg)
                .isEqualTo(expErrorMsg);
    }
}
