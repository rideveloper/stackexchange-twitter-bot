package com.rideveloper.stackexchangeclient.util;

import org.apache.http.client.utils.URIBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ridwan Mustapha
 */
public class RequestBuilder {

    private Map<String, Object> parameters = new HashMap<>();

    public RequestBuilder add(String paramName, Object paramValue) {
        this.parameters.put(paramName, paramValue);
        return this;
    }

    public String build() {
        URIBuilder uriBuilder = new URIBuilder();
        for (Map.Entry<String, Object> param : this.parameters.entrySet()) {
            uriBuilder.addParameter(param.getKey(), param.getValue().toString());
        }

        return uriBuilder.toString();
    }
}
