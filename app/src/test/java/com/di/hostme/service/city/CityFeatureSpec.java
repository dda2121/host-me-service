package com.di.hostme.service.city;

import static com.di.hostme.service.repository.model.tables.LvCity.LV_CITY;
import static com.di.hostme.service.repository.model.tables.LvCountry.LV_COUNTRY;

import com.di.hostme.service.ServiceAppFeatureSpec;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CityFeatureSpec extends ServiceAppFeatureSpec implements CityTestSupport {

  protected UUID countryId;
  protected final List<UUID> cityIds = new ArrayList<>();
  protected final List<String> cityNames = new ArrayList<>();

  @BeforeEach
  public void createPrerequisites() {
    final OffsetDateTime now = OffsetDateTime.now();
    countryId = UUID.randomUUID();
    cityIds.addAll(List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID()));
    cityNames.addAll(List.of("TEST_NAME_1", "TEST_NAME_2", "TEST_NAME_3"));

    dslContext
        .insertInto(LV_COUNTRY)
        .set(LV_COUNTRY.ID, countryId)
        .set(LV_COUNTRY.CREATED_AT, now)
        .set(LV_COUNTRY.CREATED_BY, UUID.randomUUID())
        .set(LV_COUNTRY.UPDATED_AT, now)
        .set(LV_COUNTRY.UPDATED_BY, UUID.randomUUID())
        .set(LV_COUNTRY.IS_DELETED, false)
        .set(LV_COUNTRY.NAME, "TEST_NAME")
        .execute();

    IntStream.range(0, cityIds.size())
        .forEach(
            idx -> {
              dslContext
                  .insertInto(LV_CITY)
                  .set(LV_CITY.ID, cityIds.get(idx))
                  .set(LV_CITY.CREATED_AT, now)
                  .set(LV_CITY.CREATED_BY, UUID.randomUUID())
                  .set(LV_CITY.UPDATED_AT, now)
                  .set(LV_CITY.UPDATED_BY, UUID.randomUUID())
                  .set(LV_CITY.IS_DELETED, false)
                  .set(LV_CITY.COUNTRY_ID, countryId)
                  .set(LV_CITY.NAME, cityNames.get(idx))
                  .execute();
            });
  }

  @AfterEach
  public void deletePrerequisites() {
    dslContext.delete(LV_CITY).where(LV_CITY.ID.in(cityIds)).execute();
    dslContext.delete(LV_COUNTRY).where(LV_COUNTRY.ID.eq(countryId)).execute();
  }
}
