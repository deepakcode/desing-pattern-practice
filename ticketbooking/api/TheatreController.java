package com.practice.ticketbooking.api;

import com.practice.ticketbooking.model.Screen;
import com.practice.ticketbooking.model.Seat;
import com.practice.ticketbooking.model.Theatre;
import com.practice.ticketbooking.services.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@AllArgsConstructor
public class TheatreController {
    final private TheatreService theatreService;

    public String createTheatre(@NonNull final String theatreName) {
        return theatreService.createTheatre(theatreName).getId();
    }

    public String createScreenInTheatre(@NonNull final String screenName, @NonNull final String theatreId) {
        final Theatre theatre = theatreService.getTheatre(theatreId);
        return theatreService.createScreenInTheatre(screenName, theatre).getId();
    }

    public String createSeatInScreen(@NonNull final Integer rowNo, @NonNull final Integer seatNo, @NonNull final String screenId) {
        final Screen screen = theatreService.getScreen(screenId);
        return theatreService.createSeatInScreen(rowNo, seatNo, screen).getId();
    }
}
