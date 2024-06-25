package com.di.hostme.service.controller;

import com.di.hostme.service.business.country.port.inbound.FindCountryUseCase;
import com.di.hostme.service.business.country.port.inbound.ListCountryUseCase;
import com.di.hostme.service.domain.country.query.ImmutableFindCountryByIdQuery;
import com.di.hostme.service.mapper.CountryResponseMapper;
import com.di.hostme.service.rest.api.dto.country.CountryDetailResponse;
import com.di.hostme.service.rest.api.dto.country.CountryListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Countries", description = "Countries endpoints")
@RestController
public class CountryController extends BaseController {

  private static final Logger log = LoggerFactory.getLogger(CountryController.class);

  private final FindCountryUseCase findCountryUseCase;
  private final ListCountryUseCase listCountryUseCase;

  @Autowired
  public CountryController(
      FindCountryUseCase findCountryUseCase, ListCountryUseCase listCountryUseCase) {
    this.findCountryUseCase = findCountryUseCase;
    this.listCountryUseCase = listCountryUseCase;
  }

  @Operation(
      operationId = "getCountry",
      summary = "Returns detail of a country",
      description = "Returns detail of a country",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Successful operation - detail of a country is returned",
            content = {
              @Content(
                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                  schema = @Schema(implementation = CountryDetailResponse.class))
            }),
      })
  @GetMapping(value = COUNTRY_URI, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CountryDetailResponse> getCountry(
      @PathVariable(PARAM_COUNTRY_ID) @Validated @NotNull UUID countryId) {
    log.info("GetCountry applied successfully, countryId: '{}'.", countryId);

    return ResponseEntity.ok()
        .body(
            CountryResponseMapper.map(
                findCountryUseCase.execute(ImmutableFindCountryByIdQuery.of(countryId))));
  }

  @Operation(
      operationId = "listCountries",
      summary = "Returns a list of all countries",
      description = "Returns a list of all countries",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Successful operation - a list of all countries is returned",
            content = {
              @Content(
                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                  schema = @Schema(implementation = CountryListResponse.class))
            }),
      })
  @GetMapping(value = COUNTRIES_URI, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CountryListResponse> listCountries() {
    log.info("ListCountries applied successfully.");

    return ResponseEntity.ok().body(CountryResponseMapper.map(listCountryUseCase.execute()));
  }
}
