INSERT INTO movies (title, director, duration, available_tickets) VALUES ('Inception', 'Christopher Nolan', 148, 10) ON CONFLICT DO NOTHING;
INSERT INTO movies (title, director, duration, available_tickets) VALUES ('The Matrix', 'Wachowski Brothers', 136, 5) ON CONFLICT DO NOTHING;
INSERT INTO movies (title, director, duration, available_tickets) VALUES ('Interstellar', 'Christopher Nolan', 169, 3) ON CONFLICT DO NOTHING;
INSERT INTO movies (title, director, duration, available_tickets) VALUES ('The Dark Knight', 'Christopher Nolan', 152, 8) ON CONFLICT DO NOTHING;
