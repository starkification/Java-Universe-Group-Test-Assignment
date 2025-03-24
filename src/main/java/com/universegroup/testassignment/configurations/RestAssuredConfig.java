package com.universegroup.testassignment.configurations;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.parsing.Parser;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("unused")
public class RestAssuredConfig {

    @PostConstruct
    public void setup() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .setDefaultParser(Parser.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}
