# Low Level Design Practice in Kotlin

This repository is a Kotlin workspace for practicing low level design problems by building small, self-contained systems from scratch.

The focus here is on:

- object modeling
- interface-driven design
- composition over inheritance
- strategy-based extensibility
- in-memory repositories and service orchestration
- asynchronous flows where they make sense

## Problems Implemented

The repository currently contains these exercises under `src/main/kotlin`:

| Problem | Path | Demo Entry Point |
| --- | --- | --- |
| Autocomplete | `autocomplete` | `autocomplete/AutoCompleteMain.kt` |
| BookMyShow | `bookmyshow` | module code only |
| Cache | `cache` | module code only |
| Ecommerce | `ecommerce` | `ecommerce/ECommerceMain.kt` |
| Event Logging Library | `event_logging_library` | `event_logging_library/EventMain.kt` |
| Flight Aggregator System | `flight_aggregator_system` | `flight_aggregator_system/FlightServiceManager.kt` |
| Food Delivery System | `food_delivery_system` | `food_delivery_system/FoodDeliveryMain.kt` |
| Message Broker / Pub-Sub | `message_broker` | `message_broker/PubSubMain.kt` |
| Notification System | `notification` | `notification/NotificationMain.kt` |
| Parking Lot (legacy/simple) | `parking_lot` | module code only |
| Parking Lot (strategy-based) | `parkinglot` | `parkinglot/ParkingMain.kt`, `parkinglot/main/ParkingLotMain.kt` |
| Property Listing | `property_listing` | `property_listing/PropertyListingMain.kt` |
| Rate Limiter | `rate_limiter` | `rate_limiter/RateLimiterMain.kt` |
| Ride Hailing System | `ride_hailing_system` | `ride_hailing_system/RideHailingServiceMain.kt` |
| Splitwise | `splitwise` | `splitwise/SplitWiseMain.kt` |

## Notable Modules

### Notification System

Path: [`src/main/kotlin/notification`](src/main/kotlin/notification)

This module models a notification pipeline with:

- multiple delivery channels: `SMS`, `PUSH`, and `EMAIL`
- routing based on supported channels
- user preference filtering
- retry handling
- coroutine-based background dispatch

Key classes:

- [`NotificationManager`](src/main/kotlin/notification/NotificationManager.kt)
- [`NotificationRouter`](src/main/kotlin/notification/service/NotificationRouter.kt)
- [`RetryService`](src/main/kotlin/notification/service/RetryService.kt)

### Event Logging Library

Path: [`src/main/kotlin/event_logging_library`](src/main/kotlin/event_logging_library)

This module models a lightweight analytics/event logging SDK with:

- support for multiple analytics providers
- event, screen, and user-property logging
- fan-out dispatch to different backends
- coroutine-based async logging

Key classes:

- [`EventLogger`](src/main/kotlin/event_logging_library/EventLogger.kt)
- [`EventLoggerImpl`](src/main/kotlin/event_logging_library/service/EventLoggerImpl.kt)
- [`EventDispatcher`](src/main/kotlin/event_logging_library/service/EventDispatcher.kt)

### Ride Hailing System

Path: [`src/main/kotlin/ride_hailing_system`](src/main/kotlin/ride_hailing_system)

This module models a simple ride-booking workflow with:

- rider and driver registration
- nearest-driver matching strategy
- fare calculation strategy
- ride lifecycle management

### Property Listing

Path: [`src/main/kotlin/property_listing`](src/main/kotlin/property_listing)

This module models a property marketplace with:

- property listing by owners
- search criteria filtering
- sorting by different fields
- property status transitions

## Tech Stack

- Kotlin JVM
- Gradle Kotlin DSL
- Kotlin Coroutines

Current project configuration:

- Kotlin `1.9.24`
- Coroutines `1.8.1`
- JVM toolchain `8`

See [`build.gradle.kts`](build.gradle.kts) for the source of truth.

## Project Structure

```text
src/main/kotlin/
├── autocomplete/
├── bookmyshow/
├── cache/
├── ecommerce/
├── event_logging_library/
├── flight_aggregator_system/
├── food_delivery_system/
├── message_broker/
├── notification/
├── parking_lot/
├── parkinglot/
├── property_listing/
├── rate_limiter/
├── ride_hailing_system/
├── splitwise/
└── Main.kt
```

[`Main.kt`](src/main/kotlin/Main.kt) currently launches the ride hailing demo.

## Running the Project

Build the project:

```bash
./gradlew build
```

The project is configured with `application.mainClass = "MainKt"`, so running:

```bash
./gradlew run
```

will execute [`src/main/kotlin/Main.kt`](src/main/kotlin/Main.kt), which currently delegates to the ride hailing example.

If you want to explore specific exercises, the simplest option right now is to run the corresponding entry file from IntelliJ:

- [`src/main/kotlin/notification/NotificationMain.kt`](src/main/kotlin/notification/NotificationMain.kt)
- [`src/main/kotlin/event_logging_library/EventMain.kt`](src/main/kotlin/event_logging_library/EventMain.kt)
- [`src/main/kotlin/ride_hailing_system/RideHailingServiceMain.kt`](src/main/kotlin/ride_hailing_system/RideHailingServiceMain.kt)
- [`src/main/kotlin/property_listing/PropertyListingMain.kt`](src/main/kotlin/property_listing/PropertyListingMain.kt)
- [`src/main/kotlin/rate_limiter/RateLimiterMain.kt`](src/main/kotlin/rate_limiter/RateLimiterMain.kt)
- [`src/main/kotlin/message_broker/PubSubMain.kt`](src/main/kotlin/message_broker/PubSubMain.kt)
- [`src/main/kotlin/food_delivery_system/FoodDeliveryMain.kt`](src/main/kotlin/food_delivery_system/FoodDeliveryMain.kt)
- [`src/main/kotlin/flight_aggregator_system/FlightServiceManager.kt`](src/main/kotlin/flight_aggregator_system/FlightServiceManager.kt)
- [`src/main/kotlin/splitwise/SplitWiseMain.kt`](src/main/kotlin/splitwise/SplitWiseMain.kt)
- [`src/main/kotlin/ecommerce/ECommerceMain.kt`](src/main/kotlin/ecommerce/ECommerceMain.kt)
- [`src/main/kotlin/autocomplete/AutoCompleteMain.kt`](src/main/kotlin/autocomplete/AutoCompleteMain.kt)
- [`src/main/kotlin/parkinglot/ParkingMain.kt`](src/main/kotlin/parkinglot/ParkingMain.kt)
- [`src/main/kotlin/parkinglot/main/ParkingLotMain.kt`](src/main/kotlin/parkinglot/main/ParkingLotMain.kt)

## Why This Repo Exists

I use this project to practice:

- translating requirements into domain models
- choosing clean abstractions
- applying common design patterns in Kotlin
- structuring code for extension without tight coupling

## Gaps and Next Improvements

Some useful next steps for this repository:

- add automated tests under `src/test`
- standardize package naming such as `parking_lot` vs `parkinglot`
- make demo entry points consistent across modules
- document the main design patterns used in each exercise
- add a root index for completed vs in-progress problems
