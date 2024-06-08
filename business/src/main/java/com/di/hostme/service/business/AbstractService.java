package com.di.hostme.service.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractService {

  protected static final Logger log = LoggerFactory.getLogger(AbstractService.class);

  public static final String SERVICE_NAME = "host-me-service";
}
