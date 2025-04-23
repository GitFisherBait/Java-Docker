package kz.sd.service

import kz.sd.model.Driver
import kz.sd.repository.DriverRepository
import org.springframework.stereotype.Service

@Service
class DriverService(
    private val driverRepository: DriverRepository
) {

    fun updateDriver(id: Long, body: Driver): Driver {
        val driver = driverRepository.findById(id).get()
        body.name?.let { driver.name = it }
        body.age?.let { driver.age = it }
        body.nationality?.let { driver.nationality = it }
        body.teamId?.let { driver.teamId = it }
        driverRepository.save(driver)
        return driver
    }
}