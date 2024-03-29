# SWAPI SDK
[SWAPI.co](https://swapi.co/):
- Kotlin Client for Android using Coroutines
- Demo App using the SDK with declarative/functional UI approach
- API Mirror: https://gotev.github.io/swapi-android, to reduce loads on https://swapi.co/api/ origin server

[Download Demo App](https://github.com/gotev/swapi-android/releases/download/1.1.0/app-debug.apk)

This project is the main subject of the talk `Declarative Dynamic UI`, hosted by [Android Developers Italia](https://androiddevs.it).

[YouTube Video (italian)](https://www.youtube.com/watch?v=fivfxxW82gk) | [Slides](https://github.com/gotev/swapi-android/blob/master/assets/Declarative%20Dynamic%20UI.pdf)

## Why?
This SDK and Demo App are made to have a common ground to promote discussions about:
- Architecture
- Technologies
- Modeling
- UI/UX
- Approaches
- ...whatever else comes to mind

Too often, we as developers are tied to the specific business domain on which we are working on and when the time comes to exchange ideas with other developers, some effort has to be made to de-contextualize what we are doing in our day-to-day job to present it to others.

This is a complete app which has various challenges to solve. **It's not perfect** and probably never will be, so feel free to open discussions about every aspect and tell your ideas. Also, **this is only one in a million ways** to achieve the same result.

You have many ways to use this repository:
- Use the SDK as a Gradle dependency
- Fork the project and modify the demo app, the SDK or both
- Study it
- Use it like a template for other projects
- Contribute to this project with your own additions. Motivate them in Pull Requests.

## Technology Stack
- Kotlin + Coroutines
- OkHttp 4
- Moshi
- Retrofit
- ThreeTenABP

## Using the library
```groovy
implementation 'net.gotev:swapi-sdk:x.y.z'
```
Replace `x.y.z` with [ ![Download](https://api.bintray.com/packages/gotev/maven/swapi-sdk/images/download.svg) ](https://bintray.com/gotev/maven/swapi-sdk/_latestVersion)

Initialize it in your `Application`

```kotlin
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initializeSwapiClient(this)
    }
}
```

And then you can make requests from Coroutine Scopes to get data for each resource.

You can also pass in your own `OkHttpClient` instance if you have a global one in your app and decide if you want to use mirror or origin API server.

> By default, to reduce loads on SWAPI.co, the client will point to the SWAPI mirror hosted on this project's GitHub Pages: https://gotev.github.io/swapi-android

All the domain models are also `Parcelable` so you can safely pass them as arguments.

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

## Mirror
This project has the ability to make a complete API mirror from `SWAPI.co`. Go into `mirror` directory and launch:

```
./fetch
```

This will update:
- The JSONs used in SWAPI SDK unit tests, saved in `fetched` sub directory
- The SWAPI.co API mirror in the `docs` directory, which is the GitHub Pages source

## Dependency Updates
Keeping dependencies always up to date can be annoying. To ease things, a gradle plugin has been added which automatically checks for new versions. Just run:

```
./gradlew dependencyUpdates
```

And you will see a complete report of actual and new dependencies versions.

## Release
Library can be released:
- **locally**: `./release local`. This is going to create a `releases` directory which can be used as a Maven Repository.
