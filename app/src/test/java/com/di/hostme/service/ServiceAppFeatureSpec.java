package com.di.hostme.service;

import com.di.hostme.service.repository.country.JooqCountryRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.jooq.DSLContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// TODO: https://dmytrodemianenko21.atlassian.net/browse/KAN-17
@ExtendWith(SpringExtension.class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = HostMeServiceApplication.class)
@ActiveProfiles("test")
public class ServiceAppFeatureSpec implements BaseTestSupport {

  @Value("${local.server.port}")
  protected int actualPort;

  @Autowired protected DSLContext dslContext;
  @Autowired protected JooqCountryRepository countryRepository;

  public RequestSpecification requestSpecification() {
    return RestAssured.given()
        .log()
        .all()
        .port(actualPort)
        .accept(ContentType.JSON)
        .contentType(ContentType.JSON);
  }
}
