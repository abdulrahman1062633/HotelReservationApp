package com.hotel.management.console;

import com.hotel.management.service.HotelService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CommandHandler {
    private final HotelService hotelService;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

    public CommandHandler(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter commands (blank line to exit):");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;

            if (input.startsWith("Availability")) {
                handleAvailability(input);
            } else if (input.startsWith("Search")) {
                handleSearch(input);
            } else {
                System.out.println("Invalid command");
            }
        }
        scanner.close();
    }

    private void handleAvailability(String command) {
        String[] parts = command.replace("Availability(", "").replace(")", "").split(", ");
        String hotelId = parts[0];
        String[] dateRange = parts[1].split("-");
        LocalDate startDate = LocalDate.parse(dateRange[0], DATE_FORMAT);
        LocalDate endDate = dateRange.length > 1 ? LocalDate.parse(dateRange[1], DATE_FORMAT) : startDate;
        String roomType = parts[2];

        int availability = hotelService.checkAvailability(hotelId, startDate, endDate, roomType);
        System.out.println("Availability: " + availability);
    }

    private void handleSearch(String command) {
        String[] parts = command.replace("Search(", "").replace(")", "").split(", ");
        String hotelId = parts[0];
        int daysAhead = Integer.parseInt(parts[1]);
        String roomType = parts[2];

        List<String> result = hotelService.searchAvailability(hotelId, daysAhead, roomType);
        System.out.println(String.join(", ", result));
    }
}
