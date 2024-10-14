package org.example.coderun.itmo_mag.airports;

import java.util.*;

class Flight {
    String airline;
    String from;
    String to;
    int dayOfWeek; // 0-6 (Sunday-Saturday)
    int departureTime; // in minutes from midnight
    int arrivalTime; // in minutes from midnight
    double cost;
    int capacity;

    public Flight(String airline, String from, String to, int dayOfWeek, int departureTime, int arrivalTime, double cost, int capacity) {
        this.airline = airline;
        this.from = from;
        this.to = to;
        this.dayOfWeek = dayOfWeek;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.cost = cost;
        this.capacity = capacity;
    }
}

class Schedule {
    Map<String, List<Flight>> flightsByDay = new HashMap<>();

    public void addFlight(Flight flight) {
        String key = flight.from + "-" + flight.dayOfWeek;
        flightsByDay.computeIfAbsent(key, k -> new ArrayList<>()).add(flight);
    }

    public List<Flight> getFlightsFrom(String from, int dayOfWeek) {
        String key = from + "-" + dayOfWeek;
        return flightsByDay.getOrDefault(key, new ArrayList<>());
    }
}

class Booking {
    String passenger;
    Flight flight;

    public Booking(String passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }
}

class Airport {
    String name;
    Schedule schedule;
    Map<String, List<Booking>> bookings = new HashMap<>();

    public Airport(String name, Schedule schedule) {
        this.name = name;
        this.schedule = schedule;
    }

    public List<FlightSearchResult> searchFlights(String to, int dayOfWeek, int passengers) {
        List<FlightSearchResult> results = new ArrayList<>();
        for (Flight flight : schedule.getFlightsFrom(this.name, dayOfWeek)) {
            if (flight.capacity >= passengers) {
                results.add(new FlightSearchResult(Collections.singletonList(flight)));
            }
        }
        return results;
    }

    public boolean bookFlight(String passenger, Flight flight) {
        String key = flight.from + "-" + flight.to + "-" + flight.dayOfWeek;
        bookings.computeIfAbsent(key, k -> new ArrayList<>()).add(new Booking(passenger, flight));
        flight.capacity -= 1;
        return true;
    }

    public boolean cancelBooking(String passenger, Flight flight) {
        String key = flight.from + "-" + flight.to + "-" + flight.dayOfWeek;
        List<Booking> flightBookings = bookings.getOrDefault(key, new ArrayList<>());
        for (Booking booking : flightBookings) {
            if (booking.passenger.equals(passenger) && booking.flight.equals(flight)) {
                flightBookings.remove(booking);
                flight.capacity += 1;
                return true;
            }
        }
        return false;
    }
}

class FlightSearchResult implements Comparable<FlightSearchResult> {
    List<Flight> flights;
    double totalCost;

    public FlightSearchResult(List<Flight> flights) {
        this.flights = flights;
        this.totalCost = flights.stream().mapToDouble(f -> f.cost).sum();
    }

    @Override
    public int compareTo(FlightSearchResult o) {
        return Double.compare(this.totalCost, o.totalCost);
    }
}

public class FlightBookingSystem {
    Map<String, Airport> airports = new HashMap<>();

    public void addAirport(Airport airport) {
        airports.put(airport.name, airport);
    }

    public List<FlightSearchResult> searchFlights(String from, String to, int dayOfWeek, int passengers) {
        if (!airports.containsKey(from) || !airports.containsKey(to)) {
            return new ArrayList<>();
        }
        List<FlightSearchResult> directFlights = airports.get(from).searchFlights(to, dayOfWeek, passengers);
        List<FlightSearchResult> connectingFlights = searchConnectingFlights(from, to, dayOfWeek, passengers);

        List<FlightSearchResult> results = new ArrayList<>(directFlights);
        results.addAll(connectingFlights);
        results.sort(Comparator.naturalOrder());
        return results;
    }

    private List<FlightSearchResult> searchConnectingFlights(String from, String to, int dayOfWeek, int passengers) {
        List<FlightSearchResult> results = new ArrayList<>();

        for (Airport airport : airports.values()) {
            if (airport.name.equals(from) || airport.name.equals(to)) {
                continue;
            }

            List<FlightSearchResult> firstLegs = airports.get(from).searchFlights(airport.name, dayOfWeek, passengers);
            List<FlightSearchResult> secondLegs = airports.get(airport.name).searchFlights(to, dayOfWeek, passengers);

            for (FlightSearchResult firstLeg : firstLegs) {
                for (FlightSearchResult secondLeg : secondLegs) {
                    Flight lastFlightOfFirstLeg = firstLeg.flights.get(firstLeg.flights.size() - 1);
                    Flight firstFlightOfSecondLeg = secondLeg.flights.get(0);

                    if (firstFlightOfSecondLeg.departureTime >= lastFlightOfFirstLeg.arrivalTime + 60) {
                        List<Flight> combinedFlights = new ArrayList<>(firstLeg.flights);
                        combinedFlights.addAll(secondLeg.flights);
                        results.add(new FlightSearchResult(combinedFlights));
                    }
                }
            }
        }

        return results;
    }

    public boolean bookFlight(String from, String passenger, Flight flight) {
        if (!airports.containsKey(from)) {
            return false;
        }
        return airports.get(from).bookFlight(passenger, flight);
    }

    public boolean cancelBooking(String from, String passenger, Flight flight) {
        if (!airports.containsKey(from)) {
            return false;
        }
        return airports.get(from).cancelBooking(passenger, flight);
    }

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        Flight flight1 = new Flight("K1", "A", "B", 1, 480, 540, 100, 10);
        Flight flight2 = new Flight("K2", "B", "C", 1, 600, 660, 150, 10);
        Flight flight3 = new Flight("K1", "A", "C", 1, 720, 780, 200, 10);
        schedule.addFlight(flight1);
        schedule.addFlight(flight2);
        schedule.addFlight(flight3);

        Airport airportA = new Airport("A", schedule);
        Airport airportB = new Airport("B", schedule);
        Airport airportC = new Airport("C", schedule);

        FlightBookingSystem system = new FlightBookingSystem();
        system.addAirport(airportA);
        system.addAirport(airportB);
        system.addAirport(airportC);

        List<FlightSearchResult> results = system.searchFlights("A", "C", 1, 1);
        for (FlightSearchResult result : results) {
            System.out.println("Flight route:");
            for (Flight flight : result.flights) {
                System.out.println("  From " + flight.from + " to " + flight.to + " with cost " + flight.cost);
            }
            System.out.println("Total cost: " + result.totalCost);
        }

        // Example booking
        if (!results.isEmpty()) {
            system.bookFlight("A", "Passenger1", results.get(0).flights.get(0));
            // To book entire route, iterate through each flight in the result and book individually
        }

        // Example cancellation
        if (!results.isEmpty()) {
            system.cancelBooking("A", "Passenger1", results.get(0).flights.get(0));
        }
    }
}
