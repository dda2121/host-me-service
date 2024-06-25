package com.di.hostme.service.repository.country.mapper;

import com.di.hostme.service.domain.country.entity.CountryEntity;
import com.di.hostme.service.domain.country.entity.ImmutableCountryEntity;
import com.di.hostme.service.repository.model.tables.records.LvCountryRecord;
import org.jooq.Record;

public final class CountryJooqRepositoryMapper {

  public static CountryEntity map(Record record) {
    final LvCountryRecord lvCountryRecord = record.into(LvCountryRecord.class);

    return ImmutableCountryEntity.builder()
        .createdAt(lvCountryRecord.getCreatedAt())
        .createdBy(lvCountryRecord.getCreatedBy())
        .updatedAt(lvCountryRecord.getUpdatedAt())
        .updatedBy(lvCountryRecord.getUpdatedBy())
        .id(lvCountryRecord.getId())
        .name(lvCountryRecord.getName())
        .build();
  }
}
