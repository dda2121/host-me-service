package com.di.hostme.service.business.city.port.inbound;

import com.di.hostme.service.domain.city.entity.CityEntity;
import com.di.hostme.service.domain.city.query.ListCityQuery;
import java.util.List;

public interface ListCityUseCase {

  List<CityEntity> execute(ListCityQuery query);
}
