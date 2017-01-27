# 03PopularMovieVer2- Udacity Android Nanodegree Project 2
This is an app that shows moview information such as rating, review, trailer, synopsis and release date. Both 

### Phone
![Demo](https://cloud.githubusercontent.com/assets/17938363/22362028/64b02dfa-e414-11e6-9422-5dd594525834.gif)
### Tablet
![Demo](https://cloud.githubusercontent.com/assets/17938363/22362033/72e677b2-e414-11e6-896b-f05b28e58886.png)

Previous version can be found [here](https://github.com/jinyoon0124/02PopularMovie)

## Features
* Save movies as favorite
* Sort movies by popularity or rating 
* Show trailers on YouTube and read reviews

## Getting Started
This sample uses the Gradle build system. To build this project, use the "gradlew build" command or use "Import Project" in Android Studio. Or clone this repository and import into **Android Studio**
```
git clone git@github.com:jinyoon0124/03PopularMovieVer2.git
```

## Configuration
### API KEY:
Create your TMDB API KEY [here](https://www.themoviedb.org/documentation/api) and add the key in `gradle.properties`
```
MovieApiKey = "..."
```

## Generating signed APK
From Android Studio: 1. **_Build_** menu 2. **_Generate Signed APK_**... 3. Fill in the keystore information _(you only need to do this once manually and then let Android Studio remember it)_

## Libraries
* [ButterKnife](http://jakewharton.github.io/butterknife/)
* [Picasso](http://square.github.io/picasso/)
* [Retrofit](https://square.github.io/retrofit/)

## License
```
Copyright 2017 Jin Yoon

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
