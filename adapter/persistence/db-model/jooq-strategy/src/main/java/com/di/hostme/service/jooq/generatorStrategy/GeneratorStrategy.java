package com.di.hostme.service.jooq.generatorStrategy;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;
import org.jooq.meta.ForeignKeyDefinition;

public class GeneratorStrategy extends DefaultGeneratorStrategy {

  @Override
  public String getJavaIdentifier(Definition definition) {
    return definition instanceof ForeignKeyDefinition
        ? definition.getName().toUpperCase()
        : super.getJavaIdentifier(definition).toUpperCase();
  }
}
