package com.car.rental.mapper;

import com.car.rental.domain.RaceTrack;
import com.car.rental.domain.RaceTrackDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaceTrackMapper {

    public RaceTrack mapToRaceTrack(RaceTrackDto raceTrackDto) {
        return new RaceTrack(raceTrackDto.getId(), raceTrackDto.getTrackName(), raceTrackDto.isClosed());
    }

    public RaceTrackDto mapToRaceTrackDto(RaceTrack raceTrack) {
        return RaceTrackDto.builder()
                .id(raceTrack.getId())
                .trackName(raceTrack.getTrackName())
                .isClosed(raceTrack.isClosed())
                .build();
    }

    public List<RaceTrackDto> mapToRaceTrackDtoList(List<RaceTrack> raceTrackList) {
        return raceTrackList.stream()
                .map(this::mapToRaceTrackDto)
                .collect(Collectors.toList());
    }
}
