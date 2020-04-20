## Resume

- [Overview](#overview)
- [Architecture](#architecture)
- [3rd party libraries](#3rd-party-libraries)
- [Known issues](#known-issues)

<img src="https://github.com/Nihilus13/Resume/blob/master/app.gif?raw=true" height="500">

## Overview

Simple resume app.

### Features
+ Fetching data placed in gist
+ Displaying different positions from my resume
+ Opening call dialer with my number
+ Opening email client with my new email to me
+ Redirecting to my LinkedIn profile

## Architecture

### Packaging
Project is structurized to preserve clean architecure in the project. Main independent modules ui, domain and date. Additionally
for different purposes, in project have been created independent feature modules.

### Domain
Main business models of all used entities is kept in `domain` module. `Domain` module does not contain any business logic.

### Data
Main business logic lives in the `data` module. `Data` is responsible for downloading data from `Repository` and combine them with network status.
`Repository` is implemented with two data sources. In memory cache and remote, for fetching data from network. Remote data source is responsible for work with `ApiService` - Retrofit interface to define network calls.

### Coroutines
Coroutines is used to perform simple api calls defined in through `Repository`.

### View
Thanks to Android Data Binding mechanism `Activity` or `Fragment` acts as a Dummy View. It does not contain any presentation or render logic. `View` is only responsible for getting an instance of `ViewModel` and bind it to generated representation of xml layout(`Binding`). In some scenarios it also needs to do addition work but only related to combining everything together or specific Android Framework stuff.

### ViewModel
`ViewModel` is build on top of Android Architecture Components. It gives simplicity when it comes to screen rotation as it survives `Fragment` or `Activity` re-creation. Main responsibility of a `ViewModel` is to react to specific data changes and modify state of UI. Updating `ViewState` is automatically translated to UI due data binding mechanism.

### Dependency Inversion
There is no dependency injection framework used. For the simplicity of this application constructor injection(with default values) is the main approach to
build lose coupling and testable code. Dagger 2 or Koin frameworks would not solve any problems.
It would only introduce unnecessary complexity.

## 3rd party libraries

- Retrofit2 (Networking).
- Coil (Image loading).
- Coroutines (For async stuff)
- Android Data Binding (MVVM).
- Android View Binding

## Known issues

- Lack of UI/Espresso tests for user journeys.