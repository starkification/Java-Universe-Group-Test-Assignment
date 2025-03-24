package com.universegroup.testassignment.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.universegroup.testassignment.stepdefinitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:build/test-reports/cucumber-report.html")
@ConfigurationParameter(key = "cucumber.execution.parallel.enabled", value = "true")
public class CucumberRunner {
}
