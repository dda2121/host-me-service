package com.di.hostme.service.business.country;

import com.di.hostme.service.business.AbstractService;
import com.di.hostme.service.business.country.port.inbound.FindCountryUseCase;
import com.di.hostme.service.business.country.port.outbound.QueryCountryPort;
import com.di.hostme.service.domain.country.entity.CountryEntity;
import com.di.hostme.service.domain.country.query.FindCountryByIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// TODO: https://dmytrodemianenko21.atlassian.net/browse/KAN-10
@Service
@RequiredArgsConstructor
public class FindCountryService extends AbstractService implements FindCountryUseCase {

  private final QueryCountryPort queryCountryPort;

  @Override
  public CountryEntity execute(FindCountryByIdQuery query) {
    log.info("Applying findCountryUseCase, query: '{}'.", query);

    return queryCountryPort.findOne(query);
  }
}
