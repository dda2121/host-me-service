package com.di.hostme.service.business.country.port.inbound;

import com.di.hostme.service.domain.country.entity.CountryEntity;
import com.di.hostme.service.domain.country.query.FindCountryByIdQuery;

public interface FindCountryUseCase {

  CountryEntity execute(FindCountryByIdQuery query);
}
