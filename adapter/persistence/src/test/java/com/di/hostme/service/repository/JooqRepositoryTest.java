package com.di.hostme.service.repository;

import com.di.hostme.service.repository.city.JooqCityRepository;
import com.di.hostme.service.repository.country.JooqCountryRepository;
import org.jooq.DSLContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// TODO: https://dmytrodemianenko21.atlassian.net/browse/KAN-17
@ExtendWith(SpringExtension.class)
@SpringBootTest(
    classes = SpringPersistentTestApp.class,
    properties = "spring.main.allow-bean-definition-overriding=true")
public abstract class JooqRepositoryTest {

  @Autowired protected DSLContext dslContext;
  @Autowired protected JooqCountryRepository countryRepository;
  @Autowired protected JooqCityRepository cityRepository;
}
