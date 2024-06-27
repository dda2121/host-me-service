package com.di.hostme.service.repository.city.mapper;

import com.di.hostme.service.domain.city.entity.CityEntity;
import com.di.hostme.service.domain.city.entity.ImmutableCityEntity;
import com.di.hostme.service.repository.model.tables.records.LvCityRecord;
import org.jooq.Record;

// TODO: https://dmytrodemianenko21.atlassian.net/browse/KAN-11
public final class CityJooqRepositoryMapper {

  public static CityEntity map(Record record) {
    final LvCityRecord lvCityRecord = record.into(LvCityRecord.class);

    return ImmutableCityEntity.builder()
        .createdAt(lvCityRecord.getCreatedAt())
        .createdBy(lvCityRecord.getCreatedBy())
        .updatedAt(lvCityRecord.getUpdatedAt())
        .updatedBy(lvCityRecord.getUpdatedBy())
        .id(lvCityRecord.getId())
        .countryId(lvCityRecord.getCountryId())
        .name(lvCityRecord.getName())
        .build();
  }
}
