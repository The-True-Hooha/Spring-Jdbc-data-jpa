package com.TheTrueHooha.jdbc.Entity;

import com.TheTrueHooha.jdbc.Actor.Actors;
import java.time.LocalDate;
import java.util.List;

public record Movie(
        Integer id,
        String name,
        String producer,
        String studio,
        List<Actors> actors,
        LocalDate releaseDate) {

    }
