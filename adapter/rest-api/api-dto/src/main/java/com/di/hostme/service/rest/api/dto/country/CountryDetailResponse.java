package com.di.hostme.service.rest.api.dto.country;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@JsonSerialize(as = ImmutableCountryDetailResponse.class)
@JsonDeserialize(as = ImmutableCountryDetailResponse.class)
@Value.Immutable
public sealed interface CountryDetailResponse extends BaseCountryResponse
    permits ImmutableCountryDetailResponse, ImmutableCountryDetailResponse.Json {}
