package com.practice.ticketbooking.api;

import com.practice.ticketbooking.model.Movie;
import com.practice.ticketbooking.services.MovieService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class MovieController {
    final private MovieService movieService;

    public String createMovie(@NonNull final String movieName) {
        return movieService.createMovie(movieName).getId();
    }

}
