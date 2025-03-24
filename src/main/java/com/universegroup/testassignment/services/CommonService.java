package com.universegroup.testassignment.services;

import com.universegroup.testassignment.validators.CommonValidator;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommonService {

    public static final String EXP_UNAUTHORIZED_ERROR_MSG = "Unauthorized";
    private static final String EXP_BAD_REQUEST_ERROR_MSG = "Request failed with status code 400";
    public static final String EXP_INTERNAL_SERVER_ERROR_MSG = "Internal Server Error";

    private final CommonValidator commonValidator;

    public void verifyUnauthorizedClientErrorResponse(Response response) {
        commonValidator.verifyStatusCode(response.getStatusCode(), 401);
        commonValidator.verifyErrorMessage(response, EXP_UNAUTHORIZED_ERROR_MSG);
    }

    public void verifyBadRequestClientErrorResponse(Response response) {
        commonValidator.verifyStatusCode(response.getStatusCode(), 400);
        commonValidator.verifyErrorMessage(response, EXP_BAD_REQUEST_ERROR_MSG);
    }

    public void verifyServerErrorResponse(Response response) {
        commonValidator.verifyStatusCode(response.getStatusCode(), 500);
        commonValidator.verifyErrorMessage(response, EXP_INTERNAL_SERVER_ERROR_MSG);
    }
}
