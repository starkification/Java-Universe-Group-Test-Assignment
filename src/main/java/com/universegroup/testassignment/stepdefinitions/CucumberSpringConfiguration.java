package com.universegroup.testassignment.stepdefinitions;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The class is used to integrate Cucumber with Spring.
 * It configures and bootstraps the Spring context required for Cucumber tests
 * and should be placed in the same directory as the step definitions.
 */
@CucumberContextConfiguration
@SpringBootTest
@SuppressWarnings("unused")
public class CucumberSpringConfiguration {
}
