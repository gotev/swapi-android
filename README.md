# SWAPI SDK
[SWAPI.co](https://swapi.co/) Kotlin Client for Android

## Technology Stack
- Kotlin + Coroutines
- OkHttp 4
- Moshi
- Retrofit
- ThreeTenABP

## Using the library
```groovy
implementation 'net.gotev:swapi-sdk:1.0.0'
```

Initialize it in your `Application`

```kotlin
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initializeSwapiClient(this)
    }
}
```

And then you can make requests from Coroutine Scopes to get data for each resource. All the domain models are also `Parcelable` so you can safely pass them as arguments.

```kotlin
swapiClient.species()
swapiClient.characters()
swapiClient.films()
swapiClient.species()
swapiClient.vehicles()
swapiClient.starships()
```

You will get a `PagedResponse<T>` from those API calls. From each one you can request `previousPage()` and `nextPage()`.

To request a specific page of data for `species`, `characters`, `films`, `species`, `vehicles` and `starships`, you can pass a page value:

```kotlin
swapiClient.species(page = 2)
```

It's also possible to fetch a single resource from its URL. Each domain model has a unique URL. For example, to fetch `https://swapi.co/api/people/1/`

```kotlin
val lukeSkywalker = swapiClient.character("https://swapi.co/api/people/1/")
```

## Dependency Updates
Keeping dependencies always up to date can be annoying. To ease things, a gradle plugin has been added which automatically checks for new versions. Just run:

```
./gradlew dependencyUpdates
```

And you will see a complete report of actual and new dependencies versions.

## Release
Library can be released:
- **locally**: `./release local`. This is going to create a `releases` directory which can be used as a Maven Repository.
- **publicly on Bintray**: `./release`
