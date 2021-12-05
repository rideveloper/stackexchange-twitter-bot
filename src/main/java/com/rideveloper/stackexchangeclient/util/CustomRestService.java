package com.rideveloper.stackexchangeclient.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;

/**
 * @author Ridwan Mustapha
 */
@Slf4j
@Service
public class CustomRestService {

    private final RestTemplate restTemplate;

    public CustomRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return httpHeaders;
    }

    public <T, G> G makeRequest(String url, T jsonObject, HttpMethod httpMethod, Class<G> responseClass) {
        try {
            ResponseEntity<G> response = null;
            log.info("Making a {} request to {} with request {}", httpMethod, url, jsonObject);
            switch (httpMethod) {
                case GET:
                    HttpEntity<T> entity = new HttpEntity<>(jsonObject, getHeaders());
                    response = restTemplate.exchange(new URI(url), HttpMethod.GET, entity, responseClass);
                    break;
                case POST:
                    HttpEntity<Object> payload = new HttpEntity<>(jsonObject, getHeaders());
                    response = restTemplate.exchange(new URI(url), HttpMethod.POST, payload, responseClass);
                    break;
            }

            log.info("Response gotten from {} :===: {}",url, response);
            return response.getBody();

        } catch (Exception ex) {
            log.info("Error occurred while calling url : {} with Exception - {} and Message - {}",url,ex,ex.getMessage());
            return null;
        }
    }
}
