package com.di.hostme.service.mapper;

import com.di.hostme.service.domain.city.entity.CityEntity;
import com.di.hostme.service.rest.api.dto.city.CityDetailResponse;
import com.di.hostme.service.rest.api.dto.city.CityListResponse;
import com.di.hostme.service.rest.api.dto.city.ImmutableCityDetailResponse;
import com.di.hostme.service.rest.api.dto.city.ImmutableCityListResponse;
import java.util.List;

// TODO: https://dmytrodemianenko21.atlassian.net/browse/KAN-11
public final class CityResponseMapper {

  public static CityDetailResponse map(CityEntity entity) {
    return ImmutableCityDetailResponse.builder()
        .createdAt(entity.createdAt())
        .createdBy(entity.createdBy())
        .updatedAt(entity.updatedAt())
        .updatedBy(entity.updatedBy())
        .id(entity.id())
        .countryId(entity.countryId())
        .name(entity.name())
        .build();
  }

  public static CityListResponse map(List<CityEntity> entities) {
    return ImmutableCityListResponse.builder()
        .addAllCities(entities.parallelStream().map(CityResponseMapper::map).toList())
        .build();
  }
}
