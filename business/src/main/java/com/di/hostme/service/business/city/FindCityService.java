package com.di.hostme.service.business.city;

import com.di.hostme.service.business.AbstractService;
import com.di.hostme.service.business.city.port.inbound.FindCityUseCase;
import com.di.hostme.service.business.city.port.outbound.QueryCityPort;
import com.di.hostme.service.domain.city.entity.CityEntity;
import com.di.hostme.service.domain.city.query.FindCityByIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCityService extends AbstractService implements FindCityUseCase {

  private final QueryCityPort queryCityPort;

  @Override
  public CityEntity execute(FindCityByIdQuery query) {
    log.info("Applying findCityUseCase, query: '{}'.", query);

    return queryCityPort.findOne(query);
  }
}
