$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/prodTest.feature");
formatter.feature({
  "name": "Complex test",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@prodTest"
    }
  ]
});
formatter.scenario({
  "name": "personal area test",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@prodTest"
    }
  ]
});
formatter.step({
  "name": "I am loggined",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.iAmLoggined()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I check title page \"Войти\"",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.iCheckTitlePage(String)"
});
formatter.result({
  "status": "passed"
});
});