package com.universegroup.testassignment.properties;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix="test-assignment")
@Data
@Validated
public class Properties {

    @NotEmpty
    private String chatApiUrl;
    @NotEmpty
    private String baseUrl;
    @NotEmpty
    private String authToken;
}
