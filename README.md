---

# Carousell News

Hello! We hope you are doing great today and would like to thank you for taking your time to work on this exercise.

## Project Overview

### Objective

Build a Carousell News application that displays a list of articles with the following features:

1. **Title** (max 2 lines, truncated if too long)
2. **Description** (max 2 lines, truncated if too long)
3. **Date of Creation** displayed in a readable, relative format (e.g., "5 days ago", "1 week ago", "1 month ago", "1 year ago")
4. **Image** (center cropped)
5. **Action Bar Menu** with options to sort articles by "Recent" and "Popular"

### Instructions

1. **Display Articles**: Fetch and display a list of articles from the provided API.
2. **Sort Articles**:
    - **Default**: Articles are sorted by creation time.
    - **Recent**: Sort articles by time.
    - **Popular**: Sort articles by rank, then by time.
3. **Architecture**: Use MVVM architecture for clear, maintainable, and testable code.
4. **Modular Project**: Structure the project into separate, interdependent modules.
5. **Testing**: Include tests to ensure the code is error-free and maintainable.

### Technologies and Libraries

- **Language**: Kotlin
- **Architecture**: MVVM
- **Dependency Injection**: Dagger Hilt
- **Asynchronous Programming**: Kotlin Coroutines, Flow
- **Network**: Retrofit, OkHttp, Moshi
- **Image Loading**: Coil
- **Logging**: Timber, Chucker
- **UI Framework**: Jetpack Compose
- **Testing**: JUnit, MockK, Turbine for Flow testing, Compose UI Test

## Setup

- Clone the project
- Open the project with Android Studio
- Sync and build the project

## Linter and Static Code Analysis

- Lint:

  ```
  $ ./gradlew lint
  ```

  Report is located at: `./app/build/reports/lint/`

- Detekt:

  ```
  $ ./gradlew detekt
  ```

  Report is located at: `./build/reports/detekt`

## Run the App

- Deploy the app to an emulator or physical device.

## Acknowledgment

This project was built using the Android template provided by Nimble. I want to express my gratitude to Nimble for making such an excellent template available. It has greatly streamlined my development process and ensured the project maintains a high standard of quality. You can find credit to Nimble’s template source in my public GitHub projects.

---
