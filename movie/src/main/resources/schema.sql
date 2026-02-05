CREATE TABLE IF NOT EXISTS movies (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255),
    duration INT,
    available_tickets INT
);
