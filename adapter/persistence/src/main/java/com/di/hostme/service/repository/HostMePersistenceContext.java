package com.di.hostme.service.repository;

import static com.di.hostme.service.repository.config.JooqConfiguration.HOST_ME_SERVICE_DSL_CONTEXT;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HostMePersistenceContext {

  private final DSLContext context;

  public HostMePersistenceContext(@Qualifier(HOST_ME_SERVICE_DSL_CONTEXT) DSLContext context) {
    this.context = context;
  }

  public DSLContext get() {
    return this.context;
  }
}
