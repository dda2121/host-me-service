package com.di.hostme.service.rest.api.dto.city;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import org.immutables.value.Value;

@JsonSerialize(as = ImmutableCityListResponse.class)
@JsonDeserialize(as = ImmutableCityListResponse.class)
@Value.Immutable
public sealed interface CityListResponse
    permits ImmutableCityListResponse, ImmutableCityListResponse.Json {

  List<CityDetailResponse> getCities();
}
