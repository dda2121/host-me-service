package com.di.hostme.service.repository;

import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class JooqRepository {

  protected final DSLContext dslContext;

  protected static final Logger log = LoggerFactory.getLogger(JooqRepository.class);

  protected JooqRepository(HostMePersistenceContext dslContext) {
    this.dslContext = dslContext.get();
  }
}
