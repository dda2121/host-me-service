package com.di.hostme.service;

import io.restassured.specification.RequestSpecification;

public interface BaseTestSupport {

  RequestSpecification requestSpecification();
}
