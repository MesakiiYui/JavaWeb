package com.mesakiiyui.springdatamysql.service;

import com.mesakiiyui.springdatamysql.Entity.JsonpPost;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RestService {

    public String getPostsPlainJSON();

    public JsonpPost getPostWithCustomHeaders();

    public JsonpPost createPost();

    public JsonpPost createPostWithObject();

    public HttpHeaders retrieveHeaders();

    public Set<HttpMethod> allowedOperations();

    public String unknownRequest();


}
