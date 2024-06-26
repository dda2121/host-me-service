package com.di.hostme.service.repository.country;

import static com.di.hostme.service.domain.country.error.CountryErrorCode.COUNTRY_DOES_NOT_EXIST;
import static com.di.hostme.service.repository.model.tables.LvCountry.LV_COUNTRY;

import com.di.hostme.service.domain.country.entity.CountryEntity;
import com.di.hostme.service.domain.country.query.FindCountryByIdQuery;
import com.di.hostme.service.repository.HostMePersistenceContext;
import com.di.hostme.service.repository.JooqRepository;
import com.di.hostme.service.repository.country.mapper.CountryJooqRepositoryMapper;
import java.util.List;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: use lombok for constructor
@Repository
public class JooqCountryRepository extends JooqRepository implements CountryRepositoryAdapter {

  @Autowired
  public JooqCountryRepository(HostMePersistenceContext dslContext) {
    super(dslContext);
  }

  @Override
  public CountryEntity findOne(FindCountryByIdQuery query) {
    log.info("Applying findOne, query: '{}'.", query);

    final Result<Record> result =
        dslContext
            .select()
            .from(LV_COUNTRY)
            .where(LV_COUNTRY.ID.eq(query.id()))
            .and(LV_COUNTRY.IS_DELETED.eq(false))
            .fetch();

    if (result.isEmpty()) {
      log.error("Country with id '{}' does not exist.", query.id());
      throw COUNTRY_DOES_NOT_EXIST.createError(query.id().toString()).convertToException();
    }

    log.info("FindOne applied successfully, query: '{}'.", query);
    return CountryJooqRepositoryMapper.map(result.getFirst());
  }

  @Override
  public List<CountryEntity> list() {
    log.info("Applying list.");

    final Result<Record> result =
        dslContext.select().from(LV_COUNTRY).where(LV_COUNTRY.IS_DELETED.eq(false)).fetch();

    log.info("List applied successfully.");
    return result.map(CountryJooqRepositoryMapper::map).parallelStream().toList();
  }
}
