#!/bin/bash
export DB_CONNECTION_URI=jdbc:postgresql://localhost:5432/postgres
export DB_LIQUIBASE_USERNAME=postgres
export DB_LIQUIBASE_PASSWORD=postgres
export DB_USERNAME=postgres
export DB_PASSWORD=postgres
export DB_SCHEMA=public

./gradlew clean build $@
