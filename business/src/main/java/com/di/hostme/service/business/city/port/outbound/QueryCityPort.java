package com.di.hostme.service.business.city.port.outbound;

import com.di.hostme.service.domain.city.entity.CityEntity;
import com.di.hostme.service.domain.city.query.FindCityByIdQuery;
import java.util.List;

public interface QueryCityPort {

  CityEntity findOne(FindCityByIdQuery query);

  List<CityEntity> list();
}
