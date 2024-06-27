package com.di.hostme.service.repository.city;

import static com.di.hostme.service.domain.city.error.CityErrorCode.CITY_DOES_NOT_EXIST;
import static com.di.hostme.service.repository.model.tables.LvCity.LV_CITY;

import com.di.hostme.service.domain.city.entity.CityEntity;
import com.di.hostme.service.domain.city.query.FindCityByIdQuery;
import com.di.hostme.service.repository.HostMePersistenceContext;
import com.di.hostme.service.repository.JooqRepository;
import com.di.hostme.service.repository.city.mapper.CityJooqRepositoryMapper;
import java.util.List;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: https://dmytrodemianenko21.atlassian.net/browse/KAN-10
// TODO: https://dmytrodemianenko21.atlassian.net/browse/KAN-17
@Repository
public class JooqCityRepository extends JooqRepository implements CityRepositoryAdapter {

  @Autowired
  public JooqCityRepository(HostMePersistenceContext dslContext) {
    super(dslContext);
  }

  @Override
  public CityEntity findOne(FindCityByIdQuery query) {
    log.info("Applying findOne, query: '{}'.", query);

    final Result<Record> result =
        dslContext
            .select()
            .from(LV_CITY)
            .where(LV_CITY.ID.eq(query.id()))
            .and(LV_CITY.COUNTRY_ID.eq(query.countryId()))
            .and(LV_CITY.IS_DELETED.eq(false))
            .fetch();

    if (result.isEmpty()) {
      log.error(
          "City with id '{}' for country with id '{}' does not exist.",
          query.id(),
          query.countryId());
      throw CITY_DOES_NOT_EXIST
          .createError(query.id().toString(), query.countryId().toString())
          .convertToException();
    }

    log.info("FindOne applied successfully, query: '{}'.", query);
    return CityJooqRepositoryMapper.map(result.getFirst());
  }

  @Override
  public List<CityEntity> list() {
    log.info("Applying list.");

    final Result<Record> result =
        dslContext.select().from(LV_CITY).where(LV_CITY.IS_DELETED.eq(false)).fetch();

    log.info("List applied successfully.");
    return result.map(CityJooqRepositoryMapper::map).parallelStream().toList();
  }
}
