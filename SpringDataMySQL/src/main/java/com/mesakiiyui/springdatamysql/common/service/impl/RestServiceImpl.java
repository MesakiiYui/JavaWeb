package com.mesakiiyui.springdatamysql.common.service.impl;


import com.mesakiiyui.springdatamysql.common.entity.JsonpPost;
import com.mesakiiyui.springdatamysql.common.service.RestService;
import com.mesakiiyui.springdatamysql.common.utils.constant.EnvironmentVariable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class RestServiceImpl implements RestService {

    private final RestTemplate restTemplate;

    public RestServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        // set connection and read timeouts
        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(500))
                .setReadTimeout(Duration.ofSeconds(500))
                .build();
    }

    public String getPostsPlainJSON() {
        String url = EnvironmentVariable.TYPI_CODE_USER_LIST_URL;
        return this.restTemplate.getForObject(url, String.class);
    }

    public JsonpPost getPostWithCustomHeaders() {
        String url = EnvironmentVariable.TYPI_CODE_USER_BY_ID_URL + "1";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // set custom header
        headers.set("x-request-source", "desktop");

        // build the request
        HttpEntity request = new HttpEntity(headers);

        // use `exchange` method for HTTP call
        ResponseEntity<JsonpPost> response = this.restTemplate.exchange(url, HttpMethod.GET, request, JsonpPost.class, 1);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    public JsonpPost createPost() {
        String url = EnvironmentVariable.TYPI_CODE_USER_LIST_URL;

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // create a map for post parameters
        Map<String, Object> map = new HashMap<>();
        map.put("userId", 1);
        map.put("title", "Introduction to Spring Boot");
        map.put("body", "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.");

        // build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        // send POST request
        ResponseEntity<JsonpPost> response = this.restTemplate.postForEntity(url, entity, JsonpPost.class);

        // check response status code
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        } else {
            return null;
        }
    }

    public JsonpPost createPostWithObject() {
        String url = EnvironmentVariable.TYPI_CODE_USER_LIST_URL;

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // create a post object
        JsonpPost post = new JsonpPost(1,1, "Introduction to Spring Boot",
                "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.");

        // build the request
        HttpEntity<JsonpPost> entity = new HttpEntity<>(post, headers);

        // send POST request
        return restTemplate.postForObject(url, entity, JsonpPost.class);
    }


    /**
     * The RestTemplate class offers headForHeaders() method to retrieve headers:
     * @return
     */
    public HttpHeaders retrieveHeaders() {
        String url = EnvironmentVariable.TYPI_CODE_USER_LIST_URL;

        // send HEAD request
        return this.restTemplate.headForHeaders(url);
    }

    /**
     * Let us use optionsForAllow() method to get a list of all supported HTTP operations:
     * @return
     */
    public Set<HttpMethod> allowedOperations() {
        String url = EnvironmentVariable.TYPI_CODE_USER_LIST_URL;

        // send HEAD request
        return this.restTemplate.optionsForAllow(url);
    }


    /**
     * If there is an error during the execution of the request or the server returns a non-successful
     * HTTP error (4xx or 5xx), RestTemplate will throw an exception.
     * You can catch the HttpStatusCodeException in catch block to get the response body and headers:
     * @return
     */
    public String unknownRequest() {
        try {
            String url = EnvironmentVariable.TYPI_CODE_USER_404;
            return this.restTemplate.getForObject(url, String.class);
        } catch (HttpStatusCodeException ex) {
            // raw http status code e.g `404`
            System.out.println(ex.getRawStatusCode());
            // http status code e.g. `404 NOT_FOUND`
            System.out.println(ex.getStatusCode().toString());
            // get response body
            System.out.println(ex.getResponseBodyAsString());
            // get http headers
            HttpHeaders headers= ex.getResponseHeaders();
            System.out.println(headers.get("Content-Type"));
            System.out.println(headers.get("Server"));
        }

        return null;
    }

}