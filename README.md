# Money Exchange

Basic Springboot application. 
Uses [Free Currency API](https://api.freecurrencyapi.com/v1/latest)

Integrates with Google App Engine leveraging on Gradle plugin `'com.google.cloud.tools.appengine'`
Uses `src/main/appengine/app.yaml` for App Engine and Service configuration.

## Build

    ./gradlew clean build

## Deploy to AppEngine

    ./gradlew appengineDeploy