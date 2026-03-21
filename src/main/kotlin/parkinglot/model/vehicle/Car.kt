package parkinglot.model.vehicle

import parkinglot.enums.VehicleType

class Car(carNumber : String): Vehicle(carNumber, VehicleType.CAR)