package com.di.hostme.service.country;

import static com.di.hostme.service.repository.model.tables.LvCountry.LV_COUNTRY;

import com.di.hostme.service.ServiceAppFeatureSpec;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CountryFeatureSpec extends ServiceAppFeatureSpec implements CountryTestSupport {

  protected final List<UUID> countryIds = new ArrayList<>();
  protected final List<String> countryNames = new ArrayList<>();

  @BeforeEach
  public void createPrerequisites() {
    final OffsetDateTime now = OffsetDateTime.now();
    countryIds.addAll(List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID()));
    countryNames.addAll(List.of("TEST_NAME_1", "TEST_NAME_2", "TEST_NAME_3"));

    IntStream.range(0, countryIds.size())
        .forEach(
            idx -> {
              dslContext
                  .insertInto(LV_COUNTRY)
                  .set(LV_COUNTRY.ID, countryIds.get(idx))
                  .set(LV_COUNTRY.CREATED_AT, now)
                  .set(LV_COUNTRY.CREATED_BY, UUID.randomUUID())
                  .set(LV_COUNTRY.UPDATED_AT, now)
                  .set(LV_COUNTRY.UPDATED_BY, UUID.randomUUID())
                  .set(LV_COUNTRY.IS_DELETED, false)
                  .set(LV_COUNTRY.NAME, countryNames.get(idx))
                  .execute();
            });
  }

  @AfterEach
  public void deletePrerequisites() {
    dslContext.delete(LV_COUNTRY).where(LV_COUNTRY.ID.in(countryIds)).execute();
  }
}
