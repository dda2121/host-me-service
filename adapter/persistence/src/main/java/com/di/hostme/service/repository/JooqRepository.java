package com.di.hostme.service.repository;

import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class JooqRepository {

  protected static final Logger log = LoggerFactory.getLogger(JooqRepository.class);

  protected final DSLContext dslContext;

  public JooqRepository(HostMePersistenceContext dslContext) {
    this.dslContext = dslContext.get();
  }
}
