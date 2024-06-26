package com.di.hostme.service.business.country;

import com.di.hostme.service.business.AbstractService;
import com.di.hostme.service.business.country.port.inbound.ListCountryUseCase;
import com.di.hostme.service.business.country.port.outbound.QueryCountryPort;
import com.di.hostme.service.domain.country.entity.CountryEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListCountryService extends AbstractService implements ListCountryUseCase {

  private final QueryCountryPort queryCountryPort;

  @Override
  public List<CountryEntity> execute() {
    log.info("Applying listCountryUseCase.");

    return queryCountryPort.list();
  }
}
