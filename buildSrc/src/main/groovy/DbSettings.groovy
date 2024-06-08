class DbSettings {

  String url
  String liquibaseUsername
  String liquibasePassword
  String username
  String password
  String dbSchema

  DbSettings(String url, String liquibaseUsername, String liquibasePassword, String username, String password, String dbSchema) {
    this.url = url
    this.liquibaseUsername = liquibaseUsername
    this.liquibasePassword = liquibasePassword
    this.username = username
    this.password = password
    this.dbSchema = dbSchema
  }

  String getUrl() {
    return url
  }

  String getLiquibaseUsername() {
    return liquibaseUsername
  }

  String getLiquibasePassword() {
    return liquibasePassword
  }

  String getUsername() {
    return username
  }

  String getPassword() {
    return password
  }

  String getDbSchema() {
    return dbSchema
  }
}
