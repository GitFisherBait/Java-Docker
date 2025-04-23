package kz.sd.controller

import kz.sd.model.DriverDto
import kz.sd.model.Team
import kz.sd.repository.TeamRepository
import kz.sd.service.TeamService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/team")
class TeamController(
    private val teamService: TeamService,
    private val teamRepository: TeamRepository
) {

    @GetMapping
    fun getDrivers(): List<Team> {
        return teamRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getTeam(@PathVariable id: Long): Team {
        return teamRepository.findById(id).get()
    }

    @PostMapping
    fun createTeam(@RequestBody driver: Team): Team {
        return teamRepository.save(driver)
    }

    @PutMapping("/{id}")
    fun updateTeam(@PathVariable id: Long, @RequestBody body: Team): Team {
        return teamService.updateTeam(id, body)
    }

    @GetMapping("/api/{id}")
    fun getDriver(@PathVariable("id") id: Long): DriverDto {
        return teamService.find(id)
    }

}