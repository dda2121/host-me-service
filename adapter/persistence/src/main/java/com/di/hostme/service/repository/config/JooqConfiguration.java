package com.di.hostme.service.repository.config;

import java.util.concurrent.Executors;
import javax.sql.DataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.*;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.ThreadLocalTransactionProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

@Configuration
public class JooqConfiguration {

  public static final String HOST_ME_SERVICE_DATA_SOURCE = "host-me-service-data-source";
  public static final String HOST_ME_SERVICE_DSL_CONTEXT = "host-me-service-dsl-context";

  public static final String HOST_ME_SERVICE_TRANSACTION_AWARE_DATA_SOURCE_PROXY =
      "host-me-service-transaction-aware-data-source-proxy";
  public static final String HOST_ME_SERVICE_DATA_SOURCE_CONNECTION_PROVIDER =
      "host-me-service-data-source-connection-provider";

  @Value("${spring.jooq.sql-dialect}")
  private String jooqDialect;

  @Value("${spring.jooq.schema-name}")
  private String schemaName;

  @Bean(name = HOST_ME_SERVICE_DATA_SOURCE)
  @Primary
  @ConfigurationProperties("spring.datasource")
  DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = HOST_ME_SERVICE_TRANSACTION_AWARE_DATA_SOURCE_PROXY)
  TransactionAwareDataSourceProxy transactionAwareDataSourceProxy(DataSource dataSource) {
    return new TransactionAwareDataSourceProxy(dataSource);
  }

  @Bean(name = HOST_ME_SERVICE_DATA_SOURCE_CONNECTION_PROVIDER)
  DataSourceConnectionProvider dataSourceConnectionProvider(
      @Qualifier(HOST_ME_SERVICE_TRANSACTION_AWARE_DATA_SOURCE_PROXY)
          TransactionAwareDataSourceProxy proxy) {
    return new DataSourceConnectionProvider(proxy);
  }

  @Bean(name = HOST_ME_SERVICE_DSL_CONTEXT)
  DSLContext dsl(
      @Qualifier(HOST_ME_SERVICE_DATA_SOURCE_CONNECTION_PROVIDER)
          DataSourceConnectionProvider provider) {
    final Settings settings =
        new Settings()
            .withRenderQuotedNames(RenderQuotedNames.EXPLICIT_DEFAULT_UNQUOTED)
            .withRenderNameCase(RenderNameCase.UPPER)
            .withRenderSchema(true)
            .withRenderCatalog(false)
            .withRenderMapping(
                new RenderMapping()
                    .withSchemata(
                        new MappedSchema()
                            .withInput("DB_SCHEMA_REPLACEABLE")
                            .withOutput(schemaName)));

    return DSL.using(
        new DefaultConfiguration()
            .set(SQLDialect.valueOf(jooqDialect))
            .set(settings)
            .set(Executors.newCachedThreadPool())
            .set(new ThreadLocalTransactionProvider(provider)));
  }
}
