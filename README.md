# Android Architecture NewsApp Sample
[![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/AkshayChordiya//blob/master/LICENSE)

During Google I/O 2017, Android Team announced [guidelines](https://developer.android.com/topic/libraries/architecture/index.html) for architecture of Android app.
This is just sample app explaining few parts of the Architecture Guidelines written in **Kotlin**, YAY!

## Components Demonstrated
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata.html)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel.html)

## What's the app about?
It's an extremely simple app which uses [NewsAPI](https://newsapi.org/) to show the latest news from Google News.
It uses Retrofit 2 to fetch the news from the API.

## Steps to run:
- Go to [NewsAPI](https://newsapi.org/) and generate an API key (It's only 2 steps!)
- Put the API key at the bottom of the `gradle.properties`
`
NEWS_API_KEY = "YOUR_API_KEY"
`
- Run the app
- Enjoyyyyy 🎉

--------------------

## Screenshots

<img alt="NewsApp Main Page" height="450px" src="https://raw.githubusercontent.com/AkshayChordiya/android-arch-news-sample/master/art/screen.png" />

--------------------


### Prerequisites

- Android Studio 3.0 Canary 1
- Android Device with USB Debugging Enabled


## Built With

* [Android Studio](https://developer.android.com/studio/index.html) - The Official IDE for Android
* [Kotlin](https://kotlinlang.org/) - The Official Language for Android
* [Gradle](https://gradle.org/) - Build tool for Android Studio

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for contributions.


## License
-------

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

<p align="center">
  <h3>Proudly :muscle: made in <b><a href="https://kotlinlang.org/">Kotlin</a></b></h3>
</p>
