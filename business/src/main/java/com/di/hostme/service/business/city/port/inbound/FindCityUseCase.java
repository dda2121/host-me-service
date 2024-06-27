package com.di.hostme.service.business.city.port.inbound;

import com.di.hostme.service.domain.city.entity.CityEntity;
import com.di.hostme.service.domain.city.query.FindCityByIdQuery;

public interface FindCityUseCase {

  CityEntity execute(FindCityByIdQuery query);
}
