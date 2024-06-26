package com.di.hostme.service.business.country.port.inbound;

import com.di.hostme.service.domain.country.entity.CountryEntity;
import java.util.List;

public interface ListCountryUseCase {

  List<CountryEntity> execute();
}
