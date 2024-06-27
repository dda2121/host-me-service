package com.di.hostme.service.business.city;

import com.di.hostme.service.business.AbstractService;
import com.di.hostme.service.business.city.port.inbound.ListCityUseCase;
import com.di.hostme.service.business.city.port.outbound.QueryCityPort;
import com.di.hostme.service.domain.city.entity.CityEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// TODO: https://dmytrodemianenko21.atlassian.net/browse/KAN-10
@Service
@RequiredArgsConstructor
public class ListCityService extends AbstractService implements ListCityUseCase {

  private final QueryCityPort queryCityPort;

  @Override
  public List<CityEntity> execute() {
    log.info("Applying listCityUseCase.");

    return queryCityPort.list();
  }
}
