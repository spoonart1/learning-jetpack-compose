package com.moladin.compose.data

class Database private constructor() {

    companion object {
        val Instance by lazy {
            Database()
        }

        private val sources by lazy {
            carPrefilled
        }
    }

    fun insert(carEntity: CarEntity) {
        //TODO: task 1 - implement insert here
        // do not perform insert when carId already exist in database (array)
    }

    fun update(carEntity: CarEntity) {
        val toUpdate = sources.find { it.carId == carEntity.carId }
        val index = sources.indexOf(toUpdate)
        toUpdate?.let {
            sources[index] = it.copy(name = carEntity.name)
        }
    }

    fun delete(carId: Int) {
        //TODO: task 2
        // remove car entity by id
    }

    fun getCarById(carId: Int) = sources.find { it.carId == carId }

    fun getCars(): List<CarEntity> = sources
}


private val carPrefilled = arrayListOf(
    CarEntity(1, "Mitsubishi Pajero Sport"),
    CarEntity(2, "Suzuki Karimun"),
    CarEntity(3, "Toyota Kijang Inova"),
    CarEntity(4, "Mitsubishi Kuda"),
    CarEntity(5, "Hyundai Ionic"),
    CarEntity(6, "EV Tesla 2.0"),
    CarEntity(7, "Suzuki Splash 2017"),
    CarEntity(8, "Honda Jazz Rs 2018"),
    CarEntity(9, "Suzuki Jimny 1993"),
    CarEntity(10, "Suzuki Jimmny 2020"),
    CarEntity(11, "Isuzu Panther"),
    CarEntity(12, "Mazda 2"),
    CarEntity(13, "Mercedes Benz"),
    CarEntity(14, "Alphard"),
    CarEntity(15, "Toyota HiAce")
)