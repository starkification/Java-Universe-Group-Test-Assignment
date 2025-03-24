package com.universegroup.testassignment.contexts;

import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ScenarioScope
public class ScenarioContext {

    private final Map<ContextKeys, Object> contextMap = new HashMap<>();

    public <T> void setContext(ContextKeys contextKey, T contextValue) {
        contextMap.put(contextKey, contextValue);
    }

    @SuppressWarnings("unchecked")
    public <T> T getContext(ContextKeys contextKey) {
        if (!contextMap.containsKey(contextKey)) {
            var errorMsg = String.format("The context with the key %s does not exist. " +
                    "Please verify the previous test steps and ensure that " +
                    "one of them sets the context with this key.", contextKey);
            throw new IllegalArgumentException(errorMsg);
        }
        return (T) contextMap.get(contextKey);
    }
}
