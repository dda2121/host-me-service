package com.di.hostme.service.controller;

import static com.di.hostme.service.controller.CountryController.COUNTRY_URI;
import static com.di.hostme.service.controller.CountryController.PARAM_COUNTRY_ID;

import com.di.hostme.service.business.city.port.inbound.FindCityUseCase;
import com.di.hostme.service.business.city.port.inbound.ListCityUseCase;
import com.di.hostme.service.domain.city.query.ImmutableFindCityByIdQuery;
import com.di.hostme.service.mapper.CityResponseMapper;
import com.di.hostme.service.rest.api.dto.city.CityDetailResponse;
import com.di.hostme.service.rest.api.dto.city.CityListResponse;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponseFault;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cities", description = "City endpoints")
@RestController
@RequiredArgsConstructor
public class CityController extends BaseController {

  public static final String PARAM_CITY_ID = "cityId";

  public static final String CITIES_URI = COUNTRY_URI + "/cities";
  public static final String CITY_URI = CITIES_URI + "/{" + PARAM_CITY_ID + "}";

  private static final Logger log = LoggerFactory.getLogger(CityController.class);

  private final FindCityUseCase findCityUseCase;
  private final ListCityUseCase listCityUseCase;

  @Operation(
      operationId = "getCity",
      summary = "Returns detail of a city",
      description = "Returns detail of a city",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Successful operation - detail of a city is returned",
            content = {
              @Content(
                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                  schema = @Schema(implementation = CityDetailResponse.class))
            }),
        @ApiResponse(
            responseCode = "404",
            description = "Unsuccessful operation - the city does not exist exception is returned",
            content = {
              @Content(
                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                  schema = @Schema(implementation = ErrorResponseFault.class),
                  examples = {
                    @ExampleObject(
                        name = "CITY_DOES_NOT_EXIST",
                        description = "City with id '{}' for country with id '{}' does not exist.",
                        value =
                            """
                                {
                                  "serviceName" : "host-me-service",
                                  "errorResponseFaults": [
                                    {
                                        "code": "CITY_DOES_NOT_EXIST",
                                        "message": "City with id '{}' for country with id '{}' does not exist.",
                                        "messageParameters": [
                                            e9ee4c87-8633-4393-b6a6-1b7778585d51,
                                            a4ab5d31-8633-4393-b6a6-1b7778585d51
                                        ]
                                    }
                                  ]
                                }
                            """)
                  })
            }),
      })
  @GetMapping(value = CITY_URI, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CityDetailResponse> getCity(
      @PathVariable(PARAM_CITY_ID) @Validated @NotNull UUID cityId,
      @PathVariable(PARAM_COUNTRY_ID) @Validated @NotNull UUID countryId) {
    log.info("GetCity applied successfully, cityId: '{}', countryId: '{}'.", cityId, countryId);

    return ResponseEntity.ok()
        .body(
            CityResponseMapper.map(
                findCityUseCase.execute(ImmutableFindCityByIdQuery.of(cityId, countryId))));
  }

  @Operation(
      operationId = "listCities",
      summary = "Returns a list of all cities",
      description = "Returns a list of all cities",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Successful operation - a list of all cities is returned",
            content = {
              @Content(
                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                  schema = @Schema(implementation = CityListResponse.class))
            }),
      })
  @GetMapping(value = CITIES_URI, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CityListResponse> listCities() {
    log.info("ListCities applied successfully.");

    return ResponseEntity.ok().body(CityResponseMapper.map(listCityUseCase.execute()));
  }
}
