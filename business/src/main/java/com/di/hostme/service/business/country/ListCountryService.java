package com.di.hostme.service.business.country;

import com.di.hostme.service.business.AbstractService;
import com.di.hostme.service.business.country.port.inbound.ListCountryUseCase;
import com.di.hostme.service.business.country.port.outbound.QueryCountryPort;
import com.di.hostme.service.domain.country.entity.CountryEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListCountryService extends AbstractService implements ListCountryUseCase {

  private final QueryCountryPort queryCountryPort;

  @Autowired
  public ListCountryService(QueryCountryPort queryCountryPort) {
    this.queryCountryPort = queryCountryPort;
  }

  @Override
  public List<CountryEntity> execute() {
    log.info("Applying listCountryUseCase.");
    return queryCountryPort.list();
  }
}
