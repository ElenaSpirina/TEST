package data;

import model.BookingDates;
import model.BookingRequest;

public class DataTest {

    public static BookingRequest defaultBooking() {
        return new BookingRequest(
                "Elene",
                "Spirina",
                500,
                true,
                new BookingDates("2026-03-01", "2026-03-10"),
                "Breakfast"
        );
    }

    public static BookingRequest updatedBooking() {
        return new BookingRequest(
                "Name",
                "Test",
                900,
                false,
                new BookingDates("2026-04-01", "2026-04-10"),
                "Lunch"
        );
    }
}