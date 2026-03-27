# Low Level Design Practice in Kotlin

This repository is my Kotlin workspace for practicing low level design problems and building small, design-focused systems from scratch.

The goal here is not production completeness. It is to explore:

- object modeling
- interface-driven design
- composition over rigid inheritance
- strategy-based extensibility
- asynchronous workflows with coroutines

## Current Exercises

### 1. Notification System

Located under [`src/main/kotlin/notification`](/Users/abhi/Desktop/Projects/low_level_design_kotlin/src/main/kotlin/notification)

This module models a notification pipeline with:

- multiple delivery channels: `SMS`, `PUSH`, and `EMAIL`
- routing based on supported notification channels
- user preference filtering
- retry handling
- coroutine-based background dispatch

Core classes:

- [`NotificationManager`](/Users/abhi/Desktop/Projects/low_level_design_kotlin/src/main/kotlin/notification/NotificationManager.kt)
- [`NotificationRouter`](/Users/abhi/Desktop/Projects/low_level_design_kotlin/src/main/kotlin/notification/service/NotificationRouter.kt)
- [`RetryService`](/Users/abhi/Desktop/Projects/low_level_design_kotlin/src/main/kotlin/notification/service/RetryService.kt)

Design ideas practiced:

- Strategy Pattern for channel-specific notification services
- separation of orchestration, routing, and preference resolution
- fault isolation around external delivery operations

### 2. Event Logging Library

Located under [`src/main/kotlin/event_logging_library`](/Users/abhi/Desktop/Projects/low_level_design_kotlin/src/main/kotlin/event_logging_library)

This module models a lightweight analytics/event logging SDK with:

- support for multiple analytics providers
- event, screen, and user-property logging
- fan-out dispatch to different backends
- coroutine-based async logging

Core classes:

- [`EventLogger`](/Users/abhi/Desktop/Projects/low_level_design_kotlin/src/main/kotlin/event_logging_library/EventLogger.kt)
- [`EventLoggerImpl`](/Users/abhi/Desktop/Projects/low_level_design_kotlin/src/main/kotlin/event_logging_library/service/EventLoggerImpl.kt)
- [`EventDispatcher`](/Users/abhi/Desktop/Projects/low_level_design_kotlin/src/main/kotlin/event_logging_library/service/EventDispatcher.kt)

Design ideas practiced:

- abstraction over third-party providers
- interface-based extensibility
- centralized dispatch with isolated provider failures

## Tech Stack

- Kotlin JVM
- Gradle Kotlin DSL
- Kotlin Coroutines

The project is configured with:

- Kotlin `2.3.0`
- Coroutines `1.10.2`
- JVM toolchain `24`

## Project Structure

```text
src/main/kotlin/
├── event_logging_library/
├── notification/
├── cache/
└── Main.kt
```

`Main.kt` is still the default starter file and can be cleaned up later as the repo evolves.

## Running the Project

Build the project:

```bash
./gradlew build
```

If you want to explore specific exercises, the simplest option right now is to run the corresponding Kotlin entry file from IntelliJ:

- [`NotificationMain.kt`](/Users/abhi/Desktop/Projects/low_level_design_kotlin/src/main/kotlin/notification/NotificationMain.kt)
- [`EventMain.kt`](/Users/abhi/Desktop/Projects/low_level_design_kotlin/src/main/kotlin/event_logging_library/EventMain.kt)

## Why This Repo Exists

I am using this project to improve at:

- translating requirements into clean domain models
- identifying reusable abstractions
- applying common design patterns in Kotlin
- structuring code for extension without heavy coupling

## Next Improvements

Some natural next steps for this repo:

- add unit tests for each exercise
- add more LLD problems such as parking lot, rate limiter, elevator system, or splitwise
- standardize package naming and entry points
- add a dedicated `app` or demo runner setup for each exercise

