package com.di.hostme.service.business.country;

import com.di.hostme.service.business.AbstractService;
import com.di.hostme.service.business.country.port.inbound.FindCountryUseCase;
import com.di.hostme.service.business.country.port.outbound.QueryCountryPort;
import com.di.hostme.service.domain.country.entity.CountryEntity;
import com.di.hostme.service.domain.country.query.FindCountryByIdQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCountryService extends AbstractService implements FindCountryUseCase {

  private final QueryCountryPort queryCountryPort;

  @Autowired
  public FindCountryService(QueryCountryPort queryCountryPort) {
    this.queryCountryPort = queryCountryPort;
  }

  @Override
  public CountryEntity execute(FindCountryByIdQuery query) {
    log.info("Applying findCountryUseCase, query: '{}'.", query);

    return queryCountryPort.findOne(query);
  }
}
