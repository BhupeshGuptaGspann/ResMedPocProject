$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/KaranCharan/workspace/CucumberTest/src/main/java/com/cucumber/feature/login.feature");
formatter.feature({
  "line": 1,
  "name": "TDAmeritrade login",
  "description": "",
  "id": "tdameritrade-login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "TDA Login Test Scenario",
  "description": "",
  "id": "tdameritrade-login;tda-login-test-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user is already on Login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "verify title of login page",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "login to TDA application",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "verify title of the landing page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_already_in_login_page()"
});
formatter.result({
  "duration": 12596846481,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.verify_title_of_login_page()"
});
formatter.result({
  "duration": 29978960,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.login_to_TDA_application()"
});
formatter.result({
  "duration": 3095771787,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.verify_title_of_the_landing_page()"
});
formatter.result({
  "duration": 62128262,
  "status": "passed"
});
});