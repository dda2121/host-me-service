package com.di.hostme.service.rest.api.dto.city;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@JsonSerialize(as = ImmutableCityDetailResponse.class)
@JsonDeserialize(as = ImmutableCityDetailResponse.class)
@Value.Immutable
public sealed interface CityDetailResponse extends BaseCityResponse
    permits ImmutableCityDetailResponse, ImmutableCityDetailResponse.Json {}
