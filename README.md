# Android Architecture NewsApp Sample
[![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/AkshayChordiya//blob/master/LICENSE)

During Google I/O 2017, Android Team announced [guidelines](https://developer.android.com/topic/libraries/architecture/index.html) for architecture of Android app.
This is just sample app explaining the new Architecture Guidelines written in **Kotlin**, YAY!

## Components Demonstrated
- [Room](https://developer.android.com/topic/libraries/architecture/room.html)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata.html)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel.html)

## What's the app about?
It's an extremely simple app which uses [NewsAPI](https://newsapi.org/) to show the latest news from Google News.
It uses [Retrofit 2](http://square.github.io/retrofit/) to fetch the news from the API and save them into database using [Room](https://developer.android.com/topic/libraries/architecture/room.html).
The main aim of this sample app is show how to use the new [Architecture Guidelines](https://developer.android.com/topic/libraries/architecture/index.html) with Kotlin.

## Steps to run:
- Go to [NewsAPI](https://newsapi.org/) and generate an API key (It's only 2 steps!)
- Put the API key at the bottom of the `gradle.properties`
`
NEWS_API_KEY = "YOUR_API_KEY"
`
- Run the app
- Enjoyyyyy 🎉

## Architecture

The app uses `ViewModel` to abstract the data from UI and `Repository` as single source of truth for data. `Repository` fetch the data from database if it doesn't exist then it fetches from the webservice.

![Architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

--------------------

## Screenshots

<img alt="NewsApp Main Page" height="450px" src="https://raw.githubusercontent.com/AkshayChordiya/android-arch-news-sample/master/art/screen.png" />

--------------------

## Architecture Components Explained
Trying to learn the new Architecture Components. I have wrote a series of articles to understand Android Architecture Components. Feel free to check it out to learn more.

- [Introduction to Architecture Components](https://medium.com/@aky/introduction-to-android-architecture-components-22b8c84f0b9d)
- [Exploring ViewModel Architecture component](https://medium.com/@aky/exploring-viewmodel-architecture-component-5d60828172f9)
- [Exploring LiveData Architecture component](https://medium.com/@aky/exploring-livedata-architecture-component-f9375d3644ee)
- [Exploring Room Architecture component](https://medium.com/@aky/exploring-room-architecture-component-6db807094241)

## Todo
- ~~Write article explaining the complete flow of application~~
- Create fork of repo showing integration with Dagger 2
- Write test cases; (DONE for Room - DAO and Retrofit - WebService)

## Testing
The architecture components are highly testable. Following table shows how to test various parts of the app (cheatsheet for testing architecture component)

|  Component |     Test     |        Mock        |
|:----------:|:------------:|:------------------:|
|     UI     |   Espresso   |      ViewModel     |
|  ViewModel |     JUnit    |     Repository     |
| Repository |     JUnit    | DAO and WebService |
|     DAO    | Instrumented |          -         |
| WebService | Instrumented |    MockWebServer   |

### Prerequisites

- Android Studio 3.0
- Android Device with USB Debugging Enabled


## Built With

* [Android Studio](https://developer.android.com/studio/index.html) - The Official IDE for Android
* [Kotlin](https://kotlinlang.org/) - The Official Language for Android
* [Gradle](https://gradle.org/) - Build tool for Android Studio

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for contributions.

<p align="center">
  <h3>Proudly :muscle: made in <b><a href="https://kotlinlang.org/">Kotlin</a></b></h3>
</p>

## License

    The MIT License (MIT)
    
    Copyright (c) 2017 Akshay Chordiya
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
