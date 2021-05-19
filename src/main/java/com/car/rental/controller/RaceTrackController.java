package com.car.rental.controller;

import com.car.rental.domain.RaceTrackDto;
import com.car.rental.facade.RaceTrackFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class RaceTrackController {

    private final RaceTrackFacade raceTrackFacade;

    @GetMapping(value = "/raceTracks")
    public List<RaceTrackDto> getAllRaceTracks() {
        return raceTrackFacade.getAllRaceTracks();
    }

    @GetMapping(value = "/raceTracks/{raceTrackId}")
    public RaceTrackDto getRaceTrack(@PathVariable Long raceTrackId) {
        return raceTrackFacade.getRaceTrackDto(raceTrackId);
    }

    @PostMapping(value = "/raceTracks")
    public Long createRaceTrack(@RequestBody RaceTrackDto raceTrackDto) {
        return raceTrackFacade.saveRaceTrack(raceTrackDto);
    }

    @PutMapping(value = "/raceTracks/{raceTrackId}")
    public Long updateRaceTrackStatus(@PathVariable Long raceTrackId, @RequestParam boolean status) {
        return raceTrackFacade.updateRaceTrackStatus(raceTrackId, status);
    }

    @DeleteMapping(value = "/raceTracks/{raceTrackId}")
    public void deleteRaceTrack(@PathVariable Long raceTrackId) {
        raceTrackFacade.deleteRaceTrack(raceTrackId);
    }
}
