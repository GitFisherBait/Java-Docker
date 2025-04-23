package kz.sd.service

import kz.sd.feign.DriverClient
import kz.sd.model.DriverDto
import kz.sd.model.Team
import kz.sd.repository.TeamRepository
import org.springframework.stereotype.Service

@Service
class TeamService(
    private val teamRepository: TeamRepository,
    private val driverClient: DriverClient
) {

    fun updateTeam(id: Long, body: Team): Team {
        val team = teamRepository.findById(id).get()
        body.name?.let { team.name = it }
        body.country?.let { team.country = it }
        teamRepository.save(team)
        return team
    }

    fun find(id: Long): DriverDto {
        return driverClient.getDriver(id)
    }

}