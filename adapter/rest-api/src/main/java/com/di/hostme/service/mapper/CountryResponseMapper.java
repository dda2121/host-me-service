package com.di.hostme.service.mapper;

import com.di.hostme.service.domain.country.entity.CountryEntity;
import com.di.hostme.service.rest.api.dto.country.CountryDetailResponse;
import com.di.hostme.service.rest.api.dto.country.CountryListResponse;
import com.di.hostme.service.rest.api.dto.country.ImmutableCountryDetailResponse;
import com.di.hostme.service.rest.api.dto.country.ImmutableCountryListResponse;
import java.util.List;

public final class CountryResponseMapper {

  public static CountryDetailResponse map(CountryEntity entity) {
    return ImmutableCountryDetailResponse.builder()
        .createdAt(entity.createdAt())
        .createdBy(entity.createdBy())
        .updatedAt(entity.updatedAt())
        .updatedBy(entity.updatedBy())
        .id(entity.id())
        .name(entity.name())
        .build();
  }

  public static CountryListResponse map(List<CountryEntity> entities) {
    return ImmutableCountryListResponse.builder()
        .addAllCountries(entities.parallelStream().map(CountryResponseMapper::map).toList())
        .build();
  }
}
