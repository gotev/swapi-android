# SWAPI SDK
SWAPI.co Kotlin Client for Android

## Technology Stack
- Kotlin + Coroutines
- OkHttp 4
- Moshi
- Retrofit
- ThreeTenABP

## Release
You can release the library:
- **locally**: `./release local`. This is going to create a `releases` directory which can be used as a Maven Repository.
- **publicly on Bintray**: `./release`
    > From bintray.com, you can then link your library on jCenter and push it also to Maven Central, but I'm not going to cover that here, as there are plenty of examples on the Internet on how to do that.

## Using the library
Once the library is published to bintray, you can use it like this:

```groovy
implementation 'net.gotev:swapi-sdk:1.0.0'
```

## Dependency Updates
Keeping dependencies always up to date can be annoying. To ease things, a gradle plugin has been added which automatically checks for new versions. Just run:

```
./gradlew dependencyUpdates
```

And you will see a complete report of actual and new dependencies versions.
