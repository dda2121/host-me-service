package com.di.hostme.service.business.country.port.outbound;

import com.di.hostme.service.domain.country.entity.CountryEntity;
import com.di.hostme.service.domain.country.query.FindCountryByIdQuery;
import java.util.List;

public interface QueryCountryPort {

  CountryEntity findOne(FindCountryByIdQuery query);

  List<CountryEntity> list();
}
