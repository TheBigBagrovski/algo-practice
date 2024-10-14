CREATE TABLE Airports (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          code VARCHAR(3) NOT NULL UNIQUE
);

CREATE TABLE Airlines (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          code VARCHAR(3) NOT NULL UNIQUE
);

CREATE TABLE Flights (
                         id SERIAL PRIMARY KEY,
                         airline_id INT NOT NULL,
                         from_airport_id INT NOT NULL,
                         to_airport_id INT NOT NULL,
                         departure_time TIME NOT NULL,
                         arrival_time TIME NOT NULL,
                         capacity INT NOT NULL,
                         cost DECIMAL(10, 2) NOT NULL,
                         CONSTRAINT fk_airline FOREIGN KEY (airline_id) REFERENCES Airlines(id),
                         CONSTRAINT fk_from_airport FOREIGN KEY (from_airport_id) REFERENCES Airports(id),
                         CONSTRAINT fk_to_airport FOREIGN KEY (to_airport_id) REFERENCES Airports(id)
);

CREATE TABLE Schedules (
                           id SERIAL PRIMARY KEY,
                           flight_id INT NOT NULL,
                           day_of_week INT NOT NULL, -- 0-6 (Sunday-Saturday)
                           CONSTRAINT fk_flight FOREIGN KEY (flight_id) REFERENCES Flights(id)
);

CREATE TABLE Bookings (
                          id SERIAL PRIMARY KEY,
                          passenger_name VARCHAR(255) NOT NULL,
                          flight_id INT NOT NULL,
                          booking_time TIMESTAMP NOT NULL,
                          CONSTRAINT fk_booking_flight FOREIGN KEY (flight_id) REFERENCES Flights(id)
);