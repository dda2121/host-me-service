package com.di.hostme.service.rest.api.dto.country;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import org.immutables.value.Value;

@JsonSerialize(as = ImmutableCountryListResponse.class)
@JsonDeserialize(as = ImmutableCountryListResponse.class)
@Value.Immutable
public sealed interface CountryListResponse
    permits ImmutableCountryListResponse, ImmutableCountryListResponse.Json {

  List<CountryDetailResponse> getCountries();
}
