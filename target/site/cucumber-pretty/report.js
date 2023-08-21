$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./features/codeBreakflow.feature");
formatter.feature({
  "name": "API request validations POM",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@UATTesting"
    }
  ]
});
formatter.scenario({
  "name": "Verifying the breakFlow of API",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@UATTesting"
    }
  ]
});
formatter.step({
  "name": "an API to post",
  "keyword": "Given "
});
formatter.match({
  "location": "postCreate.postCreate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "get the created API",
  "keyword": "When "
});
formatter.match({
  "location": "getInfo.getInfo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "update the API",
  "keyword": "Then "
});
formatter.match({
  "location": "putUpdate.putUpdate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "delete the API",
  "keyword": "And "
});
formatter.match({
  "location": "deleteBooking.deleteBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("./features/codeflow.feature");
formatter.feature({
  "name": "API request validations",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@UATTesting"
    }
  ]
});
formatter.scenario({
  "name": "Flow of API",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@UATTesting"
    }
  ]
});
formatter.step({
  "name": "an API to post",
  "keyword": "Given "
});
formatter.match({
  "location": "postCreate.postCreate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "get the created API",
  "keyword": "When "
});
formatter.match({
  "location": "getInfo.getInfo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "update the API",
  "keyword": "Then "
});
formatter.match({
  "location": "putUpdate.putUpdate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "delete the API",
  "keyword": "And "
});
formatter.match({
  "location": "deleteBooking.deleteBooking()"
});
formatter.result({
  "status": "passed"
});
});