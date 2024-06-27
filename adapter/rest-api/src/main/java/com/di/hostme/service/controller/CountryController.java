package com.di.hostme.service.controller;

import com.di.hostme.service.business.country.port.inbound.FindCountryUseCase;
import com.di.hostme.service.business.country.port.inbound.ListCountryUseCase;
import com.di.hostme.service.domain.country.query.ImmutableFindCountryByIdQuery;
import com.di.hostme.service.mapper.CountryResponseMapper;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponseFault;
import com.di.hostme.service.rest.api.dto.country.CountryDetailResponse;
import com.di.hostme.service.rest.api.dto.country.CountryListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

// TODO: https://dmytrodemianenko21.atlassian.net/browse/KAN-10
@Tag(name = "Countries", description = "Country endpoints")
@RestController
@RequiredArgsConstructor
public class CountryController extends BaseController {

  public static final String PARAM_COUNTRY_ID = "countryId";

  public static final String COUNTRIES_URI = BASE_URI + "/countries";
  public static final String COUNTRY_URI = COUNTRIES_URI + "/{" + PARAM_COUNTRY_ID + "}";

  private static final Logger log = LoggerFactory.getLogger(CountryController.class);

  private final FindCountryUseCase findCountryUseCase;
  private final ListCountryUseCase listCountryUseCase;

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
        @ApiResponse(
            responseCode = "404",
            description =
                "Unsuccessful operation - the country does not exist exception is returned",
            content = {
              @Content(
                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                  schema = @Schema(implementation = ErrorResponseFault.class),
                  examples = {
                    @ExampleObject(
                        name = "COUNTRY_DOES_NOT_EXIST",
                        description = "Country with id '%s' does not exist.",
                        value =
                            """
                                {
                                  "serviceName" : "host-me-service",
                                  "errorResponseFaults": [
                                    {
                                        "code": "COUNTRY_DOES_NOT_EXIST",
                                        "message": "Country with id '%s' does not exist.",
                                        "messageParameters": [
                                            e9ee4c87-8633-4393-b6a6-1b7778585d51
                                        ]
                                    }
                                  ]
                                }
                            """)
                  })
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
